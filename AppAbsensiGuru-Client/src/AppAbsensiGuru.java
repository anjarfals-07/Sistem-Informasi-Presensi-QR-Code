
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import javax.swing.UIManager;
import view.AbsensiGuru;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AppAbsensiGuru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
         try {
             com.jtattoo.plaf.BaseBorders.setLogo("");
           UIManager.setLookAndFeel(new McWinLookAndFeel());
                 //"com.jtattoo.plaf.hifi.HiFiLookAndFeel " com.jtattoo.plaf.mcwin.McWinLookAndFeel
            // TODO code application logic here
        AbsensiGuru ab = new AbsensiGuru();
        ab.setVisible(true);
      } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
    
}
