/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzdnv
 *  com.google.android.gms.internal.ads.zzdnw
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzdnv;
import com.google.android.gms.internal.ads.zzdnw;
import java.util.Map;

final class zzdns
implements zzbpr {
    private final zzdnw zza;

    zzdns(zzdnw zzdnw2) {
        this.zza = zzdnw2;
    }

    public final void zza(Object object, Map object2) {
        Object object3 = this.zza;
        object = (zzcml)object;
        object.zzR().zzy((zzcnx)new zzdnv(object3, (Map)object2));
        object3 = (String)object2.get("overlayHtml");
        object2 = (String)object2.get("baseUrl");
        if (TextUtils.isEmpty((CharSequence)object2)) {
            object.loadData((String)object3, "text/html", "UTF-8");
            return;
        }
        object.loadDataWithBaseURL((String)object2, (String)object3, "text/html", "UTF-8", null);
    }
}
