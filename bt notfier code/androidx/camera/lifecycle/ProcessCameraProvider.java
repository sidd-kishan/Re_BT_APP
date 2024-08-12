/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.CameraInfoUnavailableException
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.CameraSelector$Builder
 *  androidx.camera.core.CameraX
 *  androidx.camera.core.CameraXConfig
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCaseGroup
 *  androidx.camera.core.ViewPort
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.core.internal.CameraUseCaseAdapter
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraId
 *  androidx.camera.lifecycle.LifecycleCamera
 *  androidx.camera.lifecycle.LifecycleCameraProvider
 *  androidx.camera.lifecycle.LifecycleCameraRepository
 *  androidx.camera.lifecycle._$$Lambda$ProcessCameraProvider$TYjfluwv4_m1lcHTHHt4JLTu5vc
 *  androidx.core.util.Preconditions
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraProvider;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.camera.lifecycle._$;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Executor;

public final class ProcessCameraProvider
implements LifecycleCameraProvider {
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private CameraX mCameraX;
    private final LifecycleCameraRepository mLifecycleCameraRepository = new LifecycleCameraRepository();

    private ProcessCameraProvider() {
    }

    public static void configureInstance(CameraXConfig cameraXConfig) {
        CameraX.configureInstance((CameraXConfig)cameraXConfig);
    }

    public static ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
        Preconditions.checkNotNull((Object)context);
        return Futures.transform((ListenableFuture)CameraX.getOrCreateInstance((Context)context), (Function)_$.Lambda.ProcessCameraProvider.TYjfluwv4_m1lcHTHHt4JLTu5vc.INSTANCE, (Executor)CameraXExecutors.directExecutor());
    }

    static /* synthetic */ ProcessCameraProvider lambda$getInstance$0(CameraX cameraX) {
        sAppInstance.setCameraX(cameraX);
        return sAppInstance;
    }

    private void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        return this.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup.getViewPort(), useCaseGroup.getUseCases().toArray(new UseCase[0]));
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector object, ViewPort viewPort, UseCase ... useCaseArray) {
        Object object2;
        int n;
        Threads.checkMainThread();
        object = CameraSelector.Builder.fromSelector((CameraSelector)object);
        int n2 = useCaseArray.length;
        for (n = 0; n < n2; ++n) {
            object2 = useCaseArray[n].getCurrentConfig().getCameraSelector(null);
            if (object2 == null) continue;
            object2 = object2.getCameraFilterSet().iterator();
            while (object2.hasNext()) {
                object.addCameraFilter((CameraFilter)object2.next());
            }
        }
        LinkedHashSet linkedHashSet = object.build().filter(this.mCameraX.getCameraRepository().getCameras());
        object = CameraUseCaseAdapter.generateCameraId((LinkedHashSet)linkedHashSet);
        object2 = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, (CameraUseCaseAdapter.CameraId)object);
        Collection collection = this.mLifecycleCameraRepository.getLifecycleCameras();
        n2 = useCaseArray.length;
        for (n = 0; n < n2; ++n) {
            object = useCaseArray[n];
            for (LifecycleCamera lifecycleCamera : collection) {
                if (!lifecycleCamera.isBound((UseCase)object) || lifecycleCamera == object2) continue;
                throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", object));
            }
        }
        object = object2;
        if (object2 == null) {
            object = this.mLifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(linkedHashSet, this.mCameraX.getCameraDeviceSurfaceManager(), this.mCameraX.getDefaultConfigFactory()));
        }
        if (useCaseArray.length == 0) {
            return object;
        }
        this.mLifecycleCameraRepository.bindToLifecycleCamera((LifecycleCamera)object, viewPort, Arrays.asList(useCaseArray));
        return object;
    }

    public Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase ... useCaseArray) {
        return this.bindToLifecycle(lifecycleOwner, cameraSelector, (ViewPort)null, useCaseArray);
    }

    public List<CameraInfo> getAvailableCameraInfos() {
        ArrayList<CameraInfo> arrayList = new ArrayList<CameraInfo>();
        Iterator iterator = this.mCameraX.getCameraRepository().getCameras().iterator();
        while (iterator.hasNext()) {
            arrayList.add(((CameraInternal)iterator.next()).getCameraInfo());
        }
        return arrayList;
    }

    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        try {
            cameraSelector.select(this.mCameraX.getCameraRepository().getCameras());
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    public boolean isBound(UseCase useCase) {
        Iterator iterator = this.mLifecycleCameraRepository.getLifecycleCameras().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!((LifecycleCamera)iterator.next()).isBound(useCase));
        return true;
    }

    public ListenableFuture<Void> shutdown() {
        this.mLifecycleCameraRepository.clear();
        return CameraX.shutdown();
    }

    public void unbind(UseCase ... useCaseArray) {
        Threads.checkMainThread();
        this.mLifecycleCameraRepository.unbind(Arrays.asList(useCaseArray));
    }

    public void unbindAll() {
        Threads.checkMainThread();
        this.mLifecycleCameraRepository.unbindAll();
    }
}
