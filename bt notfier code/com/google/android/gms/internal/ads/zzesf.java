/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.DeviceProperties
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesd
 *  com.google.android.gms.internal.ads.zzese
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzglo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesd;
import com.google.android.gms.internal.ads.zzese;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzglo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Callable;

final class zzesf
implements zzery<zzesd> {
    private final zzfsn zza;
    private final Context zzb;

    public zzesf(zzfsn zzfsn2, Context context) {
        this.zza = zzfsn2;
        this.zzb = context;
    }

    private static ResolveInfo zzc(PackageManager packageManager, String string) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string)), 65536);
    }

    public final zzfsm<zzesd> zza() {
        return this.zza.zzb((Callable)new zzese(this));
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    final /* synthetic */ zzesd zzb() throws Exception {
        block14: {
            block13: {
                block12: {
                    block11: {
                        var16_1 = this.zzb.getPackageManager();
                        var11_2 = Locale.getDefault();
                        var5_4 = zzesf.zzc(var16_1, "geo:0,0?q=donuts") != null;
                        var6_5 = zzesf.zzc(var16_1, "http://www.google.com") != null;
                        var13_6 = var11_2.getCountry();
                        var10_7 = Build.DEVICE.startsWith("generic");
                        var9_8 = DeviceProperties.isLatchsky((Context)this.zzb);
                        var8_9 = DeviceProperties.isSidewinder((Context)this.zzb);
                        var15_10 = var11_2.getLanguage();
                        var14_11 = new ArrayList<String>();
                        if (Build.VERSION.SDK_INT >= 24) {
                            var11_2 = LocaleList.getDefault();
                            for (var1_12 = 0; var1_12 < var11_2.size(); ++var1_12) {
                                var14_11.add(var11_2.get(var1_12).getLanguage());
                            }
                        }
                        var12_13 = this.zzb;
                        var11_2 = zzesf.zzc(var16_1, "market://details?id=com.google.android.gms.ads");
                        if (var11_2 != null && (var11_2 = var11_2.activityInfo) != null) {
                            try {
                                if ((var12_13 = Wrappers.packageManager((Context)var12_13).getPackageInfo(var11_2.packageName, 0)) == null) break block11;
                                var1_12 = var12_13.versionCode;
                                var11_2 = var11_2.packageName;
                                var2_15 = String.valueOf(var11_2).length();
                                var12_13 = new StringBuilder(var2_15 + 12);
                                var12_13.append(var1_12);
                                var12_13.append(".");
                                var12_13.append((String)var11_2);
                                var11_2 = var12_13.toString();
                            }
                            catch (PackageManager.NameNotFoundException var11_3) {}
                        }
                    }
                    var11_2 = null;
                    var12_13 = this.zzb;
                    try {
                        block15: {
                            var12_13 = Wrappers.packageManager((Context)var12_13).getPackageInfo("com.android.vending", 128);
                            if (var12_13 == null) break block15;
                            var1_12 = var12_13.versionCode;
                            var17_16 = var12_13.packageName;
                            var2_15 = String.valueOf(var17_16).length();
                            var12_13 = new StringBuilder(var2_15 + 12);
                            var12_13.append(var1_12);
                            var12_13.append(".");
                            var12_13.append(var17_16);
                            var12_13 = var12_13.toString();
                            ** GOTO lbl56
                        }
lbl54:
                        // 2 sources

                        while (true) {
                            var12_13 = null;
lbl56:
                            // 2 sources

                            var19_17 = Build.FINGERPRINT;
                            var18_18 = this.zzb;
                            if (var16_1 == null) break block12;
                            break;
                        }
                    }
                    catch (Exception var12_14) {
                        ** continue;
                    }
                    {
                        var20_20 = new Intent("android.intent.action.VIEW", Uri.parse((String)"http://www.example.com"));
                        var17_16 = var16_1.resolveActivity((Intent)var20_20, 0);
                        if ((var20_20 = var16_1.queryIntentActivities((Intent)var20_20, 65536)) == null || var17_16 == null) break block12;
                        var1_12 = 0;
                        break block13;
                    }
                }
                while (true) {
                    var7_19 = false;
                    break block14;
                    break;
                }
            }
            while (true) {
                if (var1_12 >= var20_20.size()) ** continue;
                var16_1 = (ResolveInfo)var20_20.get(var1_12);
                if (var17_16.activityInfo.name.equals(var16_1.activityInfo.name)) {
                    var7_19 = var17_16.activityInfo.packageName.equals(zzglo.zza((Context)var18_18));
                    break;
                }
                ++var1_12;
            }
        }
        var3_21 = zzt.zze().zzi();
        return new zzesd(var5_4, var6_5, var13_6, var10_7, var9_8, var8_9, var15_10, var14_11, (String)var11_2, (String)var12_13, var19_17, var7_19, Build.MODEL, var3_21);
    }
}
