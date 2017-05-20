package sg.edu.rp.c347.p05ndpssongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    SongAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvSongs);

        DBHelper db = new DBHelper(SecondActivity.this);
        ArrayList<Song> songs = db.getAllSongs();

        aa = new SongAdapter(SecondActivity.this, R.layout.row, songs);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

    }

}
