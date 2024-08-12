/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.session.MediaSessionCompat$Token
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

private static interface MediaBrowserServiceCompat.ServiceCallbacks {
    public IBinder asBinder();

    public void onConnect(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException;

    public void onConnectFailed() throws RemoteException;

    public void onLoadChildren(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3, Bundle var4) throws RemoteException;
}
