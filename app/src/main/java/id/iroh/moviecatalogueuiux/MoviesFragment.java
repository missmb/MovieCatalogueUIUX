package id.iroh.moviecatalogueuiux;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements  View.OnClickListener{
    View v;
    private RecyclerView myrecyclerview;
    private String[] dataJudul, dataDeskripsi,dataKonten;
    private TypedArray poster;
    private ArrayList<Movie> movies;
    public MoviesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_movies, container, false);
        prepare();
        addItem();
        myrecyclerview = (RecyclerView) v.findViewById(R.id.rv_movies);
        MovieAdapter listmovieadapter = new MovieAdapter(getContext(), movies);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(listmovieadapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.data_movie);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        poster = getResources().obtainTypedArray(R.array.data_poster);
        dataKonten = getResources().getStringArray(R.array.dataKonten);
    }
    private void addItem(){
        movies = new ArrayList<>();
        for (int i=0; i<dataJudul.length; i++){
            Movie listMovie = new Movie();
            listMovie.setJudul(dataJudul[i]);
            listMovie.setDeskripsi(dataDeskripsi[i]);
            listMovie.setThisposter(poster.getResourceId(i, -1));
            listMovie.setKonten(dataKonten[i]);

            movies.add(listMovie);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
