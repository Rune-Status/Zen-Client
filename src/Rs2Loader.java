import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletStub;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Rs2Loader extends Applet implements AppletStub {

    private final Map<String, String> properties = new HashMap<String, String>() {{
        put("worldid", "1");
        put("members", "1");
        put("modewhat", "0");
        put("modewhere", "0");
        put("safemode", "0");
        put("game", "0");
        put("js", "1");
        put("lang", "0");
        put("affid", "0");
        put("lowmem", "0");
        put("settings", "kKmok3kJqOeN6D3mDdihco3oPeYN2KFy6W5--vZUbNA");
    }};

    private final JPanel panel = new JPanel() {{
        setLayout(new BorderLayout());
        add(Rs2Loader.this);
        setPreferredSize(new Dimension(765, 503));
    }};

    private final JFrame frame = new JFrame("Jagex") {{
        setLayout(new BorderLayout());
        setResizable(true);
        getContentPane().add(panel, "Center");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }};

    private final GameClient client = new GameClient();
    private final GameStub stub = new GameStub(this, 32, "runescape", 28);

    private Rs2Loader() throws Exception {
        GameClient.setAppletStub(stub);
        client.init();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Rs2Loader();
    }

    @Override
    public String getParameter(String name) {
        return properties.getOrDefault(name, "");
    }

    @Override
    public void appletResize(int width, int height) {
        super.resize(new Dimension(width, height));
    }

    @Override
    public URL getDocumentBase() {
        return getCodeBase();
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://" + Constants.ADDRESS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
