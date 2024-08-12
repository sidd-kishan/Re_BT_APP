/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.camera.view.video.AutoValue_OutputFileResults
 */
package androidx.camera.view.video;

import android.net.Uri;
import androidx.camera.view.video.AutoValue_OutputFileResults;

public abstract class OutputFileResults {
    OutputFileResults() {
    }

    public static OutputFileResults create(Uri uri) {
        return new AutoValue_OutputFileResults(uri);
    }

    public abstract Uri getSavedUri();
}
