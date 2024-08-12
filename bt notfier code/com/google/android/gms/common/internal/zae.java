/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.fragment.app.Fragment
 *  com.google.android.gms.common.internal.zag
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zag;

final class zae
extends zag {
    final Intent zaa;
    final Fragment zab;
    final int zac;

    zae(Intent intent, Fragment fragment, int n) {
        this.zaa = intent;
        this.zab = fragment;
        this.zac = n;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent == null) return;
        this.zab.startActivityForResult(intent, this.zac);
    }
}
