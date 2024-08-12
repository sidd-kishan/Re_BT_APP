/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.PlaybackStateCompat$CustomAction
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;

static final class PlaybackStateCompat.CustomAction.1
implements Parcelable.Creator<PlaybackStateCompat.CustomAction> {
    PlaybackStateCompat.CustomAction.1() {
    }

    public PlaybackStateCompat.CustomAction createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat.CustomAction(parcel);
    }

    public PlaybackStateCompat.CustomAction[] newArray(int n) {
        return new PlaybackStateCompat.CustomAction[n];
    }
}
