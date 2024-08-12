/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.content.res.AppCompatResources
 *  com.google.android.material.resources.TextAppearance
 */
package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.resources.TextAppearance;

public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int n) {
        if (!typedArray.hasValue(n)) return typedArray.getColorStateList(n);
        int n2 = typedArray.getResourceId(n, 0);
        if (n2 == 0) return typedArray.getColorStateList(n);
        if ((context = AppCompatResources.getColorStateList((Context)context, (int)n2)) == null) return typedArray.getColorStateList(n);
        return context;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int n) {
        if (!typedArray.hasValue(n)) return typedArray.getDrawable(n);
        int n2 = typedArray.getResourceId(n, 0);
        if (n2 == 0) return typedArray.getDrawable(n);
        if ((context = AppCompatResources.getDrawable((Context)context, (int)n2)) == null) return typedArray.getDrawable(n);
        return context;
    }

    static int getIndexWithValue(TypedArray typedArray, int n, int n2) {
        if (!typedArray.hasValue(n)) return n2;
        return n;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int n) {
        if (!typedArray.hasValue(n)) return null;
        if ((n = typedArray.getResourceId(n, 0)) == 0) return null;
        return new TextAppearance(context, n);
    }
}
