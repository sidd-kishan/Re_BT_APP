/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzeqa
 *  com.google.android.gms.internal.ads.zzeqb
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzeqa;
import com.google.android.gms.internal.ads.zzeqb;
import java.util.ArrayList;

final class zzepz
implements zzeqb {
    private final zzeqa zza;
    private final ArrayList zzb;

    zzepz(zzeqa zzeqa2, ArrayList arrayList) {
        this.zza = zzeqa2;
        this.zzb = arrayList;
    }

    public final void zzf(Object object) {
        this.zza.zzb(this.zzb, (Bundle)object);
    }
}
