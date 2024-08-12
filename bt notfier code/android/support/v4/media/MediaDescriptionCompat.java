/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaDescriptionCompat$Builder
 *  android.support.v4.media.MediaDescriptionCompatApi21
 *  android.support.v4.media.MediaDescriptionCompatApi21$Builder
 *  android.support.v4.media.MediaDescriptionCompatApi23
 *  android.support.v4.media.MediaDescriptionCompatApi23$Builder
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.text.TextUtils
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat
implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2L;
    public static final long STATUS_DOWNLOADING = 1L;
    public static final long STATUS_NOT_DOWNLOADED = 0L;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    MediaDescriptionCompat(Parcel parcel) {
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.mIcon = (Bitmap)parcel.readParcelable(classLoader);
        this.mIconUri = (Uri)parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri)parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String string, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.mMediaId = string;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object object) {
        Builder builder;
        Object object2;
        Bundle bundle;
        block9: {
            Bundle bundle2;
            block8: {
                bundle2 = null;
                bundle = null;
                object2 = bundle2;
                if (object == null) return object2;
                object2 = bundle2;
                if (Build.VERSION.SDK_INT < 21) return object2;
                builder = new Builder();
                builder.setMediaId(MediaDescriptionCompatApi21.getMediaId((Object)object));
                builder.setTitle(MediaDescriptionCompatApi21.getTitle((Object)object));
                builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle((Object)object));
                builder.setDescription(MediaDescriptionCompatApi21.getDescription((Object)object));
                builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap((Object)object));
                builder.setIconUri(MediaDescriptionCompatApi21.getIconUri((Object)object));
                bundle2 = MediaDescriptionCompatApi21.getExtras((Object)object);
                if (bundle2 != null) {
                    MediaSessionCompat.ensureClassLoader((Bundle)bundle2);
                    object2 = (Uri)bundle2.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
                } else {
                    object2 = null;
                }
                if (object2 == null) break block8;
                if (bundle2.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) && bundle2.size() == 2) break block9;
                bundle2.remove(DESCRIPTION_KEY_MEDIA_URI);
                bundle2.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
            }
            bundle = bundle2;
        }
        builder.setExtras(bundle);
        if (object2 != null) {
            builder.setMediaUri((Uri)object2);
        } else if (Build.VERSION.SDK_INT >= 23) {
            builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri((Object)object));
        }
        object2 = builder.build();
        object2.mDescriptionObj = object;
        return object2;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Bundle bundle;
        if (this.mDescriptionObj != null) return this.mDescriptionObj;
        if (Build.VERSION.SDK_INT < 21) {
            return this.mDescriptionObj;
        }
        Object object = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId((Object)object, (String)this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle((Object)object, (CharSequence)this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle((Object)object, (CharSequence)this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription((Object)object, (CharSequence)this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap((Object)object, (Bitmap)this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri((Object)object, (Uri)this.mIconUri);
        Object object2 = bundle = this.mExtras;
        if (Build.VERSION.SDK_INT < 23) {
            object2 = bundle;
            if (this.mMediaUri != null) {
                object2 = bundle;
                if (bundle == null) {
                    object2 = new Bundle();
                    object2.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                }
                object2.putParcelable(DESCRIPTION_KEY_MEDIA_URI, (Parcelable)this.mMediaUri);
            }
        }
        MediaDescriptionCompatApi21.Builder.setExtras((Object)object, (Bundle)object2);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri((Object)object, (Uri)this.mMediaUri);
        }
        object2 = MediaDescriptionCompatApi21.Builder.build((Object)object);
        this.mDescriptionObj = object2;
        return object2;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.mTitle);
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.mSubtitle);
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.mDescription);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.mMediaId);
            TextUtils.writeToParcel((CharSequence)this.mTitle, (Parcel)parcel, (int)n);
            TextUtils.writeToParcel((CharSequence)this.mSubtitle, (Parcel)parcel, (int)n);
            TextUtils.writeToParcel((CharSequence)this.mDescription, (Parcel)parcel, (int)n);
            parcel.writeParcelable((Parcelable)this.mIcon, n);
            parcel.writeParcelable((Parcelable)this.mIconUri, n);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable((Parcelable)this.mMediaUri, n);
        } else {
            MediaDescriptionCompatApi21.writeToParcel((Object)this.getMediaDescription(), (Parcel)parcel, (int)n);
        }
    }
}
