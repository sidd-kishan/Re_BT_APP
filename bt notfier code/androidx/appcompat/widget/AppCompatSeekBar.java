/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  android.widget.SeekBar
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatSeekBarHelper
 *  androidx.appcompat.widget.ThemeUtils
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatSeekBarHelper;
import androidx.appcompat.widget.ThemeUtils;

public class AppCompatSeekBar
extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        ThemeUtils.checkAppCompatTheme((View)this, (Context)this.getContext());
        context = new AppCompatSeekBarHelper((SeekBar)this);
        this.mAppCompatSeekBarHelper = context;
        context.loadFromAttributes(attributeSet, n);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    protected void onDraw(Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            this.mAppCompatSeekBarHelper.drawTickMarks(canvas);
            return;
        }
    }
}
