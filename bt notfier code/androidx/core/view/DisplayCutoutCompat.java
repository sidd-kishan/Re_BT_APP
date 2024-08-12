/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.DisplayCutout
 *  androidx.core.graphics.Insets
 *  androidx.core.os.BuildCompat
 *  androidx.core.util.ObjectsCompat
 */
package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DisplayCutoutCompat {
    private final Object mDisplayCutout;

    public DisplayCutoutCompat(Rect object, List<Rect> list) {
        object = Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(object, list) : null;
        this(object);
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets insets2) {
        this(DisplayCutoutCompat.constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    private DisplayCutoutCompat(Object object) {
        this.mDisplayCutout = object;
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, androidx.core.graphics.Insets object) {
        if (BuildCompat.isAtLeastR()) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, object.toPlatformInsets());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (Build.VERSION.SDK_INT < 28) return null;
        insets = new Rect(insets.left, insets.top, insets.right, insets.bottom);
        object = new ArrayList();
        if (rect != null) {
            ((ArrayList)object).add(rect);
        }
        if (rect2 != null) {
            ((ArrayList)object).add(rect2);
        }
        if (rect3 != null) {
            ((ArrayList)object).add(rect3);
        }
        if (rect4 == null) return new DisplayCutout((Rect)insets, (List)object);
        ((ArrayList)object).add(rect4);
        return new DisplayCutout((Rect)insets, (List)object);
    }

    static DisplayCutoutCompat wrap(Object object) {
        object = object == null ? null : new DisplayCutoutCompat(object);
        return object;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (DisplayCutoutCompat)object;
        return ObjectsCompat.equals((Object)this.mDisplayCutout, (Object)((DisplayCutoutCompat)object).mDisplayCutout);
    }

    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT < 28) return Collections.emptyList();
        return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT < 28) return 0;
        return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT < 28) return 0;
        return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT < 28) return 0;
        return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT < 28) return 0;
        return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (!BuildCompat.isAtLeastR()) return androidx.core.graphics.Insets.NONE;
        return androidx.core.graphics.Insets.toCompatInsets((Insets)((DisplayCutout)this.mDisplayCutout).getWaterfallInsets());
    }

    public int hashCode() {
        Object object = this.mDisplayCutout;
        int n = object == null ? 0 : object.hashCode();
        return n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisplayCutoutCompat{");
        stringBuilder.append(this.mDisplayCutout);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    DisplayCutout unwrap() {
        return (DisplayCutout)this.mDisplayCutout;
    }
}
