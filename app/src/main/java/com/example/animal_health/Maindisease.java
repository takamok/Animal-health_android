package com.example.animal_health;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Maindisease extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView ivdismu1, ivdismu2, ivdismu3, ivdismu4;
    Glide GlideApp;
    String[] dis = {"링웜(피부병)", "발작", "급성 심부전", "심장 사상충", "음식물 중독", "장폐색"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        ivdismu1 = findViewById(R.id.dismu1);
        ivdismu2 = findViewById(R.id.dismu2);
        ivdismu3 = findViewById(R.id.dismu3);
        ivdismu4 = findViewById(R.id.dismu4);

        FirebaseStorage storage = FirebaseStorage.getInstance();

        Spinner dismu = (Spinner) findViewById(R.id.dismu);
        dismu.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dis);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dismu.setAdapter(bb);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int menu, long l) {
        Toast.makeText(getApplicationContext(),dis[menu] , Toast.LENGTH_LONG).show();
        if(dis[menu].equals("링웜(피부병)")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm.PNG?alt=media&token=09c9f234-9301-48d1-8480-e169b68048b2";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm2.PNG?alt=media&token=8a32f30b-43f3-4ed8-842b-a733859b47bf";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }else if(dis[menu].equals("발작")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion1.PNG?alt=media&token=7b5d8074-bb9a-408e-bde9-5e2802900d8b";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion2.PNG?alt=media&token=f8d12068-5a3b-43c8-ba2d-5eea0a4a68db";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion3.PNG?alt=media&token=7bf6343c-f5f2-4035-acf5-9e2d871649ed";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);
            String ur4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion4.PNG?alt=media&token=ff4c18bf-8382-4d11-93c4-ba4ef1e66e2b";
            Glide.with(getApplicationContext()).load(ur4).into(ivdismu4);

        }else if(dis[menu].equals("급성 심부전")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure.PNG?alt=media&token=77d30918-79c9-48d1-a4af-d50a58279941";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure2.PNG?alt=media&token=4b012ce9-5031-419b-b05a-70f686c08e35";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }else if(dis[menu].equals("심장 사상충")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis.PNG?alt=media&token=863482d3-510e-4a8b-a688-2602d527078c";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis2.PNG?alt=media&token=7129c134-e57d-431a-842e-6bccfd842826";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);


        }else if(dis[menu].equals("음식물 중독")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology.PNG?alt=media&token=ca824d16-9b40-43c1-8c41-90e8eeeb99d1";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology2.PNG?alt=media&token=a2f4c185-daa0-4fcc-9908-b1b8ef63a969";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology3.PNG?alt=media&token=2ab16b88-b0c3-4061-93ab-a5a57e7e97ee";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);

        }else if(dis[menu].equals("장폐색")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FIleus.PNG?alt=media&token=446ae10e-8b67-4cbf-8474-6a8cfd166198";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fileus2.PNG?alt=media&token=fa9858eb-ee83-4e94-a05d-c0f1b4313eca";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub

    }
}