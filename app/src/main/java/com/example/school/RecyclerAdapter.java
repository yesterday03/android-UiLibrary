package com.example.school;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school.databinding.LaoBinding;
import com.killua.ui.adapter.BaseRecyclerAdapter;
import com.killua.ui.adapter.BaseViewHolder;

public class RecyclerAdapter extends BaseRecyclerAdapter<User> {

    private Context context;
    public RecyclerAdapter(Context context) {
        super(context);
        this.context=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LearningViewHolder(LaoBinding.inflate(mLayoutInflater,parent,false));
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

    static class LearningViewHolder extends BaseViewHolder<LaoBinding>{

        public LearningViewHolder(LaoBinding laoBinding) {
            super(laoBinding);
        }
    }
}
