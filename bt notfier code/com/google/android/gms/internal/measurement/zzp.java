/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.measurement.zzb
 *  com.google.android.gms.internal.measurement.zzc
 *  com.google.android.gms.internal.measurement.zzo
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzr
 *  com.google.android.gms.internal.measurement.zzt
 *  com.google.android.gms.internal.measurement.zzu
 *  com.google.android.gms.internal.measurement.zzw
 *  com.google.android.gms.internal.measurement.zzx
 *  com.google.android.gms.internal.measurement.zzy
 *  com.google.android.gms.internal.measurement.zzz
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.internal.measurement.zzz;

public abstract class zzp
extends zzb
implements zzq {
    public zzp() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzq asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (!(iInterface instanceof zzq)) return new zzo(iBinder);
        return (zzq)iInterface;
    }

    protected final boolean zza(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        Object var12_5 = null;
        Object var17_6 = null;
        Object var18_7 = null;
        Object var15_8 = null;
        Bundle bundle = null;
        String string = null;
        Object var19_11 = null;
        Object var14_12 = null;
        Object var20_13 = null;
        Object var21_14 = null;
        Object var11_15 = null;
        Object var13_16 = null;
        Object var22_17 = null;
        String string2 = null;
        IBinder iBinder = null;
        Object object2 = null;
        Object var16_21 = null;
        switch (n) {
            default: {
                return false;
            }
            case 45: {
                this.setConsentThirdParty((Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR), object.readLong());
                break;
            }
            case 44: {
                this.setConsent((Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR), object.readLong());
                break;
            }
            case 43: {
                this.clearMeasurementEnabled(object.readLong());
                break;
            }
            case 42: {
                this.setDefaultEventParameters((Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                break;
            }
            case 40: {
                object = object.readStrongBinder();
                object = object == null ? var16_21 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.isDataCollectionEnabled((zzt)object);
                break;
            }
            case 39: {
                this.setDataCollectionEnabled(zzc.zza((Parcel)object));
                break;
            }
            case 38: {
                object2 = object.readStrongBinder();
                object2 = object2 == null ? var12_5 : ((string2 = object2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)string2 : new zzr(object2));
                this.getTestFlag((zzt)object2, object.readInt());
                break;
            }
            case 37: {
                this.initForTests(zzc.zzf((Parcel)object));
                break;
            }
            case 36: {
                object = object.readStrongBinder();
                object = object == null ? var17_6 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy")) instanceof zzw ? (zzw)object2 : new zzu((IBinder)object));
                this.unregisterOnMeasurementEventListener((zzw)object);
                break;
            }
            case 35: {
                object = object.readStrongBinder();
                object = object == null ? var18_7 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy")) instanceof zzw ? (zzw)object2 : new zzu((IBinder)object));
                this.registerOnMeasurementEventListener((zzw)object);
                break;
            }
            case 34: {
                object = object.readStrongBinder();
                object = object == null ? var15_8 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy")) instanceof zzw ? (zzw)object2 : new zzu((IBinder)object));
                this.setEventInterceptor((zzw)object);
                break;
            }
            case 33: {
                this.logHealthData(object.readInt(), object.readString(), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()));
                break;
            }
            case 32: {
                string2 = (Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR);
                object2 = object.readStrongBinder();
                object2 = object2 == null ? bundle : ((string = object2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)string : new zzr(object2));
                this.performAction((Bundle)string2, (zzt)object2, object.readLong());
                break;
            }
            case 31: {
                string2 = IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder());
                object2 = object.readStrongBinder();
                object2 = object2 == null ? string : ((string = object2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)string : new zzr(object2));
                this.onActivitySaveInstanceState((IObjectWrapper)string2, (zzt)object2, object.readLong());
                break;
            }
            case 30: {
                this.onActivityResumed(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readLong());
                break;
            }
            case 29: {
                this.onActivityPaused(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readLong());
                break;
            }
            case 28: {
                this.onActivityDestroyed(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readLong());
                break;
            }
            case 27: {
                this.onActivityCreated(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), (Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR), object.readLong());
                break;
            }
            case 26: {
                this.onActivityStopped(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readLong());
                break;
            }
            case 25: {
                this.onActivityStarted(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readLong());
                break;
            }
            case 24: {
                this.endAdUnitExposure(object.readString(), object.readLong());
                break;
            }
            case 23: {
                this.beginAdUnitExposure(object.readString(), object.readLong());
                break;
            }
            case 22: {
                object = object.readStrongBinder();
                object = object == null ? var19_11 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.generateEventId((zzt)object);
                break;
            }
            case 21: {
                object = object.readStrongBinder();
                object = object == null ? var14_12 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getGmpAppId((zzt)object);
                break;
            }
            case 20: {
                object = object.readStrongBinder();
                object = object == null ? var20_13 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getAppInstanceId((zzt)object);
                break;
            }
            case 19: {
                object = object.readStrongBinder();
                object = object == null ? var21_14 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getCachedAppInstanceId((zzt)object);
                break;
            }
            case 18: {
                object = object.readStrongBinder();
                object = object == null ? var11_15 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider")) instanceof zzy ? (zzy)object2 : new zzx((IBinder)object));
                this.setInstanceIdProvider((zzy)object);
                break;
            }
            case 17: {
                object = object.readStrongBinder();
                object = object == null ? var13_16 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getCurrentScreenClass((zzt)object);
                break;
            }
            case 16: {
                object = object.readStrongBinder();
                object = object == null ? var22_17 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getCurrentScreenName((zzt)object);
                break;
            }
            case 15: {
                this.setCurrentScreen(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), object.readString(), object.readString(), object.readLong());
                break;
            }
            case 14: {
                this.setSessionTimeoutDuration(object.readLong());
                break;
            }
            case 13: {
                this.setMinimumSessionDuration(object.readLong());
                break;
            }
            case 12: {
                this.resetAnalyticsData(object.readLong());
                break;
            }
            case 11: {
                this.setMeasurementEnabled(zzc.zza((Parcel)object), object.readLong());
                break;
            }
            case 10: {
                object2 = object.readString();
                string = object.readString();
                object = object.readStrongBinder();
                object = object == null ? string2 : ((string2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)string2 : new zzr((IBinder)object));
                this.getConditionalUserProperties((String)object2, string, (zzt)object);
                break;
            }
            case 9: {
                this.clearConditionalUserProperty(object.readString(), object.readString(), (Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR));
                break;
            }
            case 8: {
                this.setConditionalUserProperty((Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR), object.readLong());
                break;
            }
            case 7: {
                this.setUserId(object.readString(), object.readLong());
                break;
            }
            case 6: {
                object2 = object.readString();
                object = object.readStrongBinder();
                object = object == null ? iBinder : ((string2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)string2 : new zzr((IBinder)object));
                this.getMaxUserProperties((String)object2, (zzt)object);
                break;
            }
            case 5: {
                string = object.readString();
                string2 = object.readString();
                boolean bl = zzc.zza((Parcel)object);
                object = object.readStrongBinder();
                object = object == null ? object2 : ((object2 = object.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr((IBinder)object));
                this.getUserProperties(string, string2, bl, (zzt)object);
                break;
            }
            case 4: {
                this.setUserProperty(object.readString(), object.readString(), IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), zzc.zza((Parcel)object), object.readLong());
                break;
            }
            case 3: {
                string2 = object.readString();
                string = object.readString();
                bundle = (Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR);
                iBinder = object.readStrongBinder();
                object2 = iBinder == null ? null : ((object2 = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver")) instanceof zzt ? (zzt)object2 : new zzr(iBinder));
                this.logEventAndBundle(string2, string, bundle, (zzt)object2, object.readLong());
                break;
            }
            case 2: {
                this.logEvent(object.readString(), object.readString(), (Bundle)zzc.zzc((Parcel)object, (Parcelable.Creator)Bundle.CREATOR), zzc.zza((Parcel)object), zzc.zza((Parcel)object), object.readLong());
                break;
            }
            case 1: {
                this.initialize(IObjectWrapper.Stub.asInterface((IBinder)object.readStrongBinder()), (zzz)zzc.zzc((Parcel)object, (Parcelable.Creator)zzz.CREATOR), object.readLong());
            }
        }
        parcel.writeNoException();
        return true;
    }
}
