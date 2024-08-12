/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Camera
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraInternal$State
 *  androidx.camera.core.impl.CameraStateRegistry$CameraRegistration
 *  androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

public final class CameraStateRegistry {
    private static final String TAG = "CameraStateRegistry";
    private int mAvailableCameras;
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString = new StringBuilder();
    private final Object mLock = new Object();
    private final int mMaxAllowedOpenedCameras;

    public CameraStateRegistry(int n) {
        this.mCameraStates = new HashMap<Camera, CameraRegistration>();
        this.mMaxAllowedOpenedCameras = n;
        synchronized ("mLock") {
            this.mAvailableCameras = this.mMaxAllowedOpenedCameras;
            return;
        }
    }

    private static boolean isOpen(CameraInternal.State state) {
        boolean bl = state != null && state.holdsCameraSlot();
        return bl;
    }

    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled((String)TAG)) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.mDebugString.append("-------------------------------------------------------------------\n");
        }
        Iterator<Map.Entry<Camera, CameraRegistration>> iterator = this.mCameraStates.entrySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            Map.Entry<Camera, CameraRegistration> entry = iterator.next();
            if (Logger.isDebugEnabled((String)TAG)) {
                String string = entry.getValue().getState() != null ? entry.getValue().getState().toString() : "UNKNOWN";
                this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", entry.getKey().toString(), string));
            }
            if (!CameraStateRegistry.isOpen(entry.getValue().getState())) continue;
            ++n;
        }
        if (Logger.isDebugEnabled((String)TAG)) {
            this.mDebugString.append("-------------------------------------------------------------------\n");
            this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", n, this.mMaxAllowedOpenedCameras));
            Logger.d((String)TAG, (String)this.mDebugString.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - n, 0);
    }

    private CameraInternal.State unregisterCamera(Camera camera) {
        if ((camera = this.mCameraStates.remove(camera)) == null) return null;
        this.recalculateAvailableCameras();
        return camera.getState();
    }

    private CameraInternal.State updateAndVerifyState(Camera camera, CameraInternal.State state) {
        camera = ((CameraRegistration)Preconditions.checkNotNull((Object)this.mCameraStates.get(camera), (Object)"Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(state);
        if (state == CameraInternal.State.OPENING) {
            boolean bl = CameraStateRegistry.isOpen(state) || camera == CameraInternal.State.OPENING;
            Preconditions.checkState((boolean)bl, (String)"Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (camera == state) return camera;
        this.recalculateAvailableCameras();
        return camera;
    }

    public boolean isCameraClosing() {
        Object object = this.mLock;
        synchronized (object) {
            try {
                Iterator<Map.Entry<Camera, CameraRegistration>> iterator = this.mCameraStates.entrySet().iterator();
                do {
                    if (!iterator.hasNext()) return false;
                } while (iterator.next().getValue().getState() != CameraInternal.State.CLOSING);
                return true;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void markCameraState(Camera camera, CameraInternal.State state) {
        this.markCameraState(camera, state, true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void markCameraState(Camera object, CameraInternal.State object2, boolean bl) {
        Object object3 = this.mLock;
        // MONITORENTER : object3
        int n = this.mAvailableCameras;
        Object object4 = object2 == CameraInternal.State.RELEASED ? this.unregisterCamera((Camera)object) : this.updateAndVerifyState((Camera)object, (CameraInternal.State)object2);
        if (object4 == object2) {
            // MONITOREXIT : object3
            return;
        }
        if (n < 1 && this.mAvailableCameras > 0) {
            object4 = new HashMap();
            Iterator<Map.Entry<Camera, CameraRegistration>> iterator = this.mCameraStates.entrySet().iterator();
            while (true) {
                object2 = object4;
                if (iterator.hasNext()) {
                    object2 = iterator.next();
                    if (((CameraRegistration)object2.getValue()).getState() != CameraInternal.State.PENDING_OPEN) continue;
                    object4.put((Camera)object2.getKey(), (CameraRegistration)object2.getValue());
                    continue;
                }
                break;
            }
        } else if (object2 == CameraInternal.State.PENDING_OPEN && this.mAvailableCameras > 0) {
            object2 = new HashMap();
            object2.put(object, this.mCameraStates.get(object));
        } else {
            object2 = null;
        }
        if (object2 != null && !bl) {
            object2.remove(object);
        }
        // MONITOREXIT : object3
        if (object2 == null) return;
        object = object2.values().iterator();
        while (object.hasNext()) {
            ((CameraRegistration)object.next()).notifyListener();
        }
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : object3
                throw throwable;
            }
        }
    }

    public void registerCamera(Camera camera, Executor executor, OnOpenAvailableListener onOpenAvailableListener) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = !this.mCameraStates.containsKey(camera);
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("Camera is already registered: ");
            ((StringBuilder)object2).append(camera);
            Preconditions.checkState((boolean)bl, (String)((StringBuilder)object2).toString());
            object2 = this.mCameraStates;
            CameraRegistration cameraRegistration = new CameraRegistration(null, executor, onOpenAvailableListener);
            object2.put(camera, cameraRegistration);
            return;
        }
    }

    public boolean tryOpenCamera(Camera object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            boolean bl;
            Object object3 = (CameraRegistration)Preconditions.checkNotNull((Object)this.mCameraStates.get(object), (Object)"Camera must first be registered with registerCamera()");
            if (Logger.isDebugEnabled((String)TAG)) {
                this.mDebugString.setLength(0);
                this.mDebugString.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", object, this.mAvailableCameras, CameraStateRegistry.isOpen(object3.getState()), object3.getState()));
            }
            if (this.mAvailableCameras <= 0 && !CameraStateRegistry.isOpen(object3.getState())) {
                bl = false;
            } else {
                object3.setState(CameraInternal.State.OPENING);
                bl = true;
            }
            if (Logger.isDebugEnabled((String)TAG)) {
                object3 = this.mDebugString;
                Locale locale = Locale.US;
                object = bl ? "SUCCESS" : "FAIL";
                ((StringBuilder)object3).append(String.format(locale, " --> %s", object));
                Logger.d((String)TAG, (String)this.mDebugString.toString());
            }
            if (!bl) return bl;
            this.recalculateAvailableCameras();
            return bl;
        }
    }
}
