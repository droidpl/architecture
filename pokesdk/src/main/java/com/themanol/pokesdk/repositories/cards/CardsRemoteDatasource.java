package com.themanol.pokesdk.repositories.cards;

import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.models.PokeCards;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by manuelgarcia on 13/11/16.
 */

public interface CardsRemoteDatasource {

    @GET("cards")
    Single<PokeCards> getCards();

    @GET("cards/{id}")
    Maybe<PokeCard> getCard(@Path("id") String id);
}
