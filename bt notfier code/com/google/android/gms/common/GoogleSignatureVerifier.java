/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.google.android.gms.common.GooglePlayServicesUtilLight
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.zzi
 *  com.google.android.gms.common.zzj
 *  com.google.android.gms.common.zzl
 *  com.google.android.gms.common.zzm
 *  com.google.android.gms.common.zzw
 */
package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzl;
import com.google.android.gms.common.zzm;
import com.google.android.gms.common.zzw;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull((Object)context);
        synchronized (GoogleSignatureVerifier.class) {
            GoogleSignatureVerifier googleSignatureVerifier;
            if (zza != null) return zza;
            zzm.zza((Context)context);
            zza = googleSignatureVerifier = new GoogleSignatureVerifier(context);
            return zza;
        }
    }

    @Nullable
    static final zzi zza(PackageInfo zzj2, zzi ... zziArray) {
        if (zzj2.signatures == null) {
            return null;
        }
        if (zzj2.signatures.length != 1) {
            Log.w((String)"GoogleSignatureVerifier", (String)"Package has more than one signature.");
            return null;
        }
        zzj2 = zzj2.signatures;
        int n = 0;
        zzj2 = new zzj(zzj2[0].toByteArray());
        while (n < zziArray.length) {
            if (zziArray[n].equals((Object)zzj2)) {
                return zziArray[n];
            }
            ++n;
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean bl) {
        if (packageInfo == null) return false;
        if (packageInfo.signatures == null) return false;
        packageInfo = bl ? GoogleSignatureVerifier.zza(packageInfo, zzl.zza) : GoogleSignatureVerifier.zza(packageInfo, zzl.zza[0]);
        if (packageInfo == null) return false;
        return true;
    }

    private final zzw zzc(String string, boolean bl, boolean bl2) {
        zzw zzw2;
        if (string == null) {
            return zzw.zzd((String)"null pkg");
        }
        if (string.equals(this.zzc)) return zzw.zzb();
        if (zzm.zzd()) {
            zzw2 = zzm.zzb((String)string, (boolean)GooglePlayServicesUtilLight.honorsDebugCertificates((Context)this.zzb), (boolean)false, (boolean)false);
        } else {
            PackageInfo packageInfo;
            try {
                packageInfo = this.zzb.getPackageManager().getPackageInfo(string, 64);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                string = string.length() != 0 ? "no pkg ".concat(string) : new String("no pkg ");
                return zzw.zze((String)string, (Throwable)nameNotFoundException);
            }
            bl = GooglePlayServicesUtilLight.honorsDebugCertificates((Context)this.zzb);
            if (packageInfo == null) {
                zzw2 = zzw.zzd((String)"null pkg");
            } else if (packageInfo.signatures != null && packageInfo.signatures.length == 1) {
                zzj zzj2 = new zzj(packageInfo.signatures[0].toByteArray());
                String string2 = packageInfo.packageName;
                zzw2 = zzm.zzc((String)string2, (zzi)zzj2, (boolean)bl, (boolean)false);
                if (zzw2.zza && packageInfo.applicationInfo != null && (packageInfo.applicationInfo.flags & 2) != 0 && zzm.zzc((String)string2, (zzi)zzj2, (boolean)false, (boolean)true).zza) {
                    zzw2 = zzw.zzd((String)"debuggable release cert app rejected");
                }
            } else {
                zzw2 = zzw.zzd((String)"single cert required");
            }
        }
        if (!zzw2.zza) return zzw2;
        this.zzc = string;
        return zzw2;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (GoogleSignatureVerifier.zzb(packageInfo, false)) {
            return true;
        }
        if (!GoogleSignatureVerifier.zzb(packageInfo, true)) return false;
        if (GooglePlayServicesUtilLight.honorsDebugCertificates((Context)this.zzb)) {
            return true;
        }
        Log.w((String)"GoogleSignatureVerifier", (String)"Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean isPackageGoogleSigned(String string) {
        string = this.zzc(string, false, false);
        string.zzf();
        return ((zzw)string).zza;
    }

    public boolean isUidGoogleSigned(int n) {
        zzw zzw2;
        block4: {
            int n2;
            String[] stringArray = this.zzb.getPackageManager().getPackagesForUid(n);
            if (stringArray == null || (n2 = stringArray.length) == 0) {
                zzw2 = zzw.zzd((String)"no pkgs");
            } else {
                zzw2 = null;
                for (n = 0; n < n2; ++n) {
                    zzw2 = this.zzc(stringArray[n], false, false);
                    if (!zzw2.zza) {
                        continue;
                    }
                    break block4;
                }
                Preconditions.checkNotNull((Object)zzw2);
            }
        }
        zzw2.zzf();
        return zzw2.zza;
    }
}
