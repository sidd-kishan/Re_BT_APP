/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$CodecException
 *  com.google.android.gms.internal.ads.zzad
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfo
 */
package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import com.google.android.gms.internal.ads.zzad;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfo;

public class zzfn
extends zzad {
    public final zzfo zza;
    public final String zzb;

    public zzfn(Throwable throwable, zzfo object) {
        Object var4_3 = null;
        String string = object == null ? null : object.zza;
        string = String.valueOf(string);
        string = string.length() != 0 ? "Decoder failed: ".concat(string) : new String("Decoder failed: ");
        super(string, throwable);
        this.zza = object;
        object = var4_3;
        if (zzamq.zza >= 21) {
            object = var4_3;
            if (throwable instanceof MediaCodec.CodecException) {
                object = ((MediaCodec.CodecException)throwable).getDiagnosticInfo();
            }
        }
        this.zzb = object;
    }
}
