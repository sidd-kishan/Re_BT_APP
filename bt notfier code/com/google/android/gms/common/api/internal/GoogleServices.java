/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.common.R$string
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.StringResourceValueReader
 *  com.google.android.gms.common.internal.zzaf
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzaf;

@Deprecated
public final class GoogleServices {
    private static final Object zza = new Object();
    private static GoogleServices zzb;
    private final String zzc;
    private final Status zzd;
    private final boolean zze;
    private final boolean zzf;

    GoogleServices(Context context) {
        Object object = context.getResources();
        int n = object.getIdentifier("google_app_measurement_enable", "integer", object.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean bl = true;
        boolean bl2 = true;
        if (n != 0) {
            bl = (n = object.getInteger(n)) == 0;
            if (n == 0) {
                bl2 = false;
            }
            this.zzf = bl;
        } else {
            this.zzf = false;
            bl2 = bl;
        }
        this.zze = bl2;
        String string2 = zzaf.zza((Context)context);
        object = string2;
        if (string2 == null) {
            object = new StringResourceValueReader(context).getString("google_app_id");
        }
        if (TextUtils.isEmpty((CharSequence)object)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
            return;
        }
        this.zzc = object;
        this.zzd = Status.RESULT_SUCCESS;
    }

    GoogleServices(String string2, boolean bl) {
        this.zzc = string2;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = bl;
        this.zzf = bl ^ true;
    }

    private static GoogleServices checkInitialized(String object) {
        Object object2 = zza;
        synchronized (object2) {
            if (zzb != null) {
                object = zzb;
                return object;
            }
            int n = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n + 34);
            stringBuilder.append("Initialize must be called before ");
            stringBuilder.append((String)object);
            stringBuilder.append(".");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }

    static void clearInstanceForTest() {
        Object object = zza;
        synchronized (object) {
            zzb = null;
            return;
        }
    }

    public static String getGoogleAppId() {
        return GoogleServices.checkInitialized((String)"getGoogleAppId").zzc;
    }

    public static Status initialize(Context context) {
        Preconditions.checkNotNull((Object)context, (Object)"Context must not be null.");
        Object object = zza;
        synchronized (object) {
            if (zzb == null) {
                GoogleServices googleServices;
                zzb = googleServices = new GoogleServices(context);
            }
            context = GoogleServices.zzb.zzd;
            return context;
        }
    }

    public static Status initialize(Context object, String string2, boolean bl) {
        Preconditions.checkNotNull((Object)object, (Object)"Context must not be null.");
        Preconditions.checkNotEmpty((String)string2, (Object)"App ID must be nonempty.");
        object = zza;
        synchronized (object) {
            GoogleServices googleServices;
            if (zzb != null) {
                string2 = zzb.checkGoogleAppId(string2);
                return string2;
            }
            zzb = googleServices = new GoogleServices(string2, bl);
            string2 = googleServices.zzd;
            return string2;
        }
    }

    public static boolean isMeasurementEnabled() {
        GoogleServices googleServices = GoogleServices.checkInitialized("isMeasurementEnabled");
        if (!googleServices.zzd.isSuccess()) return false;
        if (!googleServices.zze) return false;
        return true;
    }

    public static boolean isMeasurementExplicitlyDisabled() {
        return GoogleServices.checkInitialized((String)"isMeasurementExplicitlyDisabled").zzf;
    }

    Status checkGoogleAppId(String charSequence) {
        String string2 = this.zzc;
        if (string2 == null) return Status.RESULT_SUCCESS;
        if (string2.equals(charSequence)) return Status.RESULT_SUCCESS;
        string2 = this.zzc;
        charSequence = new StringBuilder(String.valueOf(string2).length() + 97);
        ((StringBuilder)charSequence).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("'.");
        return new Status(10, ((StringBuilder)charSequence).toString());
    }
}
