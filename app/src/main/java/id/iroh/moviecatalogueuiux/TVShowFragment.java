package id.iroh.moviecatalogueuiux;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TVShowFragment extends Fragment {
    View v;
    private String[] datajudul, datadeskripsi, dataKonten, dataposter;
    private ArrayList<TVShow> tvShows;
    private RecyclerView iniRecyclerView;

    public TVShowFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tvshow, container, false);
        siap();
        tambah();
        iniRecyclerView = (RecyclerView) v.findViewById(R.id.rvtvshow);
        TVShowAdapter initvshow = new TVShowAdapter(getContext(), tvShows);
        iniRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iniRecyclerView.setAdapter(initvshow);
        return v;
    }

    public void siap(){
        datajudul = getResources().getStringArray(R.array.judul_tvshow);
        datadeskripsi = getResources().getStringArray(R.array.deskripsi_tvshow);
        dataposter = getResources().getStringArray(R.array.poster_tvshow);
        dataKonten = getResources().getStringArray(R.array.konten_tvshow);
    }

    public void tambah(){
        tvShows = new ArrayList<>();
        for (int j=0; j<datajudul.length; j++){
            TVShow tv = new TVShow();
            tv.setJudul(datajudul[j]);
            tv.setDeskripsi(datadeskripsi[j]);
            tv.setPoster(dataposter[j]);
            tv.setIsitvshow(dataKonten[j]);
            tvShows.add(tv);
        }
    }
}
