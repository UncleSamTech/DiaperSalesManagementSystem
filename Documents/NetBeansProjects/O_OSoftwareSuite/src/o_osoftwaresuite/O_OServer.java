/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package o_osoftwaresuite;

/**
 *
 * @author SAMUEL
 */
public class O_OServer {
    public static O_OAuthenticate o_OAuthenticate;
    public static O_OSplash o_OSplash;
    public static O_OStaffZone o_OStaffZone;
    public static O_OManagerZone o_OManagerZone;
public static O_OSalesPanel os;
    public static O_OAuthenticate getO_OAuthenticate() {
        
        if(o_OAuthenticate==null){
        o_OAuthenticate = new O_OAuthenticate();}
        return o_OAuthenticate;
    }

    public static O_OSalesPanel getOs() {
        if(os==null){
        os = new O_OSalesPanel();
        }
        return os;
    }

    public static O_OManagerZone getO_OManagerZone() {
        if(o_OManagerZone==null){
        o_OManagerZone = new O_OManagerZone();}
        return o_OManagerZone;
    }

    public static O_OSplash getO_OSplash() {
        if(o_OSplash ==null){
        o_OSplash = new O_OSplash();}
        return o_OSplash;
    }

    public static O_OStaffZone getO_OStaffZone() {
        if(o_OStaffZone == null){
        o_OStaffZone = new O_OStaffZone();}
        return o_OStaffZone;
    }
    
}
