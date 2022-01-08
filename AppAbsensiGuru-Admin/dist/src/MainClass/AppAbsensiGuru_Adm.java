/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass;



import Splash.SplashScreen;
import javax.swing.ImageIcon;

import javax.swing.UIManager;

import view.Login;

/**
 *
 * @author ASUS
 */
public class AppAbsensiGuru_Adm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
    
       try {
           
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                   
                 //"com.jtattoo.plaf.hifi.HiFiLookAndFeel " com.jtattoo.plaf.mcwin.McWinLookAndFeel
      
      } catch (Exception ex) {
            ex.printStackTrace();
        }
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
        try {
        
            for (int i = 0; i <= 100; i++) {
                 Thread.sleep(30);
                SplashScreen.jLabel1.setText(""+i);
                SplashScreen.jProgressBar1.setValue(i);
                if (i==100) {
                   Login lo= new Login();
                   splash.setVisible(false);
                   lo.setVisible(true);
                   lo.show();         
                } 
           }
        } catch (Exception e) {
        }
        
    }
    
    
}

