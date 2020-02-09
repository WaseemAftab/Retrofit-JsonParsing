package com.office.retrofitjsonparsing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.office.retrofitjsonparsing.model.Feed;
import com.office.retrofitjsonparsing.model.scholoars.Scholoars;
import com.office.retrofitjsonparsing.model.scholoars.Surah;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String Tag = "MainActivity";

    private static final String BASE_URL = "http://www.bhimsoft.com/";

    Button getDataButton;
    TextView text;
    public Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.txt_data);
        getDataButton = (Button) findViewById(R.id.btn_GetData);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        final Call<Feed> call = apiInterface.getData();

        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Data Received in LogCat");

                call.enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        //text.setText("received data : " + "\n" + response.body().toString());
                        Log.d(Tag, "on responce: server responce : " + response.toString());
                        Feed body = response.body();
                        Log.d(Tag, "on responce: received information : " + body.toString());

                        ArrayList<Scholoars> arrayList = body.getScholoars();


                        for (int i = 0; i < arrayList.size(); i++) {
                            Scholoars obj = arrayList.get(i);


                            ArrayList<Surah> surah = obj.getSurah();

                            for (int j = 0; j < surah.size(); j++) {
                                Surah surah1 = surah.get(j);
                                Log.d(Tag, "onResponce: \n" +
                                        "name_ar: " + surah1.getName_ar() + "\n" +
                                        "name_eng: " + surah1.getName_eng() + "\n" +
                                        "total_ayat: " + surah1.getTotal_ayat() + "\n" +
                                        "----------------------------------------" + "\n"
                                );
                            }

                            Log.d(Tag, "onResponceyyyyy: \n" +
                                    "name: " + arrayList.get(i).getName() + "\n" +
                                    "age: " + arrayList.get(i).getAge() + "\n" +
                                    "----------------------------------------" + "\n"
                            );
                        }
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
