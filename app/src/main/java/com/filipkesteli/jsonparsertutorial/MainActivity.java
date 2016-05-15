package com.filipkesteli.jsonparsertutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private String strJSON;
    private String data;
    private JSONArray jsonArray;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupJSON();
    }

    private void initWidgets() {
        output = (TextView) findViewById(R.id.textView1);
        strJSON = "";
        data = "";
    }

    private void setupJSON() {
        try {
            jsonObject = new JSONObject(strJSON);

            //Get the instance of JSONArray that contains JSONObjects
            jsonArray = jsonObject.optJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());
                data += "Node" + i + ": \n id = " + id + "\n Name = " + name;
                output.setText(data);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
