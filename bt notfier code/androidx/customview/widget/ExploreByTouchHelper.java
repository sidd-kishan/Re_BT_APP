/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityRecord
 *  androidx.collection.SparseArrayCompat
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewParentCompat
 *  androidx.core.view.accessibility.AccessibilityEventCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  androidx.core.view.accessibility.AccessibilityNodeProviderCompat
 *  androidx.core.view.accessibility.AccessibilityRecordCompat
 *  androidx.customview.widget.ExploreByTouchHelper$MyNodeProvider
 *  androidx.customview.widget.FocusStrategy
 *  androidx.customview.widget.FocusStrategy$BoundsAdapter
 *  androidx.customview.widget.FocusStrategy$CollectionAdapter
 */
package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper
extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new /* Unavailable Anonymous Inner Class!! */;
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new /* Unavailable Anonymous Inner Class!! */;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect;

    public ExploreByTouchHelper(View view) {
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (view == null) throw new IllegalArgumentException("View may not be null");
        this.mHost = view;
        this.mManager = (AccessibilityManager)view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility((View)view) != 0) return;
        ViewCompat.setImportantForAccessibility((View)view, (int)1);
    }

    private boolean clearAccessibilityFocus(int n) {
        if (this.mAccessibilityFocusedVirtualViewId != n) return false;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        this.sendEventForVirtualView(n, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int n = this.mKeyboardFocusedVirtualViewId;
        boolean bl = n != Integer.MIN_VALUE && this.onPerformActionForVirtualView(n, 16, null);
        return bl;
    }

    private AccessibilityEvent createEvent(int n, int n2) {
        if (n == -1) return this.createEventForHost(n2);
        return this.createEventForChild(n, n2);
    }

    private AccessibilityEvent createEventForChild(int n, int n2) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n2);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.obtainAccessibilityNodeInfo(n);
        accessibilityEvent.getText().add(accessibilityNodeInfoCompat.getText());
        accessibilityEvent.setContentDescription(accessibilityNodeInfoCompat.getContentDescription());
        accessibilityEvent.setScrollable(accessibilityNodeInfoCompat.isScrollable());
        accessibilityEvent.setPassword(accessibilityNodeInfoCompat.isPassword());
        accessibilityEvent.setEnabled(accessibilityNodeInfoCompat.isEnabled());
        accessibilityEvent.setChecked(accessibilityNodeInfoCompat.isChecked());
        this.onPopulateEventForVirtualView(n, accessibilityEvent);
        if (accessibilityEvent.getText().isEmpty()) {
            if (accessibilityEvent.getContentDescription() == null) throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEvent.setClassName(accessibilityNodeInfoCompat.getClassName());
        AccessibilityRecordCompat.setSource((AccessibilityRecord)accessibilityEvent, (View)this.mHost, (int)n);
        accessibilityEvent.setPackageName((CharSequence)this.mHost.getContext().getPackageName());
        return accessibilityEvent;
    }

    private AccessibilityEvent createEventForHost(int n) {
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain((int)n);
        this.mHost.onInitializeAccessibilityEvent(accessibilityEvent);
        return accessibilityEvent;
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int n) {
        Object object = AccessibilityNodeInfoCompat.obtain();
        object.setEnabled(true);
        object.setFocusable(true);
        object.setClassName((CharSequence)DEFAULT_CLASS_NAME);
        object.setBoundsInParent(INVALID_PARENT_BOUNDS);
        object.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        object.setParent(this.mHost);
        this.onPopulateNodeForVirtualView(n, (AccessibilityNodeInfoCompat)object);
        if (object.getText() == null) {
            if (object.getContentDescription() == null) throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        object.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals((Object)INVALID_PARENT_BOUNDS)) {
            object = new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
            throw object;
        }
        int n2 = object.getActions();
        if ((n2 & 0x40) != 0) throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        if ((n2 & 0x80) != 0) throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        object.setPackageName((CharSequence)this.mHost.getContext().getPackageName());
        object.setSource(this.mHost, n);
        if (this.mAccessibilityFocusedVirtualViewId == n) {
            object.setAccessibilityFocused(true);
            object.addAction(128);
        } else {
            object.setAccessibilityFocused(false);
            object.addAction(64);
        }
        boolean bl = this.mKeyboardFocusedVirtualViewId == n;
        if (bl) {
            object.addAction(2);
        } else if (object.isFocusable()) {
            object.addAction(1);
        }
        object.setFocused(bl);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        object.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals((Object)INVALID_PARENT_BOUNDS)) {
            object.getBoundsInParent(this.mTempScreenRect);
            if (object.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
                n = object.mParentVirtualDescendantId;
                while (n != -1) {
                    accessibilityNodeInfoCompat.setParent(this.mHost, -1);
                    accessibilityNodeInfoCompat.setBoundsInParent(INVALID_PARENT_BOUNDS);
                    this.onPopulateNodeForVirtualView(n, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
                    this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    n = accessibilityNodeInfoCompat.mParentVirtualDescendantId;
                }
                accessibilityNodeInfoCompat.recycle();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (!this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) return object;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (!this.mTempScreenRect.intersect(this.mTempVisibleRect)) return object;
        object.setBoundsInScreen(this.mTempScreenRect);
        if (!this.isVisibleToUser(this.mTempScreenRect)) return object;
        object.setVisibleToUser(true);
        return object;
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain((View)this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo((View)this.mHost, (AccessibilityNodeInfoCompat)accessibilityNodeInfoCompat);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        this.getVisibleVirtualViews(arrayList);
        if (accessibilityNodeInfoCompat.getChildCount() > 0) {
            if (arrayList.size() > 0) throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int n = 0;
        int n2 = arrayList.size();
        while (n < n2) {
            accessibilityNodeInfoCompat.addChild(this.mHost, arrayList.get(n).intValue());
            ++n;
        }
        return accessibilityNodeInfoCompat;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        this.getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        int n = 0;
        while (n < arrayList.size()) {
            sparseArrayCompat.put(n, (Object)this.createNodeForChild(n));
            ++n;
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int n, Rect rect) {
        this.obtainAccessibilityNodeInfo(n).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int n, Rect rect) {
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        if (n != 17) {
            if (n != 33) {
                if (n != 66) {
                    if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    rect.set(0, -1, n2, -1);
                } else {
                    rect.set(-1, 0, -1, n3);
                }
            } else {
                rect.set(0, n3, n2, n3);
            }
        } else {
            rect.set(n2, 0, n2, n3);
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        boolean bl;
        boolean bl2 = bl = false;
        if (rect == null) return bl2;
        if (rect.isEmpty()) {
            bl2 = bl;
        } else {
            if (this.mHost.getWindowVisibility() != 0) {
                return false;
            }
            rect = this.mHost.getParent();
            while (rect instanceof View) {
                if ((rect = (View)rect).getAlpha() <= 0.0f) return false;
                if (rect.getVisibility() != 0) {
                    return false;
                }
                rect = rect.getParent();
            }
            bl2 = bl;
            if (rect == null) return bl2;
            bl2 = true;
        }
        return bl2;
    }

    private static int keyToDirection(int n) {
        if (n == 19) return 33;
        if (n == 21) return 17;
        if (n == 22) return 66;
        return 130;
    }

    private boolean moveFocus(int n, Rect rect) {
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = this.getAllNodes();
        int n2 = this.mKeyboardFocusedVirtualViewId;
        int n3 = Integer.MIN_VALUE;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = n2 == Integer.MIN_VALUE ? null : (AccessibilityNodeInfoCompat)sparseArrayCompat.get(n2);
        if (n != 1 && n != 2) {
            if (n != 17 && n != 33 && n != 66) {
                if (n != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            n2 = this.mKeyboardFocusedVirtualViewId;
            if (n2 != Integer.MIN_VALUE) {
                this.getBoundsInParent(n2, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                ExploreByTouchHelper.guessPreviouslyFocusedRect(this.mHost, n, rect2);
            }
            rect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(sparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, (Object)accessibilityNodeInfoCompat, (Rect)rect2, (int)n);
        } else {
            boolean bl = ViewCompat.getLayoutDirection((View)this.mHost) == 1;
            rect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(sparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, (Object)accessibilityNodeInfoCompat, (int)n, (boolean)bl, (boolean)false);
        }
        n = rect == null ? n3 : sparseArrayCompat.keyAt(sparseArrayCompat.indexOfValue((Object)rect));
        return this.requestKeyboardFocusForVirtualView(n);
    }

    private boolean performActionForChild(int n, int n2, Bundle bundle) {
        if (n2 == 1) return this.requestKeyboardFocusForVirtualView(n);
        if (n2 == 2) return this.clearKeyboardFocusForVirtualView(n);
        if (n2 == 64) return this.requestAccessibilityFocus(n);
        if (n2 == 128) return this.clearAccessibilityFocus(n);
        return this.onPerformActionForVirtualView(n, n2, bundle);
    }

    private boolean performActionForHost(int n, Bundle bundle) {
        return ViewCompat.performAccessibilityAction((View)this.mHost, (int)n, (Bundle)bundle);
    }

    private boolean requestAccessibilityFocus(int n) {
        if (!this.mManager.isEnabled()) return false;
        if (!this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int n2 = this.mAccessibilityFocusedVirtualViewId;
        if (n2 == n) return false;
        if (n2 != Integer.MIN_VALUE) {
            this.clearAccessibilityFocus(n2);
        }
        this.mAccessibilityFocusedVirtualViewId = n;
        this.mHost.invalidate();
        this.sendEventForVirtualView(n, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int n) {
        int n2 = this.mHoveredVirtualViewId;
        if (n2 == n) {
            return;
        }
        this.mHoveredVirtualViewId = n;
        this.sendEventForVirtualView(n, 128);
        this.sendEventForVirtualView(n2, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int n) {
        if (this.mKeyboardFocusedVirtualViewId != n) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.onVirtualViewKeyboardFocusChanged(n, false);
        this.sendEventForVirtualView(n, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean bl;
        boolean bl2 = this.mManager.isEnabled();
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        if (!this.mManager.isTouchExplorationEnabled()) {
            bl3 = bl;
        } else {
            int n = motionEvent.getAction();
            if (n != 7 && n != 9) {
                if (n != 10) {
                    return false;
                }
                if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) return false;
                this.updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            }
            n = this.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            this.updateHoveredVirtualView(n);
            bl3 = bl;
            if (n == Integer.MIN_VALUE) return bl3;
            bl3 = true;
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n = keyEvent.getAction();
        boolean bl = false;
        int n2 = 0;
        boolean bl2 = bl;
        if (n == 1) return bl2;
        n = keyEvent.getKeyCode();
        if (n != 61) {
            if (n != 66) {
                switch (n) {
                    default: {
                        return bl;
                    }
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: {
                        bl2 = bl;
                        if (!keyEvent.hasNoModifiers()) return bl2;
                        n = ExploreByTouchHelper.keyToDirection(n);
                        int n3 = keyEvent.getRepeatCount();
                        bl2 = false;
                        while (n2 < n3 + 1) {
                            if (!this.moveFocus(n, null)) return bl2;
                            ++n2;
                            bl2 = true;
                        }
                        return bl2;
                    }
                    case 23: 
                }
            }
            bl2 = bl;
            if (!keyEvent.hasNoModifiers()) return bl2;
            bl2 = bl;
            if (keyEvent.getRepeatCount() != 0) return bl2;
            this.clickKeyboardFocusedVirtualView();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return this.moveFocus(2, null);
        }
        bl2 = bl;
        if (!keyEvent.hasModifiers(1)) return bl2;
        return this.moveFocus(1, null);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider != null) return this.mNodeProvider;
        this.mNodeProvider = new MyNodeProvider(this);
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return this.getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float var1, float var2);

    protected abstract void getVisibleVirtualViews(List<Integer> var1);

    public final void invalidateRoot() {
        this.invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int n) {
        this.invalidateVirtualView(n, 0);
    }

    public final void invalidateVirtualView(int n, int n2) {
        if (n == Integer.MIN_VALUE) return;
        if (!this.mManager.isEnabled()) return;
        ViewParent viewParent = this.mHost.getParent();
        if (viewParent == null) return;
        AccessibilityEvent accessibilityEvent = this.createEvent(n, 2048);
        AccessibilityEventCompat.setContentChangeTypes((AccessibilityEvent)accessibilityEvent, (int)n2);
        ViewParentCompat.requestSendAccessibilityEvent((ViewParent)viewParent, (View)this.mHost, (AccessibilityEvent)accessibilityEvent);
    }

    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int n) {
        if (n != -1) return this.createNodeForChild(n);
        return this.createNodeForHost();
    }

    public final void onFocusChanged(boolean bl, int n, Rect rect) {
        int n2 = this.mKeyboardFocusedVirtualViewId;
        if (n2 != Integer.MIN_VALUE) {
            this.clearKeyboardFocusForVirtualView(n2);
        }
        if (!bl) return;
        this.moveFocus(n, rect);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        this.onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        this.onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    protected abstract boolean onPerformActionForVirtualView(int var1, int var2, Bundle var3);

    protected void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int n, AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void onPopulateNodeForVirtualView(int var1, AccessibilityNodeInfoCompat var2);

    protected void onVirtualViewKeyboardFocusChanged(int n, boolean bl) {
    }

    boolean performAction(int n, int n2, Bundle bundle) {
        if (n == -1) return this.performActionForHost(n2, bundle);
        return this.performActionForChild(n, n2, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int n) {
        if (!this.mHost.isFocused() && !this.mHost.requestFocus()) {
            return false;
        }
        int n2 = this.mKeyboardFocusedVirtualViewId;
        if (n2 == n) {
            return false;
        }
        if (n2 != Integer.MIN_VALUE) {
            this.clearKeyboardFocusForVirtualView(n2);
        }
        this.mKeyboardFocusedVirtualViewId = n;
        this.onVirtualViewKeyboardFocusChanged(n, true);
        this.sendEventForVirtualView(n, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int n, int n2) {
        if (n == Integer.MIN_VALUE) return false;
        if (!this.mManager.isEnabled()) {
            return false;
        }
        ViewParent viewParent = this.mHost.getParent();
        if (viewParent == null) {
            return false;
        }
        AccessibilityEvent accessibilityEvent = this.createEvent(n, n2);
        return ViewParentCompat.requestSendAccessibilityEvent((ViewParent)viewParent, (View)this.mHost, (AccessibilityEvent)accessibilityEvent);
    }
}
