package hutsalod.game.nevelnex;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class FloorActivity extends AppCompatActivity {


    SharedPreferences sPref;
    private String floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrin2);
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);

    }

    public void man(View view) {
        floor = "1";
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("floor", floor);
        ed.commit();
        Intent intents = new Intent(this, MainActivity.class);
        startActivity(intents);
    }

    public void girl(View view) {
        floor = "0";
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("floor", floor);
        ed.commit();
        Intent intents = new Intent(this, MainActivity.class);
        startActivity(intents);
    }
}
