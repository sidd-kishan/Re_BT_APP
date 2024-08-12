/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  androidx.appcompat.graphics.drawable.DrawableWrapper
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.graphics.drawable.WrappedDrawable
 */
package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;

public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = new int[]{0x10100A0};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class<?> sInsetsClazz;

    /*
     * Enabled force condition propagation
     */
    static {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            sInsetsClazz = Class.forName("android.graphics.Insets");
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(Drawable drawableArray) {
        if (Build.VERSION.SDK_INT < 15 && drawableArray instanceof InsetDrawable) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && drawableArray instanceof GradientDrawable) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && drawableArray instanceof LayerDrawable) {
            return false;
        }
        if (!(drawableArray instanceof DrawableContainer)) {
            if (drawableArray instanceof WrappedDrawable) {
                return DrawableUtils.canSafelyMutateDrawable(((WrappedDrawable)drawableArray).getWrappedDrawable());
            }
            if (drawableArray instanceof DrawableWrapper) {
                return DrawableUtils.canSafelyMutateDrawable(((DrawableWrapper)drawableArray).getWrappedDrawable());
            }
            if (!(drawableArray instanceof ScaleDrawable)) return true;
            return DrawableUtils.canSafelyMutateDrawable(((ScaleDrawable)drawableArray).getDrawable());
        }
        if (!((drawableArray = drawableArray.getConstantState()) instanceof DrawableContainer.DrawableContainerState)) return true;
        drawableArray = ((DrawableContainer.DrawableContainerState)drawableArray).getChildren();
        int n = drawableArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (!DrawableUtils.canSafelyMutateDrawable(drawableArray[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    static void fixDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT != 21) return;
        if (!VECTOR_DRAWABLE_CLAZZ_NAME.equals(drawable.getClass().getName())) return;
        DrawableUtils.fixVectorDrawableTinting(drawable);
    }

    private static void fixVectorDrawableTinting(Drawable drawable) {
        int[] nArray = drawable.getState();
        if (nArray != null && nArray.length != 0) {
            drawable.setState(EMPTY_STATE_SET);
        } else {
            drawable.setState(CHECKED_STATE_SET);
        }
        drawable.setState(nArray);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static Rect getOpticalBounds(Drawable object) {
        block18: {
            int n;
            int n2;
            Field[] fieldArray;
            Rect rect;
            Object object2;
            if (Build.VERSION.SDK_INT >= 29) {
                object = object.getOpticalInsets();
                Rect rect2 = new Rect();
                rect2.left = ((Insets)object).left;
                rect2.right = ((Insets)object).right;
                rect2.top = ((Insets)object).top;
                rect2.bottom = ((Insets)object).bottom;
                return rect2;
            }
            if (sInsetsClazz == null) return INSETS_NONE;
            try {
                object = DrawableCompat.unwrap((Drawable)object);
                object2 = object.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(object, new Object[0]);
                if (object2 == null) return INSETS_NONE;
                rect = new Rect();
                fieldArray = sInsetsClazz.getFields();
                n2 = fieldArray.length;
                n = 0;
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"Couldn't obtain the optical insets. Ignoring.");
                break block18;
            }
            while (n < n2) {
                Field field = fieldArray[n];
                {
                    object = field.getName();
                    int n3 = -1;
                    switch (((String)object).hashCode()) {
                        default: {
                            break;
                        }
                        case 108511772: {
                            if (!((String)object).equals("right")) break;
                            n3 = 2;
                            break;
                        }
                        case 3317767: {
                            if (!((String)object).equals("left")) break;
                            n3 = 0;
                            break;
                        }
                        case 115029: {
                            if (!((String)object).equals("top")) break;
                            n3 = 1;
                            break;
                        }
                        case -1383228885: {
                            if (!((String)object).equals("bottom")) break;
                            n3 = 3;
                        }
                    }
                    if (n3 != 0) {
                        if (n3 != 1) {
                            if (n3 != 2) {
                                if (n3 == 3) {
                                    rect.bottom = field.getInt(object2);
                                }
                            } else {
                                rect.right = field.getInt(object2);
                            }
                        } else {
                            rect.top = field.getInt(object2);
                        }
                    } else {
                        rect.left = field.getInt(object2);
                    }
                    ++n;
                }
            }
            return rect;
        }
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int n, PorterDuff.Mode mode) {
        if (n == 3) return PorterDuff.Mode.SRC_OVER;
        if (n == 5) return PorterDuff.Mode.SRC_IN;
        if (n == 9) return PorterDuff.Mode.SRC_ATOP;
        switch (n) {
            default: {
                return mode;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 14: 
        }
        return PorterDuff.Mode.MULTIPLY;
    }
}
