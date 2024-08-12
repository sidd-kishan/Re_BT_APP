/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcsc
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcsc;
import java.util.Map;

public final class zzcsm
implements zzcsc {
    private final Context zza;
    private final zzg zzb = zzt.zzg().zzp();

    public zzcsm(Context context) {
        this.zza = context;
    }

    public final void zza(Map<String, String> object) {
        if (object.isEmpty()) {
            return;
        }
        String string = object.get("gad_idless");
        if (string != null) {
            boolean bl = Boolean.parseBoolean(string);
            object.remove("gad_idless");
            string = zzbjl.zzao;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
                this.zzb.zzB(bl);
                string = zzbjl.zzex;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue() && bl) {
                    this.zza.deleteDatabase("OfflineUpload.db");
                }
            }
        }
        string = new Bundle();
        object = object.entrySet().iterator();
        while (true) {
            if (!object.hasNext()) {
                object = zzbjl.zzaj;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
                zzt.zzA().zze((Bundle)string);
                return;
            }
            Map.Entry entry = (Map.Entry)object.next();
            string.putString((String)entry.getKey(), (String)entry.getValue());
        }
    }
}
