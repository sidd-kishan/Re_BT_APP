/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaDescription
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcel
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class MediaDescriptionCompatApi21 {
    private MediaDescriptionCompatApi21() {
    }

    public static Object fromParcel(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static CharSequence getDescription(Object object) {
        return ((MediaDescription)object).getDescription();
    }

    public static Bundle getExtras(Object object) {
        return ((MediaDescription)object).getExtras();
    }

    public static Bitmap getIconBitmap(Object object) {
        return ((MediaDescription)object).getIconBitmap();
    }

    public static Uri getIconUri(Object object) {
        return ((MediaDescription)object).getIconUri();
    }

    public static String getMediaId(Object object) {
        return ((MediaDescription)object).getMediaId();
    }

    public static CharSequence getSubtitle(Object object) {
        return ((MediaDescription)object).getSubtitle();
    }

    public static CharSequence getTitle(Object object) {
        return ((MediaDescription)object).getTitle();
    }

    public static void writeToParcel(Object object, Parcel parcel, int n) {
        ((MediaDescription)object).writeToParcel(parcel, n);
    }
}
