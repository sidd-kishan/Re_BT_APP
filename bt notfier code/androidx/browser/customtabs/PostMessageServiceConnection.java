/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsCallback$Stub
 *  android.support.customtabs.IPostMessageService
 *  android.support.customtabs.IPostMessageService$Stub
 *  androidx.browser.customtabs.CustomTabsSessionToken
 *  androidx.browser.customtabs.PostMessageService
 */
package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;
import androidx.browser.customtabs.CustomTabsSessionToken;
import androidx.browser.customtabs.PostMessageService;

public abstract class PostMessageServiceConnection
implements ServiceConnection {
    private final Object mLock = new Object();
    private IPostMessageService mService;
    private final ICustomTabsCallback mSessionBinder;

    public PostMessageServiceConnection(CustomTabsSessionToken customTabsSessionToken) {
        this.mSessionBinder = ICustomTabsCallback.Stub.asInterface((IBinder)customTabsSessionToken.getCallbackBinder());
    }

    public boolean bindSessionToPostMessageService(Context context, String string) {
        Intent intent = new Intent();
        intent.setClassName(string, PostMessageService.class.getName());
        return context.bindService(intent, (ServiceConnection)this, 1);
    }

    public final boolean notifyMessageChannelReady(Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        Object object = this.mLock;
        synchronized (object) {
            try {
                try {
                    this.mService.onMessageChannelReady(this.mSessionBinder, bundle);
                    return true;
                }
                catch (RemoteException remoteException) {
                    return false;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void onPostMessageServiceConnected() {
    }

    public void onPostMessageServiceDisconnected() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = IPostMessageService.Stub.asInterface((IBinder)iBinder);
        this.onPostMessageServiceConnected();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.onPostMessageServiceDisconnected();
    }

    public final boolean postMessage(String string, Bundle bundle) {
        if (this.mService == null) {
            return false;
        }
        Object object = this.mLock;
        synchronized (object) {
            try {
                try {
                    this.mService.onPostMessage(this.mSessionBinder, string, bundle);
                    return true;
                }
                catch (RemoteException remoteException) {
                    return false;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void unbindFromContext(Context context) {
        context.unbindService((ServiceConnection)this);
    }
}
