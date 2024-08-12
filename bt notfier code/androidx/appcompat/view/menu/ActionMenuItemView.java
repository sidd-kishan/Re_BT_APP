/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.view.menu.ActionMenuItemView$ActionMenuItemForwardingListener
 *  androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback
 *  androidx.appcompat.view.menu.MenuBuilder$ItemInvoker
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView$ItemView
 *  androidx.appcompat.widget.ActionMenuView$ActionMenuChildView
 *  androidx.appcompat.widget.AppCompatTextView
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;

public class ActionMenuItemView
extends AppCompatTextView
implements MenuView.ItemView,
View.OnClickListener,
ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, n, 0);
        this.mMinWidth = context.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        context.recycle();
        this.mMaxIconSize = (int)(resources.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        this.setSaveEnabled(false);
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration configuration = this.getContext().getResources().getConfiguration();
        int n = configuration.screenWidthDp;
        int n2 = configuration.screenHeightDp;
        boolean bl = n >= 480 || n >= 640 && n2 >= 480 || configuration.orientation == 2;
        return bl;
    }

    /*
     * Exception decompiling
     */
    private void updateTextButtonVisibility() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:461)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:251)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:673)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:722)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return TextUtils.isEmpty((CharSequence)this.getText()) ^ true;
    }

    public void initialize(MenuItemImpl menuItemImpl, int n) {
        this.mItemData = menuItemImpl;
        this.setIcon(menuItemImpl.getIcon());
        this.setTitle(menuItemImpl.getTitleForItemView((MenuView.ItemView)this));
        this.setId(menuItemImpl.getItemId());
        n = menuItemImpl.isVisible() ? 0 : 8;
        this.setVisibility(n);
        this.setEnabled(menuItemImpl.isEnabled());
        if (!menuItemImpl.hasSubMenu()) return;
        if (this.mForwardingListener != null) return;
        this.mForwardingListener = new ActionMenuItemForwardingListener(this);
    }

    public boolean needsDividerAfter() {
        return this.hasText();
    }

    public boolean needsDividerBefore() {
        boolean bl = this.hasText() && this.mItemData.getIcon() == null;
        return bl;
    }

    public void onClick(View view) {
        view = this.mItemInvoker;
        if (view == null) return;
        view.invokeItem(this.mItemData);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = this.shouldAllowTextWithIcon();
        this.updateTextButtonVisibility();
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        boolean bl = this.hasText();
        if (bl && (n3 = this.mSavedPaddingLeft) >= 0) {
            super.setPadding(n3, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
        super.onMeasure(n, n2);
        n3 = View.MeasureSpec.getMode((int)n);
        n = View.MeasureSpec.getSize((int)n);
        int n4 = this.getMeasuredWidth();
        n = n3 == Integer.MIN_VALUE ? Math.min(n, this.mMinWidth) : this.mMinWidth;
        if (n3 != 0x40000000 && this.mMinWidth > 0 && n4 < n) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000), n2);
        }
        if (bl) return;
        if (this.mIcon == null) return;
        super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mItemData.hasSubMenu()) return super.onTouchEvent(motionEvent);
        ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener == null) return super.onTouchEvent(motionEvent);
        if (!forwardingListener.onTouch((View)this, motionEvent)) return super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean bl) {
    }

    public void setChecked(boolean bl) {
    }

    public void setExpandedFormat(boolean bl) {
        if (this.mExpandedFormat == bl) return;
        this.mExpandedFormat = bl;
        MenuItemImpl menuItemImpl = this.mItemData;
        if (menuItemImpl == null) return;
        menuItemImpl.actionFormatChanged();
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null) {
            float f;
            int n = drawable.getIntrinsicWidth();
            int n2 = drawable.getIntrinsicHeight();
            int n3 = this.mMaxIconSize;
            int n4 = n;
            int n5 = n2;
            if (n > n3) {
                f = (float)n3 / (float)n;
                n5 = (int)((float)n2 * f);
                n4 = n3;
            }
            n = this.mMaxIconSize;
            n2 = n4;
            n3 = n5;
            if (n5 > n) {
                f = (float)n / (float)n5;
                n2 = (int)((float)n4 * f);
                n3 = n;
            }
            drawable.setBounds(0, 0, n2, n3);
        }
        this.setCompoundDrawables(drawable, null, null, null);
        this.updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    public void setPadding(int n, int n2, int n3, int n4) {
        this.mSavedPaddingLeft = n;
        super.setPadding(n, n2, n3, n4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    public void setShortcut(boolean bl, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.updateTextButtonVisibility();
    }

    public boolean showsIcon() {
        return true;
    }
}
