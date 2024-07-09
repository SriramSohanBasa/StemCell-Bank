


import Business.Employee.Employee;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for managing the schedules of employees.
 */
public class EmployeeScheduleDirectory {
    private Map<Employee, String> employeeScheduleMap;

    public EmployeeScheduleDirectory() {
        employeeScheduleMap = new HashMap<>();
    }

    public Map<Employee, String> getEmployeeScheduleMap() {
        return employeeScheduleMap;
    }
    
    public void addEmployeeSchedule(Employee employee, String scheduleDetails){
        // Here, 'scheduleDetails' could represent a shift time, a work assignment, etc.
        employeeScheduleMap.put(employee, scheduleDetails);
    }

    public String getScheduleForEmployee(Employee employee) {
        return employeeScheduleMap.get(employee);
    }

    // Method to remove a schedule for an employee
    public void removeEmployeeSchedule(Employee employee) {
        employeeScheduleMap.remove(employee);
    }
}
