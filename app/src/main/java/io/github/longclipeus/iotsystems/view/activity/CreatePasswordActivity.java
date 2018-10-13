package io.github.longclipeus.iotsystems.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import io.github.longclipeus.iotsystems.R;

public class CreatePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private String passWd = "", text1, text2;
    private boolean checkPasswd;

    private EditText mEdCreatePass;
    private EditText mEdConfirmPass;
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
    private ImageButton mIbBack;
    private Button mBtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        addEvent();
    }

    private void initView() {
        mEdCreatePass = findViewById(R.id.ed_password_1);
        mEdConfirmPass = findViewById(R.id.ed_password_2);
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

        mEdCreatePass.setHint(R.string.create_password);
        mEdConfirmPass.setHint(R.string.confirm_password);
    }

    private void addEvent() {
        mBtn_1.setOnClickListener(CreatePasswordActivity.this);
        mBtn_2.setOnClickListener(CreatePasswordActivity.this);
        mBtn_3.setOnClickListener(CreatePasswordActivity.this);
        mBtn_4.setOnClickListener(CreatePasswordActivity.this);
        mBtn_5.setOnClickListener(CreatePasswordActivity.this);
        mBtn_6.setOnClickListener(CreatePasswordActivity.this);
        mBtn_7.setOnClickListener(CreatePasswordActivity.this);
        mBtn_8.setOnClickListener(CreatePasswordActivity.this);
        mBtn_9.setOnClickListener(CreatePasswordActivity.this);
        mBtn_0.setOnClickListener(CreatePasswordActivity.this);
        mBtnOk.setOnClickListener(CreatePasswordActivity.this);
        mIbBack.setOnClickListener(CreatePasswordActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok : {
                if (checkPasswd) {
                    text2 = mEdConfirmPass.getText().toString();
                    if (text2.equals("")) {
                        Toast.makeText(CreatePasswordActivity.this,
                                R.string.no_password,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        if (text2.equals(text1)) {
                            // save and move to MenuActivity

                            SharedPreferences settings = getSharedPreferences("preferences",
                                    Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = settings.edit();

                            // edit and commit
                            editor.putString("Password", text2);
                            editor.apply();

                            startActivity(new Intent(CreatePasswordActivity.this,
                                    MainActivity.class));
                            finish();
                        } else {
                            // Invalid password
                            passWd = "";
                            mEdConfirmPass.setText(passWd);
                            mEdCreatePass.setText(passWd);
                            checkPasswd = false;
                            Toast.makeText(CreatePasswordActivity.this,
                                    R.string.invalid_password,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    text1 = mEdCreatePass.getText().toString();
                    if (text1.equals("")) {
                        // there a no password
                        Toast.makeText(CreatePasswordActivity.this,
                                R.string.no_password,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CreatePasswordActivity.this,
                                R.string.retype_password,
                                Toast.LENGTH_SHORT).show();
                        checkPasswd = true;
                        passWd = "";
                    }
                }

                break;
            }
            case R.id.ib_back : {
                // delete character last
                if (!passWd.equals("")) {
                    passWd = passWd.substring(0, passWd.length() - 1);
                }
                if (checkPasswd)
                    mEdConfirmPass.setText(passWd);
                else
                    mEdCreatePass.setText(passWd);
                break;
            }
            default: {
                passWd += ((Button)view).getText().toString();
                if (checkPasswd)
                    mEdConfirmPass.setText(passWd);
                else
                    mEdCreatePass.setText(passWd);
            }
        }
    }
}
