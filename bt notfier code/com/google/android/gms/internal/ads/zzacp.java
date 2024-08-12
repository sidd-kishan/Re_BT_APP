/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzacp
extends zzacz {
    private List<Long> zzi = null;

    public zzacp(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "6LxD9DBfXSlooSx7/LozL06rdHrjyh7Q8PNFejLJXxiRhvgA5vOTtEhIRp3pKXIi", "yXdkchwXd7KBwiPBiUydLTG3hsBC8U5EW7urXPkQrKc=", zzyj2, n, 31);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        List<Long> list;
        this.zze.zzq(-1L);
        this.zze.zzr(-1L);
        if (this.zzi == null) {
            this.zzi = (List)this.zzf.invoke(null, this.zzb.zzc());
        }
        if ((list = this.zzi) == null) return;
        if (list.size() != 2) return;
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzq(this.zzi.get(0).longValue());
            this.zze.zzr(this.zzi.get(1).longValue());
            return;
        }
    }
}
