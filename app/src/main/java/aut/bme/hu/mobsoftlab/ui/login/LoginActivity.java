package aut.bme.hu.mobsoftlab.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.R;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.ui.admin.AdminActivity;
import aut.bme.hu.mobsoftlab.ui.admin.AdminPresenter;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;

import static android.R.attr.password;


/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobSoftApplication.injector.inject(this);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void show() {

    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
        finish();
    }

    public void loginClicked(View view){
        EditText mEmail = (EditText)findViewById(R.id.email);
        EditText mPass = (EditText)findViewById(R.id.password);
        Profile prof = new Profile();
        prof.setEmail(mEmail.getText().toString());
        prof.setPassword(mPass.getText().toString());
        System.out.println("logactivity start");
        loginPresenter.loginUser(prof);
    }
}
