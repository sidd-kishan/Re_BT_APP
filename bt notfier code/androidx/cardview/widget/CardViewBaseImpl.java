/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  androidx.cardview.widget.CardViewDelegate
 *  androidx.cardview.widget.CardViewImpl
 *  androidx.cardview.widget.RoundRectDrawableWithShadow
 */
package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewBaseImpl
implements CardViewImpl {
    final RectF mCornerRect = new RectF();

    CardViewBaseImpl() {
    }

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow)cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getColor();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getShadowSize();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMinHeight();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getMinWidth();
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return this.getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new /* Unavailable Anonymous Inner Class!! */;
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        context = this.createBackground(context, colorStateList, f, f2, f3);
        context.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground((Drawable)context);
        this.updatePadding(cardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        this.getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        this.updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        this.getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        this.getShadowBackground(cardViewDelegate).setShadowSize(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        this.getShadowBackground(cardViewDelegate).setMaxShadowSize(f);
        this.updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        this.getShadowBackground(cardViewDelegate).setCornerRadius(f);
        this.updatePadding(cardViewDelegate);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        this.getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        cardViewDelegate.setMinWidthHeightInternal((int)Math.ceil(this.getMinWidth(cardViewDelegate)), (int)Math.ceil(this.getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
