/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.hardware.Camera
 *  android.hardware.Camera$PictureCallback
 *  android.os.Environment
 *  android.provider.MediaStore$Images$Media
 *  android.util.Log
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import com.lianhezhuli.btnotification.function.device.remotecamera.Preview;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/*
 * Exception performing whole class analysis ignored.
 */
private final class Preview.TakePictureCallback
implements Camera.PictureCallback {
    final Preview this$0;

    private Preview.TakePictureCallback(Preview preview) {
        this.this$0 = preview;
    }

    private Bitmap sendCaptureData(byte[] object) {
        int n;
        MainService mainService = MainService.getInstance();
        int n2 = (object = (Object)BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((byte[])object).length)).getWidth();
        int n3 = n2 > (n = object.getHeight()) ? n2 / 170 : n / 170;
        double d = n3;
        Object object2 = new Matrix();
        if (Preview.access$300((Preview)this.this$0) == 0 || Preview.access$300((Preview)this.this$0) == 180) {
            object2.postRotate((float)(Preview.access$300((Preview)this.this$0) + 90));
        }
        if (Preview.access$300((Preview)this.this$0) == 90 || Preview.access$300((Preview)this.this$0) == 270) {
            object2.postRotate((float)(Preview.access$300((Preview)this.this$0) - 90));
        }
        double d2 = n2;
        Double.isNaN(d2);
        n3 = (int)(d2 / d);
        d2 = n;
        Double.isNaN(d2);
        n = (int)(d2 / d);
        object = Bitmap.createBitmap((Bitmap)Bitmap.createScaledBitmap((Bitmap)object, (int)n3, (int)n, (boolean)false), (int)0, (int)0, (int)n3, (int)n, (Matrix)object2, (boolean)true);
        object2 = new ByteArrayOutputStream();
        object.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)object2);
        this.this$0.mCaptureJpegData = ((ByteArrayOutputStream)object2).toByteArray();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(String.valueOf(2));
        ((StringBuilder)object2).append(" 1 ");
        ((StringBuilder)object2).append(String.valueOf(this.this$0.mCaptureJpegData.length));
        ((StringBuilder)object2).append(" ");
        mainService.sendCAPCResult(((StringBuilder)object2).toString());
        mainService.sendCAPCData(this.this$0.mCaptureJpegData);
        return object;
    }

    private void sendCaptureFail() {
        MainService mainService = MainService.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(-1));
        stringBuilder.append(" 0 ");
        mainService.sendCAPCResult(stringBuilder.toString());
    }

    public void onPictureTaken(byte[] object, Camera camera) {
        Log.i((String)"REMOTECAMERAService", (String)"onPictureTaken");
        if ("mounted".equals(Environment.getExternalStorageState()) && Util.getAvailableStore((String)Environment.getExternalStorageDirectory().getPath()) >= 2000L) {
            this.sendCaptureData((byte[])object);
            Object object2 = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)((byte[])object).length);
            object = new Matrix();
            if (Preview.access$300((Preview)this.this$0) == 0 || Preview.access$300((Preview)this.this$0) == 180) {
                object.postRotate((float)(Preview.access$300((Preview)this.this$0) + 90));
            }
            if (Preview.access$300((Preview)this.this$0) == 90 || Preview.access$300((Preview)this.this$0) == 270) {
                object.postRotate((float)(Preview.access$300((Preview)this.this$0) - 90));
            }
            object = Bitmap.createBitmap((Bitmap)object2, (int)0, (int)0, (int)object2.getWidth(), (int)object2.getHeight(), (Matrix)object, (boolean)true);
            ContentResolver contentResolver = Preview.access$400((Preview)this.this$0).getContentResolver();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(System.currentTimeMillis());
            ((StringBuilder)object2).append(".jpg");
            MediaStore.Images.Media.insertImage((ContentResolver)contentResolver, (Bitmap)object, (String)((StringBuilder)object2).toString(), (String)"Image of RemoteCapture");
        } else {
            this.sendCaptureFail();
        }
        camera.setDisplayOrientation(0);
        camera.startPreview();
    }
}
