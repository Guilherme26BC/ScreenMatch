package br.com.ScreenMatch.main;

import br.com.ScreenMatch.Models.Episode;
import br.com.ScreenMatch.Models.Movie;
import br.com.ScreenMatch.Models.Serie;
import br.com.ScreenMatch.calculate.RecomendationFilter;
import br.com.ScreenMatch.calculate.TimeCalculator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //instanciando um filme
        Movie mv1 = new Movie("Wicked",2024, true, "Fulano de tal");
        mv1.setDurationMinutes(200);
        mv1.rateMovie(10);
        mv1.rateMovie(2);
        mv1.showTech();
        //instanciando serie
        Serie ser = new Serie("Brookling 99", 2012,true,7,23,32);
        ser.showTech();

        //testando calculadora de tempo
        TimeCalculator calculator = new TimeCalculator();
        calculator.includeTitle(mv1);
        System.out.println(calculator.getTotalTime());
        calculator.includeTitle(ser);
        System.out.println(calculator.getTotalTime());

        //testando o filtro
        RecomendationFilter filter = new RecomendationFilter();
        filter.filter(mv1);
        Episode ep = new Episode(1, "pilot", ser, 10000);
        filter.filter(ep);

        //instanciando mais um filme
        Movie mv2 = new Movie("I'm still here", 2024, true,"Walter Sales");
        mv2.setDurationMinutes(200);
        mv2.rateMovie(10);
        mv2.rateMovie(10);
        mv2.showTech();

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(mv1);
        movies.add(mv2);
        System.out.println("Tamanho da lista: " + movies.size());
        System.out.println("Primeiro item da lista: " + movies.getFirst().getName());
        System.out.println(movies);//pode reescrever o metodo toString na classe desejada para exibir como queira
        System.out.println("***************");
        for (Movie mvAux : movies){
            mvAux.showTech();
            System.out.println("");


        }
    }
}
