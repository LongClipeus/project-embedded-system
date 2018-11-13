package phong_long_chuyen.app_android.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.PasswordPreIm;
import phong_long_chuyen.app_android.view.fragment.ConfirmPasswordFragment;
import phong_long_chuyen.app_android.view.fragment.CreatePasswordFragment;
import phong_long_chuyen.app_android.view.fragment.DetailAccountFragment;
import phong_long_chuyen.app_android.view.fragment.RemoveOrChangePassword;
import phong_long_chuyen.app_android.view.fragment.SettingListFragment;
import phong_long_chuyen.app_android.view.fragment.SignInFragment;
import phong_long_chuyen.app_android.view.fragment.SignUpFragment;

import static phong_long_chuyen.app_android.config.Define.STACK_CHANGE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_CONFIRM_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_CREATE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_DETAIL_ACCOUNT;
import static phong_long_chuyen.app_android.config.Define.STACK_REMOVE_OR_CHANGE_PASSWORD;
import static phong_long_chuyen.app_android.config.Define.STACK_SETTING_LIST_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.STACK_SIGN_IN;
import static phong_long_chuyen.app_android.config.Define.STACK_SIGN_UP;
import static phong_long_chuyen.app_android.config.Define.TRAN_CHANGE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_CONFIRM_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_CREATE_PASSWORD_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_DETAIL_ACCOUNT;
import static phong_long_chuyen.app_android.config.Define.TRAN_REMOVE_OR_CHANGE_PASSWORD;
import static phong_long_chuyen.app_android.config.Define.TRAN_SETTING_LIST_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TRAN_SIGN_IN;
import static phong_long_chuyen.app_android.config.Define.TRAN_SIGN_UP;

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
        fragmentTransaction.replace(R.id.frame_setting, new SettingListFragment(this),
                TRAN_SETTING_LIST_FRAGMENT);
        fragmentTransaction.addToBackStack(STACK_SETTING_LIST_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void lockScreen() {
        PasswordPreIm passwordPreIm = new PasswordPreIm(this);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!passwordPreIm.isPassword()) {
            fragmentTransaction.replace(R.id.frame_setting, new CreatePasswordFragment(this),
                    TRAN_CREATE_PASSWORD_FRAGMENT);
            fragmentTransaction.addToBackStack(STACK_CREATE_PASSWORD_FRAGMENT);
        } else {
            fragmentTransaction.replace(R.id.frame_setting, new ConfirmPasswordFragment(this),
                    TRAN_CONFIRM_PASSWORD_FRAGMENT);
            fragmentTransaction.addToBackStack(STACK_CONFIRM_PASSWORD_FRAGMENT);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void removeOrChangePasswd() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new RemoveOrChangePassword(this),
                TRAN_REMOVE_OR_CHANGE_PASSWORD);
        fragmentTransaction.addToBackStack(STACK_REMOVE_OR_CHANGE_PASSWORD);
        fragmentTransaction.commit();
    }

    @Override
    public void changePassword() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new CreatePasswordFragment(this),
                TRAN_CHANGE_PASSWORD_FRAGMENT);
        fragmentTransaction.addToBackStack(STACK_CHANGE_PASSWORD_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void signIn() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new SignInFragment(this),
                TRAN_SIGN_IN);
        fragmentTransaction.addToBackStack(STACK_SIGN_IN);
        fragmentTransaction.commit();
    }

    @Override
    public void signUp() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new SignUpFragment(this),
                TRAN_SIGN_UP);
        fragmentTransaction.addToBackStack(STACK_SIGN_UP);
        fragmentTransaction.commit();
    }

    @Override
    public void detailAccount() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_setting, new DetailAccountFragment(this),
                TRAN_DETAIL_ACCOUNT);
        fragmentTransaction.addToBackStack(STACK_DETAIL_ACCOUNT);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            finish();
        }
    }
}
