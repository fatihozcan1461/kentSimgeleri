package com.example.kentsimgeleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.kentsimgeleri.MainActivity.secilenResim;

public class DetailsActivity extends AppCompatActivity {
    ImageView ımageView;
    TextView countrytext,landmarktext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details );

        ımageView = findViewById( R.id.imageView );
        countrytext = findViewById( R.id.textViewCountryName );
        landmarktext= findViewById( R.id.textViewLankmak );

        Intent intent = getIntent();
        String ulkesimgeismi = intent.getStringExtra( "name" );
        String ulkeisimleri = intent.getStringExtra( "ulke" );
        landmarktext.setText( intent.getStringExtra( "name" ) );
        countrytext.setText( ulkeisimleri );
        Singleton singleton = Singleton.getInstance();
        ımageView.setImageBitmap( singleton.getSecilmisResim() );
        //ımageView.setImageBitmap( secilenResim );


    }
}
