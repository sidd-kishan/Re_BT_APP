/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Function
 *  kotlin.Metadata
 *  kotlin.contracts.CallsInPlace
 *  kotlin.contracts.InvocationKind
 *  kotlin.contracts.Returns
 *  kotlin.contracts.ReturnsNotNull
 */
package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.contracts.CallsInPlace;
import kotlin.contracts.InvocationKind;
import kotlin.contracts.Returns;
import kotlin.contracts.ReturnsNotNull;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'\u00a8\u0006\u000e"}, d2={"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface ContractBuilder {
    public <R> CallsInPlace callsInPlace(Function<? extends R> var1, InvocationKind var2);

    public Returns returns();

    public Returns returns(Object var1);

    public ReturnsNotNull returnsNotNull();
}
