/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CodecException
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzave;

public final class zzarh
extends Exception {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzarh(zzanm object, Throwable throwable, boolean bl, int n) {
        String string = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 36);
        stringBuilder.append("Decoder init failed: [");
        stringBuilder.append(n);
        stringBuilder.append("], ");
        stringBuilder.append(string);
        super(stringBuilder.toString(), throwable);
        this.zza = ((zzanm)object).zzf;
        this.zzb = null;
        n = Math.abs(n);
        object = new StringBuilder(68);
        ((StringBuilder)object).append("com.google.android.exoplayer.MediaCodecTrackRenderer_neg_");
        ((StringBuilder)object).append(n);
        this.zzc = ((StringBuilder)object).toString();
    }

    public zzarh(zzanm object, Throwable throwable, boolean bl, String string) {
        String string2 = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 23 + String.valueOf(string2).length());
        stringBuilder.append("Decoder init failed: ");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        super(stringBuilder.toString(), throwable);
        this.zza = object.zzf;
        this.zzb = string;
        int n = zzave.zza;
        string = null;
        object = string;
        if (n >= 21) {
            object = string;
            if (throwable instanceof MediaCodec.CodecException) {
                object = ((MediaCodec.CodecException)throwable).getDiagnosticInfo();
            }
        }
        this.zzc = object;
    }
}
