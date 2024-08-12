/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.internal.service.Common
 *  com.google.android.gms.common.internal.service.zah
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.zah;

abstract class zag<R extends Result>
extends BaseImplementation.ApiMethodImpl<R, zah> {
    public zag(GoogleApiClient googleApiClient) {
        super(Common.API, googleApiClient);
    }
}
