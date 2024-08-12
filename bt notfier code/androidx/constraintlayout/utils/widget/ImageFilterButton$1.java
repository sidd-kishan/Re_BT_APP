/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  androidx.constraintlayout.utils.widget.ImageFilterButton
 */
package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

/*
 * Exception performing whole class analysis ignored.
 */
class ImageFilterButton.1
extends ViewOutlineProvider {
    final ImageFilterButton this$0;

    ImageFilterButton.1(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    public void getOutline(View view, Outline outline) {
        int n = this.this$0.getWidth();
        int n2 = this.this$0.getHeight();
        outline.setRoundRect(0, 0, n, n2, (float)Math.min(n, n2) * ImageFilterButton.access$000((ImageFilterButton)this.this$0) / 2.0f);
    }
}
