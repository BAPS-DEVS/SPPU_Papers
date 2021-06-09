package com.sppupapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> compSecondYearArray = new ArrayList<String>();          //comp
    final ArrayList<String> compThirdYearArray = new ArrayList<String>();
    final ArrayList<String> compFourthYearArray = new ArrayList<String>();
    final ArrayList<String> entcSecondYearArray = new ArrayList<String>();          //entc
    final ArrayList<String> entcThirdYearArray = new ArrayList<String>();
    final ArrayList<String> entcFourthYearArray = new ArrayList<String>();
    final ArrayList<String> itSecondYearArray = new ArrayList<String>();            //it
    final ArrayList<String> itThirdYearArray = new ArrayList<String>();
    final ArrayList<String> itFourthYearArray = new ArrayList<String>();
    final ArrayList<String> elecSecondYearArray = new ArrayList<String>();          //elec
    final ArrayList<String> elecThirdYearArray = new ArrayList<String>();
    final ArrayList<String> elecFourthYearArray = new ArrayList<String>();
    final ArrayList<String> mechSecondYearArray = new ArrayList<String>();          //mech
    final ArrayList<String> mechThirdYearArray = new ArrayList<String>();
    final ArrayList<String> mechFourthYearArray = new ArrayList<String>();
    final ArrayList<String> firstYear2015Array = new ArrayList<String>();           //firstYear
    final ArrayList<String> firstYear2019Array = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to make action bar disappear.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //shows no text in the action bar

        //ID's
        final ImageButton compImageButton = (ImageButton)findViewById(R.id.compImage);
        final ImageButton entcImageButton = (ImageButton)findViewById(R.id.entcImage);
        final ImageButton itImageButton = (ImageButton)findViewById(R.id.itImage);
        final ImageButton elecImageButton = (ImageButton)findViewById(R.id.elecImage);
        final ImageButton mechImageButton = (ImageButton)findViewById(R.id.mechImage);
        final ImageButton firstyearImageButton = (ImageButton)findViewById(R.id.firstyearimage);
        //back_dim_layout = (RelativeLayout) findViewById(R.id.share_bac_dim_layout);

        //Computer

        compImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   WindowManager.LayoutParams windowManager = getWindow().getAttributes();
                                                   ((WindowManager.LayoutParams) windowManager).dimAmount = 0.90f;
                                                   getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, compImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   compSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("comp2",compSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   compThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("comp3",compThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   compFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("comp4",compFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }


                                                       }
                                                   });

                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //ENTC

        entcImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, entcImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   entcSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("entc2",entcSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   entcThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("entc3",entcThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   entcFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("entc4",entcFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //IT

        itImageButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 //Creating the instance of PopupMenu
                                                 PopupMenu popup = new PopupMenu(MainActivity.this, itImageButton);
                                                 //Inflating the Popup using xml file
                                                 popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                 //registering popup with OnMenuItemClickListener
                                                 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                     public boolean onMenuItemClick(MenuItem item) {
                                                         switch (item.getItemId()) {
                                                             case R.id.second:
                                                                 itSecondYearSubjects();
                                                                 Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent.putExtra("it2",itSecondYearArray);
                                                                 startActivity(intent);
                                                                 return true;
                                                             case R.id.third:
                                                                 itThirdYearSubjects();
                                                                 Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent1.putExtra("it3",itThirdYearArray);
                                                                 startActivity(intent1);
                                                                 return true;
                                                             case R.id.fourth:
                                                                 itFourthYearSubjects();
                                                                 Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                 intent2.putExtra("it4",itFourthYearArray);
                                                                 startActivity(intent2);
                                                                 return true;
                                                             default:
                                                                 return false;
                                                         }
                                                     }
                                                 });
                                                 popup.show();//showing popup menu
                                             }
                                         }
        );

        //Electrical

        elecImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, elecImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   elecSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("elec2",elecSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   elecThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("elec3", elecThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   elecFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("elec4",elecFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //Mechanical

        mechImageButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   //Creating the instance of PopupMenu
                                                   PopupMenu popup = new PopupMenu(MainActivity.this, mechImageButton);
                                                   //Inflating the Popup using xml file
                                                   popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                                                   //registering popup with OnMenuItemClickListener
                                                   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                       public boolean onMenuItemClick(MenuItem item) {
                                                           switch (item.getItemId()) {
                                                               case R.id.second:
                                                                   mechSecondYearSubjects();
                                                                   Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent.putExtra("mech2",mechSecondYearArray);
                                                                   startActivity(intent);
                                                                   return true;
                                                               case R.id.third:
                                                                   mechThirdYearSubjects();
                                                                   Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent1.putExtra("mech3",mechThirdYearArray);
                                                                   startActivity(intent1);
                                                                   return true;
                                                               case R.id.fourth:
                                                                   mechFourthYearSubjects();
                                                                   Intent intent2=new Intent(getApplicationContext(), BranchDetails.class);
                                                                   intent2.putExtra("mech4",mechFourthYearArray);
                                                                   startActivity(intent2);
                                                                   return true;
                                                               default:
                                                                   return false;
                                                           }
                                                       }
                                                   });
                                                   popup.show();//showing popup menu
                                               }
                                           }
        );

        //FirstYear
        firstyearImageButton.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        //Creating the instance of PopupMenu
                                                        PopupMenu popup = new PopupMenu(MainActivity.this, firstyearImageButton);
                                                        //Inflating the Popup using xml file
                                                        popup.getMenuInflater().inflate(R.menu.popup_menu_fe, popup.getMenu());
                                                        //registering popup with OnMenuItemClickListener
                                                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                            public boolean onMenuItemClick(MenuItem item) {
                                                                switch (item.getItemId()) {
                                                                    case R.id.fe2015:
                                                                        firstYear2015Subjects();
                                                                        Intent intent=new Intent(getApplicationContext(), BranchDetails.class);
                                                                        intent.putExtra("fe15",firstYear2015Array);
                                                                        startActivity(intent);
                                                                        return true;
                                                                    case R.id.fe2019:
                                                                        firstYear2019Subjects();
                                                                        Intent intent1=new Intent(getApplicationContext(), BranchDetails.class);
                                                                        intent1.putExtra("fe19",firstYear2019Array);
                                                                        startActivity(intent1);
                                                                        return true;
                                                                    default:
                                                                        return false;
                                                                }
                                                            }
                                                        });
                                                        popup.show();//showing popup menu
                                                    }
                                                }
        );


    };
