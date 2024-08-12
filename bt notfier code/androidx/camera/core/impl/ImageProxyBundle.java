/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxy
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageProxy;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public interface ImageProxyBundle {
    public List<Integer> getCaptureIds();

    public ListenableFuture<ImageProxy> getImageProxy(int var1);
}
