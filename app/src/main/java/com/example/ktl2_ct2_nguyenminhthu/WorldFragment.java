package com.example.ktl2_ct2_nguyenminhthu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ktl2_ct2_nguyenminhthu.CustomedAdapters.WorldViewPaperAdapter;
import com.example.ktl2_ct2_nguyenminhthu.databinding.FragmentWorldBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorldFragment extends Fragment {

    private FragmentWorldBinding fragmentWorldBinding;
    final private int TAB_COUNT = 5;
    WorldViewPaperAdapter viewPagerAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WorldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorldFragment newInstance(String param1, String param2) {
        WorldFragment fragment = new WorldFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentWorldBinding = FragmentWorldBinding.inflate(getLayoutInflater());
        return fragmentWorldBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerAdapter = new WorldViewPaperAdapter(getChildFragmentManager());
        fragmentWorldBinding.viewPager.setAdapter(viewPagerAdapter);
        fragmentWorldBinding.tab.setupWithViewPager(fragmentWorldBinding.viewPager);
        fragmentWorldBinding.viewPager.setOffscreenPageLimit(TAB_COUNT);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentWorldBinding = null;
    }
}