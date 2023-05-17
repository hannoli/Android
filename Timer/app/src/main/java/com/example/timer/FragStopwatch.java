package com.example.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragStopwatch extends Fragment // Fragment 클래스를 상속받아야한다
{
    ViewGroup viewGroup;
    ImageView button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragstopwatch,container,false);

        button= (ImageView) viewGroup.findViewById(R.id.img_alarm_dots);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup= new PopupMenu(getActivity(), view);
                MenuInflater menuInflater = new MenuInflater(getActivity());

                menuInflater.inflate(R.menu.menu_resource, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_see:
                                Toast.makeText(getContext(),"이전 구간 기록 보기",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_config:
                                Toast.makeText(getContext(),"설정",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        return viewGroup;
    }
}


