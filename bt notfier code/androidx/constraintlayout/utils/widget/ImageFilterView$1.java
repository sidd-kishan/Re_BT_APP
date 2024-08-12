/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  androidx.constraintlayout.utils.widget.ImageFilterView
 */
package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/*
 * Exception performing whole class analysis ignored.
 */
class ImageFilterView.1
extends ViewOutlineProvider {
    final ImageFilterView this$0;

    ImageFilterView.1(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    public void getOutline(View view, Outline outline) {
        int n = this.this$0.getWidth();
        int n2 = this.this$0.getHeight();
        outline.setRoundRect(0, 0, n, n2, (float)Math.min(n, n2) * ImageFilterView.access$000((ImageFilterView)this.this$0) / 2.0f);
    }
}
