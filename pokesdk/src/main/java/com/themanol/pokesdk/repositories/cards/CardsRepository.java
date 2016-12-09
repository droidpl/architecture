package com.themanol.pokesdk.repositories.cards;

import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.models.PokeCards;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class CardsRepository {
    private CardsRemoteDatasource dataSource;
    private final Map<String, PokeCard> cache;

    public CardsRepository(CardsRemoteDatasource dataSource) {
        this.dataSource = dataSource;
        this.cache = new HashMap<>();
    }

    public Single<PokeCards> getPokeCards() {
        /**
         * Return the cached data or bring the new data from the network and
         * cache it in the map.
         */
        return Single.just(!cache.isEmpty())
                .flatMap(hasCachedData ->
                        hasCachedData ?
                                Single.just(PokeCards.create((List<PokeCard>) cache.values())) :
                                cacheResults(dataSource.getCards())
                );
    }

    public Maybe<PokeCard> getPokeCard(String id) {
        /**
         * Gets or a cached PokeCard or a new one from network. Then
         * caches it to the current map.
         */
        return Maybe.concat(Maybe.just(cache.get(id)), dataSource.getCard(id))
                .firstOrError()
                .doOnEvent((cardObtained, error) -> cache.put(cardObtained.id(), cardObtained))
                .toMaybe();
    }

    private Single<PokeCards> cacheResults(Single<PokeCards> cards) {
        /**
         * Gets every item and adds it to the Map cache. Then
         * converts it to PokeCards
         */
        return cards.toObservable()
                .flatMapIterable(PokeCards::cards)
                .map((it) -> {
                    cache.put(it.id(), it);
                    return it;
                }).toList()
                .map(PokeCards::create);
    }
}
