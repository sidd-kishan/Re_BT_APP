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

public final class zzace
extends zzacz {
    private static volatile Long zzi;
    private static final Object zzj;

    static {
        zzj = new Object();
    }

    public zzace(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2) {
        super(zzabr2, "BZSpo1ki7Qq4VpNbKNY5xp3ObP5b46iKtLhMqj95i84Sl1pKZG1hW1hXSXh30EEu", "LLuZlwuRYspGUGo7OZU51ciMYYFQ89K2r1TLDzvNq9k=", zzyj2, n, 44);
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            Object object = zzj;
            synchronized (object) {
                if (zzi == null) {
                    zzi = (Long)this.zzf.invoke(null, new Object[0]);
                }
            }
        }
        zzyj zzyj2 = this.zze;
        synchronized (zzyj2) {
            this.zze.zzB(zzi.longValue());
            return;
        }
    }
}
