/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.google.android.gms.common.api.GoogleApi$Settings
 *  com.google.android.gms.common.api.internal.ApiExceptionMapper
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.Preconditions;

public static class GoogleApi.Settings.Builder {
    private StatusExceptionMapper zaa;
    private Looper zab;

    public GoogleApi.Settings build() {
        if (this.zaa == null) {
            this.zaa = new ApiExceptionMapper();
        }
        if (this.zab != null) return new GoogleApi.Settings(this.zaa, null, this.zab, null);
        this.zab = Looper.getMainLooper();
        return new GoogleApi.Settings(this.zaa, null, this.zab, null);
    }

    public GoogleApi.Settings.Builder setLooper(Looper looper) {
        Preconditions.checkNotNull((Object)looper, (Object)"Looper must not be null.");
        this.zab = looper;
        return this;
    }

    public GoogleApi.Settings.Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
        Preconditions.checkNotNull((Object)statusExceptionMapper, (Object)"StatusExceptionMapper must not be null.");
        this.zaa = statusExceptionMapper;
        return this;
    }
}
