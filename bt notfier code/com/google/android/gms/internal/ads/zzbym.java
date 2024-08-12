/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.URLUtil
 *  com.google.android.gms.ads.impl.R$string
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbiv
 *  com.google.android.gms.internal.ads.zzbyk
 *  com.google.android.gms.internal.ads.zzbyl
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbyk;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzcml;
import java.util.Map;

public final class zzbym
extends zzbyp {
    private final Map<String, String> zza;
    private final Context zzb;

    public zzbym(zzcml zzcml2, Map<String, String> map) {
        super(zzcml2, "storePicture");
        this.zza = map;
        this.zzb = zzcml2.zzj();
    }

    static /* synthetic */ Context zza(zzbym zzbym2) {
        return zzbym2.zzb;
    }

    public final void zzb() {
        if (this.zzb == null) {
            this.zzf("Activity context is not available");
            return;
        }
        zzt.zzc();
        if (!new zzbiv(this.zzb).zza()) {
            this.zzf("Feature is not supported by the device.");
            return;
        }
        String string2 = this.zza.get("iurl");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.zzf("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl((String)string2)) {
            String string3 = String.valueOf(string2);
            string3 = string3.length() != 0 ? "Invalid image url: ".concat(string3) : new String("Invalid image url: ");
            this.zzf(string3);
            return;
        }
        String string4 = Uri.parse((String)string2).getLastPathSegment();
        zzt.zzc();
        if (!TextUtils.isEmpty((CharSequence)string4) && string4.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            Resources resources = zzt.zzg().zzj();
            zzt.zzc();
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
            String string5 = resources != null ? resources.getString(R.string.s1) : "Save image";
            builder.setTitle((CharSequence)string5);
            string5 = resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?";
            builder.setMessage((CharSequence)string5);
            string5 = resources != null ? resources.getString(R.string.s3) : "Accept";
            builder.setPositiveButton((CharSequence)string5, (DialogInterface.OnClickListener)new zzbyk(this, string2, string4));
            string5 = resources != null ? resources.getString(R.string.s4) : "Decline";
            builder.setNegativeButton((CharSequence)string5, (DialogInterface.OnClickListener)new zzbyl(this));
            builder.create().show();
            return;
        }
        String string6 = String.valueOf(string4);
        string6 = string6.length() != 0 ? "Image type not recognized: ".concat(string6) : new String("Image type not recognized: ");
        this.zzf(string6);
    }
}
