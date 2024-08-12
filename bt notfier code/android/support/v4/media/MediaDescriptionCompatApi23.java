/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription
 *  android.net.Uri
 */
package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 {
    private MediaDescriptionCompatApi23() {
    }

    public static Uri getMediaUri(Object object) {
        return ((MediaDescription)object).getMediaUri();
    }
}
