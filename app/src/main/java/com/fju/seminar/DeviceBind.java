package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeviceBind extends AppCompatActivity {

    private Button bBinding;
    private TextView tvBinding;
    private Activity context=this;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_bind);
        //連線
        textView = findViewById(R.id.textView6);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(WebLogin.Classes);
            Connection connection = DriverManager.getConnection(WebLogin.url, WebLogin.username, WebLogin.password);
            textView.setText("Chicken Key － SUCCESS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            textView.setText("Chicken Key － ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            textView.setText("Chicken Key － FAILURE");
        }
        //

        bBinding = findViewById(R.id.binding);

        button = findViewById(R.id.button);

        tvBinding=(TextView)findViewById(R.id.TV_binding);
        bBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(context);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("掃描QR Code");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.setOrientationLocked(false);
                integrator.initiateScan();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeviceBind.this, Biometrics.class));
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult SR = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if(SR != null){
            if (SR.getContents() != null){
                String SC=SR.getContents();
                if (!SC.equals("")){
                    tvBinding.setText(SC.toString());
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, intent);
            tvBinding.setText("產生錯誤");
        }
    }
}
