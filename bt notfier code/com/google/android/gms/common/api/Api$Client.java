/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.IBinder
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
 *  com.google.android.gms.common.internal.IAccountAccessor
 */
package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

public static interface Api.Client
extends Api.AnyClient {
    public void connect(BaseGmsClient.ConnectionProgressReportCallbacks var1);

    public void disconnect();

    public void disconnect(String var1);

    public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public Feature[] getAvailableFeatures();

    public String getEndpointPackageName();

    public String getLastDisconnectMessage();

    public int getMinApkVersion();

    public void getRemoteService(IAccountAccessor var1, Set<Scope> var2);

    public Feature[] getRequiredFeatures();

    public Set<Scope> getScopesForConnectionlessNonSignIn();

    public IBinder getServiceBrokerBinder();

    public Intent getSignInIntent();

    public boolean isConnected();

    public boolean isConnecting();

    public void onUserSignOut(BaseGmsClient.SignOutCallbacks var1);

    public boolean providesSignIn();

    public boolean requiresAccount();

    public boolean requiresGooglePlayServices();

    public boolean requiresSignIn();
}
