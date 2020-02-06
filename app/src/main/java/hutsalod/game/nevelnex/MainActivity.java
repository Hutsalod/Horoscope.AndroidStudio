package hutsalod.game.nevelnex;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static hutsalod.game.nevelnex.R.drawable.ic_refresh;


public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private final int REQ_DANGERS_PERMISSION = 2;
    static TextView herom,spil,today,tommorow,signs,status,stlove,stsex,kars,youstatus,westatus,zrlove,zrsex,life,txtVs,lol2,lol3,signsTwo,
    intes,lifeCout,bonusCout,happyCout;
    static ImageView image,handfon,toUsersZodiac,youUsersZodiac,ic_zodiac;
    public Button start;
    public ConstraintLayout home,seting;
    private Animation fadein;
    private CountDownTimer mCountTime;
    private int cameraSet = 0,data,lan = 0, r;
    static int hr;
    double st;
    LinearLayout herom2;
    private Random rand = new Random();
    private SwitchCompat sfacty,sword;
    private RadioButton radio1,radio3;
    private ScrollView history,loves,cout;
    private String floor;
    ProgressBar love,sex,kar,load;
    static ProgressBar bar1,bar2,bar3;
    RadioGroup rg,radioFloor;
    SharedPreferences sPref;
    SensorManager sensorManager;
    private DatePicker datePicker;
    private static final String TAG = "AndroidCameraApi";

    private Camera mCamera;
    private CameraPreview mPreview;
    private Camera.PictureCallback mPicture;
    private boolean stE = false;
    private Context myContext;
    private LinearLayout cameraPreview;
    private boolean cameraFront = false;
    public static Bitmap bitmap;

    private boolean dial=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.Start);

        herom = (TextView) findViewById(R.id.herom);
        youstatus = (TextView) findViewById(R.id.youstatus);
        spil = (TextView) findViewById(R.id.spil);
        today = (TextView) findViewById(R.id.today);
        tommorow = (TextView) findViewById(R.id.tommorow);
        signs = (TextView) findViewById(R.id.signs);
        signsTwo = (TextView) findViewById(R.id.signsTwo);
        westatus = (TextView) findViewById(R.id.westatus);
        zrlove = (TextView) findViewById(R.id.zrlove);
        zrsex = (TextView) findViewById(R.id.zrsex);
        life = (TextView) findViewById(R.id.life);
        txtVs = (TextView) findViewById(R.id.txtVs);
        lol2 = (TextView) findViewById(R.id.lol2);
        lol3 = (TextView) findViewById(R.id.lol3);
        intes = (TextView) findViewById(R.id.intes);
        lifeCout = (TextView)findViewById(R.id.lifeCout);
        bonusCout = (TextView)findViewById(R.id.bonusCout);
        happyCout = (TextView)findViewById(R.id.happyCout);

        herom2 = (LinearLayout) findViewById(R.id.herom2);

        home = (ConstraintLayout) findViewById(R.id.home);
        seting = (ConstraintLayout) findViewById(R.id.seting);
        loves = (ScrollView) findViewById(R.id.loves);
        history = (ScrollView) findViewById(R.id.history);
        cout = (ScrollView) findViewById(R.id.cout);

        datePicker = (DatePicker) findViewById(R.id.datePicker);


        image = (ImageView)findViewById(R.id.image);
        toUsersZodiac = (ImageView)findViewById(R.id.toUsersZodiac);
        youUsersZodiac = (ImageView)findViewById(R.id.youUsersZodiac);
        handfon = (ImageView)findViewById(R.id.handfon);
        ic_zodiac = (ImageView)findViewById(R.id.ic_zodiac);


        sfacty = (SwitchCompat)findViewById(R.id.switch1);
        sword = (SwitchCompat)findViewById(R.id.switch2);

        rg = (RadioGroup) findViewById(R.id.rbgroup);
        radioFloor = (RadioGroup) findViewById(R.id.floor);
        radio1 = (RadioButton) findViewById(R.id.radioButton3);
        radio3 = (RadioButton) findViewById(R.id.radioButton);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadein);

        switch (lan){
            case 1: radio1.setChecked(true);
                break;
            case 2: radio3.setChecked(true);
                break;}


        love = findViewById(R.id.progressBar);
        sex = findViewById(R.id.progressBar2);
        kar = findViewById(R.id.progressBar3);
        load = findViewById(R.id.progressBar4);
        bar1 = findViewById(R.id.progressBar5);
        bar2 = findViewById(R.id.progressBar6);
        bar3 = findViewById(R.id.progressBar7);


        status = (TextView) findViewById(R.id.ststus);
        stlove = (TextView) findViewById(R.id.stlove);
        stsex = (TextView) findViewById(R.id.stsex);
        kars = (TextView) findViewById(R.id.kar);

        navigation.setSelectedItemId(R.id.navigation_history);

        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        st = Double.parseDouble(sPref.getString("saved_text", "3.21"));
        floor =  sPref.getString("floor", "0");

        long date = System.currentTimeMillis();
        SimpleDateFormat datas = new SimpleDateFormat("d");
        data = Integer.parseInt(datas.format(date));

        love.setMax(100);
        love.setProgress(0);
        sex.setMax(100);
        sex.setProgress(0);
        kar.setMax(100);
        kar.setProgress(0);
        bar1.setMax(100);
        bar1.setProgress(0);
        bar2.setMax(100);
        bar2.setProgress(0);
        bar3.setMax(100);
        bar3.setProgress(0);

        StartStatus(st);

        cameraPreview = (LinearLayout) findViewById(R.id.cPreview);

        toUsersZodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        myContext = this;
        if(	PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)) {
            mCamera = Camera.open();
            mCamera.setDisplayOrientation(90);
            mPreview = new CameraPreview(myContext, mCamera);
            cameraPreview.addView(mPreview);
        }else {
            stE=true;
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},
                    REQ_DANGERS_PERMISSION);

        }
}

    public void StartStatus(double st){
        if(st>=3.21 && st<=4.20){
            status.setText(R.string.h1);
            spil.setText(R.string.described1);
            ic_zodiac.setImageResource(R.drawable.ic_zod9);
            youUsersZodiac.setImageResource(R.drawable.ic_zod9);
            signs.setText(R.string.signs1);
            progres(93,94,92,1);
        }

        if(st>=4.21 && st<=5.20){
            status.setText(R.string.h2);
            spil.setText(R.string.described2);
            ic_zodiac.setImageResource(R.drawable.ic_zod7);
            youUsersZodiac.setImageResource(R.drawable.ic_zod7);
            signs.setText(R.string.signs2);
            progres(92,94,93,2);
        }
        if(st>=5.21 && st<=6.21){
            status.setText(R.string.h3);
            spil.setText(R.string.described3);
            ic_zodiac.setImageResource(R.drawable.ic_zod5);
            youUsersZodiac.setImageResource(R.drawable.ic_zod5);
            signs.setText(R.string.signs3);
            progres(91,94,94,3);
        }
        if(st>=6.22 && st<=7.22){
            status.setText(R.string.h4);
            spil.setText(R.string.described4);
            ic_zodiac.setImageResource(R.drawable.ic_zod4);
            youUsersZodiac.setImageResource(R.drawable.ic_zod4);
            signs.setText(R.string.signs4);
            progres(90,94,95,4);
        }
        if(st>=7.23 && st<=8.23){
            status.setText(R.string.h5);
            spil.setText(R.string.described5);
            ic_zodiac.setImageResource(R.drawable.ic_zod3);
            youUsersZodiac.setImageResource(R.drawable.ic_zod3);
            signs.setText(R.string.signs5);
            progres(89,94,96,5);
        }
        if(st>=8.24 && st<=9.23){
            status.setText(R.string.h6);
            spil.setText(R.string.described6);
            ic_zodiac.setImageResource(R.drawable.ic_zod6);
            youUsersZodiac.setImageResource(R.drawable.ic_zod6);
            signs.setText(R.string.signs6);
            progres(93,93,97,6);
        }
        if(st>=9.24 && st<=10.23){
            status.setText(R.string.h7);
            spil.setText(R.string.described7);
            ic_zodiac.setImageResource(R.drawable.ic_zod11);
            youUsersZodiac.setImageResource(R.drawable.ic_zod11);
            signs.setText(R.string.signs7);
            progres(93,92,98,7);
        }
        if(st>=10.24 && st<=11.22){
            status.setText(R.string.h8);
            spil.setText(R.string.described8);
            ic_zodiac.setImageResource(R.drawable.ic_zod12);
            youUsersZodiac.setImageResource(R.drawable.ic_zod12);
            signs.setText(R.string.signs8);
            progres(93,91,99,8);
        }
        if(st>=11.23 && st<=12.21){
            status.setText(R.string.h9);
            spil.setText(R.string.described9);
            ic_zodiac.setImageResource(R.drawable.ic_zod10);
            youUsersZodiac.setImageResource(R.drawable.ic_zod10);
            signs.setText(R.string.signs9);
            progres(93,90,98,9);
        }
        if(st>=12.22 && st<=1.20){
            status.setText(R.string.h10);
            spil.setText(R.string.described10);
            ic_zodiac.setImageResource(R.drawable.ic_zod2);
            youUsersZodiac.setImageResource(R.drawable.ic_zod2);
            signs.setText(R.string.signs10);
            progres(93,89,97,10);
        }
        if(st>=1.21 && st<=2.20){
            status.setText(R.string.h11);
            spil.setText(R.string.described11);
            ic_zodiac.setImageResource(R.drawable.ic_zod8);
            youUsersZodiac.setImageResource(R.drawable.ic_zod8);
            signs.setText(R.string.signs11);
            progres(93,94,96,11);
        }
        if(st>=2.21 && st<=3.20){
            status.setText(R.string.h12);
            spil.setText(R.string.described12);
            ic_zodiac.setImageResource(R.drawable.ic_zod1);
            youUsersZodiac.setImageResource(R.drawable.ic_zod1);
            signs.setText(R.string.signs12);
            progres(93,94,95,12);
        }
        if(floor=="1") {
            lol2.setText(R.string.txt4);
            lol3.setText(R.string.txt5);
            }else{
            lol2.setText(R.string.txt5);
            lol3.setText(R.string.txt4);
        }

        youstatus.setText(status.getText());
        signsTwo.setText(signs.getText());
        intes.setText(""+(st+70)+"%");
        lifeCout.setText(""+(12-hr+Integer.parseInt(floor)));
        bonusCout.setText(""+(22-hr+Integer.parseInt(floor)));
        happyCout.setText(""+(14-(int)st+Integer.parseInt(floor)));
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void progres(int love,int sex,int kars,int a) {
        this.stlove.setText("" + (love - data));
        this.stsex.setText("" + (sex - data));
        this.kars.setText("" + (kars - data));
        this.love.setProgress(love - data);
        this.sex.setProgress(sex - data);
        this.kar.setProgress(kars - data);
        hr = a;
        switch (data + a) {
            case (1):
        today.setText(R.string.go1);
        tommorow.setText(R.string.go2);
                break;
            case (2):
        today.setText(R.string.go2);
        tommorow.setText(R.string.go3);
                break;
            case (3):
        today.setText(R.string.go3);
        tommorow.setText(R.string.go4);
                break;
            case (4):
        today.setText(R.string.go4);
        tommorow.setText(R.string.go5);
                break;
            case (5):
        today.setText(R.string.go5);
        tommorow.setText(R.string.go6);
                break;
            case (6):
        today.setText(R.string.go6);
        tommorow.setText(R.string.go7);
                break;
            case (7):
        today.setText(R.string.go7);
        tommorow.setText(R.string.go8);
                break;
            case (8):
        today.setText(R.string.go8);
        tommorow.setText(R.string.go9);
                break;
            case (9):
        today.setText(R.string.go9);
        tommorow.setText(R.string.go10);
                break;
            case (10):
        today.setText(R.string.go10);
        tommorow.setText(R.string.go11);
                break;
            case (11):
        today.setText(R.string.go11);
        tommorow.setText(R.string.go12);
                break;
            case (12):
        today.setText(R.string.go12);
        tommorow.setText(R.string.go13);
                break;
            case (13):
        today.setText(R.string.go13);
        tommorow.setText(R.string.go14);
                break;
            case (14):
        today.setText(R.string.go14);
        tommorow.setText(R.string.go15);
                break;
            case (15):
        today.setText(R.string.go15);
        tommorow.setText(R.string.go16);
                break;
            case (16):
        today.setText(R.string.go16);
        tommorow.setText(R.string.go17);
                break;
            case (17):
        today.setText(R.string.go17);
        tommorow.setText(R.string.go18);
                break;
            case (18):
        today.setText(R.string.go18);
        tommorow.setText(R.string.go19);
                break;
            case (19):
        today.setText(R.string.go19);
        tommorow.setText(R.string.go20);
                break;
            case (20):
        today.setText(R.string.go20);
        tommorow.setText(R.string.go21);
                break;
            case (21):
        today.setText(R.string.go21);
        tommorow.setText(R.string.go22);
                break;
            case (22):
        today.setText(R.string.go22);
        tommorow.setText(R.string.go23);
                break;
            case (23):
        today.setText(R.string.go23);
        tommorow.setText(R.string.go24);
                break;
            case (24):
        today.setText(R.string.go24);
        tommorow.setText(R.string.go25);
                break;
            case (25):
        today.setText(R.string.go25);
        tommorow.setText(R.string.go26);
                break;
            case (26):
        today.setText(R.string.go26);
        tommorow.setText(R.string.go27);
                break;
            case (27):
        today.setText(R.string.go27);
        tommorow.setText(R.string.go28);
                break;
            case (28):
        today.setText(R.string.go28);
        tommorow.setText(R.string.go29);
                break;
            case (29):
        today.setText(R.string.go29);
        tommorow.setText(R.string.go30);
                break;
            case (30):
        today.setText(R.string.go30);
        tommorow.setText(R.string.go31);
                break;
            case (31):
        today.setText(R.string.go31);
        tommorow.setText(R.string.go32);
                break;
            case (32):
        today.setText(R.string.go32);
        tommorow.setText(R.string.go33);
                break;
            case (33):
         today.setText(R.string.go33);
         tommorow.setText(R.string.go34);
                break;
            case (34):
         today.setText(R.string.go34);
         tommorow.setText(R.string.go35);
                break;
            case (35):
         today.setText(R.string.go35);
         tommorow.setText(R.string.go36);
                break;
            case (36):
         today.setText(R.string.go36);
         tommorow.setText(R.string.go37);
                break;
            case (37):
         today.setText(R.string.go37);
         tommorow.setText(R.string.go38);
                break;
            case (38):
         today.setText(R.string.go38);
         tommorow.setText(R.string.go39);
                break;
            case (39):
         today.setText(R.string.go39);
         tommorow.setText(R.string.go40);
                break;
            case (40):
         today.setText(R.string.go40);
         tommorow.setText(R.string.go41);
                break;
            case (41):
         today.setText(R.string.go41);
         tommorow.setText(R.string.go42);
                break;
            case (42):
         today.setText(R.string.go42);
         tommorow.setText(R.string.go43);
                break;
            case (43):
         today.setText(R.string.go43);
         tommorow.setText(R.string.go44);
                break;
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_history:
                    history.setVisibility(View.VISIBLE);
                    home.setVisibility(View.GONE);
                    cout.setVisibility(View.GONE);
                    seting.setVisibility(View.GONE);
                    loves.setVisibility(View.GONE);
                    history.startAnimation(fadein);
                    loves.clearAnimation();
                    seting.clearAnimation();
                    home.clearAnimation();
                    cout.clearAnimation();
                    return true;
                case R.id.navigation_hand:
                    home.setVisibility(View.VISIBLE);
                    history.setVisibility(View.GONE);
                    seting.setVisibility(View.GONE);
                    loves.setVisibility(View.GONE);
                    cout.setVisibility(View.GONE);
                    home.startAnimation(fadein);
                    loves.clearAnimation();
                    history.clearAnimation();
                    cout.clearAnimation();
                    seting.clearAnimation();

            if(PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)  && stE==false){
                    mCamera.startPreview();
                }else  if(PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) && stE==true)
            {
                mCamera = Camera.open();
                mCamera.setDisplayOrientation(90);
                mPreview = new CameraPreview(myContext, mCamera);
                cameraPreview.addView(mPreview);
                mCamera.startPreview();
                stE=false;
            }

                    return true;
                case R.id.navigation_vs:
                    loves.setVisibility(View.VISIBLE);
                    history.setVisibility(View.GONE);
                    home.setVisibility(View.GONE);
                    cout.setVisibility(View.GONE);
                    seting.setVisibility(View.GONE);
                    loves.startAnimation(fadein);
                    history.clearAnimation();
                    home.clearAnimation();
                    cout.clearAnimation();
                    seting.clearAnimation();
                    if (dial==false)
                    openDialog();
                    dial=true;
                    return true;
                case R.id.navigation_cout:
                    cout.setVisibility(View.VISIBLE);
                    loves.setVisibility(View.GONE);
                    history.setVisibility(View.GONE);
                    home.setVisibility(View.GONE);
                    seting.setVisibility(View.GONE);
                    cout.startAnimation(fadein);
                    history.clearAnimation();
                    home.clearAnimation();
                    loves.clearAnimation();
                    seting.clearAnimation();
                    return true;
                case R.id.navigation_setting:
                    seting.setVisibility(View.VISIBLE);
                    history.setVisibility(View.GONE);
                    home.setVisibility(View.GONE);
                    loves.setVisibility(View.GONE);
                    cout.setVisibility(View.GONE);
                    seting.startAnimation(fadein);
                    loves.clearAnimation();
                    history.clearAnimation();
                    cout.clearAnimation();
                    home.clearAnimation();
                    return true;
            }
            return false;
        }
    };

    public void en(View view) {
        lan = 1;
    }

    public void ua(View view) {
        lan = 2;
    }

    public void ru(View view) {
        lan = 3;
    }

    public void Start(View view) {
        if(cameraSet==0) {
            cameraPreview.setVisibility(View.GONE);
            handfon.setVisibility(View.GONE);
            start.setVisibility(View.GONE);
            load.setVisibility(View.VISIBLE);
            mCountTime = new CountDownTimer(5000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    r = rand.nextInt(11);
                    switch (r) {
                        case (1):herom.setText(R.string.hand1);
                        break;
                        case (2):herom.setText(R.string.hand2);
                            break;
                        case (3):herom.setText(R.string.hand3);
                            break;
                        case (4):herom.setText(R.string.hand4);
                            break;
                        case (5):herom.setText(R.string.hand5);
                            break;
                        case (6):herom.setText(R.string.hand6);
                            break;
                        case (7):herom.setText(R.string.hand7);
                            break;
                        case (8):herom.setText(R.string.hand8);
                            break;
                        case (9):herom.setText(R.string.hand9);
                            break;
                        case (10):herom.setText(R.string.hand10);
                            break;
                    }
                    load.setVisibility(View.GONE);
                    home.startAnimation(fadein);
                    herom.setVisibility(View.VISIBLE);
                    herom2.setVisibility(View.VISIBLE);
                    start.setVisibility(View.VISIBLE);
                    start.setBackgroundResource(R.drawable.ic_refresh);
                    cameraSet=1;
                }
            }.start();
        }
        if(cameraSet==1) {
            cameraPreview.setVisibility(View.VISIBLE);
            handfon.setVisibility(View.VISIBLE);
            start.setVisibility(View.VISIBLE);
            herom.setVisibility(View.GONE);
            herom2.setVisibility(View.GONE);
            load.setVisibility(View.GONE);
            start.setBackgroundResource(R.drawable.handbut);
            cameraSet=0;
        }
        }

    @Override
    public void applyTexts(String username, String password) {
    }

    public void SaveSet(View view) {
        final double st = Double.parseDouble(sPref.getString("saved_text", "3.21"));

        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        onDateSet(year,month,day);

        radioFloor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.man:
                        floor = "1";
                        StartStatus(st);
                        Log.i("Start",""+floor);
                        break;
                    case R.id.girl:
                        floor = "0";
                        StartStatus(st);
                        Log.i("Start",""+floor);
                        break;
                }
            }
        });


        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("floor", floor);
        ed.commit();
        StartStatus(st);


    }

    public void onDateSet(int year, int month, int day) {
        String date = month + "/" + day + "/" + year;
        String months = month+1 + "." + day;
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("saved_text", months);
        ed.commit();
    }




    private int findFrontFacingCamera() {

        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                cameraId = i;
                cameraFront = true;
                break;
            }
        }
        return cameraId;

    }

    private int findBackFacingCamera() {
        int cameraId = -1;
        //Search for the back facing camera
        //get the number of cameras
        int numberOfCameras = Camera.getNumberOfCameras();
        //for every camera check
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                cameraId = i;
                cameraFront = false;
                break;

            }

        }
        return cameraId;
    }

    public void onResume() {
        super.onResume();
        if(	PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) && stE==false) {
            if (mCamera == null) {
                mCamera = Camera.open();
                mCamera.setDisplayOrientation(90);
                mPreview.refreshCamera(mCamera);
                Log.d("nu", "null");
            } else {
                Log.d("nu", "no null");
            }
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        //when on Pause, release camera in order to be used from other applications
      /*  if(	PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)) {
            releaseCamera();
        }*/

    }

    private void releaseCamera() {
        // stop and release camera
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }


}


