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
    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6,imageView7,imageView8,imageView9,imageView10, imageView11;
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
        imageView8 = findViewById(R.id.image8);
        imageView9 = findViewById(R.id.image9);
        imageView10 = findViewById(R.id.image10);
        imageView11 = findViewById(R.id.image11);


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
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-1.PNG?alt=media&token=224a9a2b-5613-4af3-842a-0bee8f304447";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-2.PNG?alt=media&token=cb176811-5724-461a-a949-1717fb64992b";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-3.PNG?alt=media&token=1e47a7ba-3bae-4324-a57a-26ba745fc583";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-4.PNG?alt=media&token=827a340f-7e77-4a8b-a402-943609291026";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-5.PNG?alt=media&token=a6f82bbd-9e23-406c-951d-dea0cc11606b";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-6.PNG?alt=media&token=623a7f04-37ed-4910-95a5-1c1fe033dfad";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-7.PNG?alt=media&token=77db3090-c5c3-47a3-88c8-2695846710da";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);
            String url8 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-7.jpg?alt=media&token=2d992774-c9f0-4d3e-9586-0dd9070a7a7c";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url8).into(imageView8);
            String url9 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-8.PNG?alt=media&token=a42c695f-de9a-4814-a519-3f0631fb7a41";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url9).into(imageView9);
            String url10 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-8.jpg?alt=media&token=9951dd45-5d01-428e-a577-5fa8adab44d9";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url10).into(imageView10);
            String url11 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F1-9.PNG?alt=media&token=fbec4280-1f85-4805-98dd-9d1ae7b55991";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url11).into(imageView11);

        }else if(country[position].equals("중급 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-1.PNG?alt=media&token=fabf7b57-7f18-4d65-81ce-82d7220d4818";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-1.jpg?alt=media&token=9f128c3b-b34a-44f6-9d0b-c5899b625f00";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-2.PNG?alt=media&token=ea222c3a-7020-4afa-bcc2-d51f6e87685f";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-p2.jpg?alt=media&token=71bcb7c2-a34d-475b-b2a9-04918a3a250e";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-3.PNG?alt=media&token=08a7b8a1-7366-4a73-a9aa-68e5843e0633";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-4.PNG?alt=media&token=5b812340-7f93-450d-ad6a-41f55bbbc1c0";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-5.PNG?alt=media&token=3c8b10d7-5d5c-429e-a451-742bf4ba4d55";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);
            String url8 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-p5.png?alt=media&token=f96b534c-e17b-469b-a79a-9176548dbd96";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url8).into(imageView8);
            String url9 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F2-6.PNG?alt=media&token=09ba25de-dd12-4440-83b2-f7261b41d6b2";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url9).into(imageView9);

        }else if(country[position].equals("개인기 훈련")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-1.PNG?alt=media&token=f7582ff0-66e6-4f85-b689-da3ac2c92be2";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url).into(imageView);
            String url2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-p1.jpg?alt=media&token=488d4961-5435-42d7-8039-65e431f6bd21";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url2).into(imageView2);
            String url3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-3.PNG?alt=media&token=c4603ed0-3805-4276-b265-e9b253548856";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url3).into(imageView3);
            String url4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-4.PNG?alt=media&token=60ae8322-a6b0-4b22-8054-a272cb19116a";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url4).into(imageView4);
            String url5 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-5.PNG?alt=media&token=ea6b7f3b-61d3-45e5-8fbb-4e2ce7010bd2";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url5).into(imageView5);
            String url6 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-6.PNG?alt=media&token=80174f2d-77b4-45c3-9acc-7c67c31167f3";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url6).into(imageView6);
            String url7 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-7.PNG?alt=media&token=c0d117ac-33a0-41b8-9f94-d52b0e65a5fd";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url7).into(imageView7);
            String url8 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2F3-8.PNG?alt=media&token=a476026e-6c58-41fc-8e6d-2d0f76c07501";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url8).into(imageView8);
            String url9 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/play%2Fimages%20(1).jpg?alt=media&token=bb42b96e-0930-4f26-8039-dd0cf368ee35";//Retrieved url as mentioned above
            Glide.with(getApplicationContext()).load(url9).into(imageView9);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}


