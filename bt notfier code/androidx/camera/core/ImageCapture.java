/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.Log
 *  android.util.Rational
 *  android.util.Size
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.CameraClosedException
 *  androidx.camera.core.CaptureBundles
 *  androidx.camera.core.CaptureProcessorPipeline
 *  androidx.camera.core.ImageCapture$Builder
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker
 *  androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker
 *  androidx.camera.core.ImageCapture$CaptureFailedException
 *  androidx.camera.core.ImageCapture$Defaults
 *  androidx.camera.core.ImageCapture$ImageCaptureRequest
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor
 *  androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.ImageCapture$TakePictureState
 *  androidx.camera.core.ImageCaptureException
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MetadataImageReader
 *  androidx.camera.core.ProcessingImageReader
 *  androidx.camera.core.SafeCloseImageReaderProxy
 *  androidx.camera.core.UseCase
 *  androidx.camera.core._$$Lambda$ImageCapture$2B91NcXQyr59NDscigcxsZb94mc
 *  androidx.camera.core._$$Lambda$ImageCapture$2_TxPNzHOcVqstis6XB6DYcuHfk
 *  androidx.camera.core._$$Lambda$ImageCapture$9NeJjlGj1l0wJ4jfJNWwt1DkA3s
 *  androidx.camera.core._$$Lambda$ImageCapture$DqjPQEkFz9L9Jvyv3SBJHIasGzQ
 *  androidx.camera.core._$$Lambda$ImageCapture$GEenEcxZ7MUcWJ3KQGleDsVFVdQ
 *  androidx.camera.core._$$Lambda$ImageCapture$GeHlALlHFv1WxWIIQxPTXHlEbSo
 *  androidx.camera.core._$$Lambda$ImageCapture$LpgzdauR0iq_2ijVwWwzEkD4t_k
 *  androidx.camera.core._$$Lambda$ImageCapture$NfkIyUUNF6TQcVvDSGDDBPf204o
 *  androidx.camera.core._$$Lambda$ImageCapture$QYjuQos4r7KQ3WnWA68DUS3Y9Zo
 *  androidx.camera.core._$$Lambda$ImageCapture$QoVG5slEUa31RRxy1FnwjcCeJx8
 *  androidx.camera.core._$$Lambda$ImageCapture$W4g17ZQWrYwqNU1YgXV6cLIPxGw
 *  androidx.camera.core._$$Lambda$ImageCapture$Wt1TovyCuiGs1Jjb3Lz19xrnOjg
 *  androidx.camera.core._$$Lambda$ImageCapture$ZwpMLqCr2U9t8PY1QTzAwfLPaTE
 *  androidx.camera.core._$$Lambda$ImageCapture$_MbcjLnO0JEbrFw7tB0q1uSNwrI
 *  androidx.camera.core._$$Lambda$ImageCapture$_NPEX6f_pK2w8zMZHH6SI_c_xrU
 *  androidx.camera.core._$$Lambda$ImageCapture$gDTOLCYzy2SGRtJgJGUBEedUxDU
 *  androidx.camera.core._$$Lambda$ImageCapture$krFF_M7LPhv7YZAVeh738KTXgGg
 *  androidx.camera.core._$$Lambda$ImageCapture$qxiP_lEMHbynOHrJ3C0Tk0bLYJQ
 *  androidx.camera.core._$$Lambda$ImageCapture$s15kWxyb0irUJ4Kjm96oHrpvB3E
 *  androidx.camera.core._$$Lambda$ImageCapture$s_1as3Eacj1lPWaU67XyHl9xer8
 *  androidx.camera.core._$$Lambda$ImageCapture$zkT1tNl5mK3A6lQ0dD_iPwhWq9c
 *  androidx.camera.core._$$Lambda$kBKr_WXSgibOrSk3AWcyOrTIBI0
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureMetaData$AeState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfMode
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AwbState
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CameraControlInternal
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.CaptureBundle
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$_CC
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.ImageCaptureConfig
 *  androidx.camera.core.impl.ImageInputConfig
 *  androidx.camera.core.impl.ImageReaderProxy
 *  androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener
 *  androidx.camera.core.impl.ImmediateSurface
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$Builder
 *  androidx.camera.core.impl.SessionConfig$ErrorListener
 *  androidx.camera.core.impl.SessionConfig$SessionError
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.UseCaseConfigFactory$CaptureType
 *  androidx.camera.core.impl.utils.CameraOrientationUtil
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.FutureChain
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.core.internal.YuvToJpegProcessor
 *  androidx.camera.core.internal.compat.quirk.DeviceQuirks
 *  androidx.camera.core.internal.compat.quirk.ImageCaptureWashedOutImageQuirk
 *  androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk
 *  androidx.camera.core.internal.compat.workaround.ExifRotationAvailability
 *  androidx.camera.core.internal.utils.ImageUtil
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Rational;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraClosedException;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.CaptureProcessorPipeline;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.UseCase;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis ignored.
 */
