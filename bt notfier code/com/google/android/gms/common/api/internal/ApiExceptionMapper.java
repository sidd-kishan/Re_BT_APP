/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.internal.ApiExceptionUtil
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.ApiExceptionUtil;

public class ApiExceptionMapper
implements StatusExceptionMapper {
    public final Exception getException(Status status) {
        return ApiExceptionUtil.fromStatus((Status)status);
    }
}
