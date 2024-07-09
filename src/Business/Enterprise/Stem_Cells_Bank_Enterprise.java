/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Stem_Cells_Bank_Enterprise extends Enterprise {
    public Stem_Cells_Bank_Enterprise(String name){
        super(name,EnterpriseType.StemCellBank);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
