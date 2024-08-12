/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.media.AudioManager
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.os.Build
 *  android.telephony.TelephonyManager
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.DeviceProperties
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkj
 *  com.google.android.gms.internal.ads.zzcbo
 *  com.google.android.gms.internal.ads.zzcgm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzcbo;
import com.google.android.gms.internal.ads.zzcgm;
import java.util.Locale;

public final class zzcbn {
    private int zzA;
    private final String zzB;
    private boolean zzC;
    private int zza;
    private boolean zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private double zzm;
    private boolean zzn;
    private String zzo;
    private String zzp;
    private final boolean zzq;
    private final boolean zzr;
    private final String zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final boolean zzv;
    private final String zzw;
    private final String zzx;
    private float zzy;
    private int zzz;

    public zzcbn(Context context) {
        int n;
        int n2;
        ResolveInfo resolveInfo;
        Object object;
        Object object2;
        block8: {
            object2 = context.getPackageManager();
            this.zzb(context);
            this.zzc(context);
            this.zzd(context);
            object = Locale.getDefault();
            resolveInfo = zzcbn.zze((PackageManager)object2, "geo:0,0?q=donuts");
            boolean bl = true;
            boolean bl2 = resolveInfo != null;
            this.zzq = bl2;
            bl2 = zzcbn.zze((PackageManager)object2, "http://www.google.com") != null ? bl : false;
            this.zzr = bl2;
            this.zzs = ((Locale)object).getCountry();
            zzber.zza();
            this.zzt = zzcgm.zzm();
            this.zzu = DeviceProperties.isLatchsky((Context)context);
            this.zzv = DeviceProperties.isSidewinder((Context)context);
            this.zzw = ((Locale)object).getLanguage();
            object2 = zzcbn.zze((PackageManager)object2, "market://details?id=com.google.android.gms.ads");
            resolveInfo = null;
            if (object2 != null && (object2 = ((ResolveInfo)object2).activityInfo) != null) {
                try {
                    object = Wrappers.packageManager((Context)context).getPackageInfo(((ActivityInfo)object2).packageName, 0);
                    if (object == null) break block8;
                    n2 = ((PackageInfo)object).versionCode;
                    object = ((ActivityInfo)object2).packageName;
                    n = String.valueOf(object).length();
                    super(n + 12);
                    ((StringBuilder)object2).append(n2);
                    ((StringBuilder)object2).append(".");
                    ((StringBuilder)object2).append((String)object);
                    object2 = ((StringBuilder)object2).toString();
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            }
        }
        object2 = null;
        this.zzx = object2;
        try {
            object = Wrappers.packageManager((Context)context).getPackageInfo("com.android.vending", 128);
            object2 = resolveInfo;
            if (object != null) {
                n2 = ((PackageInfo)object).versionCode;
                object = ((PackageInfo)object).packageName;
                n = String.valueOf(object).length();
                super(n + 12);
                ((StringBuilder)object2).append(n2);
                ((StringBuilder)object2).append(".");
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
            }
        }
        catch (Exception exception) {
            object2 = resolveInfo;
        }
        this.zzB = object2;
        if ((context = context.getResources()) == null) {
            return;
        }
        if ((context = context.getDisplayMetrics()) == null) {
            return;
        }
        this.zzy = context.density;
        this.zzz = context.widthPixels;
        this.zzA = context.heightPixels;
    }

    public zzcbn(Context context, zzcbo zzcbo2) {
        boolean bl;
        this.zzb(context);
        this.zzc(context);
        this.zzd(context);
        this.zzo = Build.FINGERPRINT;
        this.zzp = Build.DEVICE;
        boolean bl2 = PlatformVersion.isAtLeastIceCreamSandwichMR1();
        boolean bl3 = bl = false;
        if (bl2) {
            bl3 = bl;
            if (zzbkj.zza((Context)context)) {
                bl3 = true;
            }
        }
        this.zzC = bl3;
        this.zzq = zzcbo2.zza;
        this.zzr = zzcbo2.zzb;
        this.zzs = zzcbo2.zzd;
        this.zzt = zzcbo2.zze;
        this.zzu = zzcbo2.zzf;
        this.zzv = zzcbo2.zzg;
        this.zzw = zzcbo2.zzh;
        this.zzx = zzcbo2.zzi;
        this.zzB = zzcbo2.zzj;
        this.zzy = zzcbo2.zzm;
        this.zzz = zzcbo2.zzn;
        this.zzA = zzcbo2.zzo;
    }

    private final void zzb(Context context) {
        if ((context = (AudioManager)context.getSystemService("audio")) != null) {
            try {
                this.zza = context.getMode();
                this.zzb = context.isMusicActive();
                this.zzc = context.isSpeakerphoneOn();
                this.zzd = context.getStreamVolume(3);
                this.zze = context.getRingerMode();
                this.zzf = context.getStreamVolume(2);
                return;
            }
            catch (Throwable throwable) {
                com.google.android.gms.ads.internal.zzt.zzg().zzk(throwable, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zza = -2;
        this.zzb = false;
        this.zzc = false;
        this.zzd = 0;
        this.zze = 2;
        this.zzf = 0;
    }

    /*
     * Unable to fully structure code
     */
    private final void zzc(Context var1_1) {
        var4_2 = (TelephonyManager)var1_1.getSystemService("phone");
        var3_3 = (ConnectivityManager)var1_1.getSystemService("connectivity");
        this.zzg = var4_2.getNetworkOperator();
        if (!PlatformVersion.isAtLeastR()) ** GOTO lbl-1000
        var5_4 = zzbjl.zzgd;
        if (((Boolean)zzbet.zzc().zzc(var5_4)).booleanValue()) {
            var2_5 = 0;
        } else lbl-1000:
        // 2 sources

        {
            var2_5 = var4_2.getNetworkType();
        }
        this.zzi = var2_5;
        this.zzj = var4_2.getPhoneType();
        this.zzh = -2;
        this.zzk = false;
        this.zzl = -1;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzE((Context)var1_1, (String)"android.permission.ACCESS_NETWORK_STATE") == false) return;
        var1_1 = var3_3.getActiveNetworkInfo();
        if (var1_1 != null) {
            this.zzh = var1_1.getType();
            this.zzl = var1_1.getDetailedState().ordinal();
        } else {
            this.zzh = -1;
        }
        this.zzk = var3_3.isActiveNetworkMetered();
    }

    private final void zzd(Context context) {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean bl = false;
        if (context == null) {
            this.zzm = -1.0;
            this.zzn = false;
            return;
        }
        int n = context.getIntExtra("status", -1);
        this.zzm = (float)context.getIntExtra("level", -1) / (float)context.getIntExtra("scale", -1);
        if (n == 2 || n == 5) {
            bl = true;
        }
        this.zzn = bl;
    }

    private static ResolveInfo zze(PackageManager packageManager, String string) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string));
            packageManager = packageManager.resolveActivity(intent, 65536);
            return packageManager;
        }
        catch (Throwable throwable) {
            com.google.android.gms.ads.internal.zzt.zzg().zzk(throwable, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzcbo zza() {
        return new zzcbo(this.zza, this.zzq, this.zzr, this.zzg, this.zzs, this.zzt, this.zzu, this.zzv, this.zzb, this.zzc, this.zzw, this.zzx, this.zzB, this.zzd, this.zzh, this.zzi, this.zzj, this.zze, this.zzf, this.zzy, this.zzz, this.zzA, this.zzm, this.zzn, this.zzk, this.zzl, this.zzo, this.zzC, this.zzp);
    }
}
