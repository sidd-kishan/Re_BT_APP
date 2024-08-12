/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.transform.FileTransformFactory
 */
package androidx.camera.view.transform;

import androidx.camera.view.transform.FileTransformFactory;

public static class FileTransformFactory.Builder {
    boolean mUseExifOrientation = false;

    public FileTransformFactory build() {
        return new FileTransformFactory(this.mUseExifOrientation);
    }

    public FileTransformFactory.Builder setUseExifOrientation(boolean bl) {
        this.mUseExifOrientation = bl;
        return this;
    }
}
