/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.app.ActionBar$TabListener
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.appcompat.content.res.AppCompatResources
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.content.res.AppCompatResources;

public class WindowDecorActionBar.TabImpl
extends ActionBar.Tab {
    private ActionBar.TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition;
    private Object mTag;
    private CharSequence mText;
    final WindowDecorActionBar this$0;

    public WindowDecorActionBar.TabImpl(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
        this.mPosition = -1;
    }

    public ActionBar.TabListener getCallback() {
        return this.mCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public Object getTag() {
        return this.mTag;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void select() {
        this.this$0.selectTab((ActionBar.Tab)this);
    }

    public ActionBar.Tab setContentDescription(int n) {
        return this.setContentDescription(this.this$0.mContext.getResources().getText(n));
    }

    public ActionBar.Tab setContentDescription(CharSequence charSequence) {
        this.mContentDesc = charSequence;
        if (this.mPosition < 0) return this;
        this.this$0.mTabScrollView.updateTab(this.mPosition);
        return this;
    }

    public ActionBar.Tab setCustomView(int n) {
        return this.setCustomView(LayoutInflater.from((Context)this.this$0.getThemedContext()).inflate(n, null));
    }

    public ActionBar.Tab setCustomView(View view) {
        this.mCustomView = view;
        if (this.mPosition < 0) return this;
        this.this$0.mTabScrollView.updateTab(this.mPosition);
        return this;
    }

    public ActionBar.Tab setIcon(int n) {
        return this.setIcon(AppCompatResources.getDrawable((Context)this.this$0.mContext, (int)n));
    }

    public ActionBar.Tab setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (this.mPosition < 0) return this;
        this.this$0.mTabScrollView.updateTab(this.mPosition);
        return this;
    }

    public void setPosition(int n) {
        this.mPosition = n;
    }

    public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
        this.mCallback = tabListener;
        return this;
    }

    public ActionBar.Tab setTag(Object object) {
        this.mTag = object;
        return this;
    }

    public ActionBar.Tab setText(int n) {
        return this.setText(this.this$0.mContext.getResources().getText(n));
    }

    public ActionBar.Tab setText(CharSequence charSequence) {
        this.mText = charSequence;
        if (this.mPosition < 0) return this;
        this.this$0.mTabScrollView.updateTab(this.mPosition);
        return this;
    }
}
