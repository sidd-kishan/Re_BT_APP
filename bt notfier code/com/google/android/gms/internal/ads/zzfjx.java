/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.Hex
 *  com.google.android.gms.internal.ads.zzadf
 *  com.google.android.gms.internal.ads.zzadi
 *  com.google.android.gms.internal.ads.zzfjw
 *  com.google.android.gms.internal.ads.zzfjy
 *  com.google.android.gms.internal.ads.zzfkd
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzadi;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzfkd;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggm;
import java.io.File;
import java.util.HashSet;

public final class zzfjx {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfjx(Context object, int n) {
        this.zzc = object.getSharedPreferences("pcvmspf", 0);
        File file = object.getDir("pccache", 0);
        zzfjy.zzd((File)file, (boolean)false);
        this.zzb = file;
        object = object.getDir("tmppccache", 0);
        zzfjy.zzd((File)object, (boolean)true);
        this.zza = object;
        this.zzd = n;
    }

    static String zzb(zzadi zzadi2) {
        return Hex.bytesToStringLowercase((byte[])zzadi2.zzan().zzz());
    }

    private final File zze() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (file.exists()) return file;
        file.mkdir();
        return file;
    }

    private final String zzf() {
        int n = this.zzd;
        StringBuilder stringBuilder = new StringBuilder(17);
        stringBuilder.append("FBAMTD");
        stringBuilder.append(n - 1);
        return stringBuilder.toString();
    }

    private final String zzg() {
        int n = this.zzd;
        StringBuilder stringBuilder = new StringBuilder(17);
        stringBuilder.append("LATMTD");
        stringBuilder.append(n - 1);
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final boolean zza(zzadf var1_1, zzfkd var2_2) {
        var7_3 = var1_1.zza().zza();
        var8_4 /* !! */  = var1_1.zzc().zzz();
        var6_5 = var1_1.zzd().zzz();
        var5_6 = TextUtils.isEmpty((CharSequence)var7_3);
        var3_7 = 0;
        if (var5_6 != false) return false;
        if (var6_5 == null) return false;
        if (((byte[])var6_5).length == 0) {
            return false;
        }
        zzfjy.zze((File)this.zza);
        this.zza.mkdirs();
        zzfjy.zzc((String)var7_3, (File)this.zza).mkdirs();
        var9_8 = zzfjy.zza((String)var7_3, (String)"pcam.jar", (File)this.zza);
        if (var8_4 /* !! */  != null && var8_4 /* !! */ .length > 0) {
            if (zzfjy.zzb((File)var9_8, (byte[])var8_4 /* !! */ ) == false) return false;
        }
        if (zzfjy.zzb((File)zzfjy.zza((String)var7_3, (String)"pcbc", (File)this.zza), (byte[])var6_5) == false) return false;
        var6_5 = zzfjy.zza((String)var1_1.zza().zza(), (String)"pcam.jar", (File)this.zza);
        if (var6_5.exists() && var2_2 != null) {
            if (var2_2.zza((File)var6_5) == false) return false;
        }
        if (TextUtils.isEmpty((CharSequence)(var8_4 /* !! */  = (byte[])var1_1.zza().zza()))) ** GOTO lbl-1000
        var7_3 = zzfjy.zza((String)var8_4 /* !! */ , (String)"pcam.jar", (File)this.zza);
        var6_5 = zzfjy.zza((String)var8_4 /* !! */ , (String)"pcbc", (File)this.zza);
        var2_2 = zzfjy.zza((String)var8_4 /* !! */ , (String)"pcam.jar", (File)this.zze());
        var8_4 /* !! */  = (byte[])zzfjy.zza((String)var8_4 /* !! */ , (String)"pcbc", (File)this.zze());
        if (var7_3.exists() && !var7_3.renameTo((File)var2_2) || !var6_5.exists() || !var6_5.renameTo((File)var8_4 /* !! */ )) ** GOTO lbl-1000
        var2_2 = zzadi.zzi();
        var2_2.zza(var1_1.zza().zza());
        var2_2.zzb(var1_1.zza().zzc());
        var2_2.zzd(var1_1.zza().zze());
        var2_2.zze(var1_1.zza().zzf());
        var2_2.zzc(var1_1.zza().zzd());
        var6_5 = (zzadi)var2_2.zzah();
        var2_2 = this.zzd(1);
        var1_1 = this.zzc.edit();
        if (var2_2 != null && !var6_5.zza().equals(var2_2.zza())) {
            var1_1.putString(this.zzf(), zzfjx.zzb((zzadi)var2_2));
        }
        var1_1.putString(this.zzg(), zzfjx.zzb((zzadi)var6_5));
        if (var1_1.commit()) {
            var5_6 = true;
        } else lbl-1000:
        // 3 sources

        {
            var5_6 = false;
        }
        var1_1 = new HashSet<E>();
        var2_2 = this.zzd(1);
        if (var2_2 != null) {
            var1_1.add(var2_2.zza());
        }
        if ((var2_2 = this.zzd(2)) != null) {
            var1_1.add(var2_2.zza());
        }
        var2_2 = this.zze().listFiles();
        var4_9 = ((File[])var2_2).length;
        while (var3_7 < var4_9) {
            var6_5 = var2_2[var3_7].getName();
            if (!var1_1.contains(var6_5)) {
                zzfjy.zze((File)zzfjy.zzc((String)var6_5, (File)this.zze()));
            }
            ++var3_7;
        }
        return var5_6;
    }

    public final zzfjw zzc(int n) {
        File file;
        zzadi zzadi2 = this.zzd(1);
        if (zzadi2 == null) {
            return null;
        }
        String string = zzadi2.zza();
        File file2 = file = zzfjy.zza((String)string, (String)"pcam.jar", (File)this.zze());
        if (!file.exists()) {
            file2 = zzfjy.zza((String)string, (String)"pcam", (File)this.zze());
        }
        file = zzfjy.zza((String)string, (String)"pcopt", (File)this.zze());
        return new zzfjw(zzadi2, file2, zzfjy.zza((String)string, (String)"pcbc", (File)this.zze()), file);
    }

    final zzadi zzd(int n) {
        Object object = n == 1 ? this.zzc.getString(this.zzg(), null) : this.zzc.getString(this.zzf(), null);
        if (TextUtils.isEmpty((CharSequence)object)) {
            return null;
        }
        try {
            zzadi zzadi2 = zzadi.zzg((zzgex)zzgex.zzt((byte[])Hex.stringToBytes((String)object)));
            String string = zzadi2.zza();
            File file = zzfjy.zza((String)string, (String)"pcam.jar", (File)this.zze());
            object = file;
            if (!file.exists()) {
                object = zzfjy.zza((String)string, (String)"pcam", (File)this.zze());
            }
            file = zzfjy.zza((String)string, (String)"pcbc", (File)this.zze());
            if (!((File)object).exists()) return null;
            boolean bl = file.exists();
            if (!bl) return null;
            return zzadi2;
        }
        catch (zzggm zzggm2) {
        }
        return null;
    }
}
