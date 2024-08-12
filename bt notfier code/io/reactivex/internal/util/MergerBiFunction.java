/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 */
package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MergerBiFunction<T>
implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List<T> apply(List<T> var1_1, List<T> var2_2) throws Exception {
        block8: {
            var3_3 = var1_1.size() + var2_2 /* !! */ .size();
            if (var3_3 == 0) {
                return new ArrayList<E>();
            }
            var5_4 = new ArrayList<List<T>>(var3_3);
            var6_5 = var1_1.iterator();
            var7_6 = var2_2 /* !! */ .iterator();
            var1_1 = var6_5.hasNext() != false ? var6_5.next() : null;
            var4_7 /* !! */  = var1_1;
            if (!var7_6.hasNext()) break block8;
            var2_2 /* !! */  = var7_6.next();
            ** GOTO lbl16
        }
        block0: while (true) {
            var2_2 /* !! */  = null;
            var1_1 = var4_7 /* !! */ ;
            while (var1_1 != null && var2_2 /* !! */  != null) {
                if (this.comparator.compare(var1_1, var2_2 /* !! */ ) < 0) {
                    var5_4.add(var1_1);
                    if (var6_5.hasNext()) {
                        var1_1 = var6_5.next();
                        continue;
                    }
                    var1_1 = null;
                    continue;
                }
                var5_4.add(var2_2 /* !! */ );
                var4_7 /* !! */  = var1_1;
                if (!var7_6.hasNext()) continue block0;
                var2_2 /* !! */  = var7_6.next();
            }
            break;
        }
        if (var1_1 != null) {
            var5_4.add(var1_1);
            while (var6_5.hasNext() != false) {
                var5_4.add((List<T>)var6_5.next());
            }
            return var5_4;
        }
        var5_4.add(var2_2 /* !! */ );
        while (var7_6.hasNext() != false) {
            var5_4.add((List<T>)var7_6.next());
        }
        return var5_4;
    }
}
