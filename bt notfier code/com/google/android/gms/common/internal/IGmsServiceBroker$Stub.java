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
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.IGmsCallbacks
 *  com.google.android.gms.common.internal.IGmsServiceBroker
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzai
 *  com.google.android.gms.common.internal.zzz
 */
package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzz;

public static abstract class IGmsServiceBroker.Stub
extends Binder
implements IGmsServiceBroker {
    public IGmsServiceBroker.Stub() {
        this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }

    public IBinder asBinder() {
        return this;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final boolean onTransact(int var1_1, Parcel var2_2, Parcel var3_3, int var4_4) throws RemoteException {
        block13: {
            block12: {
                if (var1_1 > 0xFFFFFF) {
                    return super.onTransact(var1_1, var2_2, var3_3, var4_4);
                }
                var2_2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                var7_5 = var2_2.readStrongBinder();
                var6_6 = null;
                var5_7 /* !! */  = var7_5 == null ? null : ((var5_7 /* !! */  = var7_5.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks")) instanceof IGmsCallbacks != false ? (IGmsCallbacks)var5_7 /* !! */  : new zzz(var7_5));
                if (var1_1 == 46) {
                    if (var2_2.readInt() != 0) {
                        var6_6 = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(var2_2);
                    }
                    this.getService((IGmsCallbacks)var5_7 /* !! */ , var6_6);
                    Preconditions.checkNotNull((Object)var3_3);
                    var3_3.writeNoException();
                    return true;
                }
                if (var1_1 == 47) {
                    if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
                    var2_2 = (zzai)zzai.CREATOR.createFromParcel(var2_2);
                    throw new UnsupportedOperationException();
                }
                var2_2.readInt();
                if (var1_1 == 4) throw new UnsupportedOperationException();
                var2_2.readString();
                if (var1_1 == 1) break block12;
                if (var1_1 == 2 || var1_1 == 23 || var1_1 == 25 || var1_1 == 27) ** GOTO lbl-1000
                if (var1_1 == 30) ** GOTO lbl-1000
                if (var1_1 == 34) ** GOTO lbl-1000
                if (var1_1 != 41 && var1_1 != 43 && var1_1 != 37 && var1_1 != 38) {
                    switch (var1_1) {
                        default: {
                            break;
                        }
                        case 19: {
                            var2_2.readStrongBinder();
                            if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
                            var2_2 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                        case 10: {
                            var2_2.readString();
                            var2_2.createStringArray();
                            break;
                        }
                        case 9: {
                            var2_2.readString();
                            var2_2.createStringArray();
                            var2_2.readString();
                            var2_2.readStrongBinder();
                            var2_2.readString();
                            if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
                            var2_2 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                    }
                }
                ** GOTO lbl-1000
lbl-1000:
                // 1 sources

                {
                    var2_2.readString();
                    break;
                    case 20: lbl-1000:
                    // 2 sources

                    {
                        var2_2.createStringArray();
                        var2_2.readString();
                        if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
                        var2_2 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                        break;
                    }
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: 
                    case 16: 
                    case 17: 
                    case 18: lbl-1000:
                    // 3 sources

                    {
                        if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
                        var2_2 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                        break;
                    }
                }
                break block13;
            }
            var2_2.readString();
            var2_2.createStringArray();
            var2_2.readString();
            if (var2_2.readInt() == 0) throw new UnsupportedOperationException();
            var2_2 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
        }
        throw new UnsupportedOperationException();
    }
}
