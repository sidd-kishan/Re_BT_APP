/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.internal.ApiKey
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;

public interface HasApiKey<O extends Api.ApiOptions> {
    public ApiKey<O> getApiKey();
}
