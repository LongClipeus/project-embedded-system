package phong_long_chuyen.app_android.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.view.activity.SettingView;

@SuppressLint("ValidFragment")
public class SignInFragment extends Fragment implements View.OnClickListener {

    private Context mContext;

    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private TextView mTvNewUser;

    @SuppressLint("ValidFragment")
    public SignInFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        initView(view);
        addEvent();

        return view;
    }

    private void initView(View view) {
        mEtEmail = view.findViewById(R.id.et_email);
        mEtPassword = view.findViewById(R.id.et_passwd);
        mBtnLogin = view.findViewById(R.id.btn_login);
        mTvNewUser = view.findViewById(R.id.tv_create_new_user);
    }

    private void addEvent() {
        mBtnLogin.setOnClickListener(this);
        mTvNewUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
                String email = mEtEmail.getText().toString();
                String password = mEtPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(mContext, R.string.no_email_password, Toast.LENGTH_SHORT).show();
                } else {
                    // kiem tra dang nhap
                    boolean thanhcong = true;
                    if (thanhcong) {
                        Intent intent = getActivity().getIntent();
                        Log.d("SignInFragment", "intent: " + intent);
                        getActivity().finish();
                    }
                }
                break;
            }
            case R.id.tv_create_new_user: {
                SettingView settingView = (SettingView) mContext;
                settingView.signUp();
                break;
            }
        }
    }
}
