package com.themanol.pokecards.ui.cards;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.themanol.pokecards.R;
import com.themanol.pokecards.base.PokeCardsApplication;
import com.themanol.pokecards.ui.cards.adapter.CardsAdapter;
import com.themanol.pokecards.ui.cards.viewmodels.CardsViewModel;
import com.themanol.pokesdk.usecases.GetAllCardsUseCase;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.themanol.pokecards.ui.carddetails.CardDetailsActivity;

public class CardsActivity extends AppCompatActivity implements CardsViewTranslator.View, CardsAdapter.OnCardClickListener {

    private CardsViewTranslator.Presenter mPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ContentLoadingProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_activity);
        ButterKnife.bind(this);
        initViews();
        mPresenter = new CardsPresenter(this, new GetAllCardsUseCase(PokeCardsApplication.sdk().repositories().cardsRepository()));
        mPresenter.start();
    }

    private void initViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.hide();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            progressBar.show();
        } else {
            progressBar.hide();
        }

    }

    @Override
    public void showCards(CardsViewModel cards) {
        recyclerView.setAdapter(new CardsAdapter(cards, this));
    }

    @Override
    public void showError() {
        Log.d("TheManol", "Get cards error");
    }

    @Override
    public void onCardClick(String cardId, ImageView imageView, TextView nameView) {
//		CardDetailsActivity.startActivity(cardId, this, imageView, nameView);
    }
}
