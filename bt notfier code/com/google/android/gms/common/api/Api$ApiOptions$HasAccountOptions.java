/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  com.google.android.gms.common.api.Api$ApiOptions$HasOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$NotRequiredOptions
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import com.google.android.gms.common.api.Api;

public static interface Api.ApiOptions.HasAccountOptions
extends Api.ApiOptions.HasOptions,
Api.ApiOptions.NotRequiredOptions {
    public Account getAccount();
}
