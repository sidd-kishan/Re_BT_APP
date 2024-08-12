/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.ads.mediation.MediationServerParameters
 */
package com.google.ads.mediation;

import com.google.ads.mediation.MediationServerParameters;

@Deprecated
public interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters> {
    public void destroy();

    public Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    public Class<SERVER_PARAMETERS> getServerParametersType();
}
