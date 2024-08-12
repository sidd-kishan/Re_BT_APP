/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzcnn
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzcnn;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

final class zzbow
implements zzbpr {
    static final zzbpr zza = new zzbow();

    private zzbow() {
    }

    public final void zza(Object object, Map object2) {
        object = (zzcnn)object;
        Object object3 = zzbpq.zza;
        object3 = zzbjl.zzfS;
        if (!((Boolean)zzbet.zzc().zzc((zzbjd)object3)).booleanValue()) {
            zze.zzi((String)"canOpenAppGmsgHandler disabled.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)(object2 = (String)object2.get("package_name")))) {
            zze.zzi((String)"Package name missing in canOpenApp GMSG.");
            return;
        }
        object3 = new HashMap();
        boolean bl = object.getContext().getPackageManager().getLaunchIntentForPackage((String)object2) != null;
        Serializable serializable = Boolean.valueOf(bl);
        ((HashMap)object3).put(object2, serializable);
        String string = serializable.toString();
        serializable = new StringBuilder(String.valueOf(object2).length() + 13 + string.length());
        ((StringBuilder)serializable).append("/canOpenApp;");
        ((StringBuilder)serializable).append((String)object2);
        ((StringBuilder)serializable).append(";");
        ((StringBuilder)serializable).append(string);
        zze.zza((String)((StringBuilder)serializable).toString());
        ((zzbsi)object).zze("openableApp", (Map)object3);
    }
}
