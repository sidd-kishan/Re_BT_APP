/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.util.Size
 *  androidx.camera.core.Preview$Builder
 *  androidx.camera.core.Preview$Defaults
 *  androidx.camera.core.Preview$SurfaceProvider
 *  androidx.camera.core.ProcessingSurface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.core.UseCase
 *  androidx.camera.core._$$Lambda$Preview$F8OagHJfMben_rk0POhBzTArAGY
 *  androidx.camera.core._$$Lambda$Preview$mBIi_1TxOEtDykjYmpiDigz40hs
 *  androidx.camera.core._$$Lambda$VS_AhFnevfX6dVpdRrxC_TUaSoY
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.camera.core.impl.CaptureStage$DefaultCaptureStage
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$_CC
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.ImageInputConfig
 *  androidx.camera.core.impl.PreviewConfig
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
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.camera.core.Preview;
import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public final class Preview
extends UseCase {
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final Executor DEFAULT_SURFACE_PROVIDER_EXECUTOR = CameraXExecutors.mainThreadExecutor();
    private static final String TAG = "Preview";
    SurfaceRequest mCurrentSurfaceRequest;
    private boolean mHasUnsentSurfaceRequest = false;
    private DeferrableSurface mSessionDeferrableSurface;
    private SurfaceProvider mSurfaceProvider;
    private Executor mSurfaceProviderExecutor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
    private Size mSurfaceSize;

    Preview(PreviewConfig previewConfig) {
        super((UseCaseConfig)previewConfig);
    }

    private Rect getCropRect(Size size) {
        if (this.getViewPortCropRect() != null) {
            return this.getViewPortCropRect();
        }
        if (size == null) return null;
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    static /* synthetic */ void lambda$sendSurfaceRequestIfReady$1(SurfaceProvider surfaceProvider, SurfaceRequest surfaceRequest) {
        surfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    private boolean sendSurfaceRequestIfReady() {
        SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        if (surfaceProvider == null) return false;
        if (surfaceRequest == null) return false;
        this.mSurfaceProviderExecutor.execute((Runnable)new _$.Lambda.Preview.F8OagHJfMben_rk0POhBzTArAGY(surfaceProvider, surfaceRequest));
        return true;
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal cameraInternal = this.getCamera();
        SurfaceProvider surfaceProvider = this.mSurfaceProvider;
        Rect rect = this.getCropRect(this.mSurfaceSize);
        SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        if (cameraInternal == null) return;
        if (surfaceProvider == null) return;
        if (rect == null) return;
        surfaceRequest.updateTransformationInfo(SurfaceRequest.TransformationInfo.of((Rect)rect, (int)this.getRelativeRotation(cameraInternal), (int)this.getTargetRotation()));
    }

    private void updateConfigAndOutput(String string, PreviewConfig previewConfig, Size size) {
        this.updateSessionConfig(this.createPipeline(string, previewConfig, size).build());
    }

    SessionConfig.Builder createPipeline(String string, PreviewConfig previewConfig, Size size) {
        Threads.checkMainThread();
        SessionConfig.Builder builder = SessionConfig.Builder.createFrom((UseCaseConfig)previewConfig);
        CaptureProcessor captureProcessor = previewConfig.getCaptureProcessor(null);
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        deferrableSurface = this.getCamera();
        boolean bl = captureProcessor != null;
        deferrableSurface = new SurfaceRequest(size, (CameraInternal)deferrableSurface, bl);
        this.mCurrentSurfaceRequest = deferrableSurface;
        if (this.sendSurfaceRequestIfReady()) {
            this.sendTransformationInfoIfReady();
        } else {
            this.mHasUnsentSurfaceRequest = true;
        }
        if (captureProcessor != null) {
            CaptureStage.DefaultCaptureStage defaultCaptureStage = new CaptureStage.DefaultCaptureStage();
            HandlerThread handlerThread = new HandlerThread("CameraX-preview_processing");
            handlerThread.start();
            String string2 = Integer.toString(defaultCaptureStage.hashCode());
            captureProcessor = new ProcessingSurface(size.getWidth(), size.getHeight(), previewConfig.getInputFormat(), new Handler(handlerThread.getLooper()), (CaptureStage)defaultCaptureStage, captureProcessor, deferrableSurface.getDeferrableSurface(), string2);
            builder.addCameraCaptureCallback(captureProcessor.getCameraCaptureCallback());
            captureProcessor.getTerminationFuture().addListener((Runnable)new _$.Lambda.VS_AhFnevfX6dVpdRrxC_TUaSoY(handlerThread), CameraXExecutors.directExecutor());
            this.mSessionDeferrableSurface = captureProcessor;
            builder.addTag(string2, Integer.valueOf(defaultCaptureStage.getId()));
        } else {
            captureProcessor = previewConfig.getImageInfoProcessor(null);
            if (captureProcessor != null) {
                builder.addCameraCaptureCallback((CameraCaptureCallback)new /* Unavailable Anonymous Inner Class!! */);
            }
            this.mSessionDeferrableSurface = deferrableSurface.getDeferrableSurface();
        }
        builder.addSurface(this.mSessionDeferrableSurface);
        builder.addErrorListener((SessionConfig.ErrorListener)new _$.Lambda.Preview.mBIi_1TxOEtDykjYmpiDigz40hs(this, string, previewConfig, size));
        return builder;
    }

    public UseCaseConfig<?> getDefaultConfig(boolean bl, UseCaseConfigFactory object) {
        Config config = object.getConfig(UseCaseConfigFactory.CaptureType.PREVIEW);
        object = config;
        if (bl) {
            object = Config._CC.mergeConfigs((Config)config, (Config)DEFAULT_CONFIG.getConfig());
        }
        object = object == null ? null : this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        return object;
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig((Config)config);
    }

    public /* synthetic */ void lambda$createPipeline$0$Preview(String string, PreviewConfig previewConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (!this.isCurrentCamera(string)) return;
        this.updateSessionConfig(this.createPipeline(string, previewConfig, size).build());
        this.notifyReset();
    }

    public void onDetached() {
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mCurrentSurfaceRequest = null;
    }

    protected UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        if (builder.getMutableConfig().retrieveOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, null) != null) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)35);
        } else {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)34);
        }
        return builder.getUseCaseConfig();
    }

    protected Size onSuggestedResolutionUpdated(Size size) {
        this.mSurfaceSize = size;
        this.updateConfigAndOutput(this.getCameraId(), (PreviewConfig)this.getCurrentConfig(), this.mSurfaceSize);
        return size;
    }

    public void setSurfaceProvider(SurfaceProvider surfaceProvider) {
        this.setSurfaceProvider(DEFAULT_SURFACE_PROVIDER_EXECUTOR, surfaceProvider);
    }

    public void setSurfaceProvider(Executor executor, SurfaceProvider surfaceProvider) {
        Threads.checkMainThread();
        if (surfaceProvider == null) {
            this.mSurfaceProvider = null;
            this.notifyInactive();
        } else {
            this.mSurfaceProvider = surfaceProvider;
            this.mSurfaceProviderExecutor = executor;
            this.notifyActive();
            if (this.mHasUnsentSurfaceRequest) {
                if (!this.sendSurfaceRequestIfReady()) return;
                this.sendTransformationInfoIfReady();
                this.mHasUnsentSurfaceRequest = false;
            } else {
                if (this.getAttachedSurfaceResolution() == null) return;
                this.updateConfigAndOutput(this.getCameraId(), (PreviewConfig)this.getCurrentConfig(), this.getAttachedSurfaceResolution());
                this.notifyReset();
            }
        }
    }

    public void setTargetRotation(int n) {
        if (!this.setTargetRotationInternal(n)) return;
        this.sendTransformationInfoIfReady();
    }

    public void setViewPortCropRect(Rect rect) {
        super.setViewPortCropRect(rect);
        this.sendTransformationInfoIfReady();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Preview:");
        stringBuilder.append(this.getName());
        return stringBuilder.toString();
    }
}
