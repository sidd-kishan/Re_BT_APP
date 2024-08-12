/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$AnimationBuilder
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/*
 * Exception performing whole class analysis ignored.
 */
class SubsamplingScaleImageView.2
extends GestureDetector.SimpleOnGestureListener {
    final SubsamplingScaleImageView this$0;
    final Context val$context;

    SubsamplingScaleImageView.2(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        this.this$0 = subsamplingScaleImageView;
        this.val$context = context;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!SubsamplingScaleImageView.access$1400((SubsamplingScaleImageView)this.this$0)) return super.onDoubleTapEvent(motionEvent);
        if (!SubsamplingScaleImageView.access$700((SubsamplingScaleImageView)this.this$0)) return super.onDoubleTapEvent(motionEvent);
        if (SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0) == null) return super.onDoubleTapEvent(motionEvent);
        SubsamplingScaleImageView.access$1500((SubsamplingScaleImageView)this.this$0, (Context)this.val$context);
        if (SubsamplingScaleImageView.access$1600((SubsamplingScaleImageView)this.this$0)) {
            SubsamplingScaleImageView.access$1702((SubsamplingScaleImageView)this.this$0, (PointF)new PointF(motionEvent.getX(), motionEvent.getY()));
            SubsamplingScaleImageView.access$1802((SubsamplingScaleImageView)this.this$0, (PointF)new PointF(SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).x, SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).y));
            SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
            SubsamplingScaleImageView.access$1902((SubsamplingScaleImageView)subsamplingScaleImageView, (float)SubsamplingScaleImageView.access$1000((SubsamplingScaleImageView)subsamplingScaleImageView));
            SubsamplingScaleImageView.access$2002((SubsamplingScaleImageView)this.this$0, (boolean)true);
            SubsamplingScaleImageView.access$902((SubsamplingScaleImageView)this.this$0, (boolean)true);
            SubsamplingScaleImageView.access$2102((SubsamplingScaleImageView)this.this$0, (float)-1.0f);
            subsamplingScaleImageView = this.this$0;
            SubsamplingScaleImageView.access$2202((SubsamplingScaleImageView)subsamplingScaleImageView, (PointF)subsamplingScaleImageView.viewToSourceCoord(SubsamplingScaleImageView.access$1700((SubsamplingScaleImageView)subsamplingScaleImageView)));
            SubsamplingScaleImageView.access$2302((SubsamplingScaleImageView)this.this$0, (PointF)new PointF(motionEvent.getX(), motionEvent.getY()));
            SubsamplingScaleImageView.access$2402((SubsamplingScaleImageView)this.this$0, (PointF)new PointF(SubsamplingScaleImageView.access$2200((SubsamplingScaleImageView)this.this$0).x, SubsamplingScaleImageView.access$2200((SubsamplingScaleImageView)this.this$0).y));
            SubsamplingScaleImageView.access$2502((SubsamplingScaleImageView)this.this$0, (boolean)false);
            return false;
        }
        SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
        SubsamplingScaleImageView.access$2600((SubsamplingScaleImageView)subsamplingScaleImageView, (PointF)subsamplingScaleImageView.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), (PointF)new PointF(motionEvent.getX(), motionEvent.getY()));
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!SubsamplingScaleImageView.access$600((SubsamplingScaleImageView)this.this$0)) return super.onFling(motionEvent, motionEvent2, f, f2);
        if (!SubsamplingScaleImageView.access$700((SubsamplingScaleImageView)this.this$0)) return super.onFling(motionEvent, motionEvent2, f, f2);
        if (SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0) == null) return super.onFling(motionEvent, motionEvent2, f, f2);
        if (motionEvent == null) return super.onFling(motionEvent, motionEvent2, f, f2);
        if (motionEvent2 == null) return super.onFling(motionEvent, motionEvent2, f, f2);
        if (!(Math.abs(motionEvent.getX() - motionEvent2.getX()) > 50.0f)) {
            if (!(Math.abs(motionEvent.getY() - motionEvent2.getY()) > 50.0f)) return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        if (!(Math.abs(f) > 500.0f)) {
            if (!(Math.abs(f2) > 500.0f)) return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        if (SubsamplingScaleImageView.access$900((SubsamplingScaleImageView)this.this$0)) return super.onFling(motionEvent, motionEvent2, f, f2);
        motionEvent = new PointF(SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).x + f * 0.25f, SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).y + f2 * 0.25f);
        f = ((float)(this.this$0.getWidth() / 2) - motionEvent.x) / SubsamplingScaleImageView.access$1000((SubsamplingScaleImageView)this.this$0);
        f2 = ((float)(this.this$0.getHeight() / 2) - motionEvent.y) / SubsamplingScaleImageView.access$1000((SubsamplingScaleImageView)this.this$0);
        SubsamplingScaleImageView.AnimationBuilder.access$1300((SubsamplingScaleImageView.AnimationBuilder)SubsamplingScaleImageView.AnimationBuilder.access$1200((SubsamplingScaleImageView.AnimationBuilder)new SubsamplingScaleImageView.AnimationBuilder(this.this$0, new PointF(f, f2), null).withEasing(1), (boolean)false), (int)3).start();
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.this$0.performClick();
        return true;
    }
}
