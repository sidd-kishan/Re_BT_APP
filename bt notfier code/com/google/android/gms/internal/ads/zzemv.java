/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzerx
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzerx;
import java.util.ArrayList;

final class zzemv
implements zzerx {
    private final ArrayList zza;

    zzemv(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zzf(Object object) {
        ArrayList arrayList = this.zza;
        ((Bundle)object).putStringArrayList("ad_types", arrayList);
    }
}