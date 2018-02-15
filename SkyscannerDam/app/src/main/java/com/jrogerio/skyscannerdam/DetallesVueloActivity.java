package com.jrogerio.skyscannerdam;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetallesVueloActivity extends AppCompatActivity {

    TextView textViewOrigen, textViewDestino, textViewHoraSalida, textViewDuracion, textViewPrecio;
    ImageView imageViewFoto;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_vuelo);

        textViewOrigen = findViewById(R.id.textViewOrigen);
        textViewDestino = findViewById(R.id.textViewDestino);
        textViewHoraSalida = findViewById(R.id.textViewHoraSalida);
        textViewDuracion = findViewById(R.id.textViewDuracion);
        textViewPrecio = findViewById(R.id.textViewPrecio);
        imageViewFoto = findViewById(R.id.imageViewFoto);

        // Obtenemos del Intent que ha lanzado este Activity
        // los parámetros que vienen a través del putExtra()
        Bundle extras = getIntent().getExtras();
        String origen = extras.getString("origen");
        String destino = extras.getString("destino");
        String horaSalida = extras.getString("horaSalida");
        Double duracion = extras.getDouble("duracion");
        Double precio = extras.getDouble("precio");
        String foto = extras.getString("foto");

        textViewOrigen.setText(origen);
        textViewDestino.setText(destino);
        textViewHoraSalida.setText(horaSalida);
        textViewDuracion.setText(String.valueOf(duracion));
        textViewPrecio.setText(String.valueOf(precio));
        Picasso.with(DetallesVueloActivity.this).load(foto).into(imageViewFoto);


    }
}
