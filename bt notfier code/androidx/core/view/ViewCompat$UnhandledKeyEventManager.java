/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.R$id
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat
 */
package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/*
 * Exception performing whole class analysis ignored.
 */
static class ViewCompat.UnhandledKeyEventManager {
    private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
    private SparseArray<WeakReference<View>> mCapturedKeys = null;
    private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
    private WeakHashMap<View, Boolean> mViewsContainingListeners = null;

    ViewCompat.UnhandledKeyEventManager() {
    }

    static ViewCompat.UnhandledKeyEventManager at(View view) {
        ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager;
        ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager2 = unhandledKeyEventManager = (ViewCompat.UnhandledKeyEventManager)view.getTag(R.id.tag_unhandled_key_event_manager);
        if (unhandledKeyEventManager != null) return unhandledKeyEventManager2;
        unhandledKeyEventManager2 = new ViewCompat.UnhandledKeyEventManager();
        view.setTag(R.id.tag_unhandled_key_event_manager, (Object)unhandledKeyEventManager2);
        return unhandledKeyEventManager2;
    }

    private View dispatchInOrder(View view, KeyEvent keyEvent) {
        ViewGroup viewGroup = this.mViewsContainingListeners;
        if (viewGroup == null) return null;
        if (!viewGroup.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup)view;
            for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                View view2 = this.dispatchInOrder(viewGroup.getChildAt(i), keyEvent);
                if (view2 == null) continue;
                return view2;
            }
        }
        if (!this.onUnhandledKeyEvent(view, keyEvent)) return null;
        return view;
    }

    private SparseArray<WeakReference<View>> getCapturedKeys() {
        if (this.mCapturedKeys != null) return this.mCapturedKeys;
        this.mCapturedKeys = new SparseArray();
        return this.mCapturedKeys;
    }

    private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList)view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) return false;
        int n = arrayList.size() - 1;
        while (n >= 0) {
            if (((ViewCompat.OnUnhandledKeyEventListenerCompat)arrayList.get(n)).onUnhandledKeyEvent(view, keyEvent)) {
                return true;
            }
            --n;
        }
        return false;
    }

    private void recalcViewsWithUnhandled() {
        View view = this.mViewsContainingListeners;
        if (view != null) {
            view.clear();
        }
        if (sViewsWithListeners.isEmpty()) {
            return;
        }
        ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            if (this.mViewsContainingListeners == null) {
                view = new WeakHashMap();
                this.mViewsContainingListeners = view;
            }
            int n = sViewsWithListeners.size() - 1;
            while (n >= 0) {
                view = (View)sViewsWithListeners.get(n).get();
                if (view == null) {
                    sViewsWithListeners.remove(n);
                } else {
                    this.mViewsContainingListeners.put(view, Boolean.TRUE);
                    view = view.getParent();
                    while (view instanceof View) {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        view = view.getParent();
                    }
                }
                --n;
            }
            return;
        }
    }

    static void registerListeningView(View view) {
        ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            try {
                Object object = sViewsWithListeners.iterator();
                do {
                    if (object.hasNext()) continue;
                    object = sViewsWithListeners;
                    WeakReference<View> weakReference = new WeakReference<View>(view);
                    ((ArrayList)object).add(weakReference);
                    return;
                } while (object.next().get() != view);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    static void unregisterListeningView(View view) {
        ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
        synchronized (arrayList) {
            int n = 0;
            while (n < sViewsWithListeners.size()) {
                if (sViewsWithListeners.get(n).get() == view) {
                    sViewsWithListeners.remove(n);
                    return;
                }
                ++n;
            }
            return;
        }
    }

    boolean dispatch(View view, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            this.recalcViewsWithUnhandled();
        }
        view = this.dispatchInOrder(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int n = keyEvent.getKeyCode();
            if (view != null && !KeyEvent.isModifierKey((int)n)) {
                this.getCapturedKeys().put(n, new WeakReference<View>(view));
            }
        }
        boolean bl = view != null;
        return bl;
    }

    boolean preDispatch(KeyEvent keyEvent) {
        WeakReference weakReference = this.mLastDispatchedPreViewKeyEvent;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        this.mLastDispatchedPreViewKeyEvent = new WeakReference<KeyEvent>(keyEvent);
        WeakReference weakReference2 = null;
        SparseArray<WeakReference<View>> sparseArray = this.getCapturedKeys();
        weakReference = weakReference2;
        if (keyEvent.getAction() == 1) {
            int n = sparseArray.indexOfKey(keyEvent.getKeyCode());
            weakReference = weakReference2;
            if (n >= 0) {
                weakReference = (WeakReference)sparseArray.valueAt(n);
                sparseArray.removeAt(n);
            }
        }
        weakReference2 = weakReference;
        if (weakReference == null) {
            weakReference2 = (WeakReference)sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference2 == null) return false;
        weakReference = (View)weakReference2.get();
        if (weakReference == null) return true;
        if (!ViewCompat.isAttachedToWindow((View)weakReference)) return true;
        this.onUnhandledKeyEvent((View)weakReference, keyEvent);
        return true;
    }
}
