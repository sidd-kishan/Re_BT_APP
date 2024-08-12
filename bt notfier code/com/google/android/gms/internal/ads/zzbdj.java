/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.RequestConfiguration
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;

final class zzbdj
implements Comparator {
    static final Comparator zza = new zzbdj();

    private zzbdj() {
    }

    public final int compare(Object object, Object object2) {
        object = (String)object;
        object2 = (String)object2;
        return RequestConfiguration.zza.indexOf(object) - RequestConfiguration.zza.indexOf(object2);
    }
}
