/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.INotchInsetConsumer
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 */
package com.qmuiteam.qmui.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.INotchInsetConsumer;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;
import java.lang.ref.WeakReference;

public class QMUIWindowInsetHelper {
    private static final Object KEYBOARD_CONSUMER = new Object();
    private final int KEYBOARD_HEIGHT_BOUNDARY;
    private final WeakReference<IWindowInsetLayout> mWindowInsetLayoutWR;
    private int sApplySystemWindowInsetsCount = 0;

    public QMUIWindowInsetHelper(ViewGroup viewGroup, IWindowInsetLayout iWindowInsetLayout) {
        this.mWindowInsetLayoutWR = new WeakReference<IWindowInsetLayout>(iWindowInsetLayout);
        this.KEYBOARD_HEIGHT_BOUNDARY = QMUIDisplayHelper.dp2px((Context)viewGroup.getContext(), (int)100);
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            this.setOnApplyWindowInsetsListener28(viewGroup);
        } else {
            ViewCompat.setOnApplyWindowInsetsListener((View)viewGroup, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    static /* synthetic */ WeakReference access$000(QMUIWindowInsetHelper qMUIWindowInsetHelper) {
        return qMUIWindowInsetHelper.mWindowInsetLayoutWR;
    }

    private void dispatchNotchInsetChange(View view) {
        if (view instanceof INotchInsetConsumer && ((INotchInsetConsumer)view).notifyInsetMaybeChanged()) {
            return;
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = view.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            this.dispatchNotchInsetChange(view.getChildAt(n2));
            ++n2;
        }
    }

    public static View findKeyboardAreaConsumer(View view) {
        while (view != null) {
            Object object = view.getTag(R.id.qmui_window_inset_keyboard_area_consumer);
            if (KEYBOARD_CONSUMER == object) {
                return view;
            }
            if ((view = view.getParent()) instanceof View) continue;
            view = null;
        }
        return null;
    }

    public static boolean isHandleContainer(View view) {
        boolean bl = view instanceof IWindowInsetLayout || view instanceof CoordinatorLayout;
        return bl;
    }

    public static boolean jumpDispatch(View view) {
        boolean bl = !view.getFitsSystemWindows() && !QMUIWindowInsetHelper.isHandleContainer(view);
        return bl;
    }

    private void setOnApplyWindowInsetsListener28(ViewGroup viewGroup) {
        viewGroup.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void computeInsetsWithGravity(View view, Rect rect) {
        int n = (view = view.getLayoutParams()) instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams)view).gravity : -1;
        int n2 = n;
        if (n == -1) {
            n2 = 51;
        }
        if (view.width != -1) {
            n = n2 & 7;
            if (n != 3) {
                if (n == 5) {
                    rect.left = 0;
                }
            } else {
                rect.right = 0;
            }
        }
        if (view.height == -1) return;
        n = n2 & 0x70;
        if (n != 48) {
            if (n != 80) return;
            rect.top = 0;
        } else {
            rect.bottom = 0;
        }
    }

    public boolean defaultApplySystemWindowInsets(ViewGroup viewGroup, WindowInsets windowInsets) {
        ++this.sApplySystemWindowInsetsCount;
        WindowInsets windowInsets2 = windowInsets;
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            if (this.sApplySystemWindowInsetsCount == 1) {
                this.dispatchNotchInsetChange((View)viewGroup);
            }
            windowInsets2 = windowInsets.consumeDisplayCutout();
        }
        boolean bl = windowInsets2.hasSystemWindowInsets();
        boolean bl2 = false;
        if (bl) {
            boolean bl3;
            if (windowInsets2.getSystemWindowInsetBottom() >= this.KEYBOARD_HEIGHT_BOUNDARY) {
                QMUIViewHelper.setPaddingBottom((View)viewGroup, (int)windowInsets2.getSystemWindowInsetBottom());
                viewGroup.setTag(R.id.qmui_window_inset_keyboard_area_consumer, KEYBOARD_CONSUMER);
                bl3 = true;
            } else {
                QMUIViewHelper.setPaddingBottom((View)viewGroup, (int)0);
                viewGroup.setTag(R.id.qmui_window_inset_keyboard_area_consumer, null);
                bl3 = false;
            }
            bl2 = false;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                View view = viewGroup.getChildAt(i);
                if (QMUIWindowInsetHelper.jumpDispatch(view)) continue;
                int n = windowInsets2.getSystemWindowInsetLeft();
                int n2 = windowInsets2.getSystemWindowInsetTop();
                int n3 = windowInsets2.getSystemWindowInsetRight();
                int n4 = bl3 ? 0 : windowInsets2.getSystemWindowInsetBottom();
                windowInsets = new Rect(n, n2, n3, n4);
                this.computeInsetsWithGravity(view, (Rect)windowInsets);
                windowInsets = view.dispatchApplyWindowInsets(windowInsets2.replaceSystemWindowInsets((Rect)windowInsets));
                if (!bl2 && !windowInsets.isConsumed()) {
                    bl2 = false;
                    continue;
                }
                bl2 = true;
            }
        }
        --this.sApplySystemWindowInsetsCount;
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    public boolean defaultApplySystemWindowInsets19(ViewGroup var1_1, Rect var2_2) {
        if (var2_2.bottom >= this.KEYBOARD_HEIGHT_BOUNDARY) {
            QMUIViewHelper.setPaddingBottom((View)var1_1, (int)var2_2.bottom);
            var1_1.setTag(R.id.qmui_window_inset_keyboard_area_consumer, QMUIWindowInsetHelper.KEYBOARD_CONSUMER);
            var2_2.bottom = 0;
        } else {
            var1_1.setTag(R.id.qmui_window_inset_keyboard_area_consumer, null);
            QMUIViewHelper.setPaddingBottom((View)var1_1, (int)0);
        }
        var3_3 = 0;
        var4_4 = false;
        while (var3_3 < var1_1.getChildCount()) {
            block5: {
                block7: {
                    block6: {
                        var6_6 = var1_1.getChildAt(var3_3);
                        if (QMUIWindowInsetHelper.jumpDispatch(var6_6)) break block5;
                        var7_7 = new Rect(var2_2);
                        this.computeInsetsWithGravity(var6_6, var7_7);
                        if (QMUIWindowInsetHelper.isHandleContainer(var6_6)) break block6;
                        var6_6.setPadding(var7_7.left, var7_7.top, var7_7.right, var7_7.bottom);
                        break block5;
                    }
                    if (!(var6_6 instanceof IWindowInsetLayout)) break block7;
                    var5_5 = ((IWindowInsetLayout)var6_6).applySystemWindowInsets19(var7_7);
                    if (!var4_4 && !var5_5) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                var5_5 = this.defaultApplySystemWindowInsets19((ViewGroup)var6_6, var7_7);
                if (!var4_4 && !var5_5) lbl-1000:
                // 2 sources

                {
                    var4_4 = false;
                } else lbl-1000:
                // 2 sources

                {
                    var4_4 = true;
                }
            }
            ++var3_3;
        }
        return var4_4;
    }

    public boolean defaultApplySystemWindowInsets21(ViewGroup viewGroup, Object object) {
        if (!QMUINotchHelper.isNotchOfficialSupport()) return this.defaultApplySystemWindowInsetsCompat(viewGroup, (WindowInsetsCompat)object);
        return this.defaultApplySystemWindowInsets(viewGroup, (WindowInsets)object);
    }

    public boolean defaultApplySystemWindowInsetsCompat(ViewGroup viewGroup, WindowInsetsCompat windowInsetsCompat) {
        boolean bl;
        if (!windowInsetsCompat.hasSystemWindowInsets()) {
            return false;
        }
        if (windowInsetsCompat.getSystemWindowInsetBottom() >= this.KEYBOARD_HEIGHT_BOUNDARY) {
            QMUIViewHelper.setPaddingBottom((View)viewGroup, (int)windowInsetsCompat.getSystemWindowInsetBottom());
            viewGroup.setTag(R.id.qmui_window_inset_keyboard_area_consumer, KEYBOARD_CONSUMER);
            bl = true;
        } else {
            QMUIViewHelper.setPaddingBottom((View)viewGroup, (int)0);
            viewGroup.setTag(R.id.qmui_window_inset_keyboard_area_consumer, null);
            bl = false;
        }
        int n = 0;
        boolean bl2 = false;
        while (n < viewGroup.getChildCount()) {
            View view = viewGroup.getChildAt(n);
            if (!QMUIWindowInsetHelper.jumpDispatch(view)) {
                int n2 = windowInsetsCompat.getSystemWindowInsetLeft();
                int n3 = windowInsetsCompat.getSystemWindowInsetRight();
                int n4 = n2;
                int n5 = n3;
                if (QMUINotchHelper.needFixLandscapeNotchAreaFitSystemWindow((View)viewGroup)) {
                    n4 = n2;
                    n5 = n3;
                    if (viewGroup.getResources().getConfiguration().orientation == 2) {
                        n4 = Math.max(n2, QMUINotchHelper.getSafeInsetLeft((View)viewGroup));
                        n5 = Math.max(n3, QMUINotchHelper.getSafeInsetRight((View)viewGroup));
                    }
                }
                n2 = windowInsetsCompat.getSystemWindowInsetTop();
                n3 = bl ? 0 : windowInsetsCompat.getSystemWindowInsetBottom();
                Rect rect = new Rect(n4, n2, n5, n3);
                this.computeInsetsWithGravity(view, rect);
                rect = ViewCompat.dispatchApplyWindowInsets((View)view, (WindowInsetsCompat)windowInsetsCompat.replaceSystemWindowInsets(rect));
                bl2 = bl2 || rect != null && rect.isConsumed();
            }
            ++n;
        }
        return bl2;
    }
}
