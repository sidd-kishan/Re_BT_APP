/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzenl
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzenl;
import com.google.android.gms.internal.ads.zzfln;
import java.util.ArrayList;

final class zzenk
implements zzfln {
    static final zzfln zza = new zzenk();

    private zzenk() {
    }

    public final Object apply(Object object) {
        if (!((ArrayList)(object = (ArrayList)object)).isEmpty()) return new zzenl((ArrayList)object);
        return null;
    }
}
