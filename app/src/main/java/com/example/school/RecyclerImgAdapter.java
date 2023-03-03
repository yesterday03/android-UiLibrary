package com.example.school;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.school.databinding.ImgBinding;
import com.example.school.databinding.LaoBinding;
import com.killua.ui.adapter.BaseRecyclerAdapter;
import com.killua.ui.adapter.BaseViewHolder;

public class RecyclerImgAdapter extends BaseRecyclerAdapter<Image> {

    private Context context;
    public RecyclerImgAdapter(Context context) {
        super(context);
        this.context=context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LearningViewHolder(ImgBinding.inflate(mLayoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
//        holder.itemView.setOnClickListener(v -> {
//            if(onItemClickListener != null && holder.getBindingAdapterPosition()!=RecyclerView.NO_POSITION){
//                onItemClickListener.onItemClick(v,holder.getBindingAdapterPosition(),getItem(holder.getBindingAdapterPosition()));
//            }
//        });

        LearningViewHolder learningViewHolder = (LearningViewHolder) holder;
        learningViewHolder.getViewDataBinding().setImage(getItem(position));
    }

    static class LearningViewHolder extends BaseViewHolder<ImgBinding>{

        public LearningViewHolder(ImgBinding laoBinding) {
            super(laoBinding);
        }
    }
}
