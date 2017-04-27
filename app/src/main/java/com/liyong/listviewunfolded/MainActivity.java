package com.liyong.listviewunfolded;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.liyong.listviewunfolded.adapter.ListAdapter;
import com.liyong.listviewunfolded.listener.MyClickListener;
import com.liyong.listviewunfolded.listener.MyClickListener2;

/**
 * 模仿酷狗下载歌曲
 * listview点开效果
 */
public class MainActivity extends AppCompatActivity {

    private ListView lv_list;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        lv_list = (ListView) findViewById(R.id.lv_list);
    }

    private void initData() {
        listAdapter = new ListAdapter(this, listener, listener2);
        lv_list.setAdapter(listAdapter);


        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listAdapter.changeImageVisable(position);
            }
        });
    }

    /**
     * 点我1
     */
    MyClickListener listener = new MyClickListener() {
        @Override
        public void myOnClick(int position, View v) {
            Toast.makeText(getApplicationContext(), "点我1", Toast.LENGTH_LONG).show();
        }
    };

    /**
     * 点我2
     */
    MyClickListener2 listener2 = new MyClickListener2() {
        public void myOnClick2(int position, View v) {
            Toast.makeText(getApplicationContext(), "点我2", Toast.LENGTH_LONG).show();
        }
    };
}
