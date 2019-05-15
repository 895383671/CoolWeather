package com.example.admin.myapplication;//package com.example.admin.myapplication;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Response;
//
//public class CountryActivity extends AppCompatActivity {
//    private TextView textView=null;
//
//    private String[] weather_ids= {"","",""," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",""," "," "," "," "," "," "," "," "," "," "," "," "," "};
//    private List<String> data=new ArrayList<>();
//    private ListView contrylistview;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_country);
//        this.textView=findViewById(R.id.textview);
//        this.contrylistview=findViewById(R.id.contrylistview);
//
//        Intent intent=getIntent();
//        int cityid=intent.getIntExtra("cid",0);
//        int pid=intent.getIntExtra("pid",0);
//
//        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//        contrylistview.setAdapter(adapter);
//        this.contrylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("点击了哪一个",""+position+":"+weather_ids[position]);
//                Intent intent = new Intent(CountryActivity.this,WeatherActivity.class);
//                intent.putExtra("wid",weather_ids[position]);
//                startActivity(intent);
//            }
//        });
//
//        String url="http://guolin.tech/api/china/"+pid+"/"+cityid;
//        com.example.admin.helloworld1.HttpUtil.sendOkHttpRequest(url, new Callback() {
//
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String responseText = response.body().string();
//
//                //parseJSONObject(responseText);
//
//                parseJSONObject(responseText);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
//            }
//
//
//        });
//
//    }
//    private void parseJSONObject(String responseText) {
//        JSONArray jsonArray = null;
//        this.data.clear();
//        try {
//            jsonArray = new JSONArray(responseText);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = null;
//                jsonObject = jsonArray.getJSONObject(i);
//                this.data.add(jsonObject.getString("name"));
//                this.weather_ids[i] = jsonObject.getString("weather_id");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
