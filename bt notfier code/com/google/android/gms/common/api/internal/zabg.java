/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.GoogleApiManager;

final class zabg
implements BackgroundDetector.BackgroundStateChangeListener {
    final GoogleApiManager zaa;

    zabg(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean bl) {
        GoogleApiManager.zas((GoogleApiManager)this.zaa).sendMessage(GoogleApiManager.zas((GoogleApiManager)this.zaa).obtainMessage(1, (Object)bl));
    }
}
