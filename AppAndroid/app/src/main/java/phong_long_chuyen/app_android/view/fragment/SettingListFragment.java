package phong_long_chuyen.app_android.view.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.adapter.SettingListAdapter;
import phong_long_chuyen.app_android.model.entity.SettingEntity;
import phong_long_chuyen.app_android.view.activity.SettingView;

public class SettingListFragment extends Fragment {

    private RecyclerView mRvSettingList;
    private List<SettingEntity> mSettingList;
    private Context mContext;
    private View mView;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_setting_list, container, false);

        initView();
        setValueItemSetting();
        setLayoutSettings();

        return mView;
    }

    private void initView() {

        Log.d("test", "settinglist fragment: " + mContext);
        mRvSettingList = mView.findViewById(R.id.rv_setting_list);
        mContext = getActivity();
        mSettingList = new ArrayList<>();

        mFragmentManager = this.getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
    }

    private void setValueItemSetting() {
        mSettingList.add(new SettingEntity(R.drawable.ic_screen_lock_portrait, R.string.lock_screen));
        mSettingList.add(new SettingEntity(R.drawable.ic_screen_lock_portrait, R.string._0));
        mSettingList.add(new SettingEntity(R.drawable.ic_screen_lock_portrait, R.string.lock_screen));
        mSettingList.add(new SettingEntity(R.drawable.ic_screen_lock_portrait, R.string.lock_screen));
    }

    private void setLayoutSettings() {
        if (mSettingList.size() == 0) {
            TextView tvNoData = mView.findViewById(R.id.tv_no_data);
            tvNoData.setText(R.string.no_data);
            return;
        }
        SettingListAdapter adapter = new SettingListAdapter(mContext, mSettingList);
        mRvSettingList.setAdapter(adapter);
        mRvSettingList.setLayoutManager(new LinearLayoutManager(mContext));
        adapter.setOnItemClickedListener(new SettingList() {
            @Override
            public void onClickItem(int index) {
                SettingView settingView = (SettingView) mContext;
                switch (index) {
                    case 0: {
                        // call back function lockScreen() in Setting activity
                        settingView.lockScreen();
                        break;
                    }
                    case 1: {
                        Toast.makeText(mContext, "test test", Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getFragmentManager().popBackStack();
    }

}
