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
import android.widget.Toast;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.PasswordPreIm;
import phong_long_chuyen.app_android.view.activity.SettingView;

import static phong_long_chuyen.app_android.config.Define.STACK_SETTING_LIST_FRAGMENT;

@SuppressLint("ValidFragment")
public class RemoveOrChangePassword extends Fragment implements View.OnClickListener {

    private Context mContext;
    private Button mBtnRemovePasswd;
    private Button mBtnChangePasswd;

    @SuppressLint("ValidFragment")
    public RemoveOrChangePassword(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_remove_or_change_passwd, container, false);
        initView(view);
        addEvent();
        return view;
    }

    private void initView(View view) {
        mBtnRemovePasswd = view.findViewById(R.id.btn_remove_password);
        mBtnChangePasswd = view.findViewById(R.id.btn_change_password);
    }

    private void addEvent() {
        mBtnRemovePasswd.setOnClickListener(this);
        mBtnChangePasswd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_remove_password) {
            PasswordPreIm passwordPreIm = new PasswordPreIm(mContext);
            if (passwordPreIm.removePassword()) {
                Toast.makeText(mContext, R.string.rm_passwd_success, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, R.string.fail_del_password, Toast.LENGTH_SHORT).show();
            }
            getFragmentManager().popBackStack(STACK_SETTING_LIST_FRAGMENT, 0);
        } else if (v.getId() == R.id.btn_change_password) {
            SettingView settingView = (SettingView) mContext;
            settingView.changePassword();

        }
    }
}
