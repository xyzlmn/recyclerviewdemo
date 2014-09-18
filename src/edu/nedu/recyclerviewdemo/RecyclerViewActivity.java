package edu.nedu.recyclerviewdemo;

import java.util.ArrayList;

import edu.nedu.recyclerviewdemo.ClickItemTouchListener.OnItemClickListener;
import edu.nedu.recyclerviewdemo.ClickItemTouchListener.OnItemLongClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


public class RecyclerViewActivity extends Activity{

	
	private LinearLayoutManager layoutManager ;
	private ArrayList<String> dataList;
	private RecyclerViewAdapter adapter ;
	private RecyclerView recyclerView;
	
	private int firstVisiblePosition=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initRecyclerView();
    }


    public void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_vertical);

        // 创建一个线性布局管理器
        layoutManager = new LinearLayoutManager(this);
        // 默认是Vertical
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 创建数据集
        dataList = new ArrayList<String>();;
        for (int i = 0; i < 100; i++){
        	dataList.add("item" + i);
        }
        // allows for optimizations if all items are of the same size:
        recyclerView.setHasFixedSize(true);
        
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);

        // this is the default; this call is actually only necessary with custom ItemAnimators
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        
        // 创建Adapter，并指定数据集
        adapter = new RecyclerViewAdapter(dataList);
        // 设置Adapter
        recyclerView.setAdapter(adapter);
        
        ClickItemTouchListener clickListener = ClickItemTouchListener.addTo(recyclerView);

        clickListener.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(RecyclerView parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(RecyclerViewActivity.this, "ItemClick "+position+"  remove", Toast.LENGTH_LONG).show();
			
				adapter.removeData(position);
			
			}
           
        });

        clickListener.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(RecyclerView parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(RecyclerViewActivity.this, "ItemLongClick "+position, Toast.LENGTH_LONG).show();
				
				return false;
			}
			
        });

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

			@Override
			public void onScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onScrolled(int arg0, int arg1) {
				// TODO Auto-generated method stub
				//Toast.makeText(RecyclerViewActivity.this, "onScrolled "+arg0+"|"+arg1, Toast.LENGTH_LONG).show();
				
			}
           
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add) {
        	
        	adapter.addData("add data", 2);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
