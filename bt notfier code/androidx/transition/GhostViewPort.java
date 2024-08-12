/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.transition.CanvasUtils
 *  androidx.transition.GhostView
 *  androidx.transition.GhostViewHolder
 *  androidx.transition.R$id
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.CanvasUtils;
import androidx.transition.GhostView;
import androidx.transition.GhostViewHolder;
import androidx.transition.R;
import androidx.transition.ViewUtils;

class GhostViewPort
extends ViewGroup
implements GhostView {
    private Matrix mMatrix;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new /* Unavailable Anonymous Inner Class!! */;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View view) {
        super(view.getContext());
        this.mView = view;
        this.setWillNotDraw(false);
        this.setClipChildren(false);
        this.setLayerType(2, null);
    }

    static GhostViewPort addGhost(View object, ViewGroup viewGroup, Matrix object2) {
        if (!(object.getParent() instanceof ViewGroup)) throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        GhostViewHolder ghostViewHolder = GhostViewHolder.getHolder((ViewGroup)viewGroup);
        GhostViewPort ghostViewPort = GhostViewPort.getGhostView(object);
        int n = 0;
        GhostViewPort ghostViewPort2 = ghostViewPort;
        int n2 = n;
        if (ghostViewPort != null) {
            GhostViewHolder ghostViewHolder2 = (GhostViewHolder)ghostViewPort.getParent();
            ghostViewPort2 = ghostViewPort;
            n2 = n;
            if (ghostViewHolder2 != ghostViewHolder) {
                n2 = ghostViewPort.mReferences;
                ghostViewHolder2.removeView((View)ghostViewPort);
                ghostViewPort2 = null;
            }
        }
        if (ghostViewPort2 == null) {
            ghostViewPort2 = object2;
            if (object2 == null) {
                ghostViewPort2 = new Matrix();
                GhostViewPort.calculateMatrix(object, viewGroup, (Matrix)ghostViewPort2);
            }
            object2 = new GhostViewPort((View)object);
            ((GhostViewPort)((Object)object2)).setMatrix((Matrix)ghostViewPort2);
            if (ghostViewHolder == null) {
                object = new GhostViewHolder(viewGroup);
            } else {
                ghostViewHolder.popToOverlayTop();
                object = ghostViewHolder;
            }
            GhostViewPort.copySize((View)viewGroup, object);
            GhostViewPort.copySize((View)viewGroup, (View)object2);
            object.addGhostView((GhostViewPort)((Object)object2));
            ((GhostViewPort)((Object)object2)).mReferences = n2;
            object = object2;
        } else {
            object = ghostViewPort2;
            if (object2 != null) {
                ghostViewPort2.setMatrix((Matrix)object2);
                object = ghostViewPort2;
            }
        }
        ++object.mReferences;
        return object;
    }

    static void calculateMatrix(View view, ViewGroup viewGroup, Matrix matrix) {
        view = (ViewGroup)view.getParent();
        matrix.reset();
        ViewUtils.transformMatrixToGlobal((View)view, (Matrix)matrix);
        matrix.preTranslate((float)(-view.getScrollX()), (float)(-view.getScrollY()));
        ViewUtils.transformMatrixToLocal((View)viewGroup, (Matrix)matrix);
    }

    static void copySize(View view, View view2) {
        ViewUtils.setLeftTopRightBottom((View)view2, (int)view2.getLeft(), (int)view2.getTop(), (int)(view2.getLeft() + view.getWidth()), (int)(view2.getTop() + view.getHeight()));
    }

    static GhostViewPort getGhostView(View view) {
        return (GhostViewPort)((Object)view.getTag(R.id.ghost_view));
    }

    static void removeGhost(View object) {
        int n;
        if ((object = GhostViewPort.getGhostView(object)) == null) return;
        object.mReferences = n = object.mReferences - 1;
        if (n > 0) return;
        ((GhostViewHolder)object.getParent()).removeView(object);
    }

    static void setGhostView(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, (Object)ghostViewPort);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GhostViewPort.setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility((View)this.mView, (int)4);
        if (this.mView.getParent() == null) return;
        ((View)this.mView.getParent()).invalidate();
    }

    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility((View)this.mView, (int)0);
        GhostViewPort.setGhostView(this.mView, null);
        if (this.mView.getParent() != null) {
            ((View)this.mView.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        CanvasUtils.enableZ((Canvas)canvas, (boolean)true);
        canvas.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility((View)this.mView, (int)0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility((View)this.mView, (int)4);
        this.drawChild(canvas, this.mView, this.getDrawingTime());
        CanvasUtils.enableZ((Canvas)canvas, (boolean)false);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.mStartParent = viewGroup;
        this.mStartView = view;
    }

    void setMatrix(Matrix matrix) {
        this.mMatrix = matrix;
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        if (GhostViewPort.getGhostView(this.mView) != this) return;
        n = n == 0 ? 4 : 0;
        ViewUtils.setTransitionVisibility((View)this.mView, (int)n);
    }
}
