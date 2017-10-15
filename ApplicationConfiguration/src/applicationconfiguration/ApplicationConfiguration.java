/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationconfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class ApplicationConfiguration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
           // new signup().setVisible(true);
            new login().setVisible(true);
           //new TestManualDemo().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
