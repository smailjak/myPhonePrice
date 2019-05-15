package com.tistory.webnautes.phonemoney.TotalManage;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.tistory.webnautes.phonemoney.R;
import com.tistory.webnautes.phonemoney.TotalManage.FragOne.FragmentOne;
import com.tistory.webnautes.phonemoney.TotalManage.FragTwo.FragmentTwo;
import com.tistory.webnautes.phonemoney.databinding.ActivityManageBinding;

public class ManageActivity extends AppCompatActivity {

    private ActivityManageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//      Adding Fragments
        adapter.AddFragment(new FragmentOne(), "PhoneInfo");
        adapter.AddFragment(new FragmentTwo(), "Artificial");
//        adapter Setup
        binding.vp.setAdapter(adapter);
        binding.tl.setupWithViewPager(binding.vp);
        binding.vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tl));
        binding.tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }   // onCreate 끝나는 부분
}
