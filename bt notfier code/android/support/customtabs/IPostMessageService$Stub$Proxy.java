/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.IPostMessageService
 */
package android.support.customtabs;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

private static class IPostMessageService.Stub.Proxy
implements IPostMessageService {
    private IBinder mRemote;

    IPostMessageService.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "android.support.customtabs.IPostMessageService";
    }

    public void onMessageChannelReady(ICustomTabsCallback object, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.IPostMessageService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void onPostMessage(ICustomTabsCallback object, String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.IPostMessageService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}
