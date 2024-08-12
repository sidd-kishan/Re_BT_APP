/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzaw
 *  com.google.android.gms.ads.internal.util.zzay
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.IOUtils
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdyb
 *  com.google.android.gms.internal.ads.zzdyc
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzaw;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaz {
    protected String zza = "";
    private final Object zzb = new Object();
    private String zzc = "";
    private String zzd = "";
    private boolean zze = false;
    private boolean zzf = false;
    private zzdyc zzg;

    protected static final String zzo(Context object, String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("User-Agent", zzt.zzc().zzi((Context)object, string2));
        string2 = new zzbr((Context)object).zzb(0, string, hashMap, null);
        try {
            object = zzbjl.zzdh;
            object = (String)string2.get((long)((Integer)zzbet.zzc().zzc((zzbjd)object)).intValue(), TimeUnit.MILLISECONDS);
            return object;
        }
        catch (Exception exception) {
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "Error retrieving a response from: ".concat((String)object) : new String("Error retrieving a response from: ");
            com.google.android.gms.ads.internal.util.zze.zzg((String)object, (Throwable)exception);
        }
        catch (InterruptedException interruptedException) {
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "Interrupted while retrieving a response from: ".concat((String)object) : new String("Interrupted while retrieving a response from: ");
            com.google.android.gms.ads.internal.util.zze.zzg((String)object, (Throwable)interruptedException);
            string2.cancel(true);
        }
        catch (TimeoutException timeoutException) {
            object = String.valueOf(string);
            object = ((String)object).length() != 0 ? "Timeout while retrieving a response from: ".concat((String)object) : new String("Timeout while retrieving a response from: ");
            com.google.android.gms.ads.internal.util.zze.zzg((String)object, (Throwable)timeoutException);
            string2.cancel(true);
        }
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final Uri zzp(Context object, String string, String string2, String string3) {
        Uri.Builder builder = Uri.parse((String)string).buildUpon();
        Object object2 = this.zzb;
        synchronized (object2) {
            if (TextUtils.isEmpty((CharSequence)this.zzc)) {
                zzt.zzc();
                try {
                    FileInputStream fileInputStream = object.openFileInput("debug_signals_id.txt");
                    string = new String(IOUtils.readInputStreamFully((InputStream)fileInputStream, (boolean)true), "UTF-8");
                }
                catch (IOException iOException) {
                    com.google.android.gms.ads.internal.util.zze.zzd((String)"Error reading from internal storage.");
                    string = "";
                }
                this.zzc = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    zzt.zzc();
                    this.zzc = UUID.randomUUID().toString();
                    zzt.zzc();
                    string = this.zzc;
                    try {
                        object = object.openFileOutput("debug_signals_id.txt", 0);
                        ((FileOutputStream)object).write(string.getBytes("UTF-8"));
                        ((FileOutputStream)object).close();
                    }
                    catch (Exception exception) {
                        com.google.android.gms.ads.internal.util.zze.zzg((String)"Error writing to file in internal storage.", (Throwable)exception);
                    }
                }
            }
            object = this.zzc;
        }
        builder.appendQueryParameter("linkedDeviceId", (String)object);
        builder.appendQueryParameter("adSlotPath", string2);
        builder.appendQueryParameter("afmaVersion", string3);
        return builder.build();
    }

    public final void zza(zzdyc zzdyc2) {
        this.zzg = zzdyc2;
    }

    public final zzdyc zzb() {
        return this.zzg;
    }

    public final void zzc(Context context) {
        zzbjd zzbjd2 = zzbjl.zzgE;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        zzbjd2 = this.zzg;
        if (zzbjd2 == null) return;
        zzbjd2.zzk((zzbgq)new zzaw(this, context), zzdyb.zzd);
    }

    final boolean zzd(Context object, String object2, String string) {
        zzbjd zzbjd2 = zzbjl.zzde;
        if (TextUtils.isEmpty((CharSequence)(object = zzaz.zzo((Context)object, this.zzp((Context)object, (String)zzbet.zzc().zzc(zzbjd2), (String)object2, string).toString(), string)))) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Not linked for in app preview.");
            return false;
        }
        object = ((String)object).trim();
        try {
            string = new JSONObject((String)object);
            object = string.optString("gct");
            this.zza = string.optString("status");
            string = zzbjl.zzgE;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
                boolean bl = "0".equals(this.zza) || "2".equals(this.zza);
                this.zzj(bl);
                string = zzt.zzg().zzp();
                if (!bl) {
                    object2 = "";
                }
                string.zzL((String)object2);
            }
            object2 = this.zzb;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Fail to get in app preview response json.", (Throwable)jSONException);
            return false;
        }
        synchronized (object2) {
            this.zzd = object;
            return true;
        }
    }

    public final boolean zze(Context object, String string, String string2) {
        boolean bl;
        zzbjd zzbjd2 = zzbjl.zzdf;
        if (TextUtils.isEmpty((CharSequence)(object = zzaz.zzo((Context)object, this.zzp((Context)object, (String)zzbet.zzc().zzc(zzbjd2), string, string2).toString(), string2)))) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Not linked for debug signals.");
            return false;
        }
        object = ((String)object).trim();
        try {
            string2 = new JSONObject((String)object);
            object = string2.optString("debug_mode");
            bl = "1".equals(object);
            this.zzj(bl);
            object = zzbjl.zzgE;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return bl;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Fail to get debug mode response json.", (Throwable)jSONException);
            return false;
        }
        object = zzt.zzg().zzp();
        if (!bl) {
            string = "";
        }
        object.zzL(string);
        return bl;
    }

    public final void zzf(Context context, String string, String string2) {
        zzt.zzc();
        zzbjd zzbjd2 = zzbjl.zzdd;
        zzs.zzX((Context)context, (Uri)this.zzp(context, (String)zzbet.zzc().zzc(zzbjd2), string, string2));
    }

    public final boolean zzg(Context context, String string, String string2, String string3) {
        if (TextUtils.isEmpty((CharSequence)string2)) return false;
        if (!this.zzm()) {
            return false;
        }
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Sending troubleshooting signals to the server.");
        this.zzh(context, string, string2, string3);
        return true;
    }

    public final void zzh(Context context, String string, String string2, String string3) {
        zzbjd zzbjd2 = zzbjl.zzdg;
        string3 = this.zzp(context, (String)zzbet.zzc().zzc(zzbjd2), string3, string).buildUpon();
        string3.appendQueryParameter("debugData", string2);
        zzt.zzc();
        zzs.zzN((Context)context, (String)string, (String)string3.build().toString());
    }

    public final String zzi() {
        Object object = this.zzb;
        synchronized (object) {
            String string = this.zzd;
            return string;
        }
    }

    public final void zzj(boolean bl) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzf = bl;
            zzbjd zzbjd2 = zzbjl.zzgE;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
            zzt.zzg().zzp().zzJ(bl);
            zzbjd2 = this.zzg;
            if (zzbjd2 == null) return;
            zzbjd2.zzb(bl);
            return;
        }
    }

    public final boolean zzk() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl = this.zzf;
            return bl;
        }
    }

    public final void zzl(boolean bl) {
        Object object = this.zzb;
        synchronized (object) {
            this.zze = bl;
            return;
        }
    }

    public final boolean zzm() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl = this.zze;
            return bl;
        }
    }

    protected final void zzn(Context context, String string, boolean bl, boolean bl2) {
        if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.zze.zzh((String)"Can not create dialog without Activity Context");
            return;
        }
        zzs.zza.post((Runnable)new zzay(this, context, string, bl, bl2));
    }
}
