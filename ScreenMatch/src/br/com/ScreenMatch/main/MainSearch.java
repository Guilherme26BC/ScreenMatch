package br.com.ScreenMatch.main;

import br.com.ScreenMatch.Exception.YearConvertionErrorException;
import br.com.ScreenMatch.Models.Title;
import br.com.ScreenMatch.Models.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String movie;
        List<Title> titles =new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        do {
            System.out.println("Type the movie you want to search");
            movie = teclado.nextLine().toLowerCase();

            if(movie.equalsIgnoreCase("exit"))
                break;

            String mvaux[] = movie.split(" ");

            //ADAPTAÇÃO PARA O FILME ENTRAR NO PADRÃO DE PESQUISA
            for (int i = 0; i < mvaux.length; i++) {
                if (i == 0) {
                    movie = String.format("""
                            %s""", mvaux[i]);
                } else {
                    movie = String.format("""
                            %s+%s""", movie, mvaux[i]);
                }
            }
            //ou movie = movie.replace(" ", "+");

            //COLOcANDO NO PADRÃO DA URL
            String url = String.format("""
                    https://www.omdbapi.com/?t=%s&apikey=4f1d8fec""", movie.split(" "));

            //CRIA A CONEXÃO E MANDA PARA O SERVIDOR
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            //TRAZ A RESPOSTA
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            //Title title = gson.fromJson(json, Title.class);
            //title.showTech();
            TitleOmdb titleOmdb = gson.fromJson(json, TitleOmdb.class);
            System.out.println(titleOmdb);

            try {
                Title title = new Title(titleOmdb.title(), Integer.parseInt(titleOmdb.year()), true);
                title.setTime(titleOmdb.runtime());
                title.showTech();

                titles.add(title);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: " + e);
            }
        }while(!movie.equalsIgnoreCase("exit"));
        FileWriter writer = new FileWriter("Movies.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("The program ended");
    }
}
