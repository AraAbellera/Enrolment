package sg.edu.rp.c346.id22014114.enrolment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    AsyncHttpClient client;
    ArrayList<SingaporePolytechnic> al;
    ArrayAdapter<SingaporePolytechnic> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();
        al = new ArrayList<SingaporePolytechnic>();
        aa = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            int year;
            String type;
            int enrollment_count;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonObjResults = response.getJSONObject("result");
                    JSONArray  jsonArrRecord = jsonObjResults.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecord.length(); i++) {
                        JSONObject jsonObjYear = jsonArrRecord.getJSONObject(i);
                        year = jsonObjYear.getInt("year");
                        type = jsonObjYear.getString("type_of_study");
                        enrollment_count = jsonObjYear.getInt("enrolment");
                        SingaporePolytechnic sp = new SingaporePolytechnic(year, type, enrollment_count);
                        al.add(sp);
                    }
                    aa.notifyDataSetChanged();
                }
                catch(JSONException e){
                }
            }
        });
    }

}