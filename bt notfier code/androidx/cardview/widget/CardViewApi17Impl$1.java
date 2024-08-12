/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  androidx.cardview.widget.CardViewApi17Impl
 *  androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper
 */
package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.CardViewApi17Impl;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewApi17Impl.1
implements RoundRectDrawableWithShadow.RoundRectHelper {
    final CardViewApi17Impl this$0;

    CardViewApi17Impl.1(CardViewApi17Impl cardViewApi17Impl) {
        this.this$0 = cardViewApi17Impl;
    }

    public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
