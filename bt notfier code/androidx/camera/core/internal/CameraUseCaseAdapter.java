/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraControl
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.CameraSelector$Builder
 *  androidx.camera.core.Logger
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.ViewPort
 *  androidx.camera.core.impl.CameraConfig
 *  androidx.camera.core.impl.CameraConfigs
 *  androidx.camera.core.impl.CameraControlInternal
 *  androidx.camera.core.impl.CameraDeviceSurfaceManager
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.SurfaceConfig
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfigFactory
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraId
 *  androidx.camera.core.internal.CameraUseCaseAdapter$ConfigPair
 *  androidx.camera.core.internal.ViewPorts
 *  androidx.camera.core.internal._$$Lambda$CameraUseCaseAdapter$BePYo6_BuRj_bYHdBe4iuXmtjgI
 *  androidx.core.util.Consumer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.internal;

import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.internal.ViewPorts;
import androidx.camera.core.internal._$;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public final class CameraUseCaseAdapter
implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private boolean mAttached = true;
    private CameraConfig mCameraConfig;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;
    private Config mInteropConfig = null;
    private final Object mLock;
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private final List<UseCase> mUseCases = new ArrayList<UseCase>();
    private ViewPort mViewPort;

    public CameraUseCaseAdapter(LinkedHashSet<CameraInternal> linkedHashSet, CameraDeviceSurfaceManager cameraDeviceSurfaceManager, UseCaseConfigFactory useCaseConfigFactory) {
        this.mCameraConfig = CameraConfigs.emptyConfig();
        this.mLock = new Object();
        this.mCameraInternal = (CameraInternal)linkedHashSet.iterator().next();
        linkedHashSet = new LinkedHashSet<CameraInternal>(linkedHashSet);
        this.mCameraInternals = linkedHashSet;
        this.mId = new CameraId(linkedHashSet);
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
    }

    private void cacheInteropConfig() {
        Object object = this.mLock;
        synchronized (object) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
            return;
        }
    }

    private Map<UseCase, Size> calculateSuggestedResolutions(CameraInfoInternal object, List<UseCase> object2, List<UseCase> object3, Map<UseCase, ConfigPair> map) {
        UseCase useCase;
        ArrayList<SurfaceConfig> arrayList = new ArrayList<SurfaceConfig>();
        String string = object.getCameraId();
        HashMap<UseCase, Size> hashMap = new HashMap<UseCase, Size>();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            useCase = (UseCase)object3.next();
            arrayList.add(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(string, useCase.getImageFormat(), useCase.getAttachedSurfaceResolution()));
            hashMap.put(useCase, useCase.getAttachedSurfaceResolution());
        }
        if (object2.isEmpty()) return hashMap;
        object3 = new HashMap<UseCaseConfig, UseCase>();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            useCase = (UseCase)object2.next();
            ConfigPair configPair = map.get(useCase);
            object3.put(useCase.mergeConfigs((CameraInfoInternal)object, configPair.mExtendedConfig, configPair.mCameraConfig), useCase);
        }
        object = this.mCameraDeviceSurfaceManager.getSuggestedResolutions(string, arrayList, new ArrayList(object3.keySet()));
        object3 = object3.entrySet().iterator();
        while (object3.hasNext()) {
            object2 = (Map.Entry)object3.next();
            hashMap.put((UseCase)object2.getValue(), (Size)object.get(object2.getKey()));
        }
        return hashMap;
    }

    public static CameraId generateCameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private Map<UseCase, ConfigPair> getConfigs(List<UseCase> useCase, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap<UseCase, ConfigPair> hashMap = new HashMap<UseCase, ConfigPair>();
        Iterator<UseCase> iterator = useCase.iterator();
        while (iterator.hasNext()) {
            useCase = iterator.next();
            hashMap.put(useCase, new ConfigPair(useCase.getDefaultConfig(false, useCaseConfigFactory), useCase.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    static /* synthetic */ void lambda$notifyAttachedUseCasesChange$0(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Consumer consumer = ((UseCase)iterator.next()).getCurrentConfig().getAttachedUseCasesUpdateListener(null);
            if (consumer == null) continue;
            consumer.accept(Collections.unmodifiableList(list));
        }
    }

    private void notifyAttachedUseCasesChange(List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.CameraUseCaseAdapter.BePYo6_BuRj_bYHdBe4iuXmtjgI(list));
    }

    private void restoreInteropConfig() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mInteropConfig == null) return;
            this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
            return;
        }
    }

    private void updateViewPort(Map<UseCase, Size> map, Collection<UseCase> object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                if (this.mViewPort == null) return;
                boolean bl = this.mCameraInternal.getCameraInfoInternal().getLensFacing() == 0;
                map = ViewPorts.calculateViewPortRects((Rect)this.mCameraInternal.getCameraControlInternal().getSensorRect(), (boolean)bl, (Rational)this.mViewPort.getAspectRatio(), (int)this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), (int)this.mViewPort.getScaleType(), (int)this.mViewPort.getLayoutDirection(), map);
                object = object.iterator();
                while (object.hasNext()) {
                    UseCase useCase = (UseCase)object.next();
                    useCase.setViewPortCropRect((Rect)Preconditions.checkNotNull((Object)((Rect)map.get(useCase))));
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void addUseCases(Collection<UseCase> iterator) throws CameraException {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Object object2;
                CameraException cameraException = new ArrayList();
                Object object3 = iterator.iterator();
                while (object3.hasNext()) {
                    object2 = object3.next();
                    if (this.mUseCases.contains(object2)) {
                        Logger.d((String)TAG, (String)"Attempting to attach already attached UseCase");
                        continue;
                    }
                    cameraException.add((UseCase)object2);
                }
                object2 = this.getConfigs((List<UseCase>)cameraException, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                try {
                    object3 = this.calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), (List<UseCase>)cameraException, this.mUseCases, (Map<UseCase, ConfigPair>)object2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    cameraException = new CameraException(illegalArgumentException.getMessage());
                    throw cameraException;
                }
                this.updateViewPort((Map<UseCase, Size>)object3, (Collection<UseCase>)((Object)iterator));
                for (UseCase useCase : cameraException) {
                    ConfigPair configPair = (ConfigPair)object2.get(useCase);
                    useCase.onAttach(this.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                    useCase.updateSuggestedResolution((Size)Preconditions.checkNotNull((Object)((Size)object3.get(useCase))));
                }
                this.mUseCases.addAll((Collection<UseCase>)cameraException);
                if (this.mAttached) {
                    this.notifyAttachedUseCasesChange(this.mUseCases);
                    this.mCameraInternal.attachUseCases((Collection)cameraException);
                }
                iterator = cameraException.iterator();
                while (iterator.hasNext()) {
                    ((UseCase)iterator.next()).notifyState();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void attachUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                if (this.mAttached) return;
                this.mCameraInternal.attachUseCases(this.mUseCases);
                this.notifyAttachedUseCasesChange(this.mUseCases);
                this.restoreInteropConfig();
                Iterator<UseCase> iterator = this.mUseCases.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.mAttached = true;
                        return;
                    }
                    iterator.next().notifyState();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void checkAttachUseCases(List<UseCase> list) throws CameraException {
        Object object = this.mLock;
        synchronized (object) {
            try {
                try {
                    Map<UseCase, ConfigPair> map = this.getConfigs(list, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                    this.calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), list, Collections.<UseCase>emptyList(), map);
                    return;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    CameraException cameraException = new CameraException(illegalArgumentException.getMessage());
                    throw cameraException;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public void detachUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mAttached) return;
            CameraInternal cameraInternal = this.mCameraInternal;
            ArrayList<UseCase> arrayList = new ArrayList<UseCase>(this.mUseCases);
            cameraInternal.detachUseCases(arrayList);
            this.cacheInteropConfig();
            this.mAttached = false;
            return;
        }
    }

    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControlInternal();
    }

    public CameraId getCameraId() {
        return this.mId;
    }

    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfoInternal();
    }

    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    public CameraConfig getExtendedConfig() {
        Object object = this.mLock;
        synchronized (object) {
            CameraConfig cameraConfig = this.mCameraConfig;
            return cameraConfig;
        }
    }

    public List<UseCase> getUseCases() {
        Object object = this.mLock;
        synchronized (object) {
            ArrayList<UseCase> arrayList = new ArrayList<UseCase>(this.mUseCases);
            return arrayList;
        }
    }

    public boolean isEquivalent(CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals((Object)cameraUseCaseAdapter.getCameraId());
    }

    public void removeUseCases(Collection<UseCase> collection) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                this.mCameraInternal.detachUseCases(collection);
                Iterator<UseCase> iterator = collection.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.mUseCases.removeAll(collection);
                        return;
                    }
                    UseCase useCase = iterator.next();
                    if (this.mUseCases.contains(useCase)) {
                        useCase.onDetach(this.mCameraInternal);
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Attempting to detach non-attached UseCase: ");
                    stringBuilder.append(useCase);
                    Logger.e((String)TAG, (String)stringBuilder.toString());
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void setExtendedConfig(CameraConfig cameraConfig) throws CameraException {
        Throwable throwable2;
        Object object = this.mLock;
        synchronized (object) {
            block12: {
                CameraConfig cameraConfig2 = cameraConfig;
                if (cameraConfig == null) {
                    try {
                        cameraConfig2 = CameraConfigs.emptyConfig();
                    }
                    catch (Throwable throwable2) {
                        break block12;
                    }
                }
                cameraConfig = cameraConfig2.getCameraFilter();
                Object object2 = new CameraSelector.Builder();
                cameraConfig = object2.addCameraFilter((CameraFilter)cameraConfig).build().select(this.mCameraInternals);
                Map<UseCase, ConfigPair> map = this.getConfigs(this.mUseCases, cameraConfig2.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                try {
                    object2 = this.calculateSuggestedResolutions(cameraConfig.getCameraInfoInternal(), this.mUseCases, Collections.<UseCase>emptyList(), map);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    cameraConfig2 = new CameraException(illegalArgumentException.getMessage());
                    throw cameraConfig2;
                }
                this.updateViewPort((Map<UseCase, Size>)object2, this.mUseCases);
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(this.mUseCases);
                }
                UseCase useCase2 = this.mUseCases.iterator();
                while (useCase2.hasNext()) {
                    useCase2.next().onDetach(this.mCameraInternal);
                }
                for (UseCase useCase2 : this.mUseCases) {
                    ConfigPair configPair = map.get(useCase2);
                    useCase2.onAttach((CameraInternal)cameraConfig, configPair.mExtendedConfig, configPair.mCameraConfig);
                    useCase2.updateSuggestedResolution((Size)Preconditions.checkNotNull((Object)((Size)object2.get(useCase2))));
                }
                if (this.mAttached) {
                    this.notifyAttachedUseCasesChange(this.mUseCases);
                    cameraConfig.attachUseCases(this.mUseCases);
                }
                object2 = this.mUseCases.iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.mCameraInternal = cameraConfig;
                        this.mCameraConfig = cameraConfig2;
                        return;
                    }
                    ((UseCase)object2.next()).notifyState();
                }
            }
        }
        throw throwable2;
    }

    public void setViewPort(ViewPort viewPort) {
        Object object = this.mLock;
        synchronized (object) {
            this.mViewPort = viewPort;
            return;
        }
    }
}
