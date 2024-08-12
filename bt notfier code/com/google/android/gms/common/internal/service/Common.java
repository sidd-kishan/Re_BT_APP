/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ApiOptions$NoOptions
 *  com.google.android.gms.common.api.Api$ClientKey
 *  com.google.android.gms.common.internal.service.zab
 *  com.google.android.gms.common.internal.service.zae
 *  com.google.android.gms.common.internal.service.zah
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.service.zab;
import com.google.android.gms.common.internal.service.zae;
import com.google.android.gms.common.internal.service.zah;

public final class Common {
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.ClientKey<zah> CLIENT_KEY;
    public static final zae zaa;
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> zab;

    static {
        zab zab2;
        CLIENT_KEY = new Api.ClientKey();
        zab = zab2 = new zab();
        API = new Api("Common.API", (Api.AbstractClientBuilder)zab2, CLIENT_KEY);
        zaa = new zae();
    }
}
