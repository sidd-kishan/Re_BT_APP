/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

public interface zaba {
    public void zaa();

    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T var1);

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T var1);

    public boolean zad();

    public void zae();

    public void zaf(Bundle var1);

    public void zag(ConnectionResult var1, Api<?> var2, boolean var3);

    public void zah(int var1);
}
