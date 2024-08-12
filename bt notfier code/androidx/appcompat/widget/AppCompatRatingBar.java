/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.RatingBar
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatProgressBarHelper
 *  androidx.appcompat.widget.ThemeUtils
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatProgressBarHelper;
import androidx.appcompat.widget.ThemeUtils;

public class AppCompatRatingBar
extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatProgressBarHelper((ProgressBar)this);
        this.mAppCompatProgressBarHelper = context;
        context.loadFromAttributes(attributeSet, n);
    }

    protected void onMeasure(int n, int n2) {
        synchronized (this) {
            super.onMeasure(n, n2);
            Bitmap bitmap = this.mAppCompatProgressBarHelper.getSampleTile();
            if (bitmap == null) return;
            this.setMeasuredDimension(View.resolveSizeAndState((int)(bitmap.getWidth() * this.getNumStars()), (int)n, (int)0), this.getMeasuredHeight());
            return;
        }
    }
}
