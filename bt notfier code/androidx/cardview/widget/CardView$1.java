/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  androidx.cardview.widget.CardView
 *  androidx.cardview.widget.CardViewDelegate
 */
package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.CardViewDelegate;

/*
 * Exception performing whole class analysis ignored.
 */
class CardView.1
implements CardViewDelegate {
    private Drawable mCardBackground;
    final CardView this$0;

    CardView.1(CardView cardView) {
        this.this$0 = cardView;
    }

    public Drawable getCardBackground() {
        return this.mCardBackground;
    }

    public View getCardView() {
        return this.this$0;
    }

    public boolean getPreventCornerOverlap() {
        return this.this$0.getPreventCornerOverlap();
    }

    public boolean getUseCompatPadding() {
        return this.this$0.getUseCompatPadding();
    }

    public void setCardBackground(Drawable drawable) {
        this.mCardBackground = drawable;
        this.this$0.setBackgroundDrawable(drawable);
    }

    public void setMinWidthHeightInternal(int n, int n2) {
        if (n > this.this$0.mUserSetMinWidth) {
            CardView.access$101((CardView)this.this$0, (int)n);
        }
        if (n2 <= this.this$0.mUserSetMinHeight) return;
        CardView.access$201((CardView)this.this$0, (int)n2);
    }

    public void setShadowPadding(int n, int n2, int n3, int n4) {
        this.this$0.mShadowBounds.set(n, n2, n3, n4);
        CardView cardView = this.this$0;
        CardView.access$001((CardView)cardView, (int)(n + cardView.mContentPadding.left), (int)(n2 + this.this$0.mContentPadding.top), (int)(n3 + this.this$0.mContentPadding.right), (int)(n4 + this.this$0.mContentPadding.bottom));
    }
}
