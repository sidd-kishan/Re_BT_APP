/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.camera.core;

import android.net.Uri;

public static class ImageCapture.OutputFileResults {
    private Uri mSavedUri;

    ImageCapture.OutputFileResults(Uri uri) {
        this.mSavedUri = uri;
    }

    public Uri getSavedUri() {
        return this.mSavedUri;
    }
}
