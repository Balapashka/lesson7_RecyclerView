package kz.jihc.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FoodListAdapter foodListAdapter;
    ArrayList<Food> foodList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    Button btnChange;
    boolean LayoutType = false;


    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initRecyclerItemClick(){
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(this,recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void OnItemClick(View view, final int pos){
                    Toast.makeText(SecondActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();
                }


                @Override
                public void onLongItemClick(View view, int position){
                    Toast.makeText(SecondActivity.this, "onLongItemClick", Toast.LENGTH_SHORT).show();
                }
            })
        );
    }
    public void initViews(){

        recyclerView = findViewById(R.id.recyclerView);
        btnChange = findViewById(R.id.btnChange);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.tort, "Woopy1", "Торт Вупи-Пай", 3500));
        foodList.add(new Food(R.drawable.tort, "Woopy2", "Торт Вупи-Пай", 4500));
        foodList.add(new Food(R.drawable.tort, "Woopy3", "Торт Вупи-Пай", 2500));

        foodListAdapter = new FoodListAdapter(this,foodList);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(foodListAdapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutType = !LayoutType;

                if (LayoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                }else{
                    recyclerView.setLayoutManager(linearLayoutManager);
                }

                foodListAdapter.notifyDataSetChanged();
            }
        });
    }

}
