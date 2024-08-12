/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImmutableImageInfo
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SettableImageProxy
 *  androidx.camera.core._$$Lambda$ImageAnalysisAbstractAnalyzer$V6Gtux2_h8spda8vf4wFnIZntYI
 *  androidx.camera.core._$$Lambda$ImageAnalysisAbstractAnalyzer$mR2LN44DwXC209Sm8_KLIHvFCIo
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.os.OperationCanceledException
 */
package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core._$;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

abstract class ImageAnalysisAbstractAnalyzer
implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    private Executor mUserExecutor;

    ImageAnalysisAbstractAnalyzer() {
    }

    abstract ImageProxy acquireImage(ImageReaderProxy var1);

    /*
     * Enabled unnecessary exception pruning
     */
    ListenableFuture<Void> analyzeImage(ImageProxy object) {
        ImageAnalysis.Analyzer analyzer;
        Executor executor;
        Object object2 = this.mAnalyzerLock;
        synchronized (object2) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        if (analyzer == null) return Futures.immediateFailedFuture((Throwable)new OperationCanceledException("No analyzer or executor currently set."));
        if (executor == null) return Futures.immediateFailedFuture((Throwable)new OperationCanceledException("No analyzer or executor currently set."));
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageAnalysisAbstractAnalyzer.mR2LN44DwXC209Sm8_KLIHvFCIo(this, executor, object, analyzer));
    }

    void attach() {
        this.mIsAttached = true;
    }

    abstract void clearCache();

    void detach() {
        this.mIsAttached = false;
        this.clearCache();
    }

    public /* synthetic */ void lambda$analyzeImage$0$ImageAnalysisAbstractAnalyzer(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (this.mIsAttached) {
            analyzer.analyze((ImageProxy)new SettableImageProxy(imageProxy, ImmutableImageInfo.create((TagBundle)imageProxy.getImageInfo().getTagBundle(), (long)imageProxy.getImageInfo().getTimestamp(), (int)this.mRelativeRotation)));
            completer.set(null);
        } else {
            completer.setException((Throwable)new OperationCanceledException("ImageAnalysis is detached"));
        }
    }

    public /* synthetic */ Object lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(Executor executor, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute((Runnable)new _$.Lambda.ImageAnalysisAbstractAnalyzer.V6Gtux2_h8spda8vf4wFnIZntYI(this, imageProxy, analyzer, completer));
        return "analyzeImage";
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            imageReaderProxy = this.acquireImage(imageReaderProxy);
            if (imageReaderProxy == null) return;
            this.onValidImageAvailable((ImageProxy)imageReaderProxy);
        }
        catch (IllegalStateException illegalStateException) {
            Logger.e((String)TAG, (String)"Failed to acquire image.", (Throwable)illegalStateException);
        }
    }

    abstract void onValidImageAvailable(ImageProxy var1);

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        Object object = this.mAnalyzerLock;
        synchronized (object) {
            void var2_2;
            if (var2_2 == null) {
                this.clearCache();
            }
            this.mSubscribedAnalyzer = var2_2;
            this.mUserExecutor = executor;
            return;
        }
    }

    void setRelativeRotation(int n) {
        this.mRelativeRotation = n;
    }
}
