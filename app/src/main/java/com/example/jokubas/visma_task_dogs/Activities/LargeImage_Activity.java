package com.example.jokubas.visma_task_dogs.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.jokubas.visma_task_dogs.R;
import com.squareup.picasso.Picasso;

public class LargeImage_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image_);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        String url = i.getExtras().getString("url");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(url).into(imageView);
    }
}
