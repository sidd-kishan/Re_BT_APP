/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.os.Build$VERSION
 *  android.view.Surface
 *  androidx.camera.core.internal.compat.ImageWriterCompatApi26Impl
 *  androidx.camera.core.internal.compat.ImageWriterCompatApi29Impl
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.camera.core.internal.compat.ImageWriterCompatApi26Impl;
import androidx.camera.core.internal.compat.ImageWriterCompatApi29Impl;

public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static ImageWriter newInstance(Surface object, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageWriterCompatApi29Impl.newInstance((Surface)object, (int)n, (int)n2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ImageWriterCompatApi26Impl.newInstance((Surface)object, (int)n, (int)n2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unable to call newInstance(Surface, int, int) on API ");
        ((StringBuilder)object).append(Build.VERSION.SDK_INT);
        ((StringBuilder)object).append(". Version 26 or higher required.");
        throw new RuntimeException(((StringBuilder)object).toString());
    }
}
