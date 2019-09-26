package hutsalod.game.nevelnex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    //  ImageView imageView;
    private Animation intro,introname;
    private ImageView image;
    private CountDownTimer countDownTimer;
    private TextView text;
    private static final String TAG = "MainActivity";
    final String SAVED_TEXT = "saved_text";
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

        intro = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fintro);
        introname = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fintroname);
        image = (ImageView)findViewById(R.id.imageView5);
        image.startAnimation(intro);
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        final double st = Double.parseDouble(sPref.getString(SAVED_TEXT, "0"));

        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                if(st==0){
                    Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                    startActivity(intent);
               } else{
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);}
            }};
        countDownTimer.start();

    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }


}