/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.telephony.PhoneStateListener
 *  android.telephony.ServiceState
 *  android.telephony.TelephonyDisplayInfo
 *  com.google.android.gms.internal.ads.zzama
 *  com.google.android.gms.internal.ads.zzamd
 */
package com.google.android.gms.internal.ads;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import com.google.android.gms.internal.ads.zzama;
import com.google.android.gms.internal.ads.zzamd;

final class zzamc
extends PhoneStateListener {
    final zzamd zza;

    /* synthetic */ zzamc(zzamd zzamd2, zzama zzama2) {
        this.zza = zzamd2;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int n = telephonyDisplayInfo.getOverrideNetworkType();
        n = n != 3 && n != 4 ? 0 : 1;
        telephonyDisplayInfo = this.zza;
        n = 1 != n ? 5 : 10;
        zzamd.zzd((zzamd)telephonyDisplayInfo, (int)n);
    }

    public final void onServiceStateChanged(ServiceState object) {
        int n = !((String)(object = object == null ? "" : object.toString())).contains("nrState=CONNECTED") && !((String)object).contains("nrState=NOT_RESTRICTED") ? 0 : 1;
        object = this.zza;
        n = 1 != n ? 5 : 10;
        zzamd.zzd((zzamd)object, (int)n);
    }
}
