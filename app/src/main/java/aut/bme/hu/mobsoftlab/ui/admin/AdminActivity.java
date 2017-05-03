package aut.bme.hu.mobsoftlab.ui.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.R;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AdminActivity extends AppCompatActivity implements AdminScreen {

    @Inject
    AdminPresenter adminPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adminPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adminPresenter.detachScreen();
    }

    @Override
    public void showModel(String model) {

    }

    @Override
    public void showError(String error) {

    }
}
