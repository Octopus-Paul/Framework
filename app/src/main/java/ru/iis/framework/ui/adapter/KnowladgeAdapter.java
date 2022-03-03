package ru.iis.framework.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import ru.iis.framework.R;
import ru.iis.framework.databinding.ItemProductBinding;
import ru.iis.framework.ui.initiative.InitiativeContract;
import ru.iis.framework.ui.knowledge.KnowledgeContract;


public class KnowladgeAdapter extends RecyclerView.Adapter<KnowladgeAdapter.ViewHolder> {

    String[] names;
    long[] coast;
    float[] bonus;
    int[] icons;
    boolean[] flags;
    KnowledgeContract.View contract;

    public KnowladgeAdapter(String[] names, long[] coast, float[] bonus, int[] icons,boolean[] flags, KnowledgeContract.View contract) {
        this.names=names;       this.coast=coast;
        this.bonus=bonus;       this.icons=icons;
        this.contract=contract; this.flags=flags;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemProductBinding binding =ItemProductBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.binding.image.setImageResource(icons[position]);
        holder.binding.title.setText(names[position]);
        holder.binding.coast.setText(holder.itemView.getContext().getString(R.string.coast)
                                    .replace("$points",String.valueOf(coast[position])));
        holder.binding.buff.setText(holder.itemView.getContext().getString(R.string.bonus)
                .replace("$points",String.valueOf(bonus[position])));
        if(flags[position]){
            holder.binding.buyButton.setAlpha(0.4f);
            holder.binding.buyButton.setEnabled(false);
        }else{
            holder.binding.buyButton.setAlpha(1);
            holder.binding.buyButton.setEnabled(true);
            holder.binding.buyButton.setOnClickListener(v->{
                flags[position]=true;
                contract.buyButton(bonus[position], coast[position], position);
            });
        }
    }


    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        ItemProductBinding binding;

        public ViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
