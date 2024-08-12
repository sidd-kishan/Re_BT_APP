/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.core.view.ViewCompat
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/*
 * Exception performing whole class analysis ignored.
 */
static class ViewCompat.AccessibilityPaneVisibilityManager
implements ViewTreeObserver.OnGlobalLayoutListener,
View.OnAttachStateChangeListener {
    private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap();

    ViewCompat.AccessibilityPaneVisibilityManager() {
    }

    private void checkPaneVisibility(View view, boolean bl) {
        boolean bl2 = view.getVisibility() == 0;
        if (bl == bl2) return;
        int n = bl2 ? 16 : 32;
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded((View)view, (int)n);
        this.mPanesToVisible.put(view, bl2);
    }

    private void registerForLayoutCallback(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    private void unregisterForLayoutCallback(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    void addAccessibilityPane(View view) {
        WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
        boolean bl = view.getVisibility() == 0;
        weakHashMap.put(view, bl);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        if (!view.isAttachedToWindow()) return;
        this.registerForLayoutCallback(view);
    }

    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= 28) return;
        Iterator<Map.Entry<View, Boolean>> iterator = this.mPanesToVisible.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<View, Boolean> entry = iterator.next();
            this.checkPaneVisibility(entry.getKey(), entry.getValue());
        }
    }

    public void onViewAttachedToWindow(View view) {
        this.registerForLayoutCallback(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }

    void removeAccessibilityPane(View view) {
        this.mPanesToVisible.remove(view);
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.unregisterForLayoutCallback(view);
    }
}
