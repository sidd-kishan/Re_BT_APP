/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.view.Display
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzciw
 *  com.google.android.gms.internal.ads.zzcix
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzciw;
import com.google.android.gms.internal.ads.zzcix;
import com.google.android.gms.internal.ads.zzfla;

final class zzciy
implements SensorEventListener {
    private final SensorManager zza;
    private final Object zzb;
    private final Display zzc;
    private final float[] zzd;
    private final float[] zze;
    private float[] zzf;
    private Handler zzg;
    private zzcix zzh;

    zzciy(Context context) {
        this.zza = (SensorManager)context.getSystemService("sensor");
        this.zzc = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzb = new Object();
    }

    public final void onAccuracyChanged(Sensor sensor, int n) {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onSensorChanged(SensorEvent object) {
        Object object2;
        block12: {
            block13: {
                object2 = object.values;
                if (object2[0] == 0.0f && object2[1] == 0.0f) {
                    if (object2[2] == 0.0f) return;
                }
                object = this.zzb;
                synchronized (object) {
                    if (this.zzf == null) {
                        this.zzf = new float[9];
                    }
                }
                SensorManager.getRotationMatrixFromVector((float[])this.zzd, (float[])object2);
                int n = this.zzc.getRotation();
                if (n == 1) break block13;
                if (n != 2) {
                    if (n != 3) {
                        System.arraycopy(this.zzd, 0, this.zze, 0, 9);
                        break block12;
                    } else {
                        SensorManager.remapCoordinateSystem((float[])this.zzd, (int)130, (int)1, (float[])this.zze);
                    }
                    break block12;
                } else {
                    SensorManager.remapCoordinateSystem((float[])this.zzd, (int)129, (int)130, (float[])this.zze);
                }
                break block12;
            }
            SensorManager.remapCoordinateSystem((float[])this.zzd, (int)2, (int)129, (float[])this.zze);
        }
        object = this.zze;
        SensorEvent sensorEvent = object[1];
        object[1] = object[3];
        object[3] = sensorEvent;
        sensorEvent = object[2];
        object[2] = object[6];
        object[6] = sensorEvent;
        sensorEvent = object[5];
        object[5] = object[7];
        object[7] = sensorEvent;
        object2 = this.zzb;
        synchronized (object2) {
            System.arraycopy(this.zze, 0, this.zzf, 0, 9);
        }
        object = this.zzh;
        if (object == null) return;
        object.zza();
    }

    final void zza() {
        if (this.zzg != null) {
            return;
        }
        Sensor sensor = this.zza.getDefaultSensor(11);
        if (sensor == null) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        handlerThread = new zzfla(handlerThread.getLooper());
        this.zzg = handlerThread;
        if (this.zza.registerListener((SensorEventListener)this, sensor, 0, (Handler)handlerThread)) return;
        com.google.android.gms.ads.internal.util.zze.zzf((String)"SensorManager.registerListener failed.");
        this.zzb();
    }

    final void zzb() {
        if (this.zzg == null) {
            return;
        }
        this.zza.unregisterListener((SensorEventListener)this);
        this.zzg.post((Runnable)new zzciw(this));
        this.zzg = null;
    }

    final void zzc(zzcix zzcix2) {
        this.zzh = zzcix2;
    }

    final boolean zzd(float[] fArray) {
        Object object = this.zzb;
        synchronized (object) {
            float[] fArray2 = this.zzf;
            if (fArray2 == null) {
                return false;
            }
            System.arraycopy(fArray2, 0, fArray, 0, 9);
            return true;
        }
    }
}
