/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflm;
import javax.annotation.CheckForNull;

public final class zzflt
extends zzflm {
    public static boolean zza(@CheckForNull Object object, @CheckForNull Object object2) {
        boolean bl = false;
        if (object != object2) {
            if (object == null) return bl;
            if (!object.equals(object2)) return false;
        }
        bl = true;
        return bl;
    }
}
