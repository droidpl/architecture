package com.themanol.pokesdk.models;

import com.google.auto.value.AutoValue;
import com.themanol.pokesdk.injection.NetworkModule;

import java.util.List;

@AutoValue
@NetworkModule.AutoGson(autoClass = AutoValue_Attack.class)
public abstract class Attack {

    public abstract List<String> cost();

    public abstract String name();

    public abstract String text();

    public abstract String damage();

    public abstract int convertedEnergyCost();

    public static Attack create(List<String> cost, String name, String text, String damage, int convertedEnergyCost) {
        return new AutoValue_Attack(cost, name, text, damage, convertedEnergyCost);
    }
}
