package com.example.myqq.chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myqq.R;

import java.util.List;

public class myadpater extends RecyclerView.Adapter<myadpater.viewholder> {
    private List<chat_picture> mList;

    class viewholder extends RecyclerView.ViewHolder {
        ImageView rightImage;
        ImageView leftImage;
        TextView rightText;
        TextView leftText;
        LinearLayout leftLayout;
        LinearLayout rightLayout;


        /*******************设置绑定头像文字显示控件****************************/
        public viewholder(@NonNull View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.chat_picture_left);
            rightLayout = itemView.findViewById(R.id.chat_picture_right);
            rightImage = itemView.findViewById(R.id.chat_picture_image1);
            rightText = itemView.findViewById(R.id.chat_picture_text1);
            leftImage = itemView.findViewById(R.id.chat_picture_image2);
            leftText = itemView.findViewById(R.id.chat_picture_text2);

        }
    }

    public myadpater(List<chat_picture> list) {
        mList = list;
    }


    @NonNull
    @Override
    public myadpater.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_picture,
                viewGroup, false);
        viewholder viewholder = new viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull myadpater.viewholder viewholder, int i) {
        chat_picture chat_picture = mList.get(i);
        if(chat_picture.getLeft_right()){
            viewholder.rightLayout.setVisibility(View.VISIBLE);
            viewholder.leftLayout.setVisibility(View.GONE);
            viewholder.rightImage.setImageResource(chat_picture.getImageView());
            viewholder.rightText.setText(chat_picture.getTextView());
        }
        else{
            viewholder.rightLayout.setVisibility(View.GONE);
            viewholder.leftLayout.setVisibility(View.VISIBLE);
            viewholder.leftImage.setImageResource(chat_picture.getImageView());
            viewholder.leftText.setText(chat_picture.getTextView());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
