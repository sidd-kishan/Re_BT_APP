/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  androidx.core.graphics.BlendModeCompat
 *  androidx.core.graphics.BlendModeUtils
 *  androidx.core.util.Pair
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;
import androidx.core.util.Pair;

public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udb3f\udffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal();

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint paint, String string) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(string);
        }
        int n = string.length();
        if (n == 1 && Character.isWhitespace(string.charAt(0))) {
            return true;
        }
        float f = paint.measureText(TOFU_STRING);
        float f2 = paint.measureText(EM_STRING);
        float f3 = paint.measureText(string);
        float f4 = 0.0f;
        if (f3 == 0.0f) {
            return false;
        }
        if (string.codePointCount(0, string.length()) > 1) {
            if (f3 > f2 * 2.0f) {
                return false;
            }
            int n2 = 0;
            while (n2 < n) {
                int n3 = Character.charCount(string.codePointAt(n2)) + n2;
                f4 += paint.measureText(string, n2, n3);
                n2 = n3;
            }
            if (f3 >= f4) {
                return false;
            }
        }
        if (f3 != f) {
            return true;
        }
        Pair<Rect, Rect> pair = PaintCompat.obtainEmptyRects();
        paint.getTextBounds(TOFU_STRING, 0, 2, (Rect)pair.first);
        paint.getTextBounds(string, 0, n, (Rect)pair.second);
        return ((Rect)pair.first).equals(pair.second) ^ true;
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Pair pair = sRectThreadLocal.get();
        if (pair == null) {
            pair = new Pair((Object)new Rect(), (Object)new Rect());
            sRectThreadLocal.set((Pair<Rect, Rect>)pair);
        } else {
            ((Rect)pair.first).setEmpty();
            ((Rect)pair.second).setEmpty();
        }
        return pair;
    }

    public static boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        PorterDuff.Mode mode = null;
        PorterDuff.Mode mode2 = null;
        if (n >= 29) {
            mode = mode2;
            if (blendModeCompat != null) {
                mode = BlendModeUtils.obtainBlendModeFromCompat((BlendModeCompat)blendModeCompat);
            }
            paint.setBlendMode((BlendMode)mode);
            return true;
        }
        if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        }
        mode2 = BlendModeUtils.obtainPorterDuffFromCompat((BlendModeCompat)blendModeCompat);
        blendModeCompat = mode;
        if (mode2 != null) {
            blendModeCompat = new PorterDuffXfermode(mode2);
        }
        paint.setXfermode((Xfermode)blendModeCompat);
        if (mode2 != null) return bl;
        bl = false;
        return bl;
    }
}
