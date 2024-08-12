/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  android.support.v4.os.IResultReceiver
 *  android.support.v4.os.IResultReceiver$Stub
 *  android.support.v4.os.ResultReceiver$MyResultReceiver
 *  android.support.v4.os.ResultReceiver$MyRunnable
 */
package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.ResultReceiver;

public class ResultReceiver
implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    public ResultReceiver(Handler handler) {
        this.mLocal = true;
        this.mHandler = handler;
    }

    ResultReceiver(Parcel parcel) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver.Stub.asInterface((IBinder)parcel.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    protected void onReceiveResult(int n, Bundle bundle) {
    }

    /*
     * Enabled force condition propagation
     */
    public void send(int n, Bundle bundle) {
        if (this.mLocal) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post((Runnable)new MyRunnable(this, n, bundle));
                return;
            }
            this.onReceiveResult(n, bundle);
            return;
        }
        IResultReceiver iResultReceiver = this.mReceiver;
        if (iResultReceiver == null) return;
        try {
            iResultReceiver.send(n, bundle);
            return;
        }
        catch (RemoteException remoteException) {
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int n) {
        synchronized (this) {
            if (this.mReceiver == null) {
                MyResultReceiver myResultReceiver = new MyResultReceiver(this);
                this.mReceiver = myResultReceiver;
            }
            parcel.writeStrongBinder(this.mReceiver.asBinder());
            return;
        }
    }
}
