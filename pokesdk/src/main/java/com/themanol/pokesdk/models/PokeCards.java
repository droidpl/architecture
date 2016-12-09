package com.themanol.pokesdk.models;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.themanol.pokesdk.injection.NetworkModule;

import java.util.List;

/**
 * Created by manuelgarcia on 13/11/16.
 */

@AutoValue
@NetworkModule.AutoGson(autoClass = AutoValue_PokeCards.class)
public abstract class PokeCards {

    public abstract List<PokeCard> cards();

    public static PokeCards create(@NonNull List<PokeCard> cards) {
        return new AutoValue_PokeCards(cards);
    }
}
