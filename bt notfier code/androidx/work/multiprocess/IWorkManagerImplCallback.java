/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 */
package androidx.work.multiprocess;

import android.os.IInterface;
import android.os.RemoteException;

public interface IWorkManagerImplCallback
extends IInterface {
    public void onFailure(String var1) throws RemoteException;

    public void onSuccess(byte[] var1) throws RemoteException;
}
