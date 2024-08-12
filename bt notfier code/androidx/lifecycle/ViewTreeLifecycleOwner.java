/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.runtime.R$id
 */
package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.runtime.R;

public class ViewTreeLifecycleOwner {
    private ViewTreeLifecycleOwner() {
    }

    public static LifecycleOwner get(View view) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner)view.getTag(R.id.view_tree_lifecycle_owner);
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        ViewParent viewParent = view.getParent();
        view = lifecycleOwner;
        while (view == null) {
            if (!(viewParent instanceof View)) return view;
            viewParent = (View)viewParent;
            view = (LifecycleOwner)viewParent.getTag(R.id.view_tree_lifecycle_owner);
            viewParent = viewParent.getParent();
        }
        return view;
    }

    public static void set(View view, LifecycleOwner lifecycleOwner) {
        view.setTag(R.id.view_tree_lifecycle_owner, (Object)lifecycleOwner);
    }
}
