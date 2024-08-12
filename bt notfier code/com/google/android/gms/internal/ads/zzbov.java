/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzcnn
 */
package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzcnn;
import java.util.HashMap;
import java.util.Map;

final class zzbov
implements zzbpr {
    static final zzbpr zza = new zzbov();

    private zzbov() {
    }

    public final void zza(Object object, Map object2) {
        zzcnn zzcnn2 = (zzcnn)object;
        object = zzbpq.zza;
        object = (String)object2.get("urls");
        if (TextUtils.isEmpty((CharSequence)object)) {
            zze.zzi((String)"URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] stringArray = ((String)object).split(",");
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        PackageManager packageManager = zzcnn2.getContext().getPackageManager();
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                ((zzbsi)zzcnn2).zze("openableURLs", hashMap);
                return;
            }
            object2 = stringArray[n2];
            object = ((String)object2).split(";", 2);
            CharSequence charSequence = object[0].trim();
            int n3 = ((String[])object).length;
            boolean bl = true;
            object = n3 > 1 ? object[1].trim() : "android.intent.action.VIEW";
            if (packageManager.resolveActivity(new Intent((String)object, Uri.parse((String)charSequence)), 65536) == null) {
                bl = false;
            }
            object = bl;
            hashMap.put(object2, object);
            object = object.toString();
            charSequence = new StringBuilder(String.valueOf(object2).length() + 14 + ((String)object).length());
            ((StringBuilder)charSequence).append("/canOpenURLs;");
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(";");
            ((StringBuilder)charSequence).append((String)object);
            zze.zza((String)((StringBuilder)charSequence).toString());
            ++n2;
        }
    }
}
