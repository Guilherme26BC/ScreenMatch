package br.com.ScreenMatch.calculate;

public class RecomendationFilter {
    private String recomendation;

    public void filter(Classification classification){
        if(classification.getClassifition()>=4){
            System.out.println("This is one of the favorites");
        }else if (classification.getClassifition()>=2){
            System.out.println("Well rated recently");
        }else{
            System.out.println("Put on your 'watch later' playlist");
        }
    }

}
