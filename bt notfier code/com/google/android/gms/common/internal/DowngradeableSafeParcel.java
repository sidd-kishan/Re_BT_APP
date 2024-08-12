/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class DowngradeableSafeParcel
extends AbstractSafeParcelable
implements ReflectedParcelable {
    private static final Object zza = new Object();
    private boolean zzb = false;

    protected static boolean canUnparcelSafely(String string) {
        Object object = zza;
        synchronized (object) {
            return true;
        }
    }

    protected static Integer getUnparcelClientVersion() {
        Object object = zza;
        synchronized (object) {
            return null;
        }
    }

    protected abstract boolean prepareForClientVersion(int var1);

    public void setShouldDowngrade(boolean bl) {
        this.zzb = bl;
    }

    protected boolean shouldDowngrade() {
        return this.zzb;
    }
}
