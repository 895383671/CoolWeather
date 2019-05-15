package com.example.admin.myapplication;//package com.example.admin.myapplication;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
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
//public class CityActivity extends AppCompatActivity {
//
//    private int[] cids = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//    private List<String> data=new ArrayList<>();
//
//    private TextView textView;
//    private Button button;
//
//    private ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Intent intent=getIntent();
//       final int pid=intent.getIntExtra("pid",0);
//        Log.i("我们接收到了id",""+pid);
//        this.textView = (TextView) findViewById(R.id.abc);
//        this.listView=(ListView)findViewById(R.id.list_view);
//        this.button=(Button)findViewById(R.id.Btn);
////        this.button.setOnClickListener((v)->{
////            startActivity(new Intent(CityActivity.this,ProvinceActivity.class));
////        });
//
//        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
//        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("点击了哪一个",""+position+":"+cids[position]+":"+data.get(position));
//                Intent intent = new Intent(CityActivity.this,CountryActivity.class);
//                intent.putExtra("cid",cids[position]);
//                intent.putExtra("pid",pid);
//                startActivity(intent);
//            }
//        });
//        String weatherUrl = "http://guolin.tech/api/china/"+pid;
//        com.example.admin.helloworld1.HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
//
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
//                parseJSONObject(responseText);
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
//            }
//        });
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
//                this.cids[i] = jsonObject.getInt("id");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//}
