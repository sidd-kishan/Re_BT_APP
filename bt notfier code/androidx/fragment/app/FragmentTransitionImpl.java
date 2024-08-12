/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.os.CancellationSignal
 *  androidx.core.view.OneShotPreDrawListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewGroupCompat
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class FragmentTransitionImpl {
    protected static void bfsAddViewChildren(List<View> list, View view) {
        int n = list.size();
        if (FragmentTransitionImpl.containedBeforeIndex(list, view, n)) {
            return;
        }
        if (ViewCompat.getTransitionName((View)view) != null) {
            list.add(view);
        }
        int n2 = n;
        while (n2 < list.size()) {
            view = list.get(n2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view;
                int n3 = viewGroup.getChildCount();
                for (int i = 0; i < n3; ++i) {
                    view = viewGroup.getChildAt(i);
                    if (FragmentTransitionImpl.containedBeforeIndex(list, view, n) || ViewCompat.getTransitionName((View)view) == null) continue;
                    list.add(view);
                }
            }
            ++n2;
        }
    }

    private static boolean containedBeforeIndex(List<View> list, View view, int n) {
        int n2 = 0;
        while (n2 < n) {
            if (list.get(n2) == view) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    static String findKeyForValue(Map<String, String> object, String string) {
        Map.Entry entry;
        object = object.entrySet().iterator();
        do {
            if (!object.hasNext()) return null;
        } while (!string.equals((entry = (Map.Entry)object.next()).getValue()));
        return (String)entry.getKey();
    }

    protected static boolean isNullOrEmpty(List list) {
        boolean bl = list == null || list.isEmpty();
        return bl;
    }

    public abstract void addTarget(Object var1, View var2);

    public abstract void addTargets(Object var1, ArrayList<View> var2);

    public abstract void beginDelayedTransition(ViewGroup var1, Object var2);

    public abstract boolean canHandle(Object var1);

    /*
     * Enabled force condition propagation
     */
    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) return;
        if (!(view instanceof ViewGroup)) {
            arrayList.add(view);
            return;
        }
        if (ViewGroupCompat.isTransitionGroup((ViewGroup)(view = (ViewGroup)view))) {
            arrayList.add(view);
            return;
        }
        int n = view.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            this.captureTransitioningViews(arrayList, view.getChildAt(n2));
            ++n2;
        }
    }

    public abstract Object cloneTransition(Object var1);

    void findNamedViews(Map<String, View> map, View view) {
        if (view.getVisibility() != 0) return;
        String string = ViewCompat.getTransitionName((View)view);
        if (string != null) {
            map.put(string, view);
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = view.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            this.findNamedViews(map, view.getChildAt(n2));
            ++n2;
        }
    }

    protected void getBoundsOnScreen(View view, Rect rect) {
        if (!ViewCompat.isAttachedToWindow((View)view)) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset((float)view.getLeft(), (float)view.getTop());
        Object object = view.getParent();
        while (true) {
            if (!(object instanceof View)) {
                object = new int[2];
                view.getRootView().getLocationOnScreen((int[])object);
                rectF.offset((float)object[0], (float)object[1]);
                rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                return;
            }
            object = (View)object;
            rectF.offset((float)(-object.getScrollX()), (float)(-object.getScrollY()));
            object.getMatrix().mapRect(rectF);
            rectF.offset((float)object.getLeft(), (float)object.getTop());
            object = object.getParent();
        }
    }

    public abstract Object mergeTransitionsInSequence(Object var1, Object var2, Object var3);

    public abstract Object mergeTransitionsTogether(Object var1, Object var2, Object var3);

    ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            View view = arrayList.get(n2);
            arrayList2.add(ViewCompat.getTransitionName((View)view));
            ViewCompat.setTransitionName((View)view, null);
            ++n2;
        }
        return arrayList2;
    }

    public abstract void removeTarget(Object var1, View var2);

    public abstract void replaceTargets(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    public abstract void scheduleHideFragmentView(Object var1, View var2, ArrayList<View> var3);

    void scheduleNameReset(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add((View)viewGroup, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public abstract void scheduleRemoveTargets(Object var1, Object var2, ArrayList<View> var3, Object var4, ArrayList<View> var5, Object var6, ArrayList<View> var7);

    public abstract void setEpicenter(Object var1, Rect var2);

    public abstract void setEpicenter(Object var1, View var2);

    public void setListenerForTransitionEnd(Fragment fragment, Object object, CancellationSignal cancellationSignal, Runnable runnable) {
        runnable.run();
    }

    void setNameOverridesOrdered(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add((View)view, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void setNameOverridesReordered(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int n = arrayList2.size();
        ArrayList<String> arrayList4 = new ArrayList<String>();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                OneShotPreDrawListener.add((View)view, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
                return;
            }
            Object object = arrayList.get(n2);
            String string = ViewCompat.getTransitionName((View)object);
            arrayList4.add(string);
            if (string != null) {
                ViewCompat.setTransitionName((View)object, null);
                object = map.get(string);
                for (int i = 0; i < n; ++i) {
                    if (!((String)object).equals(arrayList3.get(i))) continue;
                    ViewCompat.setTransitionName((View)arrayList2.get(i), (String)string);
                    break;
                }
            }
            ++n2;
        }
    }

    public abstract void setSharedElementTargets(Object var1, View var2, ArrayList<View> var3);

    public abstract void swapSharedElementTargets(Object var1, ArrayList<View> var2, ArrayList<View> var3);

    public abstract Object wrapTransitionInSet(Object var1);
}
