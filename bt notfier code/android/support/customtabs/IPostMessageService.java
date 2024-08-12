/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 */
package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;

public interface IPostMessageService
extends IInterface {
    public void onMessageChannelReady(ICustomTabsCallback var1, Bundle var2) throws RemoteException;

    public void onPostMessage(ICustomTabsCallback var1, String var2, Bundle var3) throws RemoteException;
}
