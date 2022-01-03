package com.example.jinx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {
    private Context context;
    private List<ac1> ac1;
    private LayoutInflater inflater;

    public adapter(Context context, List<ac1> ac1) {
        this.context = context;
        this.ac1 = ac1;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ac1.size();
    }

    @Override
    public ac1 getItem(int position) {
        return ac1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_item, null);
        ac1 currentItem = getItem(position);
//get infos about view
        String itemName = currentItem.getTitle();
        String itemdescription = currentItem.getDescription();
        String img = currentItem.getImage();

//get item icon view


        ImageView imgg = view.findViewById(R.id.imageView2);

        int imageResource = view.getResources().getIdentifier(img, null, context.getPackageName());

        Drawable drawable = view.getResources().getDrawable(imageResource);
        imgg.setImageDrawable(drawable);

        TextView itemNameView = view.findViewById(R.id.title);
        itemNameView.setText(itemName);

        TextView itemDescriptionView = view.findViewById(R.id.description);
        itemDescriptionView.setText(itemdescription);

        return view;
    }
}
