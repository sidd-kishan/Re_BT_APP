/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.JsonReader
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzah
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzah;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONException;

final class zzae
implements zzfrk {
    private final zzcbj zza;

    zzae(zzcbj zzcbj2) {
        this.zza = zzcbj2;
    }

    public final zzfsm zza(Object object) {
        zzcbj zzcbj2 = this.zza;
        object = new zzah(new JsonReader((Reader)new InputStreamReader((InputStream)object)));
        zzcbj2 = zzcbj2.zza;
        try {
            ((zzah)object).zzb = zzt.zzc().zzl((Bundle)zzcbj2).toString();
        }
        catch (JSONException jSONException) {
            ((zzah)object).zzb = "{}";
        }
        return zzfsd.zza((Object)object);
    }
}
