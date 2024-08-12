/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Quirk
 *  androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk
 *  androidx.camera.core.internal.compat.quirk.ImageCaptureWashedOutImageQuirk
 *  androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk
 */
package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.core.internal.compat.quirk.IncompleteCameraListQuirk;
import java.util.ArrayList;
import java.util.List;

public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    static List<Quirk> loadQuirks() {
        ArrayList<Quirk> arrayList = new ArrayList<Quirk>();
        if (IncompleteCameraListQuirk.load()) {
            arrayList.add((Quirk)new IncompleteCameraListQuirk());
        }
        if (ImageCaptureRotationOptionQuirk.load()) {
            arrayList.add((Quirk)new ImageCaptureRotationOptionQuirk());
        }
        if (!ImageCaptureWashedOutImageQuirk.load()) return arrayList;
        arrayList.add((Quirk)new ImageCaptureWashedOutImageQuirk());
        return arrayList;
    }
}
