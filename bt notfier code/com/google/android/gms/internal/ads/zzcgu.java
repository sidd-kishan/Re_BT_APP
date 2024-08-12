/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcgu {
    /*
     * Unable to fully structure code
     */
    public static boolean zza(Bundle var0, Bundle var1_1) {
        if (var0 != null && var1_1 != null) {
            if (var0.size() != var1_1.size()) {
                return false;
            }
        } else {
            if (var0 != null) return false;
            if (var1_1 != null) return false;
            return true;
        }
        var5_2 = var0.keySet().iterator();
        while (true) {
            if (var5_2.hasNext() == false) return true;
            var6_6 = (String)var5_2.next();
            if (!var1_1.containsKey((String)var6_6)) {
                return false;
            }
            var4_5 = var0.get((String)var6_6);
            var6_6 = var1_1.get((String)var6_6);
            if (var4_5 != null && var6_6 != null) {
                if (var4_5 instanceof Bundle) {
                    if (var6_6 instanceof Bundle == false) return false;
                    if (zzcgu.zza((Bundle)var4_5, (Bundle)var6_6)) continue;
                    return false;
                }
                if (!var4_5.getClass().isArray()) {
                    if (var4_5.equals(var6_6)) continue;
                    return false;
                }
            } else {
                if (var4_5 != null) return false;
                if (var6_6 != null) return false;
                return true;
            }
            var3_4 = Array.getLength(var4_5);
            if (var6_6.getClass().isArray() == false) return false;
            if (var3_4 != Array.getLength(var6_6)) return false;
            var2_3 = 0;
            while (true) {
                if (var2_3 >= var3_4) ** break;
                if (!Objects.equal((Object)Array.get(var4_5, var2_3), (Object)Array.get(var6_6, var2_3))) {
                    return false;
                }
                ++var2_3;
            }
            break;
        }
    }
}
