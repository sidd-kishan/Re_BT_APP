/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.zacw
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacw;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacx {
    public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
    final Set<BasePendingResult<?>> zab = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacw zac = new zacw(this);

    final void zaa(BasePendingResult<? extends Result> basePendingResult) {
        this.zab.add(basePendingResult);
        basePendingResult.zan(this.zac);
    }

    public final void zab() {
        BasePendingResult basePendingResult = this.zab;
        int n = 0;
        BasePendingResult[] basePendingResultArray = basePendingResult.toArray(new BasePendingResult[0]);
        int n2 = basePendingResultArray.length;
        while (n < n2) {
            basePendingResult = basePendingResultArray[n];
            basePendingResult.zan(null);
            if (basePendingResult.zaj()) {
                this.zab.remove(basePendingResult);
            }
            ++n;
        }
    }
}
