/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Fragment
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IFragmentWrapper
 *  com.google.android.gms.dynamic.IFragmentWrapper$Stub
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 */
package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class FragmentWrapper
extends IFragmentWrapper.Stub {
    private Fragment zza;

    private FragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment == null) return null;
        return new FragmentWrapper(fragment);
    }

    public final void zzA(IObjectWrapper iObjectWrapper) {
        View view = (View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        iObjectWrapper = this.zza;
        Preconditions.checkNotNull((Object)view);
        iObjectWrapper.unregisterForContextMenu(view);
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap((Object)this.zza.getActivity());
    }

    public final Bundle zzc() {
        return this.zza.getArguments();
    }

    public final int zzd() {
        return this.zza.getId();
    }

    public final IFragmentWrapper zze() {
        return FragmentWrapper.wrap(this.zza.getParentFragment());
    }

    public final IObjectWrapper zzf() {
        return ObjectWrapper.wrap((Object)this.zza.getResources());
    }

    public final boolean zzg() {
        return this.zza.getRetainInstance();
    }

    public final String zzh() {
        return this.zza.getTag();
    }

    public final IFragmentWrapper zzi() {
        return FragmentWrapper.wrap(this.zza.getTargetFragment());
    }

    public final int zzj() {
        return this.zza.getTargetRequestCode();
    }

    public final boolean zzk() {
        return this.zza.getUserVisibleHint();
    }

    public final IObjectWrapper zzl() {
        return ObjectWrapper.wrap((Object)this.zza.getView());
    }

    public final boolean zzm() {
        return this.zza.isAdded();
    }

    public final boolean zzn() {
        return this.zza.isDetached();
    }

    public final boolean zzo() {
        return this.zza.isHidden();
    }

    public final boolean zzp() {
        return this.zza.isInLayout();
    }

    public final boolean zzq() {
        return this.zza.isRemoving();
    }

    public final boolean zzr() {
        return this.zza.isResumed();
    }

    public final boolean zzs() {
        return this.zza.isVisible();
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        iObjectWrapper = (View)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        Fragment fragment = this.zza;
        Preconditions.checkNotNull((Object)iObjectWrapper);
        fragment.registerForContextMenu((View)iObjectWrapper);
    }

    public final void zzu(boolean bl) {
        this.zza.setHasOptionsMenu(bl);
    }

    public final void zzv(boolean bl) {
        this.zza.setMenuVisibility(bl);
    }

    public final void zzw(boolean bl) {
        this.zza.setRetainInstance(bl);
    }

    public final void zzx(boolean bl) {
        this.zza.setUserVisibleHint(bl);
    }

    public final void zzy(Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zzz(Intent intent, int n) {
        this.zza.startActivityForResult(intent, n);
    }
}
