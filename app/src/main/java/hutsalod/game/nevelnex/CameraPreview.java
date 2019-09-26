package hutsalod.game.nevelnex;

import android.content.Context;

import android.content.res.Configuration;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {


    Camera camera;
    SurfaceHolder holder;

    public CameraPreview(Context context, Camera camera) {
        super(context);
       this.camera = camera;
       holder = getHolder();
       holder.addCallback(this);

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the activity_hologram where to draw the preview.
Camera.Parameters parans = camera.getParameters();

        if (this. getResources() .getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE)
        {

            parans.set("orientation", "portrait");
            camera.setDisplayOrientation (90);
            parans. setRotation(90);

        }
        else
        {
         parans.set("orientation", "landscape");
        camera.setDisplayOrientation (0);
        parans.setRotation (0);

        camera.setParameters(parans);
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        }catch (IOException e){
           e.printStackTrace();
        }

    }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

    }

}
