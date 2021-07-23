package com.yeoul.dashboardexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView logo_imageview;
    Button loginBtn;
    TextView signUp_textview, forgotPassword_textview, logoName_textview, logoName_textview2;
    TextInputLayout username_editText, password_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        /* --- Hooks --- */
        logo_imageview = findViewById(R.id.Login_image);
        logoName_textview = findViewById(R.id.Login_logoName);
        logoName_textview2 = findViewById(R.id.Login_LogoName2);
        username_editText = findViewById(R.id.login_username);
        password_editText = findViewById(R.id.login_password);
        signUp_textview = findViewById(R.id.login_signIn_textView);
        forgotPassword_textview = findViewById(R.id.login_forgotPassword_textView);
        loginBtn = findViewById(R.id.login_button);

        /* --- onClick Listener --- */
        signUp_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);

                /* --- Shared View animation setting --- */
                Pair<View, String>[] pairs = new Pair[6];
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    pairs[0] = new Pair(logo_imageview, logo_imageview.getTransitionName());
                    pairs[1] = new Pair(logoName_textview, logoName_textview.getTransitionName());
                    pairs[2] = new Pair(logoName_textview2, logoName_textview2.getTransitionName());
                    pairs[3] = new Pair(username_editText, username_editText.getTransitionName());
                    pairs[4] = new Pair(password_editText, password_editText.getTransitionName());
                    pairs[5] = new Pair(loginBtn, loginBtn.getTransitionName());

                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }
                else  {
                    startActivity(intent);
                }
            }
        });
    }
}