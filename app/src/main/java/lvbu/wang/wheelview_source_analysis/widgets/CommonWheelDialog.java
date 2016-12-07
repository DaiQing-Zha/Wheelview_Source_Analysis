package lvbu.wang.wheelview_source_analysis.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import lvbu.wang.wheelview_source_analysis.R;
import lvbu.wang.wheelview_source_analysis.wheel.adapters.AbstractWheelTextAdapter;
import lvbu.wang.wheelview_source_analysis.wheel.views.OnWheelChangedListener;
import lvbu.wang.wheelview_source_analysis.wheel.views.OnWheelScrollListener;
import lvbu.wang.wheelview_source_analysis.wheel.views.WheelView;


/**
 * Created by DaiQing.Zha on 2016/7/1 0001.
 * Email:1642674371@qq.com
 * Description:自定义通用的滚轮对话框
 */
public class CommonWheelDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private WheelView wheelControl;
    private TextView btnSure;
    private TextView btnCancel;
    private TextView tv_title,tv_unitE;
    private CalendarTextAdapter mDataAdapter;
    private int maxTextSize = 24;
    private int minTextSize = 14;
    private String selectData;
    private OnDataListener OnDataListener;
    private String title,unitE;

    public CommonWheelDialog(Context context) {
        super(context, R.style.ShareDialog);
        this.context = context;
    }

    public CommonWheelDialog(Context context, ArrayList arrayData) {

        this(context);
        this.arrayData = arrayData;
    }

    public CommonWheelDialog(Context context, ArrayList arrayData, String title) {

        this(context,arrayData);
        this.title = title;
    }

    public CommonWheelDialog(Context context, ArrayList arrayData, String title, String unitE) {

        this(context,arrayData,title);
        this.unitE = unitE;
    }
    
    private int currentPosition = 0;
    private ArrayList<String> arrayData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_wheel);

        wheelControl = (WheelView) findViewById(R.id.wv_birth_year);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_unitE = (TextView) findViewById(R.id.tv_unitE);
        btnSure = (TextView) findViewById(R.id.btn_myinfo_sure);
        btnCancel = (TextView) findViewById(R.id.btn_myinfo_cancel);

        btnSure.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        if (title!= null && !"".equals(title)) tv_title.setText(title);
        if (unitE!= null && !"".equals(unitE)) tv_unitE.setText(unitE);
        mDataAdapter = new CalendarTextAdapter(context, arrayData, setinitPosition(), maxTextSize, minTextSize);
        wheelControl.setVisibleItems(5);
        wheelControl.setViewAdapter(mDataAdapter);
        wheelControl.setCurrentItem(setinitPosition());

        wheelControl.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mDataAdapter.getItemText(wheel.getCurrentItem());
                selectData = currentText;
                currentPosition = wheel.getCurrentItem();
                setTextviewSize(currentText, mDataAdapter);
            }
        });
        wheelControl.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {
            }
            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mDataAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mDataAdapter);
            }
        });
    }

    private class CalendarTextAdapter extends AbstractWheelTextAdapter {
        ArrayList<String> list;
        protected CalendarTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_dialog, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }
        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }
        @Override
        public int getItemsCount() {
            return list.size();
        }
        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }
    }

    public void setDataListener(OnDataListener OnDataListener) {
        this.OnDataListener = OnDataListener;
    }
    @Override
    public void onClick(View v) {

        if (v == btnSure) {
            if (OnDataListener != null) {
                OnDataListener.onClick(selectData,currentPosition);
            }
        } else if (v == btnCancel) {
        } else {
            dismiss();
        }
        dismiss();
    }

    /**
     * 点击事件监听器
     */
    public interface OnDataListener {
        public void onClick(String data, int position);
    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, CalendarTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(maxTextSize);
            } else {
                textvew.setTextSize(minTextSize);
            }
        }
    }
    /**
     * 设置初始数据
     * @param position 初始数据的选中位置
     */
    public void setInitData(int position){
        this.currentPosition = position;
        try {
            selectData = arrayData.get(currentPosition);
        }catch (Exception e){

            selectData = arrayData.get(0);
        }
    }
    /**
     * 设置初始位置
     * @return
     */
    public int setinitPosition(){
        return currentPosition;
    }
}
