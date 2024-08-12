/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.ads.zzbuz
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbht
extends ContentProvider {
    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Object object;
        Object object2 = null;
        try {
            object2 = object = Wrappers.packageManager((Context)context).getApplicationInfo((String)context.getPackageName(), (int)128).metaData;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            zzcgt.zzg((String)"Failed to load metadata: Package name not found.", (Throwable)nameNotFoundException);
        }
        catch (NullPointerException nullPointerException) {
            zzcgt.zzg((String)"Failed to load metadata: Null pointer exception.", (Throwable)nullPointerException);
        }
        zzbuz zzbuz2 = zzbuz.zza();
        if (object2 == null) {
            zzcgt.zzf((String)"Metadata was null.");
        } else {
            String string = (String)object2.get("com.google.android.gms.ads.APPLICATION_ID");
            Boolean bl = (Boolean)object2.get("com.google.android.gms.ads.AD_MANAGER_APP");
            object = (Boolean)object2.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
            object2 = (String)object2.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (string != null && !string.matches("^/\\d+~.+$")) {
                if (!string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                object2 = string.length() != 0 ? "Publisher provided Google AdMob App ID in manifest: ".concat(string) : new String("Publisher provided Google AdMob App ID in manifest: ");
                zzcgt.zzd((String)object2);
                if (object == null || !((Boolean)object).booleanValue()) {
                    zzbuz2.zzb(context, string);
                }
            } else if (bl == null || !bl.booleanValue()) {
                if (TextUtils.isEmpty((CharSequence)object2)) throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                object2 = ((String)(object2 = String.valueOf(object2))).length() != 0 ? "The Google Mobile Ads SDK is integrated by ".concat((String)object2) : new String("The Google Mobile Ads SDK is integrated by ");
                zzcgt.zzd((String)object2);
            }
        }
        super.attachInfo(context, providerInfo);
        return;
        catch (ClassCastException classCastException) {
            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", classCastException);
        }
        catch (ClassCastException classCastException) {
            throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", classCastException);
        }
        catch (ClassCastException classCastException) {
            throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", classCastException);
        }
        catch (ClassCastException classCastException) {
            throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", classCastException);
        }
    }

    public final int delete(Uri uri, String string, String[] stringArray) {
        return 0;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        return 0;
    }
}
