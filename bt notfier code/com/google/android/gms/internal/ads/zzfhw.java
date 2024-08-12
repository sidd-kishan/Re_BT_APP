/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  com.google.android.gms.internal.ads.zzfho
 *  com.google.android.gms.internal.ads.zzfhx
 */
package com.google.android.gms.internal.ads;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzfho;
import com.google.android.gms.internal.ads.zzfhx;

public abstract class zzfhw
extends AsyncTask<Object, Void, String> {
    private zzfhx zza;
    protected final zzfho zzd;

    public zzfhw(zzfho zzfho2, byte[] byArray) {
        this.zzd = zzfho2;
    }

    protected void zza(String string) {
        string = this.zza;
        if (string == null) return;
        string.zzb(this);
    }

    public final void zzb(zzfhx zzfhx2) {
        this.zza = zzfhx2;
    }
}
