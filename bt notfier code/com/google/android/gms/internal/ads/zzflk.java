/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflh
 *  com.google.android.gms.internal.ads.zzfly
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflh;
import com.google.android.gms.internal.ads.zzfly;

public abstract class zzflk
implements zzfly<Character> {
    protected zzflk() {
    }

    public static zzflk zzb(char c) {
        return new zzflh(c);
    }

    public abstract boolean zza(char var1);
}
