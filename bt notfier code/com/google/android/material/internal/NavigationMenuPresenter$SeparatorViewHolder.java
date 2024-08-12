/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  com.google.android.material.R$layout
 *  com.google.android.material.internal.NavigationMenuPresenter$ViewHolder
 */
package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenuPresenter;

private static class NavigationMenuPresenter.SeparatorViewHolder
extends NavigationMenuPresenter.ViewHolder {
    public NavigationMenuPresenter.SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
    }
}
