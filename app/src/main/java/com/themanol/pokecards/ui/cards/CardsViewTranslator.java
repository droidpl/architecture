package com.themanol.pokecards.ui.cards;

import com.themanol.pokecards.base.BasePresenter;
import com.themanol.pokecards.base.BaseView;
import com.themanol.pokecards.ui.cards.viewmodels.CardsViewModel;

/**
 * Created by manuelgarcia on 13/11/16.
 */

interface CardsViewTranslator {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showCards(CardsViewModel cardsViewModel);

        void showError();
    }

    interface Presenter extends BasePresenter {
    }
}
