/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$HasAccountOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$HasGoogleSignInAccountOptions
 *  com.google.android.gms.common.api.Api$Client
 *  com.google.android.gms.common.api.GoogleApi$Settings
 *  com.google.android.gms.common.api.GoogleApi$Settings$Builder
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.HasApiKey
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.ListenerHolder
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.ListenerHolders
 *  com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.RegistrationMethods
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.common.api.internal.UnregisterListenerMethod
 *  com.google.android.gms.common.api.internal.zaab
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zabp
 *  com.google.android.gms.common.api.internal.zaco
 *  com.google.android.gms.common.api.zac
 *  com.google.android.gms.common.internal.BaseGmsClient
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.ClientSettings$Builder
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zaco;
import com.google.android.gms.common.api.zac;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class GoogleApi<O extends Api.ApiOptions>
implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api<O> zad;
    private final O zae;
    private final ApiKey<O> zaf;
    private final Looper zag;
    private final int zah;
    @NotOnlyInitialized
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    public GoogleApi(Activity activity, Api<O> googleApiManager, O o, Settings settings) {
        Preconditions.checkNotNull((Object)activity, (Object)"Null activity is not permitted.");
        Preconditions.checkNotNull(googleApiManager, (Object)"Api must not be null.");
        Preconditions.checkNotNull((Object)settings, (Object)"Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = activity.getApplicationContext();
        this.zac = GoogleApi.zaf(activity);
        this.zad = googleApiManager;
        this.zae = o;
        this.zag = settings.zab;
        this.zaf = ApiKey.zaa(this.zad, this.zae, (String)this.zac);
        this.zai = new zabp(this);
        this.zaa = googleApiManager = GoogleApiManager.zaa((Context)this.zab);
        this.zah = googleApiManager.zac();
        this.zaj = settings.zaa;
        if (!(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaab.zaa((Activity)activity, (GoogleApiManager)this.zaa, this.zaf);
        }
        this.zaa.zad(this);
    }

    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        builder.setLooper(activity.getMainLooper());
        this(activity, api, o, builder.build());
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setLooper(looper);
        builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }

    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        Preconditions.checkNotNull((Object)context, (Object)"Null context is not permitted.");
        Preconditions.checkNotNull(api, (Object)"Api must not be null.");
        Preconditions.checkNotNull((Object)settings, (Object)"Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zab = context.getApplicationContext();
        this.zac = GoogleApi.zaf(context);
        this.zad = api;
        this.zae = o;
        this.zag = settings.zab;
        this.zaf = ApiKey.zaa(this.zad, this.zae, (String)this.zac);
        this.zai = new zabp(this);
        context = GoogleApiManager.zaa((Context)this.zab);
        this.zaa = context;
        this.zah = context.zac();
        this.zaj = settings.zaa;
        this.zaa.zad(this);
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.setMapper(statusExceptionMapper);
        this(context, api, o, builder.build());
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zad(int n, T t) {
        t.zak();
        this.zaa.zak(this, n, t);
        return t;
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zae(int n, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.zal(this, n, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    private static String zaf(Object object) {
        if (!PlatformVersion.isAtLeastR()) return null;
        try {
            object = (String)Context.class.getMethod("getAttributionTag", new Class[0]).invoke(object, new Object[0]);
            return object;
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
        }
        return null;
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    protected ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Object object = this.zae;
        object = object instanceof Api.ApiOptions.HasGoogleSignInAccountOptions && (object = ((Api.ApiOptions.HasGoogleSignInAccountOptions)object).getGoogleSignInAccount()) != null ? object.getAccount() : ((object = this.zae) instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions)object).getAccount() : null);
        builder.zaa(object);
        object = this.zae;
        object = object instanceof Api.ApiOptions.HasGoogleSignInAccountOptions ? ((object = ((Api.ApiOptions.HasGoogleSignInAccountOptions)object).getGoogleSignInAccount()) == null ? Collections.emptySet() : object.getRequestedScopes()) : Collections.emptySet();
        builder.zab(object);
        builder.zac(this.zab.getClass().getName());
        builder.setRealClientPackageName(this.zab.getPackageName());
        return builder;
    }

    protected Task<Boolean> disconnectService() {
        return this.zaa.zaj(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        this.zad(2, t);
        return t;
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return this.zae(2, taskApiCall);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        this.zad(0, t);
        return t;
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return this.zae(0, taskApiCall);
    }

    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull((Object)t.getListenerKey(), (Object)"Listener has already been released.");
        Preconditions.checkNotNull((Object)u.getListenerKey(), (Object)"Listener has already been released.");
        Preconditions.checkArgument((boolean)Objects.equal((Object)t.getListenerKey(), (Object)u.getListenerKey()), (Object)"Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.zan(this, t, u, com.google.android.gms.common.api.zac.zaa);
    }

    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.checkNotNull(registrationMethods);
        Preconditions.checkNotNull((Object)registrationMethods.register.getListenerKey(), (Object)"Listener has already been released.");
        Preconditions.checkNotNull((Object)registrationMethods.zaa.getListenerKey(), (Object)"Listener has already been released.");
        return this.zaa.zan(this, registrationMethods.register, registrationMethods.zaa, registrationMethods.zab);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return this.doUnregisterEventListener(listenerKey, 0);
    }

    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int n) {
        Preconditions.checkNotNull(listenerKey, (Object)"Listener key cannot be null.");
        return this.zaa.zao(this, listenerKey, n);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        this.zad(1, t);
        return t;
    }

    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return this.zae(1, taskApiCall);
    }

    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    protected String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    protected String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> ListenerHolder<L> registerListener(L l, String string) {
        return ListenerHolders.createListenerHolder(l, (Looper)this.zag, (String)string);
    }

    public final Api.Client zaa(Looper object, zabl<O> client) {
        ClientSettings clientSettings = this.createClientSettingsBuilder().build();
        client = ((Api.AbstractClientBuilder)Preconditions.checkNotNull((Object)this.zad.zab())).buildClient(this.zab, object, clientSettings, this.zae, client, client);
        object = this.getContextAttributionTag();
        if (object != null && client instanceof BaseGmsClient) {
            ((BaseGmsClient)client).setAttributionTag((String)object);
        }
        if (object == null) return client;
        if (!(client instanceof NonGmsServiceBrokerClient)) return client;
        ((NonGmsServiceBrokerClient)client).zaa((String)object);
        return client;
    }

    public final int zab() {
        return this.zah;
    }

    public final zaco zac(Context context, Handler handler) {
        return new zaco(context, handler, this.createClientSettingsBuilder().build());
    }
}
