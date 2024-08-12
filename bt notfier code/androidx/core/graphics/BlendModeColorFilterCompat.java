/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.BlendModeColorFilter
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.os.Build$VERSION
 *  androidx.core.graphics.BlendModeCompat
 *  androidx.core.graphics.BlendModeUtils
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int n, BlendModeCompat blendModeCompat) {
        int n2 = Build.VERSION.SDK_INT;
        BlendMode blendMode = null;
        PorterDuff.Mode mode = null;
        if (n2 >= 29) {
            blendMode = BlendModeUtils.obtainBlendModeFromCompat((BlendModeCompat)blendModeCompat);
            blendModeCompat = mode;
            if (blendMode == null) return blendModeCompat;
            blendModeCompat = new BlendModeColorFilter(n, blendMode);
            return blendModeCompat;
        }
        mode = BlendModeUtils.obtainPorterDuffFromCompat((BlendModeCompat)blendModeCompat);
        blendModeCompat = blendMode;
        if (mode == null) return blendModeCompat;
        blendModeCompat = new PorterDuffColorFilter(n, mode);
        return blendModeCompat;
    }
}
