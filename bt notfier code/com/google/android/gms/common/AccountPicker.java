/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  com.google.android.gms.common.AccountPicker$AccountChooserOptions
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
public final class AccountPicker {
    private AccountPicker() {
    }

    @Deprecated
    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] stringArray, boolean bl, String string, String string2, String[] stringArray2, Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument((boolean)true, (Object)"We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", stringArray);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", (Parcelable)account);
        intent.putExtra("alwaysPromptForAccount", bl);
        intent.putExtra("descriptionTextOverride", string);
        intent.putExtra("authTokenType", string2);
        intent.putExtra("addAccountRequiredFeatures", stringArray2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        AccountChooserOptions.zza((AccountChooserOptions)accountChooserOptions);
        AccountChooserOptions.zzb((AccountChooserOptions)accountChooserOptions);
        Preconditions.checkArgument((boolean)true, (Object)"We only support hostedDomain filter for account chip styled account picker");
        AccountChooserOptions.zzc((AccountChooserOptions)accountChooserOptions);
        Preconditions.checkArgument((boolean)true, (Object)"Consent is only valid for account chip styled account picker");
        AccountChooserOptions.zzd((AccountChooserOptions)accountChooserOptions);
        Preconditions.checkArgument((boolean)true, (Object)"Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        AccountChooserOptions.zza((AccountChooserOptions)accountChooserOptions);
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", (Serializable)AccountChooserOptions.zzf((AccountChooserOptions)accountChooserOptions));
        if (AccountChooserOptions.zzg((AccountChooserOptions)accountChooserOptions) != null) {
            intent.putExtra("allowableAccountTypes", AccountChooserOptions.zzg((AccountChooserOptions)accountChooserOptions).toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", AccountChooserOptions.zzh((AccountChooserOptions)accountChooserOptions));
        intent.putExtra("selectedAccount", (Parcelable)AccountChooserOptions.zzi((AccountChooserOptions)accountChooserOptions));
        AccountChooserOptions.zzd((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", AccountChooserOptions.zzj((AccountChooserOptions)accountChooserOptions));
        intent.putExtra("descriptionTextOverride", AccountChooserOptions.zzk((AccountChooserOptions)accountChooserOptions));
        AccountChooserOptions.zzl((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("setGmsCoreAccount", false);
        AccountChooserOptions.zzm((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("realClientPackage", null);
        AccountChooserOptions.zze((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("overrideTheme", 0);
        AccountChooserOptions.zza((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("overrideCustomTheme", 0);
        AccountChooserOptions.zzb((AccountChooserOptions)accountChooserOptions);
        intent.putExtra("hostedDomainFilter", null);
        Bundle bundle = new Bundle();
        AccountChooserOptions.zza((AccountChooserOptions)accountChooserOptions);
        AccountChooserOptions.zzc((AccountChooserOptions)accountChooserOptions);
        AccountChooserOptions.zzn((AccountChooserOptions)accountChooserOptions);
        AccountChooserOptions.zzo((AccountChooserOptions)accountChooserOptions);
        if (bundle.isEmpty()) return intent;
        intent.putExtra("first_party_options_bundle", bundle);
        return intent;
    }
}
