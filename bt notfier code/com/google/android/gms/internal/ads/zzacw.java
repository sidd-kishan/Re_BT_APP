/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.DisplayMetrics
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzabv
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzyx
 *  com.google.android.gms.internal.ads.zzyy
 */
package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzabv;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzyy;
import java.lang.reflect.InvocationTargetException;

public final class zzacw
extends zzacz {
    private final View zzi;

    public zzacw(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, View view) {
        super(zzabr2, "Rh7wPiyt0Q0zAefasWAQ/36LhULiVi3U1eCO9K34euxkll+3xBb3q2iaqyDuAy33", "Kmv9uscZLQkY9DcwgermeDphrIGnHnQJYdRAudw6Thg=", zzyj2, n, 57);
        this.zzi = view;
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi == null) return;
        Object object = zzbjl.zzbX;
        object = (Boolean)zzbet.zzc().zzc((zzbjd)object);
        DisplayMetrics displayMetrics = this.zzb.zzc().getResources().getDisplayMetrics();
        displayMetrics = new zzabv((String)this.zzf.invoke(null, this.zzi, displayMetrics, object));
        zzyx zzyx2 = zzyy.zza();
        zzyx2.zza(displayMetrics.zza.longValue());
        zzyx2.zzb(displayMetrics.zzb.longValue());
        zzyx2.zzc(displayMetrics.zzc.longValue());
        if (((Boolean)object).booleanValue()) {
            zzyx2.zzd(displayMetrics.zzd.longValue());
        }
        this.zze.zzL((zzyy)zzyx2.zzah());
    }
}
