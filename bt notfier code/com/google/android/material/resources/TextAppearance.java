/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  android.util.Log
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  com.google.android.material.R$styleable
 *  com.google.android.material.resources.MaterialResources
 *  com.google.android.material.resources.TextAppearance$1
 *  com.google.android.material.resources.TextAppearanceConfig
 */
package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceConfig;

public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved = false;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, int n) {
        TypedArray typedArray = context.obtainStyledAttributes(n, R.styleable.TextAppearance);
        this.textSize = typedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = typedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = typedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
        n = MaterialResources.getIndexWithValue((TypedArray)typedArray, (int)R.styleable.TextAppearance_fontFamily, (int)R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = typedArray.getResourceId(n, 0);
        this.fontFamily = typedArray.getString(n);
        this.textAllCaps = typedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList((Context)context, (TypedArray)typedArray, (int)R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = typedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = typedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = typedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArray.recycle();
    }

    static /* synthetic */ Typeface access$002(TextAppearance textAppearance, Typeface typeface) {
        textAppearance.font = typeface;
        return typeface;
    }

    static /* synthetic */ boolean access$102(TextAppearance textAppearance, boolean bl) {
        textAppearance.fontResolved = bl;
        return bl;
    }

    static /* synthetic */ void access$200(TextAppearance textAppearance) {
        textAppearance.createFallbackTypeface();
    }

    private void createFallbackTypeface() {
        if (this.font == null) {
            this.font = Typeface.create((String)this.fontFamily, (int)this.textStyle);
        }
        if (this.font != null) return;
        int n = this.typeface;
        this.font = n != 1 ? (n != 2 ? (n != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE) : Typeface.SERIF) : Typeface.SANS_SERIF;
        Typeface typeface = this.font;
        if (typeface == null) return;
        this.font = Typeface.create((Typeface)typeface, (int)this.textStyle);
    }

    public Typeface getFont(Context object) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!object.isRestricted()) {
            try {
                object = ResourcesCompat.getFont((Context)object, (int)this.fontFamilyResourceId);
                this.font = object;
                if (object != null) {
                    this.font = Typeface.create((Typeface)object, (int)this.textStyle);
                }
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Error loading font ");
                ((StringBuilder)object).append(this.fontFamily);
                Log.d((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)exception);
            }
            catch (Resources.NotFoundException | UnsupportedOperationException throwable) {}
        }
        this.createFallbackTypeface();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(Context context, TextPaint object, ResourcesCompat.FontCallback fontCallback) {
        if (this.fontResolved) {
            this.updateTextPaintMeasureState((TextPaint)object, this.font);
            return;
        }
        this.createFallbackTypeface();
        if (context.isRestricted()) {
            this.fontResolved = true;
            this.updateTextPaintMeasureState((TextPaint)object, this.font);
            return;
        }
        try {
            int n = this.fontFamilyResourceId;
            1 var5_7 = new /* Unavailable Anonymous Inner Class!! */;
            ResourcesCompat.getFont((Context)context, (int)n, (ResourcesCompat.FontCallback)var5_7, null);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Error loading font ");
            ((StringBuilder)object).append(this.fontFamily);
            Log.d((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)exception);
        }
        catch (Resources.NotFoundException | UnsupportedOperationException throwable) {}
    }

    public void updateDrawState(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        this.updateMeasureState(context, textPaint, fontCallback);
        context = this.textColor;
        int n = context != null ? context.getColorForState(textPaint.drawableState, this.textColor.getDefaultColor()) : -16777216;
        textPaint.setColor(n);
        float f = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        context = this.shadowColor;
        n = context != null ? context.getColorForState(textPaint.drawableState, this.shadowColor.getDefaultColor()) : 0;
        textPaint.setShadowLayer(f, f2, f3, n);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            this.updateTextPaintMeasureState(textPaint, this.getFont(context));
        } else {
            this.getFontAsync(context, textPaint, fontCallback);
            if (this.fontResolved) return;
            this.updateTextPaintMeasureState(textPaint, this.font);
        }
    }

    public void updateTextPaintMeasureState(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int n = this.textStyle;
        n = ~typeface.getStyle() & n;
        boolean bl = (n & 1) != 0;
        textPaint.setFakeBoldText(bl);
        float f = (n & 2) != 0 ? -0.25f : 0.0f;
        textPaint.setTextSkewX(f);
        textPaint.setTextSize(this.textSize);
    }
}
