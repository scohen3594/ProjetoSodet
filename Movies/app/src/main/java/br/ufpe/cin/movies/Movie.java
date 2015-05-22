package br.ufpe.cin.movies;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int id;
    private String name;
    private String originalName;
    private String sinopse;
    private String director;
    private String classification;
    private String year;
    private double imdbRating;
    private String duration;
    private String writer;
    private String genre;
    private String cast;
    private String imdbUrl;
    private String trailer;
    private String poster;
    private String backrop;
    private String national;
    private List<Session> sessions;
    private String originalTitle;

    public Movie(int id, String name, String originalName, String sinopse, String director, String classification,
                 String year, double imdbRating, String duration, String writer, String genre, String cast, String imdbUrl,
                 String trailer, String poster, String backrop, String national, String originalTitle, List<Session> sessions) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.sinopse = sinopse;
        this.director = director;
        this.classification = classification;
        this.year = year;
        this.imdbRating = imdbRating;
        this.duration = duration;
        this.writer = writer;
        this.genre = genre;
        this.cast = cast;
        this.imdbUrl = imdbUrl;
        this.trailer = trailer;
        this.poster = poster;
        this.backrop = backrop;
        this.national = national;
        this.sessions = sessions;
        this.originalTitle = originalTitle;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setString(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getClassification(){
        return classification;
    }

    public void setClassification(String classification){
        this.classification = classification;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public double getImdbRating(){
        return imdbRating;
    }

    public void setImdbRating(double imdbRating){
        this.imdbRating = imdbRating;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){this.duration = duration;
    }

    public String getWriter(){
        return writer;
    }

    public void setWriter(String writer){
        this.writer = writer;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getCast(){
        return cast;
    }

    public void setCast(String cast){
        this.cast = cast;
    }

    public String getImdbUrl(){
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl){
        this.imdbRating = imdbRating;
    }

    public String getTrailer(){
        return trailer;
    }

    public void setTrailer(String trailer){
        this.trailer = trailer;
    }

    public String getPoster(){
        return poster;
    }

    public void setPoster(String poster){
        this.poster = poster;
    }

    public String getBackrop(){
        return backrop;
    }

    public void setBackrop(String backrop){
        this.backrop = backrop;
    }

    public String getNational(){
        return national;
    }

    public void setNational(String national){
        this.national = national;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getOriginalTitle(){
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

}
