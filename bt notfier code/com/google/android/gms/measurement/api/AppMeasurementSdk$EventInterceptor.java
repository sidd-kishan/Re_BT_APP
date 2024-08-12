/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.measurement.internal.zzgp
 */
package com.google.android.gms.measurement.api;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgp;

public static interface AppMeasurementSdk.EventInterceptor
extends zzgp {
    public void interceptEvent(String var1, String var2, Bundle var3, long var4);
}
