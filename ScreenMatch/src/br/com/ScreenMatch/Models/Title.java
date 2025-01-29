package br.com.ScreenMatch.Models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable{
   // @SerializedName("Title")
    private String name;
    //@SerializedName("Year")
    private int launchDate;
    private boolean inclueded;
    private double rating;
    private int totalRating;
    //@SerializedName("Runtime")
    private String time;
    private int durationMinutes;
    private int contador=0;

    //construtores
    public Title( String name, int launchDate, boolean inclueded) {

        this.name = name;
        this.launchDate = launchDate;
        this.inclueded = inclueded;
    }
    //getters and setters

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(int launchDate) {
        this.launchDate = launchDate;
    }

    public boolean isInclueded() {
        return inclueded;
    }

    public void setInclueded(boolean inclueded) {
        this.inclueded = inclueded;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //métodos unicos
    public void showTech(){
        System.out.println(String.format("""
                Name: %s
                Release year: %d
                Duration(minutes): %s
                Rating: %f""",name,launchDate,time,rating));
    }
    public void rateMovie(double rate){
        totalRating+=rate;
        contador++;
        averageRating();
    }
    public double averageRating(){
        rating =totalRating/contador;
        return rating;
    }

    @Override
    public int compareTo(Object titleaux) {
        if(titleaux instanceof Movie mvAux)
        return this.getName().compareTo(mvAux.getName());
        else if(titleaux instanceof Serie serAux)
            return this.getName().compareTo(serAux.getName());
        return 0;
    }

    @Override
    public String toString() {
        return "(Title: " + this.getName() + " Released in: " + this.getLaunchDate() + " Runtime: " + this.time + ") ";
    }
}
