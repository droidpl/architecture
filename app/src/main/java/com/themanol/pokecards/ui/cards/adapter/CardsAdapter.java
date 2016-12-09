package com.themanol.pokecards.ui.cards.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.themanol.pokecards.R;
import com.themanol.pokecards.ui.cards.viewmodels.CardItemViewModel;
import com.themanol.pokecards.ui.cards.viewmodels.CardsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private CardsViewModel viewModel;
    private OnCardClickListener listener;

    public CardsAdapter(@NonNull CardsViewModel cardsViewModel, @NonNull OnCardClickListener cardClickListener) {
        listener = cardClickListener;
        viewModel = cardsViewModel;
    }

    @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_item, parent, false);
        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardsViewHolder holder, int position) {
        holder.bindCardItem(viewModel.getItemViewModel(position));
    }

    @Override
    public int getItemCount() {
        return viewModel.getCount();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.type)
        TextView type;

        CardsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(view1 -> listener.onCardClick(viewModel.getItemViewModel(getAdapterPosition()).getCardId(), image, name));
        }

        void bindCardItem(CardItemViewModel viewModel) {
            name.setText(viewModel.getName());
            type.setText(viewModel.getType());
            Glide.with(image.getContext()).load(viewModel.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
        }
    }

    public interface OnCardClickListener {
        void onCardClick(String cardId, ImageView imageView, TextView nameView);
    }
}
