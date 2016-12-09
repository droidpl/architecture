package com.themanol.pokecards.ui.cards;

import android.support.annotation.NonNull;

import com.themanol.pokecards.ui.cards.viewmodels.CardsViewModel;
import com.themanol.pokesdk.models.PokeCards;
import com.themanol.pokesdk.usecases.GetAllCardsUseCase;
import com.themanol.pokesdk.utils.RxUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

class CardsPresenter extends DisposableSingleObserver<CardsViewModel> implements CardsViewTranslator.Presenter {

    private CardsViewTranslator.View view;
    private GetAllCardsUseCase useCase;
    private CompositeDisposable disposables;

    CardsPresenter(@NonNull CardsViewTranslator.View view, @NonNull GetAllCardsUseCase useCase) {
        this.view = view;
        this.useCase = useCase;
        disposables = new CompositeDisposable();
    }

    @Override
    public void start() {
        view.setLoadingIndicator(true);
        /**
         * Execute the use case and transform it to something with value for the
         * view. In this case CardsViewModel.
         */
        disposables.add(useCase.execute(null)
                .map(PokeCards::cards)
                .map(CardsViewModel::new)
                .compose(RxUtils.defaultSchedulersSingle())
                .subscribeWith(this));
    }

    @Override
    public void destroy() {
        disposables.dispose();
    }

    @Override
    public void onSuccess(CardsViewModel value) {
        view.setLoadingIndicator(false);
        view.showCards(value);
    }

    @Override
    public void onError(Throwable e) {
        view.setLoadingIndicator(false);
        view.showError();
    }
}
