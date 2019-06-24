package com.studio.suku.submission1;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Bismillah Budal Amerika
    private String[] dataNama;
    private String[] dataResensi;
    private TypedArray dataGambar;
    private FilmAdapter adapter;
    private ArrayList<Film> films;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Panggil Adapter nya disini
        adapter = new FilmAdapter(this);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);

        //Kita Buat Fungsi Untuk Memanggil Datanya dan menambahkannya
        //Persiapan Dan tambahItem
        Persiapan();
        tambahItem();

        //Disini Kita tambhkan Fungsi Onclick Pada Listview nya
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, films.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void Persiapan(){
        //Kita Panggil datanya Disini -> Dari Strings.xml
        dataNama = getResources().getStringArray(R.array.list_nama);
        dataResensi = getResources().getStringArray(R.array.list_desc);
        dataGambar = getResources().obtainTypedArray(R.array.list_gambar);
    }

    void tambahItem(){
        films = new ArrayList<>();
        //Looping Dan Slobokkan -> Bahasa Wonorejonya Masukkan
        for (int i = 0; i < dataNama.length; i++){
            Film film = new Film();
            //Dari Setter Getter yahhh
            film.setNama(dataNama[i]);
            film.setResensi(dataResensi[i]);
            film.setPhoto(dataGambar.getResourceId(i, -1));
        }

        adapter.setFilms(films);
    }
}
