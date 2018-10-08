package bd.gov.teachers.teacherportal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import bd.gov.teachers.teacherportal.RestClient;
import cz.msebera.android.httpclient.Header;


public class ProfileActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://192.168.1.2/profile.json";

    private static RestClient client = new RestClient();
    private ListView listView;
    private JSONArray jsonArray;
    public ProfileAdapter profileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        renderPofileData();
        listView = (ListView) findViewById(R.id.listView);
        profileAdapter = new ProfileAdapter(this, R.layout.activity_profile_row);
        listView.setAdapter(profileAdapter);
    }

    public  void renderPofileData() {
        client.setEndPoint(BASE_URL).setUrl(null);
        client.get(null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                try {
                    jsonArray = jsonObject.getJSONArray("profile");
                    int count = 0;
                    String name, email;
                    while (count < jsonArray.length()){
                        JSONObject Jo = jsonArray.getJSONObject(count);
                        Log.d("JSON",Jo.getString("name"));
                        Log.d("JSON",Jo.getString("email"));
                        name =  Jo.getString("name");
                        email = Jo.getString("email");
                        Profile profile = new Profile(name,email);
                        profileAdapter.add(profile);
                        count++;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

}
