package com.example.mobile_ch08;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

public class ch8_15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch8_14);

        Button btnFilelist;
        final EditText editFilelist;
        btnFilelist = (Button) findViewById(R.id.btnFilelist);
        editFilelist = (EditText) findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;
                for(int i = 0; i < sysFiles.length; i++){
                    if(sysFiles[i].isDirectory() == true)
                        strFname = "<폴더>" + sysFiles[i].toString();
                    else
                        strFname = "<파일>" + sysFiles[i].toString();

                    editFilelist.setText(editFilelist.getText() + "\n" + strFname);
                }
            }
        });
    }
}