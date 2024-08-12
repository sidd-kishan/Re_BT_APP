/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.view.Surface
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    static ImageWriter newInstance(Surface surface, int n, int n2) {
        return ImageWriter.newInstance((Surface)surface, (int)n, (int)n2);
    }
}
