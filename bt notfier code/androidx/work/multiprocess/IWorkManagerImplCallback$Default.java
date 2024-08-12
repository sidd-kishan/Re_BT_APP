/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  androidx.work.multiprocess.IWorkManagerImplCallback
 */
package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.work.multiprocess.IWorkManagerImplCallback;

public static class IWorkManagerImplCallback.Default
implements IWorkManagerImplCallback {
    public IBinder asBinder() {
        return null;
    }

    public void onFailure(String string) throws RemoteException {
    }

    public void onSuccess(byte[] byArray) throws RemoteException {
    }
}
