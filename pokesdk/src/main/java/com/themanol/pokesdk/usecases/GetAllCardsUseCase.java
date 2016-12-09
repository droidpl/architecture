package com.themanol.pokesdk.usecases;

import com.themanol.pokesdk.models.PokeCards;
import com.themanol.pokesdk.repositories.cards.CardsRepository;

import io.reactivex.Single;

public class GetAllCardsUseCase implements BaseUseCase<Single<PokeCards>, Void> {

    private CardsRepository repository;

    public GetAllCardsUseCase(CardsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<PokeCards> execute(Void ignore) {
        return repository.getPokeCards();
    }
}
