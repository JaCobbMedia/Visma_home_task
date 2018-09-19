package com.example.jokubas.visma_task_dogs.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.jokubas.visma_task_dogs.Adapters.ImageAdapter;
import com.example.jokubas.visma_task_dogs.Helpers.ConnectivityCheck;
import com.example.jokubas.visma_task_dogs.IO.JsonReader;
import com.example.jokubas.visma_task_dogs.R;

import java.util.ArrayList;

public class Main_activity extends AppCompatActivity {

    String jsonFile = "dog_urls.json";
    ArrayList<String> dogUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        dogUrls = JsonReader.readJSONfile(jsonFile, this);

        if(ConnectivityCheck.CheckConnectivity(this)){
            GridView gridView = (GridView) findViewById(R.id.gridView);
            gridView.setAdapter(new ImageAdapter(this, dogUrls));

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getApplicationContext(), LargeImage_Activity.class);
                    i.putExtra("id", position);
                    i.putExtra("url",dogUrls.get(position));
                    startActivity(i);
                }
            });
        }else{
            Toast.makeText(getApplicationContext(), getString(R.string.net_error), Toast.LENGTH_LONG).show();
        }

    }
}
