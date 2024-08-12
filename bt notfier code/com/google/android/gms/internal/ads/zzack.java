/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaav
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;

public final class zzack
extends zzacz {
    private final zzaav zzi;

    public zzack(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, zzaav zzaav2) {
        super(zzabr2, "E20AdmxNj0iK7Vx72nHXXjWnsmv4FUkyxC/Oztwx6eZIzlENIrQYdkN17JfC0Q1q", "rY9DNDEvlJE2YV76YVSJLP4cBUy/u1xcBXUcMxb1h8o=", zzyj2, n, 11);
        this.zzi = zzaav2;
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaav zzaav2 = this.zzi;
        if (zzaav2 == null) return;
        this.zze.zzf(((Long)this.zzf.invoke(null, zzaav2.zzc())).longValue());
    }
}
