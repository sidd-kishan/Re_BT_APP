/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.core.SurfaceRequest$TransformationInfoListener
 *  androidx.camera.core._$$Lambda$SurfaceRequest$1B_FEIX2iizhnKAclUlsKNJ3zuM
 *  androidx.camera.core._$$Lambda$SurfaceRequest$YU28NjaJOhNpkHKgiHkeDk9hezs
 *  androidx.camera.core._$$Lambda$SurfaceRequest$aC9bT1pfUxuJxiP2CHR2nby0fcw
 *  androidx.camera.core._$$Lambda$SurfaceRequest$izJhW7Kwab2vgiWRDUyBSJPuRwo
 *  androidx.camera.core._$$Lambda$SurfaceRequest$lsWJpXa9sk3H6fbWQnQgT7mjPt0
 *  androidx.camera.core._$$Lambda$SurfaceRequest$ngtA0g5dJH3w7teLIgUUOnvVWD4
 *  androidx.camera.core._$$Lambda$SurfaceRequest$odG17THPHlbCF8n40ySxsMVBMjU
 *  androidx.camera.core._$$Lambda$SurfaceRequest$sEXLWXS66apbUecgY06U3wMjup4
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.DeferrableSurface
 *  androidx.camera.core.impl.DeferrableSurface$SurfaceUnavailableException
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Consumer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core._$;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis ignored.
 */
public final class SurfaceRequest {
    private final CameraInternal mCamera;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final boolean mRGBA8888Required;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final ListenableFuture<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final ListenableFuture<Surface> mSurfaceFuture;
    private TransformationInfo mTransformationInfo;
    private Executor mTransformationInfoExecutor;
    private TransformationInfoListener mTransformationInfoListener;

