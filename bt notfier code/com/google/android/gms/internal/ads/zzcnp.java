/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcms
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcms;
import java.io.File;
import java.util.Collections;
import java.util.Map;

public class zzcnp
extends zzcms {
    public zzcnp(zzcml zzcml2, zzazb zzazb2, boolean bl) {
        super(zzcml2, zzazb2, bl);
    }

    protected final WebResourceResponse zzM(WebView object, String string, Map<String, String> map) {
        if (!(object instanceof zzcml)) {
            zze.zzi((String)"Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcml zzcml2 = (zzcml)object;
        object = this.zza;
        if (object != null) {
            object.zzf(string, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(string).getName())) {
            object = map;
            if (map != null) return super.zzA(string, (Map)object);
            object = Collections.emptyMap();
            return super.zzA(string, (Map)object);
        }
        if (zzcml2.zzR() != null) {
            zzcml2.zzR().zzC();
        }
        if (zzcml2.zzP().zzg()) {
            object = zzbjl.zzJ;
            object = (String)zzbet.zzc().zzc((zzbjd)object);
        } else if (zzcml2.zzW()) {
            object = zzbjl.zzI;
            object = (String)zzbet.zzc().zzc((zzbjd)object);
        } else {
            object = zzbjl.zzH;
            object = (String)zzbet.zzc().zzc((zzbjd)object);
        }
        zzt.zzc();
        return zzs.zzB((Context)zzcml2.getContext(), (String)zzcml2.zzt().zza, (String)object);
    }
}
