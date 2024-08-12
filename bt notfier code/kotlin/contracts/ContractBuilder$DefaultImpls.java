/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.contracts.CallsInPlace
 *  kotlin.contracts.ContractBuilder
 *  kotlin.contracts.InvocationKind
 */
package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.contracts.CallsInPlace;
import kotlin.contracts.ContractBuilder;
import kotlin.contracts.InvocationKind;

@Metadata(k=3, mv={1, 5, 1})
public static final class ContractBuilder.DefaultImpls {
    public static /* synthetic */ CallsInPlace callsInPlace$default(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int n, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        if ((n & 2) == 0) return contractBuilder.callsInPlace(function, invocationKind);
        invocationKind = InvocationKind.UNKNOWN;
        return contractBuilder.callsInPlace(function, invocationKind);
    }
}
