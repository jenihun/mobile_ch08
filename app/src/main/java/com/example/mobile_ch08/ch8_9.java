package com.example.mobile_ch08;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class ch8_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch8_8);
        Button btnRead;
        final EditText edtRaw;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtRaw = (EditText) findViewById(R.id.edtRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    InputStream inputS = getResources().openRawResource(R.raw_test);
                    byte[] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    edtRaw.setText(new String(txt));
                    inputS.close();
                } catch (IOException e){ }
            }
        });
    }
}