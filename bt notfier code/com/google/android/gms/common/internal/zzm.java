/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class zzm {
    private static final Uri zzf = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    private final String zza;
    private final String zzb;
    private final ComponentName zzc;
    private final int zzd;
    private final boolean zze;

    public zzm(ComponentName componentName, int n) {
        this.zza = null;
        this.zzb = null;
        Preconditions.checkNotNull((Object)componentName);
        this.zzc = componentName;
        this.zzd = n;
        this.zze = false;
    }

    public zzm(String string, String string2, int n) {
        this(string, "com.google.android.gms", n, false);
    }

    public zzm(String string, String string2, int n, boolean bl) {
        Preconditions.checkNotEmpty((String)string);
        this.zza = string;
        Preconditions.checkNotEmpty((String)string2);
        this.zzb = string2;
        this.zzc = null;
        this.zzd = n;
        this.zze = bl;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzm)) {
            return false;
        }
        object = (zzm)object;
        if (!Objects.equal((Object)this.zza, (Object)((zzm)object).zza)) return false;
        if (!Objects.equal((Object)this.zzb, (Object)((zzm)object).zzb)) return false;
        if (!Objects.equal((Object)this.zzc, (Object)((zzm)object).zzc)) return false;
        if (this.zzd != ((zzm)object).zzd) return false;
        if (this.zze != ((zzm)object).zze) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze});
    }

    public final String toString() {
        String string;
        String string2 = string = this.zza;
        if (string != null) return string2;
        Preconditions.checkNotNull((Object)this.zzc);
        string2 = this.zzc.flattenToString();
        return string2;
    }

    public final String zza() {
        return this.zzb;
    }

    public final ComponentName zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final Intent zzd(Context object) {
        Object object2;
        if (this.zza != null) {
            boolean bl = this.zze;
            object2 = null;
            Object var4_5 = null;
            if (bl) {
                object2 = new Bundle();
                object2.putString("serviceActionBundleKey", this.zza);
                try {
                    object = object.getContentResolver().call(zzf, "serviceIntentCall", null, (Bundle)object2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object = String.valueOf(illegalArgumentException);
                    object2 = new StringBuilder(String.valueOf(object).length() + 34);
                    ((StringBuilder)object2).append("Dynamic intent resolution failed: ");
                    ((StringBuilder)object2).append((String)object);
                    Log.w((String)"ConnectionStatusConfig", (String)((StringBuilder)object2).toString());
                    object = null;
                }
                object = object == null ? var4_5 : (Intent)object.getParcelable("serviceResponseIntentKey");
                object2 = object;
                if (object == null) {
                    object2 = String.valueOf(this.zza);
                    object2 = ((String)object2).length() != 0 ? "Dynamic lookup for intent failed for action: ".concat((String)object2) : new String("Dynamic lookup for intent failed for action: ");
                    Log.w((String)"ConnectionStatusConfig", (String)object2);
                    object2 = object;
                }
            }
            if (object2 == null) return new Intent(this.zza).setPackage(this.zzb);
        } else {
            object2 = new Intent().setComponent(this.zzc);
        }
        return object2;
    }
}
