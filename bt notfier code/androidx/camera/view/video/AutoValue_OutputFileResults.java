/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  androidx.camera.view.video.OutputFileResults
 */
package androidx.camera.view.video;

import android.net.Uri;
import androidx.camera.view.video.OutputFileResults;

final class AutoValue_OutputFileResults
extends OutputFileResults {
    private final Uri savedUri;

    AutoValue_OutputFileResults(Uri uri) {
        this.savedUri = uri;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof OutputFileResults)) return false;
        OutputFileResults outputFileResults = (OutputFileResults)object;
        object = this.savedUri;
        outputFileResults = outputFileResults.getSavedUri();
        if (object == null) {
            if (outputFileResults == null) return bl;
            bl = false;
        } else {
            bl = object.equals((Object)outputFileResults);
        }
        return bl;
    }

    public Uri getSavedUri() {
        return this.savedUri;
    }

    public int hashCode() {
        Uri uri = this.savedUri;
        int n = uri == null ? 0 : uri.hashCode();
        return n ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OutputFileResults{savedUri=");
        stringBuilder.append(this.savedUri);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
