package com.ntdat.weaning.screens.recipe;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntdat.weaning.R;
import com.ntdat.weaning.screens.recipe.adapter.RecipeAdapter;
import com.ntdat.weaning.screens.recipe.view.SpacesItemDecoration;

/**
 * Created by ntdat on 2/25/16.
 */
public class RecipeFragment extends Fragment{
    private RecyclerView rvRecipes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rvRecipes = (RecyclerView) inflater.inflate(
                R.layout.fragment_recipe, container, false);
        setupRecyclerView(rvRecipes);
        return rvRecipes;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        RecipeAdapter adapter = new RecipeAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(0);
        recyclerView.addItemDecoration(decoration);
        adapter.SetOnItemClickListener(
                new RecipeAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), RecipeDetailActivity.class);
                        if (intent != null) {
                            ActivityOptionsCompat options = ActivityOptionsCompat.
                                    makeSceneTransitionAnimation(getActivity(), view, "recipe_photo");
                            startActivity(intent, options.toBundle());
                        }
                    }
                }
        );
    }

}
