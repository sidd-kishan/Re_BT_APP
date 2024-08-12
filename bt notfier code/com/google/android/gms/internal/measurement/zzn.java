/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.android.gms.internal.measurement.zzs
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzs;
import java.util.concurrent.atomic.AtomicReference;

public final class zzn
extends zzs {
    private final AtomicReference<Bundle> zza = new AtomicReference();
    private boolean zzb;

    public static final <T> T zze(Bundle object, Class<T> clazz) {
        T t;
        T t2 = t = null;
        if (object == null) return t2;
        object = object.get("r");
        t2 = t;
        if (object == null) return t2;
        try {
            t2 = clazz.cast(object);
        }
        catch (ClassCastException classCastException) {
            Log.w((String)"AM", (String)String.format("Unexpected object type. Expected, Received: %s, %s", clazz.getCanonicalName(), object.getClass().getCanonicalName()), (Throwable)classCastException);
            throw classCastException;
        }
        return t2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb(Bundle bundle) {
        AtomicReference<Bundle> atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
                return;
            }
            finally {
                this.zza.notify();
            }
        }
    }

    public final String zzc(long l) {
        return zzn.zze(this.zzd(l), String.class);
    }

    public final Bundle zzd(long l) {
        AtomicReference<Bundle> atomicReference = this.zza;
        synchronized (atomicReference) {
            boolean bl = this.zzb;
            if (!bl) {
                try {
                    this.zza.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    return null;
                }
            }
            Bundle bundle = this.zza.get();
            return bundle;
        }
    }
}
