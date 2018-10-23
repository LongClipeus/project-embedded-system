package io.github.longclipeus.iotsystems.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import io.github.longclipeus.iotsystems.R;
import io.github.longclipeus.iotsystems.presenter.NetworkConnectIm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mTemperature;
    private RelativeLayout mHumidity;
    private RelativeLayout mGas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isConnected = new NetworkConnectIm(this).isNetworkConnected();
        if (!isConnected) {
            Toast.makeText(this, "ban can ket noi internet", Toast.LENGTH_SHORT).show();
        }

        initView();
        addEvent();


    }

    private void addEvent() {
        mTemperature.setOnClickListener(this);
        mHumidity.setOnClickListener(this);
        mGas.setOnClickListener(this);
    }

    private void initView() {
        mTemperature = findViewById(R.id.rl_temperature);
        mHumidity = findViewById(R.id.rl_humidity);
        mGas = findViewById(R.id.rl_gas);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_temperature: {
                break;
            }
            case R.id.rl_humidity: {
                break;
            }
            case R.id.rl_gas: {
                break;
            }
        }
    }
}
