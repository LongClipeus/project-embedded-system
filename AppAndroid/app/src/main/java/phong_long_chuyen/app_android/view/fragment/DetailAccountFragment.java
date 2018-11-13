package phong_long_chuyen.app_android.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phong_long_chuyen.app_android.R;

@SuppressLint("ValidFragment")
public class DetailAccountFragment extends Fragment {

    private Context mContext;

    @SuppressLint("ValidFragment")
    public DetailAccountFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_detail_account, container, false);

        initView(view);
        addEvent();

        return view;
    }

    private void initView(View view) {

    }

    private void addEvent() {

    }

}
