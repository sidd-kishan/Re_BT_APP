/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;

interface ViewTypeStorage {
    public ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper var1);

    public NestedAdapterWrapper getWrapperForGlobalType(int var1);
}
