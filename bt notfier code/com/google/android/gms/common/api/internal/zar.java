/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.zaq
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaq;

final class zar {
    final BasePendingResult zaa;

    /* synthetic */ zar(BasePendingResult basePendingResult, zaq zaq2) {
        this.zaa = basePendingResult;
    }

    protected final void finalize() throws Throwable {
        BasePendingResult.zal((Result)BasePendingResult.zam((BasePendingResult)this.zaa));
        super.finalize();
    }
}
