package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private static String ip = "10.211.55.4";
    private static String port = "4321";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "Seminar";
    private static String username = "sa";
    private static String password = "0000";
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;

    private Connection connection = null;
    private Button bDVmanage;
    private Button bLoginAct;
    private Button bWebLogin;
    private Button bSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        textView = findViewById(R.id.textView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
            textView.setText("Chicken Key － SUCCESS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            textView.setText("Chicken Key － ERROR");
        } catch (SQLException e) {
            e.printStackTrace();
            textView.setText("Chicken Key － FAILURE");
        }

//
        bDVmanage = findViewById(R.id.device_manage);
        bLoginAct = findViewById(R.id.login_activity);
        bWebLogin = findViewById(R.id.web_login);
        bSettings = findViewById(R.id.settings);
    }

    public void device(View view){

    }
}
