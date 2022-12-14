package com.college.stringsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.college.stringsapp.util.MyFileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/*
    Display the list of Secret Agents in the list view
    All the layout has been done for you.
    You only need to modify the onCreate() method in MainActivity.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Read all the agents in the ArrayList
        ArrayList<SecretAgent> allMyAgents;

        //Define and create the adapter and the listview

    }


    // Deserialize a list of states from a file in JSON format
    public ArrayList<SecretAgent> readData(String fileName){

        final ArrayList<SecretAgent> mylist = new ArrayList<>();

        try {
            // load the data in an ArrayList
            String jsonString     = MyFileReader.readJson(this, fileName);
            JSONObject json       = new JSONObject(jsonString);
            JSONArray items       = json.getJSONArray("squadmembers");

            // Loop through the list in the json array
            for(int i = 0; i < items.length(); i++){
                String name = items.getJSONObject(i).getString("name");
                int age = items.getJSONObject(i).getInt ("age");
                String si = items.getJSONObject(i).getString("secretIdentity");
                SecretAgent sa = new SecretAgent(name, age, si);
                mylist.add(sa);
            }
        } catch (JSONException e) {
            // Log the error
            e.printStackTrace();
        }
        return mylist;
    }
}