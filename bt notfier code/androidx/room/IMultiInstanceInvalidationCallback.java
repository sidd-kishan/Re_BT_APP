/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package androidx.room;

import android.os.IInterface;
import android.os.RemoteException;

public interface IMultiInstanceInvalidationCallback
extends IInterface {
    public void onInvalidation(String[] var1) throws RemoteException;
}
