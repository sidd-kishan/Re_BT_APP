/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.camera.core;

import android.net.Uri;

public static class VideoCapture.OutputFileResults {
    private Uri mSavedUri;

    VideoCapture.OutputFileResults(Uri uri) {
        this.mSavedUri = uri;
    }

    public Uri getSavedUri() {
        return this.mSavedUri;
    }
}
