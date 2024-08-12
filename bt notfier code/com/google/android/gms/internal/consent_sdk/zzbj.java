/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Log
 *  com.google.android.gms.internal.consent_sdk.zzaj
 *  com.google.android.gms.internal.consent_sdk.zzat
 *  com.google.android.gms.internal.consent_sdk.zzbh
 *  com.google.android.gms.internal.consent_sdk.zzbl
 *  com.google.android.gms.internal.consent_sdk.zzbm
 *  com.google.android.gms.internal.consent_sdk.zzca
 *  com.google.android.gms.internal.consent_sdk.zze
 *  com.google.android.gms.internal.consent_sdk.zzi
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.consent_sdk.zzaj;
import com.google.android.gms.internal.consent_sdk.zzat;
import com.google.android.gms.internal.consent_sdk.zzbh;
import com.google.android.gms.internal.consent_sdk.zzbl;
import com.google.android.gms.internal.consent_sdk.zzbm;
import com.google.android.gms.internal.consent_sdk.zzca;
import com.google.android.gms.internal.consent_sdk.zze;
import com.google.android.gms.internal.consent_sdk.zzi;
import com.google.android.gms.internal.consent_sdk.zzk;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

final class zzbj
implements zzi {
    private final Application zza;
    private final zzbh zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzaj zzf;
    private final zzat zzg;

    zzbj(Application application, zzbh zzbh2, Handler handler, Executor executor, zze zze2, zzaj zzaj2, zzat zzat2) {
        this.zza = application;
        this.zzb = zzbh2;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zze2;
        this.zzf = zzaj2;
        this.zzg = zzat2;
    }

    /*
     * Enabled force condition propagation
     */
    private static JSONObject zza(Context object) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", (Object)object.getPackageManager().getApplicationLabel(object.getApplicationInfo()).toString());
            Drawable drawable = object.getPackageManager().getApplicationIcon(object.getApplicationInfo());
            if (drawable == null) {
                object = null;
            } else {
                object = Bitmap.createBitmap((int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Object object2 = new Canvas((Bitmap)object);
                drawable.setBounds(0, 0, object2.getWidth(), object2.getHeight());
                drawable.draw((Canvas)object2);
                object2 = new ByteArrayOutputStream();
                object.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)object2);
                object = String.valueOf(Base64.encodeToString((byte[])((ByteArrayOutputStream)object2).toByteArray(), (int)0));
                object = ((String)object).length() != 0 ? "data:image/png;base64,".concat((String)object) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", object);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return jSONObject;
        }
    }

    public final Executor zza() {
        Handler handler = this.zzc;
        handler.getClass();
        return zzbm.zza((Handler)handler);
    }

    final void zza(int n, String string, String string2) {
        this.zzg.zza(new zzk(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", n, string2, string)));
    }

    final void zza(String string) {
        String string2 = String.valueOf(string);
        string2 = string2.length() != 0 ? "Receive consent action: ".concat(string2) : new String("Receive consent action: ");
        Log.d((String)"UserMessagingPlatform", (String)string2);
        string2 = Uri.parse((String)string);
        string = string2.getQueryParameter("action");
        string2 = string2.getQueryParameter("args");
        this.zze.zza(string, string2, new zzi[]{this, this.zzf});
    }

    public final boolean zza(String string, JSONObject object) {
        block25: {
            int n;
            block24: {
                block22: {
                    block23: {
                        int n2;
                        int n3;
                        block21: {
                            n3 = string.hashCode();
                            n2 = -1;
                            n = 0;
                            switch (n3) {
                                default: {
                                    break;
                                }
                                case 1671672458: {
                                    if (!string.equals("dismiss")) break;
                                    n3 = 1;
                                    break block21;
                                }
                                case 150940456: {
                                    if (!string.equals("browser")) break;
                                    n3 = 2;
                                    break block21;
                                }
                                case -278739366: {
                                    if (!string.equals("configure_app_assets")) break;
                                    n3 = 3;
                                    break block21;
                                }
                                case -1370505102: {
                                    if (!string.equals("load_complete")) break;
                                    n3 = 0;
                                    break block21;
                                }
                            }
                            n3 = -1;
                        }
                        if (n3 == 0) {
                            this.zzg.zzb();
                            return true;
                        }
                        if (n3 != 1) {
                            Uri uri;
                            if (n3 != 2) {
                                if (n3 != 3) {
                                    return false;
                                }
                                this.zzd.execute((Runnable)new zzbl(this));
                                return true;
                            }
                            if (TextUtils.isEmpty((CharSequence)(object = object.optString("url")))) {
                                Log.d((String)"UserMessagingPlatform", (String)"Action[browser]: empty url.");
                            }
                            if ((uri = Uri.parse((String)object)).getScheme() == null) {
                                string = String.valueOf(object);
                                string = string.length() != 0 ? "Action[browser]: empty scheme: ".concat(string) : new String("Action[browser]: empty scheme: ");
                                Log.d((String)"UserMessagingPlatform", (String)string);
                            }
                            try {
                                string = new Intent("android.intent.action.VIEW", uri);
                                this.zzb.startActivity((Intent)string);
                            }
                            catch (ActivityNotFoundException activityNotFoundException) {
                                string = String.valueOf(object);
                                string = string.length() != 0 ? "Action[browser]: can not open url: ".concat(string) : new String("Action[browser]: can not open url: ");
                                zzca.zza((String)string, (Throwable)activityNotFoundException);
                            }
                            return true;
                        }
                        string = object.optString("status");
                        switch (string.hashCode()) {
                            default: {
                                n3 = n2;
                                break;
                            }
                            case 1666911234: {
                                n3 = n2;
                                if (!string.equals("non_personalized")) break;
                                n3 = 2;
                                break;
                            }
                            case 467888915: {
                                n3 = n2;
                                if (!string.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) break;
                                n3 = 1;
                                break;
                            }
                            case 429411856: {
                                n3 = n2;
                                if (!string.equals("CONSENT_SIGNAL_SUFFICIENT")) break;
                                n3 = 4;
                                break;
                            }
                            case -258041904: {
                                n3 = n2;
                                if (!string.equals("personalized")) break;
                                n3 = 0;
                                break;
                            }
                            case -954325659: {
                                n3 = n2;
                                if (!string.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) break;
                                n3 = 3;
                            }
                        }
                        if (n3 == 0 || n3 == 1) break block22;
                        if (n3 == 2 || n3 == 3) break block23;
                        if (n3 == 4) break block24;
                        this.zzg.zzb(new zzk(1, "We are getting something wrong with the webview."));
                        break block25;
                    }
                    n = 1;
                    break block24;
                }
                n = 2;
            }
            this.zzg.zza(3, n);
        }
        return true;
    }

    final /* synthetic */ void zzb() {
        JSONObject jSONObject = zzbj.zza((Context)this.zza);
        this.zzg.zza().zza("UMP_configureFormWithAppAssets", jSONObject);
    }
}
