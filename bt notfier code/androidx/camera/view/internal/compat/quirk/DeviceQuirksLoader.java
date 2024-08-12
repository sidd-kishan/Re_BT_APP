/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Quirk
 *  androidx.camera.view.internal.compat.quirk.PreviewOneThirdWiderQuirk
 *  androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk
 */
package androidx.camera.view.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.view.internal.compat.quirk.PreviewOneThirdWiderQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import java.util.ArrayList;
import java.util.List;

public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    static List<Quirk> loadQuirks() {
        ArrayList<Quirk> arrayList = new ArrayList<Quirk>();
        if (PreviewOneThirdWiderQuirk.load()) {
            arrayList.add((Quirk)new PreviewOneThirdWiderQuirk());
        }
        if (!SurfaceViewStretchedQuirk.load()) return arrayList;
        arrayList.add((Quirk)new SurfaceViewStretchedQuirk());
        return arrayList;
    }
}
