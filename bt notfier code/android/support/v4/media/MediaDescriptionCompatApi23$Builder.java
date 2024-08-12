/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaDescription$Builder
 *  android.net.Uri
 */
package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

static class MediaDescriptionCompatApi23.Builder {
    private MediaDescriptionCompatApi23.Builder() {
    }

    public static void setMediaUri(Object object, Uri uri) {
        ((MediaDescription.Builder)object).setMediaUri(uri);
    }
}
