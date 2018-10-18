package com.example.administrator.listviewlocalrefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<String> names = new ArrayList<String>();
    @BindView(R.id.position)
    EditText idEdit;
    @BindView(R.id.content)
    EditText nameEdit;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.listview)
    ListView listView;
    private LocalRefreshAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
        initListener();
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = idEdit.getText().toString();
                String str2 = nameEdit.getText().toString();
                try{
                    int position = Integer.parseInt(str1);
                    if(position>0 && position<names.size()){
                        adapter2.updateView(position,str2,listView);
                    }else{
                        Toast.makeText(MainActivity.this,"输入异常",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"输入异常",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        final LocalRefreshAdapter adapter = new LocalRefreshAdapter(this, names);
        adapter2 = adapter;
        listView.setAdapter(adapter);
    }

    private void initData() {
        names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");
        names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");names.add("谭桂涛");
        names.add("谭克骚");
        names.add("GOAT");
        names.add("罗宾");
        names.add("谭哥哥");
    }
}
