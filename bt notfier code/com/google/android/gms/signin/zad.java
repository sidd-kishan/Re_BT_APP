/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ClientKey
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.signin.SignInOptions
 *  com.google.android.gms.signin.internal.SignInClientImpl
 *  com.google.android.gms.signin.zaa
 *  com.google.android.gms.signin.zab
 *  com.google.android.gms.signin.zac
 */
package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zab;
import com.google.android.gms.signin.zac;

public final class zad {
    public static final Api.ClientKey<SignInClientImpl> zaa = new Api.ClientKey();
    public static final Api.ClientKey<SignInClientImpl> zab = new Api.ClientKey();
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zac = new zaa();
    static final Api.AbstractClientBuilder<SignInClientImpl, zac> zad = new zab();
    public static final Scope zae = new Scope("profile");
    public static final Scope zaf = new Scope("email");
    public static final Api<SignInOptions> zag = new Api("SignIn.API", zac, zaa);
    public static final Api<zac> zah = new Api("SignIn.INTERNAL_API", zad, zab);
}
