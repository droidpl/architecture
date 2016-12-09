//package com.themanol.pokecards.ui.carddetails;
//
//import com.themanol.pokecards.ui.carddetails.viewmodels.CardDetailsViewModel;
//import com.themanol.pokesdk.models.PokeCard;
//
//import android.support.annotation.NonNull;
//
///**
// * Created by manuelgarcia on 13/11/16.
// */
//
//public class CardDetailsPresenter implements CardDetailsViewTranslator.Presenter, CardDetailsInteractor.OnFinishedListener {
//
//	private final CardDetailsViewTranslator.View mView;
//	private final CardDetailsInteractor mInteractor;
//	private final String mId;
//
//	CardDetailsPresenter(String id, @NonNull CardDetailsViewTranslator.View view, @NonNull CardDetailsInteractor interactor) {
//		mId = id;
//		mView = view;
//		mInteractor = interactor;
//		mView.setPresenter(this);
//		start();
//	}
//
//	@Override
//	public void start() {
//		mInteractor.getCard(mId, this);
//	}
//
//	@Override
//	public void onSuccess(PokeCard pokeCard) {
//		CardDetailsViewModel viewModel = new CardDetailsViewModel();
//		viewModel.setName(pokeCard.getName());
//		viewModel.setImageUrl(pokeCard.getImageUrl());
//		mView.showCard(viewModel);
//	}
//
//	@Override
//	public void onError() {
//		mView.showError();
//	}
//}
