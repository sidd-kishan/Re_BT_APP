/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.appcompat.content.res.AppCompatResources
 *  com.google.android.material.tabs.TabLayout
 *  com.google.android.material.tabs.TabLayout$TabView
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.tabs.TabLayout;

public static class TabLayout.Tab {
    public static final int INVALID_POSITION = -1;
    private CharSequence contentDesc;
    private View customView;
    private Drawable icon;
    public TabLayout parent;
    private int position = -1;
    private Object tag;
    private CharSequence text;
    public TabLayout.TabView view;

    static /* synthetic */ CharSequence access$100(TabLayout.Tab tab) {
        return tab.contentDesc;
    }

    static /* synthetic */ CharSequence access$200(TabLayout.Tab tab) {
        return tab.text;
    }

    public CharSequence getContentDescription() {
        Object object = this.view;
        object = object == null ? null : object.getContentDescription();
        return object;
    }

    public View getCustomView() {
        return this.customView;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getPosition() {
        return this.position;
    }

    public Object getTag() {
        return this.tag;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isSelected() {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) throw new IllegalArgumentException("Tab not attached to a TabLayout");
        boolean bl = tabLayout.getSelectedTabPosition() == this.position;
        return bl;
    }

    void reset() {
        this.parent = null;
        this.view = null;
        this.tag = null;
        this.icon = null;
        this.text = null;
        this.contentDesc = null;
        this.position = -1;
        this.customView = null;
    }

    public void select() {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) throw new IllegalArgumentException("Tab not attached to a TabLayout");
        tabLayout.selectTab(this);
    }

    public TabLayout.Tab setContentDescription(int n) {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) throw new IllegalArgumentException("Tab not attached to a TabLayout");
        return this.setContentDescription(tabLayout.getResources().getText(n));
    }

    public TabLayout.Tab setContentDescription(CharSequence charSequence) {
        this.contentDesc = charSequence;
        this.updateView();
        return this;
    }

    public TabLayout.Tab setCustomView(int n) {
        return this.setCustomView(LayoutInflater.from((Context)this.view.getContext()).inflate(n, (ViewGroup)this.view, false));
    }

    public TabLayout.Tab setCustomView(View view) {
        this.customView = view;
        this.updateView();
        return this;
    }

    public TabLayout.Tab setIcon(int n) {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) throw new IllegalArgumentException("Tab not attached to a TabLayout");
        return this.setIcon(AppCompatResources.getDrawable((Context)tabLayout.getContext(), (int)n));
    }

    public TabLayout.Tab setIcon(Drawable drawable) {
        this.icon = drawable;
        this.updateView();
        return this;
    }

    void setPosition(int n) {
        this.position = n;
    }

    public TabLayout.Tab setTag(Object object) {
        this.tag = object;
        return this;
    }

    public TabLayout.Tab setText(int n) {
        TabLayout tabLayout = this.parent;
        if (tabLayout == null) throw new IllegalArgumentException("Tab not attached to a TabLayout");
        return this.setText(tabLayout.getResources().getText(n));
    }

    public TabLayout.Tab setText(CharSequence charSequence) {
        if (TextUtils.isEmpty((CharSequence)this.contentDesc) && !TextUtils.isEmpty((CharSequence)charSequence)) {
            this.view.setContentDescription(charSequence);
        }
        this.text = charSequence;
        this.updateView();
        return this;
    }

    void updateView() {
        TabLayout.TabView tabView = this.view;
        if (tabView == null) return;
        tabView.update();
    }
}