public final class ImageCapture
extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    private static final long CHECK_3A_TIMEOUT_IN_MS = 1000L;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    private static final int FLASH_MODE_UNKNOWN = -1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ImageCapture";
    private CaptureBundle mCaptureBundle;
    private CaptureConfig mCaptureConfig;
    private final int mCaptureMode;
    private CaptureProcessor mCaptureProcessor;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private Rational mCropAspectRatio = null;
    private DeferrableSurface mDeferrableSurface;
    private final boolean mEnableCheck3AConverged;
    private ExecutorService mExecutor;
    private int mFlashMode = -1;
    private ImageCaptureRequestProcessor mImageCaptureRequestProcessor;
    SafeCloseImageReaderProxy mImageReader;
    final Executor mIoExecutor;
    private final AtomicReference<Integer> mLockedFlashMode;
    private int mMaxCaptureStages;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    ProcessingImageReader mProcessingImageReader;
    final Executor mSequentialIoExecutor;
    private final CaptureCallbackChecker mSessionCallbackChecker = new CaptureCallbackChecker();
    SessionConfig.Builder mSessionConfigBuilder;
    private boolean mUseSoftwareJpeg;
    private final boolean mUseTorchFlash;

    ImageCapture(ImageCaptureConfig object) {
        super((UseCaseConfig)object);
        this.mClosingListener = _$.Lambda.ImageCapture._NPEX6f_pK2w8zMZHH6SI_c_xrU.INSTANCE;
        this.mLockedFlashMode = new AtomicReference<Object>(null);
        boolean bl = false;
        this.mUseSoftwareJpeg = false;
        object = (ImageCaptureConfig)this.getCurrentConfig();
        this.mCaptureMode = object.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE) ? object.getCaptureMode() : 1;
        object = (Executor)Preconditions.checkNotNull((Object)object.getIoExecutor(CameraXExecutors.ioExecutor()));
        this.mIoExecutor = object;
        this.mSequentialIoExecutor = CameraXExecutors.newSequentialExecutor((Executor)object);
        this.mEnableCheck3AConverged = this.mCaptureMode == 0;
        if (DeviceQuirks.get(ImageCaptureWashedOutImageQuirk.class) != null) {
            bl = true;
        }
        this.mUseTorchFlash = bl;
        if (!bl) return;
        Logger.d((String)"ImageCapture", (String)"Open and close torch to replace the flash fired by flash mode.");
    }

    private void abortImageCaptureRequests() {
        CameraClosedException cameraClosedException = new CameraClosedException("Camera is closed.");
        this.mImageCaptureRequestProcessor.cancelRequests((Throwable)cameraClosedException);
    }

    private void closeTorch(TakePictureState takePictureState) {
        if (!takePictureState.mIsTorchOpened) return;
        CameraControlInternal cameraControlInternal = this.getCameraControl();
        takePictureState.mIsTorchOpened = false;
        cameraControlInternal.enableTorch(false).addListener((Runnable)_$.Lambda.ImageCapture.DqjPQEkFz9L9Jvyv3SBJHIasGzQ.INSTANCE, CameraXExecutors.directExecutor());
    }

    static boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        Object object = ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER;
        boolean bl = false;
        boolean bl2 = false;
        Boolean bl3 = false;
        if ((Boolean)mutableConfig.retrieveOption((Config.Option)object, (Object)bl3) == false) return bl;
        boolean bl4 = true;
        if (Build.VERSION.SDK_INT < 26) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Software JPEG only supported on API 26+, but current API level is ");
            ((StringBuilder)object).append(Build.VERSION.SDK_INT);
            Logger.w((String)"ImageCapture", (String)((StringBuilder)object).toString());
            bl4 = false;
        }
        if ((object = (Integer)mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null)) != null && (Integer)object != 256) {
            Logger.w((String)"ImageCapture", (String)"Software JPEG cannot be used with non-JPEG output buffer format.");
            bl4 = bl2;
        }
        bl = bl4;
        if (bl4) return bl;
        Logger.w((String)"ImageCapture", (String)"Unable to support software JPEG. Disabling.");
        mutableConfig.insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, (Object)bl3);
        bl = bl4;
        return bl;
    }

    private CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        List list = this.mCaptureBundle.getCaptureStages();
        CaptureBundle captureBundle2 = captureBundle;
        if (list == null) return captureBundle2;
        captureBundle2 = list.isEmpty() ? captureBundle : CaptureBundles.createCaptureBundle((List)list);
        return captureBundle2;
    }

    static int getError(Throwable throwable) {
        if (throwable instanceof CameraClosedException) {
            return 3;
        }
        if (!(throwable instanceof CaptureFailedException)) return 0;
        return 2;
    }

    private int getJpegQuality() {
        int n = this.mCaptureMode;
        if (n == 0) return 100;
        if (n == 1) {
            return 95;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CaptureMode ");
        stringBuilder.append(this.mCaptureMode);
        stringBuilder.append(" is invalid");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private ListenableFuture<CameraCaptureResult> getPreCaptureStateIfNeeded() {
        if (this.mEnableCheck3AConverged) return this.mSessionCallbackChecker.checkCaptureResult((CaptureCallbackChecker.CaptureResultChecker)new /* Unavailable Anonymous Inner Class!! */);
        if (this.getFlashMode() != 0) return Futures.immediateFuture(null);
        return this.mSessionCallbackChecker.checkCaptureResult((CaptureCallbackChecker.CaptureResultChecker)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void lambda$closeTorch$16() {
    }

    static /* synthetic */ void lambda$createPipeline$1(YuvToJpegProcessor yuvToJpegProcessor, CaptureProcessorPipeline captureProcessorPipeline) {
        if (Build.VERSION.SDK_INT < 26) return;
        yuvToJpegProcessor.close();
        captureProcessorPipeline.close();
    }

    static /* synthetic */ Void lambda$issueTakePicture$20(List list) {
        return null;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void lambda$new$0(ImageReaderProxy object) {
        ImageProxy imageProxy = object.acquireLatestImage();
        object = new StringBuilder();
        ((StringBuilder)object).append("Discarding ImageProxy which was inadvertently acquired: ");
        ((StringBuilder)object).append(imageProxy);
        Log.d((String)"ImageCapture", (String)((StringBuilder)object).toString());
        if (imageProxy == null) return;
        imageProxy.close();
        return;
        catch (Throwable throwable) {
            if (imageProxy == null) throw throwable;
            try {
                imageProxy.close();
                throw throwable;
            }
            catch (Throwable throwable2) {
                try {
                    throwable.addSuppressed(throwable2);
                    throw throwable;
                }
                catch (IllegalStateException illegalStateException) {
                    Log.e((String)"ImageCapture", (String)"Failed to acquire latest image.", (Throwable)illegalStateException);
                }
            }
        }
    }

    static /* synthetic */ void lambda$openTorch$14(CallbackToFutureAdapter.Completer completer) {
        completer.set(null);
    }

    static /* synthetic */ Void lambda$preTakePicture$13(Boolean bl) {
        return null;
    }

    static /* synthetic */ void lambda$takePictureInternal$7(CallbackToFutureAdapter.Completer completer, ImageReaderProxy object) {
        try {
            object = object.acquireLatestImage();
            if (object != null) {
                if (completer.set(object)) return;
                object.close();
            } else {
                object = new IllegalStateException("Unable to acquire image");
                completer.setException((Throwable)object);
            }
        }
        catch (IllegalStateException illegalStateException) {
            completer.setException((Throwable)illegalStateException);
        }
    }

    static /* synthetic */ void lambda$takePictureInternal$9(ListenableFuture listenableFuture) {
        listenableFuture.cancel(true);
    }

    static /* synthetic */ Void lambda$triggerAePrecapture$18(CameraCaptureResult cameraCaptureResult) {
        return null;
    }

    static /* synthetic */ void lambda$triggerAf$17() {
    }

    private void lockFlashMode() {
        AtomicReference<Integer> atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            if (this.mLockedFlashMode.get() != null) {
                return;
            }
            this.mLockedFlashMode.set(this.getFlashMode());
            return;
        }
    }

    private ListenableFuture<Void> openTorch(TakePictureState takePictureState) {
        CameraInternal cameraInternal = this.getCamera();
        if (cameraInternal != null && (Integer)cameraInternal.getCameraInfo().getTorchState().getValue() == 1) {
            return Futures.immediateFuture(null);
        }
        Logger.d((String)"ImageCapture", (String)"openTorch");
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageCapture.LpgzdauR0iq_2ijVwWwzEkD4t_k(this, takePictureState));
    }

    private ListenableFuture<Void> preTakePicture(TakePictureState takePictureState) {
        this.lockFlashMode();
        return FutureChain.from(this.getPreCaptureStateIfNeeded()).transformAsync((AsyncFunction)new _$.Lambda.ImageCapture.qxiP_lEMHbynOHrJ3C0Tk0bLYJQ(this, takePictureState), (Executor)this.mExecutor).transformAsync((AsyncFunction)new _$.Lambda.ImageCapture.Wt1TovyCuiGs1Jjb3Lz19xrnOjg(this, takePictureState), (Executor)this.mExecutor).transform((Function)_$.Lambda.ImageCapture.9NeJjlGj1l0wJ4jfJNWwt1DkA3s.INSTANCE, (Executor)this.mExecutor);
    }

    private void sendImageCaptureRequest(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        CameraInternal cameraInternal = this.getCamera();
        if (cameraInternal == null) {
            executor.execute((Runnable)new _$.Lambda.ImageCapture.2B91NcXQyr59NDscigcxsZb94mc(this, onImageCapturedCallback));
            return;
        }
        this.mImageCaptureRequestProcessor.sendRequest(new ImageCaptureRequest(this.getRelativeRotation(cameraInternal), this.getJpegQuality(), this.mCropAspectRatio, this.getViewPortCropRect(), executor, onImageCapturedCallback));
    }

    private ListenableFuture<ImageProxy> takePictureInternal(ImageCaptureRequest imageCaptureRequest) {
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageCapture._MbcjLnO0JEbrFw7tB0q1uSNwrI(this, imageCaptureRequest));
    }

    private void triggerAf(TakePictureState takePictureState) {
        Logger.d((String)"ImageCapture", (String)"triggerAf");
        takePictureState.mIsAfTriggered = true;
        this.getCameraControl().triggerAf().addListener((Runnable)_$.Lambda.ImageCapture.GEenEcxZ7MUcWJ3KQGleDsVFVdQ.INSTANCE, CameraXExecutors.directExecutor());
    }

    private void trySetFlashModeToCameraControl() {
        AtomicReference<Integer> atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            if (this.mLockedFlashMode.get() != null) {
                return;
            }
            this.getCameraControl().setFlashMode(this.getFlashMode());
            return;
        }
    }

    private void unlockFlashMode() {
        AtomicReference<Integer> atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            Integer n = this.mLockedFlashMode.getAndSet(null);
            if (n == null) {
                return;
            }
            if (n.intValue() == this.getFlashMode()) return;
            this.trySetFlashModeToCameraControl();
            return;
        }
    }

    void cancelAfAeTrigger(TakePictureState takePictureState) {
        if (!takePictureState.mIsAfTriggered && !takePictureState.mIsAePrecaptureTriggered) {
            return;
        }
        this.getCameraControl().cancelAfAeTrigger(takePictureState.mIsAfTriggered, takePictureState.mIsAePrecaptureTriggered);
        takePictureState.mIsAfTriggered = false;
        takePictureState.mIsAePrecaptureTriggered = false;
    }

    ListenableFuture<Boolean> check3AConverged(TakePictureState takePictureState) {
        boolean bl = this.mEnableCheck3AConverged;
        Boolean bl2 = false;
        if (bl) return this.mSessionCallbackChecker.checkCaptureResult((CaptureCallbackChecker.CaptureResultChecker)new /* Unavailable Anonymous Inner Class!! */, 1000L, (Object)bl2);
        if (takePictureState.mIsAePrecaptureTriggered) return this.mSessionCallbackChecker.checkCaptureResult((CaptureCallbackChecker.CaptureResultChecker)new /* Unavailable Anonymous Inner Class!! */, 1000L, (Object)bl2);
        if (takePictureState.mIsTorchOpened) return this.mSessionCallbackChecker.checkCaptureResult((CaptureCallbackChecker.CaptureResultChecker)new /* Unavailable Anonymous Inner Class!! */, 1000L, (Object)bl2);
        return Futures.immediateFuture((Object)bl2);
    }

    void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        this.mDeferrableSurface = null;
        this.mImageReader = null;
        this.mProcessingImageReader = null;
        if (deferrableSurface == null) return;
        deferrableSurface.close();
    }

    SessionConfig.Builder createPipeline(String string, ImageCaptureConfig imageCaptureConfig, Size size) {
        Object object;
        MetadataImageReader metadataImageReader;
        Threads.checkMainThread();
        SessionConfig.Builder builder = SessionConfig.Builder.createFrom((UseCaseConfig)imageCaptureConfig);
        builder.addRepeatingCameraCaptureCallback((CameraCaptureCallback)this.mSessionCallbackChecker);
        if (imageCaptureConfig.getImageReaderProxyProvider() != null) {
            this.mImageReader = new SafeCloseImageReaderProxy(imageCaptureConfig.getImageReaderProxyProvider().newInstance(size.getWidth(), size.getHeight(), this.getImageFormat(), 2, 0L));
            this.mMetadataMatchingCaptureCallback = new /* Unavailable Anonymous Inner Class!! */;
        } else if (this.mCaptureProcessor == null && !this.mUseSoftwareJpeg) {
            metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), this.getImageFormat(), 2);
            this.mMetadataMatchingCaptureCallback = metadataImageReader.getCameraCaptureCallback();
            this.mImageReader = new SafeCloseImageReaderProxy((ImageReaderProxy)metadataImageReader);
        } else {
            YuvToJpegProcessor yuvToJpegProcessor;
            CaptureProcessor captureProcessor = this.mCaptureProcessor;
            int n = this.getImageFormat();
            int n2 = this.getImageFormat();
            if (this.mUseSoftwareJpeg) {
                if (Build.VERSION.SDK_INT < 26) throw new IllegalStateException("Software JPEG only supported on API 26+");
                Logger.i((String)"ImageCapture", (String)"Using software JPEG encoder.");
                if (this.mCaptureProcessor != null) {
                    metadataImageReader = new YuvToJpegProcessor(this.getJpegQuality(), this.mMaxCaptureStages);
                    object = new CaptureProcessorPipeline(this.mCaptureProcessor, this.mMaxCaptureStages, (CaptureProcessor)metadataImageReader, (Executor)this.mExecutor);
                    yuvToJpegProcessor = object;
                } else {
                    yuvToJpegProcessor = new YuvToJpegProcessor(this.getJpegQuality(), this.mMaxCaptureStages);
                    object = null;
                    metadataImageReader = yuvToJpegProcessor;
                }
                captureProcessor = yuvToJpegProcessor;
                n2 = 256;
                yuvToJpegProcessor = metadataImageReader;
                metadataImageReader = object;
            } else {
                yuvToJpegProcessor = null;
                metadataImageReader = null;
            }
            object = new ProcessingImageReader(size.getWidth(), size.getHeight(), n, this.mMaxCaptureStages, (Executor)this.mExecutor, this.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle()), captureProcessor, n2);
            this.mProcessingImageReader = object;
            this.mMetadataMatchingCaptureCallback = object.getCameraCaptureCallback();
            this.mImageReader = new SafeCloseImageReaderProxy((ImageReaderProxy)this.mProcessingImageReader);
            if (yuvToJpegProcessor != null) {
                this.mProcessingImageReader.getCloseFuture().addListener((Runnable)new _$.Lambda.ImageCapture.GeHlALlHFv1WxWIIQxPTXHlEbSo(yuvToJpegProcessor, (CaptureProcessorPipeline)metadataImageReader), CameraXExecutors.directExecutor());
            }
        }
        this.mImageCaptureRequestProcessor = new ImageCaptureRequestProcessor(2, (ImageCaptureRequestProcessor.ImageCaptor)new _$.Lambda.ImageCapture.s_1as3Eacj1lPWaU67XyHl9xer8(this));
        this.mImageReader.setOnImageAvailableListener(this.mClosingListener, (Executor)CameraXExecutors.mainThreadExecutor());
        metadataImageReader = this.mImageReader;
        object = this.mDeferrableSurface;
        if (object != null) {
            object.close();
        }
        object = new ImmediateSurface(this.mImageReader.getSurface());
        this.mDeferrableSurface = object;
        object = object.getTerminationFuture();
        Objects.requireNonNull(metadataImageReader);
        object.addListener((Runnable)new _$.Lambda.kBKr_WXSgibOrSk3AWcyOrTIBI0((SafeCloseImageReaderProxy)metadataImageReader), CameraXExecutors.mainThreadExecutor());
        builder.addNonRepeatingSurface(this.mDeferrableSurface);
        builder.addErrorListener((SessionConfig.ErrorListener)new _$.Lambda.ImageCapture.krFF_M7LPhv7YZAVeh738KTXgGg(this, string, imageCaptureConfig, size));
        return builder;
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    public UseCaseConfig<?> getDefaultConfig(boolean bl, UseCaseConfigFactory object) {
        Config config = object.getConfig(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
        object = config;
        if (bl) {
            object = Config._CC.mergeConfigs((Config)config, (Config)DEFAULT_CONFIG.getConfig());
        }
        object = object == null ? null : this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        return object;
    }

    public int getFlashMode() {
        AtomicReference<Integer> atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            int n = this.mFlashMode != -1 ? this.mFlashMode : ((ImageCaptureConfig)this.getCurrentConfig()).getFlashMode(2);
            return n;
        }
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig((Config)config);
    }

    boolean is3AConverged(CameraCaptureResult cameraCaptureResult) {
        boolean bl = false;
        if (cameraCaptureResult == null) {
            return false;
        }
        boolean bl2 = cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
        boolean bl3 = cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.CONVERGED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.UNKNOWN;
        boolean bl4 = cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED || cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.UNKNOWN;
        boolean bl5 = bl;
        if (!bl2) return bl5;
        bl5 = bl;
        if (!bl3) return bl5;
        bl5 = bl;
        if (!bl4) return bl5;
        bl5 = true;
        return bl5;
    }

    boolean isFlashRequired(TakePictureState takePictureState) {
        int n = this.getFlashMode();
        boolean bl = false;
        if (n != 0) {
            if (n == 1) return true;
            if (n != 2) throw new AssertionError(this.getFlashMode());
            return false;
        }
        if (takePictureState.mPreCaptureState.getAeState() != CameraCaptureMetaData.AeState.FLASH_REQUIRED) return bl;
        bl = true;
        return bl;
    }

    ListenableFuture<Void> issueTakePicture(ImageCaptureRequest imageCaptureRequest) {
        String string;
        CaptureBundle captureBundle;
        Logger.d((String)"ImageCapture", (String)"issueTakePicture");
        ArrayList<ListenableFuture> arrayList = new ArrayList<ListenableFuture>();
        ArrayList arrayList2 = new ArrayList();
        if (this.mProcessingImageReader != null) {
            captureBundle = this.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle == null) {
                return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            if (this.mCaptureProcessor == null && captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("No CaptureProcessor can be found to process the images captured for multiple CaptureStages."));
            }
            if (captureBundle.getCaptureStages().size() > this.mMaxCaptureStages) {
                return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            this.mProcessingImageReader.setCaptureBundle(captureBundle);
            string = this.mProcessingImageReader.getTagBundleKey();
        } else {
            captureBundle = this.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
            string = null;
        }
        Iterator iterator = captureBundle.getCaptureStages().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.getCameraControl().submitCaptureRequests(arrayList2);
                return Futures.transform((ListenableFuture)Futures.allAsList(arrayList), (Function)_$.Lambda.ImageCapture.s15kWxyb0irUJ4Kjm96oHrpvB3E.INSTANCE, (Executor)CameraXExecutors.directExecutor());
            }
            CaptureStage captureStage = (CaptureStage)iterator.next();
            captureBundle = new CaptureConfig.Builder();
            captureBundle.setTemplateType(this.mCaptureConfig.getTemplateType());
            captureBundle.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            captureBundle.addAllCameraCaptureCallbacks((Collection)this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks());
            captureBundle.addSurface(this.mDeferrableSurface);
            if (new ExifRotationAvailability().isRotationOptionSupported()) {
                captureBundle.addImplementationOption(CaptureConfig.OPTION_ROTATION, (Object)imageCaptureRequest.mRotationDegrees);
            }
            captureBundle.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, (Object)imageCaptureRequest.mJpegQuality);
            captureBundle.addImplementationOptions(captureStage.getCaptureConfig().getImplementationOptions());
            if (string != null) {
                captureBundle.addTag(string, Integer.valueOf(captureStage.getId()));
            }
            captureBundle.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
            arrayList.add(CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.ImageCapture.QYjuQos4r7KQ3WnWA68DUS3Y9Zo(this, (CaptureConfig.Builder)captureBundle, arrayList2, captureStage)));
        }
    }

    public /* synthetic */ ListenableFuture lambda$createPipeline$2$ImageCapture(ImageCaptureRequest imageCaptureRequest) {
        return this.takePictureInternal(imageCaptureRequest);
    }

    public /* synthetic */ void lambda$createPipeline$3$ImageCapture(String string, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.clearPipeline();
        if (!this.isCurrentCamera(string)) return;
        string = this.createPipeline(string, imageCaptureConfig, size);
        this.mSessionConfigBuilder = string;
        this.updateSessionConfig(string.build());
        this.notifyReset();
    }

    public /* synthetic */ Object lambda$issueTakePicture$19$ImageCapture(CaptureConfig.Builder object, List list, CaptureStage captureStage, CallbackToFutureAdapter.Completer completer) throws Exception {
        object.addCameraCaptureCallback((CameraCaptureCallback)new /* Unavailable Anonymous Inner Class!! */);
        list.add(object.build());
        object = new StringBuilder();
        ((StringBuilder)object).append("issueTakePicture[stage=");
        ((StringBuilder)object).append(captureStage.getId());
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public /* synthetic */ Object lambda$openTorch$15$ImageCapture(TakePictureState takePictureState, CallbackToFutureAdapter.Completer completer) throws Exception {
        CameraControlInternal cameraControlInternal = this.getCameraControl();
        takePictureState.mIsTorchOpened = true;
        cameraControlInternal.enableTorch(true).addListener((Runnable)new _$.Lambda.ImageCapture.NfkIyUUNF6TQcVvDSGDDBPf204o(completer), CameraXExecutors.directExecutor());
        return "openTorch";
    }

    public /* synthetic */ ListenableFuture lambda$preTakePicture$11$ImageCapture(TakePictureState takePictureState, CameraCaptureResult cameraCaptureResult) throws Exception {
        takePictureState.mPreCaptureState = cameraCaptureResult;
        this.triggerAfIfNeeded(takePictureState);
        if (!this.isFlashRequired(takePictureState)) return Futures.immediateFuture(null);
        if (!this.mUseTorchFlash) return this.triggerAePrecapture(takePictureState);
        return this.openTorch(takePictureState);
    }

    public /* synthetic */ ListenableFuture lambda$preTakePicture$12$ImageCapture(TakePictureState takePictureState, Void void_) throws Exception {
        return this.check3AConverged(takePictureState);
    }

    public /* synthetic */ void lambda$sendImageCaptureRequest$6$ImageCapture(OnImageCapturedCallback onImageCapturedCallback) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not bound to a valid Camera [");
        stringBuilder.append((Object)this);
        stringBuilder.append("]");
        onImageCapturedCallback.onError(new ImageCaptureException(4, stringBuilder.toString(), null));
    }

    public /* synthetic */ void lambda$takePicture$4$ImageCapture(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        this.takePicture(executor, onImageCapturedCallback);
    }

    public /* synthetic */ void lambda$takePicture$5$ImageCapture(OutputFileOptions outputFileOptions, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        this.takePicture(outputFileOptions, executor, onImageSavedCallback);
    }

    public /* synthetic */ Object lambda$takePictureInternal$10$ImageCapture(ImageCaptureRequest imageCaptureRequest, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mImageReader.setOnImageAvailableListener((ImageReaderProxy.OnImageAvailableListener)new _$.Lambda.ImageCapture.zkT1tNl5mK3A6lQ0dD_iPwhWq9c(completer), (Executor)CameraXExecutors.mainThreadExecutor());
        TakePictureState takePictureState = new TakePictureState();
        imageCaptureRequest = FutureChain.from(this.preTakePicture(takePictureState)).transformAsync((AsyncFunction)new _$.Lambda.ImageCapture.QoVG5slEUa31RRxy1FnwjcCeJx8(this, imageCaptureRequest), (Executor)this.mExecutor);
        Futures.addCallback((ListenableFuture)imageCaptureRequest, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)this.mExecutor);
        completer.addCancellationListener((Runnable)new _$.Lambda.ImageCapture.W4g17ZQWrYwqNU1YgXV6cLIPxGw((ListenableFuture)imageCaptureRequest), CameraXExecutors.directExecutor());
        return "takePictureInternal";
    }

    public /* synthetic */ ListenableFuture lambda$takePictureInternal$8$ImageCapture(ImageCaptureRequest imageCaptureRequest, Void void_) throws Exception {
        return this.issueTakePicture(imageCaptureRequest);
    }

    public void onAttached() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig)this.getCurrentConfig();
        this.mCaptureConfig = CaptureConfig.Builder.createFrom((UseCaseConfig)imageCaptureConfig).build();
        this.mCaptureProcessor = imageCaptureConfig.getCaptureProcessor(null);
        this.mMaxCaptureStages = imageCaptureConfig.getMaxCaptureStages(2);
        this.mCaptureBundle = imageCaptureConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        this.mUseSoftwareJpeg = imageCaptureConfig.isSoftwareJpegEncoderRequested();
        this.mExecutor = Executors.newFixedThreadPool(1, (ThreadFactory)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected void onCameraControlReady() {
        this.trySetFlashModeToCameraControl();
    }

    public void onDetached() {
        this.abortImageCaptureRequests();
        this.clearPipeline();
        this.mUseSoftwareJpeg = false;
        this.mExecutor.shutdown();
    }

    protected UseCaseConfig<?> onMergeConfig(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) {
        boolean bl;
        Object object = builder.getUseCaseConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null);
        boolean bl2 = true;
        Boolean bl3 = true;
        if (object != null && Build.VERSION.SDK_INT >= 29) {
            Logger.i((String)"ImageCapture", (String)"Requesting software JPEG due to a CaptureProcessor is set.");
            builder.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, (Object)bl3);
        } else if (cameraInfoInternal.getCameraQuirks().contains(SoftwareJpegEncodingPreferredQuirk.class)) {
            if (!((Boolean)builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, (Object)bl3)).booleanValue()) {
                Logger.w((String)"ImageCapture", (String)"Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                Logger.i((String)"ImageCapture", (String)"Requesting software JPEG due to device quirk.");
                builder.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, (Object)bl3);
            }
        }
        boolean bl4 = ImageCapture.enforceSoftwareJpegConstraints(builder.getMutableConfig());
        object = (Integer)builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        int n = 35;
        if (object != null) {
            bl = builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) == null;
            Preconditions.checkArgument((boolean)bl, (Object)"Cannot set buffer format with CaptureProcessor defined.");
            cameraInfoInternal = builder.getMutableConfig();
            bl3 = ImageInputConfig.OPTION_INPUT_FORMAT;
            if (!bl4) {
                n = (Integer)object;
            }
            cameraInfoInternal.insertOption((Config.Option)bl3, (Object)n);
        } else if (builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) == null && !bl4) {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)256);
        } else {
            builder.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)35);
        }
        bl = (Integer)builder.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, (Object)2) >= 1 ? bl2 : false;
        Preconditions.checkArgument((boolean)bl, (Object)"Maximum outstanding image count must be at least 1");
        return builder.getUseCaseConfig();
    }

    public void onStateDetached() {
        this.abortImageCaptureRequests();
    }

    protected Size onSuggestedResolutionUpdated(Size size) {
        SessionConfig.Builder builder;
        this.mSessionConfigBuilder = builder = this.createPipeline(this.getCameraId(), (ImageCaptureConfig)this.getCurrentConfig(), size);
        this.updateSessionConfig(builder.build());
        this.notifyActive();
        return size;
    }

    void postTakePicture(TakePictureState takePictureState) {
        this.closeTorch(takePictureState);
        this.cancelAfAeTrigger(takePictureState);
        this.unlockFlashMode();
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    public void setFlashMode(int n) {
        if (n != 0 && n != 1 && n != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid flash mode: ");
            stringBuilder.append(n);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        AtomicReference<Integer> atomicReference = this.mLockedFlashMode;
        synchronized (atomicReference) {
            this.mFlashMode = n;
            this.trySetFlashModeToCameraControl();
            return;
        }
    }

    public void setTargetRotation(int n) {
        int n2 = this.getTargetRotation();
        if (!this.setTargetRotationInternal(n)) return;
        if (this.mCropAspectRatio == null) return;
        n2 = CameraOrientationUtil.surfaceRotationToDegrees((int)n2);
        this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio((int)Math.abs(CameraOrientationUtil.surfaceRotationToDegrees((int)n) - n2), (Rational)this.mCropAspectRatio);
    }

    public void takePicture(OutputFileOptions outputFileOptions, Executor executor, OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.ImageCapture.2_TxPNzHOcVqstis6XB6DYcuHfk(this, outputFileOptions, executor, onImageSavedCallback));
            return;
        }
        outputFileOptions = new /* Unavailable Anonymous Inner Class!! */;
        this.sendImageCaptureRequest(CameraXExecutors.mainThreadExecutor(), (OnImageCapturedCallback)outputFileOptions);
    }

    public void takePicture(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.ImageCapture.ZwpMLqCr2U9t8PY1QTzAwfLPaTE(this, executor, onImageCapturedCallback));
            return;
        }
        this.sendImageCaptureRequest(executor, onImageCapturedCallback);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageCapture:");
        stringBuilder.append(this.getName());
        return stringBuilder.toString();
    }

    ListenableFuture<Void> triggerAePrecapture(TakePictureState takePictureState) {
        Logger.d((String)"ImageCapture", (String)"triggerAePrecapture");
        takePictureState.mIsAePrecaptureTriggered = true;
        return Futures.transform((ListenableFuture)this.getCameraControl().triggerAePrecapture(), (Function)_$.Lambda.ImageCapture.gDTOLCYzy2SGRtJgJGUBEedUxDU.INSTANCE, (Executor)CameraXExecutors.directExecutor());
    }

    void triggerAfIfNeeded(TakePictureState takePictureState) {
        if (!this.mEnableCheck3AConverged) return;
        if (takePictureState.mPreCaptureState.getAfMode() != CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO) return;
        if (takePictureState.mPreCaptureState.getAfState() != CameraCaptureMetaData.AfState.INACTIVE) return;
        this.triggerAf(takePictureState);
    }
}
