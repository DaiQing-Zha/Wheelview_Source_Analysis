package lvbu.wang.wheelview_source_analysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import lvbu.wang.wheelview_source_analysis.widgets.CommonWheelDialog;

public class MainActivity extends AppCompatActivity {

    private Button btn_showDialog;
    private CommonWheelDialog commonWheelDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_showDialog = (Button) findViewById(R.id.btn_showDialog);
        btn_showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String[] items = { "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200" };
                int index = 0;
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < items.length; i ++){

                    arrayList.add(items[i]);
                }
                commonWheelDialog = new CommonWheelDialog(
                        MainActivity.this,arrayList,"修改载重","kg");
                commonWheelDialog.setInitData(index);
                commonWheelDialog.show();
                commonWheelDialog.setDataListener(new CommonWheelDialog.OnDataListener() {
                    @Override
                    public void onClick(String year, final int position) {

                    }
                });
            }
        });
    }
}
