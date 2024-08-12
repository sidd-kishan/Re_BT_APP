/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.IntentSender$SendIntentException
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Objects$ToStringHelper
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.zzb
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zzb;

public final class ConnectionResult
extends AbstractSafeParcelable {
    public static final int API_DISABLED = 23;
    public static final int API_DISABLED_FOR_CONNECTION = 24;
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final ConnectionResult RESULT_SUCCESS;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = -1;
    final int zza;
    private final int zzb;
    private final PendingIntent zzc;
    private final String zzd;

    static {
        RESULT_SUCCESS = new ConnectionResult(0);
        CREATOR = new zzb();
    }

    public ConnectionResult(int n) {
        this(n, null, null);
    }

    ConnectionResult(int n, int n2, PendingIntent pendingIntent, String string) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = pendingIntent;
        this.zzd = string;
    }

    public ConnectionResult(int n, PendingIntent pendingIntent) {
        this(n, pendingIntent, null);
    }

    public ConnectionResult(int n, PendingIntent pendingIntent, String string) {
        this(1, n, pendingIntent, string);
    }

    static String zza(int n) {
        if (n == 99) return "UNFINISHED";
        if (n == 1500) return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        StringBuilder stringBuilder = new StringBuilder(31);
                        stringBuilder.append("UNKNOWN_ERROR_CODE(");
                        stringBuilder.append(n);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                    }
                    case 24: {
                        return "API_DISABLED_FOR_CONNECTION";
                    }
                    case 23: {
                        return "API_DISABLED";
                    }
                    case 22: {
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    }
                    case 21: {
                        return "API_VERSION_UPDATE_REQUIRED";
                    }
                    case 20: {
                        return "RESTRICTED_PROFILE";
                    }
                    case 19: {
                        return "SERVICE_MISSING_PERMISSION";
                    }
                    case 18: {
                        return "SERVICE_UPDATING";
                    }
                    case 17: {
                        return "SIGN_IN_FAILED";
                    }
                    case 16: {
                        return "API_UNAVAILABLE";
                    }
                    case 15: {
                        return "INTERRUPTED";
                    }
                    case 14: {
                        return "TIMEOUT";
                    }
                    case 13: 
                }
                return "CANCELED";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 0: {
                return "SUCCESS";
            }
            case -1: 
        }
        return "UNKNOWN";
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConnectionResult)) {
            return false;
        }
        object = (ConnectionResult)((Object)object);
        if (this.zzb != ((ConnectionResult)((Object)object)).zzb) return false;
        if (!Objects.equal((Object)this.zzc, (Object)((ConnectionResult)((Object)object)).zzc)) return false;
        if (!Objects.equal((Object)this.zzd, (Object)((ConnectionResult)((Object)object)).zzd)) return false;
        return true;
    }

    public int getErrorCode() {
        return this.zzb;
    }

    public String getErrorMessage() {
        return this.zzd;
    }

    public PendingIntent getResolution() {
        return this.zzc;
    }

    public boolean hasResolution() {
        if (this.zzb == 0) return false;
        if (this.zzc == null) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zzb, this.zzc, this.zzd});
    }

    public boolean isSuccess() {
        if (this.zzb != 0) return false;
        return true;
    }

    public void startResolutionForResult(Activity activity, int n) throws IntentSender.SendIntentException {
        if (!this.hasResolution()) {
            return;
        }
        PendingIntent pendingIntent = this.zzc;
        Preconditions.checkNotNull((Object)pendingIntent);
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), n, null, 0, 0, 0);
    }

    public String toString() {
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper((Object)((Object)this));
        toStringHelper.add("statusCode", (Object)ConnectionResult.zza(this.zzb));
        toStringHelper.add("resolution", (Object)this.zzc);
        toStringHelper.add("message", (Object)this.zzd);
        return toStringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.getErrorCode());
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.getResolution(), (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.getErrorMessage(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
