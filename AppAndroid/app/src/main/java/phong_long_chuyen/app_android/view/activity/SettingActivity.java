package phong_long_chuyen.app_android.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.view.fragment.SettingListFragment;

import static phong_long_chuyen.app_android.config.Define.SETTING_LIST_FRAGMENT;
import static phong_long_chuyen.app_android.config.Define.TAG_SETTING_LIST_FRAGMENT;

public class SettingActivity extends AppCompatActivity {

    private static final String TAG = SettingActivity.class.getName();

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private SettingListFragment mSettingListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();

    }

    private void initView() {
        mFragmentManager = this.getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mSettingListFragment = new SettingListFragment();
        replaceFrag();
    }

    private void replaceFrag() {
        mFragmentTransaction.replace(R.id.frame_setting, mSettingListFragment,
                TAG_SETTING_LIST_FRAGMENT);
        mFragmentTransaction.addToBackStack(SETTING_LIST_FRAGMENT);
        mFragmentTransaction.commit();
    }

}
