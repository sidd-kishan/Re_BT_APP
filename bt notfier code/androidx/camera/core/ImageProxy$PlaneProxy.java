/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core;

import java.nio.ByteBuffer;

public static interface ImageProxy.PlaneProxy {
    public ByteBuffer getBuffer();

    public int getPixelStride();

    public int getRowStride();
}
