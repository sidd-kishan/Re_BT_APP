/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvu
 *  com.google.android.gms.internal.ads.zzwq
 *  com.google.android.gms.internal.ads.zzxc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvu;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzxc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class zzxd
extends zzwq {
    public zzxd() {
    }

    public zzxd(zzxc zzxc2, SSLSocketFactory sSLSocketFactory) {
    }

    /*
     * Unable to fully structure code
     */
    static List<zzvu> zza(Map<String, List<String>> var0) {
        var1_1 = new ArrayList<zzvu>(var0.size());
        var4_2 = var0.entrySet().iterator();
        block0: while (true) {
            if (var4_2.hasNext() == false) return var1_1;
            var3_4 = var4_2.next();
            if (var3_4.getKey() == null) continue;
            var2_3 = var3_4.getValue().iterator();
            while (true) {
                if (var2_3.hasNext()) ** break;
                continue block0;
                var0 = var2_3.next();
                var1_1.add(new zzvu(var3_4.getKey(), (String)var0));
            }
            break;
        }
    }
}
