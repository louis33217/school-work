package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.MatchingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.MatchingRole.MatchingJPanel;

/**
 *
 * @author david
 */
public class MatchingRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MatchingJPanel(userProcessContainer, account, (MatchingOrganization)organization, enterprise);
    }
    
}