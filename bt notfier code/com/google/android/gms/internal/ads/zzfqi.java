/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfou
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfou;
import com.google.android.gms.internal.ads.zzfql;
import javax.annotation.CheckForNull;

final class zzfqi<E>
extends zzfot<E> {
    final transient E zza;
    private transient int zzb;

    zzfqi(E e) {
        if (e == null) throw null;
        this.zza = e;
    }

    zzfqi(E e, int n) {
        this.zza = e;
        this.zzb = n;
    }

    public final boolean contains(@CheckForNull Object object) {
        return this.zza.equals(object);
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzb;
        if (n != 0) return n2;
        this.zzb = n2 = this.zza.hashCode();
        return n2;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 2);
        stringBuilder.append('[');
        stringBuilder.append(string);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final zzfql<E> zza() {
        return new zzfou(this.zza);
    }

    final boolean zzf() {
        throw null;
    }

    final int zzg(Object[] objectArray, int n) {
        objectArray[n] = this.zza;
        return n + 1;
    }

    final boolean zzm() {
        if (this.zzb == 0) return false;
        return true;
    }

    final zzfoj<E> zzn() {
        return zzfoj.zzj(this.zza);
    }
}
