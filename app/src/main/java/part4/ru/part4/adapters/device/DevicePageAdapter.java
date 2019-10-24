package part4.ru.part4.adapters.device;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import part4.ru.part4.fragments.DeviceActivityNavigation.DevicePageFragment;

public class DevicePageAdapter extends FragmentPagerAdapter {
    private String[] mTabTitles = new String[] { "Характеристики", "Парт каталог", "Коды ошибок", "Сервис" };
    Context mContext;

    public DevicePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return DevicePageFragment.newInstance(i + 1);
    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Генерируем заголовки на основе позиции
        return mTabTitles[position];
    }
}
