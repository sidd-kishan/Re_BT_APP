/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfnm
 *  com.google.android.gms.internal.ads.zzfno
 *  com.google.android.gms.internal.ads.zzfnr
 *  com.google.android.gms.internal.ads.zzfnt
 *  com.google.android.gms.internal.ads.zzfob
 *  com.google.android.gms.internal.ads.zzfqr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfnm;
import com.google.android.gms.internal.ads.zzfno;
import com.google.android.gms.internal.ads.zzfnr;
import com.google.android.gms.internal.ads.zzfnt;
import com.google.android.gms.internal.ads.zzfob;
import com.google.android.gms.internal.ads.zzfqr;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfns<K, V>
extends AbstractMap<K, V>
implements Serializable {
    private static final Object zzd = new Object();
    @CheckForNull
    transient int[] zza;
    @CheckForNull
    transient Object[] zzb;
    @CheckForNull
    transient Object[] zzc;
    @CheckForNull
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    @CheckForNull
    private transient Set<K> zzh;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> zzi;
    @CheckForNull
    private transient Collection<V> zzj;

    zzfns() {
        this.zze(3);
    }

    zzfns(int n) {
        this.zze(8);
    }

    private final int[] zzA() {
        int[] nArray = this.zza;
        nArray.getClass();
        return nArray;
    }

    private final Object[] zzB() {
        Object[] objectArray = this.zzb;
        objectArray.getClass();
        return objectArray;
    }

    private final Object[] zzC() {
        Object[] objectArray = this.zzc;
        objectArray.getClass();
        return objectArray;
    }

    static /* synthetic */ Object zza() {
        return zzd;
    }

    static /* synthetic */ int zzb(zzfns zzfns2) {
        return zzfns2.zzf;
    }

    static /* synthetic */ int zzc(zzfns zzfns2) {
        return zzfns2.zzg;
    }

    static /* synthetic */ int zzd(zzfns zzfns2, int n) {
        zzfns2.zzg = n;
        return n;
    }

    static /* synthetic */ int zzh(zzfns zzfns2) {
        return zzfns2.zzw();
    }

    static /* synthetic */ int zzj(zzfns zzfns2, Object object) {
        return zzfns2.zzy(object);
    }

    static /* synthetic */ Object zzk(zzfns zzfns2, Object object) {
        return zzfns2.zzz(object);
    }

    static /* synthetic */ Object zzo(zzfns object) {
        object = ((zzfns)object).zze;
        object.getClass();
        return object;
    }

    static /* synthetic */ int[] zzp(zzfns zzfns2) {
        return zzfns2.zzA();
    }

    static /* synthetic */ Object[] zzq(zzfns zzfns2) {
        return zzfns2.zzB();
    }

    static /* synthetic */ Object[] zzr(zzfns zzfns2) {
        return zzfns2.zzC();
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ Object zzs(zzfns zzfns2, int n) {
        return zzfns2.zzB()[n];
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ Object zzt(zzfns zzfns2, int n) {
        return zzfns2.zzC()[n];
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzu(zzfns zzfns2, int n, Object object) {
        zzfns2.zzC()[n] = object;
    }

    private final void zzv(int n) {
        this.zzf = 32 - Integer.numberOfLeadingZeros(n) & 0x1F | this.zzf & 0xFFFFFFE0;
    }

    private final int zzw() {
        return (1 << (this.zzf & 0x1F)) - 1;
    }

    private final int zzx(int n, int n2, int n3, int n4) {
        Object object = zzfnt.zza((int)n2);
        int n5 = n2 - 1;
        if (n4 != 0) {
            zzfnt.zzc((Object)object, (int)(n3 & n5), (int)(n4 + 1));
        }
        Object object2 = this.zze;
        object2.getClass();
        int[] nArray = this.zzA();
        n2 = 0;
        while (true) {
            if (n2 > n) {
                this.zze = object;
                this.zzv(n5);
                return n5;
            }
            n3 = zzfnt.zzb((Object)object2, (int)n2);
            while (n3 != 0) {
                int n6 = n3 - 1;
                int n7 = nArray[n6];
                int n8 = ~n & n7 | n2;
                int n9 = n8 & n5;
                n4 = zzfnt.zzb((Object)object, (int)n9);
                zzfnt.zzc((Object)object, (int)n9, (int)n3);
                nArray[n6] = ~n5 & n8 | n4 & n5;
                n3 = n7 & n;
            }
            ++n2;
        }
    }

    private final int zzy(@CheckForNull Object object) {
        int n;
        if (this.zzf()) {
            return -1;
        }
        int n2 = zzfob.zzb((Object)object);
        int n3 = this.zzw();
        Object object2 = this.zze;
        object2.getClass();
        int n4 = zzfnt.zzb((Object)object2, (int)(n2 & n3));
        if (n4 == 0) return -1;
        int n5 = ~n3;
        do {
            if (((n = this.zzA()[--n4]) & n5) == (n2 & n5)) {
                if (zzflt.zza((Object)object, (Object)this.zzB()[n4])) return n4;
            }
            n4 = n &= n3;
        } while (n != 0);
        return -1;
    }

    private final Object zzz(@CheckForNull Object object) {
        if (this.zzf()) {
            return zzd;
        }
        int n = this.zzw();
        Object object2 = this.zze;
        object2.getClass();
        int n2 = zzfnt.zze((Object)object, null, (int)n, (Object)object2, (int[])this.zzA(), (Object[])this.zzB(), null);
        if (n2 == -1) {
            return zzd;
        }
        object = this.zzC()[n2];
        this.zzl(n2, n);
        --this.zzg;
        this.zzi();
        return object;
    }

    @Override
    public final void clear() {
        if (this.zzf()) {
            return;
        }
        this.zzi();
        Object object = this.zzg();
        if (object != null) {
            this.zzf = zzfqr.zza((int)this.size(), (int)3, (int)0x3FFFFFFF);
            object.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(this.zzB(), 0, this.zzg, null);
        Arrays.fill(this.zzC(), 0, this.zzg, null);
        object = this.zze;
        object.getClass();
        if (object instanceof byte[]) {
            Arrays.fill((byte[])object, (byte)0);
        } else if (object instanceof short[]) {
            Arrays.fill((short[])object, (short)0);
        } else {
            Arrays.fill((int[])object, 0);
        }
        Arrays.fill(this.zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override
    public final boolean containsKey(@CheckForNull Object object) {
        boolean bl;
        Map<K, V> map = this.zzg();
        if (map != null) {
            bl = map.containsKey(object);
        } else {
            if (this.zzy(object) != -1) return true;
            bl = false;
        }
        return bl;
    }

    @Override
    public final boolean containsValue(@CheckForNull Object object) {
        Map<K, V> map = this.zzg();
        if (map != null) return map.containsValue(object);
        int n = 0;
        while (n < this.zzg) {
            if (zzflt.zza((Object)object, (Object)this.zzC()[n])) {
                return true;
            }
            ++n;
        }
        return false;
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        zzfnm zzfnm2;
        zzfnm zzfnm3 = zzfnm2 = this.zzi;
        if (zzfnm2 != null) return zzfnm3;
        this.zzi = zzfnm3 = new zzfnm(this);
        return zzfnm3;
    }

    @Override
    @CheckForNull
    public final V get(@CheckForNull Object object) {
        Map<K, V> map = this.zzg();
        if (map != null) {
            return map.get(object);
        }
        int n = this.zzy(object);
        if (n != -1) return (V)this.zzC()[n];
        return null;
    }

    @Override
    public final boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    @Override
    public final Set<K> keySet() {
        zzfno zzfno2;
        zzfno zzfno3 = zzfno2 = this.zzh;
        if (zzfno2 != null) return zzfno3;
        this.zzh = zzfno3 = new zzfno(this);
        return zzfno3;
    }

    @Override
    @CheckForNull
    public final V put(K object, V v) {
        Object object2;
        int n;
        int n2;
        int n3;
        int n4;
        if (this.zzf()) {
            zzflx.zzb((boolean)this.zzf(), (Object)"Arrays already allocated");
            n4 = this.zzf;
            n3 = Math.max(n4 + 1, 2);
            n = n2 = Integer.highestOneBit(n3);
            if (n3 > (int)((double)n2)) {
                n2 += n2;
                n = n2;
                if (n2 <= 0) {
                    n = 0x40000000;
                }
            }
            n = Math.max(4, n);
            this.zze = zzfnt.zza((int)n);
            this.zzv(n - 1);
            this.zza = new int[n4];
            this.zzb = new Object[n4];
            this.zzc = new Object[n4];
        }
        if ((object2 = this.zzg()) != null) {
            return object2.put(object, v);
        }
        int[] nArray = this.zzA();
        Object[] objectArray = this.zzB();
        object2 = this.zzC();
        int n5 = this.zzg;
        int n6 = n5 + 1;
        n3 = zzfob.zzb(object);
        n4 = this.zzw();
        n = n3 & n4;
        Object object3 = this.zze;
        object3.getClass();
        n2 = zzfnt.zzb((Object)object3, (int)n);
        if (n2 == 0) {
            if (n6 > n4) {
                n = this.zzx(n4, zzfnt.zzd((int)n4), n3, n5);
            } else {
                object2 = this.zze;
                object2.getClass();
                zzfnt.zzc((Object)object2, (int)n, (int)n6);
                n = n4;
            }
        } else {
            int n7;
            int n8 = ~n4;
            n = 0;
            do {
                int n9;
                if ((n7 = (n2 = nArray[n9 = n2 - 1]) & n8) == (n3 & n8) && zzflt.zza(object, (Object)objectArray[n9])) {
                    object = object2[n9];
                    object2[n9] = v;
                    return (V)object;
                }
                ++n;
            } while ((n2 &= n4) != 0);
            if (n >= 9) {
                object2 = new LinkedHashMap(this.zzw() + 1, 1.0f);
                n = this.zzm();
                while (true) {
                    if (n < 0) {
                        this.zze = object2;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        this.zzi();
                        return object2.put(object, v);
                    }
                    object2.put(this.zzB()[n], this.zzC()[n]);
                    n = this.zzn(n);
                }
            }
            if (n6 > n4) {
                n = this.zzx(n4, zzfnt.zzd((int)n4), n3, n5);
            } else {
                nArray[n9] = n6 & n4 | n7;
                n = n4;
            }
        }
        n2 = this.zzA().length;
        if (n6 > n2 && (n4 = Math.min(0x3FFFFFFF, Math.max(1, n2 >>> 1) + n2 | 1)) != n2) {
            this.zza = Arrays.copyOf(this.zzA(), n4);
            this.zzb = Arrays.copyOf(this.zzB(), n4);
            this.zzc = Arrays.copyOf(this.zzC(), n4);
        }
        this.zzA()[n5] = ~n & n3;
        this.zzB()[n5] = object;
        this.zzC()[n5] = v;
        this.zzg = n6;
        this.zzi();
        return null;
    }

    @Override
    @CheckForNull
    public final V remove(@CheckForNull Object object) {
        Map<K, V> map = this.zzg();
        if (map != null) {
            return map.remove(object);
        }
        object = map = this.zzz(object);
        if (map != zzd) return (V)object;
        object = null;
        return (V)object;
    }

    @Override
    public final int size() {
        Map<K, V> map = this.zzg();
        int n = map != null ? map.size() : this.zzg;
        return n;
    }

    @Override
    public final Collection<V> values() {
        zzfnr zzfnr2;
        zzfnr zzfnr3 = zzfnr2 = this.zzj;
        if (zzfnr2 != null) return zzfnr3;
        this.zzj = zzfnr3 = new zzfnr(this);
        return zzfnr3;
    }

    final void zze(int n) {
        this.zzf = zzfqr.zza((int)n, (int)1, (int)0x3FFFFFFF);
    }

    final boolean zzf() {
        if (this.zze != null) return false;
        return true;
    }

    @CheckForNull
    final Map<K, V> zzg() {
        Object object = this.zze;
        if (!(object instanceof Map)) return null;
        return (Map)object;
    }

    final void zzi() {
        this.zzf += 32;
    }

    final void zzl(int n, int n2) {
        int n3;
        Object object;
        Object object2 = this.zze;
        object2.getClass();
        int[] nArray = this.zzA();
        Object[] objectArray = this.zzB();
        Object[] objectArray2 = this.zzC();
        int n4 = this.size() - 1;
        if (n >= n4) {
            objectArray[n] = null;
            objectArray2[n] = null;
            nArray[n] = 0;
            return;
        }
        objectArray[n] = object = objectArray[n4];
        objectArray2[n] = objectArray2[n4];
        objectArray[n4] = null;
        objectArray2[n4] = null;
        nArray[n] = nArray[n4];
        nArray[n4] = 0;
        int n5 = zzfob.zzb((Object)object) & n2;
        int n6 = zzfnt.zzb((Object)object2, (int)n5);
        if (n6 == ++n4) {
            zzfnt.zzc((Object)object2, (int)n5, (int)(n + 1));
            return;
        }
        while ((n6 = (n5 = nArray[n3 = n6 - 1]) & n2) != n4) {
        }
        nArray[n3] = n + 1 & n2 | n5 & ~n2;
    }

    final int zzm() {
        if (!this.isEmpty()) return 0;
        return -1;
    }

    final int zzn(int n) {
        if (++n >= this.zzg) return -1;
        return n;
    }
}
