/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterHelper$UpdateOp
 *  androidx.recyclerview.widget.OpReorderer$Callback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.OpReorderer;
import java.util.List;

class OpReorderer {
    final Callback mCallback;

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        int n = list.size() - 1;
        boolean bl = false;
        while (n >= 0) {
            boolean bl2;
            if (list.get((int)n).cmd == 8) {
                bl2 = bl;
                if (bl) {
                    return n;
                }
            } else {
                bl2 = true;
            }
            --n;
            bl = bl2;
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int n, AdapterHelper.UpdateOp updateOp, int n2, AdapterHelper.UpdateOp updateOp2) {
        int n3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        int n4 = n3;
        if (updateOp.positionStart < updateOp2.positionStart) {
            n4 = n3 + 1;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += n4;
        list.set(n, updateOp2);
        list.set(n2, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int n, int n2) {
        AdapterHelper.UpdateOp updateOp = list.get(n);
        AdapterHelper.UpdateOp updateOp2 = list.get(n2);
        int n3 = updateOp2.cmd;
        if (n3 != 1) {
            if (n3 != 2) {
                if (n3 != 4) return;
                this.swapMoveUpdate(list, n, updateOp, n2, updateOp2);
            } else {
                this.swapMoveRemove(list, n, updateOp, n2, updateOp2);
            }
        } else {
            this.swapMoveAdd(list, n, updateOp, n2, updateOp2);
        }
    }

    void reorderOps(List<AdapterHelper.UpdateOp> list) {
        int n;
        while ((n = this.getLastMoveOutOfOrder(list)) != -1) {
            this.swapMoveOp(list, n, n + 1);
        }
    }

    /*
     * Unable to fully structure code
     */
    void swapMoveRemove(List<AdapterHelper.UpdateOp> var1_1, int var2_2, AdapterHelper.UpdateOp var3_3, int var4_4, AdapterHelper.UpdateOp var5_5) {
        block23: {
            block21: {
                block22: {
                    var8_6 = var3_3.positionStart;
                    var6_7 = var3_3.itemCount;
                    var7_8 = false;
                    if (var8_6 >= var6_7) break block21;
                    if (var5_5.positionStart != var3_3.positionStart || var5_5.itemCount != var3_3.itemCount - var3_3.positionStart) break block22;
                    var6_7 = 0;
                    ** GOTO lbl14
                }
                var6_7 = 0;
                break block23;
            }
            if (var5_5.positionStart == var3_3.itemCount + 1 && var5_5.itemCount == var3_3.positionStart - var3_3.itemCount) {
                var6_7 = 1;
lbl14:
                // 2 sources

                var7_8 = true;
            } else {
                var6_7 = 1;
            }
        }
        if (var3_3.itemCount < var5_5.positionStart) {
            --var5_5.positionStart;
        } else if (var3_3.itemCount < var5_5.positionStart + var5_5.itemCount) {
            --var5_5.itemCount;
            var3_3.cmd = 2;
            var3_3.itemCount = 1;
            if (var5_5.itemCount != 0) return;
            var1_1.remove(var4_4);
            this.mCallback.recycleUpdateOp(var5_5);
            return;
        }
        var8_6 = var3_3.positionStart;
        var9_9 = var5_5.positionStart++;
        var11_10 = null;
        if (var8_6 > var9_9 && var3_3.positionStart < var5_5.positionStart + var5_5.itemCount) {
            var10_11 = var5_5.positionStart;
            var9_9 = var5_5.itemCount;
            var8_6 = var3_3.positionStart;
            var11_10 = this.mCallback.obtainUpdateOp(2, var3_3.positionStart + 1, var10_11 + var9_9 - var8_6, null);
            var5_5.itemCount = var3_3.positionStart - var5_5.positionStart;
        }
        if (var7_8) {
            var1_1.set(var2_2, var5_5);
            var1_1.remove(var4_4);
            this.mCallback.recycleUpdateOp(var3_3);
            return;
        }
        if (var6_7 != 0) {
            if (var11_10 != null) {
                if (var3_3.positionStart > var11_10.positionStart) {
                    var3_3.positionStart -= var11_10.itemCount;
                }
                if (var3_3.itemCount > var11_10.positionStart) {
                    var3_3.itemCount -= var11_10.itemCount;
                }
            }
            if (var3_3.positionStart > var5_5.positionStart) {
                var3_3.positionStart -= var5_5.itemCount;
            }
            if (var3_3.itemCount > var5_5.positionStart) {
                var3_3.itemCount -= var5_5.itemCount;
            }
        } else {
            if (var11_10 != null) {
                if (var3_3.positionStart >= var11_10.positionStart) {
                    var3_3.positionStart -= var11_10.itemCount;
                }
                if (var3_3.itemCount >= var11_10.positionStart) {
                    var3_3.itemCount -= var11_10.itemCount;
                }
            }
            if (var3_3.positionStart >= var5_5.positionStart) {
                var3_3.positionStart -= var5_5.itemCount;
            }
            if (var3_3.itemCount >= var5_5.positionStart) {
                var3_3.itemCount -= var5_5.itemCount;
            }
        }
        var1_1.set(var2_2, var5_5);
        if (var3_3.positionStart != var3_3.itemCount) {
            var1_1.set(var4_4, var3_3);
        } else {
            var1_1.remove(var4_4);
        }
        if (var11_10 == null) return;
        var1_1.add(var2_2, var11_10);
    }

    void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int n, AdapterHelper.UpdateOp updateOp, int n2, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOp3;
        int n3 = updateOp.itemCount;
        int n4 = updateOp2.positionStart--;
        AdapterHelper.UpdateOp updateOp4 = null;
        if (n3 >= n4 && updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
            --updateOp2.itemCount;
            updateOp3 = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
        } else {
            updateOp3 = null;
        }
        if (updateOp.positionStart <= updateOp2.positionStart) {
            ++updateOp2.positionStart;
        } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
            n4 = updateOp2.positionStart + updateOp2.itemCount - updateOp.positionStart;
            updateOp4 = this.mCallback.obtainUpdateOp(4, updateOp.positionStart + 1, n4, updateOp2.payload);
            updateOp2.itemCount -= n4;
        }
        list.set(n2, updateOp);
        if (updateOp2.itemCount > 0) {
            list.set(n, updateOp2);
        } else {
            list.remove(n);
            this.mCallback.recycleUpdateOp(updateOp2);
        }
        if (updateOp3 != null) {
            list.add(n, updateOp3);
        }
        if (updateOp4 == null) return;
        list.add(n, updateOp4);
    }
}
