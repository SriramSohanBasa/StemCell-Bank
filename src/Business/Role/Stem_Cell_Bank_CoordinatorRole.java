/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Stem_Cell_Bank_Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.Bone_Marrow_Bank_CoordinatorRole.StemCellBankCoordinatorWorkAreaJPanel;
//import userinterface.Stem_Cell_Bank_CoordinatorRole.StemCellBankCoordinatorWorkAreaJPanel;
/**
 *
 * @author HP
 */
public class Stem_Cell_Bank_CoordinatorRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new StemCellBankCoordinatorWorkAreaJPanel(account, (Stem_Cell_Bank_Organization)organization, enterprise, business, network);
    }
}
