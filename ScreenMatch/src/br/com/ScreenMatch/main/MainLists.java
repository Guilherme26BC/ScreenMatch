package br.com.ScreenMatch.main;

import br.com.ScreenMatch.Models.Movie;
import br.com.ScreenMatch.Models.Serie;
import br.com.ScreenMatch.Models.Title;

import java.util.*;

public class MainLists {
    public static void main(String[] args) {
        Movie mv1 = new Movie("Wicked", 2024, true, "Fulano de tal");
        mv1.rateMovie(10);
        Serie ser = new Serie("Brookling 99", 2012, true, 7, 23, 32);

        Movie mv2 = new Movie("I'm still here", 2024, true, "Walter Sales");
        mv2.rateMovie(10);
        Movie mv3 = new Movie("Anora", 2025, true, "Mickey Madison");
        mv3.rateMovie(10);
        ArrayList<Title> watched = new ArrayList<>();
        watched.add(mv1);
        watched.add(mv2);
        watched.add(mv3);
        watched.add(ser);

//        mv3.showTech();
//        Movie mv4 = mv3;
//        System.out.println("MV4");
//        mv4.showTech();
//        mv4.setName("ONE OF THEM DAYS");
//        mv3.showTech();
//        mv4.showTech();

        for (Title title : watched) {
            System.out.println(title.getName());
            if (title instanceof Movie mvAux) {
                System.out.println("Rating " + mvAux.getClassifition() + "\n");
            }
        }
        List<String> searchArtists = new LinkedList<>();
        searchArtists.add("Mickey Madison");
        searchArtists.add("Fernanda Torres");
        searchArtists.add("Demi Moore");
        searchArtists.add("Cinthia Erivo");
        System.out.println(searchArtists);

        Collections.sort(searchArtists);
        System.out.println(searchArtists);


        Collections.sort(watched);//organizar pelo nome; primeiro organiza pelo nome e depois pelo ano
        watched.sort(Comparator.comparing(Title::getLaunchDate));//Organizar a lista pelo ano de lançamento
        for (Title title : watched) {
            System.out.println(title.getName() + ", " + title.getLaunchDate());
        }
    }
}
