package com.example.hp.adjonline;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

public class Viewer extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ListData> data;
    Adapter  mAdapter;
    AdvanceSearch ad;
    Toolbar toolbar;
    JSONObject mjsonobject;
    JSONArray mjsonarr;
    String link;
    ImageButton filterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        recyclerView = findViewById(R.id.viewerid);
        filterButton=findViewById(R.id.filterButton);
        toolbar = (Toolbar) findViewById(R.id.result);
        data = new ArrayList<>();
        toolbar.setTitle("Document");
        toolbar.setTitleTextAppearance(this, R.style.amaticboldColor);
        setSupportActionBar(toolbar);

        final TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Search Results");
        mTitle.setGravity(Gravity.NO_GRAVITY);
        mTitle.setTextColor(Color.BLACK);
        toolbar.setBackgroundColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (getIntent().hasExtra(CitationSearch.CITATION)) {
            String res = getIntent().getStringExtra(CitationSearch.CITATION);
            filterButton.setVisibility(View.GONE);
            try {
                Log.d(TAG, "onCreate: ddsdsdsdsdsdsds " + res);
                JSONArray jArray = new JSONArray(res);
                String t1, t2, t3;

                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    t1 = json_data.getString("2");
                    t2 = json_data.getString("1");
                    t3 = json_data.getString("Citation No");
                    ListData listdata = new ListData(t1, t2, t3);
                    Log.d(TAG, "onPostExecute: pata ni qa problem hai");
                    Log.d(TAG, json_data.toString());
                    data.add(listdata);
                }
                // Setup and Handover data to recyclerview
                mAdapter = new Adapter(Viewer.this, data);
                recyclerView.setAdapter(mAdapter);
                //   mSwipeRefresh.setRefreshing(false);
//                RecyclerViewPositionHelper recyclerViewPositionHelper=new RecyclerViewPositionHelper(recyclerView);
//                recyclerViewPositionHelper.

            } catch (JSONException e) {
                // mSwipeRefresh.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "Please Check your Internet Connection and try again", Toast.LENGTH_LONG).show();
            }

        } else if (getIntent().hasExtra(DateSearch.DATESEARCH)) {
            String res = getIntent().getStringExtra(DateSearch.DATESEARCH);
            filterButton.setVisibility(View.GONE);
            try {
                Log.d(TAG, "onCreate: ddsdsdsdsdsdsds " + res);
                JSONArray jArray = new JSONArray(res);
                String t1, t2, t3;
                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    t1 = json_data.getString("2");
                    t2 = json_data.getString("1");
                    t3 = json_data.getString("Citation No");
                    ListData listdata = new ListData(t1, t2, t3);
                    Log.d(TAG, "onPostExecute: pata ni qa problem hai");
                    Log.d(TAG, json_data.toString());
                    data.add(listdata);
                }
                // Setup and Handover data to recyclerview
                mAdapter = new Adapter(Viewer.this, data);
                recyclerView.setAdapter(mAdapter);
                //   mSwipeRefresh.setRefreshing(false);
//                RecyclerViewPositionHelper recyclerViewPositionHelper=new RecyclerViewPositionHelper(recyclerView);
//                recyclerViewPositionHelper.

            } catch (JSONException e) {
                // mSwipeRefresh.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "Please Check your Internet Connection and try again", Toast.LENGTH_LONG).show();
            }
        } else if (getIntent().hasExtra(PartySearch.PARTYSEARCH)) {
            String res = getIntent().getStringExtra(PartySearch.PARTYSEARCH);
            filterButton.setVisibility(View.GONE);
            try {
                Log.d(TAG, "onCreate: ddsdsdsdsdsdsds " + res);
                JSONArray jArray = new JSONArray(res);
                String t1, t2, t3;
                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    t1 = json_data.getString("2");
                    t2 = json_data.getString("1");
                    t3 = json_data.getString("Citation No");
                    ListData listdata = new ListData(t1, t2, t3);
                    Log.d(TAG, "onPostExecute: pata ni qa problem hai");
                    Log.d(TAG, json_data.toString());
                    data.add(listdata);
                }
                // Setup and Handover data to recyclerview
                mAdapter = new Adapter(Viewer.this, data);
                recyclerView.setAdapter(mAdapter);
                //   mSwipeRefresh.setRefreshing(false);
//                RecyclerViewPositionHelper recyclerViewPositionHelper=new RecyclerViewPositionHelper(recyclerView);
//                recyclerViewPositionHelper.

            } catch (JSONException e) {
                // mSwipeRefresh.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "Please Check your Internet Connection and try again", Toast.LENGTH_LONG).show();
            }

        } else if (getIntent().hasExtra("1")) {
            try {
                Log.d(TAG, "onCreate: ddsdsdsdsdsdsds " + AdvanceSearch.AdvSearchResult);
                JSONArray jArray = new JSONArray(AdvanceSearch.AdvSearchResult + "\"" + "}" + "]");
                String t1 = "x", t2, t3;
                Log.d(TAG, "onCreate: ddddddd are bhai bhai bhai");
                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject json_data = jArray.getJSONObject(i);
                    t1 = json_data.getString("2");
                    t2 = json_data.getString("1");
                    t3 = json_data.getString("Citation No");
                    ListData listdata = new ListData(t1, t2, t3);
                    Log.d(TAG, "onPostExecute: pata ni qa problem hai");
                    Log.d(TAG, json_data.toString());
                    data.add(listdata);
                }
                // Setup and Handover data to recyclerview
                mAdapter = new Adapter(Viewer.this, data);
                recyclerView.setAdapter(mAdapter);
                //   mSwipeRefresh.setRefreshing(false);
//                RecyclerViewPositionHelper recyclerViewPositionHelper=new RecyclerViewPositionHelper(recyclerView);
//                recyclerViewPositionHelper.

            } catch (JSONException e) {
                // mSwipeRefresh.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "Please Check your Internet Connection and try again", Toast.LENGTH_LONG).show();
            }
        }


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(Viewer.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intentBundle = new Intent(Viewer.this, activity_full_judgement.class);
                        try {
                            mjsonobject = mjsonarr.getJSONObject(position);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            link = mjsonobject.getString("link");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        intentBundle.putExtra("link", link);
                        //intentBundle.putStringArrayListExtra("dimension2", ((ArrayList) dimension2.get(position))); // Very Very Important To Understand //
                        startActivity(intentBundle);
                        //Toast.makeText(getContext(),"hi",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                        //  Toast.makeText(getContext(), dimension2.get(position).toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        );
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Viewer.this,AdvanceSearchFilter.class);
                i.putExtra("INPUTTEXT",getIntent().getStringExtra("INPUTTEXT"));
                startActivity(i);
            }
        });


    }}