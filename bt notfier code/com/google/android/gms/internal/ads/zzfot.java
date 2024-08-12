/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfob
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfos
 *  com.google.android.gms.internal.ads.zzfpv
 *  com.google.android.gms.internal.ads.zzfqd
 *  com.google.android.gms.internal.ads.zzfqh
 *  com.google.android.gms.internal.ads.zzfqi
 *  com.google.android.gms.internal.ads.zzfql
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfob;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfos;
import com.google.android.gms.internal.ads.zzfpv;
import com.google.android.gms.internal.ads.zzfqd;
import com.google.android.gms.internal.ads.zzfqh;
import com.google.android.gms.internal.ads.zzfqi;
import com.google.android.gms.internal.ads.zzfql;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzfot<E>
extends zzfoe<E>
implements Set<E> {
    @CheckForNull
    private transient zzfoj<E> zza;

    zzfot() {
    }

    public static <E> zzfot<E> zzh() {
        return zzfqd.zza;
    }

    @SafeVarargs
    public static <E> zzfot<E> zzi(E e, E e2, E e3, E e4, E e5, E e6, E ... EArray) {
        Object[] objectArray = new Object[11];
        objectArray[0] = e;
        objectArray[1] = e2;
        objectArray[2] = e3;
        objectArray[3] = e4;
        objectArray[4] = e5;
        objectArray[5] = e6;
        System.arraycopy(EArray, 0, objectArray, 6, 5);
        return zzfot.zzp(11, objectArray);
    }

    static /* synthetic */ <E> zzfot<E> zzj(int n, Object[] objectArray) {
        return zzfot.zzp(n, objectArray);
    }

    static /* synthetic */ boolean zzk(int n, int n2) {
        return zzfot.zzq(n, n2);
    }

    static int zzl(int n) {
        int n2 = Math.max(n, 2);
        if (n2 < 0x2CCCCCCC) {
            n = Integer.highestOneBit(n2 - 1);
            while (true) {
                n += n;
                double d = n;
                Double.isNaN(d);
                if (!(d * 0.7 < (double)n2)) return n;
            }
        }
        boolean bl = n2 < 0x40000000;
        zzflx.zza((boolean)bl, (Object)"collection too large");
        return 0x40000000;
    }

    public static <E> zzfos<E> zzo(int n) {
        return new zzfos(n);
    }

    private static <E> zzfot<E> zzp(int n, Object ... object) {
        if (n == 0) return zzfqd.zza;
        if (n == 1) {
            object = object[0];
            object.getClass();
            return new zzfqi(object);
        }
        int n2 = zzfot.zzl(n);
        Object[] objectArray = new Object[n2];
        int n3 = n2 - 1;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        block0: while (true) {
            Object[] objectArray2;
            if (n4 >= n) {
                Arrays.fill((Object[])object, n6, n, null);
                if (n6 == 1) {
                    object = object[0];
                    object.getClass();
                    return new zzfqi(object, n5);
                }
                if (zzfot.zzl(n6) < n2 / 2) {
                    return zzfot.zzp(n6, (Object[])object);
                }
                objectArray2 = object;
                if (!zzfot.zzq(n6, ((Object)object).length)) return new zzfqd(objectArray2, n5, objectArray, n3, n6);
                objectArray2 = Arrays.copyOf(object, n6);
                return new zzfqd(objectArray2, n5, objectArray, n3, n6);
            }
            objectArray2 = object[n4];
            zzfpv.zzb((Object)objectArray2, (int)n4);
            int n7 = objectArray2.hashCode();
            int n8 = zzfob.zza((int)n7);
            while (true) {
                block11: {
                    block10: {
                        Object object2;
                        block9: {
                            int n9;
                            if ((object2 = objectArray[n9 = n8 & n3]) != null) break block9;
                            object[n6] = objectArray2;
                            objectArray[n9] = objectArray2;
                            n5 += n7;
                            ++n6;
                            break block10;
                        }
                        if (!object2.equals(objectArray2)) break block11;
                    }
                    ++n4;
                    continue block0;
                }
                ++n8;
            }
            break;
        }
    }

    private static boolean zzq(int n, int n2) {
        if (n >= (n2 >> 1) + (n2 >> 2)) return false;
        return true;
    }

    @Override
    public final boolean equals(@CheckForNull Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (object instanceof zzfot && this.zzm() && ((zzfot)object).zzm()) {
            if (this.hashCode() != object.hashCode()) return false;
        }
        if (object == this) return bl;
        if (object instanceof Set) {
            object = (Set)object;
            try {
                if (this.size() == object.size()) {
                    bl = this.containsAll((Collection<?>)object);
                    if (bl) return true;
                }
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        bl = false;
        return bl;
    }

    @Override
    public int hashCode() {
        return zzfqh.zza((Set)this);
    }

    public abstract zzfql<E> zza();

    public zzfoj<E> zze() {
        zzfoj<E> zzfoj2;
        zzfoj<E> zzfoj3 = zzfoj2 = this.zza;
        if (zzfoj2 != null) return zzfoj3;
        this.zza = zzfoj3 = this.zzn();
        return zzfoj3;
    }

    boolean zzm() {
        return false;
    }

    zzfoj<E> zzn() {
        return zzfoj.zzr((Object[])this.toArray());
    }
}
