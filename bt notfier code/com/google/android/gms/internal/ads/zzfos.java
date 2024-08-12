/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfob
 *  com.google.android.gms.internal.ads.zzfoc
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzfqd
 *  com.google.android.gms.internal.ads.zzfqi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfob;
import com.google.android.gms.internal.ads.zzfoc;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzfqd;
import com.google.android.gms.internal.ads.zzfqi;
import java.util.Arrays;
import javax.annotation.CheckForNull;

public final class zzfos<E>
extends zzfoc<E> {
    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzfos() {
        super(4);
    }

    zzfos(int n) {
        super(n);
        this.zzd = new Object[zzfot.zzl((int)n)];
    }

    public final zzfos<E> zze(E e) {
        Object object;
        int n;
        int n2;
        if (e == null) throw null;
        if (this.zzd == null || (n2 = zzfot.zzl((int)this.zzb)) > (n = ((Object[])(object = this.zzd)).length)) {
            this.zzd = null;
            super.zza(e);
            return this;
        }
        object.getClass();
        int n3 = e.hashCode();
        n2 = zzfob.zza((int)n3);
        while (true) {
            Object[] objectArray;
            if ((object = (objectArray = this.zzd)[n2 &= n - 1]) == null) {
                objectArray[n2] = e;
                this.zze += n3;
                super.zza(e);
                return this;
            }
            if (object.equals(e)) return this;
            ++n2;
        }
    }

    public final zzfos<E> zzf(Iterable<? extends E> object) {
        if (this.zzd == null) {
            super.zzb(object);
            return this;
        }
        object = object.iterator();
        while (object.hasNext()) {
            this.zze(object.next());
        }
        return this;
    }

    public final zzfot<E> zzg() {
        Object[] objectArray;
        int n = this.zzb;
        if (n == 0) return zzfqd.zza;
        if (n == 1) {
            Object object = this.zza[0];
            object.getClass();
            return new zzfqi(object);
        }
        if (this.zzd != null && zzfot.zzl((int)n) == this.zzd.length) {
            objectArray = zzfot.zzk((int)this.zzb, (int)this.zza.length) ? Arrays.copyOf(this.zza, this.zzb) : this.zza;
            n = this.zze;
            Object[] objectArray2 = this.zzd;
            objectArray = new zzfqd(objectArray, n, objectArray2, objectArray2.length - 1, this.zzb);
        } else {
            objectArray = zzfot.zzj((int)this.zzb, (Object[])this.zza);
            this.zzb = objectArray.size();
        }
        this.zzc = true;
        this.zzd = null;
        return objectArray;
    }
}
