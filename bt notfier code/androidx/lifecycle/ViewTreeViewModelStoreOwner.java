/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.lifecycle.ViewModelStoreOwner
 *  androidx.lifecycle.viewmodel.R$id
 */
package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.R;

public class ViewTreeViewModelStoreOwner {
    private ViewTreeViewModelStoreOwner() {
    }

    public static ViewModelStoreOwner get(View view) {
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner)view.getTag(R.id.view_tree_view_model_store_owner);
        if (viewModelStoreOwner != null) {
            return viewModelStoreOwner;
        }
        ViewParent viewParent = view.getParent();
        view = viewModelStoreOwner;
        while (view == null) {
            if (!(viewParent instanceof View)) return view;
            viewParent = (View)viewParent;
            view = (ViewModelStoreOwner)viewParent.getTag(R.id.view_tree_view_model_store_owner);
            viewParent = viewParent.getParent();
        }
        return view;
    }

    public static void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        view.setTag(R.id.view_tree_view_model_store_owner, (Object)viewModelStoreOwner);
    }
}
