/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Process
 *  android.provider.Settings$System
 *  android.telephony.TelephonyManager
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebSettings
 *  com.google.android.gms.ads.internal.util.zzaa
 *  com.google.android.gms.ads.internal.util.zzac
 *  com.google.android.gms.ads.internal.util.zzce
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzt
 *  com.google.android.gms.ads.internal.util.zzu
 *  com.google.android.gms.ads.internal.util.zzv
 *  com.google.android.gms.ads.internal.util.zzw
 *  com.google.android.gms.ads.internal.util.zzx
 *  com.google.android.gms.ads.internal.util.zzy
 *  com.google.android.gms.ads.internal.util.zzz
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcms
 *  com.google.android.gms.internal.ads.zzcno
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.util.zzaa;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzce;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.util.zzv;
import com.google.android.gms.ads.internal.util.zzw;
import com.google.android.gms.ads.internal.util.zzx;
import com.google.android.gms.ads.internal.util.zzy;
import com.google.android.gms.ads.internal.util.zzz;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcms;
import com.google.android.gms.internal.ads.zzcno;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

public class zzad {
    private zzad() {
    }

    /* synthetic */ zzad(zzy zzy2) {
    }

    public static zzad zzt(int n) {
        if (n >= 28) {
            return new zzac();
        }
        if (n >= 26) {
            return new zzaa();
        }
        if (n >= 24) {
            return new zzz();
        }
        if (n >= 21) {
            return new zzx();
        }
        if (n >= 19) {
            return new zzw();
        }
        if (n >= 18) {
            return new zzv();
        }
        if (n < 17) return new zzad();
        return new zzu();
    }

    public static final boolean zzu() {
        int n = Process.myUid();
        if (n == 0) return true;
        if (n != 1000) return false;
        return true;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        zzce.zza((Context)context, (Callable)new zzt(context, webSettings));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public String zzb(Context context) {
        return "";
    }

    public void zzc(Context context) {
    }

    public Drawable zzd(Context context, Bitmap bitmap, boolean bl, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public int zze(ContentResolver contentResolver) {
        return Settings.System.getInt((ContentResolver)contentResolver, (String)"wifi_on", (int)0);
    }

    public int zzf(ContentResolver contentResolver) {
        return Settings.System.getInt((ContentResolver)contentResolver, (String)"airplane_mode_on", (int)0);
    }

    public boolean zzg(View view) {
        if (view.getWindowToken() != null) return true;
        if (view.getWindowVisibility() == 8) return false;
        return true;
    }

    public int zzh() {
        return 5;
    }

    public long zzi() {
        return -1L;
    }

    public ViewGroup.LayoutParams zzj() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public CookieManager zzk(Context context) {
        if (zzad.zzu()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance((Context)context);
            context = CookieManager.getInstance();
            return context;
        }
        catch (Throwable throwable) {
            zze.zzg((String)"Failed to obtain CookieManager.", (Throwable)throwable);
            com.google.android.gms.ads.internal.zzt.zzg().zzk(throwable, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzcms zzl(zzcml zzcml2, zzazb zzazb2, boolean bl) {
        return new zzcno(zzcml2, zzazb2, bl);
    }

    public int zzm() {
        return 1;
    }

    public WebResourceResponse zzn(String string, String string2, int n, String string3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(string, string2, inputStream);
    }

    public boolean zzo(Activity activity, Configuration configuration) {
        return false;
    }

    public int zzq(Context context, TelephonyManager telephonyManager) {
        return 1001;
    }

    public void zzr(Activity activity) {
    }
}
