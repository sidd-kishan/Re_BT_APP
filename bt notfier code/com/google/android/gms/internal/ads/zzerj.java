/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfa
 *  com.google.android.gms.internal.ads.zzeri
 *  com.google.android.gms.internal.ads.zzerk
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfa;
import com.google.android.gms.internal.ads.zzeri;
import com.google.android.gms.internal.ads.zzerk;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzerj
implements zzery<zzerk> {
    private final zzcfa zza;
    private final zzfsn zzb;
    private final Context zzc;

    public zzerj(zzcfa zzcfa2, zzfsn zzfsn2, Context context) {
        this.zza = zzcfa2;
        this.zzb = zzfsn2;
        this.zzc = context;
    }

    public final zzfsm<zzerk> zza() {
        return this.zzb.zzb((Callable)new zzeri(this));
    }

    final /* synthetic */ zzerk zzb() throws Exception {
        Object object;
        String string;
        String string2;
        String string3;
        if (!this.zza.zzb(this.zzc)) {
            return new zzerk(null, null, null, null, null);
        }
        String string4 = this.zza.zzj(this.zzc);
        if (string4 == null) {
            string4 = "";
        }
        if ((string3 = this.zza.zzk(this.zzc)) == null) {
            string3 = "";
        }
        if ((string2 = this.zza.zzl(this.zzc)) == null) {
            string2 = "";
        }
        if ((string = this.zza.zzm(this.zzc)) == null) {
            string = "";
        }
        if ("TIME_OUT".equals(string3)) {
            object = zzbjl.zzaa;
            object = (Long)zzbet.zzc().zzc(object);
        } else {
            object = null;
        }
        return new zzerk(string4, string3, string2, string, (Long)object);
    }
}
