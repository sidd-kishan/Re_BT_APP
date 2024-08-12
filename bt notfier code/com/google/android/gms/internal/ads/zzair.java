/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

final class zzair {
    private final PowerManager zza;

    public zzair(Context context) {
        this.zza = (PowerManager)context.getApplicationContext().getSystemService("power");
    }
}
