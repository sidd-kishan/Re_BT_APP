/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfgf
 *  com.google.android.gms.internal.ads.zzfgl
 *  com.google.android.gms.internal.ads.zzfgm
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfgl;
import com.google.android.gms.internal.ads.zzfgm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzfge {
    private final zzfgl zza;
    private final WebView zzb;
    private final List<zzfgm> zzc = new ArrayList<zzfgm>();
    private final Map<String, zzfgm> zzd = new HashMap<String, zzfgm>();
    private final String zze;
    private final String zzf;
    private final zzfgf zzg;

    private zzfge(zzfgl zzfgl2, WebView webView, String string, List<zzfgm> list, String string2, String string3, zzfgf zzfgf2) {
        this.zza = zzfgl2;
        this.zzb = webView;
        this.zzg = zzfgf2;
        this.zzf = string2;
        this.zze = "";
    }

    public static zzfge zza(zzfgl zzfgl2, WebView webView, String string, String string2) {
        return new zzfge(zzfgl2, webView, null, null, string, "", zzfgf.zza);
    }

    public static zzfge zzb(zzfgl zzfgl2, WebView webView, String string, String string2) {
        return new zzfge(zzfgl2, webView, null, null, string, "", zzfgf.zzc);
    }

    public final zzfgl zzc() {
        return this.zza;
    }

    public final List<zzfgm> zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map<String, zzfgm> zze() {
        return Collections.unmodifiableMap(this.zzd);
    }

    public final WebView zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zze;
    }

    public final zzfgf zzi() {
        return this.zzg;
    }
}
