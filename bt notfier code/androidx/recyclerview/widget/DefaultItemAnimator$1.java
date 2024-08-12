/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator.1
implements Runnable {
    final DefaultItemAnimator this$0;
    final ArrayList val$moves;

    DefaultItemAnimator.1(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$moves = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.val$moves.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.val$moves.clear();
                this.this$0.mMovesList.remove(this.val$moves);
                return;
            }
            DefaultItemAnimator.MoveInfo moveInfo = (DefaultItemAnimator.MoveInfo)iterator.next();
            this.this$0.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
        }
    }
}
