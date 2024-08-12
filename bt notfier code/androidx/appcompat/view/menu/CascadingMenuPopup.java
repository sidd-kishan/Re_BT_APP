/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo
 *  androidx.appcompat.view.menu.MenuAdapter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPopup
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.MenuItemHoverListener
 *  androidx.appcompat.widget.MenuPopupWindow
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class CascadingMenuPopup
extends MenuPopup
implements MenuPresenter,
View.OnKeyListener,
PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity = 0;
    private boolean mForceShowIcon;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus = new ArrayList<MenuBuilder>();
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity = 0;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus = new ArrayList<CascadingMenuInfo>();
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    public CascadingMenuPopup(Context context, View view, int n, int n2, boolean bl) {
        this.mGlobalLayoutListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mAttachStateChangeListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mMenuItemHoverListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = n;
        this.mPopupStyleRes = n2;
        this.mOverflowOnly = bl;
        this.mForceShowIcon = false;
        this.mLastPosition = this.getInitialMenuPosition();
        context = context.getResources();
        this.mMenuMaxWidth = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
        menuPopupWindow.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        menuPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)this);
        menuPopupWindow.setAnchorView(this.mAnchorView);
        menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(MenuBuilder menuBuilder) {
        int n = this.mShowingMenus.size();
        int n2 = 0;
        while (n2 < n) {
            if (menuBuilder == this.mShowingMenus.get((int)n2).menu) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int n = menuBuilder.size();
        int n2 = 0;
        while (n2 < n) {
            MenuItem menuItem = menuBuilder.getItem(n2);
            if (menuItem.hasSubMenu() && menuBuilder2 == menuItem.getSubMenu()) {
                return menuItem;
            }
            ++n2;
        }
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        int n;
        int n2;
        ListView listView;
        block6: {
            if ((menuBuilder = this.findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder)) == null) {
                return null;
            }
            listView = cascadingMenuInfo.getListView();
            cascadingMenuInfo = listView.getAdapter();
            boolean bl = cascadingMenuInfo instanceof HeaderViewListAdapter;
            n2 = 0;
            if (bl) {
                cascadingMenuInfo = (HeaderViewListAdapter)cascadingMenuInfo;
                n = cascadingMenuInfo.getHeadersCount();
                cascadingMenuInfo = (MenuAdapter)cascadingMenuInfo.getWrappedAdapter();
            } else {
                cascadingMenuInfo = (MenuAdapter)cascadingMenuInfo;
                n = 0;
            }
            int n3 = cascadingMenuInfo.getCount();
            while (n2 < n3) {
                if (menuBuilder != cascadingMenuInfo.getItem(n2)) {
                    ++n2;
                    continue;
                }
                break block6;
            }
            n2 = -1;
        }
        if (n2 == -1) {
            return null;
        }
        if ((n2 = n2 + n - listView.getFirstVisiblePosition()) < 0) return null;
        if (n2 < listView.getChildCount()) return listView.getChildAt(n2);
        return null;
    }

    private int getInitialMenuPosition() {
        int n = ViewCompat.getLayoutDirection((View)this.mAnchorView);
        int n2 = 1;
        if (n != 1) return n2;
        n2 = 0;
        return n2;
    }

    private int getNextMenuPosition(int n) {
        Object object = this.mShowingMenus;
        ListView listView = object.get(object.size() - 1).getListView();
        object = new int[2];
        listView.getLocationOnScreen((int[])object);
        Rect rect = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
        if (this.mLastPosition == 1) {
            if (object[0] + listView.getWidth() + n <= rect.right) return 1;
            return 0;
        }
        if (object[0] - n >= 0) return 0;
        return 1;
    }

    /*
     * Unable to fully structure code
     */
    private void showMenu(MenuBuilder var1_1) {
        block14: {
            block12: {
                block13: {
                    var9_2 = LayoutInflater.from((Context)this.mContext);
                    var6_3 = new MenuAdapter(var1_1, var9_2, this.mOverflowOnly, CascadingMenuPopup.ITEM_LAYOUT);
                    if (!this.isShowing() && this.mForceShowIcon) {
                        var6_3.setForceShowIcon(true);
                    } else if (this.isShowing()) {
                        var6_3.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing((MenuBuilder)var1_1));
                    }
                    var3_4 = CascadingMenuPopup.measureIndividualMenuWidth((ListAdapter)var6_3, null, (Context)this.mContext, (int)this.mMenuMaxWidth);
                    var8_5 = this.createPopupWindow();
                    var8_5.setAdapter((ListAdapter)var6_3);
                    var8_5.setContentWidth(var3_4);
                    var8_5.setDropDownGravity(this.mDropDownGravity);
                    if (this.mShowingMenus.size() > 0) {
                        var6_3 = this.mShowingMenus;
                        var6_3 = (CascadingMenuInfo)var6_3.get(var6_3.size() - 1);
                        var7_6 = this.findParentViewForSubmenu((CascadingMenuInfo)var6_3, var1_1);
                    } else {
                        var6_3 = null;
                        var7_6 = null;
                    }
                    if (var7_6 == null) break block12;
                    var8_5.setTouchModal(false);
                    var8_5.setEnterTransition(null);
                    var2_7 = this.getNextMenuPosition(var3_4);
                    var4_8 = var2_7 == 1;
                    this.mLastPosition = var2_7;
                    if (Build.VERSION.SDK_INT >= 26) {
                        var8_5.setAnchorView(var7_6);
                        var2_7 = 0;
                        var5_9 = 0;
                    } else {
                        var11_10 = new int[2];
                        this.mAnchorView.getLocationOnScreen(var11_10);
                        var10_11 = new int[2];
                        var7_6.getLocationOnScreen(var10_11);
                        if ((this.mDropDownGravity & 7) == 5) {
                            var11_10[0] = var11_10[0] + this.mAnchorView.getWidth();
                            var10_11[0] = var10_11[0] + var7_6.getWidth();
                        }
                        var5_9 = var10_11[0] - var11_10[0];
                        var2_7 = var10_11[1] - var11_10[1];
                    }
                    if ((this.mDropDownGravity & 5) != 5) break block13;
                    if (var4_8) ** GOTO lbl47
                    var3_4 = var7_6.getWidth();
                    ** GOTO lbl-1000
                }
                if (var4_8) {
                    var3_4 = var7_6.getWidth();
lbl47:
                    // 2 sources

                    var3_4 = var5_9 + var3_4;
                } else lbl-1000:
                // 2 sources

                {
                    var3_4 = var5_9 - var3_4;
                }
                var8_5.setHorizontalOffset(var3_4);
                var8_5.setOverlapAnchor(true);
                var8_5.setVerticalOffset(var2_7);
                break block14;
            }
            if (this.mHasXOffset) {
                var8_5.setHorizontalOffset(this.mXOffset);
            }
            if (this.mHasYOffset) {
                var8_5.setVerticalOffset(this.mYOffset);
            }
            var8_5.setEpicenterBounds(this.getEpicenterBounds());
        }
        var7_6 = new CascadingMenuInfo(var8_5, var1_1, this.mLastPosition);
        this.mShowingMenus.add((CascadingMenuInfo)var7_6);
        var8_5.show();
        var7_6 = var8_5.getListView();
        var7_6.setOnKeyListener((View.OnKeyListener)this);
        if (var6_3 != null) return;
        if (this.mShowTitle == false) return;
        if (var1_1.getHeaderTitle() == null) return;
        var6_3 = (FrameLayout)var9_2.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)var7_6, false);
        var9_2 = (TextView)var6_3.findViewById(16908310);
        var6_3.setEnabled(false);
        var9_2.setText(var1_1.getHeaderTitle());
        var7_6.addHeaderView((View)var6_3, null, false);
        var8_5.show();
    }

    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter((MenuPresenter)this, this.mContext);
        if (this.isShowing()) {
            this.showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    protected boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    public void dismiss() {
        int n = this.mShowingMenus.size();
        if (n <= 0) return;
        CascadingMenuInfo[] cascadingMenuInfoArray = this.mShowingMenus.toArray(new CascadingMenuInfo[n]);
        --n;
        while (n >= 0) {
            CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArray[n];
            if (cascadingMenuInfo.window.isShowing()) {
                cascadingMenuInfo.window.dismiss();
            }
            --n;
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        ListView listView;
        if (this.mShowingMenus.isEmpty()) {
            listView = null;
        } else {
            listView = this.mShowingMenus;
            listView = listView.get(listView.size() - 1).getListView();
        }
        return listView;
    }

    public boolean isShowing() {
        boolean bl;
        int n = this.mShowingMenus.size();
        boolean bl2 = bl = false;
        if (n <= 0) return bl2;
        bl2 = bl;
        if (!this.mShowingMenus.get((int)0).window.isShowing()) return bl2;
        bl2 = true;
        return bl2;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        int n = this.findIndexOfAddedMenu(menuBuilder);
        if (n < 0) {
            return;
        }
        int n2 = n + 1;
        if (n2 < this.mShowingMenus.size()) {
            this.mShowingMenus.get((int)n2).menu.close(false);
        }
        CascadingMenuInfo cascadingMenuInfo = this.mShowingMenus.remove(n);
        cascadingMenuInfo.menu.removeMenuPresenter((MenuPresenter)this);
        if (this.mShouldCloseImmediately) {
            cascadingMenuInfo.window.setExitTransition(null);
            cascadingMenuInfo.window.setAnimationStyle(0);
        }
        cascadingMenuInfo.window.dismiss();
        n2 = this.mShowingMenus.size();
        this.mLastPosition = n2 > 0 ? this.mShowingMenus.get((int)(n2 - 1)).position : this.getInitialMenuPosition();
        if (n2 == 0) {
            this.dismiss();
            cascadingMenuInfo = this.mPresenterCallback;
            if (cascadingMenuInfo != null) {
                cascadingMenuInfo.onCloseMenu(menuBuilder, true);
            }
            if ((menuBuilder = this.mTreeObserver) != null) {
                if (menuBuilder.isAlive()) {
                    this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                }
                this.mTreeObserver = null;
            }
            this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
            this.mOnDismissListener.onDismiss();
        } else {
            if (!bl) return;
            this.mShowingMenus.get((int)0).menu.close(false);
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        block2: {
            int n = this.mShowingMenus.size();
            for (int i = 0; i < n; ++i) {
                cascadingMenuInfo = this.mShowingMenus.get(i);
                if (cascadingMenuInfo.window.isShowing()) {
                    continue;
                }
                break block2;
            }
            cascadingMenuInfo = null;
        }
        if (cascadingMenuInfo == null) return;
        cascadingMenuInfo.menu.close(false);
    }

    public boolean onKey(View view, int n, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1) return false;
        if (n != 82) return false;
        this.dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        MenuPresenter.Callback callback = this.mShowingMenus.iterator();
        do {
            if (!callback.hasNext()) {
                if (!subMenuBuilder.hasVisibleItems()) return false;
                this.addMenu((MenuBuilder)subMenuBuilder);
                callback = this.mPresenterCallback;
                if (callback == null) return true;
                callback.onOpenSubMenu((MenuBuilder)subMenuBuilder);
                return true;
            }
            cascadingMenuInfo = callback.next();
        } while (subMenuBuilder != cascadingMenuInfo.menu);
        cascadingMenuInfo.getListView().requestFocus();
        return true;
    }

    public void setAnchorView(View view) {
        if (this.mAnchorView == view) return;
        this.mAnchorView = view;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity((int)this.mRawDropDownGravity, (int)ViewCompat.getLayoutDirection((View)view));
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean bl) {
        this.mForceShowIcon = bl;
    }

    public void setGravity(int n) {
        if (this.mRawDropDownGravity == n) return;
        this.mRawDropDownGravity = n;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity((int)n, (int)ViewCompat.getLayoutDirection((View)this.mAnchorView));
    }

    public void setHorizontalOffset(int n) {
        this.mHasXOffset = true;
        this.mXOffset = n;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean bl) {
        this.mShowTitle = bl;
    }

    public void setVerticalOffset(int n) {
        this.mHasYOffset = true;
        this.mYOffset = n;
    }

    public void show() {
        if (this.isShowing()) {
            return;
        }
        View view = this.mPendingMenus.iterator();
        while (view.hasNext()) {
            this.showMenu(view.next());
        }
        this.mPendingMenus.clear();
        this.mShownAnchorView = view = this.mAnchorView;
        if (view == null) return;
        boolean bl = this.mTreeObserver == null;
        view = this.mShownAnchorView.getViewTreeObserver();
        this.mTreeObserver = view;
        if (bl) {
            view.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
    }

    public void updateMenuView(boolean bl) {
        Iterator<CascadingMenuInfo> iterator = this.mShowingMenus.iterator();
        while (iterator.hasNext()) {
            CascadingMenuPopup.toMenuAdapter((ListAdapter)iterator.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
