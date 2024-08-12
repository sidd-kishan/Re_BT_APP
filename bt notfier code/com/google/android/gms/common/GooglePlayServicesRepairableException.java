/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  com.google.android.gms.common.UserRecoverableException
 */
package com.google.android.gms.common;

import android.content.Intent;
import com.google.android.gms.common.UserRecoverableException;

public class GooglePlayServicesRepairableException
extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(int n, String string, Intent intent) {
        super(string, intent);
        this.zza = n;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}
