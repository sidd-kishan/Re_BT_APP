/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.GhostView
 *  androidx.transition.GhostViewPlatform
 *  androidx.transition.GhostViewPort
 */
package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.GhostView;
import androidx.transition.GhostViewPlatform;
import androidx.transition.GhostViewPort;

class GhostViewUtils {
    private GhostViewUtils() {
    }

    static GhostView addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT != 28) return GhostViewPort.addGhost((View)view, (ViewGroup)viewGroup, (Matrix)matrix);
        return GhostViewPlatform.addGhost((View)view, (ViewGroup)viewGroup, (Matrix)matrix);
    }

    static void removeGhost(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.removeGhost((View)view);
        } else {
            GhostViewPort.removeGhost((View)view);
        }
    }
}
