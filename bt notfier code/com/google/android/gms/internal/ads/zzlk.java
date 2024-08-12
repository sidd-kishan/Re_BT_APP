/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzln;
import java.util.Comparator;

final class zzlk
implements Comparator {
    static final Comparator zza = new zzlk();

    private zzlk() {
    }

    public final int compare(Object object, Object object2) {
        object = (zzln)object;
        object2 = (zzln)object2;
        return ((zzln)object).zza - ((zzln)object2).zza;
    }
}
