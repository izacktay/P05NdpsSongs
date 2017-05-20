package sg.edu.rp.c347.p05ndpssongs;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    ArrayList<Song> song;
    ArrayList<Song> fiveStarSong;
    Context context;
    //int resource;
    TextView tvYear, tvSongTitle, tvSinger;
    ImageView ivIcon, iv1, iv2, iv3, iv4, iv5;

    public SongAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        this.song = objects;
        this.context = context;

        song = new ArrayList<Song>();
        song.addAll(objects);
        fiveStarSong = (ArrayList<Song>) song.clone();


    }

    public void star5() {
        filter5Star(0);
    }

    private void filter5Star(int star) {
        fiveStarSong = new ArrayList<>();
        for(Song fiveSong: song) {
            if (fiveSong.getStars() == 5) {
                fiveStarSong.add(fiveSong);
            }
        }
        notifyDataSetChanged();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object

        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        tvSongTitle = (TextView) rowView.findViewById(R.id.tvSongTitle);
        tvSinger = (TextView) rowView.findViewById(R.id.tvSinger);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);
        iv1 = (ImageView) rowView.findViewById(R.id.imageView1Star);
        iv2 = (ImageView) rowView.findViewById(R.id.imageView2Star);
        iv3 = (ImageView) rowView.findViewById(R.id.imageView3Star);
        iv4 = (ImageView) rowView.findViewById(R.id.imageView4Star);
        iv5 = (ImageView) rowView.findViewById(R.id.imageView5Star);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Song currentSong = song.get(position);

        tvYear.setText(currentSong.getYear() + "");
        tvSinger.setText(currentSong.getSinger());
        tvSongTitle.setText(currentSong.getTitle());

        if (currentSong.getStars() >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
        }
        if (currentSong.getStars() >= 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
        }
        if (currentSong.getStars() >= 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
        }
        if (currentSong.getStars() >= 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
        }
        if (currentSong.getStars() >= 1) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }







        // Set the TextView to show the food



        // Set the image to star or nostar accordingly
        // Return the nicely done up View to the ListView
        return rowView;
    }


}
