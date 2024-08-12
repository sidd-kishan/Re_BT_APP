/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  androidx.camera.core.VideoCapture$Metadata
 *  androidx.camera.core.VideoCapture$OutputFileOptions
 *  androidx.camera.core.VideoCapture$OutputFileOptions$Builder
 *  androidx.camera.view.video.AutoValue_OutputFileOptions$Builder
 *  androidx.camera.view.video.Metadata
 *  androidx.camera.view.video.OutputFileOptions$Builder
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.video.AutoValue_OutputFileOptions;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import androidx.core.util.Preconditions;
import java.io.File;

public abstract class OutputFileOptions {
    private static final Metadata EMPTY_METADATA = Metadata.builder().build();

    OutputFileOptions() {
    }

    public static Builder builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setContentResolver(contentResolver).setSaveCollection(uri).setContentValues(contentValues);
    }

    public static Builder builder(ParcelFileDescriptor parcelFileDescriptor) {
        boolean bl = Build.VERSION.SDK_INT >= 26;
        Preconditions.checkArgument((boolean)bl, (Object)"Using a ParcelFileDescriptor to record a video is only supported for Android 8.0 or above.");
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFileDescriptor(parcelFileDescriptor);
    }

    public static Builder builder(File file) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFile(file);
    }

    private boolean isSavingToFile() {
        boolean bl = this.getFile() != null;
        return bl;
    }

    private boolean isSavingToFileDescriptor() {
        boolean bl = this.getFileDescriptor() != null;
        return bl;
    }

    private boolean isSavingToMediaStore() {
        boolean bl = this.getSaveCollection() != null && this.getContentResolver() != null && this.getContentValues() != null;
        return bl;
    }

    abstract ContentResolver getContentResolver();

    abstract ContentValues getContentValues();

    abstract File getFile();

    abstract ParcelFileDescriptor getFileDescriptor();

    public abstract Metadata getMetadata();

    abstract Uri getSaveCollection();

    public VideoCapture.OutputFileOptions toVideoCaptureOutputFileOptions() {
        VideoCapture.OutputFileOptions.Builder builder;
        if (this.isSavingToFile()) {
            builder = new VideoCapture.OutputFileOptions.Builder((File)Preconditions.checkNotNull((Object)this.getFile()));
        } else if (this.isSavingToFileDescriptor()) {
            builder = new VideoCapture.OutputFileOptions.Builder(((ParcelFileDescriptor)Preconditions.checkNotNull((Object)this.getFileDescriptor())).getFileDescriptor());
        } else {
            Preconditions.checkState((boolean)this.isSavingToMediaStore());
            builder = new VideoCapture.OutputFileOptions.Builder((ContentResolver)Preconditions.checkNotNull((Object)this.getContentResolver()), (Uri)Preconditions.checkNotNull((Object)this.getSaveCollection()), (ContentValues)Preconditions.checkNotNull((Object)this.getContentValues()));
        }
        VideoCapture.Metadata metadata = new VideoCapture.Metadata();
        metadata.location = this.getMetadata().getLocation();
        builder.setMetadata(metadata);
        return builder.build();
    }
}
