package com.themanol.pokecards.ui.cards.viewmodels;

import com.themanol.pokesdk.models.PokeCard;

import java.util.List;

/**
 * Created by manuelgarcia on 14/11/16.
 */

public class CardsViewModel {

    private List<PokeCard> mCards;

    public CardsViewModel(List<PokeCard> cards) {
        mCards = cards;
    }

    @SuppressWarnings("WrongConstant")
    public CardItemViewModel getItemViewModel(int position) {
        CardItemViewModel viewModel = new CardItemViewModel();
        viewModel.setImageUrl(mCards.get(position).imageUrl());
        viewModel.setName(mCards.get(position).name());
        viewModel.setTypes(mCards.get(position).types());
        viewModel.setSuperType(mCards.get(position).supertype());
        viewModel.setCardId(mCards.get(position).id());
        return viewModel;
    }

    public int getCount() {
        return mCards.size();
    }
}
