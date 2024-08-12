/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzffg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzffg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzffh {
    private final Clock zza;
    private final Map<String, List<String>> zzb;
    private final Map<String, Long> zzc;

    public zzffh(Clock clock) {
        this.zza = clock;
        this.zzb = new HashMap<String, List<String>>();
        this.zzc = new HashMap<String, Long>();
    }

    private final void zzd(String string, String string2) {
        if (!this.zzb.containsKey(string)) {
            this.zzb.put(string, new ArrayList());
        }
        this.zzb.get(string).add(string2);
    }

    public final void zza(String string) {
        if (this.zzc.containsKey(string)) {
            long l = this.zza.elapsedRealtime();
            long l2 = this.zzc.remove(string);
            StringBuilder stringBuilder = new StringBuilder(20);
            stringBuilder.append(l - l2);
            this.zzd(string, stringBuilder.toString());
            return;
        }
        this.zzc.put(string, this.zza.elapsedRealtime());
    }

    public final void zzb(String string, String string2) {
        if (this.zzc.containsKey(string)) {
            long l = this.zza.elapsedRealtime();
            long l2 = this.zzc.remove(string);
            StringBuilder stringBuilder = new StringBuilder(string2.length() + 20);
            stringBuilder.append(string2);
            stringBuilder.append(l - l2);
            this.zzd(string, stringBuilder.toString());
            return;
        }
        this.zzc.put(string, this.zza.elapsedRealtime());
    }

    public final List<zzffg> zzc() {
        ArrayList<zzffg> arrayList = new ArrayList<zzffg>();
        Iterator<Map.Entry<String, List<String>>> iterator = this.zzb.entrySet().iterator();
        block0: while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            int n = entry.getValue().size();
            int n2 = 0;
            if (n > 1) {
                Iterator<String> iterator2 = entry.getValue().iterator();
                while (true) {
                    if (!iterator2.hasNext()) continue block0;
                    String string = iterator2.next();
                    String string2 = entry.getKey();
                    ++n2;
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 12);
                    stringBuilder.append(string2);
                    stringBuilder.append(".");
                    stringBuilder.append(n2);
                    arrayList.add(new zzffg(stringBuilder.toString(), string));
                }
            }
            arrayList.add(new zzffg(entry.getKey(), entry.getValue().get(0)));
        }
        return arrayList;
    }
}
