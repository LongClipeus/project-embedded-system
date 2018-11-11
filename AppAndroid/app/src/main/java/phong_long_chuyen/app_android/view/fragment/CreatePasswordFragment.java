package phong_long_chuyen.app_android.view.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.PasswordPreIm;

public class CreatePasswordFragment extends Fragment implements View.OnClickListener {

    private Context mContext = getActivity();
    private String passWd = "";
    private String text1;
    private String text2;
    private boolean checkPasswd;

    private EditText mEdNewPassword;
    private EditText mEdConfirmPassword;
    private ImageButton mIbBackSpace;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_password, container, false);

        initView(view);
        addEvent();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getFragmentManager().popBackStack();
    }

    private void initView(View view) {
        mEdNewPassword = view.findViewById(R.id.ed_password_1);
        mEdConfirmPassword = view.findViewById(R.id.ed_password_2);
        mIbBackSpace = view.findViewById(R.id.ib_back_space);
        mBtn_1 = view.findViewById(R.id.btn_1);
        mBtn_2 = view.findViewById(R.id.btn_2);
        mBtn_3 = view.findViewById(R.id.btn_3);
        mBtn_4 = view.findViewById(R.id.btn_4);
        mBtn_5 = view.findViewById(R.id.btn_5);
        mBtn_6 = view.findViewById(R.id.btn_6);
        mBtn_7 = view.findViewById(R.id.btn_7);
        mBtn_8 = view.findViewById(R.id.btn_8);
        mBtn_9 = view.findViewById(R.id.btn_9);
        mBtn_0 = view.findViewById(R.id.btn_0);
        mBtnOk = view.findViewById(R.id.btn_ok);

        mEdNewPassword.setHint(R.string.new_passwd);
        mEdConfirmPassword.setHint(R.string.confirm_passwd);

    }

    private void addEvent() {
        mIbBackSpace.setOnClickListener((View.OnClickListener) mContext);
        mBtn_1.setOnClickListener((View.OnClickListener) mContext);
        mBtn_2.setOnClickListener((View.OnClickListener) mContext);
        mBtn_3.setOnClickListener((View.OnClickListener) mContext);
        mBtn_4.setOnClickListener((View.OnClickListener) mContext);
        mBtn_5.setOnClickListener((View.OnClickListener) mContext);
        mBtn_6.setOnClickListener((View.OnClickListener) mContext);
        mBtn_7.setOnClickListener((View.OnClickListener) mContext);
        mBtn_8.setOnClickListener((View.OnClickListener) mContext);
        mBtn_9.setOnClickListener((View.OnClickListener) mContext);
        mBtn_0.setOnClickListener((View.OnClickListener) mContext);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok: {
                if (checkPasswd) {
                    text2 = mEdConfirmPassword.getText().toString();
                    if (text2.equals("")) {
                        Toast.makeText(mContext, R.string.no_password, Toast.LENGTH_SHORT).show();
                    } else {
                        if (text2.equals(text1)) {
                            PasswordPreIm passwordPreIm = new PasswordPreIm(mContext);
                            passwordPreIm.savePassword(text2);
                            // back to fragment previous
                            getFragmentManager().popBackStack();
                        } else {
                            // Invalid password
                            passWd = "";
                            mEdConfirmPassword.setText(passWd);
                            mEdNewPassword.setText(passWd);
                            checkPasswd = false;
                            Toast.makeText(mContext, R.string.invalid_password, Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                } else {
                    text1 = mEdNewPassword.getText().toString();
                    if (text1.equals("")) {
                        // there a no password
                        Toast.makeText(mContext, R.string.no_password, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, R.string.retype_password, Toast.LENGTH_SHORT).show();
                        checkPasswd = true;
                        passWd = "";
                    }
                }

                break;
            }
            case R.id.ib_back_space: {
                // delete character last
                if (!passWd.equals("")) {
                    passWd = passWd.substring(0, passWd.length() - 1);
                }
                if (checkPasswd)
                    mEdConfirmPassword.setText(passWd);
                else
                    mEdNewPassword.setText(passWd);
                break;
            }
            default: {
                passWd += ((Button) view).getText().toString();
                if (checkPasswd)
                    mEdConfirmPassword.setText(passWd);
                else
                    mEdNewPassword.setText(passWd);
            }
        }
    }
}
