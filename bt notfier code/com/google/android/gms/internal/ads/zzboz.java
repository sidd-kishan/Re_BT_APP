/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbkx
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzfln;

final class zzboz
implements zzfln {
    private final String zza;

    zzboz(String string) {
        this.zza = string;
    }

    public final Object apply(Object object) {
        Object object2;
        String string = this.zza;
        String string2 = (String)object;
        object = zzbpq.zza;
        if (string2 == null) {
            object2 = string;
            return object2;
        }
        if (((Boolean)zzbkx.zzf.zze()).booleanValue()) {
            object = Uri.parse((String)string).getHost();
            int n = 0;
            while (true) {
                object2 = string;
                if (n >= 3) return object2;
                if (((String)object).endsWith((new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"})[n])) break;
                ++n;
            }
        }
        object2 = (String)zzbkx.zza.zze();
        String string3 = (String)zzbkx.zzb.zze();
        object = string;
        if (!TextUtils.isEmpty((CharSequence)object2)) {
            object = string.replace((CharSequence)object2, string2);
        }
        object2 = object;
        if (TextUtils.isEmpty((CharSequence)string3)) return object2;
        string = Uri.parse((String)object);
        object2 = object;
        if (!TextUtils.isEmpty((CharSequence)string.getQueryParameter(string3))) return object2;
        return string.buildUpon().appendQueryParameter(string3, string2).toString();
    }
}
