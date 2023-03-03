package com.killua.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("NotifyDataSetChanged")
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    protected ArrayList<T> mDatas;

    {
        mDatas = new ArrayList();
    }

    protected LayoutInflater mLayoutInflater;
    protected OnItemClickListener<T> onItemClickListener;
    protected OnItemLongClickLitener<T> onItemLongClickLitener;

    public BaseRecyclerAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public T getItem(int postion) {
        List<T> var2;
        return (var2 = this.mDatas) != null && var2.size() > postion ? this.mDatas.get(postion) : null;
    }

    public int getItemCount() {
        List<T> var1;
        return (var1 = this.mDatas) == null ? 0 : var1.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null && holder.getBindingAdapterPosition()!=RecyclerView.NO_POSITION){
                onItemClickListener.onItemClick(v,holder.getBindingAdapterPosition(),getItem(holder.getBindingAdapterPosition()));
            }
        });
    }

    public void reMoveItem(int postion){
        this.mDatas.remove(postion);
        this.notifyItemRemoved(postion);
    }

    public void reMoveAll(){
        this.clearItems();
        this.notifyDataSetChanged();
    }

    public void addItem(T var1) {
        this.addItem(var1, true);
    }

    public void addItem(T var1, boolean var2) {
        this.addItem(var1,var2,this.mDatas.size());
    }

    public void addItem(T var1, boolean var2,int index){
        this.mDatas.add(index,var1);
        if (var2) {
            this.notifyItemInserted(index);
        }
    }

    public void changeItem(int position,T var1){
        this.mDatas.set(position,var1);
        this.notifyItemChanged(position);
    }

    public void addAllItem(List<T> var1) {
        this.addAllItem(var1, true);
    }

    public void addAllItem(List<T> var1, boolean var2) {
        this.addAllItem(var1,var2,this.mDatas.size());
    }

    public void addAllItem(List<T> var1,boolean var2,int index){
        this.mDatas.addAll(index,var1);
        if (var2) {
            this.notifyItemRangeInserted(index,var1.size());
        }
    }

    public void clearItems() {
        this.mDatas.clear();
    }

    public void addAllAndClear(List<T> var1) {
        this.clearItems();
        this.mDatas.addAll(var1);
        this.notifyDataSetChanged();
    }

    public ArrayList<T> getAllDatas(){
        return mDatas;
    }

    public void destroyAdapter() {
        this.mDatas.clear();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickLitener(OnItemLongClickLitener<T> onItemLongClickLitener) {
        this.onItemLongClickLitener = onItemLongClickLitener;
    }

    public interface OnItemClickListener<T>{
        void onItemClick(View view,int postion,T t);
    }

    public interface OnItemLongClickLitener<T> {
        void onItemLongClick(View view, int postion,T t);
    }


}
