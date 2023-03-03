package com.example.school;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.school.databinding.Lao2Binding;
import com.example.school.databinding.LaoBinding;
import com.killua.ui.adapter.BaseRecyclerAdapter;
import com.killua.ui.adapter.BaseViewHolder;

public class Recycler2Adapter extends BaseRecyclerAdapter<User> {

    private Context context;
    public Recycler2Adapter(Context context) {
        super(context);
        this.context=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LearningViewHolder(Lao2Binding.inflate(mLayoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
//        holder.itemView.setOnClickListener(v -> {
//            if(onItemClickListener != null && holder.getBindingAdapterPosition()!=RecyclerView.NO_POSITION){
//                onItemClickListener.onItemClick(v,holder.getBindingAdapterPosition(),getItem(holder.getBindingAdapterPosition()));
//            }
//        });

        LearningViewHolder learningViewHolder = (LearningViewHolder) holder;
        learningViewHolder.getViewDataBinding().setUser(getItem(position));
    }

    static class LearningViewHolder extends BaseViewHolder<Lao2Binding>{

        public LearningViewHolder(Lao2Binding laoBinding) {
            super(laoBinding);
        }
    }
}
