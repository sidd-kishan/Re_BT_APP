/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowManager
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.view.menu.CascadingMenuPopup
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuHelper
 *  androidx.appcompat.view.menu.MenuPopup
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.StandardMenuPopup
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuHelper;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper
implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity = 0x800003;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener = new /* Unavailable Anonymous Inner Class!! */;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean bl, int n) {
        this(context, menuBuilder, view, bl, n, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean bl, int n, int n2) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = bl;
        this.mPopupStyleAttr = n;
        this.mPopupStyleRes = n2;
    }

    private MenuPopup createPopup() {
        Object object = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            object.getRealSize(point);
        } else {
            object.getSize(point);
        }
        boolean bl = Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width);
        object = bl ? new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly) : new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        object.addMenu(this.mMenu);
        object.setOnDismissListener(this.mInternalOnDismissListener);
        object.setAnchorView(this.mAnchorView);
        object.setCallback(this.mPresenterCallback);
        object.setForceShowIcon(this.mForceShowIcon);
        object.setGravity(this.mDropDownGravity);
        return object;
    }

    private void showPopup(int n, int n2, boolean bl, boolean bl2) {
        MenuPopup menuPopup = this.getPopup();
        menuPopup.setShowTitle(bl2);
        if (bl) {
            int n3 = n;
            if ((GravityCompat.getAbsoluteGravity((int)this.mDropDownGravity, (int)ViewCompat.getLayoutDirection((View)this.mAnchorView)) & 7) == 5) {
                n3 = n - this.mAnchorView.getWidth();
            }
            menuPopup.setHorizontalOffset(n3);
            menuPopup.setVerticalOffset(n2);
            n = (int)(this.mContext.getResources().getDisplayMetrics().density * 48.0f / 2.0f);
            menuPopup.setEpicenterBounds(new Rect(n3 - n, n2 - n, n3 + n, n2 + n));
        }
        menuPopup.show();
    }

    public void dismiss() {
        if (!this.isShowing()) return;
        this.mPopup.dismiss();
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return this.getPopup().getListView();
    }

    public MenuPopup getPopup() {
        if (this.mPopup != null) return this.mPopup;
        this.mPopup = this.createPopup();
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        boolean bl = menuPopup != null && menuPopup.isShowing();
        return bl;
    }

    protected void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener == null) return;
        onDismissListener.onDismiss();
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean bl) {
        this.mForceShowIcon = bl;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup == null) return;
        menuPopup.setForceShowIcon(bl);
    }

    public void setGravity(int n) {
        this.mDropDownGravity = n;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup == null) return;
        menuPopup.setCallback(callback);
    }

    public void show() {
        if (!this.tryShow()) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void show(int n, int n2) {
        if (!this.tryShow(n, n2)) throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public boolean tryShow() {
        if (this.isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        this.showPopup(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int n, int n2) {
        if (this.isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        this.showPopup(n, n2, true, true);
        return true;
    }
}
