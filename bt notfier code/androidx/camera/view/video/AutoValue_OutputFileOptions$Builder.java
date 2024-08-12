/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  androidx.camera.view.video.AutoValue_OutputFileOptions
 *  androidx.camera.view.video.Metadata
 *  androidx.camera.view.video.OutputFileOptions
 *  androidx.camera.view.video.OutputFileOptions$Builder
 */
package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.view.video.AutoValue_OutputFileOptions;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import java.io.File;

static final class AutoValue_OutputFileOptions.Builder
extends OutputFileOptions.Builder {
    private ContentResolver contentResolver;
    private ContentValues contentValues;
    private File file;
    private ParcelFileDescriptor fileDescriptor;
    private Metadata metadata;
    private Uri saveCollection;

    AutoValue_OutputFileOptions.Builder() {
    }

    public OutputFileOptions build() {
        Object object = this.metadata;
        CharSequence charSequence = "";
        if (object == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("");
            ((StringBuilder)charSequence).append(" metadata");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        if (((String)charSequence).isEmpty()) {
            return new AutoValue_OutputFileOptions(this.file, this.fileDescriptor, this.contentResolver, this.saveCollection, this.contentValues, this.metadata, null);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Missing required properties:");
        ((StringBuilder)object).append((String)charSequence);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    OutputFileOptions.Builder setContentResolver(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
        return this;
    }

    OutputFileOptions.Builder setContentValues(ContentValues contentValues) {
        this.contentValues = contentValues;
        return this;
    }

    OutputFileOptions.Builder setFile(File file) {
        this.file = file;
        return this;
    }

    OutputFileOptions.Builder setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.fileDescriptor = parcelFileDescriptor;
        return this;
    }

    public OutputFileOptions.Builder setMetadata(Metadata metadata) {
        if (metadata == null) throw new NullPointerException("Null metadata");
        this.metadata = metadata;
        return this;
    }

    OutputFileOptions.Builder setSaveCollection(Uri uri) {
        this.saveCollection = uri;
        return this;
    }
}
