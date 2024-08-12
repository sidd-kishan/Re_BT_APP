/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  com.google.android.gms.internal.ads.zzbkt
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbkt;
import java.util.Iterator;
import java.util.Map;

public final class zzffm {
    private final String zza = (String)zzbkt.zzb.zze();

    public final String zza(Map<String, String> object) {
        Uri.Builder builder = Uri.parse((String)this.zza).buildUpon();
        Iterator<Map.Entry<String, String>> iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            builder.appendQueryParameter((String)object.getKey(), (String)object.getValue());
        }
        return builder.build().toString();
    }
}
