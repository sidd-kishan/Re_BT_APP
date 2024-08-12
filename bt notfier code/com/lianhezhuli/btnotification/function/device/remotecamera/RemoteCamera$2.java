/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera
 *  com.lianhezhuli.btnotification.mtk.service.RemoteCameraService
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera;
import com.lianhezhuli.btnotification.mtk.service.RemoteCameraService;

/*
 * Exception performing whole class analysis ignored.
 */
class RemoteCamera.2
extends BroadcastReceiver {
    final RemoteCamera this$0;

    RemoteCamera.2(RemoteCamera remoteCamera) {
        this.this$0 = remoteCamera;
    }

    public void onReceive(Context object, Intent intent) {
        object = intent.getAction();
        if ("com.lianhezhuli.RemoteCamera.EXIT".equals(object)) {
            RemoteCamera.access$002((RemoteCamera)this.this$0, (boolean)true);
            RemoteCameraService.isIntheProgressOfExit = true;
            this.this$0.finish();
        } else {
            if (!"com.lianhezhuli.RemoteCamera.CAPTURE".equals(object)) return;
            if (RemoteCamera.access$100((RemoteCamera)this.this$0) == null) return;
            RemoteCamera.access$100((RemoteCamera)this.this$0).takePicture(RemoteCamera.ratation);
        }
    }
}
