package com.example.thuvientaobang;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.format.draw.TextImageDrawFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.utils.DensityUtils;
import com.example.thuvientaobang.model.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RedemFragment extends Fragment {

    View view;
    private SmartTable<UserInfo> smartTable;
    List<UserInfo> list2 = new ArrayList<>();
    TableData<UserInfo> tableData;
    int rank = 1;
    int page = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_redem_point, container, false);
        initView();
        getDataApi();
        initTable();
        return view;
    }

    private void initTable() {
        int size = DensityUtils.dp2px(RedemFragment.super.getContext(), 25);
        final Column<String> rankColumn = new Column<String>("Thứ hạng", "rank", new TextImageDrawFormat<String>(size, size, TextImageDrawFormat.LEFT, size / 2) {
            @Override
            protected Context getContext() {
                return RedemFragment.this.getContext();
            }

            @Override
            protected int getResourceID(String s, String value, int position) {
                if (s.equals("")) {
                    return R.drawable.avator_5;
                } else if (s.equals("\n")) {
                    return R.drawable.avator_6;
                } else if (s.equals("\n\n")) {
                    return R.drawable.avator_7;
                }
                return 0;
            }
        });
        final Column<String> nameColumn = new Column<String>("Họ tên", "name");
        final Column<String> ageColumn = new Column<String>("age", "age");
        final Column<String> addressColumn = new Column<String>("address", "address");
        final Column<String> phoneColumn = new Column<String>("phone", "phone");
        final Column<String> emailColumn = new Column<String>("email", "email");
        final Column<String> passwordColumn = new Column<String>("password", "password");
        final Column<String> heightColumn = new Column<String>("height", "height");
        tableData = new TableData<UserInfo>("", list2, rankColumn, nameColumn, ageColumn,
                addressColumn, phoneColumn, emailColumn, passwordColumn, heightColumn);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setShowTableTitle(false);
        smartTable.getConfig().setShowXSequence(false);
        smartTable.getConfig().setShowYSequence(false);
        smartTable.getConfig().setFixedTitle(true);
//        rankColumn.setFixed(true);
        nameColumn.setFixed(true);

//        rankColumn.setWidth(size);
//        rankColumn.setWidth(50);
//        nameColumn.setWidth(250);

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

    private void getDataApi() {
        list2.add(new UserInfo("", "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo("\n", "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo("\n\n", "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("4"), "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("5"), "Nguyễn Ngọc ONG", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("6"), "Nguyễn Ngọc aN", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("7"), "Nguyễn DS Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("8"), "Nguyễn DGGG Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("9"), "Nguyễn Ngọc HGFH", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("10"), "SFJHJ Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("11"), "FDSFS Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("Đang cập nhật"), "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("13"), "Nguyễn 45645 Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("14"), "Nguyễn Ngọc 654", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("15"), "Nguyễn Ngọc Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("16"), "Nguyễn 42342 Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("17"), "Nguyễn 23423 Hiệp", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("Bỏ thi"), "Nguyễn Ngọc 4342", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
        list2.add(new UserInfo(check("Gian lận cho cút"), "Nguyễn Ngọc 4342", "22", "dffdsf", "fdsfs", "fdsfdsfss", "fdsfssf", "fssfdsfsdf"));
    }

    private String check(String rank) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(rank);
        boolean found = matcher.find();
        if (found) {
            return rank.replace(" ", "\n");
        }
        return rank;
    }
}
