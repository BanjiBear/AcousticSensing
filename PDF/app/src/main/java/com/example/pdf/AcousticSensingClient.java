package com.example.pdf;

import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;



public class AcousticSensingClient extends WebSocketClient{
    static String URL;
    TextView STATUS = null;

    public AcousticSensingClient(String URL) throws URISyntaxException {
        super(new URI(URL));
        this.URL = URL;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        STATUS.findViewById(R.id.STATUS);
        STATUS.setText("Opened");
    }

    @Override
    public void onMessage(String message) {
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        STATUS.findViewById(R.id.STATUS);
        STATUS.setText("Closed");
    }

    @Override
    public void onError(Exception ex) {
        STATUS.findViewById(R.id.STATUS);
        STATUS.setText("Error: " + ex);
    }

    public static void createConnection() throws URISyntaxException {
        AcousticSensingClient acousticSensingClient = new AcousticSensingClient(URL); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        acousticSensingClient.connect();
        TextView STATUS = null;
        STATUS.findViewById(R.id.STATUS);
        STATUS.setText("Connected. Ready to sense.");
    }
}
