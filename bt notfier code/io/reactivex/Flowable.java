/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureOverflowStrategy
 *  io.reactivex.BackpressureStrategy
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Emitter
 *  io.reactivex.FlowableConverter
 *  io.reactivex.FlowableOnSubscribe
 *  io.reactivex.FlowableOperator
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.FlowableTransformer
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeSource
 *  io.reactivex.Notification
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleSource
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.flowables.GroupedFlowable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.BooleanSupplier
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Function3
 *  io.reactivex.functions.Function4
 *  io.reactivex.functions.Function5
 *  io.reactivex.functions.Function6
 *  io.reactivex.functions.Function7
 *  io.reactivex.functions.Function8
 *  io.reactivex.functions.Function9
 *  io.reactivex.functions.LongConsumer
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ScalarCallable
 *  io.reactivex.internal.operators.flowable.BlockingFlowableIterable
 *  io.reactivex.internal.operators.flowable.BlockingFlowableLatest
 *  io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent
 *  io.reactivex.internal.operators.flowable.BlockingFlowableNext
 *  io.reactivex.internal.operators.flowable.FlowableAllSingle
 *  io.reactivex.internal.operators.flowable.FlowableAmb
 *  io.reactivex.internal.operators.flowable.FlowableAnySingle
 *  io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe
 *  io.reactivex.internal.operators.flowable.FlowableBuffer
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundary
 *  io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier
 *  io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed
 *  io.reactivex.internal.operators.flowable.FlowableCache
 *  io.reactivex.internal.operators.flowable.FlowableCollectSingle
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest
 *  io.reactivex.internal.operators.flowable.FlowableConcatArray
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap
 *  io.reactivex.internal.operators.flowable.FlowableConcatMapEager
 *  io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher
 *  io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable
 *  io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe
 *  io.reactivex.internal.operators.flowable.FlowableConcatWithSingle
 *  io.reactivex.internal.operators.flowable.FlowableCountSingle
 *  io.reactivex.internal.operators.flowable.FlowableCreate
 *  io.reactivex.internal.operators.flowable.FlowableDebounce
 *  io.reactivex.internal.operators.flowable.FlowableDebounceTimed
 *  io.reactivex.internal.operators.flowable.FlowableDefer
 *  io.reactivex.internal.operators.flowable.FlowableDelay
 *  io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther
 *  io.reactivex.internal.operators.flowable.FlowableDematerialize
 *  io.reactivex.internal.operators.flowable.FlowableDetach
 *  io.reactivex.internal.operators.flowable.FlowableDistinct
 *  io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged
 *  io.reactivex.internal.operators.flowable.FlowableDoAfterNext
 *  io.reactivex.internal.operators.flowable.FlowableDoFinally
 *  io.reactivex.internal.operators.flowable.FlowableDoOnEach
 *  io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle
 *  io.reactivex.internal.operators.flowable.FlowableElementAtMaybe
 *  io.reactivex.internal.operators.flowable.FlowableElementAtSingle
 *  io.reactivex.internal.operators.flowable.FlowableEmpty
 *  io.reactivex.internal.operators.flowable.FlowableError
 *  io.reactivex.internal.operators.flowable.FlowableFilter
 *  io.reactivex.internal.operators.flowable.FlowableFlatMap
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe
 *  io.reactivex.internal.operators.flowable.FlowableFlatMapSingle
 *  io.reactivex.internal.operators.flowable.FlowableFlattenIterable
 *  io.reactivex.internal.operators.flowable.FlowableFromArray
 *  io.reactivex.internal.operators.flowable.FlowableFromCallable
 *  io.reactivex.internal.operators.flowable.FlowableFromFuture
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable
 *  io.reactivex.internal.operators.flowable.FlowableFromPublisher
 *  io.reactivex.internal.operators.flowable.FlowableGenerate
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy
 *  io.reactivex.internal.operators.flowable.FlowableGroupJoin
 *  io.reactivex.internal.operators.flowable.FlowableHide
 *  io.reactivex.internal.operators.flowable.FlowableIgnoreElements
 *  io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax
 *  io.reactivex.internal.operators.flowable.FlowableInterval
 *  io.reactivex.internal.operators.flowable.FlowableIntervalRange
 *  io.reactivex.internal.operators.flowable.FlowableJoin
 *  io.reactivex.internal.operators.flowable.FlowableJust
 *  io.reactivex.internal.operators.flowable.FlowableLastMaybe
 *  io.reactivex.internal.operators.flowable.FlowableLastSingle
 *  io.reactivex.internal.operators.flowable.FlowableLift
 *  io.reactivex.internal.operators.flowable.FlowableLimit
 *  io.reactivex.internal.operators.flowable.FlowableMap
 *  io.reactivex.internal.operators.flowable.FlowableMapNotification
 *  io.reactivex.internal.operators.flowable.FlowableMaterialize
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe
 *  io.reactivex.internal.operators.flowable.FlowableMergeWithSingle
 *  io.reactivex.internal.operators.flowable.FlowableNever
 *  io.reactivex.internal.operators.flowable.FlowableObserveOn
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest
 *  io.reactivex.internal.operators.flowable.FlowableOnErrorNext
 *  io.reactivex.internal.operators.flowable.FlowableOnErrorReturn
 *  io.reactivex.internal.operators.flowable.FlowablePublish
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast
 *  io.reactivex.internal.operators.flowable.FlowableRange
 *  io.reactivex.internal.operators.flowable.FlowableRangeLong
 *  io.reactivex.internal.operators.flowable.FlowableReduceMaybe
 *  io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle
 *  io.reactivex.internal.operators.flowable.FlowableReduceWithSingle
 *  io.reactivex.internal.operators.flowable.FlowableRepeat
 *  io.reactivex.internal.operators.flowable.FlowableRepeatUntil
 *  io.reactivex.internal.operators.flowable.FlowableRepeatWhen
 *  io.reactivex.internal.operators.flowable.FlowableReplay
 *  io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate
 *  io.reactivex.internal.operators.flowable.FlowableRetryPredicate
 *  io.reactivex.internal.operators.flowable.FlowableRetryWhen
 *  io.reactivex.internal.operators.flowable.FlowableSamplePublisher
 *  io.reactivex.internal.operators.flowable.FlowableSampleTimed
 *  io.reactivex.internal.operators.flowable.FlowableScalarXMap
 *  io.reactivex.internal.operators.flowable.FlowableScan
 *  io.reactivex.internal.operators.flowable.FlowableScanSeed
 *  io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle
 *  io.reactivex.internal.operators.flowable.FlowableSerialized
 *  io.reactivex.internal.operators.flowable.FlowableSingleMaybe
 *  io.reactivex.internal.operators.flowable.FlowableSingleSingle
 *  io.reactivex.internal.operators.flowable.FlowableSkip
 *  io.reactivex.internal.operators.flowable.FlowableSkipLast
 *  io.reactivex.internal.operators.flowable.FlowableSkipLastTimed
 *  io.reactivex.internal.operators.flowable.FlowableSkipUntil
 *  io.reactivex.internal.operators.flowable.FlowableSkipWhile
 *  io.reactivex.internal.operators.flowable.FlowableSubscribeOn
 *  io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty
 *  io.reactivex.internal.operators.flowable.FlowableSwitchMap
 *  io.reactivex.internal.operators.flowable.FlowableTake
 *  io.reactivex.internal.operators.flowable.FlowableTakeLast
 *  io.reactivex.internal.operators.flowable.FlowableTakeLastOne
 *  io.reactivex.internal.operators.flowable.FlowableTakeLastTimed
 *  io.reactivex.internal.operators.flowable.FlowableTakeUntil
 *  io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate
 *  io.reactivex.internal.operators.flowable.FlowableTakeWhile
 *  io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed
 *  io.reactivex.internal.operators.flowable.FlowableThrottleLatest
 *  io.reactivex.internal.operators.flowable.FlowableTimeInterval
 *  io.reactivex.internal.operators.flowable.FlowableTimeout
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed
 *  io.reactivex.internal.operators.flowable.FlowableTimer
 *  io.reactivex.internal.operators.flowable.FlowableToListSingle
 *  io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn
 *  io.reactivex.internal.operators.flowable.FlowableUsing
 *  io.reactivex.internal.operators.flowable.FlowableWindow
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundary
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFrom
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany
 *  io.reactivex.internal.operators.flowable.FlowableZip
 *  io.reactivex.internal.operators.flowable.FlowableZipIterable
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe
 *  io.reactivex.internal.operators.mixed.FlowableConcatMapSingle
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe
 *  io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle
 *  io.reactivex.internal.operators.observable.ObservableFromPublisher
 *  io.reactivex.internal.schedulers.ImmediateThinScheduler
 *  io.reactivex.internal.subscribers.BlockingFirstSubscriber
 *  io.reactivex.internal.subscribers.BlockingLastSubscriber
 *  io.reactivex.internal.subscribers.ForEachWhileSubscriber
 *  io.reactivex.internal.subscribers.FutureSubscriber
 *  io.reactivex.internal.subscribers.LambdaSubscriber
 *  io.reactivex.internal.subscribers.StrictSubscriber
 *  io.reactivex.internal.util.ArrayListSupplier
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.HashMapSupplier
 *  io.reactivex.parallel.ParallelFlowable
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 *  io.reactivex.schedulers.Timed
 *  io.reactivex.subscribers.SafeSubscriber
 *  io.reactivex.subscribers.TestSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Emitter;
