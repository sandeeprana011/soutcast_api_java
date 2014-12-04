/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sirfireydevs.rana;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sandeep
 */
public class SOUTcast_URLs {
    private URL stationURL;

    /**
     * 
     * @return the stationURL
     */
    public URL getStationURL(String stationID) {
        try {
            stationURL=new URL("http://yp.shoutcast.com/sbin/tunein-station.pls?id="+stationID);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SOUTcast_URLs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stationURL;
    }
    
    
}
