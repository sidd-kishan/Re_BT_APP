/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzhq
 *  com.google.android.gms.internal.ads.zzij
 *  com.google.android.gms.internal.ads.zzks
 *  com.google.android.gms.internal.ads.zzoa
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzhq;
import com.google.android.gms.internal.ads.zzij;
import com.google.android.gms.internal.ads.zzks;
import com.google.android.gms.internal.ads.zzoa;

public final class zzgt
implements zzhq {
    private final zzai zza;
    private final SparseArray<zzhq> zzb;
    private final int[] zzc;

    public zzgt(Context context, zzoa zzoa2) {
        context = new zzks(context);
        this.zza = context;
        SparseArray sparseArray = new SparseArray();
        int n = 0;
        try {
            sparseArray.put(0, (Object)Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(zzhq.class).getConstructor(zzai.class).newInstance(context));
        }
        catch (Exception exception) {}
        try {
            sparseArray.put(1, (Object)Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(zzhq.class).getConstructor(zzai.class).newInstance(context));
        }
        catch (Exception exception) {}
        try {
            sparseArray.put(2, (Object)Class.forName("androidx.media3.exoplayer.hls.HlsMediaSource$Factory").asSubclass(zzhq.class).getConstructor(zzai.class).newInstance(context));
        }
        catch (Exception exception) {}
        try {
            sparseArray.put(3, (Object)Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(zzhq.class).getConstructor(new Class[0]).newInstance(new Object[0]));
        }
        catch (Exception exception) {}
        sparseArray.put(4, (Object)new zzij((zzai)context, zzoa2));
        this.zzb = sparseArray;
        this.zzc = new int[sparseArray.size()];
        while (n < this.zzb.size()) {
            this.zzc[n] = this.zzb.keyAt(n);
            ++n;
        }
    }
}
