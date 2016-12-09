package com.themanol.pokesdk.usecases;

import com.themanol.pokesdk.models.PokeCard;
import com.themanol.pokesdk.repositories.cards.CardsRepository;

import io.reactivex.Maybe;

public class GetCardById implements BaseUseCase<Maybe<PokeCard>, String> {

    private CardsRepository repository;

    public GetCardById(CardsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maybe<PokeCard> execute(String id) {
        return repository.getPokeCard(id);
    }
}
