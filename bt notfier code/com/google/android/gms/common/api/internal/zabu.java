/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.SignInConnectionListener
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zabu {
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T var1);

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T var1);

    public ConnectionResult zad(Api<?> var1);

    public void zae();

    public ConnectionResult zaf();

    public ConnectionResult zag(long var1, TimeUnit var3);

    public void zah();

    public boolean zai();

    public boolean zaj();

    public boolean zak(SignInConnectionListener var1);

    public void zal();

    public void zam();

    public void zan(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);
}
