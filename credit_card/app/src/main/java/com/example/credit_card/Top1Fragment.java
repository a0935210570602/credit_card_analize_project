package com.example.credit_card;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Top1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Top1Fragment extends Fragment {

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

    public Top1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Top1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Top1Fragment newInstance(String param1, String param2) {
        Top1Fragment fragment = new Top1Fragment();
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

    @SuppressLint("ResourceAsColor")
    private void setCommentLayout(View view) {
        LinearLayout linear = view.findViewById(R.id.linear);
        TextView text = new TextView(this.getContext());
        text.setGravity(Gravity.LEFT);
        TextView text4 = new TextView(this.getContext());
        text4.setGravity(Gravity.LEFT);
        TextView text2 = new TextView(this.getContext());
        text2.setGravity(Gravity.CENTER);
        text2.setText("匿名留言專區：");
        text2.setTextColor(R.color.green);
        text2.setTextSize(30);
        TextView text3 = new TextView(this.getContext());
        text3.setGravity(Gravity.LEFT);


        linear.addView(text);
        linear.addView(text4);
        linear.addView(text2);
        linear.addView(text3);

        ArrayList<String> comment_list = new ArrayList<String>();
        comment_list.add("花旗銀行真是佛心，這張卡的紅利折抵真是太高了");
        comment_list.add("希望大家多多使用");
        comment_list.add("推薦給大家這張卡喔，他給了我超多優惠的");
        comment_list.add("這張卡生日時還送我禮物耶!");
        comment_list.add("沒有後悔辦過這張卡");
        comment_list.add("好用好用，太好用了");
        comment_list.add("出國搭飛機時也很方便");
        comment_list.add("來看看有多少人覺得好用，好用的+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("+1");
        comment_list.add("好用推推推");

        for(int i=0;i<comment_list.size();i++){
            LinearLayout child_linear = new LinearLayout(this.getContext());
            child_linear.setOrientation(LinearLayout.HORIZONTAL);

            ImageView iconima = new ImageView(this.getContext());
            iconima.setImageResource(R.drawable.people_icon);
            iconima.setMaxWidth(i);
            iconima.setMaxHeight(i);
            iconima.setTag("匿名");
            iconima.setContentDescription("匿名");
            iconima.setScaleType(ImageView.ScaleType.FIT_CENTER);

            TextView textViewId = new TextView(this.getContext());
            textViewId.setGravity(Gravity.LEFT);
            textViewId.setText(comment_list.get(i));
            textViewId.setTextSize(20);
            TextView text5 = new TextView(this.getContext());
            text5.setGravity(Gravity.LEFT);

            child_linear.addView(iconima);
            child_linear.addView(textViewId);
            child_linear.addView(text5);

            linear.addView(child_linear);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top1,container,false);

        credit_card.put("銀行", "花旗銀行");
        credit_card.put("信用卡名", "現金回饋PLUS卡");

        credit_card.put("圖片", String.valueOf(R.drawable.card_01));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        img = view.findViewById(R.id.img4);
        reference = view.findViewById(R.id.reference);
        showContent = view.findViewById(R.id.showContent);

        img.setImageResource(Integer.parseInt(credit_list.get(0).get("圖片")));
        showContent.setTypeface(Typeface.DEFAULT_BOLD);
        showContent.setTextSize(20);
        showContent.setText(
                credit_list.get(0).get("銀行") + credit_list.get(0).get("信用卡名") + "\n");
        reference.setImageResource(Integer.parseInt(credit_list.get(0).get("星星")));
        setCommentLayout(view);
        Button btn = view.findViewById(R.id.button);
        final EditText edit = view.findViewById(R.id.det);

        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        edit.setText("");
                        Toast.makeText(getContext(), "發表評論成功", Toast.LENGTH_LONG).show();
                    }
                }
        );

        return view;
    }
}