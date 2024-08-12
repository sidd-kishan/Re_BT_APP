/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class ApiKey<O extends Api.ApiOptions> {
    private final int zaa;
    private final Api<O> zab;
    private final O zac;
    private final String zad;

    private ApiKey(Api<O> api, O o, String string) {
        this.zab = api;
        this.zac = o;
        this.zad = string;
        this.zaa = Objects.hashCode((Object[])new Object[]{api, o, string});
    }

    public static <O extends Api.ApiOptions> ApiKey<O> zaa(Api<O> api, O o, String string) {
        return new ApiKey<O>(api, o, string);
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof ApiKey)) {
            return false;
        }
        object = (ApiKey)object;
        if (!Objects.equal(this.zab, ((ApiKey)object).zab)) return false;
        if (!Objects.equal(this.zac, ((ApiKey)object).zac)) return false;
        if (!Objects.equal((Object)this.zad, (Object)((ApiKey)object).zad)) return false;
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }

    public final String zab() {
        return this.zab.zad();
    }
}
