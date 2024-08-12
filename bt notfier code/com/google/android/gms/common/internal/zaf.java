/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  com.google.android.gms.common.api.internal.LifecycleFragment
 *  com.google.android.gms.common.internal.zag
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zag;

final class zaf
extends zag {
    final Intent zaa;
    final LifecycleFragment zab;

    zaf(Intent intent, LifecycleFragment lifecycleFragment, int n) {
        this.zaa = intent;
        this.zab = lifecycleFragment;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent == null) return;
        this.zab.startActivityForResult(intent, 2);
    }
}
