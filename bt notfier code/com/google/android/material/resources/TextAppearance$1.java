/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 *  com.google.android.material.resources.TextAppearance
 */
package com.google.android.material.resources;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.resources.TextAppearance;

/*
 * Exception performing whole class analysis ignored.
 */
class TextAppearance.1
extends ResourcesCompat.FontCallback {
    final TextAppearance this$0;
    final ResourcesCompat.FontCallback val$callback;
    final TextPaint val$textPaint;

    TextAppearance.1(TextAppearance textAppearance, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        this.this$0 = textAppearance;
        this.val$textPaint = textPaint;
        this.val$callback = fontCallback;
    }

    public void onFontRetrievalFailed(int n) {
        TextAppearance.access$200((TextAppearance)this.this$0);
        TextAppearance.access$102((TextAppearance)this.this$0, (boolean)true);
        this.val$callback.onFontRetrievalFailed(n);
    }

    public void onFontRetrieved(Typeface typeface) {
        TextAppearance textAppearance = this.this$0;
        TextAppearance.access$002((TextAppearance)textAppearance, (Typeface)Typeface.create((Typeface)typeface, (int)textAppearance.textStyle));
        this.this$0.updateTextPaintMeasureState(this.val$textPaint, typeface);
        TextAppearance.access$102((TextAppearance)this.this$0, (boolean)true);
        this.val$callback.onFontRetrieved(typeface);
    }
}
