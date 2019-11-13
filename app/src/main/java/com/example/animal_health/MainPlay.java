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
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb1.PNG?alt=media&token=a18459c5-5e67-4293-acbd-4b0ad629dc1e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb2.PNG?alt=media&token=fba0e6c4-cdd9-4d6c-9fb6-fcb41fb23c06";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb3.PNG?alt=media&token=947997fe-e9bc-412e-89a9-f3f44b7effef";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb4.PNG?alt=media&token=a5e5a45a-97f2-427a-9f69-81226fded23c";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb5.PNG?alt=media&token=2c00fa93-c2eb-4ae5-8c00-df9c3b77906a";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb6.PNG?alt=media&token=4b1b642b-ec3c-47f7-ab59-c4d801d60e97";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fb7.PNG?alt=media&token=200a22c0-fe7e-4d36-b772-f6d339b1639e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);
        }else if(country[position].equals("중급 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc1.PNG?alt=media&token=b1e1542d-9c3e-4eb7-8985-d205cb5f13a1";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc2.PNG?alt=media&token=b28dec0d-91c8-4a9a-95ab-39e88d68e086";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc3.PNG?alt=media&token=931a0b48-a589-4613-b6b0-d8a72007ddf0";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc4.PNG?alt=media&token=6ee13cde-f059-4e34-a842-8e989dc7f7fd";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc5.PNG?alt=media&token=c34064a1-c8cc-45d2-ada7-968066326e89";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc6.PNG?alt=media&token=6df3bc87-6e7f-41f5-9418-851a7818b5e0";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fc7.PNG?alt=media&token=05f955e8-f219-4cc0-8970-7d380207dbf2";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);
        }else if(country[position].equals("개인기 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa1.PNG?alt=media&token=cc97e26b-6219-4f88-a7ae-09edb79f5fe5";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa2.PNG?alt=media&token=8e9b840c-8c96-45e1-8d34-a0917337bbc1";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa3.PNG?alt=media&token=4afda6e3-e029-4226-9e3f-a2a2f4a65db8";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa4.PNG?alt=media&token=3b64b3c2-85b9-429d-9ef6-eed3c9835ea0";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa5.PNG?alt=media&token=f38f9afe-3917-4563-9018-03659acdaffd";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fa6.PNG?alt=media&token=03b4516b-8b4a-47c0-83d0-9fa250a5739e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}


