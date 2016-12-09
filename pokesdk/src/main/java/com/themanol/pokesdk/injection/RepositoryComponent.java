package com.themanol.pokesdk.injection;

import com.themanol.pokesdk.repositories.RepositoryScope;
import com.themanol.pokesdk.repositories.cards.CardsRepository;

import dagger.Subcomponent;

@RepositoryScope
@Subcomponent(modules = {
        RepositoriesModule.class,
        RetrofitServicesModule.class
})
public interface RepositoryComponent {

    CardsRepository cardsRepository();
}
