package com.example.pdf;

import android.widget.TextView;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;



public class AcousticSensingClient extends WebSocketClient{
    static URI URL;

    public AcousticSensingClient(URI URL) throws URISyntaxException {
        super(URL);
        this.URL = URL;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
    }

    @Override
    public void onMessage(String message) {
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
    }

    @Override
    public void onError(Exception ex) {
        TextView STATUS = null ;
        STATUS.findViewById(R.id.STATUS);
        STATUS.setText("Error: " + ex);
    }

    public static void createConnection() throws URISyntaxException {
        AcousticSensingClient acousticSensingClient = new AcousticSensingClient(URL); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        acousticSensingClient.connect();
    }
}
