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
import android.widget.Toast;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.ThresholdPreIm;

import static phong_long_chuyen.app_android.config.Define.FIRE_THRESHOLD;
import static phong_long_chuyen.app_android.config.Define.GAS_THRESHOLD;
import static phong_long_chuyen.app_android.config.Define.STACK_SETTING_LIST_FRAGMENT;

@SuppressLint("ValidFragment")
public class ThresholdFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    private View mView;

    private EditText mEtFireThre;
    private EditText mEtGasThre;
    private Button mBtnSetDefault;
    private Button mBtn_save;

    @SuppressLint("ValidFragment")
    public ThresholdFragment(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_threshold, container, false);
        initView();
        addEvent();
        return mView;
    }

    private void initView() {
        mEtFireThre = mView.findViewById(R.id.et_fire_thre_number);
        mEtGasThre = mView.findViewById(R.id.et_gas_thre_number);
        mBtnSetDefault = mView.findViewById(R.id.btn_set_default);
        mBtn_save = mView.findViewById(R.id.btn_save);

        ThresholdPreIm thresholdPreIm = new ThresholdPreIm(mContext);
        String text = thresholdPreIm.getFireThreshold() + "";
        mEtFireThre.setText(text);
        text = thresholdPreIm.getGasThreshold() + "";
        mEtGasThre.setText(text);
    }

    private void addEvent() {
        mBtnSetDefault.setOnClickListener(this);
        mBtn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set_default: {
                String text = FIRE_THRESHOLD + "";
                mEtFireThre.setText(text);
                text = GAS_THRESHOLD + "";
                mEtGasThre.setText(text);
                break;
            }
            case R.id.btn_save: {
                ThresholdPreIm thresholdPreIm = new ThresholdPreIm(mContext);
                String gas = mEtGasThre.getText() + "";
                String fire = mEtFireThre.getText() + "";
                Boolean a = thresholdPreIm.saveThreshold(Float.parseFloat(gas), Float.parseFloat(fire));
                if (a) {
                    Toast.makeText(mContext, R.string.save_thre_success, Toast.LENGTH_LONG).show();
                    getFragmentManager().popBackStack(STACK_SETTING_LIST_FRAGMENT, 0);
                } else {
                    Toast.makeText(mContext, R.string.can_not_save_thre, Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}
