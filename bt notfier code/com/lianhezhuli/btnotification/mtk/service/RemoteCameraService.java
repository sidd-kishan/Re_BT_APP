/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  com.lianhezhuli.btnotification.mtk.data.Util
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  org.greenrobot.eventbus.EventBus
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.lianhezhuli.btnotification.mtk.data.Util;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.greenrobot.eventbus.EventBus;

public class RemoteCameraService
extends BroadcastReceiver {
    public static final String BT_REMOTECAMERA_BROADCAST_ACTION = "com.lianhezhuli.RemoteCamera";
    public static final String BT_REMOTECAMERA_CAPTURE_ACTION = "com.lianhezhuli.RemoteCamera.CAPTURE";
    public static final String BT_REMOTECAMERA_EXIT_ACTION = "com.lianhezhuli.RemoteCamera.EXIT";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    private static final String TAG = "REMOTECAMERAService";
    public static boolean isIntheProgressOfExit;
    public static boolean isLaunched;
    public static boolean needPreview;
    private String mRemoteCameraCommand = null;

    public RemoteCameraService() {
        Log.i((String)TAG, (String)"RemoteCameraService(), RemoteCameraService created!");
    }

    public void onReceive(Context context, Intent object) {
        needPreview = false;
        CharSequence charSequence = object.getAction();
        MainService mainService = MainService.getInstance();
        if (!BT_REMOTECAMERA_BROADCAST_ACTION.equals(charSequence)) return;
        try {
            charSequence = new String(object.getByteArrayExtra(EXTRA_DATA), "UTF-8");
            this.mRemoteCameraCommand = charSequence;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        object = this.mRemoteCameraCommand.split(" ");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("RemoteCameraService onReceive(), commands :");
        ((StringBuilder)charSequence).append(Arrays.toString((Object[])object));
        Log.i((String)TAG, (String)((StringBuilder)charSequence).toString());
        int n = Integer.parseInt((String)object[0]);
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) return;
                    Log.i((String)TAG, (String)"needPreview = true");
                    needPreview = true;
                } else {
                    if (isLaunched) {
                        isIntheProgressOfExit = true;
                    }
                    object = new Intent();
                    object.setAction(BT_REMOTECAMERA_EXIT_ACTION);
                    context.sendBroadcast((Intent)object);
                }
            } else {
                object = new Intent();
                object.setAction(BT_REMOTECAMERA_CAPTURE_ACTION);
                context.sendBroadcast((Intent)object);
            }
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("isLaunched: ");
            ((StringBuilder)object).append(isLaunched);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            object = new StringBuilder();
            ((StringBuilder)object).append("isIntheProgressOfExit: ");
            ((StringBuilder)object).append(isIntheProgressOfExit);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            if (Util.isScreenLocked((Context)context)) {
                mainService.sendCAPCResult("-1 0 ");
            } else if (!Util.isScreenOn((Context)context)) {
                mainService.sendCAPCResult("-1 0 ");
            } else if (isLaunched && !isIntheProgressOfExit) {
                mainService.sendCAPCResult("1 0 ");
            } else if (isIntheProgressOfExit) {
                mainService.sendCAPCResult("-1 0 ");
            } else {
                EventBus.getDefault().post((Object)"action_open_camera");
            }
        }
    }
}
