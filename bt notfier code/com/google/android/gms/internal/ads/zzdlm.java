/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zzca
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzctq
 *  com.google.android.gms.internal.ads.zzdba
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdij
 *  com.google.android.gms.internal.ads.zzdim
 *  com.google.android.gms.internal.ads.zzdli
 *  com.google.android.gms.internal.ads.zzdlj
 *  com.google.android.gms.internal.ads.zzdlk
 *  com.google.android.gms.internal.ads.zzdmm
 *  com.google.android.gms.internal.ads.zzdmu
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzdno
 *  com.google.android.gms.internal.ads.zzdrh
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzca;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzctq;
import com.google.android.gms.internal.ads.zzdba;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdij;
import com.google.android.gms.internal.ads.zzdim;
import com.google.android.gms.internal.ads.zzdli;
import com.google.android.gms.internal.ads.zzdlj;
import com.google.android.gms.internal.ads.zzdlk;
import com.google.android.gms.internal.ads.zzdmm;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzdno;
import com.google.android.gms.internal.ads.zzdrh;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfsm;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzdlm
implements zzdmu {
    private final Context zza;
    private final zzdmx zzb;
    private final JSONObject zzc;
    private final zzdrh zzd;
    private final zzdmm zze;
    private final zzaas zzf;
    private final zzdbu zzg;
    private final zzdba zzh;
    private final zzdim zzi;
    private final zzezz zzj;
    private final zzcgz zzk;
    private final zzfar zzl;
    private final zzctq zzm;
    private final zzdno zzn;
    private final Clock zzo;
    private final zzdij zzp;
    private final zzffu zzq;
    private boolean zzr = false;
    private boolean zzs;
    private boolean zzt = false;
    private boolean zzu = false;
    private Point zzv = new Point();
    private Point zzw = new Point();
    private long zzx = 0L;
    private long zzy = 0L;
    private zzbgi zzz;

    public zzdlm(Context context, zzdmx zzdmx2, JSONObject jSONObject, zzdrh zzdrh2, zzdmm zzdmm2, zzaas zzaas2, zzdbu zzdbu2, zzdba zzdba2, zzdim zzdim2, zzezz zzezz2, zzcgz zzcgz2, zzfar zzfar2, zzctq zzctq2, zzdno zzdno2, Clock clock, zzdij zzdij2, zzffu zzffu2) {
        this.zza = context;
        this.zzb = zzdmx2;
        this.zzc = jSONObject;
        this.zzd = zzdrh2;
        this.zze = zzdmm2;
        this.zzf = zzaas2;
        this.zzg = zzdbu2;
        this.zzh = zzdba2;
        this.zzi = zzdim2;
        this.zzj = zzezz2;
        this.zzk = zzcgz2;
        this.zzl = zzfar2;
        this.zzm = zzctq2;
        this.zzn = zzdno2;
        this.zzo = clock;
        this.zzp = zzdij2;
        this.zzq = zzffu2;
    }

    private final boolean zzB(String string) {
        JSONObject jSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (jSONObject == null) return false;
        if (!jSONObject.optBoolean(string, false)) return false;
        return true;
    }

    private final String zzC(View view, Map<String, WeakReference<View>> entry2) {
        int n;
        if (entry2 != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry2 : entry2.entrySet()) {
                if (!view.equals((View)((WeakReference)entry2.getValue()).get())) continue;
                return (String)entry2.getKey();
            }
        }
        if ((n = this.zze.zzv()) == 1) return "1099";
        if (n == 2) return "2099";
        if (n == 6) return "3099";
        return null;
    }

    private final boolean zzD() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private final boolean zzE(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String string, JSONObject jSONObject5, boolean bl) {
        JSONObject jSONObject6;
        Preconditions.checkMainThread((String)"recordImpression must be called on the main UI thread.");
        try {
            jSONObject6 = new JSONObject();
            jSONObject6.put("ad", (Object)this.zzc);
            jSONObject6.put("asset_view_signal", (Object)jSONObject2);
            jSONObject6.put("ad_view_signal", (Object)jSONObject);
            jSONObject6.put("scroll_view_signal", (Object)jSONObject3);
            jSONObject6.put("lock_screen_signal", (Object)jSONObject4);
            jSONObject6.put("provided_signals", (Object)jSONObject5);
            jSONObject = zzbjl.zzca;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)jSONObject)).booleanValue()) {
                jSONObject6.put("view_signals", (Object)string);
            }
            jSONObject6.put("policy_validator_enabled", bl);
            jSONObject2 = this.zza;
            jSONObject = new JSONObject();
            com.google.android.gms.ads.internal.zzt.zzc();
            jSONObject3 = com.google.android.gms.ads.internal.util.zzs.zzy((WindowManager)((WindowManager)jSONObject2.getSystemService("window")));
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to create impression JSON.", (Throwable)jSONException);
            return false;
        }
        try {
            int n = jSONObject3.widthPixels;
            jSONObject.put("width", zzber.zza().zza((Context)jSONObject2, n));
            n = jSONObject3.heightPixels;
            jSONObject.put("height", zzber.zza().zza((Context)jSONObject2, n));
        }
        catch (JSONException jSONException) {
            jSONObject = null;
        }
        {
            jSONObject6.put("screen", (Object)jSONObject);
            jSONObject = zzbjl.zzgc;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)jSONObject)).booleanValue()) {
                jSONObject2 = this.zzd;
                jSONObject = new zzdlj(this, null);
                jSONObject2.zze("/clickRecorded", (zzbpr)jSONObject);
            } else {
                jSONObject = this.zzd;
                jSONObject2 = new zzdli(this, null);
                jSONObject.zze("/logScionEvent", (zzbpr)jSONObject2);
            }
            jSONObject = this.zzd;
            jSONObject2 = new zzdlk(this, null);
            jSONObject.zze("/nativeImpression", (zzbpr)jSONObject2);
            zzchj.zza((zzfsm)this.zzd.zzd("google.afma.nativeAds.handleImpression", jSONObject6), (String)"Error during performing handleImpression");
            if (this.zzr) return true;
        }
        this.zzr = com.google.android.gms.ads.internal.zzt.zzm().zzg(this.zza, this.zzk.zza, this.zzj.zzC.toString(), this.zzl.zzf);
        return true;
    }

    static /* synthetic */ zzdbu zza(zzdlm zzdlm2) {
        return zzdlm2.zzg;
    }

    static /* synthetic */ zzdba zzb(zzdlm zzdlm2) {
        return zzdlm2.zzh;
    }

    static /* synthetic */ zzdim zzc(zzdlm zzdlm2) {
        return zzdlm2.zzi;
    }

    public final void zzA() {
        this.zzd.zzc();
    }

    public final void zzd(View view, Map<String, WeakReference<View>> iterator, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzv = new Point();
        this.zzw = new Point();
        if (!this.zzs) {
            this.zzp.zza(view);
            this.zzs = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzk((Object)this);
        boolean bl = zzca.zza((int)this.zzk.zzc);
        if (iterator != null) {
            iterator = iterator.entrySet().iterator();
            while (iterator.hasNext()) {
                view = (View)iterator.next().getValue().get();
                if (view == null) continue;
                if (bl) {
                    view.setOnTouchListener(onTouchListener);
                }
                view.setClickable(true);
                view.setOnClickListener(onClickListener);
            }
        }
        if (map == null) return;
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            view = (View)iterator.next().getValue().get();
            if (view == null) continue;
            if (bl) {
                view.setOnTouchListener(onTouchListener);
            }
            view.setClickable(false);
        }
    }

    public final void zze(View view, Map<String, WeakReference<View>> map) {
        this.zzv = new Point();
        this.zzw = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzs = false;
    }

    public final void zzf(View view, View view2, Map<String, WeakReference<View>> object, Map<String, WeakReference<View>> jSONObject, boolean bl) {
        JSONObject jSONObject2 = zzca.zze((Context)this.zza, object, jSONObject, (View)view2);
        JSONObject jSONObject3 = zzca.zzb((Context)this.zza, (View)view2);
        jSONObject = zzca.zzc((View)view2);
        JSONObject jSONObject4 = zzca.zzd((Context)this.zza, (View)view2);
        object = this.zzC(view, (Map<String, WeakReference<View>>)object);
        JSONObject jSONObject5 = zzca.zzf((String)object, (Context)this.zza, (Point)this.zzw, (Point)this.zzv);
        zzbjd zzbjd2 = zzbjl.zzcb;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            view = view2;
        }
        this.zzl(view, jSONObject3, jSONObject2, jSONObject, jSONObject4, (String)object, jSONObject5, null, bl, false);
    }

    public final void zzg(String string) {
        this.zzl(null, null, null, null, null, string, null, null, false, false);
    }

    public final void zzh(Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Click data is null. No click is reported.");
            return;
        }
        if (!this.zzB("click_reporting")) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
            return;
        }
        Object object = bundle.getBundle("click_signal");
        object = object != null ? object.getString("asset_id") : null;
        this.zzl(null, null, null, null, null, (String)object, null, com.google.android.gms.ads.internal.zzt.zzc().zzk(bundle, null), false, false);
    }

    public final void zzi(View view, Map<String, WeakReference<View>> object, Map<String, WeakReference<View>> jSONObject, boolean bl) {
        if (!this.zzu) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!this.zzD()) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Custom click reporting failed. Ad unit id not in the allow list.");
            return;
        }
        JSONObject jSONObject2 = zzca.zze((Context)this.zza, object, jSONObject, (View)view);
        jSONObject = zzca.zzb((Context)this.zza, (View)view);
        JSONObject jSONObject3 = zzca.zzc((View)view);
        JSONObject jSONObject4 = zzca.zzd((Context)this.zza, (View)view);
        object = this.zzC(null, (Map<String, WeakReference<View>>)object);
        this.zzl(view, jSONObject, jSONObject2, jSONObject3, jSONObject4, (String)object, zzca.zzf((String)object, (Context)this.zza, (Point)this.zzw, (Point)this.zzv), null, bl, true);
    }

    public final void zzj() {
        this.zzu = true;
    }

    public final boolean zzk() {
        return this.zzD();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final void zzl(View var1_1, JSONObject var2_4, JSONObject var3_5, JSONObject var4_6, JSONObject var5_7, String var6_8, JSONObject var7_9, JSONObject var8_10, boolean var9_11, boolean var10_12) {
        Preconditions.checkMainThread((String)"performClick must be called on the main UI thread.");
        var15_13 = new JSONObject();
        var15_13.put("ad", (Object)this.zzc);
        var15_13.put("asset_view_signal", (Object)var3_5);
        var15_13.put("ad_view_signal", (Object)var2_4 /* !! */ );
        var15_13.put("click_signal", (Object)var7_9);
        var15_13.put("scroll_view_signal", (Object)var4_6);
        var15_13.put("lock_screen_signal", (Object)var5_7);
        var2_4 /* !! */  = this.zzb.zzg(this.zze.zzQ());
        var12_14 = false;
        var11_15 = var2_4 /* !! */  != null;
        var15_13.put("has_custom_click_handler", var11_15);
        var15_13.put("provided_signals", (Object)var8_10);
        var4_6 = new JSONObject();
        var4_6.put("asset_id", (Object)var6_8);
        var4_6.put("template", this.zze.zzv());
        var4_6.put("view_aware_api_used", var9_11);
        var2_4 /* !! */  = this.zzl.zzi;
        var9_11 = var2_4 /* !! */  != null && var2_4 /* !! */ .zzg != false;
        var4_6.put("custom_mute_requested", var9_11);
        var9_11 = this.zze.zzC().isEmpty() == false && this.zze.zzD() != null;
        var4_6.put("custom_mute_enabled", var9_11);
        if (this.zzn.zzb() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            var4_6.put("custom_one_point_five_click_eligible", true);
        }
        var4_6.put("timestamp", this.zzo.currentTimeMillis());
        if (this.zzu && this.zzD()) {
            var4_6.put("custom_click_gesture_eligible", true);
        }
        if (var10_12) {
            var4_6.put("is_custom_click_gesture", true);
        }
        var9_11 = var12_14;
        if (this.zzb.zzg(this.zze.zzQ()) != null) {
            var9_11 = true;
        }
        var4_6.put("has_custom_click_handler", var9_11);
        {
            catch (JSONException var1_3) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to create click JSON.", (Throwable)var1_3);
                return;
            }
            try {
                var2_4 /* !! */  = var3_5 = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (var3_5 == null) {
                    var2_4 /* !! */  = new JSONObject();
                }
                var2_4 /* !! */  = var2_4 /* !! */ .optString("click_string");
                var1_1 /* !! */  = this.zzf.zzb().zzm(this.zza, (String)var2_4 /* !! */ , var1_1 /* !! */ );
                ** GOTO lbl67
            }
            catch (Exception var1_2) {}
            {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Exception obtaining click signals", (Throwable)var1_2);
                var1_1 /* !! */  = null;
lbl67:
                // 2 sources

                var4_6.put("click_signals", (Object)var1_1 /* !! */ );
                var1_1 /* !! */  = zzbjl.zzcY;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)var1_1 /* !! */ )).booleanValue()) {
                    var4_6.put("open_chrome_custom_tab", true);
                }
                var1_1 /* !! */  = zzbjl.zzgg;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)var1_1 /* !! */ )).booleanValue() && PlatformVersion.isAtLeastR()) {
                    var4_6.put("try_fallback_for_deep_link", true);
                }
                var1_1 /* !! */  = zzbjl.zzgh;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)var1_1 /* !! */ )).booleanValue() && PlatformVersion.isAtLeastR()) {
                    var4_6.put("in_app_link_handling_for_android_11_enabled", true);
                }
                var15_13.put("click", (Object)var4_6);
                var1_1 /* !! */  = new JSONObject();
                var13_16 = this.zzo.currentTimeMillis();
                var1_1 /* !! */ .put("time_from_last_touch_down", var13_16 - this.zzx);
                var1_1 /* !! */ .put("time_from_last_touch", var13_16 - this.zzy);
                var15_13.put("touch_signal", (Object)var1_1 /* !! */ );
                zzchj.zza((zzfsm)this.zzd.zzd("google.afma.nativeAds.handleClick", var15_13), (String)"Error during performing handleClick");
                return;
            }
        }
    }

    public final void zzm(View view, MotionEvent motionEvent, View view2) {
        long l;
        this.zzv = zzca.zzh((MotionEvent)motionEvent, (View)view2);
        this.zzy = l = this.zzo.currentTimeMillis();
        if (motionEvent.getAction() == 0) {
            this.zzx = l;
            this.zzw = this.zzv;
        }
        view = MotionEvent.obtain((MotionEvent)motionEvent);
        view.setLocation((float)this.zzv.x, (float)this.zzv.y);
        this.zzf.zzd((MotionEvent)view);
        view.recycle();
    }

    public final void zzn(Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Touch event data is null. No touch event is reported.");
            return;
        }
        if (!this.zzB("touch_reporting")) {
            com.google.android.gms.ads.internal.util.zze.zzf((String)"The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
            return;
        }
        float f = bundle.getFloat("x");
        float f2 = bundle.getFloat("y");
        int n = bundle.getInt("duration_ms");
        this.zzf.zzb().zzk((int)f, (int)f2, n);
    }

    public final JSONObject zzo(View view, Map<String, WeakReference<View>> jSONObject, Map<String, WeakReference<View>> jSONObject2) {
        jSONObject = zzca.zze((Context)this.zza, jSONObject, jSONObject2, (View)view);
        jSONObject2 = zzca.zzb((Context)this.zza, (View)view);
        JSONObject jSONObject3 = zzca.zzc((View)view);
        JSONObject jSONObject4 = zzca.zzd((Context)this.zza, (View)view);
        try {
            view = new JSONObject();
            view.put("asset_view_signal", (Object)jSONObject);
            view.put("ad_view_signal", (Object)jSONObject2);
            view.put("scroll_view_signal", (Object)jSONObject3);
            view.put("lock_screen_signal", (Object)jSONObject4);
            return view;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to create native ad view signals JSON.", (Throwable)jSONException);
            return null;
        }
    }

    public final JSONObject zzp(View view, Map<String, WeakReference<View>> jSONObject, Map<String, WeakReference<View>> map) {
        jSONObject = this.zzo(view, (Map<String, WeakReference<View>>)jSONObject, map);
        view = new JSONObject();
        try {
            if (this.zzu && this.zzD()) {
                view.put("custom_click_gesture_eligible", true);
            }
            if (jSONObject == null) return view;
            view.put("nas", (Object)jSONObject);
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to create native click meta data JSON.", (Throwable)jSONException);
        }
        return view;
    }

    public final void zzq() {
        this.zzE(null, null, null, null, null, null, false);
    }

    public final void zzr(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdno zzdno2 = this.zzn;
        if (view == null) {
            return;
        }
        view.setOnClickListener((View.OnClickListener)zzdno2);
        view.setClickable(true);
        zzdno2.zzc = new WeakReference<View>(view);
    }

    public final void zzs(zzbob zzbob2) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        this.zzn.zza(zzbob2);
    }

    public final void zzt() {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            return;
        }
        this.zzn.zzc();
    }

    public final void zzu(zzbgm zzbgm2) {
        try {
            if (this.zzt) {
                return;
            }
            if (zzbgm2 == null && this.zze.zzD() != null) {
                this.zzt = true;
                this.zzq.zzb(this.zze.zzD().zzf());
                this.zzw();
                return;
            }
            this.zzt = true;
            this.zzq.zzb(zzbgm2.zzf());
            this.zzw();
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzv(zzbgi zzbgi2) {
        this.zzz = zzbgi2;
    }

    public final void zzw() {
        try {
            zzbgi zzbgi2 = this.zzz;
            if (zzbgi2 == null) return;
            zzbgi2.zze();
            return;
        }
        catch (RemoteException remoteException) {
            com.google.android.gms.ads.internal.util.zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }

    public final void zzx(View object, Map<String, WeakReference<View>> jSONObject, Map<String, WeakReference<View>> jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        block3: {
            jSONObject4 = zzca.zze((Context)this.zza, jSONObject, jSONObject2, (View)object);
            jSONObject3 = zzca.zzb((Context)this.zza, (View)object);
            jSONObject = zzca.zzc((View)object);
            jSONObject2 = zzca.zzd((Context)this.zza, (View)object);
            zzbjd zzbjd2 = zzbjl.zzca;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                try {
                    object = this.zzf.zzb().zzo(this.zza, object, null);
                    break block3;
                }
                catch (Exception exception) {
                    com.google.android.gms.ads.internal.util.zze.zzf((String)"Exception getting data.");
                }
            }
            object = null;
        }
        this.zzE(jSONObject3, jSONObject4, jSONObject, jSONObject2, (String)object, null, zzca.zzi((Context)this.zza, (zzezz)this.zzj));
    }

    public final void zzy() {
        Preconditions.checkMainThread((String)"recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", (Object)this.zzc);
            zzchj.zza((zzfsm)this.zzd.zzd("google.afma.nativeAds.handleDownloadedImpression", jSONObject), (String)"Error during performing handleDownloadedImpression");
            return;
        }
        catch (JSONException jSONException) {
            zzcgt.zzg((String)"", (Throwable)jSONException);
            return;
        }
    }

    public final boolean zzz(Bundle bundle) {
        if (this.zzB("impression_reporting")) return this.zzE(null, null, null, null, null, com.google.android.gms.ads.internal.zzt.zzc().zzk(bundle, null), false);
        com.google.android.gms.ads.internal.util.zze.zzf((String)"The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
        return false;
    }
}
