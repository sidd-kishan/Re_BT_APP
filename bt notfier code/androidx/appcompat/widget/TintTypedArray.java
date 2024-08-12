/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.content.res.ResourcesCompat;

public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int n, int[] nArray) {
        return new TintTypedArray(context, context.obtainStyledAttributes(n, nArray));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, nArray));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray, int n, int n2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, nArray, n, n2));
    }

    public boolean getBoolean(int n, boolean bl) {
        return this.mWrapped.getBoolean(n, bl);
    }

    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int n, int n2) {
        return this.mWrapped.getColor(n, n2);
    }

    public ColorStateList getColorStateList(int n) {
        if (!this.mWrapped.hasValue(n)) return this.mWrapped.getColorStateList(n);
        int n2 = this.mWrapped.getResourceId(n, 0);
        if (n2 == 0) return this.mWrapped.getColorStateList(n);
        ColorStateList colorStateList = AppCompatResources.getColorStateList((Context)this.mContext, (int)n2);
        if (colorStateList == null) return this.mWrapped.getColorStateList(n);
        return colorStateList;
    }

    public float getDimension(int n, float f) {
        return this.mWrapped.getDimension(n, f);
    }

    public int getDimensionPixelOffset(int n, int n2) {
        return this.mWrapped.getDimensionPixelOffset(n, n2);
    }

    public int getDimensionPixelSize(int n, int n2) {
        return this.mWrapped.getDimensionPixelSize(n, n2);
    }

    public Drawable getDrawable(int n) {
        if (!this.mWrapped.hasValue(n)) return this.mWrapped.getDrawable(n);
        int n2 = this.mWrapped.getResourceId(n, 0);
        if (n2 == 0) return this.mWrapped.getDrawable(n);
        return AppCompatResources.getDrawable((Context)this.mContext, (int)n2);
    }

    public Drawable getDrawableIfKnown(int n) {
        if (!this.mWrapped.hasValue(n)) return null;
        if ((n = this.mWrapped.getResourceId(n, 0)) == 0) return null;
        return AppCompatDrawableManager.get().getDrawable(this.mContext, n, true);
    }

    public float getFloat(int n, float f) {
        return this.mWrapped.getFloat(n, f);
    }

    public Typeface getFont(int n, int n2, ResourcesCompat.FontCallback fontCallback) {
        if ((n = this.mWrapped.getResourceId(n, 0)) == 0) {
            return null;
        }
        if (this.mTypedValue != null) return ResourcesCompat.getFont((Context)this.mContext, (int)n, (TypedValue)this.mTypedValue, (int)n2, (ResourcesCompat.FontCallback)fontCallback);
        this.mTypedValue = new TypedValue();
        return ResourcesCompat.getFont((Context)this.mContext, (int)n, (TypedValue)this.mTypedValue, (int)n2, (ResourcesCompat.FontCallback)fontCallback);
    }

    public float getFraction(int n, int n2, int n3, float f) {
        return this.mWrapped.getFraction(n, n2, n3, f);
    }

    public int getIndex(int n) {
        return this.mWrapped.getIndex(n);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int n, int n2) {
        return this.mWrapped.getInt(n, n2);
    }

    public int getInteger(int n, int n2) {
        return this.mWrapped.getInteger(n, n2);
    }

    public int getLayoutDimension(int n, int n2) {
        return this.mWrapped.getLayoutDimension(n, n2);
    }

    public int getLayoutDimension(int n, String string) {
        return this.mWrapped.getLayoutDimension(n, string);
    }

    public String getNonResourceString(int n) {
        return this.mWrapped.getNonResourceString(n);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int n, int n2) {
        return this.mWrapped.getResourceId(n, n2);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int n) {
        return this.mWrapped.getString(n);
    }

    public CharSequence getText(int n) {
        return this.mWrapped.getText(n);
    }

    public CharSequence[] getTextArray(int n) {
        return this.mWrapped.getTextArray(n);
    }

    public int getType(int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mWrapped.getType(n);
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        this.mWrapped.getValue(n, this.mTypedValue);
        return this.mTypedValue.type;
    }

    public boolean getValue(int n, TypedValue typedValue) {
        return this.mWrapped.getValue(n, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int n) {
        return this.mWrapped.hasValue(n);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int n) {
        return this.mWrapped.peekValue(n);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}
