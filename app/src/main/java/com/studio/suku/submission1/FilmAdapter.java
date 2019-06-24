package com.studio.suku.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    //Adapter Untuk List nya
    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films){
        this.films = films;
    }

    public FilmAdapter(Context context){
        this.context = context;
        films = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);

        }
        return convertView;
    }

    public class ViewHolder {
        private TextView nama;
        private TextView resensi;
        private ImageView gambar;

        ViewHolder(View view){
            nama = view.findViewById(R.id.nama);
            resensi = view.findViewById(R.id.resensi);
            gambar = view.findViewById(R.id.gambar);
        }
        //Binding nya disini yahh..
        //Datanya dari setter Getter nya
        void bind(Film film){
            nama.setText(film.getNama());
            resensi.setText(film.getResensi());
            gambar.setImageResource(film.getPhoto());
        }
    }
}
