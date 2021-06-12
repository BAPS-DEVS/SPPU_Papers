package com.sppupapers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.HashMap;

public class BranchDetails extends AppCompatActivity {

    HashMap<Integer, String> innerMap = new HashMap<Integer, String>(); // Subject data
    HashMap<String, HashMap<Integer, String>> outerMap = new HashMap<>(); // Paper and corresponding links
    String branchName = "";

    Integer position;
    int pos;
    String[] compSecondSubs = {"DM", "DELD", "DSA", "COA", "OOP", "M3", "CG", "ADS", "MP", "PPL"};
    String[] compSecondMcqs = {"DM_MCQS", "DELD_MCQS", "DSA_MCQS", "COA_MCQS", "OOP_MCQS", "M3_MCQS", "CG_MCQS", "ADS_MCQS", "MP_MCQS", "PPL_MCQS"};
    String[] compThirdSubs = {"TOC", "DBMS", "SEPM", "ISEE", "CN", "DAA", "SPOS", "ESIT", "SMD", "WT"};
    String[] compThirdMcqs = {"TOC_MCQS", "DBMS_MCQS", "SEPM_MCQS", "ISEE_MCQS", "CN_MCQS", "DAA_MCQS", "SPOS_MCQS", "ESIT_MCQS", "SMD_MCQS", "WT_MCQS"};
    String[] compFourthSubs = {"HPC", "AIR", "DA", "DMW", "STQA", "ML", "ICS", "ERS", "CC"};
    String[] compFourthMcqs = {"HPC_MCQS", "AIR_MCQS", "DA_MCQS", "DMW_MCQS", "STQA_MCQS", "ML_MCQS", "ICS_MCQS", "ERS_MCQS", "CC_MCQS"};


    String[] entcSecondSubs = {"SS", "EDC", "ECM", "DSAENTC", "DE", "M3ENTC", "IC", "CS", "AC", "OOPENTC"};
    String[] entcThirdSubs = {"DC", "DSP", "EM", "MC", "MTENTC", "PEENTC", "ITCCN", "BM", "AP", "SPOSENTC"};
    String[] entcFouthSubs = {"CNS", "ESRTOS", "IOT", "EPD", "RMT", "VLSI", "AVE", "WSN", "MoC", "BCS"};
    String[] entcSecondMcqs = {"SS_MCQS", "EDC_MCQS", "ECM_MCQS", "DSAENTC_MCQS", "DE_MCQS", "M3ENTC_MCQS", "IC_MCQS", "CS_MCQS", "AC_MCQS", "OOPENTC_MCQS"};
    String[] entcThirdMcqs = {"DC_MCQS", "DSP_MCQS", "EM_MCQS", "MC_MCQS", "MTENTC_MCQS", "PEENTC_MCQS", "ITCCN_MCQS", "BM_MCQS", "AP_MCQS", "SPOSENTC_MCQS"};
    String[] entcFouthmcqs = {"CNS_MCQS", "ESRTOS_MCQS", "IOT_MCQS", "EPD_MCQS", "RMT_MCQS", "VLSI_MCQS", "AVE_MCQS", "WSN_MCQS", "MoC_MCQS", "BCS_MCQS"};

    String[] itSecondSubs = {"DS", "COAIT", "DELDIT", "FDA", "PSOOP", "M3IT", "CGIT", "PAI", "DSF", "FCCN"};
    String[] itThirdSubs = {"TOCIT", "DBMSIT", "SEPMIT", "OS", "HCI", "CNT", "SP", "DAAIT", "CCIT", "DSBDA"};
    String[] itFouthSubs = {"ICSIT", "MLA", "SDM", "BAI", "STQAIT", "DCS", "UC", "ISR", "SMA"};
    String[] itSecondMcqs = {"DS_MCQS", "COAIT_MCQS", "DELDIT_MCQS", "FDA_MCQS", "PSOOP_MCQS", "M3IT_MCQS", "CGIT_MCQS", "PAI_MCQS", "DSF_MCQS", "FCCN_MCQS"};
    String[] itThirdMcqs = {"TOCIT_MCQS", "DBMSIT_MCQS", "SEPMIT_MCQS", "OS_MCQS", "HCI_MCQS", "CNT_MCQS", "SP_MCQS", "DAAIT_MCQS", "CCIT_MCQS", "DSBDA_MCQS"};
    String[] itFouthMcqs = {"ICSIT_MCQS", "MLA_MCQS", "SDM_MCQS", "BAI_MCQS", "STQAIT_MCQS", "DCS_MCQS", "UC_MCQS", "ISR_MCQS", "SMA_MCQS"};

