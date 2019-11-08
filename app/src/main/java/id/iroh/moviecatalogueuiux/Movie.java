package id.iroh.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String judul, deskripsi, konten, Thisposter;

    public Movie() {
    }

    public Movie(String judul, String deskripsi, String poster) {
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

    public String getThisposter() {
        return Thisposter;
    }

    public void setThisposter(String thisposter) {
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
        dest.writeString(this.Thisposter);

    }

    protected Movie(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.konten = in.readString();
        this.Thisposter = in.readString();
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