package br.com.ScreenMatch.Models;

import br.com.ScreenMatch.calculate.Classification;

public class Movie extends Title implements Classification {
   private String diretor;

    public Movie(String name, int launchDate, boolean inclueded, String diretor) {
        super(name, launchDate, inclueded);
        this.diretor = diretor;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassifition() {
        return (int) averageRating()/2;
    }
}
