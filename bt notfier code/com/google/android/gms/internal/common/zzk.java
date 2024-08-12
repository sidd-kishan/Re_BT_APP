/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzj
 *  org.checkerframework.checker.nullness.compatqual.NullableDecl
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzj;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzk
extends zzj {
    public static boolean zza(@NullableDecl Object object, @NullableDecl Object object2) {
        boolean bl = false;
        if (object != object2) {
            if (object == null) return bl;
            if (!object.equals(object2)) return false;
        }
        bl = true;
        return bl;
    }
}
