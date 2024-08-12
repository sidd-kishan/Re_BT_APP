/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureStrategy
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Emitter
 *  io.reactivex.Flowable
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeSource
 *  io.reactivex.Notification
 *  io.reactivex.Observable$1
 *  io.reactivex.ObservableConverter
 *  io.reactivex.ObservableOnSubscribe
 *  io.reactivex.ObservableOperator
 *  io.reactivex.ObservableSource
 *  io.reactivex.ObservableTransformer
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.SingleSource
 *  io.reactivex.annotations.BackpressureKind
 *  io.reactivex.annotations.BackpressureSupport
 *  io.reactivex.annotations.CheckReturnValue
 *  io.reactivex.annotations.SchedulerSupport
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
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
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.fuseable.ScalarCallable
 *  io.reactivex.internal.observers.BlockingFirstObserver
 *  io.reactivex.internal.observers.BlockingLastObserver
 *  io.reactivex.internal.observers.ForEachWhileObserver
 *  io.reactivex.internal.observers.FutureObserver
 *  io.reactivex.internal.observers.LambdaObserver
 *  io.reactivex.internal.operators.flowable.FlowableFromObservable
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureError
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapSingle
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe
 *  io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle
 *  io.reactivex.internal.operators.observable.BlockingObservableIterable
 *  io.reactivex.internal.operators.observable.BlockingObservableLatest
 *  io.reactivex.internal.operators.observable.BlockingObservableMostRecent
 *  io.reactivex.internal.operators.observable.BlockingObservableNext
 *  io.reactivex.internal.operators.observable.ObservableAllSingle
 *  io.reactivex.internal.operators.observable.ObservableAmb
 *  io.reactivex.internal.operators.observable.ObservableAnySingle
 *  io.reactivex.internal.operators.observable.ObservableBlockingSubscribe
 *  io.reactivex.internal.operators.observable.ObservableBuffer
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundary
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier
 *  io.reactivex.internal.operators.observable.ObservableBufferExactBoundary
 *  io.reactivex.internal.operators.observable.ObservableBufferTimed
 *  io.reactivex.internal.operators.observable.ObservableCache
 *  io.reactivex.internal.operators.observable.ObservableCollectSingle
 *  io.reactivex.internal.operators.observable.ObservableCombineLatest
 *  io.reactivex.internal.operators.observable.ObservableConcatMap
 *  io.reactivex.internal.operators.observable.ObservableConcatMapEager
 *  io.reactivex.internal.operators.observable.ObservableConcatWithCompletable
 *  io.reactivex.internal.operators.observable.ObservableConcatWithMaybe
 *  io.reactivex.internal.operators.observable.ObservableConcatWithSingle
 *  io.reactivex.internal.operators.observable.ObservableCountSingle
 *  io.reactivex.internal.operators.observable.ObservableCreate
 *  io.reactivex.internal.operators.observable.ObservableDebounce
 *  io.reactivex.internal.operators.observable.ObservableDebounceTimed
 *  io.reactivex.internal.operators.observable.ObservableDefer
 *  io.reactivex.internal.operators.observable.ObservableDelay
 *  io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther
 *  io.reactivex.internal.operators.observable.ObservableDematerialize
 *  io.reactivex.internal.operators.observable.ObservableDetach
 *  io.reactivex.internal.operators.observable.ObservableDistinct
 *  io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged
 *  io.reactivex.internal.operators.observable.ObservableDoAfterNext
 *  io.reactivex.internal.operators.observable.ObservableDoFinally
 *  io.reactivex.internal.operators.observable.ObservableDoOnEach
 *  io.reactivex.internal.operators.observable.ObservableDoOnLifecycle
 *  io.reactivex.internal.operators.observable.ObservableElementAtMaybe
 *  io.reactivex.internal.operators.observable.ObservableElementAtSingle
 *  io.reactivex.internal.operators.observable.ObservableEmpty
 *  io.reactivex.internal.operators.observable.ObservableError
 *  io.reactivex.internal.operators.observable.ObservableFilter
 *  io.reactivex.internal.operators.observable.ObservableFlatMap
 *  io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable
 *  io.reactivex.internal.operators.observable.ObservableFlatMapMaybe
 *  io.reactivex.internal.operators.observable.ObservableFlatMapSingle
 *  io.reactivex.internal.operators.observable.ObservableFlattenIterable
 *  io.reactivex.internal.operators.observable.ObservableFromArray
 *  io.reactivex.internal.operators.observable.ObservableFromCallable
 *  io.reactivex.internal.operators.observable.ObservableFromFuture
 *  io.reactivex.internal.operators.observable.ObservableFromIterable
 *  io.reactivex.internal.operators.observable.ObservableFromPublisher
 *  io.reactivex.internal.operators.observable.ObservableFromUnsafeSource
 *  io.reactivex.internal.operators.observable.ObservableGenerate
 *  io.reactivex.internal.operators.observable.ObservableGroupBy
 *  io.reactivex.internal.operators.observable.ObservableGroupJoin
 *  io.reactivex.internal.operators.observable.ObservableHide
 *  io.reactivex.internal.operators.observable.ObservableIgnoreElements
 *  io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper
 *  io.reactivex.internal.operators.observable.ObservableInterval
 *  io.reactivex.internal.operators.observable.ObservableIntervalRange
 *  io.reactivex.internal.operators.observable.ObservableJoin
 *  io.reactivex.internal.operators.observable.ObservableJust
 *  io.reactivex.internal.operators.observable.ObservableLastMaybe
 *  io.reactivex.internal.operators.observable.ObservableLastSingle
 *  io.reactivex.internal.operators.observable.ObservableLift
 *  io.reactivex.internal.operators.observable.ObservableMap
 *  io.reactivex.internal.operators.observable.ObservableMapNotification
 *  io.reactivex.internal.operators.observable.ObservableMaterialize
 *  io.reactivex.internal.operators.observable.ObservableMergeWithCompletable
 *  io.reactivex.internal.operators.observable.ObservableMergeWithMaybe
 *  io.reactivex.internal.operators.observable.ObservableMergeWithSingle
 *  io.reactivex.internal.operators.observable.ObservableNever
 *  io.reactivex.internal.operators.observable.ObservableObserveOn
 *  io.reactivex.internal.operators.observable.ObservableOnErrorNext
 *  io.reactivex.internal.operators.observable.ObservableOnErrorReturn
 *  io.reactivex.internal.operators.observable.ObservablePublish
 *  io.reactivex.internal.operators.observable.ObservablePublishSelector
 *  io.reactivex.internal.operators.observable.ObservableRange
 *  io.reactivex.internal.operators.observable.ObservableRangeLong
 *  io.reactivex.internal.operators.observable.ObservableReduceMaybe
 *  io.reactivex.internal.operators.observable.ObservableReduceSeedSingle
 *  io.reactivex.internal.operators.observable.ObservableReduceWithSingle
 *  io.reactivex.internal.operators.observable.ObservableRepeat
 *  io.reactivex.internal.operators.observable.ObservableRepeatUntil
 *  io.reactivex.internal.operators.observable.ObservableRepeatWhen
 *  io.reactivex.internal.operators.observable.ObservableReplay
 *  io.reactivex.internal.operators.observable.ObservableRetryBiPredicate
 *  io.reactivex.internal.operators.observable.ObservableRetryPredicate
 *  io.reactivex.internal.operators.observable.ObservableRetryWhen
 *  io.reactivex.internal.operators.observable.ObservableSampleTimed
 *  io.reactivex.internal.operators.observable.ObservableSampleWithObservable
 *  io.reactivex.internal.operators.observable.ObservableScalarXMap
 *  io.reactivex.internal.operators.observable.ObservableScan
 *  io.reactivex.internal.operators.observable.ObservableScanSeed
 *  io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle
 *  io.reactivex.internal.operators.observable.ObservableSerialized
 *  io.reactivex.internal.operators.observable.ObservableSingleMaybe
 *  io.reactivex.internal.operators.observable.ObservableSingleSingle
 *  io.reactivex.internal.operators.observable.ObservableSkip
 *  io.reactivex.internal.operators.observable.ObservableSkipLast
 *  io.reactivex.internal.operators.observable.ObservableSkipLastTimed
 *  io.reactivex.internal.operators.observable.ObservableSkipUntil
 *  io.reactivex.internal.operators.observable.ObservableSkipWhile
 *  io.reactivex.internal.operators.observable.ObservableSubscribeOn
 *  io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty
 *  io.reactivex.internal.operators.observable.ObservableSwitchMap
 *  io.reactivex.internal.operators.observable.ObservableTake
 *  io.reactivex.internal.operators.observable.ObservableTakeLast
 *  io.reactivex.internal.operators.observable.ObservableTakeLastOne
 *  io.reactivex.internal.operators.observable.ObservableTakeLastTimed
 *  io.reactivex.internal.operators.observable.ObservableTakeUntil
 *  io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate
 *  io.reactivex.internal.operators.observable.ObservableTakeWhile
 *  io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed
 *  io.reactivex.internal.operators.observable.ObservableThrottleLatest
 *  io.reactivex.internal.operators.observable.ObservableTimeInterval
 *  io.reactivex.internal.operators.observable.ObservableTimeout
 *  io.reactivex.internal.operators.observable.ObservableTimeoutTimed
 *  io.reactivex.internal.operators.observable.ObservableTimer
 *  io.reactivex.internal.operators.observable.ObservableToList
 *  io.reactivex.internal.operators.observable.ObservableToListSingle
 *  io.reactivex.internal.operators.observable.ObservableUnsubscribeOn
 *  io.reactivex.internal.operators.observable.ObservableUsing
 *  io.reactivex.internal.operators.observable.ObservableWindow
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundary
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector
 *  io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFrom
 *  io.reactivex.internal.operators.observable.ObservableWithLatestFromMany
 *  io.reactivex.internal.operators.observable.ObservableZip
 *  io.reactivex.internal.operators.observable.ObservableZipIterable
 *  io.reactivex.internal.util.ArrayListSupplier
 *  io.reactivex.internal.util.ErrorMode
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.HashMapSupplier
 *  io.reactivex.observables.ConnectableObservable
 *  io.reactivex.observables.GroupedObservable
 *  io.reactivex.observers.SafeObserver
 *  io.reactivex.observers.TestObserver
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers
 *  io.reactivex.schedulers.Timed
 *  org.reactivestreams.Publisher
 */
