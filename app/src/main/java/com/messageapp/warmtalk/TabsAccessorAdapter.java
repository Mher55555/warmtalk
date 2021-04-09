package com.messageapp.warmtalk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdapter extends FragmentPagerAdapter {

    public TabsAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:return new ChatsFragment();

            case 1:return new ContactsFragment();
            case 2:return new RequestsFragment();
            case 3:return new GroupsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:return "ЧАТЫ";
            case 1:return "КОНТАКТЫ";
            case 2:return "ЗАПРОСЫ";
            case 3:return "ГРУППЫ";
        }
        return null;
    }
}
