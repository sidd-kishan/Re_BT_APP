/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  androidx.camera.view.video.Metadata
 *  androidx.camera.view.video.OutputFileOptions
 */
package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.view.video.Metadata;
import androidx.camera.view.video.OutputFileOptions;
import java.io.File;

final class AutoValue_OutputFileOptions
extends OutputFileOptions {
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final File file;
    private final ParcelFileDescriptor fileDescriptor;
    private final Metadata metadata;
    private final Uri saveCollection;

    private AutoValue_OutputFileOptions(File file, ParcelFileDescriptor parcelFileDescriptor, ContentResolver contentResolver, Uri uri, ContentValues contentValues, Metadata metadata) {
        this.file = file;
        this.fileDescriptor = parcelFileDescriptor;
        this.contentResolver = contentResolver;
        this.saveCollection = uri;
        this.contentValues = contentValues;
        this.metadata = metadata;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof OutputFileOptions)) return false;
        object = (OutputFileOptions)object;
        File file = this.file;
        if ((file == null ? object.getFile() == null : file.equals(object.getFile())) && ((file = this.fileDescriptor) == null ? object.getFileDescriptor() == null : ((Object)file).equals(object.getFileDescriptor())) && ((file = this.contentResolver) == null ? object.getContentResolver() == null : ((Object)file).equals(object.getContentResolver())) && ((file = this.saveCollection) == null ? object.getSaveCollection() == null : file.equals(object.getSaveCollection())) && ((file = this.contentValues) == null ? object.getContentValues() == null : file.equals(object.getContentValues())) && this.metadata.equals(object.getMetadata())) return bl;
        bl = false;
        return bl;
    }

    ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    ContentValues getContentValues() {
        return this.contentValues;
    }

    File getFile() {
        return this.file;
    }

    ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    Uri getSaveCollection() {
        return this.saveCollection;
    }

    public int hashCode() {
        File file = this.file;
        int n = 0;
        int n2 = file == null ? 0 : file.hashCode();
        file = this.fileDescriptor;
        int n3 = file == null ? 0 : ((Object)file).hashCode();
        file = this.contentResolver;
        int n4 = file == null ? 0 : ((Object)file).hashCode();
        file = this.saveCollection;
        int n5 = file == null ? 0 : file.hashCode();
        file = this.contentValues;
        if (file == null) return (((((n2 ^ 0xF4243) * 1000003 ^ n3) * 1000003 ^ n4) * 1000003 ^ n5) * 1000003 ^ n) * 1000003 ^ this.metadata.hashCode();
        n = file.hashCode();
        return (((((n2 ^ 0xF4243) * 1000003 ^ n3) * 1000003 ^ n4) * 1000003 ^ n5) * 1000003 ^ n) * 1000003 ^ this.metadata.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OutputFileOptions{file=");
        stringBuilder.append(this.file);
        stringBuilder.append(", fileDescriptor=");
        stringBuilder.append(this.fileDescriptor);
        stringBuilder.append(", contentResolver=");
        stringBuilder.append(this.contentResolver);
        stringBuilder.append(", saveCollection=");
        stringBuilder.append(this.saveCollection);
        stringBuilder.append(", contentValues=");
        stringBuilder.append(this.contentValues);
        stringBuilder.append(", metadata=");
        stringBuilder.append(this.metadata);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
