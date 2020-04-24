package com.example.kentsimgeleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static Bitmap secilenResim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listView = findViewById( R.id.listView );

        final ArrayList<String> UlkeSimgeleri = new ArrayList<>(  );
        UlkeSimgeleri.add( "Pisa" );
        UlkeSimgeleri.add( "Eiffel" );
        UlkeSimgeleri.add("Colleseo");
        UlkeSimgeleri.add( "London Bridge" );

        final ArrayList<String> UlkeIsimleri = new ArrayList<>();
        UlkeIsimleri.add( "İtalya" );
        UlkeIsimleri.add( "Fransa" );
        UlkeIsimleri.add( "İtalya" );
        UlkeIsimleri.add( "Birleşik Krallık" );

        Bitmap pisa         = BitmapFactory.decodeResource( getApplicationContext().getResources(),R.drawable.pisa );
        Bitmap eyfel        = BitmapFactory.decodeResource( getApplicationContext().getResources(),R.drawable.eyfel );
        Bitmap colesyum     = BitmapFactory.decodeResource( getApplicationContext().getResources(),R.drawable.collesseo );
        Bitmap londonbridge = BitmapFactory.decodeResource( getApplicationContext().getResources(),R.drawable.london_bridge );

        final ArrayList<Bitmap> ulkeResimleri = new ArrayList<>();
        ulkeResimleri.add(pisa);
        ulkeResimleri.add( eyfel);
        ulkeResimleri.add( colesyum );
        ulkeResimleri.add( londonbridge );
        

        ArrayAdapter arrayAdapter = new ArrayAdapter( MainActivity.this,android.R.layout.simple_list_item_1,UlkeSimgeleri );
        listView.setAdapter( arrayAdapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent( MainActivity.this,DetailsActivity.class );
                intent.putExtra( "name",UlkeSimgeleri.get(position));
                intent.putExtra( "ulke",UlkeIsimleri.get( position ) );
                startActivity( intent );
                Singleton singleton = Singleton.getInstance();
                singleton.setSecilmisResim( ulkeResimleri.get( position ) );
                //secilenResim = ulkeResimleri.get( position );

            }
        } );
    }
}
