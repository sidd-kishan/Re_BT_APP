/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzdxk
 *  com.google.android.gms.internal.ads.zzemz
 *  com.google.android.gms.internal.ads.zzenb
 *  com.google.android.gms.internal.ads.zzenc
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfmi
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzemz;
import com.google.android.gms.internal.ads.zzenb;
import com.google.android.gms.internal.ads.zzenc;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfmi;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Arrays;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class zzena
implements zzery<zzenb> {
    private final zzfsn zza;
    private final zzdtf zzb;
    private final zzdxk zzc;
    private final zzenc zzd;

    public zzena(zzfsn zzfsn2, zzdtf zzdtf2, zzdxk zzdxk2, zzenc zzenc2) {
        this.zza = zzfsn2;
        this.zzb = zzdtf2;
        this.zzc = zzdxk2;
        this.zzd = zzenc2;
    }

    public final zzfsm<zzenb> zza() {
        zzbjd zzbjd2 = zzbjl.zzaW;
        if (zzfmi.zzc((String)((String)zzbet.zzc().zzc(zzbjd2)))) return zzfsd.zza((Object)new zzenb(new Bundle(), null));
        if (this.zzd.zzb()) return zzfsd.zza((Object)new zzenb(new Bundle(), null));
        if (!this.zzc.zzm()) {
            return zzfsd.zza((Object)new zzenb(new Bundle(), null));
        }
        this.zzd.zza(true);
        return this.zza.zzb((Callable)new zzemz(this));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final /* synthetic */ zzenb zzb() throws Exception {
        zzbjd zzbjd2 = zzbjl.zzaW;
        Object object = Arrays.asList(((String)zzbet.zzc().zzc(zzbjd2)).split(";"));
        zzbjd2 = new Bundle();
        object = object.iterator();
        while (object.hasNext()) {
            JSONObject jSONObject;
            zzdtf zzdtf2;
            String string = (String)object.next();
            try {
                zzdtf2 = this.zzb;
                jSONObject = new JSONObject();
                jSONObject = zzdtf2.zzb(string, jSONObject);
                jSONObject.zzn();
                zzdtf2 = new Bundle();
            }
            catch (zzfaw zzfaw2) {}
            try {
                zzbya zzbya2 = jSONObject.zzA();
                if (zzbya2 != null) {
                    zzdtf2.putString("sdk_version", zzbya2.toString());
                }
            }
            catch (zzfaw zzfaw3) {}
            try {
                jSONObject = jSONObject.zzz();
                if (jSONObject != null) {
                    zzdtf2.putString("adapter_version", jSONObject.toString());
                }
            }
            catch (zzfaw zzfaw4) {}
            zzbjd2.putBundle(string, (Bundle)zzdtf2);
        }
        return new zzenb((Bundle)zzbjd2, null);
    }
}
