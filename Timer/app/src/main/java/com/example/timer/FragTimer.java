package com.example.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragTimer extends Fragment // Fragment 클래스를 상속받아야한다
{
    TimePicker time_picker;
    ImageView button;
    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragtimer,container,false);
        button= (ImageView) viewGroup.findViewById(R.id.img_timer_dots);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getActivity(), view);
                MenuInflater menuInflater = new MenuInflater(getActivity());

                menuInflater.inflate(R.menu.timermenu_resource, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.timemenu_add:
                                Toast.makeText(getContext(), "기본 타이머 추가", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.timemenu_edit:
                                Toast.makeText(getContext(), "기본 타이머 편집", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.timemenu_config:
                                Toast.makeText(getContext(), "설정", Toast.LENGTH_SHORT).show();
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