/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzfln;

final class zzm
implements zzfln {
    private final zzv zza;
    private final Uri zzb;

    zzm(zzv zzv2, Uri uri) {
        this.zza = zzv2;
        this.zzb = uri;
    }

    public final Object apply(Object object) {
        return zzv.zzF((Uri)this.zzb, (String)((String)object));
    }
}
