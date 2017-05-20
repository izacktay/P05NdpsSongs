package sg.edu.rp.c347.p05ndpssongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShowList;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.etTitle);
        etSinger = (EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShowList = (Button)findViewById(R.id.btnShowList);
        rg = (RadioGroup)findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                //int year = getYear();
                int year = Integer.parseInt(etYear.getText().toString());
                Log.d("---------", String.valueOf(year));
                int star = getStars();
                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSong(title, singer, year, star);

                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(i, 9);

            }
        });


    }
    private int getStars() {
        int stars = 1;
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.rb1:
                stars = 1;
                break;
            case R.id.rb2:
                stars = 2;
                break;
            case R.id.rb3:
                stars = 3;
                break;
            case R.id.rb4:
                stars = 4;
                break;
            case R.id.rb5:
                stars = 5;
                break;
        }
        return stars;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            btnInsert.performClick();
        }
    }

}
