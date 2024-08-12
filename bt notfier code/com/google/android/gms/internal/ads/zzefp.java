/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzefr
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzefr;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzefp
implements zzfrk {
    private final zzefr zza;
    private final Uri zzb;
    private final zzfal zzc;
    private final zzezz zzd;

    zzefp(zzefr zzefr2, Uri uri, zzfal zzfal2, zzezz zzezz2) {
        this.zza = zzefr2;
        this.zzb = uri;
        this.zzc = zzfal2;
        this.zzd = zzezz2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, object);
    }
}
