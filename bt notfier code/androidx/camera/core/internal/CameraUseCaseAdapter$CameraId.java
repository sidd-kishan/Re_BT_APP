/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraInternal
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.CameraInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public static final class CameraUseCaseAdapter.CameraId {
    private final List<String> mIds = new ArrayList<String>();

    CameraUseCaseAdapter.CameraId(LinkedHashSet<CameraInternal> cameraInternal) {
        Iterator iterator = cameraInternal.iterator();
        while (iterator.hasNext()) {
            cameraInternal = (CameraInternal)iterator.next();
            this.mIds.add(cameraInternal.getCameraInfoInternal().getCameraId());
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof CameraUseCaseAdapter.CameraId)) return false;
        return this.mIds.equals(((CameraUseCaseAdapter.CameraId)object).mIds);
    }

    public int hashCode() {
        return this.mIds.hashCode() * 53;
    }
}
