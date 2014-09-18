package edu.nedu.recyclerviewdemo;

import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    // 数据集
    private ArrayList<String> dataList;

    public RecyclerViewAdapter(ArrayList<String> dataList) {
        super();
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
 
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // 绑定数据到ViewHolder上
        viewHolder.mTextView.setText(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
    
    
    /**
     * 添加数据
     * @param data
     * @param position
     */
    public void addData(String data, int position) {
    	dataList.add(position, data);
        notifyItemInserted(position);
    }
    /**
     * 移除数据
     * @param position
     */
    public void removeData(int position) {
    	dataList.remove(position);
        notifyItemRemoved(position);
    }
}
