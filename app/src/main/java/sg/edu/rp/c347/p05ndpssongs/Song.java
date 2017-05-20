package sg.edu.rp.c347.p05ndpssongs;

import java.io.Serializable;

/**
 * Created by 15017612 on 19/5/2017.
 */

public class Song implements Serializable{

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



    @Override
    public String toString() {
        return "ID:" + _id + ", " + title;
    }


//    public String[] split(String s) {
//    }
}

