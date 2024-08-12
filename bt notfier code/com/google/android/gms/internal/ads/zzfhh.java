/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfge
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgm
 *  com.google.android.gms.internal.ads.zzfgv
 *  com.google.android.gms.internal.ads.zzfhe
 *  com.google.android.gms.internal.ads.zzfhg
 *  com.google.android.gms.internal.ads.zzfhi
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgm;
import com.google.android.gms.internal.ads.zzfgv;
import com.google.android.gms.internal.ads.zzfhe;
import com.google.android.gms.internal.ads.zzfhg;
import com.google.android.gms.internal.ads.zzfhi;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzfhh
extends zzfhe {
    private WebView zza;
    private Long zzb = null;
    private final Map<String, zzfgm> zzc;

    public zzfhh(Map<String, zzfgm> map, String string) {
        this.zzc = map;
    }

    static /* synthetic */ WebView zzl(zzfhh zzfhh2) {
        return zzfhh2.zza;
    }

    public final void zza() {
        Object object = new WebView(zzfgv.zza().zzb());
        this.zza = object;
        object.getSettings().setJavaScriptEnabled(true);
        this.zzc(this.zza);
        object = this.zza;
        if (object != null && !TextUtils.isEmpty(null)) {
            object.loadUrl("javascript: null");
        }
        if (!(object = this.zzc.keySet().iterator()).hasNext()) {
            this.zzb = System.nanoTime();
            return;
        }
        object = (String)object.next();
        object = this.zzc.get(object);
        throw null;
    }

    public final void zzb() {
        super.zzb();
        long l = this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb, TimeUnit.NANOSECONDS);
        l = Math.max(4000L - l, 2000L);
        new Handler().postDelayed((Runnable)new zzfhg(this), l);
        this.zza = null;
    }

    public final void zzh(zzfgg zzfgg2, zzfge zzfge2) {
        JSONObject jSONObject = new JSONObject();
        Map map = zzfge2.zze();
        Iterator iterator = map.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzi(zzfgg2, zzfge2, jSONObject);
                return;
            }
            String string = (String)iterator.next();
            zzfhi.zzc((JSONObject)jSONObject, (String)string, (Object)((zzfgm)map.get(string)));
        }
    }
}
