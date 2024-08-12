/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzahb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzahb;

public class zzahc
extends Exception {
    public static final zzadw<zzahc> zzk = zzahb.zza;
    public final int zzi;
    public final long zzj;

    protected zzahc(String string, Throwable throwable, int n, long l) {
        super(string, throwable);
        this.zzi = n;
        this.zzj = l;
    }
}
