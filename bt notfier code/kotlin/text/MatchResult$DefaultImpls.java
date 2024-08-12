/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.text.MatchResult
 *  kotlin.text.MatchResult$Destructured
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.text.MatchResult;

@Metadata(k=3, mv={1, 5, 1})
public static final class MatchResult.DefaultImpls {
    public static MatchResult.Destructured getDestructured(MatchResult matchResult) {
        return new MatchResult.Destructured(matchResult);
    }
}
