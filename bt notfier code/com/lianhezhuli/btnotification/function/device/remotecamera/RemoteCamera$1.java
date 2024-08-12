/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.os.Handler;
import android.os.Message;
import com.lianhezhuli.btnotification.function.device.remotecamera.RemoteCamera;

class RemoteCamera.1
extends Handler {
    final RemoteCamera this$0;

    RemoteCamera.1(RemoteCamera remoteCamera) {
        this.this$0 = remoteCamera;
    }

    public void handleMessage(Message message) {
        if (message.what != 123) return;
        int n = message.arg1;
        if (n > 45 && n < 135) {
            RemoteCamera.ratation = 270;
        } else if (n > 135 && n < 225) {
            RemoteCamera.ratation = 180;
        } else if (n > 225 && n < 315) {
            RemoteCamera.ratation = 90;
        } else {
            if (n <= 315 || n >= 360) {
                if (n <= 0) return;
                if (n >= 45) return;
            }
            RemoteCamera.ratation = 0;
        }
    }
}
