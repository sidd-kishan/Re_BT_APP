/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.DropDownListView$GateKeeperDrawable
 *  androidx.appcompat.widget.DropDownListView$ResolveHoverRunnable
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.widget.ListViewAutoScrollHelper
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.widget.DropDownListView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

class DropDownListView
extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding = 0;
    private int mSelectionLeftPadding = 0;
    private int mSelectionRightPadding = 0;
    private int mSelectionTopPadding = 0;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect = new Rect();

    DropDownListView(Context object, boolean bl) {
        super((Context)object, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = bl;
        this.setCacheColorHint(0);
        try {
            object = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled = object;
            ((AccessibleObject)object).setAccessible(true);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View view = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
        if (view != null) {
            view.setPressed(false);
        }
        if ((view = this.mClickAnimation) == null) return;
        view.cancel();
        this.mClickAnimation = null;
    }

    private void clickPressedItem(View view, int n) {
        this.performItemClick(view, n, this.getItemIdAtPosition(n));
    }

    private void drawSelectorCompat(Canvas canvas) {
        if (this.mSelectorRect.isEmpty()) return;
        Drawable drawable = this.getSelector();
        if (drawable == null) return;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    private void positionSelectorCompat(int n, View object) {
        Rect rect = this.mSelectorRect;
        rect.set(object.getLeft(), object.getTop(), object.getRight(), object.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        try {
            boolean bl = this.mIsChildViewEnabled.getBoolean((Object)this);
            if (object.isEnabled() == bl) return;
            object = this.mIsChildViewEnabled;
            bl = !bl;
            ((Field)object).set((Object)this, bl);
            if (n == -1) return;
            this.refreshDrawableState();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    private void positionSelectorLikeFocusCompat(int n, View view) {
        Drawable drawable = this.getSelector();
        boolean bl = true;
        boolean bl2 = drawable != null && n != -1;
        if (bl2) {
            drawable.setVisible(false, false);
        }
        this.positionSelectorCompat(n, view);
        if (!bl2) return;
        view = this.mSelectorRect;
        float f = view.exactCenterX();
        float f2 = view.exactCenterY();
        if (this.getVisibility() != 0) {
            bl = false;
        }
        drawable.setVisible(bl, false);
        DrawableCompat.setHotspot((Drawable)drawable, (float)f, (float)f2);
    }

    private void positionSelectorLikeTouchCompat(int n, View view, float f, float f2) {
        this.positionSelectorLikeFocusCompat(n, view);
        view = this.getSelector();
        if (view == null) return;
        if (n == -1) return;
        DrawableCompat.setHotspot((Drawable)view, (float)f, (float)f2);
    }

    private void setPressedItem(View view, int n, float f, float f2) {
        View view2;
        this.mDrawsInPressedState = true;
        if (Build.VERSION.SDK_INT >= 21) {
            this.drawableHotspotChanged(f, f2);
        }
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        int n2 = this.mMotionPosition;
        if (n2 != -1 && (view2 = this.getChildAt(n2 - this.getFirstVisiblePosition())) != null && view2 != view && view2.isPressed()) {
            view2.setPressed(false);
        }
        this.mMotionPosition = n;
        float f3 = view.getLeft();
        float f4 = view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(f - f3, f2 - f4);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.positionSelectorLikeTouchCompat(n, view, f, f2);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    private void setSelectorEnabled(boolean bl) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable == null) return;
        gateKeeperDrawable.setEnabled(bl);
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable drawable = this.getSelector();
        if (drawable == null) return;
        if (!this.touchModeDrawsInPressedStateCompat()) return;
        if (!this.isPressed()) return;
        drawable.setState(this.getDrawableState());
    }

    protected void dispatchDraw(Canvas canvas) {
        this.drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }

    public boolean hasFocus() {
        boolean bl = this.mHijackFocus || super.hasFocus();
        return bl;
    }

    public boolean hasWindowFocus() {
        boolean bl = this.mHijackFocus || super.hasWindowFocus();
        return bl;
    }

    public boolean isFocused() {
        boolean bl = this.mHijackFocus || super.isFocused();
        return bl;
    }

    public boolean isInTouchMode() {
        boolean bl = this.mHijackFocus && this.mListSelectionHidden || super.isInTouchMode();
        return bl;
    }

    public int lookForSelectablePosition(int n, boolean bl) {
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) return -1;
        if (this.isInTouchMode()) return -1;
        int n2 = listAdapter.getCount();
        if (!this.getAdapter().areAllItemsEnabled()) {
            int n3;
            if (bl) {
                n = Math.max(0, n);
                while (true) {
                    n3 = n;
                    if (n < n2) {
                        n3 = n;
                        if (!listAdapter.isEnabled(n)) {
                            ++n;
                            continue;
                        }
                    }
                    break;
                }
            } else {
                n = Math.min(n, n2 - 1);
                while (true) {
                    n3 = n;
                    if (n < 0) break;
                    n3 = n;
                    if (listAdapter.isEnabled(n)) break;
                    --n;
                }
            }
            if (n3 < 0) return -1;
            if (n3 < n2) return n3;
            return -1;
        }
        if (n < 0) return -1;
        if (n < n2) return n;
        return -1;
    }

    public int measureHeightOfChildrenCompat(int n, int n2, int n3, int n4, int n5) {
        n2 = this.getListPaddingTop();
        n3 = this.getListPaddingBottom();
        int n6 = this.getDividerHeight();
        Drawable drawable = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) {
            return n2 + n3;
        }
        n3 = n2 + n3;
        if (n6 <= 0 || drawable == null) {
            n6 = 0;
        }
        int n7 = listAdapter.getCount();
        drawable = null;
        int n8 = 0;
        int n9 = 0;
        n2 = 0;
        while (n8 < n7) {
            int n10 = listAdapter.getItemViewType(n8);
            int n11 = n9;
            if (n10 != n9) {
                drawable = null;
                n11 = n10;
            }
            View view = listAdapter.getView(n8, (View)drawable, (ViewGroup)this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            drawable = layoutParams;
            if (layoutParams == null) {
                drawable = this.generateDefaultLayoutParams();
                view.setLayoutParams((ViewGroup.LayoutParams)drawable);
            }
            n9 = drawable.height > 0 ? View.MeasureSpec.makeMeasureSpec((int)drawable.height, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            view.measure(n, n9);
            view.forceLayout();
            n9 = n3;
            if (n8 > 0) {
                n9 = n3 + n6;
            }
            if ((n3 = n9 + view.getMeasuredHeight()) >= n4) {
                n = n4;
                if (n5 < 0) return n;
                n = n4;
                if (n8 <= n5) return n;
                n = n4;
                if (n2 <= 0) return n;
                n = n4;
                if (n3 == n4) return n;
                n = n2;
                return n;
            }
            n10 = n2;
            if (n5 >= 0) {
                n10 = n2;
                if (n8 >= n5) {
                    n10 = n3;
                }
            }
            ++n8;
            n9 = n11;
            drawable = view;
            n2 = n10;
        }
        return n3;
    }

    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /*
     * Unable to fully structure code
     */
    public boolean onForwardedEvent(MotionEvent var1_1, int var2_2) {
        block11: {
            block9: {
                block10: {
                    var3_3 = var1_1.getActionMasked();
                    if (var3_3 == 1) break block9;
                    if (var3_3 == 2) break block10;
                    if (var3_3 == 3) ** GOTO lbl-1000
                    ** GOTO lbl26
                }
                var6_4 = true;
                break block11;
            }
            var6_4 = false;
        }
        var4_5 = var1_1.findPointerIndex(var2_2);
        if (var4_5 < 0) lbl-1000:
        // 2 sources

        {
            var2_2 = 0;
            var6_4 = false;
        } else {
            var2_2 = (int)var1_1.getX(var4_5);
            var5_6 = this.pointToPosition(var2_2, var4_5 = (int)var1_1.getY(var4_5));
            if (var5_6 == -1) {
                var2_2 = 1;
            } else {
                var7_7 = this.getChildAt(var5_6 - this.getFirstVisiblePosition());
                this.setPressedItem(var7_7, var5_6, var2_2, var4_5);
                if (var3_3 == 1) {
                    this.clickPressedItem(var7_7, var5_6);
                }
lbl26:
                // 4 sources

                var2_2 = 0;
                var6_4 = true;
            }
        }
        if (!var6_4 || var2_2 != 0) {
            this.clearPressedItem();
        }
        if (var6_4) {
            if (this.mScrollHelper == null) {
                this.mScrollHelper = new ListViewAutoScrollHelper((ListView)this);
            }
            this.mScrollHelper.setEnabled(true);
            this.mScrollHelper.onTouch((View)this, var1_1);
        } else {
            var1_1 = this.mScrollHelper;
            if (var1_1 == null) return var6_4;
            var1_1.setEnabled(false);
        }
        return var6_4;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int n = motionEvent.getActionMasked();
        if (n == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable resolveHoverRunnable;
            this.mResolveHoverRunnable = resolveHoverRunnable = new ResolveHoverRunnable(this);
            resolveHoverRunnable.post();
        }
        boolean bl = super.onHoverEvent(motionEvent);
        if (n != 9 && n != 7) {
            this.setSelection(-1);
        } else {
            n = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
            if (n == -1) return bl;
            if (n == this.getSelectedItemPosition()) return bl;
            motionEvent = this.getChildAt(n - this.getFirstVisiblePosition());
            if (motionEvent.isEnabled()) {
                this.setSelectionFromTop(n, motionEvent.getTop() - this.getTop());
            }
            this.updateSelectorStateCompat();
        }
        return bl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable == null) return super.onTouchEvent(motionEvent);
        resolveHoverRunnable.cancel();
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean bl) {
        this.mListSelectionHidden = bl;
    }

    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.mSelector = gateKeeperDrawable;
        super.setSelector((Drawable)gateKeeperDrawable);
        gateKeeperDrawable = new Rect();
        if (drawable != null) {
            drawable.getPadding((Rect)gateKeeperDrawable);
        }
        this.mSelectionLeftPadding = gateKeeperDrawable.left;
        this.mSelectionTopPadding = gateKeeperDrawable.top;
        this.mSelectionRightPadding = gateKeeperDrawable.right;
        this.mSelectionBottomPadding = gateKeeperDrawable.bottom;
    }
}
