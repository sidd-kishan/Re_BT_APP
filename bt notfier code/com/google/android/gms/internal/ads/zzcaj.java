/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.ads.query.UpdateClickUrlCallback
 *  com.google.android.gms.internal.ads.zzcae
 *  com.google.android.gms.internal.ads.zzcal
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcal;
import java.util.List;

final class zzcaj
extends zzcae {
    final UpdateClickUrlCallback zza;

    zzcaj(zzcal zzcal2, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza = updateClickUrlCallback;
    }

    public final void zze(List<Uri> list) {
        this.zza.onSuccess(list.get(0));
    }

    public final void zzf(String string) {
        this.zza.onFailure(string);
    }
}
