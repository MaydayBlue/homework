package com.example.studycourse.Adapter;

import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studycourse.R;
import com.example.studycourse.Util.Course;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends ArrayAdapter<Course> {
    //private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int resourceId;
    public ListAdapter(Context context,int textViewResourceId, List<Course> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    //写一个静态的class,把layout_list_item的控件转移过来使用
    static class ViewHolder{
        //声明引用
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContext;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolder holder = null;
        if (convertView == null){
            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            //convertView = mLayoutInflater.inflate(R.layout.item_view,null);

            holder = new ViewHolder();

            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            //把layout_list_item对象转移过来，以便修改和赋值
            holder.imageView = (ImageView) view.findViewById(R.id.IV_list_Id);
            holder.tvTitle= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            holder.tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            holder.tvContext= (TextView) view.findViewById(R.id.TV_listContext_Id);

            //convertView.setTag(holder);
            view.setTag(holder);
        }else {
            view=convertView;
            holder=(ViewHolder) view.getTag();
            //holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        Course cour=getItem(position);
        holder.imageView.setImageResource(cour.getImageId());
        holder.tvTitle.setText(cour.getCourseId());
        holder.tvTime.setText(cour.getTeacher());
        holder.tvContext.setText(cour.getSchool());

        //return convertView;
        return view;
    }

}

