/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.os.Handler
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;

static class RemoteCamera.SubSensorListener
implements SensorEventListener {
    public static final int ORIENTATION_UNKNOWN = -1;
    private static final int _DATA_X = 0;
    private static final int _DATA_Y = 1;
    private static final int _DATA_Z = 2;
    private final Handler handler;

    public RemoteCamera.SubSensorListener(Handler handler) {
        this.handler = handler;
    }

    public void onAccuracyChanged(Sensor sensor, int n) {
    }

    public void onSensorChanged(SensorEvent object) {
        int n;
        object = object.values;
        SensorEvent sensorEvent = -object[0];
        SensorEvent sensorEvent2 = -object[1];
        SensorEvent sensorEvent3 = -object[2];
        if ((sensorEvent * sensorEvent + sensorEvent2 * sensorEvent2) * 4.0f >= sensorEvent3 * sensorEvent3) {
            int n2;
            n = 90 - Math.round((float)Math.atan2((double)(-sensorEvent2), (double)sensorEvent) * 57.29578f);
            while (true) {
                n2 = n;
                if (n < 360) break;
                n -= 360;
            }
            while (true) {
                n = n2;
                if (n2 < 0) {
                    n2 += 360;
                    continue;
                }
                break;
            }
        } else {
            n = -1;
        }
        if ((object = this.handler) == null) return;
        object.obtainMessage(123, n, 0).sendToTarget();
    }
}
