package com.xhsc.layout.ui.spinners;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.meituan.MeiTuan;


import android.R.anim;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnersActivity extends Activity {
	private Spinner mOneSpinner,mTwoSpinner,mThreeSpinner,mFourSpinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//隐藏标题栏，默认XML布局的第一个TextView为标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//1、加载布局
		setContentView(R.layout.adapter_spinner_layout);
		
		//2、获得控件实例
		mOneSpinner = (Spinner)findViewById(R.id.adapter_spinner1);
		mTwoSpinner = (Spinner)findViewById(R.id.adapter_spinner2);
		mThreeSpinner = (Spinner)findViewById(R.id.adapter_spinner3);
		mFourSpinner = (Spinner)findViewById(R.id.adapter_spinner4);
		setSpinnerOne();
		setSpinnerThree();
		setSpinnerFour();
		setSpinnerTwo();
	}
	
	public void setSpinnerOne(){
		
		//3、设置显示数据源
		String[] spinnerData = { "张三", "李四", "王二", "麻子", "赵钱" };
		
		//4、实例化对应数据源适配器
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, spinnerData);
		
		//5、加载适配器
		mOneSpinner.setAdapter(arrayAdapter);
		
		//6、设置默认显示项
		mOneSpinner.setSelection(1,true);
		
		//7、设置控件选折监听
		mOneSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SpinnersActivity.this, "mOneSpinner onItemSelected position "+position, Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				Toast.makeText(SpinnersActivity.this, "onNothingSelected  ", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public void setSpinnerThree(){
		String[] spinnerThreeData = { "美食", "娱乐", "王二", "麻子", "赵钱" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, spinnerThreeData);
		mThreeSpinner.setAdapter(arrayAdapter);
		mThreeSpinner.setSelection(1,true);
		mThreeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SpinnersActivity.this, "mThreeSpinner onItemSelected position "+position, Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				Toast.makeText(SpinnersActivity.this, "onNothingSelected  ", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public void setSpinnerFour(){
		String[] arrayss = { "体育", "NBA", "CBA", "新闻", "赵钱" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SpinnersActivity.this,android.R.layout.simple_expandable_list_item_1, arrayss);
		mFourSpinner.setAdapter(arrayAdapter);
		mFourSpinner.setSelection(2,true);
		mFourSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(SpinnersActivity.this, "mFourSpinner onItemSelected position "+position, Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				Toast.makeText(SpinnersActivity.this, "onNothingSelected  ", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public void setSpinnerTwo(){
		SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this);
		mTwoSpinner.setAdapter(spinnerAdapter);
		spinnerAdapter.setListData(getData());
	}
	
	/**
	 * @author
	 * 
	 * 获取自定义数据源
	 */
	public ArrayList<MeiTuan> getData(){
		ArrayList<MeiTuan> data = new ArrayList<MeiTuan>();
		MeiTuan meiTuan = new MeiTuan();
		
		meiTuan.setIcon(R.drawable.meituan_image1);
		meiTuan.setTitle("1【多店通用】乡村基");
		meiTuan.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		meiTuan.setNowPrice("9.9元");
		meiTuan.setOldPrice("200000元");
		meiTuan.setScore("4.9分（4546）");
		data.add(meiTuan);
		
		meiTuan = new MeiTuan();
		meiTuan.setIcon(R.drawable.meituan_image1);
		meiTuan.setTitle("2【多店通用】乡村基");
		meiTuan.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		meiTuan.setNowPrice("20元");
		meiTuan.setOldPrice("465130元");
		meiTuan.setScore("4.8分（546）");
		data.add(meiTuan);
		
		meiTuan = new MeiTuan();
		meiTuan.setIcon(R.drawable.meituan_image1);
		meiTuan.setTitle("2【多店通用】乡村基");
		meiTuan.setContent("20元代金券！全场通用，可叠加使用，提供免费WiFi！");
		meiTuan.setNowPrice("20元");
		meiTuan.setOldPrice("465");
		meiTuan.setScore("4.8分（546）");
		data.add(meiTuan);
		
		return data;
	}
	
	/**
	 * @author
	 * 自定义适配器
	 * 
	 */
	public class SpinnerAdapter extends BaseAdapter{
		private ArrayList<MeiTuan> data = new ArrayList<MeiTuan>();
		private LayoutInflater layoutInflater;// 将XML布局转换成View对象
		private Context context;
		
		SpinnerAdapter(Context context){
			layoutInflater = LayoutInflater.from(context);
			this.context = context;
		}
		
		/**
		 * 给Adapter设置数据
		 * 
		 * @param list
		 */
		public void setListData(ArrayList<MeiTuan> arrayList) {
			this.data = arrayList;
			notifyDataSetChanged();// 通知适配器刷新数据
		}
		
		
		/**
		 * 返回数据项个数
		 */
		@Override
		public int getCount() {
			
			return data.size();
		}

		
		/**
		 * 获取指定位置的数据
		 */
		@Override
		public Object getItem(int position) {
			
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			
			return position;
		}

		
		/**
		 * 获取在指定位置上显示的View并设置相应数据
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHodler viewHodler;
			View v;
			if(convertView == null){
				v = layoutInflater.inflate(R.layout.my_baseadapter_meituan_item_layout, null);
				viewHodler = new ViewHodler();
				viewHodler.iconImg = (ImageView) v.findViewById(R.id.meituan_mybaseadapter_item_imageview);
				viewHodler.titleTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_title);
				viewHodler.contentTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_content);
				viewHodler.nowPriceTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_nowprice);
				viewHodler.oldPriceTxt = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_oldprice);
				viewHodler.score = (TextView) v.findViewById(R.id.meituan_mybaseadapter_item_score);
				v.setTag(viewHodler);
			}else{
				v = convertView;
				viewHodler = (ViewHodler)v.getTag();
			}
			
			MeiTuan mTuan = (MeiTuan) getItem(position);
			viewHodler.iconImg.setBackgroundResource(mTuan.getIcon());
			viewHodler.titleTxt.setText(mTuan.getTitle());
			viewHodler.contentTxt.setText(mTuan.getContent());
			viewHodler.nowPriceTxt.setText(mTuan.getNowPrice());

			if (mTuan.getOldPrice().endsWith("元")){
				viewHodler.oldPriceTxt.setText((String)mTuan.getOldPrice());

//				viewHodler.oldPriceTxt.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
				
				viewHodler.oldPriceTxt.setText(setSpannableString( mTuan.getOldPrice()));
			}else{
				viewHodler.oldPriceTxt.setBackgroundResource(R.drawable.a3v);//(Integer)mTuan.getOldPrice()
			}

			viewHodler.score.setText(mTuan.getScore());
			return v;
		}
		
	}
	
	/**
	 * 
	 * @param sequence
	 * @return
	 * TextView使用SpannableString设置复合文本
	 * TextView通常用来显示普通文本，但是有时候需要对其中某些文本进行样式、事件方面的设置。Android系统通过SpannableString类来对指定文本进行相关处理，具体有以下功能：
	 */
	public SpannableString setSpannableString(CharSequence sequence){
		SpannableString string = new SpannableString(sequence);
		//设置字体颜色
		string.setSpan(new ForegroundColorSpan(Color.GREEN), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//字体加粗
		string.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, string.length()-3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		/*// 设置字体大小（绝对值,单位：像素）
					 string.setSpan(new AbsoluteSizeSpan(20), 0,string.length()-5,
					 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
					//第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。 
					 string.setSpan(new AbsoluteSizeSpan(20,true), string.length()-4,string.length()-1,
							 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/
		/*//设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
		 string.setSpan(new RelativeSizeSpan(0.5f), 0,string.length()-5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//0.5f表示默认字体大小的一半
		 string.setSpan(new RelativeSizeSpan(2.0f), string.length()-4,string.length()-2,
					 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体大小的两倍
*/		// 设置删除中划线
		string.setSpan(new StrikethroughSpan(), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		return string;
		/*
		 * 1、BackgroundColorSpan 背景色 
2、ClickableSpan 文本可点击，有点击事件
3、ForegroundColorSpan 文本颜色（前景色）
4、MaskFilterSpan 修饰效果，如模糊(BlurMaskFilter)、浮雕(EmbossMaskFilter)
5、MetricAffectingSpan 父类，一般不用
6、RasterizerSpan 光栅效果
7、StrikethroughSpan 删除线（中划线）
8、SuggestionSpan 相当于占位符
9、UnderlineSpan 下划线
10、AbsoluteSizeSpan 绝对大小（文本字体）
11、DynamicDrawableSpan 设置图片，基于文本基线或底部对齐。
12、ImageSpan 图片
13、RelativeSizeSpan 相对大小（文本字体）
14、ReplacementSpan 父类，一般不用
15、ScaleXSpan 基于x轴缩放
16、StyleSpan 字体样式：粗体、斜体等
17、SubscriptSpan 下标（数学公式会用到）
18、SuperscriptSpan 上标（数学公式会用到）
19、TextAppearanceSpan 文本外貌（包括字体、大小、样式和颜色）
20、TypefaceSpan 文本字体
21、URLSpan 文本超链接
		 */
		
	}
	
	class ViewHodler {
		ImageView iconImg;
		TextView titleTxt;
		TextView contentTxt;
		TextView nowPriceTxt;
		TextView oldPriceTxt;
		TextView score;
	}
}
