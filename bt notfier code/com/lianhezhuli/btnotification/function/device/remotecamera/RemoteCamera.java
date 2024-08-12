/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.Log
 *  android.view.View
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera$1
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera$SubSensorListener
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.RemoteCameraService
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Camera;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.function.device.remotecamera.Preview;
import com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.RemoteCameraService;

public class RemoteCamera
extends Activity {
    static int ratation;
    private final String TAG;
    private final Handler handler;
    private boolean isNotifiedToCloseByBTDialer = false;
    private Camera mCamera;
    private Preview mPreview;
    private final BroadcastReceiver mReceiver;
    private final SubSensorListener mSubSensorListener;
    private int numberOfCameras;
    private final MainService service = MainService.getInstance();

    public RemoteCamera() {
        this.TAG = "REMOTECAMERAService";
        1 var1_1 = new /* Unavailable Anonymous Inner Class!! */;
        this.handler = var1_1;
        this.mSubSensorListener = new SubSensorListener((Handler)var1_1);
        this.mReceiver = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ boolean access$002(RemoteCamera remoteCamera, boolean bl) {
        remoteCamera.isNotifiedToCloseByBTDialer = bl;
        return bl;
    }

    static /* synthetic */ Preview access$100(RemoteCamera remoteCamera) {
        return remoteCamera.mPreview;
    }

    private void openCamerainonResume() {
        Object object;
        try {
            object = Camera.open();
            this.mCamera = object;
            if (object == null) {
                Log.i((String)"REMOTECAMERAService", (String)"Can't open the camera");
                this.isNotifiedToCloseByBTDialer = false;
                this.finish();
            }
        }
        catch (Exception exception) {
            Log.i((String)"REMOTECAMERAService", (String)"onResume and isNotifiedToCloseByBTDialer = true");
            this.isNotifiedToCloseByBTDialer = false;
            this.finish();
        }
        this.mPreview.setCamera(this.mCamera);
        object = new StringBuilder();
        ((StringBuilder)object).append(String.valueOf(1));
        ((StringBuilder)object).append(" 0 ");
        object = ((StringBuilder)object).toString();
        this.service.sendCAPCResult((String)object);
        RemoteCameraService.isLaunched = true;
        RemoteCameraService.isIntheProgressOfExit = false;
    }

    public void finish() {
        Log.i((String)"REMOTECAMERAService", (String)"finish");
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mPreview.setCamera(null);
            this.mCamera.release();
            this.mCamera = null;
        }
        ((SensorManager)MApplication.getInstance().getSystemService("sensor")).unregisterListener((SensorEventListener)this.mSubSensorListener);
        super.finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.getWindow().addFlags(128);
        bundle = new IntentFilter("com.lianhezhuli.RemoteCamera.EXIT");
        bundle.addAction("com.lianhezhuli.RemoteCamera.CAPTURE");
        this.registerReceiver(this.mReceiver, (IntentFilter)bundle);
        bundle = (SensorManager)MApplication.getInstance().getSystemService("sensor");
        bundle.registerListener((SensorEventListener)this.mSubSensorListener, bundle.getDefaultSensor(1), 2, this.handler);
        this.requestWindowFeature(1);
        this.getWindow().addFlags(1024);
        bundle = new Preview((Context)this);
        this.mPreview = bundle;
        this.setContentView((View)bundle);
        this.numberOfCameras = Camera.getNumberOfCameras();
        bundle = new Camera.CameraInfo();
        int n = 0;
        while (n < this.numberOfCameras) {
            Camera.getCameraInfo((int)n, (Camera.CameraInfo)bundle);
            int n2 = bundle.facing;
            ++n;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(this.mReceiver);
        if (this.isNotifiedToCloseByBTDialer) {
            this.isNotifiedToCloseByBTDialer = false;
        } else {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(String.valueOf(3));
            charSequence.append(" 0 ");
            charSequence = charSequence.toString();
            this.service.sendCAPCResult((String)charSequence);
        }
        RemoteCameraService.isLaunched = false;
        RemoteCameraService.isIntheProgressOfExit = false;
    }

    protected void onPause() {
        super.onPause();
        this.finish();
        Camera camera = this.mCamera;
        if (camera == null) return;
        camera.setPreviewCallback(null);
        this.mPreview.setCamera(null);
        this.mCamera.release();
        this.mCamera = null;
    }

    protected void onResume() {
        super.onResume();
        this.openCamerainonResume();
    }
}
