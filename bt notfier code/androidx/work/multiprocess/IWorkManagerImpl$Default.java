/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImpl
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImpl;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static class IWorkManagerImpl.Default
implements IWorkManagerImpl {
    public IBinder asBinder() {
        return null;
    }

    public void cancelAllWork(IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void cancelAllWorkByTag(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void cancelUniqueWork(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void cancelWorkById(String string, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void enqueueContinuation(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void enqueueWorkRequests(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void queryWorkInfo(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }

    public void setProgress(byte[] byArray, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
    }
}
