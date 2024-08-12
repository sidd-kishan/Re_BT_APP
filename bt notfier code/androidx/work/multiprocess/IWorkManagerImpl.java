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

public interface IWorkManagerImpl
extends IInterface {
    public void cancelAllWork(IWorkManagerImplCallback var1) throws RemoteException;

    public void cancelAllWorkByTag(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void cancelUniqueWork(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void cancelWorkById(String var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void enqueueContinuation(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void enqueueWorkRequests(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void queryWorkInfo(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;

    public void setProgress(byte[] var1, IWorkManagerImplCallback var2) throws RemoteException;
}
