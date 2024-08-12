/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.telephony.TelephonyManager
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.util.zzz
 *  com.google.android.gms.ads.internal.zzt
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.util.zzz;
import com.google.android.gms.ads.internal.zzt;

public class zzaa
extends zzz {
    public final int zzq(Context context, TelephonyManager telephonyManager) {
        zzt.zzc();
        if (!zzs.zzE((Context)context, (String)"android.permission.ACCESS_NETWORK_STATE")) return 1;
        if (!telephonyManager.isDataEnabled()) return 1;
        return 2;
    }
}
