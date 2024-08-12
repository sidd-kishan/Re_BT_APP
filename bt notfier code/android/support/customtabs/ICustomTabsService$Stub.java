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
 *  android.support.customtabs.ICustomTabsCallback$Stub
 *  android.support.customtabs.ICustomTabsService
 *  android.support.customtabs.ICustomTabsService$Stub$Proxy
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
import android.support.customtabs.ICustomTabsService;

public static abstract class ICustomTabsService.Stub
extends Binder
implements ICustomTabsService {
    private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
    static final int TRANSACTION_extraCommand = 5;
    static final int TRANSACTION_mayLaunchUrl = 4;
    static final int TRANSACTION_newSession = 3;
    static final int TRANSACTION_postMessage = 8;
    static final int TRANSACTION_requestPostMessageChannel = 7;
    static final int TRANSACTION_updateVisuals = 6;
    static final int TRANSACTION_validateRelationship = 9;
    static final int TRANSACTION_warmup = 2;

    public ICustomTabsService.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static ICustomTabsService asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof ICustomTabsService)) return new Proxy(iBinder);
        return (ICustomTabsService)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n == 1598968902) {
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
        Object object = null;
        Object var9_6 = null;
        Object var10_7 = null;
        ICustomTabsCallback iCustomTabsCallback = null;
        String string = null;
        ICustomTabsCallback iCustomTabsCallback2 = null;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 9: {
                parcel.enforceInterface(DESCRIPTOR);
                iCustomTabsCallback = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
                n = parcel.readInt();
                object = parcel.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel) : null;
                string = iCustomTabsCallback2;
                if (parcel.readInt() != 0) {
                    string = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n = this.validateRelationship(iCustomTabsCallback, n, (Uri)object, (Bundle)string) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 8: {
                parcel.enforceInterface(DESCRIPTOR);
                iCustomTabsCallback2 = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
                string = parcel.readString();
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n = this.postMessage(iCustomTabsCallback2, string, (Bundle)object);
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 7: {
                parcel.enforceInterface(DESCRIPTOR);
                string = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
                object = var9_6;
                if (parcel.readInt() != 0) {
                    object = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                n = this.requestPostMessageChannel((ICustomTabsCallback)string, (Uri)object) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 6: {
                parcel.enforceInterface(DESCRIPTOR);
                string = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
                object = var10_7;
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n = this.updateVisuals((ICustomTabsCallback)string, (Bundle)object) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 5: {
                parcel.enforceInterface(DESCRIPTOR);
                string = parcel.readString();
                object = iCustomTabsCallback;
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                parcel = this.extraCommand(string, (Bundle)object);
                parcel2.writeNoException();
                if (parcel != null) {
                    parcel2.writeInt(1);
                    parcel.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            case 4: {
                parcel.enforceInterface(DESCRIPTOR);
                iCustomTabsCallback2 = ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder());
                object = parcel.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    string = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                n = this.mayLaunchUrl(iCustomTabsCallback2, (Uri)object, (Bundle)string, parcel.createTypedArrayList(Bundle.CREATOR)) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 3: {
                parcel.enforceInterface(DESCRIPTOR);
                n = this.newSession(ICustomTabsCallback.Stub.asInterface((IBinder)parcel.readStrongBinder())) ? 1 : 0;
                parcel2.writeNoException();
                parcel2.writeInt(n);
                return true;
            }
            case 2: 
        }
        parcel.enforceInterface(DESCRIPTOR);
        n = this.warmup(parcel.readLong()) ? 1 : 0;
        parcel2.writeNoException();
        parcel2.writeInt(n);
        return true;
    }
}
