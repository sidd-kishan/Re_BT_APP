/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageAnalysis$Builder
 *  androidx.camera.core.ImageAnalysis$Defaults
 *  androidx.camera.core.ImageAnalysisAbstractAnalyzer
 *  androidx.camera.core.ImageAnalysisBlockingAnalyzer
 *  androidx.camera.core.ImageAnalysisNonBlockingAnalyzer
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.ImageReaderProxys
 *  androidx.camera.core.SafeCloseImageReaderProxy
 *  androidx.camera.core.UseCase
 *  androidx.camera.core._$$Lambda$ImageAnalysis$Gd6VUhKl5XOmwdAgw0vhwsuiNpE
 *  androidx.camera.core._$$Lambda$ImageAnalysis$SK4XUin3LEuOy83vccLKZvMIwq8
 *  androidx.camera.core._$$Lambda$kBKr_WXSgibOrSk3AWcyOrTIBI0
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$_CC
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.ImageAnalysisConfig
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.ImmediateSurface
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$Builder
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.UseCaseConfigFactory$CaptureType
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageAnalysisAbstractAnalyzer;
import androidx.camera.core.ImageAnalysisBlockingAnalyzer;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.UseCase;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ImageAnalysis
extends UseCase {
    private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock = new Object();
    private DeferrableSurface mDeferrableSurface;
    final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;
    private Analyzer mSubscribedAnalyzer;

    ImageAnalysis(ImageAnalysisConfig imageAnalysisConfig) {
        super((UseCaseConfig)imageAnalysisConfig);
        this.mImageAnalysisAbstractAnalyzer = ((ImageAnalysisConfig)this.getCurrentConfig()).getBackpressureStrategy(0) == 1 ? new ImageAnalysisBlockingAnalyzer() : new ImageAnalysisNonBlockingAnalyzer(imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
    }

    private void tryUpdateRelativeRotation() {
        CameraInternal cameraInternal = this.getCamera();
        if (cameraInternal == null) return;
        this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(this.getRelativeRotation(cameraInternal));
    }

    public void clearAnalyzer() {
        Object object = this.mAnalysisLock;
        synchronized (object) {
            this.mImageAnalysisAbstractAnalyzer.setAnalyzer(null, null);
            if (this.mSubscribedAnalyzer != null) {
                this.notifyInactive();
            }
            this.mSubscribedAnalyzer = null;
            return;
        }
    }

    void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface == null) return;
        deferrableSurface.close();
        this.mDeferrableSurface = null;
    }

    SessionConfig.Builder createPipeline(String string, ImageAnalysisConfig imageAnalysisConfig, Size size) {
        Threads.checkMainThread();
        Executor executor = (Executor)Preconditions.checkNotNull((Object)imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
        int n = this.getBackpressureStrategy() == 1 ? this.getImageQueueDepth() : 4;
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = imageAnalysisConfig.getImageReaderProxyProvider() != null ? new SafeCloseImageReaderProxy(imageAnalysisConfig.getImageReaderProxyProvider().newInstance(size.getWidth(), size.getHeight(), this.getImageFormat(), n, 0L)) : new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader((int)size.getWidth(), (int)size.getHeight(), (int)this.getImageFormat(), (int)n));
        this.tryUpdateRelativeRotation();
        safeCloseImageReaderProxy.setOnImageAvailableListener((ImageReaderProxy.OnImageAvailableListener)this.mImageAnalysisAbstractAnalyzer, executor);
        executor = SessionConfig.Builder.createFrom((UseCaseConfig)imageAnalysisConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = deferrableSurface = new ImmediateSurface(safeCloseImageReaderProxy.getSurface());
        deferrableSurface.getTerminationFuture().addListener((Runnable)new _$.Lambda.kBKr_WXSgibOrSk3AWcyOrTIBI0(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
        executor.addSurface(this.mDeferrableSurface);
        executor.addErrorListener((SessionConfig.ErrorListener)new _$.Lambda.ImageAnalysis.Gd6VUhKl5XOmwdAgw0vhwsuiNpE(this, string, imageAnalysisConfig, size));
        return executor;
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig)this.getCurrentConfig()).getBackpressureStrategy(0);
    }

    public UseCaseConfig<?> getDefaultConfig(boolean bl, UseCaseConfigFactory object) {
        Config config = object.getConfig(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
        object = config;
        if (bl) {
            object = Config._CC.mergeConfigs((Config)config, (Config)DEFAULT_CONFIG.getConfig());
        }
        object = object == null ? null : this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        return object;
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig)this.getCurrentConfig()).getImageQueueDepth(6);
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig((Config)config);
    }

    public /* synthetic */ void lambda$createPipeline$0$ImageAnalysis(String string, ImageAnalysisConfig imageAnalysisConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.clearCache();
        if (!this.isCurrentCamera(string)) return;
        this.updateSessionConfig(this.createPipeline(string, imageAnalysisConfig, size).build());
        this.notifyReset();
    }

    public /* synthetic */ void lambda$setAnalyzer$1$ImageAnalysis(Analyzer analyzer, ImageProxy imageProxy) {
        if (this.getViewPortCropRect() != null) {
            imageProxy.setCropRect(this.getViewPortCropRect());
        }
        analyzer.analyze(imageProxy);
    }

    public void onAttached() {
        this.mImageAnalysisAbstractAnalyzer.attach();
    }

    public void onDetached() {
        this.clearPipeline();
        this.mImageAnalysisAbstractAnalyzer.detach();
    }

    protected Size onSuggestedResolutionUpdated(Size size) {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig)this.getCurrentConfig();
        this.updateSessionConfig(this.createPipeline(this.getCameraId(), imageAnalysisConfig, size).build());
        return size;
    }

    public void setAnalyzer(Executor executor, Analyzer analyzer) {
        Object object = this.mAnalysisLock;
        synchronized (object) {
            ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer = this.mImageAnalysisAbstractAnalyzer;
            _$.Lambda.ImageAnalysis.SK4XUin3LEuOy83vccLKZvMIwq8 sK4XUin3LEuOy83vccLKZvMIwq8 = new _$.Lambda.ImageAnalysis.SK4XUin3LEuOy83vccLKZvMIwq8(this, analyzer);
            imageAnalysisAbstractAnalyzer.setAnalyzer(executor, (Analyzer)sK4XUin3LEuOy83vccLKZvMIwq8);
            if (this.mSubscribedAnalyzer == null) {
                this.notifyActive();
            }
            this.mSubscribedAnalyzer = analyzer;
            return;
        }
    }

    public void setTargetRotation(int n) {
        if (!this.setTargetRotationInternal(n)) return;
        this.tryUpdateRelativeRotation();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageAnalysis:");
        stringBuilder.append(this.getName());
        return stringBuilder.toString();
    }
}
