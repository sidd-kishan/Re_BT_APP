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
 *  com.google.android.gms.internal.ads.zzdxn
 *  com.google.android.gms.internal.ads.zzdya
 *  com.google.android.gms.internal.ads.zzdyb
 *  com.google.android.gms.internal.ads.zzdyc
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
import com.google.android.gms.internal.ads.zzdxn;
import com.google.android.gms.internal.ads.zzdya;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyc;
import javax.annotation.Nullable;

public final class zzdxo
implements SensorEventListener {
    @Nullable
    private final SensorManager zza;
    @Nullable
    private final Sensor zzb;
    private float zzc = 0.0f;
    private Float zzd = Float.valueOf(0.0f);
    private long zze = zzt.zzj().currentTimeMillis();
    private int zzf = 0;
    private boolean zzg = false;
    private boolean zzh = false;
    @Nullable
    private zzdxn zzi = null;
    private boolean zzj = false;

    zzdxo(Context context) {
        context = (SensorManager)context.getSystemService("sensor");
        this.zza = context;
        if (context != null) {
            this.zzb = context.getDefaultSensor(4);
            return;
        }
        this.zzb = null;
    }

    public final void onAccuracyChanged(Sensor sensor, int n) {
    }

    public final void onSensorChanged(SensorEvent object) {
        int n;
        zzbjd zzbjd2 = zzbjl.zzgy;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        long l = zzt.zzj().currentTimeMillis();
        long l2 = this.zze;
        zzbjd2 = zzbjl.zzgA;
        if (l2 + (long)((Integer)zzbet.zzc().zzc(zzbjd2)).intValue() < l) {
            this.zzf = 0;
            this.zze = l;
            this.zzg = false;
            this.zzh = false;
            this.zzc = this.zzd.floatValue();
        }
        float f = ((SensorEvent)object).values[1];
        object = Float.valueOf(this.zzd.floatValue() + f * 4.0f);
        this.zzd = object;
        f = ((Float)object).floatValue();
        float f2 = this.zzc;
        object = zzbjl.zzgz;
        if (f > f2 + ((Float)zzbet.zzc().zzc((zzbjd)object)).floatValue()) {
            this.zzc = this.zzd.floatValue();
            this.zzh = true;
        } else {
            f2 = this.zzd.floatValue();
            f = this.zzc;
            object = zzbjl.zzgz;
            if (f2 < f - ((Float)zzbet.zzc().zzc((zzbjd)object)).floatValue()) {
                this.zzc = this.zzd.floatValue();
                this.zzg = true;
            }
        }
        if (this.zzd.isInfinite()) {
            this.zzd = Float.valueOf(0.0f);
            this.zzc = 0.0f;
        }
        if (!this.zzg) return;
        if (!this.zzh) return;
        com.google.android.gms.ads.internal.util.zze.zza((String)"Flick detected.");
        this.zze = l;
        this.zzf = n = this.zzf + 1;
        this.zzg = false;
        this.zzh = false;
        zzbjd2 = this.zzi;
        if (zzbjd2 == null) return;
        object = zzbjl.zzgB;
        if (n != (Integer)zzbet.zzc().zzc((zzbjd)object)) return;
        object = (zzdyc)zzbjd2;
        object.zzk((zzbgq)new zzdya((zzdyc)object), zzdyb.zzc);
    }

    public final void zza(zzdxn zzdxn2) {
        this.zzi = zzdxn2;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zzb() {
        SensorManager sensorManager;
        // MONITORENTER : this
        zzbjd zzbjd2 = zzbjl.zzgy;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            // MONITOREXIT : this
            return;
        }
        if (!this.zzj && (sensorManager = this.zza) != null && (zzbjd2 = this.zzb) != null) {
            sensorManager.registerListener((SensorEventListener)this, (Sensor)zzbjd2, 2);
            this.zzj = true;
            com.google.android.gms.ads.internal.util.zze.zza((String)"Listening for flick gestures.");
        }
        // MONITOREXIT : this
        if (this.zza != null) {
            if (this.zzb != null) return;
        }
        com.google.android.gms.ads.internal.util.zze.zzi((String)"Flick detection failed to initialize. Failed to obtain gyroscope.");
    }

    public final void zzc() {
        synchronized (this) {
            if (!this.zzj) return;
            SensorManager sensorManager = this.zza;
            if (sensorManager == null) return;
            Sensor sensor = this.zzb;
            if (sensor == null) return;
            sensorManager.unregisterListener((SensorEventListener)this, sensor);
            this.zzj = false;
            com.google.android.gms.ads.internal.util.zze.zza((String)"Stopped listening for flick gestures.");
            return;
        }
    }
}
