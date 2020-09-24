package com.natlusrun.sharedpreferencesauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    TextView userNameInfo, userPassInfo;
    Button logOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userNameInfo = findViewById(R.id.user_info_tv);
        userPassInfo = findViewById(R.id.user_pass_tv);
        logOut = findViewById(R.id.log_out_btn);
        userNameInfo.setText(PreferenceUtils.getUserName());
        userPassInfo.setText(PreferenceUtils.getUserPass());

        logOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PreferenceUtils.clearUserInfo();
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }

}
