package eclipse;

import de.uniba.wiai.lspi.chord.service.Chord;
import de.uniba.wiai.lspi.chord.service.PropertiesLoader;
import de.uniba.wiai.lspi.chord.service.impl.ChordImpl;
import de.uniba.wiai.lspi.chord.service.ServiceException;
import de.uniba.wiai.lspi.chord.data.URL;

import java.net.MalformedURLException;

public class Insert {
  public static void main (String[] args) {
    PropertiesLoader.loadPropertyFile();
    String protocol = URL.KNOWN_PROTOCOLS.get(URL.SOCKET_PROTOCOL);
    URL localURL = null;

    try {
      localURL = new URL(protocol + "://localhost:8081/");

    } catch (MalformedURLException e ) {
      throw new RuntimeException(e);
    }

    URL bootstrapURL = null;
    try {
      bootstrapURL = new URL (protocol + "://localhost:8080/");
    } catch (MalformedURLException e) {
      throw new RuntimeException (e) ;
    }
    Chord chord = new ChordImpl();
    try {
      chord.join (localURL, bootstrapURL) ;
    } catch (ServiceException e) {
      throw new RuntimeException (" Could not join DHT !", e ) ;
    }

    //Insert data
    String data = args[0];
    StringKey myKey = new StringKey (args[1]) ;
    try {
      chord.insert (myKey , data) ;
    } catch (ServiceException e) {
      System.err.println ("insertion failed");
    }
  }
} 
