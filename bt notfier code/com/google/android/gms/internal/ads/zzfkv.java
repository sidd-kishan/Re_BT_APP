/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfko
 *  com.google.android.gms.internal.ads.zzfkp
 *  com.google.android.gms.internal.ads.zzfkq
 *  com.google.android.gms.internal.ads.zzfkr
 *  com.google.android.gms.internal.ads.zzfks
 *  com.google.android.gms.internal.ads.zzfkt
 *  com.google.android.gms.internal.ads.zzfku
 *  com.google.android.gms.internal.ads.zzfmj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfko;
import com.google.android.gms.internal.ads.zzfkp;
import com.google.android.gms.internal.ads.zzfkq;
import com.google.android.gms.internal.ads.zzfkr;
import com.google.android.gms.internal.ads.zzfks;
import com.google.android.gms.internal.ads.zzfkt;
import com.google.android.gms.internal.ads.zzfku;
import com.google.android.gms.internal.ads.zzfmj;
import java.io.IOException;
import java.net.HttpURLConnection;

public final class zzfkv
extends zzfko {
    private zzfmj<Integer> zza;
    private zzfmj<Integer> zzb;
    private zzfku zzc;
    private HttpURLConnection zzd;

    zzfkv() {
        zzfmj zzfmj2 = zzfkq.zza;
        zzfmj zzfmj3 = zzfkr.zza;
        this.zza = zzfmj2;
        this.zzb = zzfmj3;
        this.zzc = null;
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzd;
        zzfkp.zzb();
        if (httpURLConnection == null) return;
        httpURLConnection.disconnect();
    }

    public final HttpURLConnection zzb(zzfku object, int n, int n2) throws IOException {
        this.zza = new zzfks(265);
        this.zzb = new zzfkt(-1);
        this.zzc = object;
        zzfkp.zza((int)((Integer)this.zza.zza()), (int)((Integer)this.zzb.zza()));
        object = this.zzc;
        if (object == null) throw null;
        object = (HttpURLConnection)object.zza();
        this.zzd = object;
        return object;
    }
}
