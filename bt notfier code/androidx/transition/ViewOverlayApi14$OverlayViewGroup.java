/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  androidx.core.view.ViewCompat
 *  androidx.transition.ViewOverlayApi14
 */
package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.transition.ViewOverlayApi14;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

static class ViewOverlayApi14.OverlayViewGroup
extends ViewGroup {
    static Method sInvalidateChildInParentFastMethod;
    private boolean mDisposed;
    ArrayList<Drawable> mDrawables = null;
    ViewGroup mHostView;
    View mRequestingView;
    ViewOverlayApi14 mViewOverlay;

    /*
     * Enabled force condition propagation
     */
    static {
        try {
            sInvalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return;
        }
    }

    ViewOverlayApi14.OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
        super(context);
        this.mHostView = viewGroup;
        this.mRequestingView = view;
        this.setRight(viewGroup.getWidth());
        this.setBottom(viewGroup.getHeight());
        viewGroup.addView((View)this);
        this.mViewOverlay = viewOverlayApi14;
    }

    private void assertNotDisposed() {
        if (this.mDisposed) throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
    }

    private void disposeIfEmpty() {
        if (this.getChildCount() != 0) return;
        ArrayList<Drawable> arrayList = this.mDrawables;
        if (arrayList != null) {
            if (arrayList.size() != 0) return;
        }
        this.mDisposed = true;
        this.mHostView.removeView((View)this);
    }

    private void getOffset(int[] nArray) {
        int[] nArray2 = new int[2];
        int[] nArray3 = new int[2];
        this.mHostView.getLocationOnScreen(nArray2);
        this.mRequestingView.getLocationOnScreen(nArray3);
        nArray[0] = nArray3[0] - nArray2[0];
        nArray[1] = nArray3[1] - nArray2[1];
    }

    public void add(Drawable drawable) {
        this.assertNotDisposed();
        if (this.mDrawables == null) {
            this.mDrawables = new ArrayList();
        }
        if (this.mDrawables.contains(drawable)) return;
        this.mDrawables.add(drawable);
        this.invalidate(drawable.getBounds());
        drawable.setCallback((Drawable.Callback)this);
    }

    public void add(View view) {
        this.assertNotDisposed();
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view.getParent();
            if (viewGroup != this.mHostView && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow((View)viewGroup)) {
                int[] nArray = new int[2];
                int[] nArray2 = new int[2];
                viewGroup.getLocationOnScreen(nArray);
                this.mHostView.getLocationOnScreen(nArray2);
                ViewCompat.offsetLeftAndRight((View)view, (int)(nArray[0] - nArray2[0]));
                ViewCompat.offsetTopAndBottom((View)view, (int)(nArray[1] - nArray2[1]));
            }
            viewGroup.removeView(view);
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
        }
        super.addView(view);
    }

    protected void dispatchDraw(Canvas canvas) {
        Object object = new int[2];
        int[] nArray = new int[2];
        this.mHostView.getLocationOnScreen((int[])object);
        this.mRequestingView.getLocationOnScreen(nArray);
        int n = 0;
        canvas.translate((float)(nArray[0] - object[0]), (float)(nArray[1] - object[1]));
        canvas.clipRect(new Rect(0, 0, this.mRequestingView.getWidth(), this.mRequestingView.getHeight()));
        super.dispatchDraw(canvas);
        object = this.mDrawables;
        int n2 = object == null ? 0 : ((ArrayList)object).size();
        while (n < n2) {
            this.mDrawables.get(n).draw(canvas);
            ++n;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public ViewParent invalidateChildInParent(int[] nArray, Rect rect) {
        if (this.mHostView == null) return null;
        rect.offset(nArray[0], nArray[1]);
        if (this.mHostView != null) {
            nArray[0] = 0;
            nArray[1] = 0;
            int[] nArray2 = new int[2];
            this.getOffset(nArray2);
            rect.offset(nArray2[0], nArray2[1]);
            return super.invalidateChildInParent(nArray, rect);
        }
        this.invalidate(rect);
        return null;
    }

    protected ViewParent invalidateChildInParentFast(int n, int n2, Rect rect) {
        if (this.mHostView == null) return null;
        if (sInvalidateChildInParentFastMethod == null) return null;
        try {
            this.getOffset(new int[2]);
            sInvalidateChildInParentFastMethod.invoke(this.mHostView, n, n2, rect);
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidate(drawable.getBounds());
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
    }

    public void remove(Drawable drawable) {
        ArrayList<Drawable> arrayList = this.mDrawables;
        if (arrayList == null) return;
        arrayList.remove(drawable);
        this.invalidate(drawable.getBounds());
        drawable.setCallback(null);
        this.disposeIfEmpty();
    }

    public void remove(View view) {
        super.removeView(view);
        this.disposeIfEmpty();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        ArrayList<Drawable> arrayList;
        boolean bl = super.verifyDrawable(drawable) || (arrayList = this.mDrawables) != null && arrayList.contains(drawable);
        return bl;
    }
}
