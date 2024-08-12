/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.camera.core.VideoCapture$Metadata
 *  androidx.camera.core.VideoCapture$OutputFileOptions
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.VideoCapture;
import androidx.core.util.Preconditions;
import java.io.File;
import java.io.FileDescriptor;

public static final class VideoCapture.OutputFileOptions.Builder {
    private ContentResolver mContentResolver;
    private ContentValues mContentValues;
    private File mFile;
    private FileDescriptor mFileDescriptor;
    private VideoCapture.Metadata mMetadata;
    private Uri mSaveCollection;

    public VideoCapture.OutputFileOptions.Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.mContentResolver = contentResolver;
        this.mSaveCollection = uri;
        this.mContentValues = contentValues;
    }

    public VideoCapture.OutputFileOptions.Builder(File file) {
        this.mFile = file;
    }

    public VideoCapture.OutputFileOptions.Builder(FileDescriptor fileDescriptor) {
        boolean bl = Build.VERSION.SDK_INT >= 26;
        Preconditions.checkArgument((boolean)bl, (Object)"Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
        this.mFileDescriptor = fileDescriptor;
    }

    public VideoCapture.OutputFileOptions build() {
        return new VideoCapture.OutputFileOptions(this.mFile, this.mFileDescriptor, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mMetadata);
    }

    public VideoCapture.OutputFileOptions.Builder setMetadata(VideoCapture.Metadata metadata) {
        this.mMetadata = metadata;
        return this;
    }
}
