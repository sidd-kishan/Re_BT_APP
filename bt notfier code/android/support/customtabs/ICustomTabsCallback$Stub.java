/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsCallback$Stub$Proxy
 */
package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;

public static abstract class ICustomTabsCallback.Stub
extends Binder
implements ICustomTabsCallback {
    private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
    static final int TRANSACTION_extraCallback = 3;
    static final int TRANSACTION_onMessageChannelReady = 4;
    static final int TRANSACTION_onNavigationEvent = 2;
    static final int TRANSACTION_onPostMessage = 5;
    static final int TRANSACTION_onRelationshipValidationResult = 6;

    public ICustomTabsCallback.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static ICustomTabsCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof ICustomTabsCallback)) return new Proxy(iBinder);
        return (ICustomTabsCallback)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        Object var8_5 = null;
        Bundle bundle = null;
        Object object = null;
        Bundle bundle2 = null;
        String string = null;
        if (n != 2) {
            if (n != 3) {
                if (n != 4) {
                    if (n != 5) {
                        if (n != 6) {
                            if (n != 1598968902) {
                                return super.onTransact(n, parcel, parcel2, n2);
                            }
                            parcel2.writeString(DESCRIPTOR);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        n = parcel.readInt();
                        object = parcel.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel) : null;
                        boolean bl = parcel.readInt() != 0;
                        if (parcel.readInt() != 0) {
                            string = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                        }
                        this.onRelationshipValidationResult(n, (Uri)object, bl, (Bundle)string);
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    string = parcel.readString();
                    object = var8_5;
                    if (parcel.readInt() != 0) {
                        object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.onPostMessage(string, (Bundle)object);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                object = bundle;
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.onMessageChannelReady((Bundle)object);
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            string = parcel.readString();
            if (parcel.readInt() != 0) {
                object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            this.extraCallback(string, (Bundle)object);
            parcel2.writeNoException();
            return true;
        }
        parcel.enforceInterface(DESCRIPTOR);
        n = parcel.readInt();
        object = bundle2;
        if (parcel.readInt() != 0) {
            object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        this.onNavigationEvent(n, (Bundle)object);
        parcel2.writeNoException();
        return true;
    }
}