    String[] mechSecondSubs = {"M3MECH", "MP1", "TD", "MS", "SOM", "FM", "TOM1", "EMT", "AT", "EEE"};
    String[] mechThirdSubs = {"DME1", "HT", "TOM2", "TM", "MQC", "NMO", "DME2", "RAC", "MT", "MP2"};
    String[] mechFouthSubs = {"HP", "CADCAM", "DMMECH", "FEA", "HVAC", "EAM", "AE", "OR", "EE", "MSD", "IE", "SWE", "PDD", "AMP", "RAC4"};  // NEED TO CREATE EXTRA LIST. . .
    String[] mechSecondMcqs = {"M3MECH_MCQS", "MP1_MCQS", "TD_MCQS", "MS_MCQS", "SOM_MCQS", "FM_MCQS", "TOM1_MCQS", "EMT_MCQS", "AT_MCQS", "EEE_MCQS"};
    String[] mechThirdMcqs = {"DME1_MCQS", "HT_MCQS", "TOM2_MCQS", "TM_MCQS", "MQC_MCQS", "NMO_MCQS", "DME2_MCQS", "RAC_MCQS", "MT_MCQS", "MP2_MCQS"};
    String[] mechFouthMcqs = {"HP_MCQS", "CADCAM_MCQS", "DMMECH_MCQS", "FEA_MCQS", "HVAC_MCQS", "EAM_MCQS", "AE_MCQS", "OR_MCQS", "EE_MCQS", "MSD_MCQS", "IE_MCQS", "SWE_MCQS", "PDD_MCQS", "AMP_MCQS", "RAC4_MCQS"};

    String[] electricalSecondSubs = {"PGT", "M3ELEC", "MSELEC", "ADE", "EMI", "PS1", "EM1", "NA", "NMCP", "FMA"};
    String[] electricalThirdSubs = {"ITM", "AMA", "EM2", "PE", "EIMT", "PS2", "CS1", "UEE", "DEM", "EAMELEC"};
    String[] electricalFouthSubs = {"PSOC", "PLC", "CS2", "PQ", "EHVACT", "EHV", "SPELEC", "PECD", "HVE", "SG"};
    String[] electricalSecondMcqs = {"PGT_MCQS", "M3ELEC_MCQS", "MSELEC_MCQS", "ADE_MCQS", "EMI_MCQS", "PS1_MCQS", "EM1_MCQS", "NA_MCQS", "NMCP_MCQS", "FMA_MCQS"};
    String[] electricalThirdMcqs = {"ITM_MCQS", "AMA_MCQS", "EM2_MCQS", "PE_MCQS", "EIMT_MCQS", "PS2_MCQS", "CS1_MCQS", "UEE_MCQS", "DEM_MCQS", "EAMELEC_MCQS"};
    String[] electricalFouthMcqs = {"PSOC_MCQS", "PLC_MCQS", "CS2_MCQS", "PQ_MCQS", "EHVACT_MCQS", "EHV_MCQS", "SPELEC_MCQS", "PECD_MCQS", "HVE_MCQS", "SG_MCQS"};

