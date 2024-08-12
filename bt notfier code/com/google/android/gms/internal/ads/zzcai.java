/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.query.UpdateImpressionUrlsCallback
 *  com.google.android.gms.internal.ads.zzcae
 *  com.google.android.gms.internal.ads.zzcal
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcal;
import java.util.List;

final class zzcai
extends zzcae {
    final UpdateImpressionUrlsCallback zza;

    zzcai(zzcal zzcal2, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(List<Uri> list) {
        this.zza.onSuccess(list);
    }

    public final void zzf(String string) {
        this.zza.onFailure(string);
    }
}
