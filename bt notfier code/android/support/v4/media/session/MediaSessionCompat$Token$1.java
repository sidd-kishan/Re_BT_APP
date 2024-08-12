/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.MediaSessionCompat$Token
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

static final class MediaSessionCompat.Token.1
implements Parcelable.Creator<MediaSessionCompat.Token> {
    MediaSessionCompat.Token.1() {
    }

    public MediaSessionCompat.Token createFromParcel(Parcel object) {
        object = Build.VERSION.SDK_INT >= 21 ? object.readParcelable(null) : object.readStrongBinder();
        return new MediaSessionCompat.Token(object);
    }

    public MediaSessionCompat.Token[] newArray(int n) {
        return new MediaSessionCompat.Token[n];
    }
}
