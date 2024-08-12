/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfob
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfob;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfql;
import javax.annotation.CheckForNull;

final class zzfqd<E>
extends zzfot<E> {
    static final zzfqd<Object> zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        zzd = new Object[0];
        Object[] objectArray = zzd;
        zza = new zzfqd(objectArray, 0, objectArray, 0, 0);
    }

    zzfqd(Object[] objectArray, int n, Object[] objectArray2, int n2, int n3) {
        this.zzb = objectArray;
        this.zze = n;
        this.zzc = objectArray2;
        this.zzf = n2;
        this.zzg = n3;
    }

    public final boolean contains(@CheckForNull Object object) {
        Object[] objectArray = this.zzc;
        if (object == null) return false;
        if (objectArray.length == 0) {
            return false;
        }
        int n = zzfob.zzb((Object)object);
        Object object2;
        while ((object2 = objectArray[n &= this.zzf]) != null) {
            if (object2.equals(object)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public final int hashCode() {
        return this.zze;
    }

    public final int size() {
        return this.zzg;
    }

    public final zzfql<E> zza() {
        return this.zze().zzt(0);
    }

    final Object[] zzb() {
        return this.zzb;
    }

    final int zzc() {
        return 0;
    }

    final int zzd() {
        return this.zzg;
    }

    final boolean zzf() {
        throw null;
    }

    final int zzg(Object[] objectArray, int n) {
        System.arraycopy(this.zzb, 0, objectArray, n, this.zzg);
        return n + this.zzg;
    }

    final boolean zzm() {
        return true;
    }

    final zzfoj<E> zzn() {
        return zzfoj.zzs((Object[])this.zzb, (int)this.zzg);
    }
}
