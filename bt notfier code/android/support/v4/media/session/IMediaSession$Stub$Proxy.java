/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.IMediaControllerCallback
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.MediaSessionCompat$QueueItem
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  android.support.v4.media.session.PlaybackStateCompat
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

private static class IMediaSession.Stub.Proxy
implements IMediaSession {
    private IBinder mRemote;

    IMediaSession.Stub.Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                parcel.writeInt(1);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(41, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                parcel.writeInt(1);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(n);
            this.mRemote.transact(42, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void adjustVolume(int n, int n2, String string) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeInt(n);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.mRemote.transact(11, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void fastForward() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(22, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public Bundle getExtras() throws RemoteException {
        Bundle bundle;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(31, parcel, parcel2, 0);
            parcel2.readException();
            bundle = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return bundle;
    }

    public long getFlags() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            long l = parcel2.readLong();
            return l;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaSession";
    }

    public PendingIntent getLaunchPendingIntent() throws RemoteException {
        PendingIntent pendingIntent;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            pendingIntent = parcel2.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return pendingIntent;
    }

    public MediaMetadataCompat getMetadata() throws RemoteException {
        MediaMetadataCompat mediaMetadataCompat;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(27, parcel, parcel2, 0);
            parcel2.readException();
            mediaMetadataCompat = parcel2.readInt() != 0 ? (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return mediaMetadataCompat;
    }

    public String getPackageName() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public PlaybackStateCompat getPlaybackState() throws RemoteException {
        PlaybackStateCompat playbackStateCompat;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(28, parcel, parcel2, 0);
            parcel2.readException();
            playbackStateCompat = parcel2.readInt() != 0 ? (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return playbackStateCompat;
    }

    public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(29, parcel, parcel2, 0);
            parcel2.readException();
            ArrayList arrayList = parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
            return arrayList;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public CharSequence getQueueTitle() throws RemoteException {
        CharSequence charSequence;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(30, parcel, parcel2, 0);
            parcel2.readException();
            charSequence = parcel2.readInt() != 0 ? (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return charSequence;
    }

    public int getRatingType() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(32, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            return n;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public int getRepeatMode() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(37, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            return n;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public int getShuffleMode() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(47, parcel, parcel2, 0);
            parcel2.readException();
            int n = parcel2.readInt();
            return n;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String getTag() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            String string = parcel2.readString();
            return string;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
        ParcelableVolumeInfo parcelableVolumeInfo;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(10, parcel, parcel2, 0);
            parcel2.readException();
            parcelableVolumeInfo = parcel2.readInt() != 0 ? (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2) : null;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
        return parcelableVolumeInfo;
    }

    public boolean isCaptioningEnabled() throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            IBinder iBinder = this.mRemote;
            bl = false;
            iBinder.transact(45, parcel, parcel2, 0);
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

    public boolean isShuffleModeEnabledRemoved() throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            IBinder iBinder = this.mRemote;
            bl = false;
            iBinder.transact(38, parcel, parcel2, 0);
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

    public boolean isTransportControlEnabled() throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            IBinder iBinder = this.mRemote;
            bl = false;
            iBinder.transact(5, parcel, parcel2, 0);
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

    public void next() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(20, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void pause() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(18, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void play() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(13, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void playFromMediaId(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(14, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void playFromSearch(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(15, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
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
            this.mRemote.transact(16, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void prepare() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(33, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void prepareFromMediaId(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(34, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void prepareFromSearch(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(35, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
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
            this.mRemote.transact(36, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void previous() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(21, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void rate(RatingCompat ratingCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (ratingCompat != null) {
                parcel.writeInt(1);
                ratingCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(25, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (ratingCompat != null) {
                parcel.writeInt(1);
                ratingCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(51, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void registerCallbackListener(IMediaControllerCallback object) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            this.mRemote.transact(3, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            if (mediaDescriptionCompat != null) {
                parcel.writeInt(1);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(43, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void removeQueueItemAt(int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeInt(n);
            this.mRemote.transact(44, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void rewind() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(23, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void seekTo(long l) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeLong(l);
            this.mRemote.transact(24, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void sendCommand(String string, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (resultReceiverWrapper != null) {
                parcel.writeInt(1);
                resultReceiverWrapper.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void sendCustomAction(String string, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeString(string);
            if (bundle != null) {
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(26, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException {
        boolean bl;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            bl = true;
            if (keyEvent != null) {
                parcel.writeInt(1);
                keyEvent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.mRemote.transact(2, parcel, parcel2, 0);
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

    public void setCaptioningEnabled(boolean bl) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            int n = bl ? 1 : 0;
            parcel.writeInt(n);
            this.mRemote.transact(46, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setRepeatMode(int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeInt(n);
            this.mRemote.transact(39, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setShuffleMode(int n) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeInt(n);
            this.mRemote.transact(48, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setShuffleModeEnabledRemoved(boolean bl) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            int n = bl ? 1 : 0;
            parcel.writeInt(n);
            this.mRemote.transact(40, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setVolumeTo(int n, int n2, String string) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeInt(n);
            parcel.writeInt(n2);
            parcel.writeString(string);
            this.mRemote.transact(12, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void skipToQueueItem(long l) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            parcel.writeLong(l);
            this.mRemote.transact(17, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void stop() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            this.mRemote.transact(19, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void unregisterCallbackListener(IMediaControllerCallback object) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
            object = object != null ? object.asBinder() : null;
            parcel.writeStrongBinder((IBinder)object);
            this.mRemote.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}
