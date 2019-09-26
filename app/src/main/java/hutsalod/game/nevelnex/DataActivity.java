package hutsalod.game.nevelnex;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TextView mDisplayDate;
    private LinearLayout data, floors;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    SharedPreferences sPref;
    private String floor;

    final String SAVED_TEXT = "saved_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrin1);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        data = (LinearLayout)findViewById(R.id.data);
        floors = (LinearLayout)findViewById(R.id.Floor);

    }
    public void onDateSet(int year, int month, int day) {
       // month = month + 1;
        String date = month + "/" + day + "/" + year;
        String months = month+1 + "." + day;
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, months);
        ed.commit();
    }

    public void next(View view) {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        onDateSet(year,month,day);
        /*Intent intents = new Intent(DataActivity.this, FloorActivity.class);
        startActivity(intents);*/
        data.setVisibility(View.GONE);
        floors.setVisibility(View.VISIBLE);
    }

     public void man(View view) {
       floor = "1";
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("floor", floor);
        ed.commit();
        Intent intents = new Intent(DataActivity.this, MainActivity.class);
        startActivity(intents);
    }

    public void girl(View view) {
        floor = "0";
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("floor", floor);
        ed.commit();
        Intent intents = new Intent(DataActivity.this, MainActivity.class);
        startActivity(intents);
    }
}
