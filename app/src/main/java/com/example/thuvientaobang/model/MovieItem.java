package com.example.thuvientaobang.model;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SmartTable(name = "userfInfo")
public class MovieItem {

    @SmartColumn(id = 0, name = "rank")
    @SerializedName("overview")
    @Expose
    public String overview;

    //    @SmartColumn(id = 1, name = "name")
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;

    //    @SmartColumn(id = 2, name = "age")
    @SerializedName("original_title")
    @Expose
    public String originalTitle;

    //    @SmartColumn(id = 3, name = "address")
    @SerializedName("video")
    @Expose
    public boolean video;

    //    @SmartColumn(id = 4, name = "phone")
    @SerializedName("title")
    @Expose
    public String title;

    //    @SmartColumn(id = 5, name = "email")
    @SerializedName("poster_path")
    @Expose
    public String posterPath;

    //    @SmartColumn(id = 6, name = "password")
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;

    //    @SmartColumn(id = 7, name = "height")
    @SerializedName("release_date")
    @Expose
    public String releaseDate;


    @SerializedName("popularity")
    @Expose
    public double popularity;
    @SerializedName("genre_ids")
    @Expose
    public List<Integer> genreIds;
    @SerializedName("vote_average")
    @Expose
    public double voteAverage;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("adult")
    @Expose
    public boolean adult;


    @SerializedName("vote_count")
    @Expose
    public int voteCount;

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "overview = '" + overview + '\'' +
                        ",original_language = '" + originalLanguage + '\'' +
                        ",original_title = '" + originalTitle + '\'' +
                        ",video = '" + video + '\'' +
                        ",title = '" + title + '\'' +
                        ",genre_ids = '" + genreIds + '\'' +
                        ",poster_path = '" + posterPath + '\'' +
                        ",backdrop_path = '" + backdropPath + '\'' +
                        ",release_date = '" + releaseDate + '\'' +
                        ",popularity = '" + popularity + '\'' +
                        ",vote_average = '" + voteAverage + '\'' +
                        ",id = '" + id + '\'' +
                        ",adult = '" + adult + '\'' +
                        ",vote_count = '" + voteCount + '\'' +
                        "}";
    }
}