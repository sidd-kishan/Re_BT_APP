/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface ICustomTabsCallback
extends IInterface {
    public void extraCallback(String var1, Bundle var2) throws RemoteException;

    public void onMessageChannelReady(Bundle var1) throws RemoteException;

    public void onNavigationEvent(int var1, Bundle var2) throws RemoteException;

    public void onPostMessage(String var1, Bundle var2) throws RemoteException;

    public void onRelationshipValidationResult(int var1, Uri var2, boolean var3, Bundle var4) throws RemoteException;
}
