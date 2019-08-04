package com.test.mychat.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.mychat.R;
import com.test.mychat.databean.ContactsBean;

import java.util.List;

/**
 * 通用适配器 -- https://www.cnblogs.com/huangjialin/p/7808599.html
 */
public class ConstantsAdapter extends RecyclerView.Adapter<ConstantsAdapter.ViewHolder> {

    private Context context;
    private List<ContactsBean> contactList;
    private LayoutInflater inflater;

    public ConstantsAdapter(Context context, List<ContactsBean> contactList) {
        this.context = context;
        this.contactList = contactList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.layout_contact_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        ContactsBean contactBean = contactList.get(pos);
//        if (contactBean.isLetter()) {
//            viewHolder.textLetter.setText(contactBean.getConstantName());
//
//            viewHolder.textLetter.setVisibility(View.VISIBLE);
//            viewHolder.imageHead.setVisibility(View.GONE);
//            viewHolder.textName.setVisibility(View.GONE);
//
//        } else {
//            viewHolder.textName.setText(contactBean.getConstantName());
//
//            viewHolder.textLetter.setVisibility(View.GONE);
//            viewHolder.imageHead.setVisibility(View.VISIBLE);
//            viewHolder.textName.setVisibility(View.VISIBLE);
//        }

    }

    @Override
    public int getItemCount() {
        if (null != contactList) {
            return contactList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageHead;
        private TextView textName;
        private TextView textLetter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHead = itemView.findViewById(R.id.fragContact_listItem_image_headPortrait);
            textName = itemView.findViewById(R.id.fragContact_listItem_text_name);
            textLetter = itemView.findViewById(R.id.fragContact_listItem_text_letter);
        }
    }
}
