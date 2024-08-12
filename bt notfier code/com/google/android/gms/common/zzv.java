/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.zzu
 *  com.google.android.gms.common.zzw
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzu;
import com.google.android.gms.common.zzw;
import java.util.concurrent.Callable;

final class zzv
extends zzw {
    private final Callable<String> zzd;

    /* synthetic */ zzv(Callable callable, zzu zzu2) {
        super(false, null, null);
        this.zzd = callable;
    }

    final String zza() {
        try {
            String string = this.zzd.call();
            return string;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
