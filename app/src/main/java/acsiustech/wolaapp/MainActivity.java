package acsiustech.wolaapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import acsiustech.wolaapp.Cart.CartActivity;
import acsiustech.wolaapp.Categories.CategoryActivity;
import acsiustech.wolaapp.History.HistoryActivity;
import acsiustech.wolaapp.HomePageLink.ShopnowActivity;
import acsiustech.wolaapp.Lititon.LititonAdapter;
import acsiustech.wolaapp.Lititon.LititonModel;
import acsiustech.wolaapp.NewCollection.NewCollcAdapter;
import acsiustech.wolaapp.NewCollection.NewCollcModel;
import acsiustech.wolaapp.NewCollection.NewCollcetionActivity;
import acsiustech.wolaapp.WishList.WishlistActivity;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.banner11,R.drawable.banner22};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    List<NewCollcModel> productList;
    RecyclerView recyclerView;

    ImageButton wishlistbtn,searchbtn;
    RelativeLayout cartbtn;

    TextView newcllectxt;


    //for expandable drawer items

//    ExpandableListAdapter expandableListAdapter;
//    ExpandableListView expandableListView;
//    List<MenuModel> headerList = new ArrayList<>();
//    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();


    ImageView imgv;
    public static TextView logintxt,logntxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrolview);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        searchbtn=(ImageButton)findViewById(R.id.imgSrch);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });

        wishlistbtn=(ImageButton)findViewById(R.id.imgfav);
        wishlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WishlistActivity.class));
            }
        });

        cartbtn=(RelativeLayout) findViewById(R.id.CartRltv);
        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        newcllectxt=(TextView)findViewById(R.id.newcolc);
        newcllectxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NewCollcetionActivity.class));
            }
        });

        //logntxt=(TextView)findViewById(R.id.logouttxt);
//        logintxt=(TextView)findViewById(R.id.logintxt);
//        logintxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(MainActivity.this,LoginActivity.class));
//            }
//        });

//        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
//        expandableListDetail = ExpandableListDataPump.getData();
//        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
//        expandableListAdapter = new ExpandableListAdapter11(this, expandableListTitle, expandableListDetail);
//        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Collapsed.",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        expandableListTitle.get(groupPosition)
//                                + " -> "
//                                + expandableListDetail.get(
//                                expandableListTitle.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT
//                ).show();
//                return false;
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



       //for expandable drawer items

//        expandableListView = findViewById(R.id.list_slidermenu);
//        prepareMenuData();
//        populateExpandableList();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorBlack));
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
       // navMenuView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

        productList = new ArrayList<>();

        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));
        productList.add(new NewCollcModel("$","140.02",R.drawable.lounge_chair,"Kyodo Swing Chair with stand",
                "50% off"));

        NewCollcAdapter adapter = new NewCollcAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        init();
    }

    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        // Auto image change

//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 3000, 3000);



//       mPager.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//               startActivity(new Intent(MainActivity.this, ShopnowActivity.class));
//
//           }
//       });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement

//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_category) {
            startActivity(new Intent(MainActivity.this,CategoryActivity.class));
        }
        else if (id == R.id.nav_aboutus) {

            startActivity(new Intent(MainActivity.this,AboutUsActivity.class));

        } else if (id == R.id.nav_cart) {

            startActivity(new Intent(MainActivity.this,CartActivity.class));

        }
        if (id == R.id.nav_history) {

            startActivity(new Intent(MainActivity.this, HistoryActivity.class));

        }
        if (id == R.id.nav_contact) {

            startActivity(new Intent(MainActivity.this,ContactUsActivity.class));

        }
        if (id == R.id.nav_login) {

            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void prepareMenuData() {
//
//        MenuModel menuModel = new MenuModel("BRANDS", true, true); //Menu of Java Tutorials
//        headerList.add(menuModel);
//        List<MenuModel> childModelsList = new ArrayList<>();
//        MenuModel childModel = new MenuModel("LITITON", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("WALLOWIN", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("PAPA", false, false);
//        childModelsList.add(childModel);
//        childModel = new MenuModel("HOME WORKERS", false, false);
//        childModelsList.add(childModel);
//        childModel = new MenuModel("COLLABORATIONS", false, false);
//        childModelsList.add(childModel);
//
//
//        if (menuModel.hasChildren) {
//            Log.d("API123","here");
//            childList.put(menuModel, childModelsList);
//        }
//
//        childModelsList = new ArrayList<>();
//        menuModel = new MenuModel("SCHEDULED BOOKING", true, true); //Menu of Python Tutorials
//        headerList.add(menuModel);
//        childModel = new MenuModel("EVENTS", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("MEETING ROOMS", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("COLLABSPOT", false, false);
//        childModelsList.add(childModel);
//
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//
//        childModelsList = new ArrayList<>();
//        menuModel = new MenuModel("MORE", true, true); //Menu of Python Tutorials
//        headerList.add(menuModel);
//        childModel = new MenuModel("PRIVACY POLICY", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("FAQ", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("CONTACT US", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("ABOUT US", false, false);
//        childModelsList.add(childModel);
//
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//
//        childModelsList = new ArrayList<>();
//        menuModel = new MenuModel("REFER & EARN", true, false); //Menu of Python Tutorials
//        headerList.add(menuModel);
//
////        childModelsList = new ArrayList<>();
////        menuModel = new MenuModel("Login", true, false); //Menu of Python Tutorials
////        headerList.add(menuModel);
//
////        childModel = new MenuModel("ITEM1", false, false);
////        childModelsList.add(childModel);
////
////        childModel = new MenuModel("Python Fractions", false, false);
////        childModelsList.add(childModel);
//
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
//
//    }
//
//    private void populateExpandableList() {
//
//        expandableListAdapter = new ExpandableListAdapter11(this, headerList, childList);
//        expandableListView.setAdapter(expandableListAdapter);
//
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//
////               if (groupPosition==4){
////                   startActivity(new Intent(MainActivity.this,LoginActivity.class));
////
////               }
//
////                ImageView imageView1=(ImageView)findViewById(R.id.arrow1);
////                ImageView imageView=(ImageView)findViewById(R.id.arrow);
////                imageView1.setVisibility(View.VISIBLE);
////                imageView.setVisibility(View.GONE);
//
//                if (headerList.get(groupPosition).isGroup) {
//                    if (!headerList.get(groupPosition).hasChildren) {
//
//                      //  imgv=(ImageView)findViewById(R.id.arrow);
//                       // imgv.setVisibility(View.VISIBLE);
//
//                       // WebView webView = findViewById(R.id.webView);
//                        //webView.loadUrl(headerList.get(groupPosition).url);
//                       // onBackPressed();
//                    }
//
//                }
//
//                return false;
//            }
//        });
//
//
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//                if (childList.get(headerList.get(groupPosition)) != null) {
//                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
//
//                    if(model.menuName.length()>0){
//                       if (model.menuName.equalsIgnoreCase("LITITON"))
//                       {
//                           startActivity(new Intent(MainActivity.this,LitionActivity.class));
//                       }
//                       else if (model.menuName.equalsIgnoreCase("WALLOWIN"))
//                       {
//                           startActivity(new Intent(MainActivity.this,WallowinaActivity.class));
//                       }
//                    }
//
////                    if (model.url.length() > 0) {
////                        WebView webView = findViewById(R.id.webView);
////                        webView.loadUrl(model.url);
////                        onBackPressed();
////                    }
//                }
//
//                return false;
//            }
//        });
//    }

}
