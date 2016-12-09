package com.themanol.pokesdk.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.themanol.pokesdk.injection.NetworkModule;

@AutoValue
@NetworkModule.AutoGson(autoClass = AutoValue_Ability.class)
public abstract class Ability {

    public abstract String name();

    public abstract String text();

    public static Ability create(@NonNull String name, @NonNull String text) {
        return new AutoValue_Ability(name, text);
    }
}
