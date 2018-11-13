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

import phong_long_chuyen.app_android.R;

@SuppressLint("ValidFragment")
public class SignUpFragment extends Fragment implements View.OnClickListener{

    private Context mContext;

    private EditText mEtFirstName;
    private EditText mEtLastName;
    private EditText mEtPassword;
    private EditText mEtConfpassword;
    private Button mBtnCreate;

    @SuppressLint("ValidFragment")
    public SignUpFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_new_account, container, false);

        initView(view);
        addEvent();

        return view;
    }

    private void initView(View view) {
        mEtFirstName = view.findViewById(R.id.et_first_name);
        mEtLastName = view.findViewById(R.id.et_last_name);
        mEtPassword = view.findViewById(R.id.et_passwd);
        mEtConfpassword = view.findViewById(R.id.et_confirm_password);
        mBtnCreate = view.findViewById(R.id.btn_create);
    }

    private void addEvent() {
        mBtnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
