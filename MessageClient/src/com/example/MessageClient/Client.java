package com.example.MessageClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Adam on 24/07/2015.
 */
public class Client extends Activity implements View.OnClickListener {
    EditText etMessage;
    Button sButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messageclient);
        etMessage = (EditText)findViewById(R.id.etMessage);
        sButton = (Button)findViewById(R.id.sButton);
        sButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Socket s = new Socket("192.168.2.105", 7000);
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF(etMessage.getText().toString());
                    dos.flush();
                    dos.close();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
    }
}
