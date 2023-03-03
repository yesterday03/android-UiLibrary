package com.killua.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class  BaseJsonArrRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    protected JSONArray jsonArray = new JSONArray();
    protected LayoutInflater mLayoutInflater;
    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickLitener onItemLongClickLitener;

    public BaseJsonArrRecyclerAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public JSONObject getItem(int postion) throws JSONException {
        JSONArray var2;
        return (var2 = this.jsonArray) != null && var2.length() > postion ? this.jsonArray.getJSONObject(postion) : null;
    }

    public int getItemCount() {
        JSONArray var1;
        return (var1 = this.jsonArray) == null ? 0 : var1.length();
    }

    public void addItem(JSONObject var1, boolean var2) {
        this.jsonArray.put(var1);
        if (var2) {
            this.notifyDataSetChanged();
        }

    }

    public void reMoveItem(int postion){
        this.jsonArray.remove(postion);
        this.notifyItemRemoved(postion);
    }

    public void addItem(JSONObject var1) {
        this.addItem(var1, true);
    }

    public void addAllItem(JSONArray var1, boolean var2) {
        this.jsonArray = var1;
        if (var2) {
            this.notifyDataSetChanged();
        }

    }

    public void addAllItem(JSONArray var1) {
        this.addAllItem(var1, true);
    }

    public void clearItems() {
        this.jsonArray = new JSONArray();
    }

    public void addAllAndClear(JSONArray var1) {
        this.clearItems();
        this.addAllItem(var1);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickLitener(OnItemLongClickLitener onItemLongClickLitener) {
        this.onItemLongClickLitener = onItemLongClickLitener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int postion,JSONObject t);
    }

    public interface OnItemLongClickLitener {
        void onItemLongClick(View view, int postion,JSONObject t);
    }
}
