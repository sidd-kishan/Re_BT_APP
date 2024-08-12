/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.ResolvableApiException
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class ApiExceptionUtil {
    public static ApiException fromStatus(Status status) {
        if (!status.hasResolution()) return new ApiException(status);
        return new ResolvableApiException(status);
    }
}
