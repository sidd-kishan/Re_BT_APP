/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater
 *  androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener
 */
package androidx.asynclayoutinflater.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

private static class AsyncLayoutInflater.InflateRequest {
    AsyncLayoutInflater.OnInflateFinishedListener callback;
    AsyncLayoutInflater inflater;
    ViewGroup parent;
    int resid;
    View view;

    AsyncLayoutInflater.InflateRequest() {
    }
}
