/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.provider.Settings$Global
 *  android.renderscript.Allocation
 *  android.renderscript.Element
 *  android.renderscript.RenderScript
 *  android.renderscript.ScriptIntrinsicBlur
 *  android.text.TextUtils
 *  android.webkit.WebSettings
 *  com.google.android.gms.ads.internal.util.zzad
 *  com.google.android.gms.ads.internal.util.zzce
 *  com.google.android.gms.ads.internal.util.zzcf
 *  com.google.android.gms.ads.internal.util.zzcg
 *  com.google.android.gms.ads.internal.util.zzch
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.common.util.SharedPreferencesUtils
 */
package com.google.android.gms.ads.internal.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzce;
import com.google.android.gms.ads.internal.util.zzcf;
import com.google.android.gms.ads.internal.util.zzcg;
import com.google.android.gms.ads.internal.util.zzch;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

public class zzu
extends zzad {
    public zzu() {
        super(null);
    }

    public final boolean zza(Context context, WebSettings webSettings) {
        super.zza(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    public final String zzb(Context object) {
        zzch zzch2 = zzch.zza();
        if (!TextUtils.isEmpty((CharSequence)zzch2.zza)) return zzch2.zza;
        object = ClientLibraryUtils.isPackageSide() ? (String)zzce.zza((Context)object, (Callable)new zzcf(zzch2, object)) : (String)zzce.zza((Context)object, (Callable)new zzcg(zzch2, GooglePlayServicesUtilLight.getRemoteContext((Context)object), object));
        zzch2.zza = object;
        return zzch2.zza;
    }

    public final void zzc(Context context) {
        block5: {
            String string;
            block7: {
                Context context2;
                Object object;
                block6: {
                    zzch zzch2 = zzch.zza();
                    zze.zza((String)"Updating user agent.");
                    string = WebSettings.getDefaultUserAgent((Context)context);
                    if (string.equals(zzch2.zza)) break block5;
                    context2 = object = GooglePlayServicesUtilLight.getRemoteContext((Context)context);
                    if (ClientLibraryUtils.isPackageSide()) break block6;
                    if (object != null) break block7;
                    context2 = null;
                }
                object = WebSettings.getDefaultUserAgent((Context)context);
                object = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", (String)object);
                if (context2 == null) {
                    object.apply();
                } else {
                    SharedPreferencesUtils.publishWorldReadableSharedPreferences((Context)context, (SharedPreferences.Editor)object, (String)"admob_user_agent");
                }
            }
            zzch2.zza = string;
        }
        zze.zza((String)"User agent is updated.");
    }

    public final Drawable zzd(Context context, Bitmap bitmap, boolean bl, float f) {
        if (!bl) return new BitmapDrawable(context.getResources(), bitmap);
        if (f <= 0.0f) return new BitmapDrawable(context.getResources(), bitmap);
        if (f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (boolean)false);
            Bitmap bitmap3 = Bitmap.createBitmap((Bitmap)bitmap2);
            RenderScript renderScript = RenderScript.create((Context)context);
            ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)renderScript, (Element)Element.U8_4((RenderScript)renderScript));
            bitmap2 = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap2);
            renderScript = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap3);
            scriptIntrinsicBlur.setRadius(f);
            scriptIntrinsicBlur.setInput((Allocation)bitmap2);
            scriptIntrinsicBlur.forEach((Allocation)renderScript);
            renderScript.copyTo(bitmap3);
            bitmap3 = new BitmapDrawable(context.getResources(), bitmap3);
            return bitmap3;
        }
        catch (RuntimeException runtimeException) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    public final int zze(ContentResolver contentResolver) {
        return Settings.Global.getInt((ContentResolver)contentResolver, (String)"wifi_on", (int)0);
    }

    public final int zzf(ContentResolver contentResolver) {
        return Settings.Global.getInt((ContentResolver)contentResolver, (String)"airplane_mode_on", (int)0);
    }
}
