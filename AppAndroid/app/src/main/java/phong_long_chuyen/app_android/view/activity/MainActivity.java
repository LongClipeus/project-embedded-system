package phong_long_chuyen.app_android.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.presenter.ThresholdPreIm;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getName();

    private float GAS_THRESHOLD;
    private float FIRE_THRESHOLD;

    private TextView mTvTemptNumber;
    private TextView mTvHumidityNumber;
    private TextView mTvGasNumber;
    private TextView mTvGasSafe;
    private TextView mTvFireSafe;
    private ImageView mIvGasState;
    private ImageView mIvFireState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        setStateValue();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle
                = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        mTvTemptNumber = findViewById(R.id.tv_tempt_number);
        mTvHumidityNumber = findViewById(R.id.tv_humidity_number);
        mTvGasNumber = findViewById(R.id.tv_gas_number);
        mIvGasState = findViewById(R.id.iv_gas_state);
        mTvFireSafe = findViewById(R.id.tv_fire_safe);
        mTvGasSafe = findViewById(R.id.tv_gas_safe);
        mIvFireState = findViewById(R.id.iv_fire_state);

        ThresholdPreIm thresholdPreIm = new ThresholdPreIm(this);
        GAS_THRESHOLD = thresholdPreIm.getGasThreshold();
        FIRE_THRESHOLD = thresholdPreIm.getFireThreshold();
    }

    @SuppressLint("ResourceAsColor")
    private void setStateValue() {
        float tempt = 20.00f;
        float gas = 80.00f;
        float humidity = 30.00f;

        mTvTemptNumber.setText(tempt + "");
        mTvGasNumber.setText(gas + "");
        mTvHumidityNumber.setText(humidity + "");

        if (gas > GAS_THRESHOLD) {
            mIvGasState.setImageLevel(1);
            mTvGasSafe.setText(R.string.warning);
            mTvGasSafe.setTextColor(R.color.colorRed);
        } else {
            mIvGasState.setImageLevel(0);
            mTvGasSafe.setText(R.string.safe);
            mTvGasSafe.setTextColor(R.color.colorGreen);
        }

        if (tempt > FIRE_THRESHOLD) {
            mIvFireState.setImageLevel(1);
            mTvFireSafe.setText(R.string.warning);
            mTvFireSafe.setTextColor(R.color.colorRed);
        } else {
            mIvFireState.setImageLevel(0);
            mTvFireSafe.setText(R.string.safe);
            mTvFireSafe.setTextColor(R.color.colorGreen);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
