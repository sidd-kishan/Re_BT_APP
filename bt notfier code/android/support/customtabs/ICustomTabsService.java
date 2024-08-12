/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 */
package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import java.util.List;

public interface ICustomTabsService
extends IInterface {
    public Bundle extraCommand(String var1, Bundle var2) throws RemoteException;

    public boolean mayLaunchUrl(ICustomTabsCallback var1, Uri var2, Bundle var3, List<Bundle> var4) throws RemoteException;

    public boolean newSession(ICustomTabsCallback var1) throws RemoteException;

    public int postMessage(ICustomTabsCallback var1, String var2, Bundle var3) throws RemoteException;

    public boolean requestPostMessageChannel(ICustomTabsCallback var1, Uri var2) throws RemoteException;

    public boolean updateVisuals(ICustomTabsCallback var1, Bundle var2) throws RemoteException;

    public boolean validateRelationship(ICustomTabsCallback var1, int var2, Uri var3, Bundle var4) throws RemoteException;

    public boolean warmup(long var1) throws RemoteException;
}
