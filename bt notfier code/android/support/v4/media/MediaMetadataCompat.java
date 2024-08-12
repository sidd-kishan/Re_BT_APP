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
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.MediaDescriptionCompat$Builder
 *  android.support.v4.media.MediaMetadataCompatApi21
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.collection.ArrayMap
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompatApi21;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.Set;

public final class MediaMetadataCompat
implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    static {
        Object object;
        METADATA_KEYS_TYPE = object = new ArrayMap();
        Integer n = 1;
        object.put((Object)METADATA_KEY_TITLE, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ARTIST, (Object)n);
        Object object2 = METADATA_KEYS_TYPE;
        object = 0;
        object2.put((Object)METADATA_KEY_DURATION, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ALBUM, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_AUTHOR, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_WRITER, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_COMPOSER, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_COMPILATION, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DATE, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_YEAR, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_GENRE, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_TRACK_NUMBER, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_NUM_TRACKS, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISC_NUMBER, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ALBUM_ARTIST, (Object)n);
        ArrayMap<String, Integer> arrayMap = METADATA_KEYS_TYPE;
        object2 = 2;
        arrayMap.put((Object)METADATA_KEY_ART, object2);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ART_URI, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ALBUM_ART, object2);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ALBUM_ART_URI, (Object)n);
        arrayMap = METADATA_KEYS_TYPE;
        Integer n2 = 3;
        arrayMap.put((Object)METADATA_KEY_USER_RATING, (Object)n2);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_RATING, (Object)n2);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISPLAY_TITLE, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISPLAY_SUBTITLE, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISPLAY_DESCRIPTION, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISPLAY_ICON, object2);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DISPLAY_ICON_URI, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_MEDIA_ID, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_BT_FOLDER_TYPE, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_MEDIA_URI, (Object)n);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_ADVERTISEMENT, object);
        METADATA_KEYS_TYPE.put((Object)METADATA_KEY_DOWNLOAD_STATUS, object);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    }

    MediaMetadataCompat(Bundle bundle) {
        this.mBundle = bundle = new Bundle(bundle);
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat fromMediaMetadata(Object object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) return null;
        Parcel parcel = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel((Object)object, (Parcel)parcel, (int)0);
        parcel.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(parcel);
        parcel.recycle();
        mediaMetadataCompat.mMetadataObj = object;
        return mediaMetadataCompat;
    }

    public boolean containsKey(String string) {
        return this.mBundle.containsKey(string);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap(String string) {
        try {
            string = (Bitmap)this.mBundle.getParcelable(string);
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Failed to retrieve a key as Bitmap.", (Throwable)exception);
            string = null;
        }
        return string;
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public MediaDescriptionCompat getDescription() {
        Uri uri;
        Uri uri2;
        CharSequence[] charSequenceArray;
        String string;
        Object object;
        block13: {
            int n;
            block12: {
                int n2;
                object = this.mDescription;
                if (object != null) {
                    return object;
                }
                string = this.getString(METADATA_KEY_MEDIA_ID);
                charSequenceArray = new CharSequence[3];
                object = this.getText(METADATA_KEY_DISPLAY_TITLE);
                if (!TextUtils.isEmpty((CharSequence)object)) {
                    charSequenceArray[0] = object;
                    charSequenceArray[1] = this.getText(METADATA_KEY_DISPLAY_SUBTITLE);
                    charSequenceArray[2] = this.getText(METADATA_KEY_DISPLAY_DESCRIPTION);
                } else {
                    n2 = 0;
                    for (n = 0; n2 < 3 && n < ((String[])(object = PREFERRED_DESCRIPTION_ORDER)).length; ++n) {
                        object = this.getText(object[n]);
                        int n3 = n2;
                        if (!TextUtils.isEmpty((CharSequence)object)) {
                            charSequenceArray[n2] = object;
                            n3 = n2 + 1;
                        }
                        n2 = n3;
                    }
                }
                n = 0;
                while (true) {
                    object = PREFERRED_BITMAP_ORDER;
                    n2 = ((String[])object).length;
                    uri2 = null;
                    if (n >= n2) break;
                    if ((object = this.getBitmap(object[n])) == null) {
                        ++n;
                        continue;
                    }
                    break block12;
                    break;
                }
                object = null;
            }
            for (n = 0; n < ((String[])(uri = PREFERRED_URI_ORDER)).length; ++n) {
                if (TextUtils.isEmpty((CharSequence)(uri = this.getString(uri[n])))) continue;
                uri = Uri.parse((String)uri);
                break block13;
            }
            uri = null;
        }
        String string2 = this.getString(METADATA_KEY_MEDIA_URI);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            uri2 = Uri.parse((String)string2);
        }
        string2 = new MediaDescriptionCompat.Builder();
        string2.setMediaId(string);
        string2.setTitle(charSequenceArray[0]);
        string2.setSubtitle(charSequenceArray[1]);
        string2.setDescription(charSequenceArray[2]);
        string2.setIconBitmap(object);
        string2.setIconUri(uri);
        string2.setMediaUri(uri2);
        object = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            object.putLong("android.media.extra.BT_FOLDER_TYPE", this.getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            object.putLong("android.media.extra.DOWNLOAD_STATUS", this.getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!object.isEmpty()) {
            string2.setExtras((Bundle)object);
        }
        object = string2.build();
        this.mDescription = object;
        return object;
    }

    public long getLong(String string) {
        return this.mBundle.getLong(string, 0L);
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null) return this.mMetadataObj;
        if (Build.VERSION.SDK_INT < 21) return this.mMetadataObj;
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel((Parcel)parcel);
        parcel.recycle();
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String string) {
        try {
            string = Build.VERSION.SDK_INT >= 19 ? RatingCompat.fromRating((Object)this.mBundle.getParcelable(string)) : (RatingCompat)this.mBundle.getParcelable(string);
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Failed to retrieve a key as Rating.", (Throwable)exception);
            string = null;
        }
        return string;
    }

    public String getString(String charSequence) {
        if ((charSequence = this.mBundle.getCharSequence((String)charSequence)) == null) return null;
        return charSequence.toString();
    }

    public CharSequence getText(String string) {
        return this.mBundle.getCharSequence(string);
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeBundle(this.mBundle);
    }
}
