/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

private static class IMediaControllerCallback.Stub.Proxy
implements IMediaControllerCallback {
    private IBinder mRemote;

    IMediaControllerCallback.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaControllerCallback";
    }

    public void onCaptioningEnabledChanged(boolean bl) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            int n = bl ? 1 : 0;
            parcel.writeInt(n);
            this.mRemote.transact(11, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onEvent(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(1, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(7, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (mediaMetadataCompat != null) {
                parcel.writeInt(1);
                mediaMetadataCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(4, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (playbackStateCompat != null) {
                parcel.writeInt(1);
                playbackStateCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(3, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeTypedList(list);
            this.mRemote.transact(5, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (charSequence != null) {
                parcel.writeInt(1);
                TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)parcel, (int)0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(6, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onRepeatModeChanged(int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeInt(n);
            this.mRemote.transact(9, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onSessionDestroyed() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            this.mRemote.transact(2, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onSessionReady() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            this.mRemote.transact(13, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onShuffleModeChanged(int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeInt(n);
            this.mRemote.transact(12, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onShuffleModeChangedRemoved(boolean bl) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            int n = bl ? 1 : 0;
            parcel.writeInt(n);
            this.mRemote.transact(10, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (parcelableVolumeInfo != null) {
                parcel.writeInt(1);
                parcelableVolumeInfo.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(8, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}
