/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  kotlin.ranges.RangesKt
 *  kotlin.text.CharDirectionality
 */
package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.CharDirectionality;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n\u00a2\u0006\u0002\b\u0004"}, d2={"<anonymous>", "", "", "Lkotlin/text/CharDirectionality;", "invoke"}, k=3, mv={1, 5, 1})
static final class CharDirectionality.Companion.directionalityMap.2
extends Lambda
implements Function0<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality.Companion.directionalityMap.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    CharDirectionality.Companion.directionalityMap.2() {
    }

    public final Map<Integer, CharDirectionality> invoke() {
        CharDirectionality[] charDirectionalityArray = CharDirectionality.values();
        Map map = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)charDirectionalityArray.length), (int)16));
        int n = charDirectionalityArray.length;
        int n2 = 0;
        while (n2 < n) {
            CharDirectionality charDirectionality = charDirectionalityArray[n2];
            map.put(charDirectionality.getValue(), charDirectionality);
            ++n2;
        }
        return map;
    }
}
