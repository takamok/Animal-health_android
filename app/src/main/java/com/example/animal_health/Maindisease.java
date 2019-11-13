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
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm.PNG?alt=media&token=3b060016-96ac-48fe-9e6d-4e9361a1746d";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm2.PNG?alt=media&token=7f73e450-606b-435c-a0c6-7973717a30de";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }else if(dis[menu].equals("발작")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion1.PNG?alt=media&token=8f78958c-6d31-4816-95b8-d57f755243d1";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion2.PNG?alt=media&token=b5468792-21b2-4035-957f-eff490f201fe";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion3.PNG?alt=media&token=6a7d190d-beb6-4a0f-bfc6-55573ca88f5f";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);
            String ur4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion4.PNG?alt=media&token=c2fc4402-3599-4f72-9b7d-b54abfc3b00a";
            Glide.with(getApplicationContext()).load(ur4).into(ivdismu4);

        }else if(dis[menu].equals("급성 심부전")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure.PNG?alt=media&token=2132cdbc-beb4-4c3c-bdf0-b1956f4e9d2c";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure2.PNG?alt=media&token=84ab3526-1c0c-45b8-a035-d91364136667";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }else if(dis[menu].equals("심장 사상충")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis.PNG?alt=media&token=6b43c4bd-19b4-40cf-ad72-25a64bef0d99";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis2.PNG?alt=media&token=5434ffb1-a81a-48bc-9249-e41cb3fb797d";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);


        }else if(dis[menu].equals("음식물 중독")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology.PNG?alt=media&token=6bd75a64-c491-4b6b-9276-46f86d80a89a";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology2.PNG?alt=media&token=3c0fd240-e584-4dc0-9d1f-20a51db6675e";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology3.PNG?alt=media&token=00cb12a1-fb1d-4efd-8daf-5f146f45e9dc";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);

        }else if(dis[menu].equals("장폐색")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FIleus.PNG?alt=media&token=ad404637-7175-4424-a8fc-7223590a140b";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fileus2.PNG?alt=media&token=a2f2dcb0-53e2-40b4-a011-1d1c846f8f34";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub

    }
}