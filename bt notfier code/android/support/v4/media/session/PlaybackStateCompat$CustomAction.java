/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;

public static final class PlaybackStateCompat.CustomAction
implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat.CustomAction> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private final String mAction;
    private Object mCustomActionObj;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;

    PlaybackStateCompat.CustomAction(Parcel parcel) {
        this.mAction = parcel.readString();
        this.mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mIcon = parcel.readInt();
        this.mExtras = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    PlaybackStateCompat.CustomAction(String string, CharSequence charSequence, int n, Bundle bundle) {
        this.mAction = string;
        this.mName = charSequence;
        this.mIcon = n;
        this.mExtras = bundle;
    }

    public static PlaybackStateCompat.CustomAction fromCustomAction(Object object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackStateCompat.CustomAction customAction = new PlaybackStateCompat.CustomAction(PlaybackStateCompatApi21.CustomAction.getAction((Object)object), PlaybackStateCompatApi21.CustomAction.getName((Object)object), PlaybackStateCompatApi21.CustomAction.getIcon((Object)object), PlaybackStateCompatApi21.CustomAction.getExtras((Object)object));
        customAction.mCustomActionObj = object;
        return customAction;
    }

    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.mAction;
    }

    public Object getCustomAction() {
        Object object;
        if (this.mCustomActionObj != null) return this.mCustomActionObj;
        if (Build.VERSION.SDK_INT < 21) {
            return this.mCustomActionObj;
        }
        this.mCustomActionObj = object = PlaybackStateCompatApi21.CustomAction.newInstance((String)this.mAction, (CharSequence)this.mName, (int)this.mIcon, (Bundle)this.mExtras);
        return object;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Action:mName='");
        stringBuilder.append((Object)this.mName);
        stringBuilder.append(", mIcon=");
        stringBuilder.append(this.mIcon);
        stringBuilder.append(", mExtras=");
        stringBuilder.append(this.mExtras);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.mAction);
        TextUtils.writeToParcel((CharSequence)this.mName, (Parcel)parcel, (int)n);
        parcel.writeInt(this.mIcon);
        parcel.writeBundle(this.mExtras);
    }
}
