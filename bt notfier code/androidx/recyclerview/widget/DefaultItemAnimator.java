/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.DefaultItemAnimator$1
 *  androidx.recyclerview.widget.DefaultItemAnimator$2
 *  androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo
 *  androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  androidx.recyclerview.widget.SimpleItemAnimator
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.List;

public class DefaultItemAnimator
extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations;
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList;
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations;
    ArrayList<ArrayList<ChangeInfo>> mChangesList;
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations;
    ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    public DefaultItemAnimator() {
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.mRemoveAnimations.add(viewHolder);
        viewPropertyAnimator.setDuration(this.getRemoveDuration()).alpha(0.0f).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
    }

    private void endChangeAnimation(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        int n = list.size() - 1;
        while (n >= 0) {
            ChangeInfo changeInfo = list.get(n);
            if (this.endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
            --n;
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            this.endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder == null) return;
        this.endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        boolean bl = false;
        if (viewHolder2 == viewHolder) {
            changeInfo.newHolder = null;
        } else {
            if (changeInfo.oldHolder != viewHolder) return false;
            changeInfo.oldHolder = null;
            bl = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        this.dispatchChangeFinished(viewHolder, bl);
        return true;
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        this.endAnimation(viewHolder);
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        this.resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.mAddAnimations.add(viewHolder);
        viewPropertyAnimator.alpha(1.0f).setDuration(this.getAddDuration()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int n, int n2, int n3, int n4) {
        if (viewHolder == viewHolder2) {
            return this.animateMove(viewHolder, n, n2, n3, n4);
        }
        float f = viewHolder.itemView.getTranslationX();
        float f2 = viewHolder.itemView.getTranslationY();
        float f3 = viewHolder.itemView.getAlpha();
        this.resetAnimation(viewHolder);
        int n5 = (int)((float)(n3 - n) - f);
        int n6 = (int)((float)(n4 - n2) - f2);
        viewHolder.itemView.setTranslationX(f);
        viewHolder.itemView.setTranslationY(f2);
        viewHolder.itemView.setAlpha(f3);
        if (viewHolder2 != null) {
            this.resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX((float)(-n5));
            viewHolder2.itemView.setTranslationY((float)(-n6));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder, viewHolder2, n, n2, n3, n4));
        return true;
    }

    void animateChangeImpl(ChangeInfo changeInfo) {
        Object object = changeInfo.oldHolder;
        View view = null;
        object = object == null ? null : object.itemView;
        RecyclerView.ViewHolder viewHolder = changeInfo.newHolder;
        if (viewHolder != null) {
            view = viewHolder.itemView;
        }
        if (object != null) {
            viewHolder = object.animate().setDuration(this.getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            viewHolder.translationX((float)(changeInfo.toX - changeInfo.fromX));
            viewHolder.translationY((float)(changeInfo.toY - changeInfo.fromY));
            viewHolder.alpha(0.0f).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
        }
        if (view == null) return;
        object = view.animate();
        this.mChangeAnimations.add(changeInfo.newHolder);
        object.translationX(0.0f).translationY(0.0f).setDuration(this.getChangeDuration()).alpha(1.0f).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int n, int n2, int n3, int n4) {
        View view = viewHolder.itemView;
        int n5 = n2 + (int)viewHolder.itemView.getTranslationY();
        this.resetAnimation(viewHolder);
        int n6 = n3 - (n += (int)viewHolder.itemView.getTranslationX());
        n2 = n4 - n5;
        if (n6 == 0 && n2 == 0) {
            this.dispatchMoveFinished(viewHolder);
            return false;
        }
        if (n6 != 0) {
            view.setTranslationX((float)(-n6));
        }
        if (n2 != 0) {
            view.setTranslationY((float)(-n2));
        }
        this.mPendingMoves.add(new MoveInfo(viewHolder, n, n5, n3, n4));
        return true;
    }

    void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int n, int n2, int n3, int n4) {
        View view = viewHolder.itemView;
        n = n3 - n;
        n2 = n4 - n2;
        if (n != 0) {
            view.animate().translationX(0.0f);
        }
        if (n2 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimator = view.animate();
        this.mMoveAnimations.add(viewHolder);
        viewPropertyAnimator.setDuration(this.getMoveDuration()).setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */).start();
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        this.resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        boolean bl = !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
        return bl;
    }

    void cancelAll(List<RecyclerView.ViewHolder> list) {
        int n = list.size() - 1;
        while (n >= 0) {
            list.get((int)n).itemView.animate().cancel();
            --n;
        }
    }

    void dispatchFinishedWhenDone() {
        if (this.isRunning()) return;
        this.dispatchAnimationsFinished();
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        ArrayList<ChangeInfo> arrayList;
        int n;
        View view = viewHolder.itemView;
        view.animate().cancel();
        for (n = this.mPendingMoves.size() - 1; n >= 0; --n) {
            if (this.mPendingMoves.get((int)n).holder != viewHolder) continue;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            this.dispatchMoveFinished(viewHolder);
            this.mPendingMoves.remove(n);
        }
        this.endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            view.setAlpha(1.0f);
            this.dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            view.setAlpha(1.0f);
            this.dispatchAddFinished(viewHolder);
        }
        for (n = this.mChangesList.size() - 1; n >= 0; --n) {
            arrayList = this.mChangesList.get(n);
            this.endChangeAnimation(arrayList, viewHolder);
            if (!arrayList.isEmpty()) continue;
            this.mChangesList.remove(n);
        }
        block2: for (n = this.mMovesList.size() - 1; n >= 0; --n) {
            arrayList = this.mMovesList.get(n);
            for (int i = arrayList.size() - 1; i >= 0; --i) {
                if (((MoveInfo)arrayList.get((int)i)).holder != viewHolder) continue;
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                this.dispatchMoveFinished(viewHolder);
                arrayList.remove(i);
                if (!arrayList.isEmpty()) continue block2;
                this.mMovesList.remove(n);
                continue block2;
            }
        }
        n = this.mAdditionsList.size() - 1;
        while (true) {
            if (n < 0) {
                this.mRemoveAnimations.remove(viewHolder);
                this.mAddAnimations.remove(viewHolder);
                this.mChangeAnimations.remove(viewHolder);
                this.mMoveAnimations.remove(viewHolder);
                this.dispatchFinishedWhenDone();
                return;
            }
            arrayList = this.mAdditionsList.get(n);
            if (arrayList.remove(viewHolder)) {
                view.setAlpha(1.0f);
                this.dispatchAddFinished(viewHolder);
                if (arrayList.isEmpty()) {
                    this.mAdditionsList.remove(n);
                }
            }
            --n;
        }
    }

    public void endAnimations() {
        int n;
        Object object;
        Object object2;
        int n2;
        for (n2 = this.mPendingMoves.size() - 1; n2 >= 0; --n2) {
            object2 = this.mPendingMoves.get(n2);
            object = ((MoveInfo)object2).holder.itemView;
            object.setTranslationY(0.0f);
            object.setTranslationX(0.0f);
            this.dispatchMoveFinished(((MoveInfo)object2).holder);
            this.mPendingMoves.remove(n2);
        }
        for (n2 = this.mPendingRemovals.size() - 1; n2 >= 0; --n2) {
            this.dispatchRemoveFinished(this.mPendingRemovals.get(n2));
            this.mPendingRemovals.remove(n2);
        }
        for (n2 = this.mPendingAdditions.size() - 1; n2 >= 0; --n2) {
            object2 = this.mPendingAdditions.get(n2);
            ((RecyclerView.ViewHolder)object2).itemView.setAlpha(1.0f);
            this.dispatchAddFinished((RecyclerView.ViewHolder)object2);
            this.mPendingAdditions.remove(n2);
        }
        for (n2 = this.mPendingChanges.size() - 1; n2 >= 0; --n2) {
            this.endChangeAnimationIfNecessary(this.mPendingChanges.get(n2));
        }
        this.mPendingChanges.clear();
        if (!this.isRunning()) {
            return;
        }
        for (n2 = this.mMovesList.size() - 1; n2 >= 0; --n2) {
            object = this.mMovesList.get(n2);
            for (n = ((ArrayList)object).size() - 1; n >= 0; --n) {
                MoveInfo moveInfo = (MoveInfo)((ArrayList)object).get(n);
                object2 = moveInfo.holder.itemView;
                object2.setTranslationY(0.0f);
                object2.setTranslationX(0.0f);
                this.dispatchMoveFinished(moveInfo.holder);
                ((ArrayList)object).remove(n);
                if (!((ArrayList)object).isEmpty()) continue;
                this.mMovesList.remove(object);
            }
        }
        for (n2 = this.mAdditionsList.size() - 1; n2 >= 0; --n2) {
            object2 = this.mAdditionsList.get(n2);
            for (n = ((ArrayList)object2).size() - 1; n >= 0; --n) {
                object = (RecyclerView.ViewHolder)((ArrayList)object2).get(n);
                ((RecyclerView.ViewHolder)object).itemView.setAlpha(1.0f);
                this.dispatchAddFinished((RecyclerView.ViewHolder)object);
                ((ArrayList)object2).remove(n);
                if (!((ArrayList)object2).isEmpty()) continue;
                this.mAdditionsList.remove(object2);
            }
        }
        n2 = this.mChangesList.size() - 1;
        while (true) {
            if (n2 < 0) {
                this.cancelAll(this.mRemoveAnimations);
                this.cancelAll(this.mMoveAnimations);
                this.cancelAll(this.mAddAnimations);
                this.cancelAll(this.mChangeAnimations);
                this.dispatchAnimationsFinished();
                return;
            }
            object2 = this.mChangesList.get(n2);
            for (n = ((ArrayList)object2).size() - 1; n >= 0; --n) {
                this.endChangeAnimationIfNecessary((ChangeInfo)((ArrayList)object2).get(n));
                if (!((ArrayList)object2).isEmpty()) continue;
                this.mChangesList.remove(object2);
            }
            --n2;
        }
    }

    public boolean isRunning() {
        boolean bl = !(this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty());
        return bl;
    }

    public void runPendingAnimations() {
        1 var12_6;
        boolean bl = this.mPendingRemovals.isEmpty() ^ true;
        boolean bl2 = this.mPendingMoves.isEmpty() ^ true;
        boolean bl3 = this.mPendingChanges.isEmpty() ^ true;
        boolean bl4 = this.mPendingAdditions.isEmpty() ^ true;
        if (!(bl || bl2 || bl4 || bl3)) {
            return;
        }
        2 var11_5 = this.mPendingRemovals.iterator();
        while (var11_5.hasNext()) {
            this.animateRemoveImpl(var11_5.next());
        }
        this.mPendingRemovals.clear();
        if (bl2) {
            var11_5 = new ArrayList();
            var11_5.addAll(this.mPendingMoves);
            this.mMovesList.add((ArrayList<MoveInfo>)var11_5);
            this.mPendingMoves.clear();
            var12_6 = new /* Unavailable Anonymous Inner Class!! */;
            if (bl) {
                ViewCompat.postOnAnimationDelayed((View)((MoveInfo)var11_5.get((int)0)).holder.itemView, (Runnable)var12_6, (long)this.getRemoveDuration());
            } else {
                var12_6.run();
            }
        }
        if (bl3) {
            var12_6 = new ArrayList();
            var12_6.addAll(this.mPendingChanges);
            this.mChangesList.add((ArrayList<ChangeInfo>)var12_6);
            this.mPendingChanges.clear();
            var11_5 = new /* Unavailable Anonymous Inner Class!! */;
            if (bl) {
                ViewCompat.postOnAnimationDelayed((View)((ChangeInfo)var12_6.get((int)0)).oldHolder.itemView, (Runnable)var11_5, (long)this.getRemoveDuration());
            } else {
                var11_5.run();
            }
        }
        if (!bl4) return;
        var11_5 = new ArrayList();
        var11_5.addAll(this.mPendingAdditions);
        this.mAdditionsList.add((ArrayList<RecyclerView.ViewHolder>)var11_5);
        this.mPendingAdditions.clear();
        var12_6 = new /* Unavailable Anonymous Inner Class!! */;
        if (!(bl || bl2 || bl3)) {
            var12_6.run();
        } else {
            long l = 0L;
            long l2 = bl ? this.getRemoveDuration() : 0L;
            long l3 = bl2 ? this.getMoveDuration() : 0L;
            if (bl3) {
                l = this.getChangeDuration();
            }
            l3 = Math.max(l3, l);
            ViewCompat.postOnAnimationDelayed((View)((RecyclerView.ViewHolder)var11_5.get((int)0)).itemView, (Runnable)var12_6, (long)(l2 + l3));
        }
    }
}
