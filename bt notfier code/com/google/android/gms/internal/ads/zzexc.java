/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzexb
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzexb;
import java.util.concurrent.atomic.AtomicReference;

public final class zzexc {
    public static <T> void zza(AtomicReference<T> atomicReference, zzexb<T> zzexb2) {
        if ((atomicReference = atomicReference.get()) == null) {
            return;
        }
        try {
            zzexb2.zza(atomicReference);
            return;
        }
        catch (NullPointerException nullPointerException) {
            zze.zzj((String)"NullPointerException occurs when invoking a method from a delegating listener.", (Throwable)nullPointerException);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
