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
class ImageFilterView.2
extends ViewOutlineProvider {
    final ImageFilterView this$0;

    ImageFilterView.2(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterView.access$100((ImageFilterView)this.this$0));
    }
}
