/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  androidx.fragment.app.FragmentActivity
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$AnyClientKey
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.SignInConnectionListener
 *  com.google.android.gms.common.api.internal.zacv
 */
package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zacv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

@Deprecated
public abstract class GoogleApiClient {
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zaa = Collections.newSetFromMap(new WeakHashMap());

    public static void dumpAll(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        Set<GoogleApiClient> set = zaa;
        synchronized (set) {
            String string2 = String.valueOf(string).concat("  ");
            Iterator<GoogleApiClient> iterator = zaa.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                GoogleApiClient googleApiClient = iterator.next();
                printWriter.append(string).append("GoogleApiClient#").println(n);
                googleApiClient.dump(string2, fileDescriptor, printWriter, stringArray);
                ++n;
            }
            return;
        }
    }

    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set = zaa;
        synchronized (set) {
            Set<GoogleApiClient> set2 = zaa;
            return set2;
        }
    }

    static /* synthetic */ Set zaq() {
        return zaa;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long var1, TimeUnit var3);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int n) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    public <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult getConnectionResult(Api<?> var1);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public boolean hasApi(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> var1);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks var1);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener var1);

    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks var1);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener var1);

    public <L> ListenerHolder<L> registerListener(L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(FragmentActivity var1);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks var1);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener var1);

    public void zao(zacv zacv2) {
        throw new UnsupportedOperationException();
    }

    public void zap(zacv zacv2) {
        throw new UnsupportedOperationException();
    }
}
