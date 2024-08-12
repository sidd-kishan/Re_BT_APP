/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzada
 *  com.google.android.gms.internal.ads.zzyj
 *  com.google.android.gms.internal.ads.zzzo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzyj;
import com.google.android.gms.internal.ads.zzzo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzacb
extends zzacz {
    private static final zzada<String> zzi = new zzada();
    private final Context zzj;

    public zzacb(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, Context context) {
        super(zzabr2, "Cm/m2hUfCdldkdMMT3yEm1sAGuFpKVfLQblDoR20XcK7ttTDkHIz3fwaKTv7az9S", "aEm/NgN//tNFhysboe/lIhu1ib9P4g8tTm8w79YCsSs=", zzyj2, n, 29);
        this.zzj = context;
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzp("E");
        Object object = zzi.zza(this.zzj.getPackageName());
        if (((AtomicReference)object).get() == null) {
            synchronized (object) {
                if (((AtomicReference)object).get() == null) {
                    ((AtomicReference)object).set((String)this.zzf.invoke(null, this.zzj));
                }
            }
        }
        object = (String)((AtomicReference)object).get();
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzp(zzzo.zza((byte[])((String)object).getBytes(), (boolean)true));
            return;
        }
    }
}