    public SurfaceRequest(Size object, CameraInternal object2, boolean bl) {
        ListenableFuture listenableFuture;
        this.mResolution = object;
        this.mCamera = object2;
        this.mRGBA8888Required = bl;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("SurfaceRequest[size: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", id: ");
        ((StringBuilder)object2).append(this.hashCode());
        ((StringBuilder)object2).append("]");
        object = ((StringBuilder)object2).toString();
        Object object3 = new AtomicReference(null);
        object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.SurfaceRequest.odG17THPHlbCF8n40ySxsMVBMjU(object3, (String)object));
        object3 = (CallbackToFutureAdapter.Completer)Preconditions.checkNotNull((Object)((AtomicReference)object3).get());
        this.mRequestCancellationCompleter = object3;
        AtomicReference<Object> atomicReference = new AtomicReference<Object>(null);
        this.mSessionStatusFuture = listenableFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.SurfaceRequest.sEXLWXS66apbUecgY06U3wMjup4(atomicReference, (String)object));
        Futures.addCallback((ListenableFuture)listenableFuture, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
        object2 = (CallbackToFutureAdapter.Completer)Preconditions.checkNotNull((Object)atomicReference.get());
        object3 = new AtomicReference<Object>(null);
        this.mSurfaceFuture = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.SurfaceRequest.izJhW7Kwab2vgiWRDUyBSJPuRwo((AtomicReference)object3, (String)object));
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer)Preconditions.checkNotNull((Object)((CallbackToFutureAdapter.Completer)((AtomicReference)object3).get()));
        object3 = new /* Unavailable Anonymous Inner Class!! */;
        this.mInternalDeferrableSurface = object3;
        object3 = object3.getTerminationFuture();
        Futures.addCallback(this.mSurfaceFuture, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
        object3.addListener((Runnable)new _$.Lambda.SurfaceRequest.ngtA0g5dJH3w7teLIgUUOnvVWD4(this), CameraXExecutors.directExecutor());
    }

    static /* synthetic */ Object lambda$new$0(AtomicReference serializable, String string, CallbackToFutureAdapter.Completer completer) throws Exception {
        ((AtomicReference)serializable).set(completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("-cancellation");
        return ((StringBuilder)serializable).toString();
    }

    static /* synthetic */ Object lambda$new$1(AtomicReference serializable, String string, CallbackToFutureAdapter.Completer completer) throws Exception {
        ((AtomicReference)serializable).set(completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("-status");
        return ((StringBuilder)serializable).toString();
    }

    static /* synthetic */ Object lambda$new$2(AtomicReference serializable, String string, CallbackToFutureAdapter.Completer completer) throws Exception {
        ((AtomicReference)serializable).set(completer);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("-Surface");
        return ((StringBuilder)serializable).toString();
    }

    static /* synthetic */ void lambda$provideSurface$4(Consumer consumer, Surface surface) {
        consumer.accept((Object)Result.of((int)3, (Surface)surface));
    }

    static /* synthetic */ void lambda$provideSurface$5(Consumer consumer, Surface surface) {
        consumer.accept((Object)Result.of((int)4, (Surface)surface));
    }

    static /* synthetic */ void lambda$setTransformationInfoListener$7(TransformationInfoListener transformationInfoListener, TransformationInfo transformationInfo) {
        transformationInfoListener.onTransformationInfoUpdate(transformationInfo);
    }

    static /* synthetic */ void lambda$updateTransformationInfo$6(TransformationInfoListener transformationInfoListener, TransformationInfo transformationInfo) {
        transformationInfoListener.onTransformationInfoUpdate(transformationInfo);
    }

    public void addRequestCancellationListener(Executor executor, Runnable runnable) {
        this.mRequestCancellationCompleter.addCancellationListener(runnable, executor);
    }

    public void clearTransformationInfoListener() {
        this.mTransformationInfoListener = null;
        this.mTransformationInfoExecutor = null;
    }

    public CameraInternal getCamera() {
        return this.mCamera;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    public boolean isRGBA8888Required() {
        return this.mRGBA8888Required;
    }

    public /* synthetic */ void lambda$new$3$SurfaceRequest() {
        this.mSurfaceFuture.cancel(true);
    }

    public void provideSurface(Surface surface, Executor executor, Consumer<Result> consumer) {
        if (!this.mSurfaceCompleter.set((Object)surface) && !this.mSurfaceFuture.isCancelled()) {
            Preconditions.checkState((boolean)this.mSurfaceFuture.isDone());
            try {
                this.mSurfaceFuture.get();
                _$.Lambda.SurfaceRequest.aC9bT1pfUxuJxiP2CHR2nby0fcw aC9bT1pfUxuJxiP2CHR2nby0fcw2 = new _$.Lambda.SurfaceRequest.aC9bT1pfUxuJxiP2CHR2nby0fcw(consumer, surface);
                executor.execute((Runnable)aC9bT1pfUxuJxiP2CHR2nby0fcw2);
            }
            catch (InterruptedException | ExecutionException exception) {
                executor.execute((Runnable)new _$.Lambda.SurfaceRequest.1B_FEIX2iizhnKAclUlsKNJ3zuM(consumer, surface));
            }
        } else {
            Futures.addCallback(this.mSessionStatusFuture, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)executor);
        }
    }

    public void setTransformationInfoListener(Executor executor, TransformationInfoListener transformationInfoListener) {
        this.mTransformationInfoListener = transformationInfoListener;
        this.mTransformationInfoExecutor = executor;
        TransformationInfo transformationInfo = this.mTransformationInfo;
        if (transformationInfo == null) return;
        executor.execute((Runnable)new _$.Lambda.SurfaceRequest.lsWJpXa9sk3H6fbWQnQgT7mjPt0(transformationInfoListener, transformationInfo));
    }

    public void updateTransformationInfo(TransformationInfo transformationInfo) {
        this.mTransformationInfo = transformationInfo;
        TransformationInfoListener transformationInfoListener = this.mTransformationInfoListener;
        if (transformationInfoListener == null) return;
        this.mTransformationInfoExecutor.execute((Runnable)new _$.Lambda.SurfaceRequest.YU28NjaJOhNpkHKgiHkeDk9hezs(transformationInfoListener, transformationInfo));
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException((Throwable)new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }
}
