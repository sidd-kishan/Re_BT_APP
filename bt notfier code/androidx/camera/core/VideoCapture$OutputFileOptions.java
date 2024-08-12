/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  androidx.camera.core.VideoCapture$Metadata
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.VideoCapture;
import java.io.File;
import java.io.FileDescriptor;

public static final class VideoCapture.OutputFileOptions {
    private static final VideoCapture.Metadata EMPTY_METADATA = new VideoCapture.Metadata();
    private final ContentResolver mContentResolver;
    private final ContentValues mContentValues;
    private final File mFile;
    private final FileDescriptor mFileDescriptor;
    private final VideoCapture.Metadata mMetadata;
    private final Uri mSaveCollection;

    VideoCapture.OutputFileOptions(File file, FileDescriptor fileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, VideoCapture.Metadata metadata) {
        this.mFile = file;
        this.mFileDescriptor = fileDescriptor;
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
        file = metadata;
        if (metadata == null) {
            file = EMPTY_METADATA;
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

    FileDescriptor getFileDescriptor() {
        return this.mFileDescriptor;
    }

    VideoCapture.Metadata getMetadata() {
        return this.mMetadata;
    }

    Uri getSaveCollection() {
        return this.mSaveCollection;
    }

    boolean isSavingToFile() {
        boolean bl = this.getFile() != null;
        return bl;
    }

    boolean isSavingToFileDescriptor() {
        boolean bl = this.getFileDescriptor() != null;
        return bl;
    }

    boolean isSavingToMediaStore() {
        boolean bl = this.getSaveCollection() != null && this.getContentResolver() != null && this.getContentValues() != null;
        return bl;
    }
}
