/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzeov
 *  com.google.android.gms.internal.ads.zzeow
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzeov;
import com.google.android.gms.internal.ads.zzeow;
import java.util.concurrent.Callable;

final class zzeou
implements Callable {
    private final zzeov zza;

    zzeou(zzeov zzeov2) {
        this.zza = zzeov2;
    }

    public final Object call() {
        zzt.zzc();
        Object object = zzt.zzg().zzp().zzb();
        Object var4_2 = null;
        if (object == null) {
            object = var4_2;
        } else if (zzt.zzg().zzp().zzd() && zzt.zzg().zzp().zzh()) {
            object = var4_2;
        } else {
            String string;
            String string2;
            String string3;
            if (object.zzh()) {
                object.zzf();
            }
            if ((object = object.zze()) != null) {
                string3 = object.zzb();
                String string4 = object.zzc();
                String string5 = object.zzd();
                if (string3 != null) {
                    zzt.zzg().zzp().zze(string3);
                }
                string2 = string5;
                string = string3;
                object = string4;
                if (string5 != null) {
                    zzt.zzg().zzp().zzi(string5);
                    string2 = string5;
                    string = string3;
                    object = string4;
                }
            } else {
                string = zzt.zzg().zzp().zzf();
                string2 = zzt.zzg().zzp().zzj();
                object = null;
            }
            string3 = new Bundle(1);
            if (!zzt.zzg().zzp().zzh()) {
                if (string2 != null && !TextUtils.isEmpty((CharSequence)string2)) {
                    string3.putString("v_fp_vertical", string2);
                } else {
                    string3.putString("v_fp_vertical", "no_hash");
                }
            }
            if (string != null && !zzt.zzg().zzp().zzd()) {
                string3.putString("fingerprint", string);
                if (!string.equals(object)) {
                    string3.putString("v_fp", (String)object);
                }
            }
            object = var4_2;
            if (string3.isEmpty()) return new zzeow((Bundle)object);
            object = string3;
        }
        return new zzeow((Bundle)object);
    }
}
