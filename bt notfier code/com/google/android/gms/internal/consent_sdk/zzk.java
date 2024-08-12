/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.ump.FormError
 */
package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.FormError;

public final class zzk
extends Exception {
    private final int zza;

    public zzk(int n, String string) {
        super(string);
        this.zza = n;
    }

    public zzk(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.zza = n;
    }

    @Override
    public final String getMessage() {
        return super.getMessage();
    }

    public final FormError zza() {
        if (this.getCause() == null) {
            Log.w((String)"UserMessagingPlatform", (String)this.getMessage());
        } else {
            Log.w((String)"UserMessagingPlatform", (String)this.getMessage(), (Throwable)this.getCause());
        }
        return new FormError(this.zza, this.getMessage());
    }
}
