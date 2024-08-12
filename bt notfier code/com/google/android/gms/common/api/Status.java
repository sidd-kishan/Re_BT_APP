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
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.CommonStatusCodes
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.zzb
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Objects$ToStringHelper
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Status
extends AbstractSafeParcelable
implements Result,
ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR;
    public static final Status RESULT_CANCELED;
    public static final Status RESULT_DEAD_CLIENT;
    public static final Status RESULT_INTERNAL_ERROR;
    public static final Status RESULT_INTERRUPTED;
    public static final Status RESULT_SUCCESS;
    public static final Status RESULT_TIMEOUT;
    public static final Status zza;
    final int zzb;
    private final int zzc;
    private final String zzd;
    private final PendingIntent zze;
    private final ConnectionResult zzf;

    static {
        RESULT_SUCCESS = new Status(0);
        RESULT_INTERRUPTED = new Status(14);
        RESULT_INTERNAL_ERROR = new Status(8);
        RESULT_TIMEOUT = new Status(15);
        RESULT_CANCELED = new Status(16);
        zza = new Status(17);
        RESULT_DEAD_CLIENT = new Status(18);
        CREATOR = new zzb();
    }

    public Status(int n) {
        this(n, null);
    }

    Status(int n, int n2, String string, PendingIntent pendingIntent) {
        this(n, n2, string, pendingIntent, null);
    }

    Status(int n, int n2, String string, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = n;
        this.zzc = n2;
        this.zzd = string;
        this.zze = pendingIntent;
        this.zzf = connectionResult;
    }

    public Status(int n, String string) {
        this(1, n, string, null);
    }

    public Status(int n, String string, PendingIntent pendingIntent) {
        this(1, n, string, pendingIntent);
    }

    public Status(ConnectionResult connectionResult, String string) {
        this(connectionResult, string, 17);
    }

    @Deprecated
    public Status(ConnectionResult connectionResult, String string, int n) {
        this(1, n, string, connectionResult.getResolution(), connectionResult);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Status)) {
            return false;
        }
        object = (Status)((Object)object);
        if (this.zzb != ((Status)((Object)object)).zzb) return false;
        if (this.zzc != ((Status)((Object)object)).zzc) return false;
        if (!Objects.equal((Object)this.zzd, (Object)((Status)((Object)object)).zzd)) return false;
        if (!Objects.equal((Object)this.zze, (Object)((Status)((Object)object)).zze)) return false;
        if (!Objects.equal((Object)this.zzf, (Object)((Status)((Object)object)).zzf)) return false;
        return true;
    }

    public ConnectionResult getConnectionResult() {
        return this.zzf;
    }

    public PendingIntent getResolution() {
        return this.zze;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzc;
    }

    public String getStatusMessage() {
        return this.zzd;
    }

    public boolean hasResolution() {
        if (this.zze == null) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zzb, this.zzc, this.zzd, this.zze, this.zzf});
    }

    public boolean isCanceled() {
        if (this.zzc != 16) return false;
        return true;
    }

    public boolean isInterrupted() {
        if (this.zzc != 14) return false;
        return true;
    }

    public boolean isSuccess() {
        if (this.zzc > 0) return false;
        return true;
    }

    public void startResolutionForResult(Activity activity, int n) throws IntentSender.SendIntentException {
        if (!this.hasResolution()) {
            return;
        }
        PendingIntent pendingIntent = this.zze;
        Preconditions.checkNotNull((Object)pendingIntent);
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), n, null, 0, 0, 0);
    }

    public String toString() {
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper((Object)((Object)this));
        toStringHelper.add("statusCode", (Object)this.zza());
        toStringHelper.add("resolution", (Object)this.zze);
        return toStringHelper.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.getStatusCode());
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.getStatusMessage(), (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zze, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)4, (Parcelable)this.getConnectionResult(), (int)n, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1000, (int)this.zzb);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final String zza() {
        String string = this.zzd;
        if (string == null) return CommonStatusCodes.getStatusCodeString((int)this.zzc);
        return string;
    }
}
