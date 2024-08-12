/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.ump;

import android.app.Activity;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

public interface ConsentInformation {
    public int getConsentStatus();

    public int getConsentType();

    public boolean isConsentFormAvailable();

    public void requestConsentInfoUpdate(Activity var1, ConsentRequestParameters var2, OnConsentInfoUpdateSuccessListener var3, OnConsentInfoUpdateFailureListener var4);

    public void reset();
}
