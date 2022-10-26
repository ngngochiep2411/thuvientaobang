package com.example.thuvientaobang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

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
import com.example.thuvientaobang.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedemFragment extends Fragment {

    View view;
    private SmartTable<UserInfo> smartTable;
    final ArrayColumn<String> rankColumn = new ArrayColumn<>("Thứ hạng", "rank");
    final ArrayColumn<String> nameColumn = new ArrayColumn<>("Họ tên", "name");
    final ArrayColumn<String> ageColumn = new ArrayColumn<>("age", "age");
    final ArrayColumn<String> addressColumn = new ArrayColumn<>("address", "address");
    final ArrayColumn<String> phoneColumn = new ArrayColumn<>("phone", "phone");
    final ArrayColumn<String> emailColumn = new ArrayColumn<>("email", "email");
    final ArrayColumn<String> passwordColumn = new ArrayColumn<>("password", "password");
    final ArrayColumn<String> heightColumn = new ArrayColumn<>("height", "height");
    List<UserInfo> list2 = new ArrayList<>();
    PageTableData<UserInfo> tableData;
    int rank = 1;
    int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_redem_point, container, false);
        initView();
        initTable();
        getDataApi(page);
        return view;
    }

    private void initTable() {
        tableData = new PageTableData<UserInfo>("userfInfo", list2, rankColumn, nameColumn, ageColumn, addressColumn, phoneColumn, emailColumn, passwordColumn, heightColumn);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setShowTableTitle(false);
        smartTable.getConfig().setShowXSequence(false);
        smartTable.getConfig().setShowYSequence(false);
        smartTable.getConfig().setFixedTitle(true);
        rankColumn.setFixed(true);
        nameColumn.setFixed(true);
        ICellBackgroundFormat<CellInfo> backgroundFormat = new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(getContext(), R.color.content_bg);
                }
                return TableConfig.INVALID_COLOR;

            }
        };
        smartTable.getConfig().setContentCellBackgroundFormat(backgroundFormat);
        smartTable.getConfig().setVerticalPadding(24);
        smartTable.getConfig().setColumnTitleBackground
                (new BaseBackgroundFormat(getResources().getColor(R.color.color_header_table)));
        smartTable.getConfig().setColumnTitleStyle(new FontStyle(getContext(), 16, ContextCompat.getColor(getContext(), R.color.white)));
        smartTable.getConfig().setColumnTitleVerticalPadding(24);
    }

    private void initView() {
        smartTable = view.findViewById(R.id.smartTable);
    }

    private void getDataApi(int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        service.getMovies("ffdb03735928fcc0efda02a0db29b49e", page).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                int size = 10;
                for (int i = 0; i < size; i++) {
                    list2.add(new UserInfo(response.body().getResults().get(i).getId() + "",
                            rank + "", "Z2", "Z3", "ZZ"
                            , "GFD", "FGDFS", "ÁDA"));
                    rank++;
                }
                smartTable.setData(list2);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
