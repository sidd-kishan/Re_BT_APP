/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  androidx.camera.core.ImageCapture$Metadata
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.ImageCapture;
import java.io.File;
import java.io.OutputStream;

public static final class ImageCapture.OutputFileOptions.Builder {
    private ContentResolver mContentResolver;
    private ContentValues mContentValues;
    private File mFile;
    private ImageCapture.Metadata mMetadata;
    private OutputStream mOutputStream;
    private Uri mSaveCollection;

    public ImageCapture.OutputFileOptions.Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
    }

    public ImageCapture.OutputFileOptions.Builder(File file) {
        this.mFile = file;
    }

    public ImageCapture.OutputFileOptions.Builder(OutputStream outputStream) {
        this.mOutputStream = outputStream;
    }

    public ImageCapture.OutputFileOptions build() {
        return new ImageCapture.OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
    }

    public ImageCapture.OutputFileOptions.Builder setMetadata(ImageCapture.Metadata metadata) {
        this.mMetadata = metadata;
        return this;
    }
}
