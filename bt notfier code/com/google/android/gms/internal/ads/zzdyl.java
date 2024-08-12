/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdxz
 *  com.google.android.gms.internal.ads.zzdyb
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzdyk
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdxz;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzdyk;
import javax.annotation.Nullable;

public final class zzdyl
implements SensorEventListener {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdyk zzf;
    private boolean zzg;

    zzdyl(Context context) {
        this.zza = context;
    }

    public final void onAccuracyChanged(Sensor sensor, int n) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int n;
        zzbjd zzbjd2 = zzbjl.zzgt;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        float f = sensorEvent.values[0] / 9.80665f;
        float f2 = sensorEvent.values[1] / 9.80665f;
        float f3 = sensorEvent.values[2] / 9.80665f;
        double d = Math.sqrt(f * f + f2 * f2 + f3 * f3);
        sensorEvent = zzbjl.zzgu;
        if ((float)d < ((Float)zzbet.zzc().zzc((zzbjd)sensorEvent)).floatValue()) {
            return;
        }
        long l = zzt.zzj().currentTimeMillis();
        long l2 = this.zzd;
        sensorEvent = zzbjl.zzgv;
        if (l2 + (long)((Integer)zzbet.zzc().zzc((zzbjd)sensorEvent)).intValue() > l) {
            return;
        }
        l2 = this.zzd;
        sensorEvent = zzbjl.zzgw;
        if (l2 + (long)((Integer)zzbet.zzc().zzc((zzbjd)sensorEvent)).intValue() < l) {
            this.zze = 0;
        }
        com.google.android.gms.ads.internal.util.zze.zza((String)"Shake detected.");
        this.zzd = l;
        this.zze = n = this.zze + 1;
        sensorEvent = this.zzf;
        if (sensorEvent == null) return;
        zzbjd2 = zzbjl.zzgx;
        if (n != (Integer)zzbet.zzc().zzc(zzbjd2)) return;
        sensorEvent = (zzdyc)sensorEvent;
        sensorEvent.zzk((zzbgq)new zzdxz((zzdyc)sensorEvent), zzdyb.zzc);
    }

    public final void zza(zzdyk zzdyk2) {
        this.zzf = zzdyk2;
    }

    public final void zzb() {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzgt;
            if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                return;
            }
            if (this.zzb == null) {
                zzbjd2 = (SensorManager)this.zza.getSystemService("sensor");
                this.zzb = zzbjd2;
                if (zzbjd2 == null) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Shake detection failed to initialize. Failed to obtain accelerometer.");
                    return;
                }
                this.zzc = zzbjd2.getDefaultSensor(1);
            }
            if (this.zzg) return;
            zzbjd2 = this.zzb;
            if (zzbjd2 == null) return;
            Sensor sensor = this.zzc;
            if (sensor == null) return;
            zzbjd2.registerListener((SensorEventListener)this, sensor, 2);
            long l = zzt.zzj().currentTimeMillis();
            zzbjd2 = zzbjl.zzgv;
            this.zzd = l - (long)((Integer)zzbet.zzc().zzc(zzbjd2)).intValue();
            this.zzg = true;
            com.google.android.gms.ads.internal.util.zze.zza((String)"Listening for shake gestures.");
            return;
        }
    }

    public final void zzc() {
        synchronized (this) {
            if (!this.zzg) return;
            SensorManager sensorManager = this.zzb;
            if (sensorManager != null) {
                sensorManager.unregisterListener((SensorEventListener)this, this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza((String)"Stopped listening for shake gestures.");
            }
            this.zzg = false;
            return;
        }
    }
}
