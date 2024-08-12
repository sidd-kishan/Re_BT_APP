/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowInsets
 *  android.widget.FrameLayout
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.fragment.R$styleable
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

public final class FragmentContainerView
extends FrameLayout {
    private View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private ArrayList<View> mDisappearingFragmentChildren;
    private boolean mDrawDisappearingViewsFirst = true;
    private ArrayList<View> mTransitioningFragmentViews;

    public FragmentContainerView(Context context) {
        super(context);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context object, AttributeSet object2, int n) {
        super(object, (AttributeSet)object2, n);
        if (object2 == null) return;
        CharSequence charSequence = object2.getClassAttribute();
        TypedArray typedArray = object.obtainStyledAttributes((AttributeSet)object2, R.styleable.FragmentContainerView);
        if (charSequence == null) {
            object = typedArray.getString(R.styleable.FragmentContainerView_android_name);
            object2 = "android:name";
        } else {
            object2 = "class";
            object = charSequence;
        }
        typedArray.recycle();
        if (object == null) return;
        if (this.isInEditMode()) {
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FragmentContainerView must be within a FragmentActivity to use ");
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append("=\"");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("\"");
        throw new UnsupportedOperationException(((StringBuilder)charSequence).toString());
    }

    FragmentContainerView(Context object, AttributeSet object2, FragmentManager fragmentManager) {
        super((Context)object, (AttributeSet)object2);
        String string = object2.getClassAttribute();
        TypedArray typedArray = object.obtainStyledAttributes((AttributeSet)object2, R.styleable.FragmentContainerView);
        String string2 = string;
        if (string == null) {
            string2 = typedArray.getString(R.styleable.FragmentContainerView_android_name);
        }
        string = typedArray.getString(R.styleable.FragmentContainerView_android_tag);
        typedArray.recycle();
        int n = this.getId();
        typedArray = fragmentManager.findFragmentById(n);
        if (string2 != null && typedArray == null) {
            if (n <= 0) {
                if (string != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" with tag ");
                    ((StringBuilder)object).append(string);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = "";
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("FragmentContainerView must have an android:id to add Fragment ");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append((String)object);
                throw new IllegalStateException(((StringBuilder)object2).toString());
            }
            string2 = fragmentManager.getFragmentFactory().instantiate(object.getClassLoader(), string2);
            string2.onInflate((Context)object, (AttributeSet)object2, null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add((ViewGroup)this, (Fragment)string2, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }

    private void addDisappearingFragmentView(View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList == null) return;
        if (!arrayList.contains(view)) return;
        if (this.mDisappearingFragmentChildren == null) {
            this.mDisappearingFragmentChildren = new ArrayList();
        }
        this.mDisappearingFragmentChildren.add(view);
    }

    public void addView(View view, int n, ViewGroup.LayoutParams object) {
        if (FragmentManager.getViewFragment((View)view) != null) {
            super.addView(view, n, (ViewGroup.LayoutParams)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        ((StringBuilder)object).append(view);
        ((StringBuilder)object).append(" is not associated with a Fragment.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected boolean addViewInLayout(View view, int n, ViewGroup.LayoutParams object, boolean bl) {
        if (FragmentManager.getViewFragment((View)view) != null) {
            return super.addViewInLayout(view, n, (ViewGroup.LayoutParams)object, bl);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        ((StringBuilder)object).append(view);
        ((StringBuilder)object).append(" is not associated with a Fragment.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        windowInsetsCompat = onApplyWindowInsetsListener != null ? WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)onApplyWindowInsetsListener.onApplyWindowInsets((View)this, windowInsets)) : ViewCompat.onApplyWindowInsets((View)this, (WindowInsetsCompat)windowInsetsCompat);
        if (windowInsetsCompat.isConsumed()) return windowInsets;
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            ViewCompat.dispatchApplyWindowInsets((View)this.getChildAt(n2), (WindowInsetsCompat)windowInsetsCompat);
            ++n2;
        }
        return windowInsets;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
            for (int i = 0; i < this.mDisappearingFragmentChildren.size(); ++i) {
                super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i), this.getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        if (!this.mDrawDisappearingViewsFirst) return super.drawChild(canvas, view, l);
        ArrayList<View> arrayList = this.mDisappearingFragmentChildren;
        if (arrayList == null) return super.drawChild(canvas, view, l);
        if (arrayList.size() <= 0) return super.drawChild(canvas, view, l);
        if (!this.mDisappearingFragmentChildren.contains(view)) return super.drawChild(canvas, view, l);
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            arrayList.remove(view);
            arrayList = this.mDisappearingFragmentChildren;
            if (arrayList != null && arrayList.remove(view)) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        int n = this.getChildCount() - 1;
        while (true) {
            if (n < 0) {
                super.removeAllViewsInLayout();
                return;
            }
            this.addDisappearingFragmentView(this.getChildAt(n));
            --n;
        }
    }

    protected void removeDetachedView(View view, boolean bl) {
        if (bl) {
            this.addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, bl);
    }

    public void removeView(View view) {
        this.addDisappearingFragmentView(view);
        super.removeView(view);
    }

    public void removeViewAt(int n) {
        this.addDisappearingFragmentView(this.getChildAt(n));
        super.removeViewAt(n);
    }

    public void removeViewInLayout(View view) {
        this.addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int n, int n2) {
        int n3 = n;
        while (true) {
            if (n3 >= n + n2) {
                super.removeViews(n, n2);
                return;
            }
            this.addDisappearingFragmentView(this.getChildAt(n3));
            ++n3;
        }
    }

    public void removeViewsInLayout(int n, int n2) {
        int n3 = n;
        while (true) {
            if (n3 >= n + n2) {
                super.removeViewsInLayout(n, n2);
                return;
            }
            this.addDisappearingFragmentView(this.getChildAt(n3));
            ++n3;
        }
    }

    void setDrawDisappearingViewsLast(boolean bl) {
        this.mDrawDisappearingViewsFirst = bl;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        super.setLayoutTransition(layoutTransition);
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.mTransitioningFragmentViews == null) {
                this.mTransitioningFragmentViews = new ArrayList();
            }
            this.mTransitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }
}
