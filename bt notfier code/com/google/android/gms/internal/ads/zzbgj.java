/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.MuteThisAdListener
 *  com.google.android.gms.internal.ads.zzbgh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.internal.ads.zzbgh;

public final class zzbgj
extends zzbgh {
    private final MuteThisAdListener zza;

    public zzbgj(MuteThisAdListener muteThisAdListener) {
        this.zza = muteThisAdListener;
    }

    public final void zze() {
        this.zza.onAdMuted();
    }
}
