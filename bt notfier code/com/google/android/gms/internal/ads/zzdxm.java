/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.Base64
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdxm {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final int zzc;
    private final int zzd;
    private String zze = "";

    public zzdxm(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        context = zzbjl.zzgC;
        this.zzc = (Integer)zzbet.zzc().zzc((zzbjd)context);
        context = zzbjl.zzgD;
        this.zzd = (Integer)zzbet.zzc().zzc((zzbjd)context);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", (Object)Wrappers.packageManager((Context)this.zza).getApplicationLabel(this.zzb.packageName));
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            // empty catch block
        }
        jSONObject.put("packageName", (Object)this.zzb.packageName);
        zzt.zzc();
        jSONObject.put("adMobAppId", (Object)zzs.zzv((Context)this.zza));
        if (this.zze.isEmpty()) {
            Object object;
            try {
                object = (Drawable)Wrappers.packageManager((Context)this.zza).getApplicationLabelAndIcon((String)this.zzb.packageName).second;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = null;
            }
            if (object == null) {
                object = "";
            } else {
                object.setBounds(0, 0, this.zzc, this.zzd);
                Bitmap bitmap = Bitmap.createBitmap((int)this.zzc, (int)this.zzd, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                object.draw(new Canvas(bitmap));
                object = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)object);
                object = Base64.encodeToString((byte[])((ByteArrayOutputStream)object).toByteArray(), (int)2);
            }
            this.zze = object;
        }
        if (this.zze.isEmpty()) return jSONObject;
        jSONObject.put("icon", (Object)this.zze);
        jSONObject.put("iconWidthPx", this.zzc);
        jSONObject.put("iconHeightPx", this.zzd);
        return jSONObject;
    }
}
