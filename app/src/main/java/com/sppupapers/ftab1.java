package com.sppupapers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ftab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab1 extends Fragment{


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ftab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab1.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab1 newInstance(String param1, String param2) {
        ftab1 fragment = new ftab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String stringPath = "";
    List<ViewModel> viewModelList;
    DatabaseReference dataBaseReference;
    MyAdapter adapter;
    RecyclerView rView;
    int clicked=0;
    String subName="";
    private AdView mAdView;
//    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_ftab1, container, false);

        rView = (RecyclerView) rootView.findViewById(R.id.recView);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModelList = new ArrayList<>();
        Intent intent = getActivity().getIntent();

        if (intent.hasExtra("sub0")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub0");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);


        }
        else if (intent.hasExtra("sub1")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub1");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub2")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub2");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub3")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub3");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub4")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub4");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub5")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub5");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub6")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub6");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub7")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub7");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub8")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub8");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub9")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub9");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub10")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub10");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub11")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub11");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub12")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub12");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub13")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub13");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub14")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub14");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else
        {
            Toast.makeText(getActivity(),"Loading...",Toast.LENGTH_LONG).show();
        }

//        return inflater.inflate(R.layout.fragment_ftab1, container, false);
            return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void getDataFromFireBase( String paperLink ){
        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(paperLink), ViewModel.class)
                        .build();
        String TAG = "TEST";

        Log.i(TAG,"inside function get data from firebase");
        adapter = new MyAdapter(options, getActivity(), viewModelList);
        rView.setAdapter(adapter);

//        adapter.notifyDataSetChanged();

    }

    private void getFireBaseList( String firebaseList ){
        viewModelList.clear();
        dataBaseReference = FirebaseDatabase.getInstance().getReference(firebaseList);

        dataBaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ViewModel viewModel = postSnapshot.getValue(ViewModel.class);
//                    ListPDF ListPdf = postSnapshot.getValue(ListPDF.class);
                    viewModelList.add(viewModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}