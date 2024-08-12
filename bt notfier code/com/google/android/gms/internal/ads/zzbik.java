/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
 *  com.google.android.gms.internal.ads.zzbgs
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.internal.ads.zzbgs;

public final class zzbik
extends zzbgs {
    private final OnAdMetadataChangedListener zza;

    public zzbik(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zza = onAdMetadataChangedListener;
    }

    public final void zze() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zza;
        if (onAdMetadataChangedListener == null) return;
        onAdMetadataChangedListener.onAdMetadataChanged();
    }
}
