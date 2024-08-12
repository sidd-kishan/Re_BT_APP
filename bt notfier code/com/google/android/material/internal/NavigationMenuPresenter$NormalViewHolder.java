/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  com.google.android.material.R$layout
 *  com.google.android.material.internal.NavigationMenuPresenter$ViewHolder
 */
package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenuPresenter;

private static class NavigationMenuPresenter.NormalViewHolder
extends NavigationMenuPresenter.ViewHolder {
    public NavigationMenuPresenter.NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
        this.itemView.setOnClickListener(onClickListener);
    }
}
