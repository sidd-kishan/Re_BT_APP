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
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaControllerCallback$Stub$Proxy
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;

public static abstract class IMediaControllerCallback.Stub
extends Binder
implements IMediaControllerCallback {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    static final int TRANSACTION_onCaptioningEnabledChanged = 11;
    static final int TRANSACTION_onEvent = 1;
    static final int TRANSACTION_onExtrasChanged = 7;
    static final int TRANSACTION_onMetadataChanged = 4;
    static final int TRANSACTION_onPlaybackStateChanged = 3;
    static final int TRANSACTION_onQueueChanged = 5;
    static final int TRANSACTION_onQueueTitleChanged = 6;
    static final int TRANSACTION_onRepeatModeChanged = 9;
    static final int TRANSACTION_onSessionDestroyed = 2;
    static final int TRANSACTION_onSessionReady = 13;
    static final int TRANSACTION_onShuffleModeChanged = 12;
    static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
    static final int TRANSACTION_onVolumeInfoChanged = 8;

    public IMediaControllerCallback.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IMediaControllerCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IMediaControllerCallback)) return new Proxy(iBinder);
        return (IMediaControllerCallback)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel parcel, Parcel object, int n2) throws RemoteException {
        if (n == 1598968902) {
            object.writeString(DESCRIPTOR);
            return true;
        }
        boolean bl = false;
        boolean bl2 = false;
        Object var12_7 = null;
        Object var10_8 = null;
        Object var9_9 = null;
        Object var11_10 = null;
        Object var7_11 = null;
        String string = null;
        switch (n) {
            default: {
                return super.onTransact(n, parcel, object, n2);
            }
            case 13: {
                parcel.enforceInterface(DESCRIPTOR);
                this.onSessionReady();
                return true;
            }
            case 12: {
                parcel.enforceInterface(DESCRIPTOR);
                this.onShuffleModeChanged(parcel.readInt());
                return true;
            }
            case 11: {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    bl2 = true;
                }
                this.onCaptioningEnabledChanged(bl2);
                return true;
            }
            case 10: {
                parcel.enforceInterface(DESCRIPTOR);
                bl2 = bl;
                if (parcel.readInt() != 0) {
                    bl2 = true;
                }
                this.onShuffleModeChangedRemoved(bl2);
                return true;
            }
            case 9: {
                parcel.enforceInterface(DESCRIPTOR);
                this.onRepeatModeChanged(parcel.readInt());
                return true;
            }
            case 8: {
                parcel.enforceInterface(DESCRIPTOR);
                object = string;
                if (parcel.readInt() != 0) {
                    object = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                }
                this.onVolumeInfoChanged((ParcelableVolumeInfo)object);
                return true;
            }
            case 7: {
                parcel.enforceInterface(DESCRIPTOR);
                object = var12_7;
                if (parcel.readInt() != 0) {
                    object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                this.onExtrasChanged((Bundle)object);
                return true;
            }
            case 6: {
                parcel.enforceInterface(DESCRIPTOR);
                object = var10_8;
                if (parcel.readInt() != 0) {
                    object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                }
                this.onQueueTitleChanged((CharSequence)object);
                return true;
            }
            case 5: {
                parcel.enforceInterface(DESCRIPTOR);
                this.onQueueChanged(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                return true;
            }
            case 4: {
                parcel.enforceInterface(DESCRIPTOR);
                object = var9_9;
                if (parcel.readInt() != 0) {
                    object = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                }
                this.onMetadataChanged((MediaMetadataCompat)object);
                return true;
            }
            case 3: {
                parcel.enforceInterface(DESCRIPTOR);
                object = var11_10;
                if (parcel.readInt() != 0) {
                    object = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                }
                this.onPlaybackStateChanged((PlaybackStateCompat)object);
                return true;
            }
            case 2: {
                parcel.enforceInterface(DESCRIPTOR);
                this.onSessionDestroyed();
                return true;
            }
            case 1: 
        }
        parcel.enforceInterface(DESCRIPTOR);
        string = parcel.readString();
        object = var7_11;
        if (parcel.readInt() != 0) {
            object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        }
        this.onEvent(string, (Bundle)object);
        return true;
    }
}
