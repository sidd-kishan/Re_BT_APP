/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmk
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfqw$zza
 *  com.google.android.gms.internal.ads.zzfqw$zzd
 *  com.google.android.gms.internal.ads.zzfqw$zze
 *  com.google.android.gms.internal.ads.zzfqw$zzl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmk;
import com.google.android.gms.internal.ads.zzfqw;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

final class zzfqw$zzk
extends zzfqw.zza {
    static final Unsafe zza;
    static final long zzb;
    static final long zzc;
    static final long zzd;
    static final long zze;
    static final long zzf;

    static {
        Unsafe unsafe;
        try {
            unsafe = Unsafe.getUnsafe();
        }
        catch (SecurityException securityException) {
            try {
                unsafe = new /* Unavailable Anonymous Inner Class!! */;
                unsafe = (Unsafe)AccessController.doPrivileged(unsafe);
            }
            catch (PrivilegedActionException privilegedActionException) {
                throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
            }
        }
        try {
            zzc = unsafe.objectFieldOffset(zzfqw.class.getDeclaredField("waiters"));
            zzb = unsafe.objectFieldOffset(zzfqw.class.getDeclaredField("listeners"));
            zzd = unsafe.objectFieldOffset(zzfqw.class.getDeclaredField("value"));
            zze = unsafe.objectFieldOffset(zzfqw.zzl.class.getDeclaredField("thread"));
            zzf = unsafe.objectFieldOffset(zzfqw.zzl.class.getDeclaredField("next"));
            zza = unsafe;
            return;
        }
        catch (Exception exception) {
            zzfmk.zza((Throwable)exception);
            throw new RuntimeException(exception);
        }
    }

    private zzfqw$zzk() {
        super(null);
    }

    /* synthetic */ zzfqw$zzk(zzfqw.zze zze2) {
        super(null);
    }

    final void zza(zzfqw.zzl zzl2, Thread thread) {
        zza.putObject((Object)zzl2, zze, (Object)thread);
    }

    final void zzb(zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        zza.putObject((Object)zzl2, zzf, (Object)zzl3);
    }

    final boolean zzc(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        return zza.compareAndSwapObject(zzfqw2, zzc, zzl2, zzl3);
    }

    final boolean zzd(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzd zzd2, zzfqw.zzd zzd3) {
        return zza.compareAndSwapObject(zzfqw2, zzb, zzd2, zzd3);
    }

    final boolean zze(zzfqw<?> zzfqw2, @CheckForNull Object object, Object object2) {
        return zza.compareAndSwapObject(zzfqw2, zzd, object, object2);
    }
}
