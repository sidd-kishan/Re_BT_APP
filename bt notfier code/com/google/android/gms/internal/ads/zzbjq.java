/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Environment
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbjp
 *  com.google.android.gms.internal.ads.zzbjw
 *  com.google.android.gms.internal.ads.zzbjz
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzbku
 *  com.google.android.gms.internal.ads.zzchg
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjp;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzchg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzbjq {
    final BlockingQueue<zzbka> zza = new ArrayBlockingQueue<zzbka>(100);
    final LinkedHashMap<String, String> zzb = new LinkedHashMap();
    final Map<String, zzbjw> zzc = new HashMap<String, zzbjw>();
    String zzd;
    Context zze;
    String zzf;
    private final HashSet<String> zzg = new HashSet<String>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    private AtomicBoolean zzh;
    private File zzi;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    private final void zzg(Map<String, String> object4, zzbjz object2) {
        block19: {
            Object object3;
            block20: {
                object3 = Uri.parse((String)this.zzd).buildUpon();
                for (Object object4 : object4.entrySet()) {
                    object3.appendQueryParameter((String)object4.getKey(), (String)object4.getValue());
                }
                object3 = object4 = object3.build().toString();
                if (object2 != null) {
                    object4 = new StringBuilder((String)object4);
                    if (!TextUtils.isEmpty((CharSequence)object2.zza())) {
                        ((StringBuilder)object4).append("&it=");
                        ((StringBuilder)object4).append(object2.zza());
                    }
                    if (!TextUtils.isEmpty((CharSequence)object2.zzb())) {
                        ((StringBuilder)object4).append("&blat=");
                        ((StringBuilder)object4).append(object2.zzb());
                    }
                    object3 = ((StringBuilder)object4).toString();
                }
                if (!this.zzh.get()) {
                    zzt.zzc();
                    zzs.zzN((Context)this.zze, (String)this.zzf, (String)object3);
                    return;
                }
                File file = this.zzi;
                if (file == null) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                    return;
                }
                Iterator<Map.Entry<String, String>> iterator = null;
                Object var5_13 = null;
                object4 = var5_13;
                try {
                    object4 = var5_13;
                    object2 = new FileOutputStream(file, true);
                }
                catch (Throwable throwable) {
                    object2 = object4;
                    object4 = throwable;
                    break block19;
                }
                catch (IOException iOException) {
                    object2 = iterator;
                    break block20;
                }
                try {
                    ((FileOutputStream)object2).write(((String)object3).getBytes());
                    ((FileOutputStream)object2).write(10);
                }
                catch (Throwable throwable) {
                    break block19;
                }
                catch (IOException iOException) {
                    object3 = iOException;
                    break block20;
                }
                try {
                    ((FileOutputStream)object2).close();
                    return;
                }
                catch (IOException iOException) {
                    com.google.android.gms.ads.internal.util.zze.zzj((String)"CsiReporter: Cannot close file: sdk_csi_data.txt.", (Throwable)iOException);
                    return;
                }
            }
            object4 = object2;
            {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"CsiReporter: Cannot write to file: sdk_csi_data.txt.", (Throwable)object3);
                if (object2 == null) return;
            }
            try {
                ((FileOutputStream)object2).close();
                return;
            }
            catch (IOException iOException) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"CsiReporter: Cannot close file: sdk_csi_data.txt.", (Throwable)iOException);
            }
            return;
        }
        if (object2 == null) throw object4;
        try {
            ((FileOutputStream)object2).close();
            throw object4;
        }
        catch (IOException iOException) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"CsiReporter: Cannot close file: sdk_csi_data.txt.", (Throwable)iOException);
        }
        throw object4;
    }

    public final void zza(Context object, String object2, String string, Map<String, String> map) {
        this.zze = object;
        this.zzf = object2;
        this.zzd = string;
        object = new AtomicBoolean(false);
        this.zzh = object;
        ((AtomicBoolean)object).set((Boolean)zzbku.zzc.zze());
        if (this.zzh.get() && (object = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File((File)object, "sdk_csi_data.txt");
        }
        object2 = map.entrySet().iterator();
        while (true) {
            if (!object2.hasNext()) {
                zzchg.zza.execute((Runnable)new zzbjp(this));
                this.zzc.put("action", zzbjw.zzb);
                this.zzc.put("ad_format", zzbjw.zzb);
                this.zzc.put("e", zzbjw.zzc);
                return;
            }
            object = (Map.Entry)object2.next();
            this.zzb.put((String)object.getKey(), (String)object.getValue());
        }
    }

    public final boolean zzb(zzbka zzbka2) {
        return this.zza.offer(zzbka2);
    }

    final Map<String, String> zzc(Map<String, String> map, Map<String, String> object) {
        map = new LinkedHashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            object = object2.getKey();
            String string = object2.getValue();
            object2 = map.get(object);
            map.put((String)object, this.zzd((String)object).zza((String)object2, string));
        }
        return map;
    }

    public final zzbjw zzd(String string) {
        if ((string = this.zzc.get(string)) == null) return zzbjw.zza;
        return string;
    }

    public final void zze(String string) {
        if (this.zzg.contains(string)) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put("sdkVersion", this.zzf);
        linkedHashMap.put("ue", string);
        this.zzg(this.zzc(this.zzb, linkedHashMap), null);
    }
}
