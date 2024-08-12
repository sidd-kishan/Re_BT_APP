/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.core.content.pm.PackageInfoCompat
 *  com.google.android.gms.internal.consent_sdk.zzbn
 *  com.google.android.gms.internal.consent_sdk.zzbp
 *  com.google.android.gms.internal.consent_sdk.zzbr
 *  com.google.android.gms.internal.consent_sdk.zzbs
 *  com.google.android.gms.internal.consent_sdk.zzbt
 *  com.google.android.gms.internal.consent_sdk.zzbu
 *  com.google.android.gms.internal.consent_sdk.zzbv
 *  com.google.android.gms.internal.consent_sdk.zzbw
 *  com.google.android.gms.internal.consent_sdk.zzcc
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.gms.internal.consent_sdk.zzn
 *  com.google.android.gms.internal.consent_sdk.zzo
 *  com.google.android.ump.ConsentDebugSettings
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.pm.PackageInfoCompat;
import com.google.android.gms.internal.consent_sdk.zzbn;
import com.google.android.gms.internal.consent_sdk.zzbp;
import com.google.android.gms.internal.consent_sdk.zzbr;
import com.google.android.gms.internal.consent_sdk.zzbs;
import com.google.android.gms.internal.consent_sdk.zzbt;
import com.google.android.gms.internal.consent_sdk.zzbu;
import com.google.android.gms.internal.consent_sdk.zzbv;
import com.google.android.gms.internal.consent_sdk.zzbw;
import com.google.android.gms.internal.consent_sdk.zzcc;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.gms.internal.consent_sdk.zzn;
import com.google.android.gms.internal.consent_sdk.zzo;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

final class zzl {
    private final zzn zza;
    private final Activity zzb;
    private final ConsentDebugSettings zzc;
    private final ConsentRequestParameters zzd;

    private zzl(zzn zzn2, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters) {
        this.zza = zzn2;
        this.zzb = activity;
        this.zzc = consentDebugSettings;
        this.zzd = consentRequestParameters;
    }

    /* synthetic */ zzl(zzn zzn2, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters, zzo zzo2) {
        this(zzn2, activity, consentDebugSettings, consentRequestParameters);
    }

