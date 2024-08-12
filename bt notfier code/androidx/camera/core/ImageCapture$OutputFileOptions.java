/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  androidx.camera.core.ImageCapture$Metadata
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.ImageCapture;
import java.io.File;
import java.io.OutputStream;

public static final class ImageCapture.OutputFileOptions {
    private final ContentResolver mContentResolver;
    private final ContentValues mContentValues;
    private final File mFile;
    private final ImageCapture.Metadata mMetadata;
    private final OutputStream mOutputStream;
    private final Uri mSaveCollection;

    ImageCapture.OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, ImageCapture.Metadata metadata) {
        this.mFile = file;
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
        this.mOutputStream = outputStream;
        file = metadata;
        if (metadata == null) {
            file = new ImageCapture.Metadata();
        }
        this.mMetadata = file;
    }

    ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    ContentValues getContentValues() {
        return this.mContentValues;
    }

    File getFile() {
        return this.mFile;
    }

    public ImageCapture.Metadata getMetadata() {
        return this.mMetadata;
    }

    OutputStream getOutputStream() {
        return this.mOutputStream;
    }

    Uri getSaveCollection() {
        return this.mSaveCollection;
    }
}
