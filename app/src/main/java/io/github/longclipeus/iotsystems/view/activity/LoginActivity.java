package io.github.longclipeus.iotsystems.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import io.github.longclipeus.iotsystems.R;
import io.github.longclipeus.iotsystems.presenter.PasswordPreIm;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String mPassWord = "";

    private PasswordPreIm mPasswordPreIm;

    private EditText mEdPassword;
    private Button mBtn_1;
    private Button mBtn_2;
    private Button mBtn_3;
    private Button mBtn_4;
    private Button mBtn_5;
    private Button mBtn_6;
    private Button mBtn_7;
    private Button mBtn_8;
    private Button mBtn_9;
    private Button mBtn_0;
    private Button mBtnOk;
    private ImageButton mIbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPasswordPreIm = new PasswordPreIm(this);

        if (!mPasswordPreIm.isPassword()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);

        initView();
        addEvent();
    }

    private void initView() {

        mBtn_1 = findViewById(R.id.btn_1);
        mBtn_2 = findViewById(R.id.btn_2);
        mBtn_3 = findViewById(R.id.btn_3);
        mBtn_4 = findViewById(R.id.btn_4);
        mBtn_5 = findViewById(R.id.btn_5);
        mBtn_6 = findViewById(R.id.btn_6);
        mBtn_7 = findViewById(R.id.btn_7);
        mBtn_8 = findViewById(R.id.btn_8);
        mBtn_9 = findViewById(R.id.btn_9);
        mBtn_0 = findViewById(R.id.btn_0);
        mBtnOk = findViewById(R.id.btn_ok);
        mIbBack = findViewById(R.id.ib_back);
        mEdPassword = findViewById(R.id.ed_password_2);

        mEdPassword.setHint(R.string.enter_password);
    }

    private void addEvent() {
        mBtn_1.setOnClickListener(LoginActivity.this);
        mBtn_2.setOnClickListener(LoginActivity.this);
        mBtn_3.setOnClickListener(LoginActivity.this);
        mBtn_4.setOnClickListener(LoginActivity.this);
        mBtn_5.setOnClickListener(LoginActivity.this);
        mBtn_6.setOnClickListener(LoginActivity.this);
        mBtn_7.setOnClickListener(LoginActivity.this);
        mBtn_8.setOnClickListener(LoginActivity.this);
        mBtn_9.setOnClickListener(LoginActivity.this);
        mBtn_0.setOnClickListener(LoginActivity.this);
        mBtnOk.setOnClickListener(LoginActivity.this);
        mIbBack.setOnClickListener(LoginActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok: {
                if (mPasswordPreIm.checkPass(mPassWord)) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    mPassWord = "";
                    mEdPassword.setText(mPassWord);
                    Toast.makeText(LoginActivity.this,
                            R.string.fail_login,
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.ib_back: {
                if (!mPassWord.equals("")) {
                    mPassWord = mPassWord.substring(0, mPassWord.length() - 1);
                    mEdPassword.setText(mPassWord);
                }
                break;
            }
            default: {
                mPassWord += ((Button) view).getText().toString();
                mEdPassword.setText(mPassWord);
            }
        }
    }
}
