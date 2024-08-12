/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ProgressBar
 *  androidx.core.widget._$$Lambda$ContentLoadingProgressBar$aW9csiS0dCdsR2nrqov9CuXAmGo
 *  androidx.core.widget._$$Lambda$ContentLoadingProgressBar$kZvB_uNUZRE2fd9TBZnBWymih7M
 *  androidx.core.widget._$$Lambda$ContentLoadingProgressBar$o6JtaSRcipUt7wQgtZoEeLlTyXE
 *  androidx.core.widget._$$Lambda$ContentLoadingProgressBar$sKUdpe5w2n1AvcCiQWHq34vJNZg
 */
package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.widget._$;

public class ContentLoadingProgressBar
extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide = new _$.Lambda.ContentLoadingProgressBar.aW9csiS0dCdsR2nrqov9CuXAmGo(this);
    private final Runnable mDelayedShow = new _$.Lambda.ContentLoadingProgressBar.o6JtaSRcipUt7wQgtZoEeLlTyXE(this);
    boolean mDismissed = false;
    boolean mPostedHide = false;
    boolean mPostedShow = false;
    long mStartTime = -1L;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    private void hideOnUiThread() {
        this.mDismissed = true;
        this.removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long l = System.currentTimeMillis();
        long l2 = this.mStartTime;
        if ((l -= l2) < 500L && l2 != -1L) {
            if (this.mPostedHide) return;
            this.postDelayed(this.mDelayedHide, 500L - l);
            this.mPostedHide = true;
        } else {
            this.setVisibility(8);
        }
    }

    public static /* synthetic */ void lambda$kZvB_uNUZRE2fd9TBZnBWymih7M(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.showOnUiThread();
    }

    public static /* synthetic */ void lambda$sKUdpe5w2n1AvcCiQWHq34vJNZg(ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.hideOnUiThread();
    }

    private void removeCallbacks() {
        this.removeCallbacks(this.mDelayedHide);
        this.removeCallbacks(this.mDelayedShow);
    }

    private void showOnUiThread() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        this.removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow) return;
        this.postDelayed(this.mDelayedShow, 500L);
        this.mPostedShow = true;
    }

    public void hide() {
        this.post((Runnable)new _$.Lambda.ContentLoadingProgressBar.sKUdpe5w2n1AvcCiQWHq34vJNZg(this));
    }

    public /* synthetic */ void lambda$new$0$ContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1L;
        this.setVisibility(8);
    }

    public /* synthetic */ void lambda$new$1$ContentLoadingProgressBar() {
        this.mPostedShow = false;
        if (this.mDismissed) return;
        this.mStartTime = System.currentTimeMillis();
        this.setVisibility(0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }

    public void show() {
        this.post((Runnable)new _$.Lambda.ContentLoadingProgressBar.kZvB_uNUZRE2fd9TBZnBWymih7M(this));
    }
}
