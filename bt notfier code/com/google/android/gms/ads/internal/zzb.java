/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcax
 *  com.google.android.gms.internal.ads.zzcdy
 */
package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcax;
import com.google.android.gms.internal.ads.zzcdy;
import java.util.Collections;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzcdy zzc;
    private final zzcax zzd;

    public zzb(Context context, zzcdy zzcdy2, zzcax zzcax2) {
        this.zza = context;
        this.zzc = zzcdy2;
        this.zzd = new zzcax(false, Collections.emptyList());
    }

    private final boolean zzd() {
        zzcdy zzcdy2 = this.zzc;
        if (zzcdy2 != null) {
            if (zzcdy2.zzb().zzf) return true;
        }
        if (!this.zzd.zza) return false;
        return true;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final boolean zzb() {
        if (!this.zzd()) return true;
        if (!this.zzb) return false;
        return true;
    }

    public final void zzc(String object) {
        if (!this.zzd()) {
            return;
        }
        String string = object;
        if (object == null) {
            string = "";
        }
        if ((object = this.zzc) != null) {
            object.zzf(string, null, 3);
            return;
        }
        object = this.zzd;
        if (!((zzcax)object).zza) return;
        object = ((zzcax)object).zzb;
        if (object == null) return;
        object = object.iterator();
        while (object.hasNext()) {
            String string2 = (String)object.next();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            string2 = string2.replace("{NAVIGATION_URL}", Uri.encode((String)string));
            zzt.zzc();
            zzs.zzN((Context)this.zza, (String)"", (String)string2);
        }
    }
}
