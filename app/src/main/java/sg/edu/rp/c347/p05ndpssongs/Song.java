package sg.edu.rp.c347.p05ndpssongs;

/**
 * Created by 15017612 on 19/5/2017.
 */

public class Song {

    private int _id;
    private String title;
    private String singer;
    private int year;
    private int stars;


    public Song (String title, String singer, int year, int stars){
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int get_id(){
        return _id;
    }

    public String getTitle(){
        return title;
    }

    public String getSinger(){
        return singer;
    }

    public int getYear(){
        return year;
    }

    public int getStars(){
        return stars;
    }



}

