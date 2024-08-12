/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzaby
 *  com.google.android.gms.internal.ads.zzacz
 *  com.google.android.gms.internal.ads.zzyj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzaby;
import com.google.android.gms.internal.ads.zzacz;
import com.google.android.gms.internal.ads.zzyj;
import java.lang.reflect.InvocationTargetException;

public final class zzact
extends zzacz {
    private final zzaby zzi;
    private long zzj;

    public zzact(zzabr zzabr2, String string, String string2, zzyj zzyj2, int n, int n2, zzaby zzaby2) {
        super(zzabr2, "BF4UgSmqTS0MLe4qitQi/hj1jIQ+0vLIJEn32u0TtZn0VL9j15ZHt04Do4ADy833", "Yw5N4XiXXiTiwJwrJ8hW/AfPIwRQ2KMfiYKb9xu8vYQ=", zzyj2, n, 53);
        this.zzi = zzaby2;
        if (zzaby2 == null) return;
        this.zzj = zzaby2.zzc();
    }

    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi == null) return;
        this.zze.zzH(((Long)this.zzf.invoke(null, this.zzj)).longValue());
    }
}
