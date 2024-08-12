/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.CameraSelector$Builder
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.LensFacingCameraFilter
 */
package androidx.camera.core;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA;
    public static final CameraSelector DEFAULT_FRONT_CAMERA;
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_FRONT = 0;
    private LinkedHashSet<CameraFilter> mCameraFilterSet;

    static {
        DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();
        DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();
    }

    CameraSelector(LinkedHashSet<CameraFilter> linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    public LinkedHashSet<CameraInternal> filter(LinkedHashSet<CameraInternal> object) {
        List<CameraInfo> list = new ArrayList<CameraInfo>();
        Object object2 = ((HashSet)object).iterator();
        while (object2.hasNext()) {
            list.add(((CameraInternal)object2.next()).getCameraInfo());
        }
        list = this.filter(list);
        object2 = new LinkedHashSet();
        object = ((HashSet)object).iterator();
        while (object.hasNext()) {
            CameraInternal cameraInternal = (CameraInternal)object.next();
            if (!list.contains(cameraInternal.getCameraInfo())) continue;
            ((HashSet)object2).add(cameraInternal);
        }
        return object2;
    }

    public List<CameraInfo> filter(List<CameraInfo> list) {
        ArrayList<CameraInfo> arrayList = new ArrayList<CameraInfo>(list);
        list = new ArrayList<CameraInfo>(list);
        Iterator iterator = this.mCameraFilterSet.iterator();
        while (iterator.hasNext()) {
            list = ((CameraFilter)iterator.next()).filter(Collections.unmodifiableList(list));
            if (list.isEmpty()) throw new IllegalArgumentException("No available camera can be found.");
            if (!arrayList.containsAll(list)) throw new IllegalArgumentException("The output isn't contained in the input.");
            arrayList.retainAll(list);
        }
        return list;
    }

    public LinkedHashSet<CameraFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public Integer getLensFacing() {
        Iterator iterator = this.mCameraFilterSet.iterator();
        Object object = null;
        while (iterator.hasNext()) {
            Object object2 = (CameraFilter)iterator.next();
            if (!(object2 instanceof LensFacingCameraFilter)) continue;
            object2 = ((LensFacingCameraFilter)object2).getLensFacing();
            if (object == null) {
                object = object2;
                continue;
            }
            if (!((Integer)object).equals(object2)) throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
        }
        return object;
    }

    public CameraInternal select(LinkedHashSet<CameraInternal> linkedHashSet) {
        return (CameraInternal)this.filter(linkedHashSet).iterator().next();
    }
}
