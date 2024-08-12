/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  androidx.transition.PathMotion
 */
package androidx.transition;

import android.graphics.Path;
import androidx.transition.PathMotion;

class Transition.1
extends PathMotion {
    Transition.1() {
    }

    public Path getPath(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }
}
