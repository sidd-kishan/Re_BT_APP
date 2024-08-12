/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.hardware.Camera
 *  android.hardware.Camera$PreviewCallback
 *  android.util.Log
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.lianhezhuli.btnotification.mtk.service.RemoteCameraService
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.util.Log;
import com.lianhezhuli.btnotification.function.device.remotecamera.Preview;
import com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.lianhezhuli.btnotification.mtk.service.RemoteCameraService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class Preview.1
implements Camera.PreviewCallback {
    final Preview this$0;

    Preview.1(Preview preview) {
        this.this$0 = preview;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public void onPreviewFrame(byte[] var1_1, Camera var2_3) {
        synchronized (this) {
            block9: {
                if (RemoteCameraService.needPreview == false) return;
                if (Preview.access$500((Preview)this.this$0) == 0L) {
                    Preview.access$502((Preview)this.this$0, (long)System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - Preview.access$500((Preview)this.this$0) <= 333L) ** GOTO lbl74
                Log.i((String)"CameraPreview", (String)"vedio data come ...");
                Preview.access$502((Preview)this.this$0, (long)System.currentTimeMillis());
                var2_3 = var2_3.getParameters();
                var7_4 = var2_3.getPreviewFormat();
                var9_5 = var2_3.getPreviewSize().width;
                var8_6 = var2_3.getPreviewSize().height;
                var10_7 = new Rect(0, 0, var9_5, var8_6);
                var2_3 = new YuvImage((byte[])var1_1, var7_4, var9_5, var8_6, null);
                var1_1 = new ByteArrayOutputStream;
                var1_1();
                var2_3.compressToJpeg(var10_7, 70, (OutputStream)var1_1);
                var2_3 = BitmapFactory.decodeByteArray((byte[])var1_1.toByteArray(), (int)0, (int)var1_1.size());
                if (var9_5 > var8_6) {
                    var7_4 = var9_5 / 170;
                }
                ** GOTO lbl-1000
lbl29:
                // 2 sources

                while (true) {
                    var3_8 = var7_4;
                    ** GOTO lbl34
                    break;
                }
lbl-1000:
                // 1 sources

                {
                    var7_4 = var8_6 / 170;
                    ** continue;
lbl34:
                    // 1 sources

                    var1_1 = new Matrix();
                    Preview.access$302((Preview)this.this$0, (int)RemoteCamera.ratation);
                    if (Preview.access$300((Preview)this.this$0) == 0 || Preview.access$300((Preview)this.this$0) == 180) {
                        var1_1.postRotate((float)(Preview.access$300((Preview)this.this$0) + 90));
                    }
                    if (Preview.access$300((Preview)this.this$0) != 90 && Preview.access$300((Preview)this.this$0) != 270) break block9;
                    var1_1.postRotate((float)(Preview.access$300((Preview)this.this$0) - 90));
                }
            }
            var5_9 = var9_5;
            Double.isNaN(var5_9);
            var7_4 = (int)(var5_9 / var3_8);
            var5_9 = var8_6;
            Double.isNaN(var5_9);
            var8_6 = (int)(var5_9 / var3_8);
            {
                block10: {
                    var2_3 = Bitmap.createScaledBitmap((Bitmap)var2_3, (int)var7_4, (int)var8_6, (boolean)false);
                    var2_3 = Bitmap.createBitmap((Bitmap)var2_3, (int)0, (int)0, (int)var2_3.getWidth(), (int)var2_3.getHeight(), (Matrix)var1_1, (boolean)true);
                    var1_1 = new ByteArrayOutputStream();
                    var2_3.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)var1_1);
                    this.this$0.mPreviewJpegData = var1_1.toByteArray();
                    var1_1 = new StringBuilder();
                    var1_1.append(String.valueOf(4));
                    var1_1.append(" 1 ");
                    var1_1.append(String.valueOf(this.this$0.mPreviewJpegData.length));
                    var1_1.append(" ");
                    var1_1 = var1_1.toString();
                    var2_3 = MainService.getInstance();
                    var2_3.sendCAPCResult((String)var1_1);
                    var2_3.sendCAPCData(this.this$0.mPreviewJpegData);
                    Log.i((String)"CameraPreview", (String)"vedio data has sent ...");
                    break block10;
lbl74:
                    // 1 sources

                    Log.i((String)"CameraPreview", (String)"vedio data did not need to send ...");
                }
                return;
            }
        }
    }
}
