/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.PopupWindow
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.widget.PopupWindowCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow
extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR;
    private boolean mOverlapAnchor;

    static {
        boolean bl = Build.VERSION.SDK_INT < 21;
        COMPAT_OVERLAP_ANCHOR = bl;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet, n, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context, attributeSet, n, n2);
    }

    private void init(Context context, AttributeSet attributeSet, int n, int n2) {
        if ((context = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.PopupWindow, (int)n, (int)n2)).hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            this.setSupportOverlapAnchor(context.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        this.setBackgroundDrawable(context.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        context.recycle();
    }

    private void setSupportOverlapAnchor(boolean bl) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = bl;
        } else {
            PopupWindowCompat.setOverlapAnchor((PopupWindow)this, (boolean)bl);
        }
    }

    public void showAsDropDown(View view, int n, int n2) {
        int n3 = n2;
        if (COMPAT_OVERLAP_ANCHOR) {
            n3 = n2;
            if (this.mOverlapAnchor) {
                n3 = n2 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n, n3);
    }

    public void showAsDropDown(View view, int n, int n2, int n3) {
        int n4 = n2;
        if (COMPAT_OVERLAP_ANCHOR) {
            n4 = n2;
            if (this.mOverlapAnchor) {
                n4 = n2 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n, n4, n3);
    }

    public void update(View view, int n, int n2, int n3, int n4) {
        int n5 = n2;
        if (COMPAT_OVERLAP_ANCHOR) {
            n5 = n2;
            if (this.mOverlapAnchor) {
                n5 = n2 - view.getHeight();
            }
        }
        super.update(view, n, n5, n3, n4);
    }
}
