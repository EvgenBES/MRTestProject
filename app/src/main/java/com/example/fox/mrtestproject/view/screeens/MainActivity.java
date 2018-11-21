package com.example.fox.mrtestproject.view.screeens;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.example.fox.mrtestproject.R;
import com.example.fox.mrtestproject.entity.User;
import com.example.fox.mrtestproject.view.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter presenter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_main);
        presenter = new MainPresenter(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.searchUser(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_name:
                presenter.sortNameUser();
                return true;
            case R.id.sort_time:
                presenter.sortTimeUser();
            return true;
            case R.id.sort_point:
                presenter.sortPointUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setItems(List<User> users) {
        recyclerView.setAdapter(new MainAdapter(users));
    }


}