//COMP SUBJECTS

    public void compSecondYearSubjects() {
        compSecondYearArray.clear();
        compSecondYearArray.add("Discrete Mathematics (DM)");
        compSecondYearArray.add("Digital Electronics and Logic Design (DELD)");
        compSecondYearArray.add("Data Structures and Algorithms (DSA)");
        compSecondYearArray.add("Computer Organization and Architecture ( COA)");
        compSecondYearArray.add("Object Oriented Programming (OOP)");
        compSecondYearArray.add("Engineering Mathematics III (M3)");
        compSecondYearArray.add("Computer Graphics (CG)");
        compSecondYearArray.add("Advanced Data Structures (ADS)");
        compSecondYearArray.add("Microprocessor (MP)");
        compSecondYearArray.add("Principles of Programming Languages (PPL)");
    }
    public void compThirdYearSubjects() {
        compThirdYearArray.clear();
        compThirdYearArray.add("Theory of Computation (TOC)");
        compThirdYearArray.add("Database Management Systems (DBMS)");
        compThirdYearArray.add("Software Engg & Project Management (SEPM)");
        compThirdYearArray.add("Information Systems & Engg Economics (ISEE)");
        compThirdYearArray.add("Computer Network (CN)");
        compThirdYearArray.add("Design & Analysis of Algorithm (DAA)");
        compThirdYearArray.add("Systems Prog & Operating System (SPOS)");
        compThirdYearArray.add("Embedded System & Internet Things (ESIT)");
        compThirdYearArray.add("Software Modeling & Design (SMD)");
        compThirdYearArray.add("Web Technology (WT)");
    }
    public void compFourthYearSubjects() {
        compFourthYearArray.clear();
        compFourthYearArray.add("High Performance Computing (HPC)");
        compFourthYearArray.add("Artificial Intelligence & Robotics (AIR)");
        compFourthYearArray.add("Data Analytics (DA)");
        compFourthYearArray.add("Data Mining & Warehousing (DMW)");
        compFourthYearArray.add("Software Testing & Quality Assurance (STQA)");
        compFourthYearArray.add("Machine Learning (ML)");
        compFourthYearArray.add("Information & Cyber Security (ICS)");
        compFourthYearArray.add("Embedded & RTO System (ERTOS)");
        compFourthYearArray.add("Cloud Computing (CC)");
    }


