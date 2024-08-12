/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  androidx.core.content.ContextCompat
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;

public class AttrsUtils {
    public static ColorStateList getColorStateList(int[] object) {
        try {
            if (((int[])object).length == 2) {
                return new ColorStateList((int[][])new int[][]{{-16842913}, {0x10100A1}}, object);
            }
            object = ColorStateList.valueOf((int)object[0]);
            return object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static boolean getTypeValueBoolean(Context context, int n) {
        boolean bl;
        boolean bl2 = bl = false;
        try {
            bl2 = bl;
            TypedValue typedValue = new TypedValue();
            bl2 = bl;
            context = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            bl2 = bl;
            bl2 = bl = context.getBoolean(0, false);
            context.recycle();
            bl2 = bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl2;
    }

    public static int getTypeValueColor(Context context, int n) {
        int n2;
        int n3 = n2 = 0;
        try {
            n3 = n2;
            TypedValue typedValue = new TypedValue();
            n3 = n2;
            context = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            n3 = n2;
            n3 = n = context.getColor(0, 0);
            context.recycle();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n = n3;
        }
        return n;
    }

    public static ColorStateList getTypeValueColorStateList(Context context, int n) {
        Context context2;
        Context context3 = context2 = null;
        try {
            context3 = context2;
            TypedValue typedValue = new TypedValue();
            context3 = context2;
            typedValue = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            context3 = context2;
            context3 = context = typedValue.getColorStateList(0);
            typedValue.recycle();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            context = context3;
        }
        return context;
    }

    public static Drawable getTypeValueDrawable(Context context, int n, int n2) {
        Drawable drawable;
        Drawable drawable2 = drawable = null;
        try {
            drawable2 = drawable;
            TypedValue typedValue = new TypedValue();
            drawable2 = drawable;
            typedValue = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            drawable2 = drawable;
            drawable2 = drawable = typedValue.getDrawable(0);
            typedValue.recycle();
            drawable2 = drawable;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        drawable = drawable2;
        if (drawable2 != null) return drawable;
        drawable = ContextCompat.getDrawable((Context)context, (int)n2);
        return drawable;
    }

    public static float getTypeValueSize(Context context, int n) {
        float f;
        float f2 = f = 0.0f;
        try {
            f2 = f;
            TypedValue typedValue = new TypedValue();
            f2 = f;
            context = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            f2 = f;
            f2 = f = (float)context.getDimensionPixelSize(0, 0);
            context.recycle();
            return f;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return f2;
        }
    }

    public static int getTypeValueSizeForInt(Context context, int n) {
        int n2;
        int n3 = n2 = 0;
        try {
            n3 = n2;
            TypedValue typedValue = new TypedValue();
            n3 = n2;
            context = context.obtainStyledAttributes(typedValue.resourceId, new int[]{n});
            n3 = n2;
            n3 = n = context.getDimensionPixelSize(0, 0);
            context.recycle();
            return n;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return n3;
        }
    }
}
