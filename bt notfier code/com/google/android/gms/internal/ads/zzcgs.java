/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.provider.Settings$Global
 *  android.util.JsonWriter
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.common.util.DefaultClock
 *  com.google.android.gms.internal.ads.zzbkv
 *  com.google.android.gms.internal.ads.zzcgn
 *  com.google.android.gms.internal.ads.zzcgo
 *  com.google.android.gms.internal.ads.zzcgp
 *  com.google.android.gms.internal.ads.zzcgq
 *  com.google.android.gms.internal.ads.zzcgr
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzcgn;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzcgq;
import com.google.android.gms.internal.ads.zzcgr;
import com.google.android.gms.internal.ads.zzcgt;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class zzcgs {
    public static final int zza = 0;
    private static final Object zzb = new Object();
    private static boolean zzc = false;
    private static boolean zzd = false;
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set<String> zzf = new HashSet<String>(Arrays.asList(new String[0]));
    private final List<String> zzg;

    public zzcgs() {
        this(null);
    }

    public zzcgs(String object) {
        if (!zzcgs.zzj()) {
            object = new ArrayList();
        } else {
            object = String.valueOf(UUID.randomUUID().toString());
            object = ((String)object).length() != 0 ? "network_request_".concat((String)object) : new String("network_request_");
            object = Arrays.asList(object);
        }
        this.zzg = object;
    }

    public static void zzg() {
        Object object = zzb;
        synchronized (object) {
            zzc = false;
            zzd = false;
            zzcgt.zzi((String)"Ad debug logging enablement is out of date.");
            return;
        }
    }

    public static void zzh(boolean bl) {
        Object object = zzb;
        synchronized (object) {
            zzc = true;
            zzd = bl;
            return;
        }
    }

    public static boolean zzi() {
        Object object = zzb;
        synchronized (object) {
            boolean bl = zzc;
            return bl;
        }
    }

    public static boolean zzj() {
        Object object = zzb;
        synchronized (object) {
            boolean bl;
            boolean bl2 = zzc;
            boolean bl3 = bl = false;
            if (!bl2) return bl3;
            bl3 = bl;
            if (!zzd) return bl3;
            bl3 = true;
            return bl3;
        }
    }

    public static boolean zzk(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean)zzbkv.zza.zze()).booleanValue()) {
            return false;
        }
        try {
            int n = Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"development_settings_enabled", (int)0);
            if (n == 0) return false;
            return true;
        }
        catch (Exception exception) {
            zzcgt.zzj((String)"Fail to determine debug setting.", (Throwable)exception);
            return false;
        }
    }

    static final /* synthetic */ void zzl(int n, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long)n);
        jsonWriter.endObject();
        zzcgs.zzq(jsonWriter, map);
        jsonWriter.endObject();
    }

    static final /* synthetic */ void zzm(String string, String string2, Map map, byte[] byArray, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(string);
        jsonWriter.name("verb").value(string2);
        jsonWriter.endObject();
        zzcgs.zzq(jsonWriter, map);
        if (byArray != null) {
            jsonWriter.name("body").value(Base64Utils.encode((byte[])byArray));
        }
        jsonWriter.endObject();
    }

    private final void zzn(String string, String string2, Map<String, ?> map, byte[] byArray) {
        this.zzr("onNetworkRequest", (zzcgr)new zzcgn(string, string2, map, byArray));
    }

    private final void zzo(Map<String, ?> map, int n) {
        this.zzr("onNetworkResponse", (zzcgr)new zzcgo(n, map));
    }

    private final void zzp(String string) {
        this.zzr("onNetworkRequestError", (zzcgr)new zzcgq(string));
    }

    private static void zzq(JsonWriter jsonWriter, Map<String, ?> object) throws IOException {
        if (object == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        for (Map.Entry<String, ?> entry : object.entrySet()) {
            object = entry.getKey();
            if (zzf.contains(object)) continue;
            if (entry.getValue() instanceof List) {
                entry = ((List)entry.getValue()).iterator();
                while (entry.hasNext()) {
                    String string = (String)entry.next();
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value((String)object);
                    jsonWriter.name("value").value(string);
                    jsonWriter.endObject();
                }
                continue;
            }
            if (entry.getValue() instanceof String) {
                jsonWriter.beginObject();
                jsonWriter.name("name").value((String)object);
                jsonWriter.name("value").value((String)entry.getValue());
                jsonWriter.endObject();
                continue;
            }
            zzcgt.zzf((String)"Connection headers should be either Map<String, String> or Map<String, List<String>>");
            break;
        }
        jsonWriter.endArray();
    }

    private final void zzr(String object, zzcgr zzcgr2) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter((Writer)stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name("event").value((String)object);
            jsonWriter.name("components").beginArray();
            object = this.zzg.iterator();
            while (object.hasNext()) {
                jsonWriter.value((String)object.next());
            }
            jsonWriter.endArray();
            zzcgr2.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        }
        catch (IOException iOException) {
            zzcgt.zzg((String)"unable to log", (Throwable)iOException);
        }
        zzcgs.zzs(stringWriter.toString());
    }

    private static void zzs(String string) {
        synchronized (zzcgs.class) {
            zzcgt.zzh((String)"GMA Debug BEGIN");
            int n = 0;
            while (n < string.length()) {
                int n2 = n + 4000;
                String string2 = String.valueOf(string.substring(n, Math.min(n2, string.length())));
                string2 = string2.length() != 0 ? "GMA Debug CONTENT ".concat(string2) : new String("GMA Debug CONTENT ");
                zzcgt.zzh((String)string2);
                n = n2;
            }
            zzcgt.zzh((String)"GMA Debug FINISH");
            return;
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] byArray) {
        if (!zzcgs.zzj()) {
            return;
        }
        HashMap<String, List<String>> hashMap = httpURLConnection.getRequestProperties() == null ? null : new HashMap<String, List<String>>(httpURLConnection.getRequestProperties());
        this.zzn(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, byArray);
    }

    public final void zzb(String string, String string2, Map<String, ?> map, byte[] byArray) {
        if (!zzcgs.zzj()) {
            return;
        }
        this.zzn(string, "GET", map, byArray);
    }

    public final void zzc(HttpURLConnection object, int n) {
        if (!zzcgs.zzj()) {
            return;
        }
        Map<String, List<String>> map = ((URLConnection)object).getHeaderFields();
        Object var4_5 = null;
        map = map == null ? null : new HashMap<String, List<String>>(((URLConnection)object).getHeaderFields());
        this.zzo(map, n);
        if (n >= 200) {
            if (n < 300) return;
        }
        try {
            object = ((HttpURLConnection)object).getResponseMessage();
        }
        catch (IOException iOException) {
            object = String.valueOf(iOException.getMessage());
            object = ((String)object).length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat((String)object) : new String("Can not get error message from error HttpURLConnection\n");
            zzcgt.zzi((String)object);
            object = var4_5;
        }
        this.zzp((String)object);
    }

    public final void zzd(Map<String, ?> map, int n) {
        if (!zzcgs.zzj()) {
            return;
        }
        this.zzo(map, n);
        if (n >= 200) {
            if (n < 300) return;
        }
        this.zzp(null);
    }

    public final void zze(String string) {
        if (!zzcgs.zzj()) {
            return;
        }
        if (string == null) {
            return;
        }
        this.zzf(string.getBytes());
    }

    public final void zzf(byte[] byArray) {
        this.zzr("onNetworkResponseBody", (zzcgr)new zzcgp(byArray));
    }
}
