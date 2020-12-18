package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class DeviceBind extends AppCompatActivity {

    private Button bBinding;
    private TextView TV;
    private Activity context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_bind);

        bBinding = findViewById(R.id.binding);

        TV=(TextView)findViewById(R.id.TV);
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

//        getPermissionsCamera();
    }

//    public void getPermissionsCamera(){
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
//        }
//    }

//    public void Binding (View view){
//
//
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult SR = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if(SR != null){
            if (SR.getContents() != null){
                String SC=SR.getContents();
                if (!SC.equals("")){
                    TV.setText(SC.toString());
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, intent);
            TV.setText("產生錯誤");
        }
    }
}
