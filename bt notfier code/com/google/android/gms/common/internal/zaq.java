/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Response
 *  com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zaq
implements PendingResultUtil.ResultConverter {
    final Response zaa;

    zaq(Response response) {
        this.zaa = response;
    }
}
