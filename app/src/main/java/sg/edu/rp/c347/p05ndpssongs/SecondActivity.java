package sg.edu.rp.c347.p05ndpssongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btnShow;
    ListView lv;
    SongAdapter aa;
    ArrayList<String> lvSongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvSongs);
        btnShow = (Button)findViewById(R.id.btnShow);

        DBHelper db = new DBHelper(SecondActivity.this);
        ArrayList<Song> songs = db.getAllSongs();

        aa = new SongAdapter(SecondActivity.this, R.layout.row, songs);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                String data = lvSongs.get(position);
                //String id = data.split(",")[0].split(":")[1];
                String content = data.split(",")[1].trim();
                String singer = data.split(",")[2].trim();
                String year = data.split(",")[3].trim();
                String star = data.split(",")[4].trim();


                Song target = new Song(content, singer,Integer.parseInt(year), Integer.parseInt(star));
                i.putExtra("data", target);
                startActivityForResult(i, 9);

            }
        });

//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int firstListItemPosition = lv.getFirstVisiblePosition();
//                int lastListItemPosition = firstListItemPosition + lv.getChildCount() - 1;
//
//                aa.star5();
//
//            }
//        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            lv.performClick();
        }
    }

}
