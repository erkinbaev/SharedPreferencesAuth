package com.natlusrun.sharedpreferencesauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName, userPass;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        userName = findViewById(R.id.user_name_et);
        userPass = findViewById(R.id.user_password_et);
        logIn = findViewById(R.id.log_in_btn);
        logIn.setOnClickListener(this);

        if (!PreferenceUtils.getUserName().isEmpty() && !PreferenceUtils.getUserPass().isEmpty()) {
            startActivity(new Intent(this, UserInfoActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(userName.getText().toString()) || TextUtils.isEmpty(userPass.getText().toString())) {
            Toast.makeText(this, "You entered incorrect data", Toast.LENGTH_SHORT).show();
        } else {
            PreferenceUtils.saveUserName(userName.getText().toString());
            PreferenceUtils.saveUserPass(userPass.getText().toString());
            Intent intent = new Intent(this, UserInfoActivity.class);
            startActivity(intent);
        }
    }
}