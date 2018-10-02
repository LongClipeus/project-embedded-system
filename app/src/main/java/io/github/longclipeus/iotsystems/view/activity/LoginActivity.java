package io.github.longclipeus.iotsystems.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.longclipeus.iotsystems.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUser;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        addEvent();
    }

    private void addEvent() {
        mLogin.setOnClickListener(this);
    }

    private void initView() {
        mUser = findViewById(R.id.et_user);
        mPassword = findViewById(R.id.et_password);
        mLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View v) {
        // xac thuc nguoi dung
    }
}
