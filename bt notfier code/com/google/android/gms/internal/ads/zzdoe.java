/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  com.google.android.gms.ads.internal.util.zzca
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbqc
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmw
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdny
 *  com.google.android.gms.internal.ads.zzdnz
 *  com.google.android.gms.internal.ads.zzdoa
 *  com.google.android.gms.internal.ads.zzdob
 *  com.google.android.gms.internal.ads.zzdoc
 *  com.google.android.gms.internal.ads.zzdod
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzdss
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbqc;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdny;
import com.google.android.gms.internal.ads.zzdnz;
import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzdob;
import com.google.android.gms.internal.ads.zzdoc;
import com.google.android.gms.internal.ads.zzdod;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzdss;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdoe {
    private final zzdss zza;
    private final zzdrh zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc;

    public zzdoe(zzdss zzdss2, zzdrh zzdrh2) {
        this.zza = zzdss2;
        this.zzb = zzdrh2;
        this.zzc = null;
    }

    private static final int zzf(Context context, String string, int n) {
        try {
            int n2;
            n = n2 = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {}
        zzber.zza();
        return zzcgm.zzs((Context)context, (int)n);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcmw {
        zzcml zzcml2 = this.zza.zzb(zzbdl.zzb(), null, null);
        View view2 = (View)zzcml2;
        view2.setVisibility(4);
        view2.setContentDescription((CharSequence)"policy_validator");
        zzcml2.zzab("/sendMessageToSdk", (zzbpr)new zzdny(this));
        zzcml2.zzab("/hideValidatorOverlay", (zzbpr)new zzdnz(this, windowManager, view));
        zzcml2.zzab("/open", (zzbpr)new zzbqc(null, null, null, null, null));
        this.zzb.zzi(new WeakReference<zzcml>(zzcml2), "/loadNativeAdPolicyViolations", (zzbpr)new zzdoa(this, view, windowManager));
        this.zzb.zzi(new WeakReference<zzcml>(zzcml2), "/showValidatorOverlay", zzdob.zza);
        return view2;
    }

    final /* synthetic */ void zzb(View object, WindowManager windowManager, zzcml zzcml2, Map map) {
        zzcml2.zzR().zzy((zzcnx)new zzdod(this, map));
        if (map == null) {
            return;
        }
        Context context = object.getContext();
        String string = (String)map.get("validator_width");
        Object object2 = zzbjl.zzfK;
        int n = zzdoe.zzf(context, string, (Integer)zzbet.zzc().zzc(object2));
        object2 = (String)map.get("validator_height");
        string = zzbjl.zzfL;
        int n2 = zzdoe.zzf(context, (String)object2, (Integer)zzbet.zzc().zzc((zzbjd)string));
        int n3 = zzdoe.zzf(context, (String)map.get("validator_x"), 0);
        int n4 = zzdoe.zzf(context, (String)map.get("validator_y"), 0);
        zzcml2.zzaf(zzcob.zzc((int)n, (int)n2));
        try {
            string = zzcml2.zzG().getSettings();
            context = zzbjl.zzfM;
            string.setUseWideViewPort(((Boolean)zzbet.zzc().zzc((zzbjd)context)).booleanValue());
            context = zzcml2.zzG().getSettings();
            string = zzbjl.zzfN;
            context.setLoadWithOverviewMode(((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue());
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        context = zzca.zzj();
        context.x = n3;
        context.y = n4;
        windowManager.updateViewLayout(zzcml2.zzH(), (ViewGroup.LayoutParams)context);
        string = (String)map.get("orientation");
        object2 = new Rect();
        if (object.getGlobalVisibleRect((Rect)object2)) {
            n2 = !"1".equals(string) && !"2".equals(string) ? object2.top : object2.bottom;
            this.zzc = new zzdoc(object, zzcml2, string, (WindowManager.LayoutParams)context, n2 - n4, windowManager);
            object = object.getViewTreeObserver();
            if (object != null && object.isAlive()) {
                object.addOnScrollChangedListener(this.zzc);
            }
        }
        object = (String)map.get("overlay_url");
        if (TextUtils.isEmpty((CharSequence)object)) return;
        zzcml2.loadUrl((String)object);
    }

    final /* synthetic */ void zzc(Map map, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String)map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    final /* synthetic */ void zzd(WindowManager windowManager, View view, zzcml zzcml2, Map map) {
        zze.zzd((String)"Hide native ad policy validator overlay.");
        zzcml2.zzH().setVisibility(8);
        if (zzcml2.zzH().getWindowToken() != null) {
            windowManager.removeView(zzcml2.zzH());
        }
        zzcml2.destroy();
        windowManager = view.getViewTreeObserver();
        if (this.zzc == null) return;
        if (windowManager == null) return;
        if (!windowManager.isAlive()) return;
        windowManager.removeOnScrollChangedListener(this.zzc);
    }

    final /* synthetic */ void zze(zzcml zzcml2, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }
}
