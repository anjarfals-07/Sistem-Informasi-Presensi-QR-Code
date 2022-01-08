/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionLogin;

/**
 *
 * @author ASUS
 */
public class UserID {
   
   private static String kd;
    private static String nama_kasir;
    
    public static String getUserLogin() {
        return kd;
    }
    public static void setUserLogin(String kd) {
        UserID.kd = kd;
    }
    
    public static String getNamaLogin() {
        return nama_kasir;
    }

    public static void setNamaLogin(String nama_kasir) {
        UserID.nama_kasir = nama_kasir;
    }
   
   
    
}
