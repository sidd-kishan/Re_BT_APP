/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzdtb
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzdtb;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzdtc {
    private final Map<String, zzdtb> zza = new HashMap<String, zzdtb>();

    zzdtc() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zza(String string, zzfbi zzfbi2) {
        synchronized (this) {
            zzbya zzbya2;
            zzbya zzbya3;
            boolean bl = this.zza.containsKey(string);
            if (bl) {
                return;
            }
            try {
                zzbya2 = zzbya3.zzz();
                zzbya3 = zzbya3.zzA();
            }
            catch (zzfaw zzfaw2) {
                return;
            }
            zzdtb zzdtb2 = new zzdtb(string, zzbya2, zzbya3);
            this.zza.put(string, zzdtb2);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    final void zzb(String string, zzbxn zzbxn2) {
        synchronized (this) {
            zzbya zzbya2;
            zzbya zzbya3;
            block6: {
                boolean bl = this.zza.containsKey(string);
                if (!bl) break block6;
                return;
            }
            try {
                zzbya3 = zzbxn2.zzf();
                zzbya2 = zzbxn2.zzg();
            }
            catch (Throwable throwable) {
                return;
            }
            {
                zzbxn2 = new zzdtb(string, zzbya3, zzbya2);
                this.zza.put(string, (zzdtb)zzbxn2);
                return;
            }
        }
    }

    @Nullable
    public final zzdtb zzc(String string) {
        synchronized (this) {
            string = this.zza.get(string);
            return string;
        }
    }

    @Nullable
    public final zzdtb zzd(List<String> object) {
        zzdtb zzdtb2;
        object = object.iterator();
        do {
            if (!object.hasNext()) return null;
        } while ((zzdtb2 = this.zzc((String)object.next())) == null);
        return zzdtb2;
    }
}
