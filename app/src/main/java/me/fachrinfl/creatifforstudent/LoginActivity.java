package me.fachrinfl.creatifforstudent;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

import me.fachrinfl.creatifforstudent.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {

    TextView tvTitle, tvSubTitle, tvDescForRegister, tvRegister;
    AppCompatEditText edtUsername, edtPassword;
    TextInputLayout tilUsername, tilPassword;
    AppCompatButton btnLogin;
    Snackbar snackbar;

    // Font
    String fontBold = "fonts/Ubuntu-Bold.ttf";
    String fontLight = "fonts/Ubuntu-Light.ttf";
    String fontRegular = "fonts/Ubuntu-Regular.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Text Title
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontBold));

        // Text Sub Title
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvSubTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontLight));

        // Form Login Username
        tilUsername = (TextInputLayout) findViewById(R.id.tilUsername);
        tilUsername.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
        tilUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (edtUsername.getText().toString().isEmpty()) {
                    tilUsername.setErrorEnabled(true);
                    tilUsername.setError("Username tidak boleh kosong");
                } else {
                    tilUsername.setErrorEnabled(false);
                }
            }
        });

        edtUsername = (AppCompatEditText) findViewById(R.id.edtUsername);
        edtUsername.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtUsername.getText().toString().isEmpty()) {
                    tilUsername.setErrorEnabled(true);
                    tilUsername.setError("Username tidak boleh kosong");
                } else {
                    tilUsername.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Form Login Password
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilPassword.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
        tilPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (edtPassword.getText().toString().isEmpty()) {
                    tilPassword.setErrorEnabled(true);
                    tilPassword.setError("Password tidak boleh kosong");
                } else {
                    tilPassword.setErrorEnabled(false);
                }
            }
        });

        edtPassword = (AppCompatEditText) findViewById(R.id.edtPassword);
        edtPassword.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edtPassword.getText().toString().isEmpty()) {
                    tilPassword.setErrorEnabled(true);
                    tilPassword.setError("Password tidak boleh kosong");
                } else {
                    tilPassword.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Button Login
        btnLogin = (AppCompatButton) findViewById(R.id.btnLogin);
        btnLogin.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        // Text Description For Register
        tvDescForRegister = (TextView) findViewById(R.id.tvDescForRegister);
        tvDescForRegister.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));

        // Text onClick Register
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontBold));
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar = Snackbar.make(v, "Let's create new account for you", Snackbar.LENGTH_SHORT);
                TextView tvForSnackbar = (TextView) (snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                tvForSnackbar.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontRegular));
                snackbar.show();
            }
        });

    }

}
