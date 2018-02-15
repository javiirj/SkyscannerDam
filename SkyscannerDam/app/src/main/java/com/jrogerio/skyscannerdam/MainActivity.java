package com.jrogerio.skyscannerdam;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.jrogerio.skyscannerdam.model.Vuelo;

public class MainActivity extends AppCompatActivity implements OnVueloInteractionListener {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()) {
                // f = new VueloFragment();
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }

            if(f!=null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, f)
                        .commit();
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new VueloFragment())
                .commit();
    }

    @Override
    public void onVueloClick(Vuelo vuelo) {
        Intent i = new Intent(this, DetallesVueloActivity.class);
        i.putExtra("origen", vuelo.getOrigen());
        i.putExtra("destino", vuelo.getDestino());
        i.putExtra("horaSalida", vuelo.getHoraSalida());
        i.putExtra("duracion", vuelo.getDuracion());
        i.putExtra("precio", vuelo.getPrecio());
        i.putExtra("foto", vuelo.getUrlFoto());
        startActivity(i);
    }
}
