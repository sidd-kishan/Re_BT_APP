/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.base.zal
 *  com.google.android.gms.internal.base.zan
 */
package com.google.android.gms.internal.base;

import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zan;

public final class zao {
    private static final zal zaa;
    private static volatile zal zab;

    static {
        zan zan2 = new zan(null);
        zaa = zan2;
        zab = zan2;
    }

    public static zal zaa() {
        return zab;
    }
}