    private final zzbn zza() throws zzk {
        zzbn zzbn2 = new zzbn();
        zzbn2.zza = this.zzc();
        Object object = zzn.zzc((zzn)this.zza).zza();
        if (object != null) {
            zzbn2.zzb = object.zza;
            zzbn2.zzi = object.zzb;
        }
        if (!this.zzc.isTestDevice()) {
            object = Collections.emptyList();
        } else {
            object = new ArrayList();
            int n = this.zzc.getDebugGeography();
            if (n != 1) {
                if (n == 2) {
                    object.add(zzbs.zzd);
                }
            } else {
                object.add(zzbs.zzc);
            }
        }
        zzbn2.zzn = object;
        Application application = zzn.zza((zzn)this.zza);
        object = zzn.zzb((zzn)this.zza).zzc();
        Cloneable cloneable = new HashMap<String, Object>();
        for (String string : object) {
            block21: {
                block19: {
                    block20: {
                        block18: {
                            object = zzcc.zza((Context)application, (String)string);
                            if (object == null) {
                                object = String.valueOf(string);
                                object = object.length() != 0 ? "Fetching request info: failed for key: ".concat((String)object) : new String("Fetching request info: failed for key: ");
                                Log.d((String)"UserMessagingPlatform", (String)object);
                                continue;
                            }
                            object = application.getSharedPreferences(object.zza, 0).getAll().get(object.zzb);
                            if (object == null) {
                                object = String.valueOf(string);
                                object = object.length() != 0 ? "Stored info not exists: ".concat((String)object) : new String("Stored info not exists: ");
                                Log.d((String)"UserMessagingPlatform", (String)object);
                                continue;
                            }
                            if (!(object instanceof Boolean)) break block18;
                            object = ((Boolean)object).booleanValue() ? "1" : "0";
                            break block19;
                        }
                        if (!(object instanceof Number)) break block20;
                        object = object.toString();
                        break block19;
                    }
                    if (!(object instanceof String)) break block21;
                    object = (String)object;
                }
                cloneable.put(string, object);
                continue;
            }
            object = String.valueOf(string);
            object = object.length() != 0 ? "Failed to fetch stored info: ".concat((String)object) : new String("Failed to fetch stored info: ");
            Log.d((String)"UserMessagingPlatform", (String)object);
        }
        zzbn2.zzj = cloneable;
        cloneable = null;
        zzbn2.zzd = null;
        zzbn2.zzg = null;
        zzbn2.zzh = this.zzd.isTagForUnderAgeOfConsent();
        zzbn2.zzf = null;
        object = Build.VERSION.SDK_INT >= 21 ? Locale.getDefault().toLanguageTag() : Locale.getDefault().toString();
        zzbn2.zze = object;
        object = new zzbr();
        object.zzc = Build.VERSION.SDK_INT;
        object.zzb = Build.MODEL;
        object.zza = zzbu.zzb;
        zzbn2.zzc = object;
        object = zzn.zza((zzn)this.zza).getResources().getConfiguration();
        zzn.zza((zzn)this.zza).getResources().getConfiguration();
        application = new zzbt();
        application.zza = object.screenWidthDp;
        application.zzb = object.screenHeightDp;
        application.zzc = zzn.zza((zzn)this.zza).getResources().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT < 28) {
            object = Collections.emptyList();
        } else {
            object = this.zzb;
            object = object == null ? null : object.getWindow();
            object = object == null ? null : object.getDecorView();
            object = object == null ? null : object.getRootWindowInsets();
            if ((object = object == null ? cloneable : object.getDisplayCutout()) == null) {
                object = Collections.emptyList();
            } else {
                object.getSafeInsetBottom();
                cloneable = new ArrayList();
                for (String string : object.getBoundingRects()) {
                    if (string == null) continue;
                    object = new zzbw();
                    object.zzb = ((Rect)string).left;
                    object.zzc = ((Rect)string).right;
                    object.zza = ((Rect)string).top;
                    object.zzd = ((Rect)string).bottom;
                    cloneable.add(object);
                }
                object = cloneable;
            }
        }
        application.zzd = object;
        zzbn2.zzk = application;
        zzbn2.zzl = this.zzb();
        object = new zzbv();
        object.zza = "1.0.0";
        zzbn2.zzm = object;
        return zzbn2;
    }

    static /* synthetic */ zzbn zza(zzl zzl2) throws zzk {
        return zzl2.zza();
    }

    private final zzbp zzb() {
        PackageInfo packageInfo;
        Object object = zzn.zza((zzn)this.zza);
        String string = null;
        try {
            packageInfo = zzn.zza((zzn)this.zza).getPackageManager().getPackageInfo(object.getPackageName(), 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            packageInfo = null;
        }
        zzbp zzbp2 = new zzbp();
        zzbp2.zza = object.getPackageName();
        object = zzn.zza((zzn)this.zza).getPackageManager().getApplicationLabel(zzn.zza((zzn)this.zza).getApplicationInfo());
        if (object != null) {
            string = object.toString();
        }
        zzbp2.zzb = string;
        if (packageInfo == null) return zzbp2;
        zzbp2.zzc = Long.toString(PackageInfoCompat.getLongVersionCode((PackageInfo)packageInfo));
        return zzbp2;
    }

    private final String zzc() throws zzk {
        String string = this.zzd.zza();
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        Bundle bundle = null;
        try {
            Bundle bundle2;
            bundle = bundle2 = zzn.zza((zzn)this.zza).getPackageManager().getApplicationInfo((String)zzn.zza((zzn)this.zza).getPackageName(), (int)128).metaData;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            // empty catch block
        }
        if (bundle != null) {
            string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        }
        if (TextUtils.isEmpty((CharSequence)string)) throw new zzk(3, "The UMP SDK requires a valid application ID in your AndroidManifest.xml through a com.google.android.gms.ads.APPLICATION_ID meta-data tag.\nExample AndroidManifest:\n    <meta-data\n        android:name=\"com.google.android.gms.ads.APPLICATION_ID\"\n        android:value=\"ca-app-pub-0000000000000000~0000000000\">");
        return string;
    }
}