import io.reactivex.FlowableConverter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableOperator;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.internal.operators.flowable.FlowableDetach;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableHide;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.internal.operators.flowable.FlowableLift;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableScan;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSerialized;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.flowable.FlowableSkip;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.FutureSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.SafeSubscriber;
import io.reactivex.subscribers.TestSubscriber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T>
implements Publisher<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128));

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableAmb(null, iterable));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> ambArray(Publisher<? extends T> ... publisherArray) {
        ObjectHelper.requireNonNull(publisherArray, (String)"sources is null");
        int n = publisherArray.length;
        if (n == 0) {
            return Flowable.empty();
        }
        if (n != 1) return RxJavaPlugins.onAssembly((Flowable)new FlowableAmb(publisherArray, null));
        return Flowable.fromPublisher(publisherArray[0]);
    }

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T> ... publisherArray) {
        return Flowable.combineLatest(publisherArray, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return Flowable.combineLatest(iterable, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCombineLatest(iterable, function, n, false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.combineLatest(Functions.toFunction(biFunction), publisher, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        return Flowable.combineLatest(Functions.toFunction(function3), publisher, publisher2, publisher3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        return Flowable.combineLatest(Functions.toFunction(function4), publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        return Flowable.combineLatest(Functions.toFunction(function5), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        return Flowable.combineLatest(Functions.toFunction(function6), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        return Flowable.combineLatest(Functions.toFunction(function7), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        ObjectHelper.requireNonNull(publisher8, (String)"source8 is null");
        return Flowable.combineLatest(Functions.toFunction(function8), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        ObjectHelper.requireNonNull(publisher8, (String)"source8 is null");
        ObjectHelper.requireNonNull(publisher9, (String)"source9 is null");
        return Flowable.combineLatest(Functions.toFunction(function9), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArray, Function<? super Object[], ? extends R> function) {
        return Flowable.combineLatest(publisherArray, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArray, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(publisherArray, (String)"sources is null");
        if (publisherArray.length == 0) {
            return Flowable.empty();
        }
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCombineLatest(publisherArray, function, n, false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int n, Publisher<? extends T> ... publisherArray) {
        return Flowable.combineLatestDelayError(publisherArray, function, n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, Publisher<? extends T> ... publisherArray) {
        return Flowable.combineLatestDelayError(publisherArray, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return Flowable.combineLatestDelayError(iterable, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCombineLatest(iterable, function, n, true));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArray, Function<? super Object[], ? extends R> function) {
        return Flowable.combineLatestDelayError(publisherArray, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArray, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(publisherArray, (String)"sources is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (publisherArray.length != 0) return RxJavaPlugins.onAssembly((Flowable)new FlowableCombineLatest(publisherArray, function, n, true));
        return Flowable.empty();
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return Flowable.fromIterable(iterable).concatMapDelayError(Functions.identity(), 2, false);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.concat(publisher, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher, int n) {
        return Flowable.fromPublisher(publisher).concatMap(Functions.identity(), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.concatArray(publisher, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        return Flowable.concatArray(publisher, publisher2, publisher3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        return Flowable.concatArray(publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArray(Publisher<? extends T> ... publisherArray) {
        if (publisherArray.length == 0) {
            return Flowable.empty();
        }
        if (publisherArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatArray(publisherArray, false));
        return Flowable.fromPublisher(publisherArray[0]);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T> ... publisherArray) {
        if (publisherArray.length == 0) {
            return Flowable.empty();
        }
        if (publisherArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatArray(publisherArray, true));
        return Flowable.fromPublisher(publisherArray[0]);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEager(int n, int n2, Publisher<? extends T> ... publisherArray) {
        ObjectHelper.requireNonNull(publisherArray, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapEager((Flowable)new FlowableFromArray((Object[])publisherArray), Functions.identity(), n, n2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEager(Publisher<? extends T> ... publisherArray) {
        return Flowable.concatArrayEager(Flowable.bufferSize(), Flowable.bufferSize(), publisherArray);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEagerDelayError(int n, int n2, Publisher<? extends T> ... publisherArray) {
        return Flowable.fromArray(publisherArray).concatMapEagerDelayError(Functions.identity(), n, n2, true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatArrayEagerDelayError(Publisher<? extends T> ... publisherArray) {
        return Flowable.concatArrayEagerDelayError(Flowable.bufferSize(), Flowable.bufferSize(), publisherArray);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return Flowable.fromIterable(iterable).concatMapDelayError(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.concatDelayError(publisher, Flowable.bufferSize(), true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher, int n, boolean bl) {
        return Flowable.fromPublisher(publisher).concatMapDelayError(Functions.identity(), n, bl);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable) {
        return Flowable.concatEager(iterable, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable, int n, int n2) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapEager((Flowable)new FlowableFromIterable(iterable), Functions.identity(), n, n2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.concatEager(publisher, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher, int n, int n2) {
        ObjectHelper.requireNonNull(publisher, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapEagerPublisher(publisher, Functions.identity(), n, n2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> create(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.requireNonNull(flowableOnSubscribe, (String)"source is null");
        ObjectHelper.requireNonNull((Object)backpressureStrategy, (String)"mode is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, (String)"supplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDefer(callable));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    private Flowable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.requireNonNull((Object)action2, (String)"onAfterTerminate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> empty() {
        return RxJavaPlugins.onAssembly((Flowable)FlowableEmpty.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> error(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"throwable is null");
        return Flowable.error(Functions.justCallable((Object)throwable));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, (String)"supplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableError(callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromArray(T ... TArray) {
        ObjectHelper.requireNonNull(TArray, (String)"items is null");
        if (TArray.length == 0) {
            return Flowable.empty();
        }
        if (TArray.length != 1) return RxJavaPlugins.onAssembly((Flowable)new FlowableFromArray((Object[])TArray));
        return Flowable.just(TArray[0]);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, (String)"supplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromCallable(callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromFuture(future, 0L, null));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromFuture(future, l, timeUnit));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return Flowable.fromFuture(future, l, timeUnit).subscribeOn(scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Flowable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return Flowable.fromFuture(future).subscribeOn(scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"source is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> fromPublisher(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.onAssembly((Flowable)((Flowable)publisher));
        }
        ObjectHelper.requireNonNull(publisher, (String)"source is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromPublisher(publisher));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"generator is null");
        return Flowable.generate(Functions.nullSupplier(), FlowableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"generator is null");
        return Flowable.generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"generator is null");
        return Flowable.generate(callable, FlowableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return Flowable.generate(callable, biFunction, Functions.emptyConsumer());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, (String)"initialState is null");
        ObjectHelper.requireNonNull(biFunction, (String)"generator is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposeState is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableGenerate(callable, biFunction, consumer));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Flowable<Long> interval(long l, long l2, TimeUnit timeUnit) {
        return Flowable.interval(l, l2, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Flowable<Long> interval(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableInterval(Math.max(0L, l), Math.max(0L, l2), timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Flowable<Long> interval(long l, TimeUnit timeUnit) {
        return Flowable.interval(l, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Flowable<Long> interval(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return Flowable.interval(l, l, timeUnit, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Flowable<Long> intervalRange(long l, long l2, long l3, long l4, TimeUnit timeUnit) {
        return Flowable.intervalRange(l, l2, l3, l4, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Flowable<Long> intervalRange(long l, long l2, long l3, long l4, TimeUnit object, Scheduler scheduler) {
        if (l2 < 0L) {
            object = new StringBuilder();
            ((StringBuilder)object).append("count >= 0 required but it was ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (l2 == 0L) {
            return Flowable.empty().delay(l3, (TimeUnit)((Object)object), scheduler);
        }
        l2 = l + (l2 - 1L);
        if (l > 0L) {
            if (l2 < 0L) throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        ObjectHelper.requireNonNull((Object)object, (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableIntervalRange(l, l2, Math.max(0L, l3), Math.max(0L, l4), (TimeUnit)((Object)object), scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableJust(t));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        return Flowable.fromArray(t, t2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        return Flowable.fromArray(t, t2, t3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        return Flowable.fromArray(t, t2, t3, t4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5, t6);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        ObjectHelper.requireNonNull(t8, (String)"item8 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        ObjectHelper.requireNonNull(t8, (String)"item8 is null");
        ObjectHelper.requireNonNull(t9, (String)"item9 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        ObjectHelper.requireNonNull(t8, (String)"item8 is null");
        ObjectHelper.requireNonNull(t9, (String)"item9 is null");
        ObjectHelper.requireNonNull(t10, (String)"item10 is null");
        return Flowable.fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int n) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity(), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int n, int n2) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity(), false, n, n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.merge(publisher, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher, int n) {
        return Flowable.fromPublisher(publisher).flatMap(Functions.identity(), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.fromArray(publisher, publisher2).flatMap(Functions.identity(), false, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        return Flowable.fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), false, 3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        return Flowable.fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), false, 4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArray(int n, int n2, Publisher<? extends T> ... publisherArray) {
        return Flowable.fromArray(publisherArray).flatMap(Functions.identity(), false, n, n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArray(Publisher<? extends T> ... publisherArray) {
        return Flowable.fromArray(publisherArray).flatMap(Functions.identity(), publisherArray.length);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArrayDelayError(int n, int n2, Publisher<? extends T> ... publisherArray) {
        return Flowable.fromArray(publisherArray).flatMap(Functions.identity(), true, n, n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T> ... publisherArray) {
        return Flowable.fromArray(publisherArray).flatMap(Functions.identity(), true, publisherArray.length);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int n) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity(), true, n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int n, int n2) {
        return Flowable.fromIterable(iterable).flatMap(Functions.identity(), true, n, n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.mergeDelayError(publisher, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher, int n) {
        return Flowable.fromPublisher(publisher).flatMap(Functions.identity(), true, n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.fromArray(publisher, publisher2).flatMap(Functions.identity(), true, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        return Flowable.fromArray(publisher, publisher2, publisher3).flatMap(Functions.identity(), true, 3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        return Flowable.fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.identity(), true, 4);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> never() {
        return RxJavaPlugins.onAssembly((Flowable)FlowableNever.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Flowable<Integer> range(int n, int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 == 0) {
            return Flowable.empty();
        }
        if (n2 == 1) {
            return Flowable.just(n);
        }
        if ((long)n + (long)(n2 - 1) > Integer.MAX_VALUE) throw new IllegalArgumentException("Integer overflow");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRange(n, n2));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Flowable<Long> rangeLong(long l, long l2) {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (l2 == 0L) {
            return Flowable.empty();
        }
        if (l2 == 1L) {
            return Flowable.just(l);
        }
        if (l <= 0L) return RxJavaPlugins.onAssembly((Flowable)new FlowableRangeLong(l, l2));
        if (l2 - 1L + l < 0L) throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRangeLong(l, l2));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        return Flowable.sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, int n) {
        return Flowable.sequenceEqual(publisher, publisher2, ObjectHelper.equalsPredicate(), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate) {
        return Flowable.sequenceEqual(publisher, publisher2, biPredicate, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(biPredicate, (String)"isEqual is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Single)new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).switchMap(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher, int n) {
        return Flowable.fromPublisher(publisher).switchMap(Functions.identity(), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return Flowable.switchOnNextDelayError(publisher, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher, int n) {
        return Flowable.fromPublisher(publisher).switchMapDelayError(Functions.identity(), n);
    }

    private Flowable<T> timeout0(long l, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"timeUnit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTimeoutTimed(this, l, timeUnit, scheduler, publisher));
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(function, (String)"itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTimeout(this, publisher, function, publisher2));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Flowable<Long> timer(long l, TimeUnit timeUnit) {
        return Flowable.timer(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Flowable<Long> timer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTimer(Math.max(0L, l), timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.NONE)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Flowable<T> unsafeCreate(Publisher<T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"onSubscribe is null");
        if (publisher instanceof Flowable) throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFromPublisher(publisher));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer) {
        return Flowable.using(callable, function, consumer, true);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        ObjectHelper.requireNonNull(callable, (String)"resourceSupplier is null");
        ObjectHelper.requireNonNull(function, (String)"sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, (String)"resourceDisposer is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableUsing(callable, function, consumer, bl));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableZip(null, iterable, function, Flowable.bufferSize(), false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> zip(Publisher<? extends Publisher<? extends T>> publisher, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        return Flowable.fromPublisher(publisher).toList().flatMapPublisher(FlowableInternalHelper.zipIterable(function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.zipArray(Functions.toFunction(biFunction), false, Flowable.bufferSize(), publisher, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean bl) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.zipArray(Functions.toFunction(biFunction), bl, Flowable.bufferSize(), publisher, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean bl, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        return Flowable.zipArray(Functions.toFunction(biFunction), bl, n, publisher, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        return Flowable.zipArray(Functions.toFunction(function3), false, Flowable.bufferSize(), publisher, publisher2, publisher3);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        return Flowable.zipArray(Functions.toFunction(function4), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        return Flowable.zipArray(Functions.toFunction(function5), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        return Flowable.zipArray(Functions.toFunction(function6), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        return Flowable.zipArray(Functions.toFunction(function7), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        ObjectHelper.requireNonNull(publisher8, (String)"source8 is null");
        return Flowable.zipArray(Functions.toFunction(function8), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        ObjectHelper.requireNonNull(publisher5, (String)"source5 is null");
        ObjectHelper.requireNonNull(publisher6, (String)"source6 is null");
        ObjectHelper.requireNonNull(publisher7, (String)"source7 is null");
        ObjectHelper.requireNonNull(publisher8, (String)"source8 is null");
        ObjectHelper.requireNonNull(publisher9, (String)"source9 is null");
        return Flowable.zipArray(Functions.toFunction(function9), false, Flowable.bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> function, boolean bl, int n, Publisher<? extends T> ... publisherArray) {
        if (publisherArray.length == 0) {
            return Flowable.empty();
        }
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableZip(publisherArray, null, function, n, bl));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableZip(null, iterable, function, n, bl));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableAllSingle(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> ambWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return Flowable.ambArray(this, publisher);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableAnySingle(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R as(FlowableConverter<T, ? extends R> flowableConverter) {
        return (R)((FlowableConverter)ObjectHelper.requireNonNull(flowableConverter, (String)"converter is null")).apply(this);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingFirst() {
        Object object = new BlockingFirstSubscriber();
        this.subscribe((FlowableSubscriber<? super T>)object);
        object = object.blockingGet();
        if (object == null) throw new NoSuchElementException();
        return (T)object;
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingFirst(T object) {
        Object object2 = new BlockingFirstSubscriber();
        this.subscribe((FlowableSubscriber<? super T>)object2);
        object2 = object2.blockingGet();
        if (object2 == null) return object;
        object = object2;
        return object;
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator<T> iterator = this.blockingIterable().iterator();
        while (iterator.hasNext()) {
            try {
                consumer.accept(iterator.next());
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                ((Disposable)iterator).dispose();
                throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
            }
        }
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingIterable() {
        return this.blockingIterable(Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingIterable(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return new BlockingFlowableIterable(this, n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingLast() {
        Object object = new BlockingLastSubscriber();
        this.subscribe((FlowableSubscriber<? super T>)object);
        object = object.blockingGet();
        if (object == null) throw new NoSuchElementException();
        return (T)object;
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingLast(T object) {
        Object object2 = new BlockingLastSubscriber();
        this.subscribe((FlowableSubscriber<? super T>)object2);
        object2 = object2.blockingGet();
        if (object2 == null) return object;
        object = object2;
        return object;
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingLatest() {
        return new BlockingFlowableLatest((Publisher)this);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingFlowableMostRecent(this, t);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingNext() {
        return new BlockingFlowableNext((Publisher)this);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingSingle() {
        return (T)this.singleOrError().blockingGet();
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingSingle(T t) {
        return (T)this.single(t).blockingGet();
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe() {
        FlowableBlockingSubscribe.subscribe((Publisher)this);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, (Consumer)Functions.ON_ERROR_MISSING, (Action)Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, int n) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, (Consumer)Functions.ON_ERROR_MISSING, (Action)Functions.EMPTY_ACTION, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, consumer2, (Action)Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, int n) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, consumer2, (Action)Functions.EMPTY_ACTION, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, consumer2, (Action)action);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, int n) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, consumer, consumer2, (Action)action, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Subscriber<? super T> subscriber) {
        FlowableBlockingSubscribe.subscribe((Publisher)this, subscriber);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<List<T>> buffer(int n) {
        return this.buffer(n, n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<List<T>> buffer(int n, int n2) {
        return this.buffer(n, n2, ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Flowable<U> buffer(int n, int n2, Callable<U> callable) {
        ObjectHelper.verifyPositive((int)n, (String)"count");
        ObjectHelper.verifyPositive((int)n2, (String)"skip");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBuffer(this, n, n2, callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Flowable<U> buffer(int n, Callable<U> callable) {
        return this.buffer(n, n, callable);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<List<T>> buffer(long l, long l2, TimeUnit timeUnit) {
        return this.buffer(l, l2, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<List<T>> buffer(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.buffer(l, l2, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <U extends Collection<? super T>> Flowable<U> buffer(long l, long l2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBufferTimed(this, l, l2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<List<T>> buffer(long l, TimeUnit timeUnit) {
        return this.buffer(l, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<List<T>> buffer(long l, TimeUnit timeUnit, int n) {
        return this.buffer(l, timeUnit, Schedulers.computation(), n);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<List<T>> buffer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.buffer(l, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<List<T>> buffer(long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return this.buffer(l, timeUnit, scheduler, n, ArrayListSupplier.asCallable(), false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <U extends Collection<? super T>> Flowable<U> buffer(long l, TimeUnit timeUnit, Scheduler scheduler, int n, Callable<U> callable, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        ObjectHelper.verifyPositive((int)n, (String)"count");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBufferTimed(this, l, l, timeUnit, scheduler, callable, n, bl));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        return this.buffer(flowable, function, ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(flowable, (String)"openingIndicator is null");
        ObjectHelper.requireNonNull(function, (String)"closingIndicator is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBufferBoundary(this, flowable, function, callable));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> callable) {
        return this.buffer(callable, ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, (String)"boundaryIndicatorSupplier is null");
        ObjectHelper.requireNonNull(callable2, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBufferBoundarySupplier(this, callable, callable2));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher) {
        return this.buffer(publisher, ArrayListSupplier.asCallable());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"initialCapacity");
        return this.buffer(publisher, Functions.createArrayList((int)n));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> publisher, Callable<U> callable) {
        ObjectHelper.requireNonNull(publisher, (String)"boundaryIndicator is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableBufferExactBoundary(this, publisher, callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> cache() {
        return this.cacheWithInitialCapacity(16);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> cacheWithInitialCapacity(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"initialCapacity");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableCache(this, n));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> cast(Class<U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.map(Functions.castFunction(clazz));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, (String)"initialItemSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, (String)"collector is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableCollectSingle(this, callable, biConsumer));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u, (String)"initialItem is null");
        return this.collect(Functions.justCallable(u), biConsumer);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        return Flowable.fromPublisher(((FlowableTransformer)ObjectHelper.requireNonNull(flowableTransformer, (String)"composer is null")).apply(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.concatMap(function, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMap(this, function, n, ErrorMode.IMMEDIATE));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return FlowableScalarXMap.scalarXMap((Object)object, function);
        return Flowable.empty();
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return this.concatMapCompletable(function, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Completable)new FlowableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return this.concatMapCompletableDelayError(function, true, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean bl) {
        return this.concatMapCompletableDelayError(function, bl, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Completable)new FlowableConcatMapCompletable(this, function, errorMode, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.concatMapDelayError(function, 2, true);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        if (this instanceof ScalarCallable) {
            Object object = ((ScalarCallable)this).call();
            if (object != null) return FlowableScalarXMap.scalarXMap((Object)object, function);
            return Flowable.empty();
        }
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMap(this, function, n, errorMode));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.concatMapEager(function, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapEager(this, function, n, n2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int n, int n2, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapEager(this, function, n, n2, errorMode));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl) {
        return this.concatMapEagerDelayError(function, Flowable.bufferSize(), Flowable.bufferSize(), bl);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return this.concatMapIterable(function, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlattenIterable(this, function, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.concatMapMaybe(function, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.concatMapMaybeDelayError(function, true, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        return this.concatMapMaybeDelayError(function, bl, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapMaybe(this, function, errorMode, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.concatMapSingle(function, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.concatMapSingleDelayError(function, true, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        return this.concatMapSingleDelayError(function, bl, 2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatMapSingle(this, function, errorMode, n));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatWithCompletable(this, completableSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableConcatWithSingle(this, singleSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return Flowable.concat(this, publisher);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> contains(Object object) {
        ObjectHelper.requireNonNull((Object)object, (String)"item is null");
        return this.any(Functions.equalsWith((Object)object));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly((Single)new FlowableCountSingle(this));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> debounce(long l, TimeUnit timeUnit) {
        return this.debounce(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> debounce(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDebounceTimed(this, l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.requireNonNull(function, (String)"debounceIndicator is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDebounce(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return this.switchIfEmpty(Flowable.just(t));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> delay(long l, TimeUnit timeUnit) {
        return this.delay(l, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delay(l, timeUnit, scheduler, false);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDelay(this, Math.max(0L, l), timeUnit, scheduler, bl));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> delay(long l, TimeUnit timeUnit, boolean bl) {
        return this.delay(l, timeUnit, Schedulers.computation(), bl);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.requireNonNull(function, (String)"itemDelayIndicator is null");
        return this.flatMap(FlowableInternalHelper.itemDelay(function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<T> delay(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        return this.delaySubscription(publisher).delay(function);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> delaySubscription(long l, TimeUnit timeUnit) {
        return this.delaySubscription(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> delaySubscription(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delaySubscription(Flowable.timer(l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"subscriptionIndicator is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDelaySubscriptionOther((Publisher)this, publisher));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    @Deprecated
    public final <T2> Flowable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDematerialize(this, Functions.identity()));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDematerialize(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> distinct() {
        return this.distinct(Functions.identity(), Functions.createHashSet());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Flowable<T> distinct(Function<? super T, K> function) {
        return this.distinct(function, Functions.createHashSet());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Flowable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(callable, (String)"collectionSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDistinct(this, function, callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> distinctUntilChanged() {
        return this.distinctUntilChanged(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, (String)"comparer is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDistinctUntilChanged(this, Functions.identity(), biPredicate));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDistinctUntilChanged(this, function, ObjectHelper.equalsPredicate()));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onAfterNext is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDoAfterNext(this, consumer));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doAfterTerminate(Action action) {
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doFinally(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDoFinally(this, action));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnCancel(Action action) {
        return this.doOnLifecycle((Consumer<Subscription>)Functions.emptyConsumer(), Functions.EMPTY_LONG_CONSUMER, action);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnComplete(Action action) {
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onNotification is null");
        return this.doOnEach(Functions.notificationOnNext(consumer), (Consumer<Throwable>)Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnEach(Subscriber<? super T> subscriber) {
        ObjectHelper.requireNonNull(subscriber, (String)"subscriber is null");
        return this.doOnEach(FlowableInternalHelper.subscriberOnNext(subscriber), (Consumer<Throwable>)FlowableInternalHelper.subscriberOnError(subscriber), FlowableInternalHelper.subscriberOnComplete(subscriber), Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnError(Consumer<? super Throwable> consumer) {
        return this.doOnEach(Functions.emptyConsumer(), consumer, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null");
        ObjectHelper.requireNonNull((Object)longConsumer, (String)"onRequest is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onCancel is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnNext(Consumer<? super T> consumer) {
        return this.doOnEach(consumer, (Consumer<Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnRequest(LongConsumer longConsumer) {
        return this.doOnLifecycle((Consumer<Subscription>)Functions.emptyConsumer(), longConsumer, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        return this.doOnLifecycle(consumer, Functions.EMPTY_LONG_CONSUMER, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> doOnTerminate(Action action) {
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.actionConsumer((Action)action), action, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> elementAt(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Maybe)new FlowableElementAtMaybe(this, l));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> elementAt(long l, T object) {
        if (l >= 0L) {
            ObjectHelper.requireNonNull(object, (String)"defaultItem is null");
            return RxJavaPlugins.onAssembly((Single)new FlowableElementAtSingle(this, l, object));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("index >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> elementAtOrError(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Single)new FlowableElementAtSingle(this, l, null));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFilter(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> first(T t) {
        return this.elementAt(0L, t);
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> firstElement() {
        return this.elementAt(0L);
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> firstOrError() {
        return this.elementAtOrError(0L);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.flatMap(function, false, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        return this.flatMap(function, false, n, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return this.flatMap(function, biFunction, false, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int n) {
        return this.flatMap(function, biFunction, false, n, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl) {
        return this.flatMap(function, biFunction, bl, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n) {
        return this.flatMap(function, biFunction, bl, n, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"bufferSize");
        return this.flatMap(FlowableInternalHelper.flatMapWithCombiner(function, biFunction), bl, n, n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, (String)"onNextMapper is null");
        ObjectHelper.requireNonNull(function2, (String)"onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, (String)"onCompleteSupplier is null");
        return Flowable.merge(new FlowableMapNotification(this, function, function2, callable));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable, int n) {
        ObjectHelper.requireNonNull(function, (String)"onNextMapper is null");
        ObjectHelper.requireNonNull(function2, (String)"onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, (String)"onCompleteSupplier is null");
        return Flowable.merge(new FlowableMapNotification(this, function, function2, callable), n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl) {
        return this.flatMap(function, bl, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl, int n) {
        return this.flatMap(function, bl, n, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean bl, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"bufferSize");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMap(this, function, bl, n, n2));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return FlowableScalarXMap.scalarXMap((Object)object, function);
        return Flowable.empty();
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return this.flatMapCompletable(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Completable)new FlowableFlatMapCompletableCompletable(this, function, bl, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return this.flatMapIterable(function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlattenIterable(this, function, n));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return this.flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, Flowable.bufferSize(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return this.flatMap(FlowableInternalHelper.flatMapIntoIterable(function), biFunction, false, Flowable.bufferSize(), n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.flatMapMaybe(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapMaybe(this, function, bl, n));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.flatMapSingle(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableFlatMapSingle(this, function, bl, n));
    }

    @BackpressureSupport(value=BackpressureKind.NONE)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return this.subscribe(consumer);
    }

    @BackpressureSupport(value=BackpressureKind.NONE)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return this.forEachWhile(predicate, (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.NONE)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return this.forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @BackpressureSupport(value=BackpressureKind.NONE)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> forEachWhileSubscriber, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(forEachWhileSubscriber, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        forEachWhileSubscriber = new ForEachWhileSubscriber(forEachWhileSubscriber, consumer, action);
        this.subscribe((FlowableSubscriber<? super T>)forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return this.groupBy(function, Functions.identity(), false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return this.groupBy(function, function2, false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean bl) {
        return this.groupBy(function, function2, bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableGroupBy(this, function, function2, n, bl, null));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean bl, int n, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull(function3, (String)"evictingMapFactory is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableGroupBy(this, function, function2, n, bl, function3));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean bl) {
        return this.groupBy(function, Functions.identity(), bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        ObjectHelper.requireNonNull(function, (String)"leftEnd is null");
        ObjectHelper.requireNonNull(function2, (String)"rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> hide() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableHide(this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly((Completable)new FlowableIgnoreElementsCompletable(this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> isEmpty() {
        return this.all(Functions.alwaysFalse());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        ObjectHelper.requireNonNull(function, (String)"leftEnd is null");
        ObjectHelper.requireNonNull(function2, (String)"rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> last(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem");
        return RxJavaPlugins.onAssembly((Single)new FlowableLastSingle((Publisher)this, t));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly((Maybe)new FlowableLastMaybe((Publisher)this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly((Single)new FlowableLastSingle((Publisher)this, null));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> flowableOperator) {
        ObjectHelper.requireNonNull(flowableOperator, (String)"lifter is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableLift(this, flowableOperator));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> limit(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Flowable)new FlowableLimit(this, l));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableMap(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableMaterialize(this));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableMergeWithCompletable(this, completableSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableMergeWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableMergeWithSingle(this, singleSource));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return Flowable.merge(this, publisher);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> observeOn(Scheduler scheduler) {
        return this.observeOn(scheduler, false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> observeOn(Scheduler scheduler, boolean bl) {
        return this.observeOn(scheduler, bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> observeOn(Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableObserveOn(this, scheduler, bl, n));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<U> ofType(Class<U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.filter(Functions.isInstanceOf(clazz)).cast(clazz);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer() {
        return this.onBackpressureBuffer(Flowable.bufferSize(), false, true);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(int n) {
        return this.onBackpressureBuffer(n, false, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(int n, Action action) {
        return this.onBackpressureBuffer(n, false, false, action);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(int n, boolean bl) {
        return this.onBackpressureBuffer(n, bl, false);
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(int n, boolean bl, boolean bl2) {
        ObjectHelper.verifyPositive((int)n, (String)"capacity");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureBuffer(this, n, bl2, bl, Functions.EMPTY_ACTION));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(int n, boolean bl, boolean bl2, Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onOverflow is null");
        ObjectHelper.verifyPositive((int)n, (String)"capacity");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureBuffer(this, n, bl2, bl, action));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(long l, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        ObjectHelper.requireNonNull((Object)backpressureOverflowStrategy, (String)"overflowStrategy is null");
        ObjectHelper.verifyPositive((long)l, (String)"capacity");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureBufferStrategy(this, l, action, backpressureOverflowStrategy));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureBuffer(boolean bl) {
        return this.onBackpressureBuffer(Flowable.bufferSize(), bl, true);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureDrop() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureDrop(this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureDrop(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onDrop is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureDrop(this, consumer));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onBackpressureLatest() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureLatest(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        ObjectHelper.requireNonNull(function, (String)"resumeFunction is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnErrorNext(this, function, false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onErrorResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"next is null");
        return this.onErrorResumeNext(Functions.justFunction(publisher));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, (String)"valueSupplier is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnErrorReturn(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return this.onErrorReturn(Functions.justFunction(t));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"next is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableOnErrorNext(this, Functions.justFunction(publisher), true));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableDetach(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ParallelFlowable<T> parallel() {
        return ParallelFlowable.from((Publisher)this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ParallelFlowable<T> parallel(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"parallelism");
        return ParallelFlowable.from((Publisher)this, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ParallelFlowable<T> parallel(int n, int n2) {
        ObjectHelper.verifyPositive((int)n, (String)"parallelism");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return ParallelFlowable.from((Publisher)this, (int)n, (int)n2);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        return this.publish(function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Flowable)new FlowablePublishMulticast(this, function, n, false));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableFlowable<T> publish() {
        return this.publish(Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableFlowable<T> publish(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return FlowablePublish.create((Flowable)this, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> rebatchRequests(int n) {
        return this.observeOn(ImmediateThinScheduler.INSTANCE, true, n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Maybe)new FlowableReduceMaybe(this, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, (String)"seed is null");
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableReduceSeedSingle((Publisher)this, r, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, (String)"seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableReduceWithSingle((Publisher)this, callable, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeat() {
        return this.repeat(Long.MAX_VALUE);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeat(long l) {
        if (l >= 0L) {
            if (l != 0L) return RxJavaPlugins.onAssembly((Flowable)new FlowableRepeat(this, l));
            return Flowable.empty();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull((Object)booleanSupplier, (String)"stop is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRepeatUntil(this, booleanSupplier));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, (String)"handler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRepeatWhen(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this), function);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this, (int)n), function);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int n, long l, TimeUnit timeUnit) {
        return this.replay(function, n, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this, (int)n, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler), function);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int n, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this, (int)n), (Function)FlowableInternalHelper.replayFunction(function, (Scheduler)scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long l, TimeUnit timeUnit) {
        return this.replay(function, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler), function);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.multicastSelector((Callable)FlowableInternalHelper.replayCallable((Flowable)this), (Function)FlowableInternalHelper.replayFunction(function, (Scheduler)scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableFlowable<T> replay() {
        return FlowableReplay.createFrom((Flowable)this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableFlowable<T> replay(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return FlowableReplay.create((Flowable)this, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final ConnectableFlowable<T> replay(int n, long l, TimeUnit timeUnit) {
        return this.replay(n, l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableFlowable<T> replay(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return FlowableReplay.create((Flowable)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler, (int)n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableFlowable<T> replay(int n, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.observeOn(this.replay(n), (Scheduler)scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final ConnectableFlowable<T> replay(long l, TimeUnit timeUnit) {
        return this.replay(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableFlowable<T> replay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.create((Flowable)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableFlowable<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return FlowableReplay.observeOn(this.replay(), (Scheduler)scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retry() {
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retry(long l) {
        return this.retry(l, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retry(long l, Predicate<? super Throwable> object) {
        if (l >= 0L) {
            ObjectHelper.requireNonNull(object, (String)"predicate is null");
            return RxJavaPlugins.onAssembly((Flowable)new FlowableRetryPredicate(this, l, (Predicate)object));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("times >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRetryBiPredicate(this, biPredicate));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retry(Predicate<? super Throwable> predicate) {
        return this.retry(Long.MAX_VALUE, predicate);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull((Object)booleanSupplier, (String)"stop is null");
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.predicateReverseFor((BooleanSupplier)booleanSupplier));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.requireNonNull(function, (String)"handler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableRetryWhen(this, function));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @SchedulerSupport(value="none")
    public final void safeSubscribe(Subscriber<? super T> subscriber) {
        ObjectHelper.requireNonNull(subscriber, (String)"s is null");
        if (subscriber instanceof SafeSubscriber) {
            this.subscribe((FlowableSubscriber<? super T>)((SafeSubscriber)subscriber));
        } else {
            this.subscribe((FlowableSubscriber<? super T>)new SafeSubscriber(subscriber));
        }
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> sample(long l, TimeUnit timeUnit) {
        return this.sample(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> sample(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSampleTimed(this, l, timeUnit, scheduler, false));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> sample(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSampleTimed(this, l, timeUnit, scheduler, bl));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> sample(long l, TimeUnit timeUnit, boolean bl) {
        return this.sample(l, timeUnit, Schedulers.computation(), bl);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> sample(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"sampler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSamplePublisher((Publisher)this, publisher, false));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> sample(Publisher<U> publisher, boolean bl) {
        ObjectHelper.requireNonNull(publisher, (String)"sampler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSamplePublisher((Publisher)this, publisher, bl));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"accumulator is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableScan(this, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, (String)"initialValue is null");
        return this.scanWith(Functions.justCallable(r), biFunction);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, (String)"seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, (String)"accumulator is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableScanSeed(this, callable, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> serialize() {
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSerialized(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> share() {
        return this.publish().refCount();
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> single(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableSingleSingle(this, t));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly((Maybe)new FlowableSingleMaybe(this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly((Single)new FlowableSingleSingle(this, null));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skip(long l) {
        if (l > 0L) return RxJavaPlugins.onAssembly((Flowable)new FlowableSkip(this, l));
        return RxJavaPlugins.onAssembly((Flowable)this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skip(long l, TimeUnit timeUnit) {
        return this.skipUntil(Flowable.timer(l, timeUnit));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> skip(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.skipUntil(Flowable.timer(l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skipLast(int n) {
        if (n >= 0) {
            if (n != 0) return RxJavaPlugins.onAssembly((Flowable)new FlowableSkipLast(this, n));
            return RxJavaPlugins.onAssembly((Flowable)this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skipLast(long l, TimeUnit timeUnit) {
        return this.skipLast(l, timeUnit, Schedulers.computation(), false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.skipLast(l, timeUnit, scheduler, false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        return this.skipLast(l, timeUnit, scheduler, bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSkipLastTimed(this, l, timeUnit, scheduler, n << 1, bl));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skipLast(long l, TimeUnit timeUnit, boolean bl) {
        return this.skipLast(l, timeUnit, Schedulers.computation(), bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> skipUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSkipUntil(this, publisher));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSkipWhile(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sorted() {
        return this.toList().toFlowable().map(Functions.listSorter((Comparator)Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, (String)"sortFunction");
        return this.toList().toFlowable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> startWith(Iterable<? extends T> iterable) {
        return Flowable.concatArray(Flowable.fromIterable(iterable), this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> startWith(T t) {
        ObjectHelper.requireNonNull(t, (String)"value is null");
        return Flowable.concatArray(Flowable.just(t), this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> startWith(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return Flowable.concatArray(publisher, this);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> startWithArray(T ... object) {
        if ((object = Flowable.fromArray(object)) != Flowable.empty()) return Flowable.concatArray(new Publisher[]{object, this});
        return RxJavaPlugins.onAssembly((Flowable)this);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport(value="none")
    public final Disposable subscribe() {
        return this.subscribe(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, (Consumer<Subscription>)FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return this.subscribe(consumer, (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, (Consumer<Subscription>)FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return this.subscribe(consumer, consumer2, Functions.EMPTY_ACTION, (Consumer<Subscription>)FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return this.subscribe(consumer, consumer2, action, (Consumer<Subscription>)FlowableInternalHelper.RequestMax.INSTANCE);
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> lambdaSubscriber, Consumer<? super Throwable> consumer, Action action, Consumer<? super Subscription> consumer2) {
        ObjectHelper.requireNonNull(lambdaSubscriber, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onSubscribe is null");
        lambdaSubscriber = new LambdaSubscriber(lambdaSubscriber, consumer, action, consumer2);
        this.subscribe((FlowableSubscriber<? super T>)lambdaSubscriber);
        return lambdaSubscriber;
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @SchedulerSupport(value="none")
    public final void subscribe(FlowableSubscriber<? super T> subscriber) {
        ObjectHelper.requireNonNull(subscriber, (String)"s is null");
        try {
            subscriber = RxJavaPlugins.onSubscribe((Flowable)this, subscriber);
            ObjectHelper.requireNonNull((Object)subscriber, (String)"The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            this.subscribeActual(subscriber);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(throwable);
            throw nullPointerException;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @SchedulerSupport(value="none")
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            this.subscribe((FlowableSubscriber)subscriber);
        } else {
            ObjectHelper.requireNonNull(subscriber, (String)"s is null");
            this.subscribe((FlowableSubscriber<? super T>)new StrictSubscriber(subscriber));
        }
    }

    protected abstract void subscribeActual(Subscriber<? super T> var1);

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return this.subscribeOn(scheduler, this instanceof FlowableCreate ^ true);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> subscribeOn(Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSubscribeOn(this, scheduler, bl));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E extends Subscriber<? super T>> E subscribeWith(E e) {
        this.subscribe(e);
        return e;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> switchIfEmpty(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchIfEmpty(this, publisher));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.switchMap(function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        return this.switchMap0(function, n, false);
    }

    <R> Flowable<R> switchMap0(Function<? super T, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchMap(this, function, n, bl));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return FlowableScalarXMap.scalarXMap((Object)object, function);
        return Flowable.empty();
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new FlowableSwitchMapCompletable(this, function, false));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new FlowableSwitchMapCompletable(this, function, true));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return this.switchMapDelayError(function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int n) {
        return this.switchMap0(function, n, true);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchMapMaybe(this, function, false));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchMapMaybe(this, function, true));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchMapSingle(this, function, false));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableSwitchMapSingle(this, function, true));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> take(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Flowable)new FlowableTake(this, l));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> take(long l, TimeUnit timeUnit) {
        return this.takeUntil(Flowable.timer(l, timeUnit));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> take(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeUntil(Flowable.timer(l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> takeLast(int n) {
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(n);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (n == 0) {
            return RxJavaPlugins.onAssembly((Flowable)new FlowableIgnoreElements(this));
        }
        if (n != 1) return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeLast(this, n));
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeLastOne(this));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> takeLast(long l, long l2, TimeUnit timeUnit) {
        return this.takeLast(l, l2, timeUnit, Schedulers.computation(), false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> takeLast(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeLast(l, l2, timeUnit, scheduler, false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> takeLast(long l, long l2, TimeUnit object, Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)object, (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeLastTimed(this, l, l2, (TimeUnit)((Object)object), scheduler, n, bl));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("count >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> takeLast(long l, TimeUnit timeUnit) {
        return this.takeLast(l, timeUnit, Schedulers.computation(), false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeLast(l, timeUnit, scheduler, false, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        return this.takeLast(l, timeUnit, scheduler, bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl, int n) {
        return this.takeLast(Long.MAX_VALUE, l, timeUnit, scheduler, bl, n);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> takeLast(long l, TimeUnit timeUnit, boolean bl) {
        return this.takeLast(l, timeUnit, Schedulers.computation(), bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"stopPredicate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeUntilPredicate(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Flowable<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeUntil(this, publisher));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTakeWhile(this, predicate));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestSubscriber<T> test() {
        TestSubscriber testSubscriber = new TestSubscriber();
        this.subscribe((FlowableSubscriber<? super T>)testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestSubscriber<T> test(long l) {
        TestSubscriber testSubscriber = new TestSubscriber(l);
        this.subscribe((FlowableSubscriber<? super T>)testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestSubscriber<T> test(long l, boolean bl) {
        TestSubscriber testSubscriber = new TestSubscriber(l);
        if (bl) {
            testSubscriber.cancel();
        }
        this.subscribe((FlowableSubscriber<? super T>)testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> throttleFirst(long l, TimeUnit timeUnit) {
        return this.throttleFirst(l, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> throttleFirst(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableThrottleFirstTimed(this, l, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> throttleLast(long l, TimeUnit timeUnit) {
        return this.sample(l, timeUnit);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> throttleLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.sample(l, timeUnit, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> throttleLatest(long l, TimeUnit timeUnit) {
        return this.throttleLatest(l, timeUnit, Schedulers.computation(), false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> throttleLatest(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.throttleLatest(l, timeUnit, scheduler, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> throttleLatest(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableThrottleLatest(this, l, timeUnit, scheduler, bl));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> throttleLatest(long l, TimeUnit timeUnit, boolean bl) {
        return this.throttleLatest(l, timeUnit, Schedulers.computation(), bl);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> throttleWithTimeout(long l, TimeUnit timeUnit) {
        return this.debounce(l, timeUnit);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> throttleWithTimeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.debounce(l, timeUnit, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timeInterval() {
        return this.timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timeInterval(Scheduler scheduler) {
        return this.timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return this.timeInterval(timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableTimeInterval(this, timeUnit, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> timeout(long l, TimeUnit timeUnit) {
        return this.timeout0(l, timeUnit, null, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.timeout0(l, timeUnit, null, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return this.timeout0(l, timeUnit, publisher, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<T> timeout(long l, TimeUnit timeUnit, Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return this.timeout0(l, timeUnit, publisher, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function) {
        return this.timeout0(null, function, null);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function, Flowable<? extends T> flowable) {
        ObjectHelper.requireNonNull(flowable, (String)"other is null");
        return this.timeout0(null, function, flowable);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        ObjectHelper.requireNonNull(publisher, (String)"firstTimeoutIndicator is null");
        return this.timeout0(publisher, function, null);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.requireNonNull(publisher, (String)"firstTimeoutSelector is null");
        ObjectHelper.requireNonNull(publisher2, (String)"other is null");
        return this.timeout0(publisher, function, publisher2);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timestamp() {
        return this.timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timestamp(Scheduler scheduler) {
        return this.timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return this.timestamp(timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return this.map(Functions.timestampWith((TimeUnit)timeUnit, (Scheduler)scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R to(Function<? super Flowable<T>, R> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"converter is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Future<T> toFuture() {
        return (Future)this.subscribeWith(new FutureSubscriber());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toList() {
        return RxJavaPlugins.onAssembly((Single)new FlowableToListSingle(this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toList(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"capacityHint");
        return RxJavaPlugins.onAssembly((Single)new FlowableToListSingle(this, Functions.createArrayList((int)n)));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, (String)"collectionSupplier is null");
        return RxJavaPlugins.onAssembly((Single)new FlowableToListSingle(this, callable));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        return this.collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        return this.collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        return this.collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return this.toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return this.toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return this.toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.requireNonNull(callable, (String)"mapSupplier is null");
        ObjectHelper.requireNonNull(function3, (String)"collectionFactory is null");
        return this.collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> toObservable() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromPublisher((Publisher)this));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList() {
        return this.toSortedList(Functions.naturalComparator());
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(int n) {
        return this.toSortedList(Functions.naturalComparator(), n);
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        return this.toList().map(Functions.listSorter(comparator));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int n) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        return this.toList(n).map(Functions.listSorter(comparator));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableUnsubscribeOn(this, scheduler));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Flowable<T>> window(long l) {
        return this.window(l, l, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Flowable<T>> window(long l, long l2) {
        return this.window(l, l2, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<Flowable<T>> window(long l, long l2, int n) {
        ObjectHelper.verifyPositive((long)l2, (String)"skip");
        ObjectHelper.verifyPositive((long)l, (String)"count");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindow(this, l, l2, n));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long l, long l2, TimeUnit timeUnit) {
        return this.window(l, l2, timeUnit, Schedulers.computation(), Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.window(l, l2, timeUnit, scheduler, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.verifyPositive((long)l, (String)"timespan");
        ObjectHelper.verifyPositive((long)l2, (String)"timeskip");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindowTimed(this, l, l2, timeUnit, scheduler, Long.MAX_VALUE, n, false));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit) {
        return this.window(l, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, long l2) {
        return this.window(l, timeUnit, Schedulers.computation(), l2, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, long l2, boolean bl) {
        return this.window(l, timeUnit, Schedulers.computation(), l2, bl);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.window(l, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2) {
        return this.window(l, timeUnit, scheduler, l2, false);
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2, boolean bl) {
        return this.window(l, timeUnit, scheduler, l2, bl, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Flowable<Flowable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2, boolean bl, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.verifyPositive((long)l2, (String)"count");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindowTimed(this, l, l, timeUnit, scheduler, l2, n, bl));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable) {
        return this.window(callable, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable, int n) {
        ObjectHelper.requireNonNull(callable, (String)"boundaryIndicatorSupplier is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindowBoundarySupplier(this, callable, n));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher) {
        return this.window(publisher, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"boundaryIndicator is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindowBoundary(this, publisher, n));
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function) {
        return this.window(publisher, function, Flowable.bufferSize());
    }

    @BackpressureSupport(value=BackpressureKind.ERROR)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function, int n) {
        ObjectHelper.requireNonNull(publisher, (String)"openingIndicator is null");
        ObjectHelper.requireNonNull(function, (String)"closingIndicator is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWindowBoundarySelector(this, publisher, function, n));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, (String)"others is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWithLatestFromMany(this, iterable, function));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        ObjectHelper.requireNonNull(biFunction, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWithLatestFrom(this, biFunction, publisher));
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Function3<? super T, ? super T1, ? super T2, R> function) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new Publisher[]{publisher, publisher2}, function);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new Publisher[]{publisher, publisher2, publisher3}, function);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function) {
        ObjectHelper.requireNonNull(publisher, (String)"source1 is null");
        ObjectHelper.requireNonNull(publisher2, (String)"source2 is null");
        ObjectHelper.requireNonNull(publisher3, (String)"source3 is null");
        ObjectHelper.requireNonNull(publisher4, (String)"source4 is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new Publisher[]{publisher, publisher2, publisher3, publisher4}, function);
    }

    @BackpressureSupport(value=BackpressureKind.PASS_THROUGH)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Flowable<R> withLatestFrom(Publisher<?>[] publisherArray, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(publisherArray, (String)"others is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableWithLatestFromMany(this, publisherArray, function));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, (String)"other is null");
        ObjectHelper.requireNonNull(biFunction, (String)"zipper is null");
        return RxJavaPlugins.onAssembly((Flowable)new FlowableZipIterable(this, iterable, biFunction));
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(publisher, (String)"other is null");
        return Flowable.zip(this, publisher, biFunction);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl) {
        return Flowable.zip(this, publisher, biFunction, bl);
    }

    @BackpressureSupport(value=BackpressureKind.FULL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n) {
        return Flowable.zip(this, publisher, biFunction, bl, n);
    }
}
