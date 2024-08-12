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
class ImageFilterButton.2
extends ViewOutlineProvider {
    final ImageFilterButton this$0;

    ImageFilterButton.2(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterButton.access$100((ImageFilterButton)this.this$0));
    }
}
