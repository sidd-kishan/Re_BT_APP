/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.media.AudioManager
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  android.text.TextUtils
 *  android.view.WindowManager
 *  com.google.android.gms.ads.internal.util.zzae
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzavz
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzctp
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzavz;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzctp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzctm
implements zzbtz<zzctp> {
    private final Context zza;
    private final zzavz zzb;
    private final PowerManager zzc;

    public zzctm(Context context, zzavz zzavz2) {
        this.zza = context;
        this.zzb = zzavz2;
        this.zzc = (PowerManager)context.getSystemService("power");
    }

    public final JSONObject zza(zzctp zzctp2) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        Object object = zzctp2.zzf;
        if (object == null) {
            zzctp2 = new JSONObject();
        } else {
            if (this.zzb.zzc() == null) {
                zzctp2 = new JSONException("Active view Info cannot be null.");
                throw zzctp2;
            }
            boolean bl = ((zzawc)object).zza;
            JSONObject jSONObject2 = new JSONObject();
            Object object2 = jSONObject2.put("afmaVersion", (Object)this.zzb.zzb()).put("activeViewJSON", (Object)this.zzb.zzc()).put("timestamp", zzctp2.zzd).put("adFormat", (Object)this.zzb.zza()).put("hashCode", (Object)this.zzb.zzd()).put("isMraid", false);
            boolean bl2 = zzctp2.zzc;
            object2 = object2.put("isStopped", false).put("isPaused", zzctp2.zzb).put("isNative", this.zzb.zze());
            bl2 = Build.VERSION.SDK_INT >= 20 ? this.zzc.isInteractive() : this.zzc.isScreenOn();
            object2.put("isScreenOn", bl2).put("appMuted", zzt.zzh().zzd()).put("appVolume", (double)zzt.zzh().zzb()).put("deviceVolume", (double)zzae.zze((Context)this.zza.getApplicationContext()));
            object2 = zzbjl.zzdY;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue() && (object2 = (object2 = (AudioManager)this.zza.getApplicationContext().getSystemService("audio")) == null ? null : Integer.valueOf(object2.getMode())) != null) {
                jSONObject2.put("audioMode", object2);
            }
            object2 = new Rect();
            Object object3 = ((WindowManager)this.zza.getSystemService("window")).getDefaultDisplay();
            object2.right = object3.getWidth();
            object2.bottom = object3.getHeight();
            object2 = this.zza.getResources().getDisplayMetrics();
            jSONObject2.put("windowVisibility", ((zzawc)object).zzb).put("isAttachedToWindow", bl).put("viewBox", (Object)new JSONObject().put("top", ((zzawc)object).zzc.top).put("bottom", ((zzawc)object).zzc.bottom).put("left", ((zzawc)object).zzc.left).put("right", ((zzawc)object).zzc.right)).put("adBox", (Object)new JSONObject().put("top", ((zzawc)object).zzd.top).put("bottom", ((zzawc)object).zzd.bottom).put("left", ((zzawc)object).zzd.left).put("right", ((zzawc)object).zzd.right)).put("globalVisibleBox", (Object)new JSONObject().put("top", ((zzawc)object).zze.top).put("bottom", ((zzawc)object).zze.bottom).put("left", ((zzawc)object).zze.left).put("right", ((zzawc)object).zze.right)).put("globalVisibleBoxVisible", ((zzawc)object).zzf).put("localVisibleBox", (Object)new JSONObject().put("top", ((zzawc)object).zzg.top).put("bottom", ((zzawc)object).zzg.bottom).put("left", ((zzawc)object).zzg.left).put("right", ((zzawc)object).zzg.right)).put("localVisibleBoxVisible", ((zzawc)object).zzh).put("hitBox", (Object)new JSONObject().put("top", ((zzawc)object).zzi.top).put("bottom", ((zzawc)object).zzi.bottom).put("left", ((zzawc)object).zzi.left).put("right", ((zzawc)object).zzi.right)).put("screenDensity", (double)object2.density);
            jSONObject2.put("isVisible", zzctp2.zza);
            object2 = zzbjl.zzaU;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue()) {
                object2 = new JSONArray();
                object = ((zzawc)object).zzk;
                if (object != null) {
                    object3 = object.iterator();
                    while (object3.hasNext()) {
                        object = (Rect)object3.next();
                        object2.put((Object)new JSONObject().put("top", ((Rect)object).top).put("bottom", ((Rect)object).bottom).put("left", ((Rect)object).left).put("right", ((Rect)object).right));
                    }
                }
                jSONObject2.put("scrollableContainerBoxes", object2);
            }
            if (!TextUtils.isEmpty((CharSequence)zzctp2.zze)) {
                jSONObject2.put("doneReasonCode", (Object)"u");
            }
            zzctp2 = jSONObject2;
        }
        jSONArray.put((Object)zzctp2);
        jSONObject.put("units", (Object)jSONArray);
        return jSONObject;
    }
}
