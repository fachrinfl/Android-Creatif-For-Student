package me.fachrinfl.creatifforstudent;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    LinearLayout rlLogin;
    TextView tvTitle, tvSubTitle, tvDescForRegister, tvRegister;
    AppCompatEditText edtUsername, edtPassword;
    TextInputLayout tilUsername, tilPassword;
    AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Font
        String fontTitle = "fonts/Ubuntu-Bold.ttf";
        String fontSubTitle = "fonts/Ubuntu-Light.ttf";
        String fontForm = "fonts/Ubuntu-Regular.ttf";

        // Main Layout
        rlLogin = (LinearLayout) findViewById(R.id.rlLogin);
        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        // Text Title
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontTitle));

        // Text Sub Title
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvSubTitle.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontSubTitle));

        // Form Login
        tilUsername = (TextInputLayout) findViewById(R.id.tilUsername);
        tilUsername.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));
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

        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilPassword.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));
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

        edtUsername = (AppCompatEditText) findViewById(R.id.edtUsername);
        edtUsername.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));
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

        edtPassword = (AppCompatEditText) findViewById(R.id.edtPassword);
        edtPassword.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));
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
        btnLogin.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));

        // Text Description For Register
        tvDescForRegister = (TextView) findViewById(R.id.tvDescForRegister);
        tvDescForRegister.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontForm));

        // Text onClick Register
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setTypeface(Typeface.createFromAsset(getBaseContext().getAssets(), fontTitle));


    }
}
