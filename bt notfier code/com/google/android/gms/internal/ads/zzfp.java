/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CodecException
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfo
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfo;

public final class zzfp
extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzfo zzc;
    public final String zzd;
    public final zzfp zze;

    public zzfp(zzafv object, Throwable throwable, boolean bl, int n) {
        String string = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 36);
        stringBuilder.append("Decoder init failed: [");
        stringBuilder.append(n);
        stringBuilder.append("], ");
        stringBuilder.append(string);
        string = ((zzafv)object).zzl;
        n = Math.abs(n);
        object = new StringBuilder(75);
        ((StringBuilder)object).append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_");
        ((StringBuilder)object).append(n);
        this(stringBuilder.toString(), throwable, string, false, null, ((StringBuilder)object).toString(), null);
    }

    public zzfp(zzafv object, Throwable throwable, boolean bl, zzfo zzfo2) {
        String string = zzfo2.zza;
        String string2 = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 23 + String.valueOf(string2).length());
        stringBuilder.append("Decoder init failed: ");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        string = object.zzl;
        object = zzamq.zza >= 21 && throwable instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException)throwable).getDiagnosticInfo() : null;
        this(string2, throwable, string, false, zzfo2, (String)object, null);
    }

    private zzfp(String string, Throwable throwable, String string2, boolean bl, zzfo zzfo2, String string3, zzfp zzfp2) {
        super(string, throwable);
        this.zza = string2;
        this.zzb = false;
        this.zzc = zzfo2;
        this.zzd = string3;
        this.zze = zzfp2;
    }

    static /* synthetic */ zzfp zza(zzfp zzfp2, zzfp zzfp3) {
        return new zzfp(zzfp2.getMessage(), zzfp2.getCause(), zzfp2.zza, false, zzfp2.zzc, zzfp2.zzd, zzfp3);
    }
}
