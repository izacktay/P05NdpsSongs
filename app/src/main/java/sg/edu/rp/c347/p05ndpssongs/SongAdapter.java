package sg.edu.rp.c347.p05ndpssongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private ArrayList<Song> song;
    private Context context;
    private TextView tvYear, tvSongTitle, tvSinger;
    private ImageView ivIcon;

    public SongAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        song = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object

        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        tvSongTitle = (TextView) rowView.findViewById(R.id.tvSongTitle);
        tvSinger = (TextView) rowView.findViewById(R.id.tvSinger);
        // Get the ImageView object
        ivIcon = (ImageView) rowView.findViewById(R.id.ivIcon);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Song currentSong = song.get(position);
        // Set the TextView to show the food

        tvYear.setText(currentSong.getYear());
        tvSinger.setText(currentSong.getSinger());
        tvSongTitle.setText(currentSong.getTitle());

        // Set the image to star or nostar accordingly
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
