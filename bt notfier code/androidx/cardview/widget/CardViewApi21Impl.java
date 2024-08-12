/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  androidx.cardview.widget.CardViewDelegate
 *  androidx.cardview.widget.CardViewImpl
 *  androidx.cardview.widget.RoundRectDrawable
 *  androidx.cardview.widget.RoundRectDrawableWithShadow
 */
package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardViewDelegate;
import androidx.cardview.widget.CardViewImpl;
import androidx.cardview.widget.RoundRectDrawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewApi21Impl
implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable)cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getColor();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.getCardView().getElevation();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getPadding();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return this.getRadius(cardViewDelegate) * 2.0f;
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return this.getRadius(cardViewDelegate) * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return this.getCardBackground(cardViewDelegate).getRadius();
    }

    public void initStatic() {
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.setCardBackground((Drawable)new RoundRectDrawable(colorStateList, f));
        context = cardViewDelegate.getCardView();
        context.setClipToOutline(true);
        context.setElevation(f2);
        this.setMaxElevation(cardViewDelegate, f3);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        this.setMaxElevation(cardViewDelegate, this.getMaxElevation(cardViewDelegate));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        this.setMaxElevation(cardViewDelegate, this.getMaxElevation(cardViewDelegate));
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        this.getCardBackground(cardViewDelegate).setColor(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.getCardView().setElevation(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        this.getCardBackground(cardViewDelegate).setPadding(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        this.updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        this.getCardBackground(cardViewDelegate).setRadius(f);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.getUseCompatPadding()) {
            cardViewDelegate.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float f = this.getMaxElevation(cardViewDelegate);
        float f2 = this.getRadius(cardViewDelegate);
        int n = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding((float)f, (float)f2, (boolean)cardViewDelegate.getPreventCornerOverlap()));
        int n2 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding((float)f, (float)f2, (boolean)cardViewDelegate.getPreventCornerOverlap()));
        cardViewDelegate.setShadowPadding(n, n2, n, n2);
    }
}
