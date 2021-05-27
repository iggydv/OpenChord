package eclipse;

import com.chord.data.URL;
import com.chord.service.Chord;
import com.chord.service.PropertiesLoader;
import com.chord.service.ServiceException;
import com.chord.service.impl.ChordImpl;

import java.net.MalformedURLException;

public class Join {
    public static void main(String[] args) {
        PropertiesLoader.loadPropertyFile();
        String protocol = URL.KNOWN_PROTOCOLS.get(URL.SOCKET_PROTOCOL);
        URL localURL = null;

        try {
            localURL = new URL(protocol + "://localhost:8081/");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        URL bootstrapURL = null;
        try {
            if (args.length == 0) {
                bootstrapURL = new URL(protocol + "://localhost:8080/");
            } else {
                bootstrapURL = new URL(protocol + "://" + args[0] + ":8080/");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Chord chord = new ChordImpl();

        try {
            chord.join(localURL, bootstrapURL);
            System.out.println("Joined to OpenChord Network");
        } catch (ServiceException e) {
            throw new RuntimeException(" Could not join DHT !", e);
        }
    }
}
