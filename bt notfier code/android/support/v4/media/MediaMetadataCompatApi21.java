/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaMetadata
 *  android.os.Parcel
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Parcel;
import java.util.Set;

class MediaMetadataCompatApi21 {
    private MediaMetadataCompatApi21() {
    }

    public static Object createFromParcel(Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }

    public static Bitmap getBitmap(Object object, String string) {
        return ((MediaMetadata)object).getBitmap(string);
    }

    public static long getLong(Object object, String string) {
        return ((MediaMetadata)object).getLong(string);
    }

    public static Object getRating(Object object, String string) {
        return ((MediaMetadata)object).getRating(string);
    }

    public static CharSequence getText(Object object, String string) {
        return ((MediaMetadata)object).getText(string);
    }

    public static Set<String> keySet(Object object) {
        return ((MediaMetadata)object).keySet();
    }

    public static void writeToParcel(Object object, Parcel parcel, int n) {
        ((MediaMetadata)object).writeToParcel(parcel, n);
    }
}
