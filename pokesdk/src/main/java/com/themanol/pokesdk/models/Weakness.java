package com.themanol.pokesdk.models;

import com.google.auto.value.AutoValue;
import com.themanol.pokesdk.injection.NetworkModule;

/**
 * Created by manuelgarcia on 13/11/16.
 */
@AutoValue
@NetworkModule.AutoGson(autoClass = AutoValue_Weakness.class)
public abstract class Weakness {

    public abstract String type();

    public abstract String value();
}
