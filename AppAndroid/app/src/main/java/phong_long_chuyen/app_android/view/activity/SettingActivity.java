package phong_long_chuyen.app_android.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.PasswordPreIm;
import phong_long_chuyen.app_android.view.fragment.ConfirmPasswordFragment;
import phong_long_chuyen.app_android.view.fragment.CreatePasswordFragment;
import phong_long_chuyen.app_android.view.fragment.SettingListFragment;

import static phong_long_chuyen.app_android.config.Define.STACK_CONFIRM_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_CREATE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_SETTING_LIST_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_CONFIRM_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_CREATE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_SETTING_LIST_FRAGMENT;

public class SettingActivity extends AppCompatActivity implements SettingView {

    private static final String TAG = SettingActivity.class.getName();

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();

    }

    private void initView() {
        mFragmentManager = this.getFragmentManager();
        fragSettingList();
    }

    private void fragSettingList() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new SettingListFragment(),
                TRAN_SETTING_LIST_FRAGMENT);
        fragmentTransaction.addToBackStack(STACK_SETTING_LIST_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void lockScreen() {
        PasswordPreIm passwordPreIm = new PasswordPreIm(this);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!passwordPreIm.isPassword()) {
            fragmentTransaction.replace(R.id.frame_setting,
                    new CreatePasswordFragment(),
                    TRAN_CREATE_PASSWORD_FRAGMENT);
            fragmentTransaction.addToBackStack(STACK_CREATE_PASSWORD_FRAGMENT);
        } else {
            fragmentTransaction.replace(R.id.frame_setting,
                    new ConfirmPasswordFragment(),
                    TRAN_CONFIRM_PASSWORD_FRAGMENT);
            fragmentTransaction.addToBackStack(STACK_CONFIRM_PASSWORD_FRAGMENT);
        }
        fragmentTransaction.commit();

    }

}
