/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.ContentFrameLayout
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ContentFrameLayout;

private class AppCompatDelegateImpl.ListMenuDecorView
extends ContentFrameLayout {
    final AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl.ListMenuDecorView(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
        this.this$0 = appCompatDelegateImpl;
        super(context);
    }

    private boolean isOutOfBounds(int n, int n2) {
        boolean bl = n < -5 || n2 < -5 || n > this.getWidth() + 5 || n2 > this.getHeight() + 5;
        return bl;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl = this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        return bl;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) return super.onInterceptTouchEvent(motionEvent);
        if (!this.isOutOfBounds((int)motionEvent.getX(), (int)motionEvent.getY())) return super.onInterceptTouchEvent(motionEvent);
        this.this$0.closePanel(0);
        return true;
    }

    public void setBackgroundResource(int n) {
        this.setBackgroundDrawable(AppCompatResources.getDrawable((Context)this.getContext(), (int)n));
    }
}
