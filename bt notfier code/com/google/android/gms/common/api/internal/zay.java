/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.zaaa
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zaaa;

final class zay
implements PendingResult.StatusListener {
    final BasePendingResult zaa;
    final zaaa zab;

    zay(zaaa zaaa2, BasePendingResult basePendingResult) {
        this.zab = zaaa2;
        this.zaa = basePendingResult;
    }

    public final void onComplete(Status status) {
        zaaa.zaf((zaaa)this.zab).remove(this.zaa);
    }
}
