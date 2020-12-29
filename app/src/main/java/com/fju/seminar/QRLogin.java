package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class QRLogin extends AppCompatActivity {

    private static final String TAG = "QrLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_login);

        Uri uri = Uri.parse("https://github.com/g8babe");

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}