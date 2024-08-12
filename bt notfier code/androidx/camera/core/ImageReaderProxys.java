/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy
 */
package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;

final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    static ImageReaderProxy createIsolatedReader(int n, int n2, int n3, int n4) {
        return new AndroidImageReaderProxy(ImageReader.newInstance((int)n, (int)n2, (int)n3, (int)n4));
    }
}
