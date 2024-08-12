/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.MatchGroup
 *  kotlin.text.MatchGroupCollection
 *  kotlin.text.MatchNamedGroupCollection
 */
package kotlin.text.jdk8;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002\u00a8\u0006\u0005"}, d2={"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k=2, mv={1, 5, 1}, pn="kotlin.text")
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection matchGroupCollection, String string) {
        Intrinsics.checkNotNullParameter((Object)matchGroupCollection, (String)"$this$get");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        MatchGroupCollection matchGroupCollection2 = matchGroupCollection;
        if (!(matchGroupCollection instanceof MatchNamedGroupCollection)) {
            matchGroupCollection2 = null;
        }
        if ((matchGroupCollection = (MatchNamedGroupCollection)matchGroupCollection2) == null) throw (Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        return matchGroupCollection.get(string);
    }
}
