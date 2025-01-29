package br.com.ScreenMatch.Models;

import br.com.ScreenMatch.calculate.Classification;

public class Episode implements Classification {
    private int number;
    private String name;
    private Serie serie;
    private int totalViews;

    public Episode(int number, String name, Serie serie, int totalViews) {
        this.number = number;
        this.name = name;
        this.serie = serie;
        this.totalViews = totalViews;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    @Override
    public int getClassifition() {
        if(totalViews>100){
        return 4;
        }else{
            return 2;
        }
    }
}
