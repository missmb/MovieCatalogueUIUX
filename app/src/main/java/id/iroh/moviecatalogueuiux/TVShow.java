package id.iroh.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private String judul, deskripsi, isitvshow;
    private int poster;

    public TVShow() {
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

    public String getIsitvshow() {
        return isitvshow;
    }

    public void setIsitvshow(String isitvshow) {
        this.isitvshow = isitvshow;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public TVShow(String judul, String deskripsi, int poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.poster = poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.isitvshow);
        dest.writeInt(this.poster);
    }

    protected TVShow(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.isitvshow = in.readString();
        this.poster = in.readInt();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
