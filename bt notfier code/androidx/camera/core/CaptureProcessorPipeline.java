/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.AndroidImageReaderProxy
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.SettableImageProxy
 *  androidx.camera.core.SettableImageProxyBundle
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.ImageProxyBundle
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

class CaptureProcessorPipeline
implements CaptureProcessor {
    private final Executor mExecutor;
    private ImageReaderProxy mIntermediateImageReader = null;
    private final int mMaxImages;
    private final CaptureProcessor mPostCaptureProcessor;
    private final CaptureProcessor mPreCaptureProcessor;
    private ImageInfo mSourceImageInfo = null;

    CaptureProcessorPipeline(CaptureProcessor captureProcessor, int n, CaptureProcessor captureProcessor2, Executor executor) {
        this.mPreCaptureProcessor = captureProcessor;
        this.mPostCaptureProcessor = captureProcessor2;
        this.mExecutor = executor;
        this.mMaxImages = n;
    }

    void close() {
        ImageReaderProxy imageReaderProxy = this.mIntermediateImageReader;
        if (imageReaderProxy == null) return;
        imageReaderProxy.clearOnImageAvailableListener();
        this.mIntermediateImageReader.close();
    }

    public void onOutputSurface(Surface surface, int n) {
        this.mPostCaptureProcessor.onOutputSurface(surface, n);
    }

    public void onResolutionUpdate(Size size) {
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance((int)size.getWidth(), (int)size.getHeight(), (int)35, (int)this.mMaxImages));
        this.mIntermediateImageReader = androidImageReaderProxy;
        this.mPreCaptureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), 35);
        this.mPreCaptureProcessor.onResolutionUpdate(size);
        this.mPostCaptureProcessor.onResolutionUpdate(size);
        this.mIntermediateImageReader.setOnImageAvailableListener((ImageReaderProxy.OnImageAvailableListener)new /* Unavailable Anonymous Inner Class!! */, this.mExecutor);
    }

    void postProcess(ImageProxy imageProxy) {
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        Preconditions.checkNotNull((Object)this.mSourceImageInfo);
        String string = (String)this.mSourceImageInfo.getTagBundle().listKeys().iterator().next();
        int n = this.mSourceImageInfo.getTagBundle().getTag(string);
        imageProxy = new SettableImageProxy(imageProxy, size, this.mSourceImageInfo);
        this.mSourceImageInfo = null;
        string = new SettableImageProxyBundle(Collections.singletonList(n), string);
        string.addImageProxy(imageProxy);
        this.mPostCaptureProcessor.process((ImageProxyBundle)string);
    }

    public void process(ImageProxyBundle imageProxyBundle) {
        ListenableFuture listenableFuture = imageProxyBundle.getImageProxy(((Integer)imageProxyBundle.getCaptureIds().get(0)).intValue());
        Preconditions.checkArgument((boolean)listenableFuture.isDone());
        try {
            this.mSourceImageInfo = ((ImageProxy)listenableFuture.get()).getImageInfo();
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
        }
        this.mPreCaptureProcessor.process(imageProxyBundle);
    }
}
