/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Parcelable
 *  android.view.Gravity
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.view.menu.MenuAdapter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPopup
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.MenuPopupWindow
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup
extends MenuPopup
implements PopupWindow.OnDismissListener,
AdapterView.OnItemClickListener,
MenuPresenter,
View.OnKeyListener {
    private static final int ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity = 0;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new /* Unavailable Anonymous Inner Class!! */;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private boolean mShowTitle;
    View mShownAnchorView;
    ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int n, int n2, boolean bl) {
        this.mAttachStateChangeListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = bl;
        this.mAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from((Context)context), this.mOverflowOnly, ITEM_LAYOUT);
        this.mPopupStyleAttr = n;
        this.mPopupStyleRes = n2;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuBuilder.addMenuPresenter((MenuPresenter)this, context);
    }

    private boolean tryShow() {
        if (this.isShowing()) {
            return true;
        }
        if (this.mWasDismissed) return false;
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        this.mShownAnchorView = view;
        this.mPopup.setOnDismissListener((PopupWindow.OnDismissListener)this);
        this.mPopup.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        this.mPopup.setModal(true);
        View view2 = this.mShownAnchorView;
        boolean bl = this.mTreeObserver == null;
        view = view2.getViewTreeObserver();
        this.mTreeObserver = view;
        if (bl) {
            view.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
        view2.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mPopup.setAnchorView(view2);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (!this.mHasContentWidth) {
            this.mContentWidth = StandardMenuPopup.measureIndividualMenuWidth((ListAdapter)this.mAdapter, null, (Context)this.mContext, (int)this.mPopupMaxWidth);
            this.mHasContentWidth = true;
        }
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setEpicenterBounds(this.getEpicenterBounds());
        this.mPopup.show();
        ListView listView = this.mPopup.getListView();
        listView.setOnKeyListener((View.OnKeyListener)this);
        if (this.mShowTitle && this.mMenu.getHeaderTitle() != null) {
            view = (FrameLayout)LayoutInflater.from((Context)this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)listView, false);
            view2 = (TextView)view.findViewById(16908310);
            if (view2 != null) {
                view2.setText(this.mMenu.getHeaderTitle());
            }
            view.setEnabled(false);
            listView.addHeaderView(view, null, false);
        }
        this.mPopup.setAdapter((ListAdapter)this.mAdapter);
        this.mPopup.show();
        return true;
    }

    public void addMenu(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (!this.isShowing()) return;
        this.mPopup.dismiss();
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.mPopup.getListView();
    }

    public boolean isShowing() {
        boolean bl = !this.mWasDismissed && this.mPopup.isShowing();
        return bl;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        if (menuBuilder != this.mMenu) {
            return;
        }
        this.dismiss();
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback == null) return;
        callback.onCloseMenu(menuBuilder, bl);
    }

    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        viewTreeObserver = this.mOnDismissListener;
        if (viewTreeObserver == null) return;
        viewTreeObserver.onDismiss();
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
        if (!subMenuBuilder.hasVisibleItems()) return false;
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, (MenuBuilder)subMenuBuilder, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupHelper.setPresenterCallback(this.mPresenterCallback);
        menuPopupHelper.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing((MenuBuilder)subMenuBuilder));
        menuPopupHelper.setOnDismissListener(this.mOnDismissListener);
        this.mOnDismissListener = null;
        this.mMenu.close(false);
        int n = this.mPopup.getHorizontalOffset();
        int n2 = this.mPopup.getVerticalOffset();
        int n3 = n;
        if ((Gravity.getAbsoluteGravity((int)this.mDropDownGravity, (int)ViewCompat.getLayoutDirection((View)this.mAnchorView)) & 7) == 5) {
            n3 = n + this.mAnchorView.getWidth();
        }
        if (!menuPopupHelper.tryShow(n3, n2)) return false;
        menuPopupHelper = this.mPresenterCallback;
        if (menuPopupHelper == null) return true;
        menuPopupHelper.onOpenSubMenu((MenuBuilder)subMenuBuilder);
        return true;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean bl) {
        this.mAdapter.setForceShowIcon(bl);
    }

    public void setGravity(int n) {
        this.mDropDownGravity = n;
    }

    public void setHorizontalOffset(int n) {
        this.mPopup.setHorizontalOffset(n);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean bl) {
        this.mShowTitle = bl;
    }

    public void setVerticalOffset(int n) {
        this.mPopup.setVerticalOffset(n);
    }

    public void show() {
        if (!this.tryShow()) throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    public void updateMenuView(boolean bl) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter == null) return;
        menuAdapter.notifyDataSetChanged();
    }
}
