/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.core.view.ViewCompat
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;

/*
 * Exception performing whole class analysis ignored.
 */
static abstract class ViewCompat.AccessibilityViewProperty<T> {
    private final int mContentChangeType;
    private final int mFrameworkMinimumSdk;
    private final int mTagKey;
    private final Class<T> mType;

    ViewCompat.AccessibilityViewProperty(int n, Class<T> clazz, int n2) {
        this(n, clazz, 0, n2);
    }

    ViewCompat.AccessibilityViewProperty(int n, Class<T> clazz, int n2, int n3) {
        this.mTagKey = n;
        this.mType = clazz;
        this.mContentChangeType = n2;
        this.mFrameworkMinimumSdk = n3;
    }

    private boolean extrasAvailable() {
        boolean bl = Build.VERSION.SDK_INT >= 19;
        return bl;
    }

    private boolean frameworkAvailable() {
        boolean bl = Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        return bl;
    }

    boolean booleanNullToFalseEquals(Boolean bl, Boolean bl2) {
        boolean bl3 = false;
        boolean bl4 = bl == null ? false : bl;
        boolean bl5 = bl2 == null ? false : bl2;
        if (bl4 != bl5) return bl3;
        bl3 = true;
        return bl3;
    }

    abstract T frameworkGet(View var1);

    abstract void frameworkSet(View var1, T var2);

    T get(View object) {
        if (this.frameworkAvailable()) {
            return this.frameworkGet((View)object);
        }
        if (!this.extrasAvailable()) return null;
        if (!this.mType.isInstance(object = object.getTag(this.mTagKey))) return null;
        return (T)object;
    }

    void set(View view, T t) {
        if (this.frameworkAvailable()) {
            this.frameworkSet(view, t);
        } else {
            if (!this.extrasAvailable()) return;
            if (!this.shouldUpdate(this.get(view), t)) return;
            ViewCompat.getOrCreateAccessibilityDelegateCompat((View)view);
            view.setTag(this.mTagKey, t);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded((View)view, (int)this.mContentChangeType);
        }
    }

    boolean shouldUpdate(T t, T t2) {
        return t2.equals(t) ^ true;
    }
}
