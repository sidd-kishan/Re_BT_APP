/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IListenableWorkerImpl
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.work.multiprocess.IListenableWorkerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static class IListenableWorkerImpl.Default
implements IListenableWorkerImpl {
    public IBinder asBinder() {
        return null;
    }

    public void interrupt(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void startWork(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }
}
