/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public class Space
extends View {
    @Deprecated
    public Space(Context context) {
        this(context, null);
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        if (this.getVisibility() != 0) return;
        this.setVisibility(4);
    }

    private static int getDefaultSize2(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        if (n3 != Integer.MIN_VALUE) {
            if (n3 != 0x40000000) return n;
            n = n2;
        } else {
            n = Math.min(n, n2);
        }
        return n;
    }

    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Deprecated
    protected void onMeasure(int n, int n2) {
        this.setMeasuredDimension(Space.getDefaultSize2(this.getSuggestedMinimumWidth(), n), Space.getDefaultSize2(this.getSuggestedMinimumHeight(), n2));
    }
}
