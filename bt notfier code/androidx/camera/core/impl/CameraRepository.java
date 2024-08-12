/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraUnavailableException
 *  androidx.camera.core.InitializationException
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraFactory
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl._$$Lambda$CameraRepository$GfCuwjwqCywAr4DgCn1JSOYgBEg
 *  androidx.camera.core.impl._$$Lambda$CameraRepository$vZy2hmnvCLGH5kuV__iaqXOZ0ng
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl._$;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    private final Map<String, CameraInternal> mCameras;
    private final Object mCamerasLock = new Object();
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;
    private ListenableFuture<Void> mDeinitFuture;
    private final Set<CameraInternal> mReleasingCameras;

    public CameraRepository() {
        this.mCameras = new LinkedHashMap<String, CameraInternal>();
        this.mReleasingCameras = new HashSet<CameraInternal>();
    }

    public ListenableFuture<Void> deinit() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            try {
                if (this.mCameras.isEmpty()) {
                    ListenableFuture<Void> listenableFuture = this.mDeinitFuture == null ? Futures.immediateFuture(null) : this.mDeinitFuture;
                    return listenableFuture;
                }
                Object object2 = this.mDeinitFuture;
                Object object3 = object2;
                if (object2 == null) {
                    object3 = new _$.Lambda.CameraRepository.GfCuwjwqCywAr4DgCn1JSOYgBEg(this);
                    this.mDeinitFuture = object3 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)object3);
                }
                this.mReleasingCameras.addAll(this.mCameras.values());
                object2 = this.mCameras.values().iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.mCameras.clear();
                        return object3;
                    }
                    CameraInternal cameraInternal = (CameraInternal)object2.next();
                    ListenableFuture listenableFuture = cameraInternal.release();
                    _$.Lambda.CameraRepository.vZy2hmnvCLGH5kuV__iaqXOZ0ng vZy2hmnvCLGH5kuV__iaqXOZ0ng2 = new _$.Lambda.CameraRepository.vZy2hmnvCLGH5kuV__iaqXOZ0ng(this, cameraInternal);
                    listenableFuture.addListener((Runnable)vZy2hmnvCLGH5kuV__iaqXOZ0ng2, CameraXExecutors.directExecutor());
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public CameraInternal getCamera(String string) {
        Object object = this.mCamerasLock;
        synchronized (object) {
            Object object2 = this.mCameras.get(string);
            if (object2 != null) {
                return object2;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid camera: ");
            ((StringBuilder)object2).append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(((StringBuilder)object2).toString());
            throw illegalArgumentException;
        }
    }

    Set<String> getCameraIds() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(this.mCameras.keySet());
            return linkedHashSet;
        }
    }

    public LinkedHashSet<CameraInternal> getCameras() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            LinkedHashSet<CameraInternal> linkedHashSet = new LinkedHashSet<CameraInternal>(this.mCameras.values());
            return linkedHashSet;
        }
    }

    public void init(CameraFactory cameraFactory) throws InitializationException {
        Throwable throwable2;
        Object object = this.mCamerasLock;
        synchronized (object) {
            try {
                try {
                    Iterator iterator = cameraFactory.getAvailableCameraIds().iterator();
                    while (iterator.hasNext()) {
                        String string = (String)iterator.next();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Added camera: ");
                        stringBuilder.append(string);
                        Logger.d((String)TAG, (String)stringBuilder.toString());
                        this.mCameras.put(string, cameraFactory.getCamera(string));
                    }
                    return;
                }
                catch (CameraUnavailableException cameraUnavailableException) {
                    cameraFactory = new InitializationException((Throwable)cameraUnavailableException);
                    throw cameraFactory;
                }
            }
            catch (Throwable throwable2) {}
        }
        throw throwable2;
    }

    public /* synthetic */ Object lambda$deinit$0$CameraRepository(CallbackToFutureAdapter.Completer completer) throws Exception {
        Object object = this.mCamerasLock;
        synchronized (object) {
            this.mDeinitCompleter = completer;
            return "CameraRepository-deinit";
        }
    }

    public /* synthetic */ void lambda$deinit$1$CameraRepository(CameraInternal cameraInternal) {
        Object object = this.mCamerasLock;
        synchronized (object) {
            this.mReleasingCameras.remove(cameraInternal);
            if (!this.mReleasingCameras.isEmpty()) return;
            Preconditions.checkNotNull(this.mDeinitCompleter);
            this.mDeinitCompleter.set(null);
            this.mDeinitCompleter = null;
            this.mDeinitFuture = null;
            return;
        }
    }
}
