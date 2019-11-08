package id.iroh.moviecatalogueuiux;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private TextView tvJudul, judul, tvKonten;
    private ImageView imgPoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        Movie pilihFilm = getIntent().getParcelableExtra(EXTRA_MOVIE);
        TVShow acara = getIntent().getParcelableExtra(EXTRA_TV);

        tvJudul = findViewById(R.id.tv_judul);
        judul = findViewById(R.id.judul);
        tvKonten = findViewById(R.id.tv_content);
        imgPoster = findViewById(R.id.img_main);

        if (pilihFilm != null){
            tvJudul.setText(pilihFilm.getJudul());
            judul.setText(pilihFilm.getJudul());
            tvKonten.setText(pilihFilm.getKonten());
            tambahGambar(pilihFilm.getThisposter(), imgPoster);
        }

        if (acara != null) {
            tvJudul.setText(acara.getJudul());
            judul.setText(acara.getJudul());
            tvKonten.setText(acara.getIsitvshow());
            tambahGambar(acara.getPoster(), imgPoster);
        }
    }

    public void tambahGambar(int data, ImageView letak){
        Glide.with(DetailActivity.this)
                .load(data)
                .into(letak);
    }
}
