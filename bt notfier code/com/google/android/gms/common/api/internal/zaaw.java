/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.StatusPendingResult
 *  com.google.android.gms.common.api.internal.zaaz
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaz;

final class zaaw
implements ResultCallback<Status> {
    final StatusPendingResult zaa;
    final boolean zab;
    final GoogleApiClient zac;
    final zaaz zad;

    zaaw(zaaz zaaz2, StatusPendingResult statusPendingResult, boolean bl, GoogleApiClient googleApiClient) {
        this.zad = zaaz2;
        this.zaa = statusPendingResult;
        this.zab = bl;
        this.zac = googleApiClient;
    }
}
