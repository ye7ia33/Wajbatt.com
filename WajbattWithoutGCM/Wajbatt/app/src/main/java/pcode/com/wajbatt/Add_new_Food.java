package pcode.com.wajbatt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_new_Food extends CustomClass {
    /* @pragma new layout use to add new row */
    private LinearLayout newfood_customLayOut ;
    private ArrayList<View> arr_addnewFood_View ;


    public  void addNewFood_addCustomView (View v){
        arr_addnewFood_View.add(add_newFood_CustomView()) ;
        newfood_customLayOut.addView(  arr_addnewFood_View .get(arr_addnewFood_View.size() - 1));

    }public void  addNewFood_removeCustomView(View v){
        Toast.makeText(this , ">>>>>>>>> "+ arr_addnewFood_View.size() , Toast.LENGTH_LONG).show();
        if (arr_addnewFood_View.size() > 1){

    arr_addnewFood_View.remove(arr_addnewFood_View.size()-1);
    newfood_customLayOut.removeView(arr_addnewFood_View.get(arr_addnewFood_View.size()-1));
        }
    }
public  void addNewFood_DismissView (View btn_Diss){
    startActivity(new Intent(Add_new_Food.this, MasterFoodView.class));
    finish();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new__food);

        Button addnewFood_btn_add = (Button)findViewById(R.id.addNewFood_BtnADD);
        Button addnewFood_btn_remove = (Button)findViewById(R.id.addNewFood_BtnREMOVE);
        Button addnewFood_btn_Submit = (Button)findViewById(R.id.addNewFood_BtnSUBMIT);
        Button addnewFood_btn_Cancel = (Button)findViewById(R.id.addNewFood_BtnCANCEL);

        addnewFood_btn_add.   setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);
        addnewFood_btn_remove.setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);
        addnewFood_btn_Submit.setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);
        addnewFood_btn_Cancel.setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);

        arr_addnewFood_View = new ArrayList<View>();

        newfood_customLayOut  = (LinearLayout) findViewById(R.id.addnewfood_CustomLinearLayOut);

        arr_addnewFood_View.add(add_newFood_CustomView());
        newfood_customLayOut.addView(arr_addnewFood_View .get(arr_addnewFood_View.size() -1 ));

    }


}
