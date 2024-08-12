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
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.IMediaControllerCallback$Stub
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.IMediaSession$Stub$Proxy
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public static abstract class IMediaSession.Stub
extends Binder
implements IMediaSession {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
    static final int TRANSACTION_addQueueItem = 41;
    static final int TRANSACTION_addQueueItemAt = 42;
    static final int TRANSACTION_adjustVolume = 11;
    static final int TRANSACTION_fastForward = 22;
    static final int TRANSACTION_getExtras = 31;
    static final int TRANSACTION_getFlags = 9;
    static final int TRANSACTION_getLaunchPendingIntent = 8;
    static final int TRANSACTION_getMetadata = 27;
    static final int TRANSACTION_getPackageName = 6;
    static final int TRANSACTION_getPlaybackState = 28;
    static final int TRANSACTION_getQueue = 29;
    static final int TRANSACTION_getQueueTitle = 30;
    static final int TRANSACTION_getRatingType = 32;
    static final int TRANSACTION_getRepeatMode = 37;
    static final int TRANSACTION_getShuffleMode = 47;
    static final int TRANSACTION_getTag = 7;
    static final int TRANSACTION_getVolumeAttributes = 10;
    static final int TRANSACTION_isCaptioningEnabled = 45;
    static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
    static final int TRANSACTION_isTransportControlEnabled = 5;
    static final int TRANSACTION_next = 20;
    static final int TRANSACTION_pause = 18;
    static final int TRANSACTION_play = 13;
    static final int TRANSACTION_playFromMediaId = 14;
    static final int TRANSACTION_playFromSearch = 15;
    static final int TRANSACTION_playFromUri = 16;
    static final int TRANSACTION_prepare = 33;
    static final int TRANSACTION_prepareFromMediaId = 34;
    static final int TRANSACTION_prepareFromSearch = 35;
    static final int TRANSACTION_prepareFromUri = 36;
    static final int TRANSACTION_previous = 21;
    static final int TRANSACTION_rate = 25;
    static final int TRANSACTION_rateWithExtras = 51;
    static final int TRANSACTION_registerCallbackListener = 3;
    static final int TRANSACTION_removeQueueItem = 43;
    static final int TRANSACTION_removeQueueItemAt = 44;
    static final int TRANSACTION_rewind = 23;
    static final int TRANSACTION_seekTo = 24;
    static final int TRANSACTION_sendCommand = 1;
    static final int TRANSACTION_sendCustomAction = 26;
    static final int TRANSACTION_sendMediaButton = 2;
    static final int TRANSACTION_setCaptioningEnabled = 46;
    static final int TRANSACTION_setRepeatMode = 39;
    static final int TRANSACTION_setShuffleMode = 48;
    static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
    static final int TRANSACTION_setVolumeTo = 12;
    static final int TRANSACTION_skipToQueueItem = 17;
    static final int TRANSACTION_stop = 19;
    static final int TRANSACTION_unregisterCallbackListener = 4;

    public IMediaSession.Stub() {
        this.attachInterface((IInterface)this, DESCRIPTOR);
    }

    public static IMediaSession asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface == null) return new Proxy(iBinder);
        if (!(iInterface instanceof IMediaSession)) return new Proxy(iBinder);
        return (IMediaSession)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        Object var22_5 = null;
        Object var18_6 = null;
        Object var12_7 = null;
        Object var14_8 = null;
        Object var15_9 = null;
        Object var16_10 = null;
        Object var19_11 = null;
        Object var13_12 = null;
        Object object2 = null;
        Object var17_14 = null;
        Object var21_15 = null;
        String string = null;
        String string2 = null;
        Object var20_18 = null;
        if (n != 51) {
            if (n == 1598968902) {
                parcel.writeString(DESCRIPTOR);
                return true;
            }
            boolean bl = false;
            boolean bl2 = false;
            switch (n) {
                default: {
                    return super.onTransact(n, object, parcel, n2);
                }
                case 48: {
                    object.enforceInterface(DESCRIPTOR);
                    this.setShuffleMode(object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 47: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.getShuffleMode();
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 46: {
                    object.enforceInterface(DESCRIPTOR);
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.setCaptioningEnabled(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 45: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.isCaptioningEnabled() ? 1 : 0;
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 44: {
                    object.enforceInterface(DESCRIPTOR);
                    this.removeQueueItemAt(object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 43: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = var20_18;
                    if (object.readInt() != 0) {
                        object2 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(object);
                    }
                    this.removeQueueItem((MediaDescriptionCompat)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 42: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = var22_5;
                    if (object.readInt() != 0) {
                        object2 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(object);
                    }
                    this.addQueueItemAt((MediaDescriptionCompat)object2, object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 41: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = var18_6;
                    if (object.readInt() != 0) {
                        object2 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(object);
                    }
                    this.addQueueItem((MediaDescriptionCompat)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 40: {
                    object.enforceInterface(DESCRIPTOR);
                    bl2 = bl;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.setShuffleModeEnabledRemoved(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 39: {
                    object.enforceInterface(DESCRIPTOR);
                    this.setRepeatMode(object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 38: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.isShuffleModeEnabledRemoved() ? 1 : 0;
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 37: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.getRepeatMode();
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 36: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = object.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(object) : null;
                    string = var12_7;
                    if (object.readInt() != 0) {
                        string = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.prepareFromUri((Uri)object2, (Bundle)string);
                    parcel.writeNoException();
                    return true;
                }
                case 35: {
                    object.enforceInterface(DESCRIPTOR);
                    string = object.readString();
                    object2 = var14_8;
                    if (object.readInt() != 0) {
                        object2 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.prepareFromSearch(string, (Bundle)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 34: {
                    object.enforceInterface(DESCRIPTOR);
                    string = object.readString();
                    object2 = var15_9;
                    if (object.readInt() != 0) {
                        object2 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.prepareFromMediaId(string, (Bundle)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 33: {
                    object.enforceInterface(DESCRIPTOR);
                    this.prepare();
                    parcel.writeNoException();
                    return true;
                }
                case 32: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.getRatingType();
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 31: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getExtras();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 30: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getQueueTitle();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        TextUtils.writeToParcel((CharSequence)object, (Parcel)parcel, (int)1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 29: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getQueue();
                    parcel.writeNoException();
                    parcel.writeTypedList((List)object);
                    return true;
                }
                case 28: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getPlaybackState();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 27: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getMetadata();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 26: {
                    object.enforceInterface(DESCRIPTOR);
                    string = object.readString();
                    object2 = var16_10;
                    if (object.readInt() != 0) {
                        object2 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.sendCustomAction(string, (Bundle)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 25: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = var19_11;
                    if (object.readInt() != 0) {
                        object2 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(object);
                    }
                    this.rate((RatingCompat)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 24: {
                    object.enforceInterface(DESCRIPTOR);
                    this.seekTo(object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 23: {
                    object.enforceInterface(DESCRIPTOR);
                    this.rewind();
                    parcel.writeNoException();
                    return true;
                }
                case 22: {
                    object.enforceInterface(DESCRIPTOR);
                    this.fastForward();
                    parcel.writeNoException();
                    return true;
                }
                case 21: {
                    object.enforceInterface(DESCRIPTOR);
                    this.previous();
                    parcel.writeNoException();
                    return true;
                }
                case 20: {
                    object.enforceInterface(DESCRIPTOR);
                    this.next();
                    parcel.writeNoException();
                    return true;
                }
                case 19: {
                    object.enforceInterface(DESCRIPTOR);
                    this.stop();
                    parcel.writeNoException();
                    return true;
                }
                case 18: {
                    object.enforceInterface(DESCRIPTOR);
                    this.pause();
                    parcel.writeNoException();
                    return true;
                }
                case 17: {
                    object.enforceInterface(DESCRIPTOR);
                    this.skipToQueueItem(object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 16: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = object.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(object) : null;
                    string = var13_12;
                    if (object.readInt() != 0) {
                        string = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.playFromUri((Uri)object2, (Bundle)string);
                    parcel.writeNoException();
                    return true;
                }
                case 15: {
                    object.enforceInterface(DESCRIPTOR);
                    string = object.readString();
                    if (object.readInt() != 0) {
                        object2 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.playFromSearch(string, (Bundle)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 14: {
                    object.enforceInterface(DESCRIPTOR);
                    string = object.readString();
                    object2 = var17_14;
                    if (object.readInt() != 0) {
                        object2 = (Bundle)Bundle.CREATOR.createFromParcel(object);
                    }
                    this.playFromMediaId(string, (Bundle)object2);
                    parcel.writeNoException();
                    return true;
                }
                case 13: {
                    object.enforceInterface(DESCRIPTOR);
                    this.play();
                    parcel.writeNoException();
                    return true;
                }
                case 12: {
                    object.enforceInterface(DESCRIPTOR);
                    this.setVolumeTo(object.readInt(), object.readInt(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 11: {
                    object.enforceInterface(DESCRIPTOR);
                    this.adjustVolume(object.readInt(), object.readInt(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 10: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getVolumeAttributes();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 9: {
                    object.enforceInterface(DESCRIPTOR);
                    long l = this.getFlags();
                    parcel.writeNoException();
                    parcel.writeLong(l);
                    return true;
                }
                case 8: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getLaunchPendingIntent();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                    } else {
                        parcel.writeInt(0);
                    }
                    return true;
                }
                case 7: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getTag();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 6: {
                    object.enforceInterface(DESCRIPTOR);
                    object = this.getPackageName();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5: {
                    object.enforceInterface(DESCRIPTOR);
                    n = this.isTransportControlEnabled() ? 1 : 0;
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 4: {
                    object.enforceInterface(DESCRIPTOR);
                    this.unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface((IBinder)object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 3: {
                    object.enforceInterface(DESCRIPTOR);
                    this.registerCallbackListener(IMediaControllerCallback.Stub.asInterface((IBinder)object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 2: {
                    object.enforceInterface(DESCRIPTOR);
                    object2 = var21_15;
                    if (object.readInt() != 0) {
                        object2 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(object);
                    }
                    n = this.sendMediaButton((KeyEvent)object2) ? 1 : 0;
                    parcel.writeNoException();
                    parcel.writeInt(n);
                    return true;
                }
                case 1: 
            }
            object.enforceInterface(DESCRIPTOR);
            string2 = object.readString();
            object2 = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            if (object.readInt() != 0) {
                string = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(object);
            }
            this.sendCommand(string2, (Bundle)object2, (MediaSessionCompat.ResultReceiverWrapper)string);
            parcel.writeNoException();
            return true;
        }
        object.enforceInterface(DESCRIPTOR);
        object2 = object.readInt() != 0 ? (RatingCompat)RatingCompat.CREATOR.createFromParcel(object) : null;
        string = string2;
        if (object.readInt() != 0) {
            string = (Bundle)Bundle.CREATOR.createFromParcel(object);
        }
        this.rateWithExtras((RatingCompat)object2, (Bundle)string);
        parcel.writeNoException();
        return true;
    }
}
