package aut.bme.hu.mobsoftlab.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.R;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.ui.admin.AdminActivity;
import aut.bme.hu.mobsoftlab.ui.details.DetailsActivity;
import aut.bme.hu.mobsoftlab.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.getMovies();
    }

    @Override
    protected void onStop() {
        mainPresenter.detachScreen();
        super.onStop();
    }

    public void addNewClicked(View view){
        navigateToAdmin();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(final List<Movie> movies) {

        ListView list = (ListView)findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter;
        for(int i=0; i<movies.size(); i++){
            arrayList.add(movies.get(i).getTitle() + " " + movies.get(i).getYear());
        }
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), movies.get(position).getTitle(), Toast.LENGTH_SHORT);
                //System.out.println(movies.get(position).getTitle());
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("id", movies.get(position).getId());
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void navigateToAdmin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
