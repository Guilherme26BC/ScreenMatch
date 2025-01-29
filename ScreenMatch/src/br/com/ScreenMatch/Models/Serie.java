package br.com.ScreenMatch.Models;

public class Serie extends Title{
    int seasons;
    int epPerSeason;
    int minPerEp;

    public Serie(String name, int launchDate, boolean inclueded, int seasons, int epPerSeason, int minPerEp) {
        super(name, launchDate,  inclueded);
        this.seasons = seasons;
        this.epPerSeason = epPerSeason;
        this.minPerEp = minPerEp;
        super.setDurationMinutes(getDurationMinutes());
    }

    public int getMinPerEp() {
        return minPerEp;
    }

    public void setMinPerEp(int minPerEp) {
        this.minPerEp = minPerEp;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpPerSeason() {
        return epPerSeason;
    }

    public void setEpPerSeason(int epPerSeason) {
        this.epPerSeason = epPerSeason;
    }

    @Override
    public int getDurationMinutes() {
        return seasons* getEpPerSeason() * getMinPerEp();
    }
}
