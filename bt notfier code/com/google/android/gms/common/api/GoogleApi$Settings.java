/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Looper
 *  com.google.android.gms.common.api.GoogleApi$Settings$Builder
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.api.zad
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.zad;

public static class GoogleApi.Settings {
    public static final GoogleApi.Settings DEFAULT_SETTINGS = new Builder().build();
    public final StatusExceptionMapper zaa;
    public final Looper zab;

    private GoogleApi.Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
        this.zaa = statusExceptionMapper;
        this.zab = looper;
    }

    /* synthetic */ GoogleApi.Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, zad zad2) {
        this(statusExceptionMapper, null, looper);
    }
}
