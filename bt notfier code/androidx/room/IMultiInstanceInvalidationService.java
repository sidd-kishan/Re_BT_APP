/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  androidx.room.IMultiInstanceInvalidationCallback
 */
package androidx.room;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

public interface IMultiInstanceInvalidationService
extends IInterface {
    public void broadcastInvalidation(int var1, String[] var2) throws RemoteException;

    public int registerCallback(IMultiInstanceInvalidationCallback var1, String var2) throws RemoteException;

    public void unregisterCallback(IMultiInstanceInvalidationCallback var1, int var2) throws RemoteException;
}
