/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.ViewPort
 *  androidx.camera.core.internal.CameraUseCaseAdapter
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraException
 *  androidx.camera.core.internal.CameraUseCaseAdapter$CameraId
 *  androidx.camera.lifecycle.LifecycleCamera
 *  androidx.camera.lifecycle.LifecycleCameraRepository$Key
 *  androidx.camera.lifecycle.LifecycleCameraRepository$LifecycleCameraRepositoryObserver
 *  androidx.core.util.Preconditions
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.lifecycle;

import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
final class LifecycleCameraRepository {
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners;
    private final Map<Key, LifecycleCamera> mCameraMap;
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap;
    private final Object mLock = new Object();

    LifecycleCameraRepository() {
        this.mCameraMap = new HashMap<Key, LifecycleCamera>();
        this.mLifecycleObserverMap = new HashMap<LifecycleCameraRepositoryObserver, Set<Key>>();
        this.mActiveLifecycleOwners = new ArrayDeque();
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver;
                Iterator<LifecycleCameraRepositoryObserver> iterator = this.mLifecycleObserverMap.keySet().iterator();
                do {
                    if (!iterator.hasNext()) return null;
                } while (!lifecycleOwner.equals((lifecycleCameraRepositoryObserver = iterator.next()).getLifecycleOwner()));
                return lifecycleCameraRepositoryObserver;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                lifecycleOwner = this.getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleOwner == null) {
                    return false;
                }
                Iterator<Key> iterator = this.mLifecycleObserverMap.get(lifecycleOwner).iterator();
                do {
                    if (!iterator.hasNext()) return false;
                } while (((LifecycleCamera)Preconditions.checkNotNull((Object)this.mCameraMap.get(lifecycleOwner = iterator.next()))).getUseCases().isEmpty());
                return true;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void registerCamera(LifecycleCamera lifecycleCamera) {
        Object object = this.mLock;
        synchronized (object) {
            LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
            Key key = Key.create((LifecycleOwner)lifecycleOwner, (CameraUseCaseAdapter.CameraId)lifecycleCamera.getCameraUseCaseAdapter().getCameraId());
            LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = this.getLifecycleCameraRepositoryObserver(lifecycleOwner);
            Set<Key> set = lifecycleCameraRepositoryObserver != null ? this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver) : new HashSet<Key>();
            set.add(key);
            this.mCameraMap.put(key, lifecycleCamera);
            if (lifecycleCameraRepositoryObserver != null) return;
            lifecycleCamera = new LifecycleCameraRepositoryObserver(lifecycleOwner, this);
            this.mLifecycleObserverMap.put((LifecycleCameraRepositoryObserver)lifecycleCamera, set);
            lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)lifecycleCamera);
            return;
        }
    }

    private void suspendUseCases(LifecycleOwner object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                object = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)object);
                object = this.mLifecycleObserverMap.get(object).iterator();
                while (object.hasNext()) {
                    Key key = (Key)object.next();
                    ((LifecycleCamera)Preconditions.checkNotNull((Object)this.mCameraMap.get(key))).suspend();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void unsuspendUseCases(LifecycleOwner object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                object = this.getLifecycleCameraRepositoryObserver((LifecycleOwner)object);
                object = this.mLifecycleObserverMap.get(object).iterator();
                while (object.hasNext()) {
                    Key key = (Key)object.next();
                    if (((LifecycleCamera)Preconditions.checkNotNull((Object)(key = this.mCameraMap.get(key)))).getUseCases().isEmpty()) continue;
                    key.unsuspend();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void bindToLifecycleCamera(LifecycleCamera object, ViewPort viewPort, Collection<UseCase> collection) {
        Object object2 = this.mLock;
        synchronized (object2) {
            try {
                boolean bl = !collection.isEmpty();
                Preconditions.checkArgument((boolean)bl);
                LifecycleOwner lifecycleOwner = object.getLifecycleOwner();
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = this.getLifecycleCameraRepositoryObserver(lifecycleOwner);
                for (Key key : this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver)) {
                    if ((key = (LifecycleCamera)Preconditions.checkNotNull((Object)this.mCameraMap.get(key))).equals(object) || key.getUseCases().isEmpty()) continue;
                    object = new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                    throw object;
                }
                try {
                    object.getCameraUseCaseAdapter().setViewPort(viewPort);
                    object.bind(collection);
                }
                catch (CameraUseCaseAdapter.CameraException cameraException) {
                    object = new IllegalArgumentException(cameraException.getMessage());
                    throw object;
                }
                if (!lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) return;
                this.setActive(lifecycleOwner);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void clear() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Object object2 = new HashSet(this.mLifecycleObserverMap.keySet());
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    this.unregisterLifecycle(((LifecycleCameraRepositoryObserver)object2.next()).getLifecycleOwner());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    LifecycleCamera createLifecycleCamera(LifecycleOwner object, CameraUseCaseAdapter cameraUseCaseAdapter) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Key key = Key.create((LifecycleOwner)object, (CameraUseCaseAdapter.CameraId)cameraUseCaseAdapter.getCameraId());
            boolean bl = this.mCameraMap.get(key) == null;
            Preconditions.checkArgument((boolean)bl, (Object)"LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (object.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                object = new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
                throw object;
            }
            key = new LifecycleCamera(object, cameraUseCaseAdapter);
            if (cameraUseCaseAdapter.getUseCases().isEmpty()) {
                key.suspend();
            }
            this.registerCamera((LifecycleCamera)key);
            return key;
        }
    }

    LifecycleCamera getLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        Object object = this.mLock;
        synchronized (object) {
            lifecycleOwner = this.mCameraMap.get(Key.create((LifecycleOwner)lifecycleOwner, (CameraUseCaseAdapter.CameraId)cameraId));
            return lifecycleOwner;
        }
    }

    Collection<LifecycleCamera> getLifecycleCameras() {
        Object object = this.mLock;
        synchronized (object) {
            Collection<LifecycleCamera> collection = Collections.unmodifiableCollection(this.mCameraMap.values());
            return collection;
        }
    }

    void setActive(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.hasUseCaseBound(lifecycleOwner)) {
                return;
            }
            if (this.mActiveLifecycleOwners.isEmpty()) {
                this.mActiveLifecycleOwners.push(lifecycleOwner);
            } else {
                LifecycleOwner lifecycleOwner2 = this.mActiveLifecycleOwners.peek();
                if (!lifecycleOwner.equals(lifecycleOwner2)) {
                    this.suspendUseCases(lifecycleOwner2);
                    this.mActiveLifecycleOwners.remove(lifecycleOwner);
                    this.mActiveLifecycleOwners.push(lifecycleOwner);
                }
            }
            this.unsuspendUseCases(lifecycleOwner);
            return;
        }
    }

    void setInactive(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            this.mActiveLifecycleOwners.remove(lifecycleOwner);
            this.suspendUseCases(lifecycleOwner);
            if (this.mActiveLifecycleOwners.isEmpty()) return;
            this.unsuspendUseCases(this.mActiveLifecycleOwners.peek());
            return;
        }
    }

    void unbind(Collection<UseCase> collection) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Iterator<Key> iterator = this.mCameraMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Key key = iterator.next();
                    boolean bl = !(key = this.mCameraMap.get(key)).getUseCases().isEmpty();
                    key.unbind(collection);
                    if (!bl || !key.getUseCases().isEmpty()) continue;
                    this.setInactive(key.getLifecycleOwner());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void unbindAll() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Iterator<Key> iterator = this.mCameraMap.keySet().iterator();
                while (iterator.hasNext()) {
                    Key key = iterator.next();
                    key = this.mCameraMap.get(key);
                    key.unbindAll();
                    this.setInactive(key.getLifecycleOwner());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    void unregisterLifecycle(LifecycleOwner lifecycleOwner) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = this.getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                this.setInactive(lifecycleOwner);
                Iterator<Key> iterator = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        this.mLifecycleObserverMap.remove(lifecycleCameraRepositoryObserver);
                        lifecycleCameraRepositoryObserver.getLifecycleOwner().getLifecycle().removeObserver((LifecycleObserver)lifecycleCameraRepositoryObserver);
                        return;
                    }
                    lifecycleOwner = iterator.next();
                    this.mCameraMap.remove(lifecycleOwner);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
