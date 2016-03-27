package pcode.com.wajbatt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MasterFoodView extends CustomClass {
    private MasterListviewAdapter mLV_Adapter ;
    private  ItemModel set_get_ModelData ;
    private List<ItemModel> arr_masterFood  = new ArrayList<ItemModel>();
    private RelativeLayout masterRoot;
public  void  masterViewAction_addNewFood(View btn_Add){
    startActivity(new Intent(MasterFoodView.this, Add_new_Food.class));
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_food_view);


        set_get_ModelData  = new ItemModel();
        arr_masterFood.clear();

        for (int i = 0 ; i < 10 ; i ++) {
            ItemModel tempModel = new ItemModel();
            tempModel.setFoodID("id = "  + i);
            tempModel.setFoodName("Name : " + i);
            tempModel.setFoodPrice("Price : " + i * 2);
            arr_masterFood.add(tempModel);
        }


        ListView master_listView = (ListView)findViewById(R.id.masterView_listView);
        mLV_Adapter =  new MasterListviewAdapter();
        master_listView.setAdapter(mLV_Adapter);


        masterRoot = (RelativeLayout) findViewById(R.id.relativeLayout_foodMasterView);

    }


    private class MasterListviewAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arr_masterFood.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arr_masterFood.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            // TODO:  DidSelectItem
            Toast.makeText(MasterFoodView.this, "" + arg0, Toast.LENGTH_LONG).show();
            DetialView detialV = new DetialView();
            detialV.addDetialView(arg0);
            return arg0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            // TODO Auto-generated method stub
            set_get_ModelData =  arr_masterFood.get(position);
            if(inflater ==null)
                inflater=(LayoutInflater)getLayoutInflater();
            if(view==null)
                view=inflater.inflate(R.layout.custom_master_food_list_view, null);

            TextView textview_foodName =(TextView)view.findViewById(R.id.custom_MasterView_lbl_foodName);
            textview_foodName.setText(set_get_ModelData.getFoodName());

            TextView textview_foodType =(TextView)view.findViewById(R.id.custom_MasterView_lbl_foodType);
            textview_foodType.setText(set_get_ModelData.getFoodPrice());


            return view;
        }


    }


    private class ItemModel {
        private String str_food_id, str_food_name , str_food_price , str_food_img;
        public String getFoodName() {return str_food_name;}
        public void setFoodName(String name) {
            this.str_food_name = name;
        }
        public String getFoodID() {
            return str_food_id;
        }
        public void setFoodID(String did) {
            this.str_food_id = did;
        }
        public String getFoodPrice() { return str_food_price;}
        public void setFoodPrice(String price) {this.str_food_price = price;}
    }

    private class DetialView  {
        public void addDetialView(int postion){
            View child_details = getLayoutInflater().inflate(R.layout.master_view_details, null);
            masterRoot.addView(child_details);


    }
    }
}
