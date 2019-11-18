package com.example.animal_health;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainPlay extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6,imageView7;
    Glide GlideApp;
    String[] country = {  "기초 훈련", "중급 훈련", "개인기 훈련"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        imageView = findViewById(R.id.image);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageView5 = findViewById(R.id.image5);
        imageView6 = findViewById(R.id.image6);
        imageView7 = findViewById(R.id.image7);


        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference listRef = storage.getReferenceFromUrl("gs://animal-health-d5254.appspot.com/IMG_2335.jpg");



        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();
        System.out.println("aaa"+country[position]);

        if(country[position].equals("기초 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb1.PNG?alt=media&token=a678588b-c9a2-41f0-bb60-5d3c03e6951f";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb2.PNG?alt=media&token=b8215cb2-0a1b-4880-a75f-3212ac684901";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb3.PNG?alt=media&token=ca6283a0-4e4f-421b-b79a-aff655843655";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb4.PNG?alt=media&token=c2a1f83e-572b-4461-8384-16bba6e97688";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb5.PNG?alt=media&token=a3d07cb5-5c6b-4fb5-9d8f-d7d0ea02750d";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb6.PNG?alt=media&token=751885b3-633c-49df-b0fe-3f48c2367195";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb7.PNG?alt=media&token=61f204a3-0181-40d3-adb6-c096345cf37e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);

        }else if(country[position].equals("중급 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc1.PNG?alt=media&token=b4a10af8-204b-4f62-8ac5-3657a7f3c7a2";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc2.PNG?alt=media&token=a7b79f06-0e60-4f8a-8493-e43eda48125d";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc3.PNG?alt=media&token=84c7695c-b8b1-43a0-9aa2-a089b756bb61";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc4.PNG?alt=media&token=f1e4807e-cffa-4fea-a194-3c9f89e8dd1b";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc5.PNG?alt=media&token=8dc3753f-0ef3-4a8c-9207-9516aad46e58";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc6.PNG?alt=media&token=116090e9-b5e8-4b66-9ec2-3c7a70beb52a";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc7.PNG?alt=media&token=708a477c-5ba3-4e34-b46e-3d0c2a7fea7f";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);

        }else if(country[position].equals("개인기 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa1.PNG?alt=media&token=7e581add-5ebc-4d09-8a24-42fdd648c215";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa2.PNG?alt=media&token=b4a9e233-ffd7-4136-bd7f-ee1f4e8bfc8b";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa3.PNG?alt=media&token=d5ac555f-99be-417d-bef9-a5ec160879f0";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa4.PNG?alt=media&token=39486f82-fe39-4c96-9b71-bbe680e2eb8d";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa5.PNG?alt=media&token=66d1c751-55ef-4150-ae24-f862d8c4c26e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa6.PNG?alt=media&token=2ee47877-b448-4a4a-af0f-2af79ff3a5e9";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}


