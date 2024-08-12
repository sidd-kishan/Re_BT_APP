/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjq
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbjz
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbjz;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzbka {
    private final List<zzbjx> zza = new LinkedList<zzbjx>();
    private final Map<String, String> zzb = new LinkedHashMap<String, String>();
    private final Object zzc = new Object();

    public zzbka(boolean bl, String string, String string2) {
        this.zzb.put("action", "make_wv");
        this.zzb.put("ad_format", string2);
    }

    public static final zzbjx zzf() {
        return new zzbjx(zzt.zzj().elapsedRealtime(), null, null);
    }

    public final void zza(zzbka object) {
        object = this.zzc;
        synchronized (object) {
            return;
        }
    }

    /*
     * Loose catch block
     */
    public final boolean zzb(zzbjx zzbjx2, long l, String ... stringArray) {
        Object object = this.zzc;
        synchronized (object) {
            int n = 0;
            while (n <= 0) {
                String string = stringArray[n];
                zzbjx zzbjx3 = new zzbjx(l, string, zzbjx2);
                this.zza.add(zzbjx3);
                ++n;
            }
            return true;
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public final zzbjz zzc() {
        zzbjd object5 = zzbjl.zzbl;
        boolean bl = (Boolean)zzbet.zzc().zzc(object5);
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new HashMap();
        Object object2 = this.zzc;
        synchronized (object2) {
            try {
                void var6_7;
                long l;
                CharSequence charSequence;
                for (zzbjx zzbjx2 : this.zza) {
                    long l2 = zzbjx2.zza();
                    charSequence = zzbjx2.zzb();
                    zzbjx zzbjx3 = zzbjx2.zzc();
                    if (zzbjx3 == null || l2 <= 0L) continue;
                    l = zzbjx3.zza();
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append('.');
                    stringBuilder.append(l2 - l);
                    stringBuilder.append(',');
                    if (!bl) continue;
                    if (!object.containsKey(zzbjx3.zza())) {
                        l = zzbjx3.zza();
                        StringBuilder stringBuilder2 = new StringBuilder((String)charSequence);
                        object.put(l, stringBuilder2);
                        continue;
                    }
                    StringBuilder stringBuilder3 = (StringBuilder)object.get(zzbjx3.zza());
                    stringBuilder3.append('+');
                    stringBuilder3.append((String)charSequence);
                }
                this.zza.clear();
                Object var6_3 = null;
                if (!TextUtils.isEmpty(null)) {
                    stringBuilder.append((String)null);
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
                charSequence = new StringBuilder();
                if (bl) {
                    for (Map.Entry entry : object.entrySet()) {
                        ((StringBuilder)charSequence).append((CharSequence)entry.getValue());
                        ((StringBuilder)charSequence).append('.');
                        l = (Long)entry.getKey();
                        ((StringBuilder)charSequence).append(zzt.zzj().currentTimeMillis() + (l - zzt.zzj().elapsedRealtime()));
                        ((StringBuilder)charSequence).append(',');
                    }
                    if (((StringBuilder)charSequence).length() > 0) {
                        ((StringBuilder)charSequence).setLength(((StringBuilder)charSequence).length() - 1);
                    }
                    String string = ((StringBuilder)charSequence).toString();
                }
                object = new zzbjz(stringBuilder.toString(), (String)var6_7);
                return object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzd(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        zzbjq zzbjq2 = zzt.zzg().zze();
        if (zzbjq2 == null) {
            return;
        }
        Object object = this.zzc;
        synchronized (object) {
            zzbjq2 = zzbjq2.zzd(string);
            Map<String, String> map = this.zzb;
            map.put(string, zzbjq2.zza(map.get(string), string2));
            return;
        }
    }

    public final Map<String, String> zze() {
        Object object = this.zzc;
        synchronized (object) {
            zzt.zzg().zze();
            Map<String, String> map = this.zzb;
            return map;
        }
    }
}
