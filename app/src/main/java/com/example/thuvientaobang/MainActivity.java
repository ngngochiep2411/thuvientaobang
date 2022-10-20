package com.example.thuvientaobang;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.ArrayColumn;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.PageTableData;
import com.example.thuvientaobang.api.GitHubService;
import com.example.thuvientaobang.model.Movie;
import com.example.thuvientaobang.model.MovieItem;
import com.example.thuvientaobang.model.UserInfo;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SmartTable<UserInfo> smartTable;
    PageTableData<UserInfo> tableData;
    List<MovieItem> list = new ArrayList<>();
    List<UserInfo> list2 = new ArrayList<>();

    SmartRefreshLayout refreshLayout;
    final ArrayColumn<String> rankColumn = new ArrayColumn<>("Thứ \nhạng", "rank");
    final ArrayColumn<String> nameColumn = new ArrayColumn<>("Họ tên", "name");
    final ArrayColumn<String> ageColumn = new ArrayColumn<>("age", "age");
    final ArrayColumn<String> addressColumn = new ArrayColumn<>("address", "address");
    final ArrayColumn<String> phoneColumn = new ArrayColumn<>("phone", "phone");
    final ArrayColumn<String> emailColumn = new ArrayColumn<>("email", "email");
    final ArrayColumn<String> passwordColumn = new ArrayColumn<>("password", "password");
    final ArrayColumn<String> heightColumn = new ArrayColumn<>("height", "height");
    int page = 1;
    int rank = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getDataApi();
        initTable();
    }

    private void initTable() {
        tableData = new PageTableData<UserInfo>("userfInfo", list2, rankColumn, nameColumn, ageColumn, addressColumn, phoneColumn, emailColumn, passwordColumn, heightColumn);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setShowTableTitle(false);
        smartTable.getConfig().setShowXSequence(false);
        smartTable.getConfig().setShowYSequence(false);
        smartTable.getConfig().setFixedTitle(true);
//        rankColumn.setFixed(true);
//        nameColumn.setFixed(true);
        ICellBackgroundFormat<CellInfo> backgroundFormat = new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(MainActivity.this, R.color.content_bg);
                }
                return TableConfig.INVALID_COLOR;


            }
        };
        smartTable.getConfig().setContentCellBackgroundFormat(backgroundFormat);
        smartTable.getConfig().setVerticalPadding(24);
        smartTable.getConfig().setColumnTitleBackground
                (new BaseBackgroundFormat(getResources().getColor(R.color.color_header_table)));
        smartTable.getConfig().setColumnTitleStyle(new FontStyle(this, 16, ContextCompat.getColor(this, R.color.white)));
        smartTable.getConfig().setColumnTitleVerticalPadding(24);
        refreshLayout.setEnableRefresh(false);//是否启用下拉刷新功能

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                if (page == 5) {
                    refreshLayout.setEnableLoadMore(false);
                }
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GitHubService service = retrofit.create(GitHubService.class);
                service.getMovies("ffdb03735928fcc0efda02a0db29b49e", page).enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                        int size = response.body().getResults().size();
                        for (int i = 0; i < size; i++) {
//                            list2.add(new UserInfo(i+"", "sddfddfsdf", response.body().getResults().get(i).getOriginalLanguage(),
//                                    String.valueOf(response.body().getResults().get(i).isVideo()), response.body().getResults().get(i).getTitle(), response.body().getResults().get(i).getPosterPath(), response.body().getResults().get(i).getBackdropPath(), response.body().getResults().get(i).getReleaseDate()));
                            list2.add(new UserInfo(response.body().getResults().get(i).getId() + "",
                                    rank + "", "Z2", "Z3", "ZZ"
                                    , "GFD", "FGDFS", "ÁDA"));
                            rank++;
                        }
                        smartTable.setData(list2);
                        page++;
                        refreshLayout.finishLoadMore();
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    private void getDataApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.getMovies("ffdb03735928fcc0efda02a0db29b49e", page).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                int size = response.body().getResults().size();
                for (int i = 0; i < size; i++) {
//                    list2.add(new UserInfo(i + "", "gfgfdgdfgdf", response.body().getResults().get(i).getOriginalLanguage(),
//                            String.valueOf(response.body().getResults().get(i).isVideo()), response.body().getResults().get(i).getTitle(),
//                            response.body().getResults().get(i).getPosterPath(),
//                            response.body().getResults().get(i).getBackdropPath(),
//                            response.body().getResults().get(i).getReleaseDate()));
                    list2.add(new UserInfo(response.body().getResults().get(i).getId() + "",
                            rank + "", "Z2", "Z3", "ZZ"
                            , "GFD", "FGDFS", "ÁDA"));
                    rank++;
                }
                smartTable.setData(list2);
                page++;
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        smartTable = findViewById(R.id.table);
        refreshLayout = findViewById(R.id.refreshLayout);
    }

}


