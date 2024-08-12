/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsCallback$Stub
 *  android.support.customtabs.IPostMessageService
 *  android.support.customtabs.IPostMessageService$Stub$Proxy
 */
package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService;

public static abstract class IPostMessageService.Stub
extends Binder
implements IPostMessageService {
    private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
    static final int TRANSACTION_onMessageChannelReady = 2;
    static final int TRANSACTION_onPostMessage = 3;

    public IPostMessageService.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IPostMessageService asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IPostMessageService)) return new Proxy(iBinder);
        return (IPostMessageService)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        String string = null;
        String string2 = null;
        if (n != 2) {
            if (n != 3) {
                if (n != 1598968902) {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            ICustomTabsCallback iCustomTabsCallback = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
            string = parcel.readString();
            if (parcel.readInt() != 0) {
                string2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            this.onPostMessage(iCustomTabsCallback, string, (Bundle)string2);
            parcel2.writeNoException();
            return true;
        }
        parcel.enforceInterface(DESCRIPTOR);
        ICustomTabsCallback iCustomTabsCallback = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
        string2 = string;
        if (parcel.readInt() != 0) {
            string2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        this.onMessageChannelReady(iCustomTabsCallback, (Bundle)string2);
        parcel2.writeNoException();
        return true;
    }
}
