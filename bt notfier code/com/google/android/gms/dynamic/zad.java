/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.google.android.gms.dynamic.DeferredLifecycleHelper
 *  com.google.android.gms.dynamic.LifecycleDelegate
 *  com.google.android.gms.dynamic.zah
 */
package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zah;

final class zad
implements zah {
    final FrameLayout zaa;
    final LayoutInflater zab;
    final ViewGroup zac;
    final Bundle zad;
    final DeferredLifecycleHelper zae;

    zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zae = deferredLifecycleHelper;
        this.zaa = frameLayout;
        this.zab = layoutInflater;
        this.zac = viewGroup;
        this.zad = bundle;
    }

    public final int zaa() {
        return 2;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.removeAllViews();
        this.zaa.addView(DeferredLifecycleHelper.zac((DeferredLifecycleHelper)this.zae).onCreateView(this.zab, this.zac, this.zad));
    }
}