    String[] fe2015Subs = {"BXE15", "BEE15", "BCEE15", "BME15", "M115", "M215", "EP15", "EM15", "EC15", "EG115"};
    String[] fe2019Subs = {"M119", "EP19", "EC19", "SME19", "BEE19", "BXE19", "PPS19", "EM19", "M219"};
    String[] fe2015Mcqs = {"BXE15_MCQS", "BEE15_MCQS", "BCEE15_MCQS", "BME15_MCQS", "M115_MCQS", "M215_MCQS", "EP15_MCQS", "EM15_MCQS", "EC15_MCQS", "EG115_MCQS"};
    String[] fe2019Mcqs = {"M119_MCQS", "EP19_MCQS", "EC19_MCQS", "SME19_MCQS", "BEE19_MCQS", "BXE19_MCQS", "PPS19_MCQS", "EM19_MCQS", "M219_MCQS"};

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to make action bar disappear.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_branch_details);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ListView listView = (ListView) findViewById(R.id.OurListView);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //TextView subTextView = (TextView) findViewById(R.id.toolbarBranch);

        Intent intent = getIntent();
        if (intent.hasExtra("comp2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);
            // subTextView.setText("Computer - SE");
            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compSecondSubs,compSecondMcqs, position);
                }
            });


        } else if (intent.hasExtra("comp3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compThirdSubs,compThirdMcqs, position);
                }
            });

        } else if (intent.hasExtra("comp4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("comp4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(compFourthSubs,compFourthMcqs, position);
                }
            });

        } else if (intent.hasExtra("entc2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcSecondSubs,entcSecondMcqs, position);
                }
            });

        } else if (intent.hasExtra("entc3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcThirdSubs,entcThirdMcqs, position);
                }
            });

        } else if (intent.hasExtra("entc4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("entc4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(entcFouthSubs,entcFouthmcqs, position);
                }
            });

        } else if (intent.hasExtra("it2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itSecondSubs,itSecondMcqs, position);
                }
            });

        } else if (intent.hasExtra("it3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itThirdSubs,itThirdMcqs, position);
                }
            });

        } else if (intent.hasExtra("it4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("it4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(itFouthSubs,itFouthMcqs, position);
                }
            });

        } else if (intent.hasExtra("elec2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalSecondSubs,electricalSecondMcqs, position);
                }
            });

        } else if (intent.hasExtra("elec3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalThirdSubs,electricalThirdMcqs, position);
                }
            });

        } else if (intent.hasExtra("elec4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("elec4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(electricalFouthSubs,electricalFouthMcqs, position);
                }
            });

        } else if (intent.hasExtra("mech2")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech2");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechSecondSubs, mechSecondMcqs, position);
                }
            });

        } else if (intent.hasExtra("mech3")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech3");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechThirdSubs,mechThirdMcqs,  position);
                }
            });

        } else if (intent.hasExtra("mech4")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("mech4");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(mechFouthSubs,mechFouthMcqs, position);
                }
            });

        } else if (intent.hasExtra("fe15")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("fe15");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(fe2015Subs, fe2015Mcqs, position);
                }
            });

        } else if (intent.hasExtra("fe19")) {
            ArrayList<String> branch = (ArrayList<String>) getIntent().getSerializableExtra("fe19");
            ArrayAdapter<String> transferList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);

            listView.setAdapter(transferList);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    compcase(fe2019Subs, fe2019Mcqs, position);
                }
            });

        } else {
            Toast.makeText(getApplicationContext(), "Unable to load....", Toast.LENGTH_SHORT).show();
        }

    }

    private void compcase(String[] yearSubArray,String[] yearSubArray1, int pos) {
        if (pos == 0) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            Intent intent2 = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub0", yearSubArray[0]);
            intent.putExtra("sub1.0", yearSubArray1[0]);
            startActivity(intent);
        } else if (pos == 1) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub1", yearSubArray[1]);
            intent.putExtra("sub1.1", yearSubArray1[1]);
            startActivity(intent);
        } else if (pos == 2) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub2", yearSubArray[2]);
            intent.putExtra("sub1.2", yearSubArray1[2]);
            startActivity(intent);
        } else if (pos == 3) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub3", yearSubArray[3]);
            intent.putExtra("sub1.3", yearSubArray1[3]);
            startActivity(intent);
        } else if (pos == 4) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub4", yearSubArray[4]);
            intent.putExtra("sub1.4", yearSubArray1[4]);
            startActivity(intent);
        } else if (pos == 5) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub5", yearSubArray[5]);
            intent.putExtra("sub1.5", yearSubArray1[5]);
            startActivity(intent);
        } else if (pos == 6) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub6", yearSubArray[6]);
            intent.putExtra("sub1.6", yearSubArray1[6]);
            startActivity(intent);
        } else if (pos == 7) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub7", yearSubArray[7]);
            intent.putExtra("sub1.7", yearSubArray1[7]);
            startActivity(intent);
        } else if (pos == 8) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub8", yearSubArray[8]);
            intent.putExtra("sub1.8", yearSubArray1[8]);
            startActivity(intent);
        } else if (pos == 9) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub9", yearSubArray[9]);
            intent.putExtra("sub1.9", yearSubArray1[9]);
            startActivity(intent);
        } else if (pos == 10) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub10", yearSubArray[10]);
            intent.putExtra("sub1.10", yearSubArray1[10]);
            startActivity(intent);
        } else if (pos == 11) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub11", yearSubArray[11]);
            intent.putExtra("sub1.11", yearSubArray1[11]);
            startActivity(intent);
        } else if (pos == 12) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub12", yearSubArray[12]);
            intent.putExtra("sub1.12", yearSubArray1[12]);
            startActivity(intent);
        } else if (pos == 13) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub13", yearSubArray[13]);
            intent.putExtra("sub1.13", yearSubArray1[13]);
            startActivity(intent);
        } else if (pos == 14) {
            Intent intent = new Intent(getApplicationContext(), PaperDetailsTab.class);
            intent.putExtra("sub14", yearSubArray[14]);
            intent.putExtra("sub1.14", yearSubArray1[14]);
            startActivity(intent);
        }

    }
}
