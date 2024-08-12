/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysisAbstractAnalyzer
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

final class ImageAnalysisNonBlockingAnalyzer
extends ImageAnalysisAbstractAnalyzer {
    final Executor mBackgroundExecutor;
    ImageProxy mCachedImage;
    private final Object mLock = new Object();
    private CacheAnalyzingImageProxy mPostedImage;

    ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
    }

    ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireLatestImage();
    }

    void analyzeCachedImage() {
        Object object = this.mLock;
        synchronized (object) {
            this.mPostedImage = null;
            if (this.mCachedImage == null) return;
            ImageProxy imageProxy = this.mCachedImage;
            this.mCachedImage = null;
            this.onValidImageAvailable(imageProxy);
            return;
        }
    }

    void clearCache() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mCachedImage == null) return;
            this.mCachedImage.close();
            this.mCachedImage = null;
            return;
        }
    }

    void onValidImageAvailable(ImageProxy imageProxy) {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mIsAttached) {
                imageProxy.close();
                return;
            }
            if (this.mPostedImage == null) {
                CacheAnalyzingImageProxy cacheAnalyzingImageProxy;
                this.mPostedImage = cacheAnalyzingImageProxy = new CacheAnalyzingImageProxy(imageProxy, this);
                ListenableFuture listenableFuture = this.analyzeImage((ImageProxy)cacheAnalyzingImageProxy);
                imageProxy = new /* Unavailable Anonymous Inner Class!! */;
                Futures.addCallback((ListenableFuture)listenableFuture, (FutureCallback)imageProxy, (Executor)CameraXExecutors.directExecutor());
                return;
            }
            if (imageProxy.getImageInfo().getTimestamp() <= this.mPostedImage.getImageInfo().getTimestamp()) {
                imageProxy.close();
            } else {
                if (this.mCachedImage != null) {
                    this.mCachedImage.close();
                }
                this.mCachedImage = imageProxy;
            }
            return;
        }
    }
}
