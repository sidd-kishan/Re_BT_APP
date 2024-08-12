/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.customtabs.ICustomTabsCallback
 *  android.support.customtabs.ICustomTabsService
 */
package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

private static class ICustomTabsService.Stub.Proxy
implements ICustomTabsService {
    private IBinder mRemote;

    ICustomTabsService.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public Bundle extraCommand(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            string = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return string;
    }

    public String getInterfaceDescriptor() {
        return "android.support.customtabs.ICustomTabsService";
    }

    public boolean mayLaunchUrl(ICustomTabsCallback object, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            bl = true;
            if (uri != null) {
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeTypedList(list);
            this.mRemote.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            if (n != 0) {
            } else {
                bl = false;
            }
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }

    public boolean newSession(ICustomTabsCallback object) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            object = this.mRemote;
            bl = false;
            object.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            if (n == 0) return bl;
            bl = true;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }

    public int postMessage(ICustomTabsCallback object, String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            return n;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public boolean requestPostMessageChannel(ICustomTabsCallback object, Uri uri) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            bl = true;
            if (uri != null) {
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            if (n != 0) {
            } else {
                bl = false;
            }
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }

    public boolean updateVisuals(ICustomTabsCallback object, Bundle bundle) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            bl = true;
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            if (n != 0) {
            } else {
                bl = false;
            }
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }

    public boolean validateRelationship(ICustomTabsCallback object, int n, Uri uri, Bundle bundle) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeInt(n);
            bl = true;
            if (uri != null) {
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            n = parcel2.readInt();
            if (n != 0) {
            } else {
                bl = false;
            }
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }

    public boolean warmup(long l) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcel.writeLong(l);
            IBinder iBinder = this.mRemote;
            bl = false;
            iBinder.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            if (n == 0) return bl;
            bl = true;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bl;
    }
}
