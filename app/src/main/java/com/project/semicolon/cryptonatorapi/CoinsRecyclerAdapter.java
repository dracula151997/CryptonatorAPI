package com.project.semicolon.cryptonatorapi;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.cryptonatorapi.databinding.CoinListItemBinding;
import com.project.semicolon.cryptonatorapi.model.MarketsItem;

import java.util.ArrayList;
import java.util.List;

public class CoinsRecyclerAdapter extends RecyclerView.Adapter<CoinsRecyclerAdapter.ViewHolder> {
    private List<MarketsItem> items;

    public void setItems(List<MarketsItem> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public CoinsRecyclerAdapter() {
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CoinListItemBinding binding = CoinListItemBinding.inflate(layoutInflater,
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setMarket(items.get(position));

    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CoinListItemBinding binding;

        public ViewHolder(@NonNull CoinListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
