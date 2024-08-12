/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzjt;
import java.util.Comparator;

final class zzjh
implements Comparator {
    static final Comparator zza = new zzjh();

    private zzjh() {
    }

    public final int compare(Object object, Object object2) {
        object = (Integer)object;
        object2 = (Integer)object2;
        int n = zzjt.zza;
        int n2 = (Integer)object;
        n = -1;
        if (n2 == -1) {
            if ((Integer)object2 != -1) return n;
            n = 0;
        } else {
            if ((Integer)object2 == -1) {
                n = 1;
                return n;
            }
            n = (Integer)object - (Integer)object2;
        }
        return n;
    }
}
