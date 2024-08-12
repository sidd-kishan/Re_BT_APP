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

public static abstract class OutputFileOptions.Builder {
    OutputFileOptions.Builder() {
    }

    public abstract OutputFileOptions build();

    abstract OutputFileOptions.Builder setContentResolver(ContentResolver var1);

    abstract OutputFileOptions.Builder setContentValues(ContentValues var1);

    abstract OutputFileOptions.Builder setFile(File var1);

    abstract OutputFileOptions.Builder setFileDescriptor(ParcelFileDescriptor var1);

    public abstract OutputFileOptions.Builder setMetadata(Metadata var1);

    abstract OutputFileOptions.Builder setSaveCollection(Uri var1);
}
