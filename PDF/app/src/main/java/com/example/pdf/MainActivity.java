package com.example.pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    //private static URI URL = URI.create("ws://");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Start = (Button) findViewById(R.id.Start);
        Start.setOnClickListener(connectServer);
        //Button Restart = (Button) findViewById(R.id.Restart);
        //Restart.setOnClickListener(connectServer);
    }


    private View.OnClickListener connectServer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Step 1: get server IP, server Port, Mic, and Speaker
            EditText editIP = findViewById(R.id.editIP);
            EditText editPort = findViewById(R.id.editPort);
            RadioGroup RadioGroupMic = (RadioGroup) findViewById(R.id.RadioGroupMic);
            RadioGroup RadioGroupSpeaker = (RadioGroup) findViewById(R.id.RadioGroupSpeaker);

            // Step 2: Convert all value to string
            String IP = editIP.getText().toString();
            String Port = editIP.getText().toString();

            if(IP.length()!=0 && Port.length()!=0 && RadioGroupMic.getCheckedRadioButtonId() != -1 && RadioGroupSpeaker.getCheckedRadioButtonId() != -1){
                showStatus("Connecting...");
                /*URL = parseURL(IP, Port);
                try {
                    AcousticSensingClient acousticSensingClient = new AcousticSensingClient(URL);
                    acousticSensingClient.createConnection();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                */
            }
            if (IP.length()==0){
                showStatus("Missing Server IP");
                //Toast.makeText(getApplicationContext(), "Missing Server IP", Toast.LENGTH_SHORT).show();
            }
            if (Port.length()==0){
                showStatus("Missing Server Port");
                //Toast.makeText(getApplicationContext(), "Missing Server Port", Toast.LENGTH_SHORT).show();
            }
            if (RadioGroupMic.getCheckedRadioButtonId() == -1){
                showStatus("Please select a Microphone Source");
                //Toast.makeText(getApplicationContext(), "Please select a Microphone", Toast.LENGTH_SHORT).show();
            }
            if (RadioGroupSpeaker.getCheckedRadioButtonId() == -1){
                showStatus("Please select a Speaker");
                //Toast.makeText(getApplicationContext(), "Please select a Speaker", Toast.LENGTH_SHORT).show();
            }
        }
    };
    /*
        private URI parseURL(String ip, String port){
            return URI.create(URL + ip + ":" + port);
        }
    */
    public void showStatus(String status){
        TextView STATUS = (TextView) findViewById(R.id.STATUS);
        STATUS.setText(status);
    }
}