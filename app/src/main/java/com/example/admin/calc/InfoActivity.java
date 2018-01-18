package com.example.admin.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView txtLoginInfo = (TextView)findViewById(R.id.txtLoginInfo);
        TextView txtPasswordInfo = (TextView)findViewById(R.id.txtPasswordInfo);
        Intent intent = getIntent();
        String login = intent.getStringExtra("edLogin");
        String password = intent.getStringExtra("edPassword");
        txtLoginInfo.setText(txtLoginInfo.getText()+" "+login);
        txtPasswordInfo.setText(txtPasswordInfo.getText()+" "+password);
    }
}