//ENTC SUBJECTS

    public void entcSecondYearSubjects() {
        entcSecondYearArray.clear();
        entcSecondYearArray.add("Signals and Systems (SS)");
        entcSecondYearArray.add("Electronic Devices and Circuits (EDC)");
        entcSecondYearArray.add("Electrical Circuits and Machines (ECM)");
        entcSecondYearArray.add("Data Structures and Algorithms (DSA)");
        entcSecondYearArray.add("Digital Electronics (DE)");
        entcSecondYearArray.add("Engineering Mathematics III (M3)");
        entcSecondYearArray.add("Integrated Circuits (IC)");
        entcSecondYearArray.add("Control Systems (CS)");
        entcSecondYearArray.add("Analog Communications (AC)");
        entcSecondYearArray.add("Object Oriented Programming (OOP)");
    }
    public void entcThirdYearSubjects() {
        entcThirdYearArray.clear();
        entcThirdYearArray.add("Digital Communications (DC)");
        entcThirdYearArray.add("Digital Signal Processing (DSP)");
        entcThirdYearArray.add("Electromagnetics (EM)");
        entcThirdYearArray.add("MicroControllers (MC)");
        entcThirdYearArray.add("Mechatronics (MT)");
        entcThirdYearArray.add("Power Electronics (PE)");
        entcThirdYearArray.add("Info Theory, Coding & Computer Networks (ITCCN)");
        entcThirdYearArray.add("Business Management (BM)");
        entcThirdYearArray.add("Advanced Processors (AP)");
        entcThirdYearArray.add("System Programming & Operating System (SPOS)");
    }
    public void entcFourthYearSubjects(){
        entcFourthYearArray.clear();
        entcFourthYearArray.add("Computer Networks & Security (CNS)");
        entcFourthYearArray.add("Embedded System & RTOS (ESRTOS)");
        entcFourthYearArray.add("Internet of Things (IOT)");
        entcFourthYearArray.add("Electronics Product Design (EPD)");
        entcFourthYearArray.add("Radiation & Microwave Techniques (RMT)");
        entcFourthYearArray.add("VLSI Design & Technology (VLSIDT)");
        entcFourthYearArray.add("Audio Video Engineering (AVE)");
        entcFourthYearArray.add("Wireless Sensor Networks (WSN)");
        entcFourthYearArray.add("Mobile Communications (MC)");
        entcFourthYearArray.add("BroadBand Communication Systems (BCS)");
    }

