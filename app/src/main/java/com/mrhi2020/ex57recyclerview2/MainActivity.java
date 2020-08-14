package com.mrhi2020.ex57recyclerview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Item> items= new ArrayList<>();

    MyAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가 [실무에서는 DB나 서버에서 데이터를 읽어옴]
        items.add( new Item("루피", "해적단 선장", R.drawable.img01, "https://img.insight.co.kr/static/2020/05/20/700/f9kep8y69c910z3y9d68.jpg")  );
        items.add( new Item("조로", "해적단 검사", R.drawable.img02, "http://www.kbsm.net/data/newsThumb/1550436395ADD_thumb580.jpg")  );
        items.add( new Item("나미", "해적단 항해사", R.drawable.img03, "https://image.ajunews.com/content/image/2019/03/10/20190310141542622710.jpg")  );
        items.add( new Item("우솝", "해적단 저격수", R.drawable.img04, "https://t1.daumcdn.net/liveboard/maxmovie/35ac85c693664a7fbeab1ab44e63c4bb.JPG")  );
        items.add( new Item("상디", "해적단 요리사", R.drawable.img05, "https://cdn.indiepost.co.kr/uploads/images/2017/01/88Cnw3-665x374.jpeg")  );
        items.add( new Item("초파", "해적단 의사", R.drawable.img06, "https://img.chuing.net/i/QVJypJH/o5ZRCRo.jpg")  );
        items.add( new Item("니코로빈", "해적단 한량", R.drawable.img07, "https://img2.ruliweb.com/img/img_link7/447/446170_7.jpg")  );
        items.add( new Item("프랑크", "해적단 목수", R.drawable.img08, "https://pbs.twimg.com/media/CZKEVpOU8AAuq-n.jpg")  );



        adapter= new MyAdapter(this, items);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aa://Linear
                RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                break;

            case R.id.menu_bb://Grid
                RecyclerView.LayoutManager layoutManager1= new GridLayoutManager(this, 2);//2칸 짜리
                recyclerView.setLayoutManager(layoutManager1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
