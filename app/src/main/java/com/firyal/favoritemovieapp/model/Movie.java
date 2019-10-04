package com.firyal.favoritemovieapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_movie")
public class Movie implements Parcelable {

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "original_language")
    private String originalLanguage;

    @ColumnInfo(name = "original_title")
    private String originalTitle;

    @ColumnInfo(name = "video")
    private boolean video;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "poster_path")
    private String posterPath;

    @ColumnInfo(name = "backdrop_path")
    private String backdropPath;

    @ColumnInfo(name = "release_date")
    private String releaseDate;

    @ColumnInfo(name = "vote_average")
    private double voteAverage;

    @ColumnInfo(name = "popularity")
    private double popularity;

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    private int id;

    @ColumnInfo(name = "adult")
    private boolean adult;

    @ColumnInfo(name = "vote_count")
    private int voteCount;


    public String getOverview() {
        return overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public boolean isVideo() {
        return video;
    }

    public String getTitle() {
        return title;
    }


    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getVoteCount() {
        return voteCount;
    }


    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.overview);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeByte(this.video ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
        dest.writeString(this.releaseDate);
        dest.writeDouble(this.voteAverage);
        dest.writeDouble(this.popularity);
        dest.writeInt(this.id);
        dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
        dest.writeInt(this.voteCount);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.overview = in.readString();
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.video = in.readByte() != 0;
        this.title = in.readString();
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
        this.releaseDate = in.readString();
        this.voteAverage = in.readDouble();
        this.popularity = in.readDouble();
        this.id = in.readInt();
        this.adult = in.readByte() != 0;
        this.voteCount = in.readInt();
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