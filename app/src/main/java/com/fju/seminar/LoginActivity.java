package com.fju.seminar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {

    private EditText eduserid;
    private EditText edpwd;
    private Button btnlogin;
    private TextView noaccount;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //連線
        textView = findViewById(R.id.textView5);

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

        eduserid = findViewById(R.id.ed_userId);
        edpwd = findViewById(R.id.ed_password);
        btnlogin = findViewById(R.id.login);
        noaccount = findViewById(R.id.no_account);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(LoginActivity.this)
                        .setTitle("沒有行動身份驗證的帳號？")
                        .setMessage("請搜尋http://chicken.key註冊帳號")
                        .setPositiveButton("我知道了！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("我已經有帳號了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }
        });
    }
}