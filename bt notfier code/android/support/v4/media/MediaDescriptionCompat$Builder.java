/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.Bundle
 *  android.support.v4.media.MediaDescriptionCompat
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;

public static final class MediaDescriptionCompat.Builder {
    private CharSequence mDescription;
    private Bundle mExtras;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private CharSequence mSubtitle;
    private CharSequence mTitle;

    public MediaDescriptionCompat build() {
        return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
    }

    public MediaDescriptionCompat.Builder setDescription(CharSequence charSequence) {
        this.mDescription = charSequence;
        return this;
    }

    public MediaDescriptionCompat.Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public MediaDescriptionCompat.Builder setIconBitmap(Bitmap bitmap) {
        this.mIcon = bitmap;
        return this;
    }

    public MediaDescriptionCompat.Builder setIconUri(Uri uri) {
        this.mIconUri = uri;
        return this;
    }

    public MediaDescriptionCompat.Builder setMediaId(String string) {
        this.mMediaId = string;
        return this;
    }

    public MediaDescriptionCompat.Builder setMediaUri(Uri uri) {
        this.mMediaUri = uri;
        return this;
    }

    public MediaDescriptionCompat.Builder setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        return this;
    }

    public MediaDescriptionCompat.Builder setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }
}
