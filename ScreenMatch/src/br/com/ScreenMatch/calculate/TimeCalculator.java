package br.com.ScreenMatch.calculate;

import br.com.ScreenMatch.Models.Movie;
import br.com.ScreenMatch.Models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void includeTitle(Title movie){
    totalTime+=movie.getDurationMinutes();
    }

}
