/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  androidx.transition.GhostViewPort
 *  androidx.transition.R$id
 *  androidx.transition.ViewGroupUtils
 */
package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.transition.GhostViewPort;
import androidx.transition.R;
import androidx.transition.ViewGroupUtils;
import java.util.ArrayList;

class GhostViewHolder
extends FrameLayout {
    private boolean mAttached;
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        this.setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, (Object)this);
        ViewGroupUtils.getOverlay((ViewGroup)this.mParent).add((View)this);
        this.mAttached = true;
    }

    static GhostViewHolder getHolder(ViewGroup viewGroup) {
        return (GhostViewHolder)((Object)viewGroup.getTag(R.id.ghost_view_holder));
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList<View> arrayList2 = new ArrayList<View>();
        int n = this.getChildCount() - 1;
        int n2 = 0;
        while (n2 <= n) {
            int n3 = (n2 + n) / 2;
            GhostViewHolder.getParents(((GhostViewPort)this.getChildAt((int)n3)).mView, arrayList2);
            if (GhostViewHolder.isOnTop(arrayList, arrayList2)) {
                n2 = n3 + 1;
            } else {
                n = n3 - 1;
            }
            arrayList2.clear();
        }
        return n2;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof ViewGroup) {
            GhostViewHolder.getParents((View)viewParent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(View view, View view2) {
        boolean bl;
        block3: {
            ViewGroup viewGroup = (ViewGroup)view.getParent();
            int n = viewGroup.getChildCount();
            int n2 = Build.VERSION.SDK_INT;
            boolean bl2 = false;
            bl = false;
            if (n2 >= 21 && view.getZ() != view2.getZ()) {
                if (!(view.getZ() > view2.getZ())) return bl;
                bl = true;
                return bl;
            }
            for (n2 = 0; n2 < n; ++n2) {
                View view3 = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder((ViewGroup)viewGroup, (int)n2));
                if (view3 == view) {
                    bl = bl2;
                    break block3;
                }
                if (view3 == view2) break;
            }
            bl = true;
        }
        return bl;
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        boolean bl;
        boolean bl2 = arrayList.isEmpty();
        boolean bl3 = bl = true;
        if (bl2) return bl3;
        bl3 = bl;
        if (arrayList2.isEmpty()) return bl3;
        if (arrayList.get(0) != arrayList2.get(0)) {
            bl3 = bl;
        } else {
            int n = Math.min(arrayList.size(), arrayList2.size());
            for (int i = 1; i < n; ++i) {
                View view;
                View view2 = arrayList.get(i);
                if (view2 == (view = arrayList2.get(i))) continue;
                return GhostViewHolder.isOnTop(view2, view);
            }
            bl3 = arrayList2.size() == n ? bl : false;
        }
        return bl3;
    }

    void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList<View> arrayList = new ArrayList<View>();
        GhostViewHolder.getParents(ghostViewPort.mView, arrayList);
        int n = this.getInsertIndex(arrayList);
        if (n >= 0 && n < this.getChildCount()) {
            this.addView((View)ghostViewPort, n);
        } else {
            this.addView((View)ghostViewPort);
        }
    }

    public void onViewAdded(View view) {
        if (!this.mAttached) throw new IllegalStateException("This GhostViewHolder is detached!");
        super.onViewAdded(view);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.getChildCount() != 1 || this.getChildAt(0) != view) {
            if (this.getChildCount() != 0) return;
        }
        this.mParent.setTag(R.id.ghost_view_holder, null);
        ViewGroupUtils.getOverlay((ViewGroup)this.mParent).remove((View)this);
        this.mAttached = false;
    }

    void popToOverlayTop() {
        if (!this.mAttached) throw new IllegalStateException("This GhostViewHolder is detached!");
        ViewGroupUtils.getOverlay((ViewGroup)this.mParent).remove((View)this);
        ViewGroupUtils.getOverlay((ViewGroup)this.mParent).add((View)this);
    }
}
