package com.ntdat.weaning.screens.recipe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntdat.weaning.R;

/**
 * Created by ntdat on 2/26/16.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeView> {

    private Context context;
    OnItemClickListener clickListener;

    int[] imgList = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten};

    String[] nameList = {"Cháo bí đỏ", "Cháo đậu hũ", "Cháo táo", "Súp chuối và đậu nành", "Súp bí đỏ", "Cháo bánh mỳ và sữa",
            "Khoai tây và bắp cải", "Cháo cải bó xôi và lòng đỏ trứng", "Cháo cà rốt và đậu hũ", "Súp khoai tây, rong biển và trứng"};

    public RecipeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecipeView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        RecipeView recipeView = new RecipeView(layoutView);
        return recipeView;
    }

    @Override
    public void onBindViewHolder(RecipeView holder, int position) {
        holder.imageView.setImageResource(imgList[position]);
        holder.textView.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        //this.clickListener = itemClickListener;
        this.clickListener = itemClickListener;
    }

    class RecipeView extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;

        public RecipeView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            textView = (TextView) itemView.findViewById(R.id.img_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getPosition());
        }
    }
}
