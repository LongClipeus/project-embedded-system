package phong_long_chuyen.app_android.view.fragment;

import android.annotation.SuppressLint;
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
import phong_long_chuyen.app_android.view.activity.SettingView;

@SuppressLint("ValidFragment")
public class ConfirmPasswordFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private String passWd = "";

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

    @SuppressLint("ValidFragment")
    public ConfirmPasswordFragment(Context context) {
        this.mContext = context;
    }

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

    private void initView(View view) {
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
        mEdConfirmPassword.setHint(R.string.confirm_passwd);
    }

    private void addEvent() {
        mIbBackSpace.setOnClickListener(this);
        mBtn_1.setOnClickListener(this);
        mBtn_2.setOnClickListener(this);
        mBtn_3.setOnClickListener(this);
        mBtn_4.setOnClickListener(this);
        mBtn_5.setOnClickListener(this);
        mBtn_6.setOnClickListener(this);
        mBtn_7.setOnClickListener(this);
        mBtn_8.setOnClickListener(this);
        mBtn_9.setOnClickListener(this);
        mBtn_0.setOnClickListener(this);
        mBtnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok: {
                PasswordPreIm passwordPreIm = new PasswordPreIm(mContext);
                if (passwordPreIm.checkPass(passWd)) {
                    SettingView settingView = (SettingView) mContext;
                    settingView.removeOrChangePasswd();
                } else {
                    Toast.makeText(mContext, R.string.incorrect_password, Toast.LENGTH_SHORT).show();
                    passWd = "";
                }
                break;
            }
            case R.id.ib_back_space: {
                if (!passWd.equals("")) {
                    passWd = passWd.substring(0, passWd.length() - 1);
                }
                break;
            }
            default: {
                passWd += ((Button) view).getText().toString();
            }
        }
        mEdConfirmPassword.setText(passWd);
    }

}
