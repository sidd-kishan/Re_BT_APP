/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  com.google.android.gms.ads.internal.util.zzv
 */
package com.google.android.gms.ads.internal.util;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzv;

public class zzw
extends zzv {
    public final boolean zzg(View view) {
        return view.isAttachedToWindow();
    }

    public final ViewGroup.LayoutParams zzj() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
