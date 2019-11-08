package id.iroh.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Movie implements Parcelable {
    private String judul, deskripsi, konten ;
    private int Thisposter;

    public Movie() {
    }

    public Movie(String judul, String deskripsi, int poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        Thisposter = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public int getThisposter() {
        return Thisposter;
    }

    public void setThisposter(int thisposter) {
        Thisposter = thisposter;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.konten);
        dest.writeInt(this.Thisposter);

    }

    protected Movie(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.konten = in.readString();
        this.Thisposter = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


}