/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

public class ImageCaptureException
extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.mImageCaptureError = n;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