//IT SUBJECTS

    public void itSecondYearSubjects() {
        itSecondYearArray.clear();
        itSecondYearArray.add("Discrete Structures (DS)");
        itSecondYearArray.add("Computer Organization and Architecture (COA)");
        itSecondYearArray.add("Digital Electronics and Logic Design (DELD)");
        itSecondYearArray.add("Fundamentals of Data Structures (FDS)");
        itSecondYearArray.add("Problem Solving & Object Oriented Prog Concepts (PSOOP)");
        itSecondYearArray.add("Engineering Mathematics III (M3)");
        itSecondYearArray.add("Computer Graphics (CG)");
        itSecondYearArray.add("Processor Architecture and Interfacing (PAI)");
        itSecondYearArray.add("Data Structures and Files (DSF)");
        itSecondYearArray.add("Foundations of Communication & Computer Networks (FCCN)");
    }
    public void itThirdYearSubjects() {
        itThirdYearArray.clear();
        itThirdYearArray.add("Theory of Computation (TOC)");
        itThirdYearArray.add("Database Management Systems (DMS)");
        itThirdYearArray.add("Software Engg & Project Management (SEPM)");
        itThirdYearArray.add("Operating System (OS)");
        itThirdYearArray.add("Human Computer Interaction (HCI)");
        itThirdYearArray.add("Computer Network Technology (CNT)");
        itThirdYearArray.add("Systems Programming (SP)");
        itThirdYearArray.add("Design & Analysis of Algorithms (DAA)");
        itThirdYearArray.add("Cloud Computing (CC)");
        itThirdYearArray.add("Data Science & Big Data Analytics (DSBDA)");
    }
    public void itFourthYearSubjects() {
        itFourthYearArray.clear();
        itFourthYearArray.add("Information & Cyber Security (ICS)");
        itFourthYearArray.add("Machine Learning & Application (MLA)");
        itFourthYearArray.add("Software Design & Modelling (SDM)");
        itFourthYearArray.add("Business Analytics & Intelligence (BAI)");
        itFourthYearArray.add("Software Testing & Quality Assurance (STQA)");
        itFourthYearArray.add("Distributed Computing System (DCS)");
        itFourthYearArray.add("Ubiquitous Computing (UC)");
        itFourthYearArray.add("Information Storage & Retrieval (ISR)");
        itFourthYearArray.add("Social Media Analytics (SMA)");
    }


//ELEC SUBJECTS

    public void elecSecondYearSubjects() {
        elecSecondYearArray.clear();
        elecSecondYearArray.add("Power Generation Technology (PGT)");
        elecSecondYearArray.add("Engineering Mathematics III (M3)");
        elecSecondYearArray.add("Material Science (MS)");
        elecSecondYearArray.add("Analog & Digital Electronics (ADE)");
        elecSecondYearArray.add("Electrical Measurements & Instrumentation (EMI)");
        elecSecondYearArray.add("Power System-I (PS1)");
        elecSecondYearArray.add("Electrical Machines-I (EM1)");
        elecSecondYearArray.add("Network Analysis (NA)");
        elecSecondYearArray.add("Numerical Methods & Computer Prog (NMCP)");
        elecSecondYearArray.add("Fundamentals of MicroController & App (FMA)");
    }
    public void elecThirdYearSubjects(){
        elecThirdYearArray.clear();
        elecThirdYearArray.add("Industrial & Technology Management (ITM)");
        elecThirdYearArray.add("Advance MicroController & Its Applications (AMA)");
        elecThirdYearArray.add("Electrical Machines-II (EM2)");
        elecThirdYearArray.add("Power Electronics (PE)");
        elecThirdYearArray.add("Electrical Insta Maintenance & Testing (EIMT)");
        elecThirdYearArray.add("Power System-II (PS2)");
        elecThirdYearArray.add("Control System-I (CS1)");
        elecThirdYearArray.add("Utilisation of Electrical Energy (UEE)");
        elecThirdYearArray.add("Design of Electrical Machines (DEM)");
        elecThirdYearArray.add("Energy Audit & Management (EAM)");
    }
    public void elecFourthYearSubjects(){
        elecFourthYearArray.clear();
        elecFourthYearArray.add("Power System Opertion & Control (PSOC)");
        elecFourthYearArray.add("PLC & SCADA Applications (PLC)");
        elecFourthYearArray.add("Control System-II (CS2)");
        elecFourthYearArray.add("Power Quality (PQ)");
        elecFourthYearArray.add("EHV AC Transmission (EHVACT)");
        elecFourthYearArray.add("Electric & Hybrid Vehicles (EHV)");
        elecFourthYearArray.add("Switchgear & Protection (SP)");
        elecFourthYearArray.add("Power Electronics Controlled Drives (PECD)");
        elecFourthYearArray.add("High Voltage Engineering (HVE)");
        elecFourthYearArray.add("Smart Grid (SG)");
    }

