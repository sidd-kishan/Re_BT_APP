/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbix
 *  com.google.android.gms.internal.ads.zzbiy
 *  com.google.android.gms.internal.ads.zzbiz
 *  com.google.android.gms.internal.ads.zzbja
 *  com.google.android.gms.internal.ads.zzbjb
 *  com.google.android.gms.internal.ads.zzbjc
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzbiy;
import com.google.android.gms.internal.ads.zzbiz;
import com.google.android.gms.internal.ads.zzbja;
import com.google.android.gms.internal.ads.zzbjb;
import com.google.android.gms.internal.ads.zzbjc;
import org.json.JSONObject;

public abstract class zzbjd<T> {
    private final int zza;
    private final String zzb;
    private final T zzc;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzbjd(int n, String string, Object object, zzbjc zzbjc2) {
        this.zza = n;
        this.zzb = string;
        this.zzc = object;
        zzbet.zzb().zza(this);
    }

    public static zzbjd<Boolean> zzg(int n, String string, Boolean bl) {
        return new zzbix(n, string, bl);
    }

    public static zzbjd<Integer> zzh(int n, String string, int n2) {
        return new zzbiy(1, string, Integer.valueOf(n2));
    }

    public static zzbjd<Long> zzi(int n, String string, long l) {
        return new zzbiz(1, string, Long.valueOf(l));
    }

    public static zzbjd<Float> zzj(int n, String string, float f) {
        return new zzbja(1, string, Float.valueOf(f));
    }

    public static zzbjd<String> zzk(int n, String string, String string2) {
        return new zzbjb(1, string, string2);
    }

    public static zzbjd<String> zzl(int n, String object) {
        object = zzbjd.zzk(1, "gads:sdk_core_constants:experiment_id", null);
        zzbet.zzb().zzb((zzbjd)object);
        return object;
    }

    public abstract T zza(Bundle var1);

    public abstract void zzb(SharedPreferences.Editor var1, T var2);

    protected abstract T zzc(JSONObject var1);

    protected abstract T zzd(SharedPreferences var1);

    public final String zze() {
        return this.zzb;
    }

    public final T zzf() {
        return this.zzc;
    }

    public final int zzm() {
        return this.zza;
    }
}
