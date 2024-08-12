/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.zabj
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabj;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zabk
implements BaseGmsClient.SignOutCallbacks {
    final zabl zaa;

    zabk(zabl zabl2) {
        this.zaa = zabl2;
    }

    public final void onSignOutComplete() {
        GoogleApiManager.zas((GoogleApiManager)this.zaa.zaa).post((Runnable)new zabj(this));
    }
}
