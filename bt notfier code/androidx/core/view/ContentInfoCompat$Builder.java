/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.net.Uri
 *  android.os.Bundle
 *  androidx.core.view.ContentInfoCompat
 */
package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.ContentInfoCompat;

public static final class ContentInfoCompat.Builder {
    ClipData mClip;
    Bundle mExtras;
    int mFlags;
    Uri mLinkUri;
    int mSource;

    public ContentInfoCompat.Builder(ClipData clipData, int n) {
        this.mClip = clipData;
        this.mSource = n;
    }

    public ContentInfoCompat.Builder(ContentInfoCompat contentInfoCompat) {
        this.mClip = contentInfoCompat.mClip;
        this.mSource = contentInfoCompat.mSource;
        this.mFlags = contentInfoCompat.mFlags;
        this.mLinkUri = contentInfoCompat.mLinkUri;
        this.mExtras = contentInfoCompat.mExtras;
    }

    public ContentInfoCompat build() {
        return new ContentInfoCompat(this);
    }

    public ContentInfoCompat.Builder setClip(ClipData clipData) {
        this.mClip = clipData;
        return this;
    }

    public ContentInfoCompat.Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public ContentInfoCompat.Builder setFlags(int n) {
        this.mFlags = n;
        return this;
    }

    public ContentInfoCompat.Builder setLinkUri(Uri uri) {
        this.mLinkUri = uri;
        return this;
    }

    public ContentInfoCompat.Builder setSource(int n) {
        this.mSource = n;
        return this;
    }
}
