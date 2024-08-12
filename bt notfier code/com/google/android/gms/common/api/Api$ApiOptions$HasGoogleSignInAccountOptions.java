/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.api.Api$ApiOptions$HasOptions
 */
package com.google.android.gms.common.api;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;

public static interface Api.ApiOptions.HasGoogleSignInAccountOptions
extends Api.ApiOptions.HasOptions {
    public GoogleSignInAccount getGoogleSignInAccount();
}
