/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.SystemClock
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.PlaybackStateCompat$CustomAction
 *  android.support.v4.media.session.PlaybackStateCompatApi21
 *  android.support.v4.media.session.PlaybackStateCompatApi22
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.support.v4.media.session.PlaybackStateCompatApi22;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PlaybackStateCompat
implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64L;
    public static final long ACTION_PAUSE = 2L;
    public static final long ACTION_PLAY = 4L;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
    public static final long ACTION_PLAY_FROM_URI = 8192L;
    public static final long ACTION_PLAY_PAUSE = 512L;
    public static final long ACTION_PREPARE = 16384L;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768L;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536L;
    public static final long ACTION_PREPARE_FROM_URI = 131072L;
    public static final long ACTION_REWIND = 8L;
    public static final long ACTION_SEEK_TO = 256L;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 0x100000L;
    public static final long ACTION_SET_RATING = 128L;
    public static final long ACTION_SET_REPEAT_MODE = 262144L;
    public static final long ACTION_SET_SHUFFLE_MODE = 0x200000L;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288L;
    public static final long ACTION_SKIP_TO_NEXT = 32L;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
    public static final long ACTION_STOP = 1L;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    PlaybackStateCompat(int n, long l, long l2, float f, long l3, int n2, CharSequence charSequence, long l4, List<CustomAction> list, long l5, Bundle bundle) {
        this.mState = n;
        this.mPosition = l;
        this.mBufferedPosition = l2;
        this.mSpeed = f;
        this.mActions = l3;
        this.mErrorCode = n2;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = l4;
        this.mCustomActions = new ArrayList<CustomAction>(list);
        this.mActiveItemId = l5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = parcel.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(Object object) {
        ArrayList<CustomAction> arrayList = null;
        Bundle bundle = null;
        Object object2 = arrayList;
        if (object == null) return object2;
        object2 = arrayList;
        if (Build.VERSION.SDK_INT < 21) return object2;
        arrayList = PlaybackStateCompatApi21.getCustomActions((Object)object);
        if (arrayList != null) {
            object2 = new ArrayList<CustomAction>(arrayList.size());
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                object2.add(CustomAction.fromCustomAction(arrayList.next()));
            }
        } else {
            object2 = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = PlaybackStateCompatApi22.getExtras((Object)object);
        }
        object2 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState((Object)object), PlaybackStateCompatApi21.getPosition((Object)object), PlaybackStateCompatApi21.getBufferedPosition((Object)object), PlaybackStateCompatApi21.getPlaybackSpeed((Object)object), PlaybackStateCompatApi21.getActions((Object)object), 0, PlaybackStateCompatApi21.getErrorMessage((Object)object), PlaybackStateCompatApi21.getLastPositionUpdateTime((Object)object), (List<CustomAction>)object2, PlaybackStateCompatApi21.getActiveQueueItemId((Object)object), bundle);
        ((PlaybackStateCompat)object2).mStateObj = object;
        return object2;
    }

    public static int toKeyCode(long l) {
        if (l == 4L) {
            return 126;
        }
        if (l == 2L) {
            return 127;
        }
        if (l == 32L) {
            return 87;
        }
        if (l == 16L) {
            return 88;
        }
        if (l == 1L) {
            return 86;
        }
        if (l == 64L) {
            return 90;
        }
        if (l == 8L) {
            return 89;
        }
        if (l != 512L) return 0;
        return 85;
    }

    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public long getCurrentPosition(Long l) {
        long l2 = this.mPosition;
        float f = this.mSpeed;
        long l3 = l != null ? l : SystemClock.elapsedRealtime() - this.mUpdateTime;
        return Math.max(0L, l2 + (long)(f * (float)l3));
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        if (this.mStateObj != null) return this.mStateObj;
        if (Build.VERSION.SDK_INT < 21) return this.mStateObj;
        ArrayList<Object> arrayList = null;
        if (this.mCustomActions != null) {
            ArrayList<Object> arrayList2 = new ArrayList<Object>(this.mCustomActions.size());
            Iterator<CustomAction> iterator = this.mCustomActions.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!iterator.hasNext()) break;
                arrayList2.add(iterator.next().getCustomAction());
            }
        }
        this.mStateObj = Build.VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.newInstance((int)this.mState, (long)this.mPosition, (long)this.mBufferedPosition, (float)this.mSpeed, (long)this.mActions, (CharSequence)this.mErrorMessage, (long)this.mUpdateTime, arrayList, (long)this.mActiveItemId, (Bundle)this.mExtras) : PlaybackStateCompatApi21.newInstance((int)this.mState, (long)this.mPosition, (long)this.mBufferedPosition, (float)this.mSpeed, (long)this.mActions, (CharSequence)this.mErrorMessage, (long)this.mUpdateTime, arrayList, (long)this.mActiveItemId);
        return this.mStateObj;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=");
        stringBuilder.append(this.mState);
        stringBuilder.append(", position=");
        stringBuilder.append(this.mPosition);
        stringBuilder.append(", buffered position=");
        stringBuilder.append(this.mBufferedPosition);
        stringBuilder.append(", speed=");
        stringBuilder.append(this.mSpeed);
        stringBuilder.append(", updated=");
        stringBuilder.append(this.mUpdateTime);
        stringBuilder.append(", actions=");
        stringBuilder.append(this.mActions);
        stringBuilder.append(", error code=");
        stringBuilder.append(this.mErrorCode);
        stringBuilder.append(", error message=");
        stringBuilder.append(this.mErrorMessage);
        stringBuilder.append(", custom actions=");
        stringBuilder.append(this.mCustomActions);
        stringBuilder.append(", active item id=");
        stringBuilder.append(this.mActiveItemId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        TextUtils.writeToParcel((CharSequence)this.mErrorMessage, (Parcel)parcel, (int)n);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }
}
