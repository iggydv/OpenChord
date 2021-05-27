package eclipse;

import com.chord.data.URL;
import com.chord.service.AsynChord;
import com.chord.service.ChordFuture;
import com.chord.service.PropertiesLoader;
import com.chord.service.ServiceException;
import com.chord.service.impl.ChordImpl;

import java.net.MalformedURLException;

public class Delete {
    public static void main(String[] args) {
        String network = args[0];
        String skey = args[1];

        PropertiesLoader.loadPropertyFile();
        String protocol = URL.KNOWN_PROTOCOLS.get(URL.SOCKET_PROTOCOL);
        URL localURL = null;

        try {
            localURL = new URL(protocol + "://localhost:8080/");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        URL bootstrapURL = null;
        try {
            bootstrapURL = new URL(protocol + "://" + network + "8080/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        AsynChord chord = new ChordImpl();
        try {
            chord.join(localURL, bootstrapURL);
        } catch (ServiceException e) {
            throw new RuntimeException(" Could not join DHT !", e);
        }

        // Remove key
        StringKey myKey = new StringKey(skey);
        ChordFuture future = chord.removeAsync(myKey, skey);

        // do other things while operation performed .
        try {
            boolean finished = future.isDone();
            while (!finished) {
                try {
                    future.waitForBeingDone();
                    finished = true;
                } catch (InterruptedException e) {
                    finished = false;
                }
            }
        } catch (ServiceException e) {
            // handle exception
            // ...
        }
    }
} 