package io.reactivex;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableConverter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
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
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
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

public abstract class Observable<T>
implements ObservableSource<T> {
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableAmb(null, iterable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> ambArray(ObservableSource<? extends T> ... observableSourceArray) {
        ObjectHelper.requireNonNull(observableSourceArray, (String)"sources is null");
        int n = observableSourceArray.length;
        if (n == 0) {
            return Observable.empty();
        }
        if (n != 1) return RxJavaPlugins.onAssembly((Observable)new ObservableAmb(observableSourceArray, null));
        return Observable.wrap(observableSourceArray[0]);
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(observableSource8, (String)"source8 is null");
        ObjectHelper.requireNonNull(observableSource9, (String)"source9 is null");
        return Observable.combineLatest(Functions.toFunction(function9), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(observableSource8, (String)"source8 is null");
        return Observable.combineLatest(Functions.toFunction(function8), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        return Observable.combineLatest(Functions.toFunction(function7), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        return Observable.combineLatest(Functions.toFunction(function6), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        return Observable.combineLatest(Functions.toFunction(function5), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        return Observable.combineLatest(Functions.toFunction(function4), Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        return Observable.combineLatest(Functions.toFunction(function3), Observable.bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.combineLatest(Functions.toFunction(biFunction), Observable.bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int n, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.combineLatest(observableSourceArray, function, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return Observable.combineLatest(iterable, function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableCombineLatest(null, iterable, function, n << 1, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArray, Function<? super Object[], ? extends R> function) {
        return Observable.combineLatest(observableSourceArray, function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArray, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(observableSourceArray, (String)"sources is null");
        if (observableSourceArray.length == 0) {
            return Observable.empty();
        }
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableCombineLatest(observableSourceArray, null, function, n << 1, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int n, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.combineLatestDelayError(observableSourceArray, function, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return Observable.combineLatestDelayError(iterable, function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableCombineLatest(null, iterable, function, n << 1, true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArray, Function<? super Object[], ? extends R> function) {
        return Observable.combineLatestDelayError(observableSourceArray, function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArray, Function<? super Object[], ? extends R> function, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        if (observableSourceArray.length != 0) return RxJavaPlugins.onAssembly((Observable)new ObservableCombineLatest(observableSourceArray, null, function, n << 1, true));
        return Observable.empty();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return Observable.concat(observableSource, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap(observableSource, Functions.identity(), n, ErrorMode.IMMEDIATE));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.concatArray(observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        return Observable.concatArray(observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        return Observable.concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return Observable.fromIterable(iterable).concatMapDelayError(Functions.identity(), Observable.bufferSize(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArray(ObservableSource<? extends T> ... observableSourceArray) {
        if (observableSourceArray.length == 0) {
            return Observable.empty();
        }
        if (observableSourceArray.length != 1) return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap(Observable.fromArray(observableSourceArray), Functions.identity(), Observable.bufferSize(), ErrorMode.BOUNDARY));
        return Observable.wrap(observableSourceArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T> ... observableSourceArray) {
        if (observableSourceArray.length == 0) {
            return Observable.empty();
        }
        if (observableSourceArray.length != 1) return Observable.concatDelayError(Observable.fromArray(observableSourceArray));
        return Observable.wrap(observableSourceArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArrayEager(int n, int n2, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).concatMapEagerDelayError(Functions.identity(), n, n2, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.concatArrayEager(Observable.bufferSize(), Observable.bufferSize(), observableSourceArray);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArrayEagerDelayError(int n, int n2, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).concatMapEagerDelayError(Functions.identity(), n, n2, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatArrayEagerDelayError(ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.concatArrayEagerDelayError(Observable.bufferSize(), Observable.bufferSize(), observableSourceArray);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return Observable.concatDelayError(observableSource, Observable.bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n, boolean bl) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch is null");
        Function function = Functions.identity();
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap(observableSource, function, n, errorMode));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return Observable.concatDelayError(Observable.fromIterable(iterable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return Observable.concatEager(observableSource, Observable.bufferSize(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n, int n2) {
        return Observable.wrap(observableSource).concatMapEager(Functions.identity(), n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return Observable.concatEager(iterable, Observable.bufferSize(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int n, int n2) {
        return Observable.fromIterable(iterable).concatMapEagerDelayError(Functions.identity(), n, n2, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.requireNonNull(observableOnSubscribe, (String)"source is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableCreate(observableOnSubscribe));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.requireNonNull(callable, (String)"supplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDefer(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.requireNonNull(consumer, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.requireNonNull((Object)action2, (String)"onAfterTerminate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDoOnEach((ObservableSource)this, consumer, consumer2, action, action2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> empty() {
        return RxJavaPlugins.onAssembly((Observable)ObservableEmpty.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> error(Throwable throwable) {
        ObjectHelper.requireNonNull((Object)throwable, (String)"exception is null");
        return Observable.error(Functions.justCallable((Object)throwable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.requireNonNull(callable, (String)"errorSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableError(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromArray(T ... TArray) {
        ObjectHelper.requireNonNull(TArray, (String)"items is null");
        if (TArray.length == 0) {
            return Observable.empty();
        }
        if (TArray.length != 1) return RxJavaPlugins.onAssembly((Observable)new ObservableFromArray((Object[])TArray));
        return Observable.just(TArray[0]);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, (String)"supplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromCallable(callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromFuture(future, 0L, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromFuture(future, l, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return Observable.fromFuture(future, l, timeUnit).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return Observable.fromFuture(future).subscribeOn(scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.requireNonNull(iterable, (String)"source is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromIterable(iterable));
    }

    @BackpressureSupport(value=BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.requireNonNull(publisher, (String)"publisher is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromPublisher(publisher));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"generator is null");
        return Observable.generate(Functions.nullSupplier(), ObservableInternalHelper.simpleGenerator(consumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"generator is null");
        return Observable.generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(biConsumer, (String)"generator is null");
        return Observable.generate(callable, ObservableInternalHelper.simpleBiGenerator(biConsumer), consumer);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return Observable.generate(callable, biFunction, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.requireNonNull(callable, (String)"initialState is null");
        ObjectHelper.requireNonNull(biFunction, (String)"generator is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposeState is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableGenerate(callable, biFunction, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Observable<Long> interval(long l, long l2, TimeUnit timeUnit) {
        return Observable.interval(l, l2, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Observable<Long> interval(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableInterval(Math.max(0L, l), Math.max(0L, l2), timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Observable<Long> interval(long l, TimeUnit timeUnit) {
        return Observable.interval(l, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Observable<Long> interval(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return Observable.interval(l, l, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Observable<Long> intervalRange(long l, long l2, long l3, long l4, TimeUnit timeUnit) {
        return Observable.intervalRange(l, l2, l3, l4, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Observable<Long> intervalRange(long l, long l2, long l3, long l4, TimeUnit object, Scheduler scheduler) {
        if (l2 < 0L) {
            object = new StringBuilder();
            ((StringBuilder)object).append("count >= 0 required but it was ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (l2 == 0L) {
            return Observable.empty().delay(l3, (TimeUnit)((Object)object), scheduler);
        }
        l2 = l + (l2 - 1L);
        if (l > 0L) {
            if (l2 < 0L) throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        ObjectHelper.requireNonNull((Object)object, (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableIntervalRange(l, l2, Math.max(0L, l3), Math.max(0L, l4), (TimeUnit)((Object)object), scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableJust(t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        return Observable.fromArray(t, t2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        return Observable.fromArray(t, t2, t3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        return Observable.fromArray(t, t2, t3, t4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        return Observable.fromArray(t, t2, t3, t4, t5);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        return Observable.fromArray(t, t2, t3, t4, t5, t6);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        return Observable.fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        ObjectHelper.requireNonNull(t8, (String)"item8 is null");
        return Observable.fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.requireNonNull(t, (String)"item1 is null");
        ObjectHelper.requireNonNull(t2, (String)"item2 is null");
        ObjectHelper.requireNonNull(t3, (String)"item3 is null");
        ObjectHelper.requireNonNull(t4, (String)"item4 is null");
        ObjectHelper.requireNonNull(t5, (String)"item5 is null");
        ObjectHelper.requireNonNull(t6, (String)"item6 is null");
        ObjectHelper.requireNonNull(t7, (String)"item7 is null");
        ObjectHelper.requireNonNull(t8, (String)"item8 is null");
        ObjectHelper.requireNonNull(t9, (String)"item9 is null");
        return Observable.fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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
        return Observable.fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMap(observableSource, Functions.identity(), false, Integer.MAX_VALUE, Observable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMap(observableSource, Functions.identity(), false, n, Observable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.fromArray(observableSource, observableSource2).flatMap(Functions.identity(), false, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        return Observable.fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), false, 3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        return Observable.fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), false, 4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int n) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity(), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int n, int n2) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity(), false, n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeArray(int n, int n2, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).flatMap(Functions.identity(), false, n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeArray(ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).flatMap(Functions.identity(), observableSourceArray.length);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeArrayDelayError(int n, int n2, ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).flatMap(Functions.identity(), true, n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T> ... observableSourceArray) {
        return Observable.fromArray(observableSourceArray).flatMap(Functions.identity(), true, observableSourceArray.length);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMap(observableSource, Functions.identity(), true, Integer.MAX_VALUE, Observable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMap(observableSource, Functions.identity(), true, n, Observable.bufferSize()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.fromArray(observableSource, observableSource2).flatMap(Functions.identity(), true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        return Observable.fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.identity(), true, 3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        return Observable.fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.identity(), true, 4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity(), true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int n) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity(), true, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int n, int n2) {
        return Observable.fromIterable(iterable).flatMap(Functions.identity(), true, n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> never() {
        return RxJavaPlugins.onAssembly((Observable)ObservableNever.INSTANCE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Observable<Integer> range(int n, int n2) {
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(n2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 == 0) {
            return Observable.empty();
        }
        if (n2 == 1) {
            return Observable.just(n);
        }
        if ((long)n + (long)(n2 - 1) > Integer.MAX_VALUE) throw new IllegalArgumentException("Integer overflow");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRange(n, n2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static Observable<Long> rangeLong(long l, long l2) {
        if (l2 < 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (l2 == 0L) {
            return Observable.empty();
        }
        if (l2 == 1L) {
            return Observable.just(l);
        }
        if (l <= 0L) return RxJavaPlugins.onAssembly((Observable)new ObservableRangeLong(l, l2));
        if (l2 - 1L + l < 0L) throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRangeLong(l, l2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return Observable.sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int n) {
        return Observable.sequenceEqual(observableSource, observableSource2, ObjectHelper.equalsPredicate(), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return Observable.sequenceEqual(observableSource, observableSource2, biPredicate, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(biPredicate, (String)"isEqual is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Single)new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return Observable.switchOnNext(observableSource, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMap(observableSource, Functions.identity(), n, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return Observable.switchOnNextDelayError(observableSource, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMap(observableSource, Functions.identity(), n, true));
    }

    private Observable<T> timeout0(long l, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"timeUnit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTimeoutTimed(this, l, timeUnit, scheduler, observableSource));
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(function, (String)"itemTimeoutIndicator is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public static Observable<Long> timer(long l, TimeUnit timeUnit) {
        return Observable.timer(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public static Observable<Long> timer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTimer(Math.max(l, 0L), timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"onSubscribe is null");
        if (observableSource instanceof Observable) throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFromUnsafeSource(observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return Observable.using(callable, function, consumer, true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean bl) {
        ObjectHelper.requireNonNull(callable, (String)"resourceSupplier is null");
        ObjectHelper.requireNonNull(function, (String)"sourceSupplier is null");
        ObjectHelper.requireNonNull(consumer, (String)"disposer is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableUsing(callable, function, consumer, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"source is null");
        if (!(observableSource instanceof Observable)) return RxJavaPlugins.onAssembly((Observable)new ObservableFromUnsafeSource(observableSource));
        return RxJavaPlugins.onAssembly((Observable)((Observable)observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(observableSource8, (String)"source8 is null");
        ObjectHelper.requireNonNull(observableSource9, (String)"source9 is null");
        return Observable.zipArray(Functions.toFunction(function9), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        ObjectHelper.requireNonNull(observableSource8, (String)"source8 is null");
        return Observable.zipArray(Functions.toFunction(function8), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        ObjectHelper.requireNonNull(observableSource7, (String)"source7 is null");
        return Observable.zipArray(Functions.toFunction(function7), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        ObjectHelper.requireNonNull(observableSource6, (String)"source6 is null");
        return Observable.zipArray(Functions.toFunction(function6), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        ObjectHelper.requireNonNull(observableSource5, (String)"source5 is null");
        return Observable.zipArray(Functions.toFunction(function5), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"source4 is null");
        return Observable.zipArray(Functions.toFunction(function4), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"source3 is null");
        return Observable.zipArray(Functions.toFunction(function3), false, Observable.bufferSize(), observableSource, observableSource2, observableSource3);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.zipArray(Functions.toFunction(biFunction), false, Observable.bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean bl) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.zipArray(Functions.toFunction(biFunction), bl, Observable.bufferSize(), observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean bl, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"source1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"source2 is null");
        return Observable.zipArray(Functions.toFunction(biFunction), bl, n, observableSource, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(observableSource, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableToList(observableSource, 16).flatMap(ObservableInternalHelper.zipIterable(function)));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableZip(null, iterable, function, Observable.bufferSize(), false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean bl, int n, ObservableSource<? extends T> ... observableSourceArray) {
        if (observableSourceArray.length == 0) {
            return Observable.empty();
        }
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableZip(observableSourceArray, null, function, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"zipper is null");
        ObjectHelper.requireNonNull(iterable, (String)"sources is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableZip(null, iterable, function, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableAllSingle((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return Observable.ambArray(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableAnySingle((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R as(ObservableConverter<T, ? extends R> observableConverter) {
        return (R)((ObservableConverter)ObjectHelper.requireNonNull(observableConverter, (String)"converter is null")).apply(this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingFirst() {
        Object object = new BlockingFirstObserver();
        this.subscribe((Observer<? super T>)object);
        object = object.blockingGet();
        if (object == null) throw new NoSuchElementException();
        return (T)object;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingFirst(T object) {
        Object object2 = new BlockingFirstObserver();
        this.subscribe((Observer<? super T>)object2);
        object2 = object2.blockingGet();
        if (object2 == null) return object;
        object = object2;
        return object;
    }

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

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingIterable() {
        return this.blockingIterable(Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingIterable(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return new BlockingObservableIterable((ObservableSource)this, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingLast() {
        Object object = new BlockingLastObserver();
        this.subscribe((Observer<? super T>)object);
        object = object.blockingGet();
        if (object == null) throw new NoSuchElementException();
        return (T)object;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingLast(T object) {
        Object object2 = new BlockingLastObserver();
        this.subscribe((Observer<? super T>)object2);
        object2 = object2.blockingGet();
        if (object2 == null) return object;
        object = object2;
        return object;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest((ObservableSource)this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingObservableMostRecent((ObservableSource)this, t);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext((ObservableSource)this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingSingle() {
        Object object = this.singleElement().blockingGet();
        if (object == null) throw new NoSuchElementException();
        return (T)object;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final T blockingSingle(T t) {
        return (T)this.single(t).blockingGet();
    }

    @SchedulerSupport(value="none")
    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.subscribe((ObservableSource)this);
    }

    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.subscribe((ObservableSource)this, observer);
    }

    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.subscribe((ObservableSource)this, consumer, (Consumer)Functions.ON_ERROR_MISSING, (Action)Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.subscribe((ObservableSource)this, consumer, consumer2, (Action)Functions.EMPTY_ACTION);
    }

    @SchedulerSupport(value="none")
    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.subscribe((ObservableSource)this, consumer, consumer2, (Action)action);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<List<T>> buffer(int n) {
        return this.buffer(n, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<List<T>> buffer(int n, int n2) {
        return this.buffer(n, n2, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int n, int n2, Callable<U> callable) {
        ObjectHelper.verifyPositive((int)n, (String)"count");
        ObjectHelper.verifyPositive((int)n2, (String)"skip");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBuffer((ObservableSource)this, n, n2, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Observable<U> buffer(int n, Callable<U> callable) {
        return this.buffer(n, n, callable);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<List<T>> buffer(long l, long l2, TimeUnit timeUnit) {
        return this.buffer(l, l2, timeUnit, Schedulers.computation(), ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<List<T>> buffer(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.buffer(l, l2, timeUnit, scheduler, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long l, long l2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBufferTimed((ObservableSource)this, l, l2, timeUnit, scheduler, callable, Integer.MAX_VALUE, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<List<T>> buffer(long l, TimeUnit timeUnit) {
        return this.buffer(l, timeUnit, Schedulers.computation(), Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<List<T>> buffer(long l, TimeUnit timeUnit, int n) {
        return this.buffer(l, timeUnit, Schedulers.computation(), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<List<T>> buffer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.buffer(l, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<List<T>> buffer(long l, TimeUnit timeUnit, Scheduler scheduler, int n) {
        return this.buffer(l, timeUnit, scheduler, n, ArrayListSupplier.asCallable(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <U extends Collection<? super T>> Observable<U> buffer(long l, TimeUnit timeUnit, Scheduler scheduler, int n, Callable<U> callable, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        ObjectHelper.verifyPositive((int)n, (String)"count");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBufferTimed((ObservableSource)this, l, l, timeUnit, scheduler, callable, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return this.buffer(observableSource, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"initialCapacity");
        return this.buffer(observableSource, Functions.createArrayList((int)n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return this.buffer(observableSource, function, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, (String)"openingIndicator is null");
        ObjectHelper.requireNonNull(function, (String)"closingIndicator is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBufferBoundary((ObservableSource)this, observableSource, function, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.requireNonNull(observableSource, (String)"boundary is null");
        ObjectHelper.requireNonNull(callable, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBufferExactBoundary((ObservableSource)this, observableSource, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return this.buffer(callable, ArrayListSupplier.asCallable());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.requireNonNull(callable, (String)"boundarySupplier is null");
        ObjectHelper.requireNonNull(callable2, (String)"bufferSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableBufferBoundarySupplier((ObservableSource)this, callable, callable2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> cache() {
        return this.cacheWithInitialCapacity(16);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> cacheWithInitialCapacity(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"initialCapacity");
        return RxJavaPlugins.onAssembly((Observable)new ObservableCache(this, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> cast(Class<U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.map(Functions.castFunction(clazz));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(callable, (String)"initialValueSupplier is null");
        ObjectHelper.requireNonNull(biConsumer, (String)"collector is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableCollectSingle((ObservableSource)this, callable, biConsumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.requireNonNull(u, (String)"initialValue is null");
        return this.collect(Functions.justCallable(u), biConsumer);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return Observable.wrap(((ObservableTransformer)ObjectHelper.requireNonNull(observableTransformer, (String)"composer is null")).apply(this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.concatMap(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap((ObservableSource)this, function, n, ErrorMode.IMMEDIATE));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return ObservableScalarXMap.scalarXMap((Object)object, function);
        return Observable.empty();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return this.concatMapCompletable(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"capacityHint");
        return RxJavaPlugins.onAssembly((Completable)new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        return this.concatMapCompletableDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean bl) {
        return this.concatMapCompletableDelayError(function, bl, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable concatMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Completable)new ObservableConcatMapCompletable(this, function, errorMode, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.concatMapDelayError(function, Observable.bufferSize(), true);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int n, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        if (this instanceof ScalarCallable) {
            Object object = ((ScalarCallable)this).call();
            if (object != null) return ObservableScalarXMap.scalarXMap((Object)object, function);
            return Observable.empty();
        }
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMap((ObservableSource)this, function, n, errorMode));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.concatMapEager(function, Integer.MAX_VALUE, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapEager((ObservableSource)this, function, ErrorMode.IMMEDIATE, n, n2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int n, int n2, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapEager((ObservableSource)this, function, errorMode, n, n2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean bl) {
        return this.concatMapEagerDelayError(function, Integer.MAX_VALUE, Observable.bufferSize(), bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlattenIterable((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return this.concatMap(ObservableInternalHelper.flatMapIntoIterable(function), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.concatMapMaybe(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.concatMapMaybeDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        return this.concatMapMaybeDelayError(function, bl, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapMaybe(this, function, errorMode, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.concatMapSingle(function, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.concatMapSingleDelayError(function, true, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        return this.concatMapSingleDelayError(function, bl, 2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> concatMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"prefetch");
        ErrorMode errorMode = bl ? ErrorMode.END : ErrorMode.BOUNDARY;
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatMapSingle(this, function, errorMode, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return Observable.concat(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableConcatWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> contains(Object object) {
        ObjectHelper.requireNonNull((Object)object, (String)"element is null");
        return this.any(Functions.equalsWith((Object)object));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Long> count() {
        return RxJavaPlugins.onAssembly((Single)new ObservableCountSingle((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> debounce(long l, TimeUnit timeUnit) {
        return this.debounce(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> debounce(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDebounceTimed((ObservableSource)this, l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, (String)"debounceSelector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDebounce((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return this.switchIfEmpty(Observable.just(t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> delay(long l, TimeUnit timeUnit) {
        return this.delay(l, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delay(l, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> delay(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDelay((ObservableSource)this, l, timeUnit, scheduler, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> delay(long l, TimeUnit timeUnit, boolean bl) {
        return this.delay(l, timeUnit, Schedulers.computation(), bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return this.delaySubscription(observableSource).delay(function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.requireNonNull(function, (String)"itemDelay is null");
        return this.flatMap(ObservableInternalHelper.itemDelay(function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> delaySubscription(long l, TimeUnit timeUnit) {
        return this.delaySubscription(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> delaySubscription(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.delaySubscription(Observable.timer(l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDelaySubscriptionOther((ObservableSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    @Deprecated
    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableDematerialize((ObservableSource)this, Functions.identity()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> dematerialize(Function<? super T, Notification<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDematerialize((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> distinct() {
        return this.distinct(Functions.identity(), Functions.createHashSet());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return this.distinct(function, Functions.createHashSet());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(callable, (String)"collectionSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDistinct((ObservableSource)this, function, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> distinctUntilChanged() {
        return this.distinctUntilChanged(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, (String)"comparer is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDistinctUntilChanged((ObservableSource)this, Functions.identity(), biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDistinctUntilChanged((ObservableSource)this, function, ObjectHelper.equalsPredicate()));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onAfterNext is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDoAfterNext((ObservableSource)this, consumer));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, action);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doFinally(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onFinally is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDoFinally((ObservableSource)this, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnComplete(Action action) {
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.emptyConsumer(), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnDispose(Action action) {
        return this.doOnLifecycle((Consumer<Disposable>)Functions.emptyConsumer(), action);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, (String)"observer is null");
        return this.doOnEach(ObservableInternalHelper.observerOnNext(observer), (Consumer<Throwable>)ObservableInternalHelper.observerOnError(observer), ObservableInternalHelper.observerOnComplete(observer), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.requireNonNull(consumer, (String)"onNotification is null");
        return this.doOnEach(Functions.notificationOnNext(consumer), (Consumer<Throwable>)Functions.notificationOnError(consumer), Functions.notificationOnComplete(consumer), Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        return this.doOnEach(Functions.emptyConsumer(), consumer, Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.requireNonNull(consumer, (String)"onSubscribe is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onDispose is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableDoOnLifecycle(this, consumer, action));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        return this.doOnEach(consumer, (Consumer<Throwable>)Functions.emptyConsumer(), Functions.EMPTY_ACTION, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return this.doOnLifecycle(consumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"onTerminate is null");
        return this.doOnEach(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.actionConsumer((Action)action), action, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> elementAt(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Maybe)new ObservableElementAtMaybe((ObservableSource)this, l));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> elementAt(long l, T object) {
        if (l >= 0L) {
            ObjectHelper.requireNonNull(object, (String)"defaultItem is null");
            return RxJavaPlugins.onAssembly((Single)new ObservableElementAtSingle((ObservableSource)this, l, object));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("index >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> elementAtOrError(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Single)new ObservableElementAtSingle((ObservableSource)this, l, null));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFilter((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> first(T t) {
        return this.elementAt(0L, t);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> firstElement() {
        return this.elementAt(0L);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> firstOrError() {
        return this.elementAtOrError(0L);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.flatMap(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int n) {
        return this.flatMap(function, false, n, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return this.flatMap(function, biFunction, false, Observable.bufferSize(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int n) {
        return this.flatMap(function, biFunction, false, n, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl) {
        return this.flatMap(function, biFunction, bl, Observable.bufferSize(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n) {
        return this.flatMap(function, biFunction, bl, n, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"combiner is null");
        return this.flatMap(ObservableInternalHelper.flatMapWithCombiner(function, biFunction), bl, n, n2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.requireNonNull(function, (String)"onNextMapper is null");
        ObjectHelper.requireNonNull(function2, (String)"onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, (String)"onCompleteSupplier is null");
        return Observable.merge(new ObservableMapNotification((ObservableSource)this, function, function2, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int n) {
        ObjectHelper.requireNonNull(function, (String)"onNextMapper is null");
        ObjectHelper.requireNonNull(function2, (String)"onErrorMapper is null");
        ObjectHelper.requireNonNull(callable, (String)"onCompleteSupplier is null");
        return Observable.merge(new ObservableMapNotification((ObservableSource)this, function, function2, callable), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean bl) {
        return this.flatMap(function, bl, Integer.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean bl, int n) {
        return this.flatMap(function, bl, n, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean bl, int n, int n2) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"maxConcurrency");
        ObjectHelper.verifyPositive((int)n2, (String)"bufferSize");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMap((ObservableSource)this, function, bl, n, n2));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return ObservableScalarXMap.scalarXMap((Object)object, function);
        return Observable.empty();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return this.flatMapCompletable(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new ObservableFlatMapCompletableCompletable((ObservableSource)this, function, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlattenIterable((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return this.flatMap(ObservableInternalHelper.flatMapIntoIterable(function), biFunction, false, Observable.bufferSize(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return this.flatMapMaybe(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMapMaybe((ObservableSource)this, function, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return this.flatMapSingle(function, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean bl) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableFlatMapSingle((ObservableSource)this, function, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEach(Consumer<? super T> consumer) {
        return this.subscribe(consumer);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return this.forEachWhile(predicate, (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return this.forEachWhile(predicate, consumer, Functions.EMPTY_ACTION);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable forEachWhile(Predicate<? super T> forEachWhileObserver, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.requireNonNull(forEachWhileObserver, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        forEachWhileObserver = new ForEachWhileObserver(forEachWhileObserver, consumer, action);
        this.subscribe((Observer<? super T>)forEachWhileObserver);
        return forEachWhileObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return this.groupBy(function, Functions.identity(), false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return this.groupBy(function, function2, false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean bl) {
        return this.groupBy(function, function2, bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean bl, int n) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableGroupBy((ObservableSource)this, function, function2, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean bl) {
        return this.groupBy(function, Functions.identity(), bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        ObjectHelper.requireNonNull(function, (String)"leftEnd is null");
        ObjectHelper.requireNonNull(function2, (String)"rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableGroupJoin((ObservableSource)this, observableSource, function, function2, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> hide() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableHide((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable ignoreElements() {
        return RxJavaPlugins.onAssembly((Completable)new ObservableIgnoreElementsCompletable((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<Boolean> isEmpty() {
        return this.all(Functions.alwaysFalse());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        ObjectHelper.requireNonNull(function, (String)"leftEnd is null");
        ObjectHelper.requireNonNull(function2, (String)"rightEnd is null");
        ObjectHelper.requireNonNull(biFunction, (String)"resultSelector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableJoin((ObservableSource)this, observableSource, function, function2, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> last(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableLastSingle((ObservableSource)this, t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> lastElement() {
        return RxJavaPlugins.onAssembly((Maybe)new ObservableLastMaybe((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> lastOrError() {
        return RxJavaPlugins.onAssembly((Single)new ObservableLastSingle((ObservableSource)this, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.requireNonNull(observableOperator, (String)"lifter is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableLift((ObservableSource)this, observableOperator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableMap((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableMaterialize((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.requireNonNull((Object)completableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableMergeWithCompletable(this, completableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableMergeWithMaybe(this, maybeSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return Observable.merge(this, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.requireNonNull(singleSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableMergeWithSingle(this, singleSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> observeOn(Scheduler scheduler) {
        return this.observeOn(scheduler, false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean bl) {
        return this.observeOn(scheduler, bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> observeOn(Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableObserveOn((ObservableSource)this, scheduler, bl, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<U> ofType(Class<U> clazz) {
        ObjectHelper.requireNonNull(clazz, (String)"clazz is null");
        return this.filter(Functions.isInstanceOf(clazz)).cast(clazz);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"next is null");
        return this.onErrorResumeNext(Functions.justFunction(observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, (String)"resumeFunction is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableOnErrorNext((ObservableSource)this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.requireNonNull(function, (String)"valueSupplier is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableOnErrorReturn((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onErrorReturnItem(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return this.onErrorReturn(Functions.justFunction(t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"next is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableOnErrorNext((ObservableSource)this, Functions.justFunction(observableSource), true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableDetach((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservablePublishSelector((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableObservable<T> publish() {
        return ObservablePublish.create((ObservableSource)this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Maybe)new ObservableReduceMaybe((ObservableSource)this, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, (String)"seed is null");
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableReduceSeedSingle((ObservableSource)this, r, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, (String)"seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, (String)"reducer is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableReduceWithSingle((ObservableSource)this, callable, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> repeat() {
        return this.repeat(Long.MAX_VALUE);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> repeat(long l) {
        if (l >= 0L) {
            if (l != 0L) return RxJavaPlugins.onAssembly((Observable)new ObservableRepeat(this, l));
            return Observable.empty();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull((Object)booleanSupplier, (String)"stop is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRepeatUntil(this, booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, (String)"handler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRepeatWhen((ObservableSource)this, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this), function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this, (int)n), function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int n, long l, TimeUnit timeUnit) {
        return this.replay(function, n, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this, (int)n, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler), function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int n, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this, (int)n), (Function)ObservableInternalHelper.replayFunction(function, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long l, TimeUnit timeUnit) {
        return this.replay(function, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler), function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.requireNonNull(function, (String)"selector is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.multicastSelector((Callable)ObservableInternalHelper.replayCallable((Observable)this), (Function)ObservableInternalHelper.replayFunction(function, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableObservable<T> replay() {
        return ObservableReplay.createFrom((ObservableSource)this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final ConnectableObservable<T> replay(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return ObservableReplay.create((ObservableSource)this, (int)n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final ConnectableObservable<T> replay(int n, long l, TimeUnit timeUnit) {
        return this.replay(n, l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableObservable<T> replay(int n, long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.create((ObservableSource)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler, (int)n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableObservable<T> replay(int n, Scheduler scheduler) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return ObservableReplay.observeOn(this.replay(n), (Scheduler)scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final ConnectableObservable<T> replay(long l, TimeUnit timeUnit) {
        return this.replay(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableObservable<T> replay(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.create((ObservableSource)this, (long)l, (TimeUnit)timeUnit, (Scheduler)scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return ObservableReplay.observeOn(this.replay(), (Scheduler)scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retry() {
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retry(long l) {
        return this.retry(l, (Predicate<Throwable>)Functions.alwaysTrue());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retry(long l, Predicate<? super Throwable> object) {
        if (l >= 0L) {
            ObjectHelper.requireNonNull(object, (String)"predicate is null");
            return RxJavaPlugins.onAssembly((Observable)new ObservableRetryPredicate(this, l, (Predicate)object));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("times >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.requireNonNull(biPredicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRetryBiPredicate(this, biPredicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return this.retry(Long.MAX_VALUE, predicate);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.requireNonNull((Object)booleanSupplier, (String)"stop is null");
        return this.retry(Long.MAX_VALUE, (Predicate<Throwable>)Functions.predicateReverseFor((BooleanSupplier)booleanSupplier));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.requireNonNull(function, (String)"handler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableRetryWhen((ObservableSource)this, function));
    }

    @SchedulerSupport(value="none")
    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.requireNonNull(observer, (String)"observer is null");
        if (observer instanceof SafeObserver) {
            this.subscribe(observer);
        } else {
            this.subscribe((Observer<? super T>)new SafeObserver(observer));
        }
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> sample(long l, TimeUnit timeUnit) {
        return this.sample(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> sample(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSampleTimed((ObservableSource)this, l, timeUnit, scheduler, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> sample(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSampleTimed((ObservableSource)this, l, timeUnit, scheduler, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> sample(long l, TimeUnit timeUnit, boolean bl) {
        return this.sample(l, timeUnit, Schedulers.computation(), bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"sampler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSampleWithObservable((ObservableSource)this, observableSource, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean bl) {
        ObjectHelper.requireNonNull(observableSource, (String)"sampler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSampleWithObservable((ObservableSource)this, observableSource, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.requireNonNull(biFunction, (String)"accumulator is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableScan((ObservableSource)this, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(r, (String)"initialValue is null");
        return this.scanWith(Functions.justCallable(r), biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.requireNonNull(callable, (String)"seedSupplier is null");
        ObjectHelper.requireNonNull(biFunction, (String)"accumulator is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableScanSeed((ObservableSource)this, callable, biFunction));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> serialize() {
        return RxJavaPlugins.onAssembly((Observable)new ObservableSerialized(this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> share() {
        return this.publish().refCount();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> single(T t) {
        ObjectHelper.requireNonNull(t, (String)"defaultItem is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableSingleSingle((ObservableSource)this, t));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Maybe<T> singleElement() {
        return RxJavaPlugins.onAssembly((Maybe)new ObservableSingleMaybe((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<T> singleOrError() {
        return RxJavaPlugins.onAssembly((Single)new ObservableSingleSingle((ObservableSource)this, null));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> skip(long l) {
        if (l > 0L) return RxJavaPlugins.onAssembly((Observable)new ObservableSkip((ObservableSource)this, l));
        return RxJavaPlugins.onAssembly((Observable)this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> skip(long l, TimeUnit timeUnit) {
        return this.skipUntil(Observable.timer(l, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> skip(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.skipUntil(Observable.timer(l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> skipLast(int n) {
        if (n >= 0) {
            if (n != 0) return RxJavaPlugins.onAssembly((Observable)new ObservableSkipLast((ObservableSource)this, n));
            return RxJavaPlugins.onAssembly((Observable)this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:trampoline")
    public final Observable<T> skipLast(long l, TimeUnit timeUnit) {
        return this.skipLast(l, timeUnit, Schedulers.trampoline(), false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.skipLast(l, timeUnit, scheduler, false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        return this.skipLast(l, timeUnit, scheduler, bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> skipLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSkipLastTimed((ObservableSource)this, l, timeUnit, scheduler, n << 1, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:trampoline")
    public final Observable<T> skipLast(long l, TimeUnit timeUnit, boolean bl) {
        return this.skipLast(l, timeUnit, Schedulers.trampoline(), bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSkipUntil((ObservableSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSkipWhile((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> sorted() {
        return this.toList().toObservable().map(Functions.listSorter((Comparator)Functions.naturalComparator())).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, (String)"sortFunction is null");
        return this.toList().toObservable().map(Functions.listSorter(comparator)).flatMapIterable(Functions.identity());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return Observable.concatArray(observableSource, this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return Observable.concatArray(Observable.fromIterable(iterable), this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> startWith(T t) {
        ObjectHelper.requireNonNull(t, (String)"item is null");
        return Observable.concatArray(Observable.just(t), this);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> startWithArray(T ... object) {
        if ((object = Observable.fromArray(object)) != Observable.empty()) return Observable.concatArray(new ObservableSource[]{object, this});
        return RxJavaPlugins.onAssembly((Observable)this);
    }

    @SchedulerSupport(value="none")
    public final Disposable subscribe() {
        return this.subscribe(Functions.emptyConsumer(), (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer) {
        return this.subscribe(consumer, (Consumer<Throwable>)Functions.ON_ERROR_MISSING, Functions.EMPTY_ACTION, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return this.subscribe(consumer, consumer2, Functions.EMPTY_ACTION, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return this.subscribe(consumer, consumer2, action, (Consumer<Disposable>)Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Disposable subscribe(Consumer<? super T> lambdaObserver, Consumer<? super Throwable> consumer, Action action, Consumer<? super Disposable> consumer2) {
        ObjectHelper.requireNonNull(lambdaObserver, (String)"onNext is null");
        ObjectHelper.requireNonNull(consumer, (String)"onError is null");
        ObjectHelper.requireNonNull((Object)action, (String)"onComplete is null");
        ObjectHelper.requireNonNull(consumer2, (String)"onSubscribe is null");
        lambdaObserver = new LambdaObserver(lambdaObserver, consumer, action, consumer2);
        this.subscribe((Observer<? super T>)lambdaObserver);
        return lambdaObserver;
    }

    @SchedulerSupport(value="none")
    public final void subscribe(Observer<? super T> object) {
        ObjectHelper.requireNonNull(object, (String)"observer is null");
        try {
            object = RxJavaPlugins.onSubscribe((Observable)this, object);
            ObjectHelper.requireNonNull((Object)object, (String)"The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            this.subscribeActual((Observer<? super T>)object);
            return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
            object = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            ((Throwable)object).initCause(throwable);
            throw object;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    protected abstract void subscribeActual(Observer<? super T> var1);

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSubscribeOn((ObservableSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        this.subscribe(e);
        return e;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchIfEmpty((ObservableSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.switchMap(function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMap((ObservableSource)this, function, n, false));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return ObservableScalarXMap.scalarXMap((Object)object, function);
        return Observable.empty();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable switchMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new ObservableSwitchMapCompletable(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Completable switchMapCompletableDelayError(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Completable)new ObservableSwitchMapCompletable(this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return this.switchMapDelayError(function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int n) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (!(this instanceof ScalarCallable)) return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMap((ObservableSource)this, function, n, true));
        Object object = ((ScalarCallable)this).call();
        if (object != null) return ObservableScalarXMap.scalarXMap((Object)object, function);
        return Observable.empty();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMapMaybe(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapMaybeDelayError(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMapMaybe(this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMapSingle(this, function, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, (String)"mapper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableSwitchMapSingle(this, function, true));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> take(long l) {
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Observable)new ObservableTake((ObservableSource)this, l));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> take(long l, TimeUnit timeUnit) {
        return this.takeUntil(Observable.timer(l, timeUnit));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> take(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeUntil(Observable.timer(l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> takeLast(int n) {
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("count >= 0 required but it was ");
            stringBuilder.append(n);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (n == 0) {
            return RxJavaPlugins.onAssembly((Observable)new ObservableIgnoreElements((ObservableSource)this));
        }
        if (n != 1) return RxJavaPlugins.onAssembly((Observable)new ObservableTakeLast((ObservableSource)this, n));
        return RxJavaPlugins.onAssembly((Observable)new ObservableTakeLastOne((ObservableSource)this));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:trampoline")
    public final Observable<T> takeLast(long l, long l2, TimeUnit timeUnit) {
        return this.takeLast(l, l2, timeUnit, Schedulers.trampoline(), false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> takeLast(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeLast(l, l2, timeUnit, scheduler, false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> takeLast(long l, long l2, TimeUnit object, Scheduler scheduler, boolean bl, int n) {
        ObjectHelper.requireNonNull((Object)object, (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        if (l >= 0L) {
            return RxJavaPlugins.onAssembly((Observable)new ObservableTakeLastTimed((ObservableSource)this, l, l2, (TimeUnit)((Object)object), scheduler, n, bl));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("count >= 0 required but it was ");
        ((StringBuilder)object).append(l);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:trampoline")
    public final Observable<T> takeLast(long l, TimeUnit timeUnit) {
        return this.takeLast(l, timeUnit, Schedulers.trampoline(), false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.takeLast(l, timeUnit, scheduler, false, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        return this.takeLast(l, timeUnit, scheduler, bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> takeLast(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl, int n) {
        return this.takeLast(Long.MAX_VALUE, l, timeUnit, scheduler, bl, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:trampoline")
    public final Observable<T> takeLast(long l, TimeUnit timeUnit, boolean bl) {
        return this.takeLast(l, timeUnit, Schedulers.trampoline(), bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTakeUntil((ObservableSource)this, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"stopPredicate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTakeUntilPredicate((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, (String)"predicate is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTakeWhile((ObservableSource)this, predicate));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test() {
        TestObserver testObserver = new TestObserver();
        this.subscribe((Observer<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final TestObserver<T> test(boolean bl) {
        TestObserver testObserver = new TestObserver();
        if (bl) {
            testObserver.dispose();
        }
        this.subscribe((Observer<? super T>)testObserver);
        return testObserver;
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> throttleFirst(long l, TimeUnit timeUnit) {
        return this.throttleFirst(l, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> throttleFirst(long l, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableThrottleFirstTimed((ObservableSource)this, l, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> throttleLast(long l, TimeUnit timeUnit) {
        return this.sample(l, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> throttleLast(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.sample(l, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> throttleLatest(long l, TimeUnit timeUnit) {
        return this.throttleLatest(l, timeUnit, Schedulers.computation(), false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> throttleLatest(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.throttleLatest(l, timeUnit, scheduler, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> throttleLatest(long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableThrottleLatest(this, l, timeUnit, scheduler, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> throttleLatest(long l, TimeUnit timeUnit, boolean bl) {
        return this.throttleLatest(l, timeUnit, Schedulers.computation(), bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> throttleWithTimeout(long l, TimeUnit timeUnit) {
        return this.debounce(l, timeUnit);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> throttleWithTimeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.debounce(l, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timeInterval() {
        return this.timeInterval(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return this.timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return this.timeInterval(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableTimeInterval((ObservableSource)this, timeUnit, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> timeout(long l, TimeUnit timeUnit) {
        return this.timeout0(l, timeUnit, null, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<T> timeout(long l, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return this.timeout0(l, timeUnit, observableSource, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.timeout0(l, timeUnit, null, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> timeout(long l, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return this.timeout0(l, timeUnit, observableSource, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.requireNonNull(observableSource, (String)"firstTimeoutIndicator is null");
        return this.timeout0(observableSource, function, null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.requireNonNull(observableSource, (String)"firstTimeoutIndicator is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"other is null");
        return this.timeout0(observableSource, function, observableSource2);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return this.timeout0(null, function, null);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return this.timeout0(null, function, observableSource);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timestamp() {
        return this.timestamp(TimeUnit.MILLISECONDS, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return this.timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return this.timestamp(timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return this.map(Functions.timestampWith((TimeUnit)timeUnit, (Scheduler)scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> R to(Function<? super Observable<T>, R> object) {
        try {
            object = ((Function)ObjectHelper.requireNonNull(object, (String)"converter is null")).apply((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
        return (R)object;
    }

    @BackpressureSupport(value=BackpressureKind.SPECIAL)
    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int n = 1.$SwitchMap$io$reactivex$BackpressureStrategy[backpressureStrategy.ordinal()];
        if (n == 1) return flowableFromObservable.onBackpressureDrop();
        if (n == 2) return flowableFromObservable.onBackpressureLatest();
        if (n == 3) return flowableFromObservable;
        if (n == 4) return RxJavaPlugins.onAssembly((Flowable)new FlowableOnBackpressureError((Flowable)flowableFromObservable));
        return flowableFromObservable.onBackpressureBuffer();
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Future<T> toFuture() {
        return (Future)this.subscribeWith(new FutureObserver());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toList() {
        return this.toList(16);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toList(int n) {
        ObjectHelper.verifyPositive((int)n, (String)"capacityHint");
        return RxJavaPlugins.onAssembly((Single)new ObservableToListSingle((ObservableSource)this, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.requireNonNull(callable, (String)"collectionSupplier is null");
        return RxJavaPlugins.onAssembly((Single)new ObservableToListSingle((ObservableSource)this, callable));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        return this.collect(HashMapSupplier.asCallable(), Functions.toMapKeySelector(function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        return this.collect(HashMapSupplier.asCallable(), Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.requireNonNull(callable, (String)"mapSupplier is null");
        return this.collect(callable, Functions.toMapKeyValueSelector(function, function2));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return this.toMultimap(function, Functions.identity(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return this.toMultimap(function, function2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return this.toMultimap(function, function2, callable, ArrayListSupplier.asFunction());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.requireNonNull(function, (String)"keySelector is null");
        ObjectHelper.requireNonNull(function2, (String)"valueSelector is null");
        ObjectHelper.requireNonNull(callable, (String)"mapSupplier is null");
        ObjectHelper.requireNonNull(function3, (String)"collectionFactory is null");
        return this.collect(callable, Functions.toMultimapKeyValueSelector(function, function2, function3));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList() {
        return this.toSortedList(Functions.naturalOrder());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(int n) {
        return this.toSortedList(Functions.naturalOrder(), n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        return this.toList().map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int n) {
        ObjectHelper.requireNonNull(comparator, (String)"comparator is null");
        return this.toList(n).map(Functions.listSorter(comparator));
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableUnsubscribeOn((ObservableSource)this, scheduler));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Observable<T>> window(long l) {
        return this.window(l, l, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Observable<T>> window(long l, long l2) {
        return this.window(l, l2, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final Observable<Observable<T>> window(long l, long l2, int n) {
        ObjectHelper.verifyPositive((long)l, (String)"count");
        ObjectHelper.verifyPositive((long)l2, (String)"skip");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindow((ObservableSource)this, l, l2, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<Observable<T>> window(long l, long l2, TimeUnit timeUnit) {
        return this.window(l, l2, timeUnit, Schedulers.computation(), Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        return this.window(l, l2, timeUnit, scheduler, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n) {
        ObjectHelper.verifyPositive((long)l, (String)"timespan");
        ObjectHelper.verifyPositive((long)l2, (String)"timeskip");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindowTimed((ObservableSource)this, l, l2, timeUnit, scheduler, Long.MAX_VALUE, n, false));
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit) {
        return this.window(l, timeUnit, Schedulers.computation(), Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, long l2) {
        return this.window(l, timeUnit, Schedulers.computation(), l2, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="io.reactivex:computation")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, long l2, boolean bl) {
        return this.window(l, timeUnit, Schedulers.computation(), l2, bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler) {
        return this.window(l, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2) {
        return this.window(l, timeUnit, scheduler, l2, false);
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2, boolean bl) {
        return this.window(l, timeUnit, scheduler, l2, bl, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="custom")
    public final Observable<Observable<T>> window(long l, TimeUnit timeUnit, Scheduler scheduler, long l2, boolean bl, int n) {
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        ObjectHelper.requireNonNull((Object)scheduler, (String)"scheduler is null");
        ObjectHelper.requireNonNull((Object)((Object)timeUnit), (String)"unit is null");
        ObjectHelper.verifyPositive((long)l2, (String)"count");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindowTimed((ObservableSource)this, l, l, timeUnit, scheduler, l2, n, bl));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return this.window(observableSource, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"boundary is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindowBoundary((ObservableSource)this, observableSource, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return this.window(observableSource, function, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int n) {
        ObjectHelper.requireNonNull(observableSource, (String)"openingIndicator is null");
        ObjectHelper.requireNonNull(function, (String)"closingIndicator is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindowBoundarySelector((ObservableSource)this, observableSource, function, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return this.window(callable, Observable.bufferSize());
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int n) {
        ObjectHelper.requireNonNull(callable, (String)"boundary is null");
        ObjectHelper.verifyPositive((int)n, (String)"bufferSize");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWindowBoundarySupplier((ObservableSource)this, callable, n));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function) {
        ObjectHelper.requireNonNull(observableSource, (String)"o1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"o2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"o3 is null");
        ObjectHelper.requireNonNull(observableSource4, (String)"o4 is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function) {
        ObjectHelper.requireNonNull(observableSource, (String)"o1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"o2 is null");
        ObjectHelper.requireNonNull(observableSource3, (String)"o3 is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function) {
        ObjectHelper.requireNonNull(observableSource, (String)"o1 is null");
        ObjectHelper.requireNonNull(observableSource2, (String)"o2 is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        function = Functions.toFunction(function);
        return this.withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, function);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        ObjectHelper.requireNonNull(biFunction, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWithLatestFrom((ObservableSource)this, biFunction, observableSource));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(iterable, (String)"others is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWithLatestFromMany((ObservableSource)this, iterable, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArray, Function<? super Object[], R> function) {
        ObjectHelper.requireNonNull(observableSourceArray, (String)"others is null");
        ObjectHelper.requireNonNull(function, (String)"combiner is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableWithLatestFromMany((ObservableSource)this, observableSourceArray, function));
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(observableSource, (String)"other is null");
        return Observable.zip(this, observableSource, biFunction);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl) {
        return Observable.zip(this, observableSource, biFunction, bl);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean bl, int n) {
        return Observable.zip(this, observableSource, biFunction, bl, n);
    }

    @CheckReturnValue
    @SchedulerSupport(value="none")
    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(iterable, (String)"other is null");
        ObjectHelper.requireNonNull(biFunction, (String)"zipper is null");
        return RxJavaPlugins.onAssembly((Observable)new ObservableZipIterable(this, iterable, biFunction));
    }
}