//MECHANICAL SUBJECTS

    public void mechSecondYearSubjects() {
        mechSecondYearArray.clear();
        mechSecondYearArray.add("Engineering Mathematics III (M3)");
        mechSecondYearArray.add("Manufacturing Processes-I (MP1)");
        mechSecondYearArray.add("Thermodynamics (TD)");
        mechSecondYearArray.add("Material Science (MS)");
        mechSecondYearArray.add("Strength Of Materials (SM)");
        mechSecondYearArray.add("Fluid Mechanics (FM)");
        mechSecondYearArray.add("Theory of Machines-I (TOM1)");
        mechSecondYearArray.add("Engineering Metallurgy (EM)");
        mechSecondYearArray.add("Applied Thermodynamics (AP)");
        mechSecondYearArray.add("Electrical & Electronics Engineering (EEE)");
    }
    public void mechThirdYearSubjects() {
        mechThirdYearArray.clear();
        mechThirdYearArray.add("Design of Machine Elements-I (DME1)");
        mechThirdYearArray.add("Heat Transfer (HT)");
        mechThirdYearArray.add("Theory of Machines-II (TOM2)");
        mechThirdYearArray.add("Turbo Machines (TM)");
        mechThirdYearArray.add("Metrology & Quality Control (MQC)");
        mechThirdYearArray.add("Numerical Methods & Optimisation (NMO)");
        mechThirdYearArray.add("Design of Machine Elements-II (DME2)");
        mechThirdYearArray.add("Refrigeration & Air Condition (RAC)");
        mechThirdYearArray.add("Mechatronics (MT)");
        mechThirdYearArray.add("Manufacturing Processes-II (MP2)");
    }
    public void mechFourthYearSubjects() {
        mechFourthYearArray.clear();
        mechFourthYearArray.add("Hydraulics & Pneumatics (HP)");
        mechFourthYearArray.add("CAD, CAM & Automation (CADCAM)");
        mechFourthYearArray.add("Dynamics of Machinery (DM)");
        mechFourthYearArray.add("Finite Element Analysis (FEA)");
        mechFourthYearArray.add("Heating, Ventilation & Air Condition (HVAC)");
        mechFourthYearArray.add("Energy Audit Management (EAM)");
        mechFourthYearArray.add("Automobile Engineering (AE)");
        mechFourthYearArray.add("Operation Research (OR)");
        mechFourthYearArray.add("Energy Engineering (EE)");
        mechFourthYearArray.add("Mechanical System Design (MSD)");
        mechFourthYearArray.add("Industrial Engineering (IE)");
        mechFourthYearArray.add("Solar & Wind Energy (SWE)");
        mechFourthYearArray.add("Product Design & Development (PDD)");
        mechFourthYearArray.add("Advanced Manufacturing Processes (AMP)");
        mechFourthYearArray.add("Refrigeration & Air Conditioning (RAC)");
    }

    public void firstYear2015Subjects(){
        firstYear2015Array.clear();
        firstYear2015Array.add("Basic Civil & Environmental Engineering (BCEE)");
        firstYear2015Array.add("Basic Electrical Engineering (BEE)");
        firstYear2015Array.add("Basic Electronics Engineering (BXE)");
        firstYear2015Array.add("Basic Mechanical Engineering (BME)");
        firstYear2015Array.add("Engineering Mathematics-I (M1)");
        firstYear2015Array.add("Engineering Mathematics-II (M2)");
        firstYear2015Array.add("Engineering Physics (EP)");
        firstYear2015Array.add("Engineering Chemistry (EC)");
        firstYear2015Array.add("Engineering Mechanics (EM)");
        firstYear2015Array.add("Engineering Graphics (EG)");
    }
    public void firstYear2019Subjects(){
        firstYear2019Array.clear();
        firstYear2019Array.add("Engineering Mathematics-I (M1)");
        firstYear2019Array.add("Engineering Physics (EP)");
        firstYear2019Array.add("Engineering Chemistry (EC)");
        firstYear2019Array.add("Systems in Mechanical Engineering (SME)");
        firstYear2019Array.add("Basic Electrical Engineering (BEE)");
        firstYear2019Array.add("Basic Electronics Engineering (BXE)");
        firstYear2019Array.add("Programming & Problem Solving (PPS)");
        firstYear2019Array.add("Engineering Mechanics (EM)");
        firstYear2019Array.add("Engineering Mathematics-II (M2)");
    }
}
