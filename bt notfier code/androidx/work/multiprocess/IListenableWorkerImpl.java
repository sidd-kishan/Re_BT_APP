/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public interface IListenableWorkerImpl
extends IInterface {
    public void interrupt(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void startWork(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;
}
