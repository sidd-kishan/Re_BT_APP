/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.ViewStubCompat$OnInflateListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R;
import androidx.appcompat.widget.ViewStubCompat;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource = 0;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, n, 0);
        this.mInflatedId = context.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = context.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        this.setId(context.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        context.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent viewParent = this.getParent();
        if (!(viewParent instanceof ViewGroup)) throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        if (this.mLayoutResource == 0) throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        ViewGroup viewGroup = (ViewGroup)viewParent;
        viewParent = this.mInflater;
        if (viewParent == null) {
            viewParent = LayoutInflater.from((Context)this.getContext());
        }
        viewParent = viewParent.inflate(this.mLayoutResource, viewGroup, false);
        int n = this.mInflatedId;
        if (n != -1) {
            viewParent.setId(n);
        }
        n = viewGroup.indexOfChild((View)this);
        viewGroup.removeViewInLayout((View)this);
        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView((View)viewParent, n, layoutParams);
        } else {
            viewGroup.addView((View)viewParent, n);
        }
        this.mInflatedViewRef = new WeakReference<ViewParent>(viewParent);
        viewGroup = this.mInflateListener;
        if (viewGroup == null) return viewParent;
        viewGroup.onInflate(this, (View)viewParent);
        return viewParent;
    }

    protected void onMeasure(int n, int n2) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int n) {
        this.mInflatedId = n;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int n) {
        this.mLayoutResource = n;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.mInflateListener = onInflateListener;
    }

    public void setVisibility(int n) {
        View view = this.mInflatedViewRef;
        if (view != null) {
            if ((view = (View)view.get()) == null) throw new IllegalStateException("setVisibility called on un-referenced view");
            view.setVisibility(n);
        } else {
            super.setVisibility(n);
            if (n != 0) {
                if (n != 4) return;
            }
            this.inflate();
        }
    }
}
