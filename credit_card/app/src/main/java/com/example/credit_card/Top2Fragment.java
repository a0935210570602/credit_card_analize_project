package com.example.credit_card;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Top2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Top2Fragment extends Fragment {

    ImageView img, reference;
    TextView showContent;

    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
    Map<String, String> credit_card= new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Top2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Top2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Top2Fragment newInstance(String param1, String param2) {
        Top2Fragment fragment = new Top2Fragment();
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

        img = getView().findViewById(R.id.img);
        reference = getView().findViewById(R.id.reference);
        showContent = getView().findViewById(R.id.showContent);

        credit_card.put("銀行", "滙豐銀行");
        credit_card.put("信用卡名", "現金回饋御璽卡");
        credit_card.put("使用人數", "78000");
        credit_card.put("圖片", String.valueOf(R.drawable.card_02));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        img.setImageResource(Integer.parseInt(credit_list.get(0).get("圖片")));
        showContent.setText(
                "信用卡名：" + credit_list.get(0).get("銀行") + credit_list.get(0).get("信用卡名") + "\n" +
                        "使用人數：" + credit_list.get(0).get("使用人數"));
        reference.setImageResource(Integer.parseInt(credit_list.get(0).get("星星")));

        return inflater.inflate(R.layout.fragment_top2, container, false);
    }
}