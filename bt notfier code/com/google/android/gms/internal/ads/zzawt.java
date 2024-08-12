/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaws
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaws;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzawt {
    int zza;
    private final Object zzb = new Object();
    private final List<zzaws> zzc = new LinkedList<zzaws>();

    /*
     * Enabled force condition propagation
     */
    public final zzaws zza(boolean bl) {
        Object object = this.zzb;
        synchronized (object) {
            zzaws zzaws2;
            block10: {
                int n = this.zzc.size();
                zzaws2 = null;
                if (n == 0) {
                    zze.zzd((String)"Queue empty");
                    return null;
                }
                n = this.zzc.size();
                int n2 = 0;
                if (n < 2) break block10;
                Iterator<zzaws> iterator = this.zzc.iterator();
                n = Integer.MIN_VALUE;
                int n3 = 0;
                while (iterator.hasNext()) {
                    zzaws zzaws3 = iterator.next();
                    int n4 = zzaws3.zzm();
                    if (n4 > n) {
                        n2 = n3;
                    }
                    int n5 = n4 > n ? n4 : n;
                    if (n4 > n) {
                        zzaws2 = zzaws3;
                    }
                    ++n3;
                    n = n5;
                }
                this.zzc.remove(n2);
                return zzaws2;
            }
            zzaws2 = this.zzc.get(0);
            if (bl) {
                this.zzc.remove(0);
            } else {
                zzaws2.zze();
            }
            return zzaws2;
        }
    }

    public final boolean zzb(zzaws zzaws2) {
        Object object = this.zzb;
        synchronized (object) {
            if (!this.zzc.contains(zzaws2)) return false;
            return true;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzc(zzaws zzaws2) {
        Object object = this.zzb;
        synchronized (object) {
            Iterator<zzaws> iterator;
            block8: {
                iterator = this.zzc.iterator();
                while (iterator.hasNext()) {
                    zzaws zzaws3 = iterator.next();
                    if (!zzt.zzg().zzp().zzd()) {
                        if (zzaws2 == zzaws3 || !zzaws3.zzb().equals(zzaws2.zzb())) continue;
                        iterator.remove();
                        return true;
                    }
                    if (zzt.zzg().zzp().zzh() || zzaws2 == zzaws3 || !zzaws3.zzd().equals(zzaws2.zzd())) {
                        continue;
                    }
                    break block8;
                }
                return false;
            }
            iterator.remove();
            return true;
        }
    }

    public final void zzd(zzaws zzaws2) {
        Object object = this.zzb;
        synchronized (object) {
            int n;
            if (this.zzc.size() >= 10) {
                n = this.zzc.size();
                StringBuilder stringBuilder = new StringBuilder(41);
                stringBuilder.append("Queue is full, current size = ");
                stringBuilder.append(n);
                zze.zzd((String)stringBuilder.toString());
                this.zzc.remove(0);
            }
            n = this.zza;
            this.zza = n + 1;
            zzaws2.zzn(n);
            zzaws2.zzj();
            this.zzc.add(zzaws2);
            return;
        }
    }
}
