package sg.edu.rp.c347.p05ndpssongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvSongs);

        // Create a few food objects in Food array
        song = new ArrayList<Song>();
        food.add(new Food("Rocky Choc", true));
        food.add(new Food("Kid Cat Choc", true));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new FoodAdapter(this, R.layout.row, food);
        lv.setAdapter(aa);
    }
   ...
}
