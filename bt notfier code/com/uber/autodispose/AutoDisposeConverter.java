/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.CompletableSubscribeProxy
 *  com.uber.autodispose.FlowableSubscribeProxy
 *  com.uber.autodispose.MaybeSubscribeProxy
 *  com.uber.autodispose.ObservableSubscribeProxy
 *  com.uber.autodispose.ParallelFlowableSubscribeProxy
 *  com.uber.autodispose.SingleSubscribeProxy
 *  io.reactivex.CompletableConverter
 *  io.reactivex.FlowableConverter
 *  io.reactivex.MaybeConverter
 *  io.reactivex.ObservableConverter
 *  io.reactivex.SingleConverter
 *  io.reactivex.parallel.ParallelFlowableConverter
 */
package com.uber.autodispose;

import com.uber.autodispose.CompletableSubscribeProxy;
import com.uber.autodispose.FlowableSubscribeProxy;
import com.uber.autodispose.MaybeSubscribeProxy;
import com.uber.autodispose.ObservableSubscribeProxy;
import com.uber.autodispose.ParallelFlowableSubscribeProxy;
import com.uber.autodispose.SingleSubscribeProxy;
import io.reactivex.CompletableConverter;
import io.reactivex.FlowableConverter;
import io.reactivex.MaybeConverter;
import io.reactivex.ObservableConverter;
import io.reactivex.SingleConverter;
import io.reactivex.parallel.ParallelFlowableConverter;

public interface AutoDisposeConverter<T>
extends FlowableConverter<T, FlowableSubscribeProxy<T>>,
ParallelFlowableConverter<T, ParallelFlowableSubscribeProxy<T>>,
ObservableConverter<T, ObservableSubscribeProxy<T>>,
MaybeConverter<T, MaybeSubscribeProxy<T>>,
SingleConverter<T, SingleSubscribeProxy<T>>,
CompletableConverter<CompletableSubscribeProxy> {
}
