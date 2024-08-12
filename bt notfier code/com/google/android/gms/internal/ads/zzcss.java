/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.webkit.CookieManager
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcsc
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcsc;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzfmg;
import java.util.List;
import java.util.Map;

public final class zzcss
implements zzcsc {
    private final CookieManager zza;

    public zzcss(Context context) {
        this.zza = zzt.zze().zzk(context);
    }

    public final void zza(Map<String, String> object) {
        String string;
        if (this.zza == null) {
            return;
        }
        if (object.get("clear") != null) {
            object = zzbjl.zzaz;
            string = (String)zzbet.zzc().zzc((zzbjd)object);
            object = this.zza.getCookie(string);
            if (object == null) {
                return;
            }
        } else {
            String string2 = (String)object.get("cookie");
            if (TextUtils.isEmpty((CharSequence)string2)) {
                return;
            }
            CookieManager cookieManager = this.zza;
            object = zzbjl.zzaz;
            cookieManager.setCookie((String)zzbet.zzc().zzc((zzbjd)object), string2);
            return;
        }
        List list = zzfmg.zzb((zzflk)zzflk.zzb((char)';')).zzf((CharSequence)object);
        int n = 0;
        while (n < list.size()) {
            CookieManager cookieManager = this.zza;
            object = (String)list.get(n);
            object = zzfmg.zzb((zzflk)zzflk.zzb((char)'=')).zzd((CharSequence)object).iterator();
            if (object == null) throw null;
            if (!object.hasNext()) {
                object = new StringBuilder(91);
                ((StringBuilder)object).append("position (0) must be less than the number of elements that remained (");
                ((StringBuilder)object).append(0);
                ((StringBuilder)object).append(")");
                throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
            }
            object = String.valueOf((String)object.next());
            Object object2 = zzbjl.zzaq;
            object2 = String.valueOf((String)zzbet.zzc().zzc((zzbjd)object2));
            object = ((String)object2).length() != 0 ? ((String)object).concat((String)object2) : new String((String)object);
            cookieManager.setCookie(string, (String)object);
            ++n;
        }
    }
}
