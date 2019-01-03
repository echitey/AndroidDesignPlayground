package com.echitey.designcheatsheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.echitey.designcheatsheet.adapters.DashAdapter;
import com.echitey.designcheatsheet.model.DashModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ArrayList<DashModel> dashModelArrayList;
    private RecyclerView recyclerView;
    private DashAdapter dashAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);

        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        setTitle("DASHBOARD");

        dashModelArrayList = new ArrayList<>();

        String heads[] = {"Home", "Hotel", "Dining", "Flights", "Gas Station", "Movies"};
        String sub[] = {"See what's coming", "12 hotels located", "Eat well", "10 flight advises", "Need some fuel?", "Some new movies"};
        int images[] = {R.drawable.ic_home_black_128dp, R.drawable.ic_hotel_black_128dp, R.drawable.ic_local_dining_black_128dp,
                        R.drawable.ic_flight_black_128dp, R.drawable.ic_local_gas_station_black_128dp, R.drawable.ic_local_movies_black_128dp};

        for(int count = 0; count < heads.length; count++){
            dashModelArrayList.add(new DashModel(heads[count], sub[count], images[count]));
        }

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        dashAdapter = new DashAdapter(dashModelArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dashAdapter);
    }
}
