/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Layout
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.AppCompatTextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatTextView;

public class DialogTitle
extends AppCompatTextView {
    public DialogTitle(Context context) {
        super(context);
    }

    public DialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        Layout layout = this.getLayout();
        if (layout == null) return;
        int n3 = layout.getLineCount();
        if (n3 <= 0) return;
        if (layout.getEllipsisCount(n3 - 1) <= 0) return;
        this.setSingleLine(false);
        this.setMaxLines(2);
        layout = this.getContext().obtainStyledAttributes(null, R.styleable.TextAppearance, 0x1010041, 16973892);
        n3 = layout.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (n3 != 0) {
            this.setTextSize(0, n3);
        }
        layout.recycle();
        super.onMeasure(n, n2);
    }
}
