/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.internal.service.zac
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.service.zac;

public final class zae {
    public final PendingResult<Status> zaa(GoogleApiClient googleApiClient) {
        return googleApiClient.execute((BaseImplementation.ApiMethodImpl)new zac(this, googleApiClient));
    }
}
