/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$PictureCallback
 *  android.util.Log
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.hardware.Camera;
import android.util.Log;
import com.lianhezhuli.btnotification.function.device.remotecamera.Preview;

/*
 * Exception performing whole class analysis ignored.
 */
private final class Preview.AutoFocusCallback
implements Camera.AutoFocusCallback {
    final Preview this$0;

    private Preview.AutoFocusCallback(Preview preview) {
        this.this$0 = preview;
    }

    public void onAutoFocus(boolean bl, Camera camera) {
        Log.i((String)"REMOTECAMERAService", (String)"onAutoFocus Callback");
        camera.cancelAutoFocus();
        camera.takePicture(null, null, (Camera.PictureCallback)Preview.access$200((Preview)this.this$0));
    }
}
