package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class WebLogin extends AppCompatActivity {

    private Button bQRCode;
    private Button bVFCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_login);

        bQRCode = findViewById(R.id.qrcode);
        bVFCode = findViewById(R.id.verification_code);
    }
}
