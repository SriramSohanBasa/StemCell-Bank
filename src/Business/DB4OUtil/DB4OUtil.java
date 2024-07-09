package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.io.File;
import java.nio.file.Paths;

/**
 * This class handles the database operations for the EcoSystem.
 * It uses db4o to persist the system state to a file.
 */
public class DB4OUtil {
    // Path to the datastore file.
    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();
    private static DB4OUtil dB4OUtil;
    
    // Singleton pattern to ensure only one instance of DB4OUtil is created.
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    // Closes the database connection. To be called when the system is shut down.
    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    // Creates a connection to the database, configuring it as necessary.
    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            // Configure the activation depth to the maximum value to ensure full object graph is retrieved.
            config.common().activationDepth(Integer.MAX_VALUE);
            // Configure the update depth to the maximum value to ensure full object graph is persisted.
            config.common().updateDepth(Integer.MAX_VALUE);

            // Register the EcoSystem class so that updates cascade.
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            // Open the file at the specified path as the database.
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    // Stores the current state of the system to the database.
    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        // Delete the old file and create a new one for every save operation.
        File f = new File(FILENAME);
        try {
            f.delete();
            f.createNewFile();
        } catch (Exception e) {
            // Proper exception handling would go here.
        }
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    // Retrieves the system state from the database. If none exists, creates a new system configuration.
    public EcoSystem retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class);
        EcoSystem system;
        if (systems.size() == 0) {
            system = ConfigureASystem.configure(); // If there's no system, configure a new one.
            System.out.println("size==0");
        } else {
            system = systems.get(systems.size() - 1);
            System.out.println("size not 0");
        }
        conn.close();
        return system;
    }

    // New function to update a given object in the database.
    public synchronized void updateObject(Object obj) {
        ObjectContainer conn = createConnection();
        conn.store(obj);
        conn.commit();
        conn.close();
    }

    // New function to delete a given object from the database.
    public synchronized void deleteObject(Object obj) {
        ObjectContainer conn = createConnection();
        conn.delete(obj);
        conn.commit();
        conn.close();
    }

    // New function to retrieve all objects of a certain type.
    public synchronized <T> ObjectSet<T> getAllObjects(Class<T> type) {
        ObjectContainer conn = createConnection();
        ObjectSet<T> result = conn.query(type);
        conn.close();
        return result;
    }
}
