package com.themanol.pokesdk.models;

import com.google.auto.value.AutoValue;
import com.themanol.pokesdk.injection.NetworkModule;

import java.util.List;

@AutoValue
@NetworkModule.AutoGson(autoClass = AutoValue_PokeCard.class)
public abstract class PokeCard {

    public abstract String id();

    public abstract String name();

    public abstract String nationalPokedexNumber();

    public abstract String imageUrl();

    public abstract String subtype();

    public abstract String supertype();

    public abstract Ability ability();

    public abstract String hp();

    public abstract String number();

    public abstract String artist();

    public abstract String rarity();

    public abstract String series();

    public abstract String set();

    public abstract String setCode();

    public abstract List<String> types();

    public abstract List<Attack> attacks();

    public abstract List<Weakness> weaknesses();

    public abstract List<Resistance> resistances();

    public static Builder builder() {
        return new AutoValue_PokeCard.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Builder nationalPokedexNumber(String nationalPokedexNumber);

        public abstract Builder imageUrl(String imageUrl);

        public abstract Builder subtype(String subtype);

        public abstract Builder supertype(String superType);

        public abstract Builder ability(Ability ability);

        public abstract Builder hp(String hp);

        public abstract Builder number(String number);

        public abstract Builder artist(String artist);

        public abstract Builder rarity(String rarity);

        public abstract Builder series(String series);

        public abstract Builder set(String set);

        public abstract Builder setCode(String setCode);

        public abstract Builder types(List<String> types);

        public abstract Builder attacks(List<Attack> attacks);

        public abstract Builder weaknesses(List<Weakness> weaknesses);

        public abstract Builder resistances(List<Resistance> resistances);

        public abstract PokeCard build();
    }
}
