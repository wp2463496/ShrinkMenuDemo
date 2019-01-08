package com.example.shrinkmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * 收缩菜单demo
 * @author Forty'7
 * xiaowangboke@vip.qq.com
 *
 */
public class MainActivity extends Activity {
	private ImageView head_img;
	private ImageView bt1;
	private ImageView bt2;
	private ImageView ap_bg;
	private boolean tag = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		head_img = (ImageView) findViewById(R.id.head_img);
		bt1 = (ImageView) findViewById(R.id.bt1);
		bt2 = (ImageView) findViewById(R.id.bt2);
		ap_bg = (ImageView) findViewById(R.id.ap_bg); 
		
		head_img.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			
				if(tag){
					bt1.setVisibility(View.VISIBLE);
					bt2.setVisibility(View.VISIBLE);
					ap_bg.setVisibility(View.VISIBLE);
					openAnimationAp_bg();
					openAnimationBt();
					//open_head_img_RotateAnimation();
				}else{
					cloesAnimationBt();
					cloesAnimationAp_bg();
					new Handler().postDelayed(new Runnable() {
						@Override
						public void run() {
							ap_bg.setVisibility(View.GONE);
							bt1.setVisibility(View.GONE);
							bt2.setVisibility(View.GONE);
						}
					}, 100);
					
				}
				tag = !tag;
			}
		});
		

		
		
	}
	
	
	/**
	 * 渐变动画
	 * 其中AlphaAnimation类第一个参数fromAlpha表示动画起始时的透明度， 第二个参数toAlpha表示动画结束时的透明度。 
	 * setDuration用来设置动画持续时间。
	 */
	private void openAnimationAp_bg(){
		//图片渐变模糊度始终  
        AlphaAnimation aa = new AlphaAnimation(0.1f,1.0f);  
        //渐变时间  
        aa.setDuration(800);  
        //展示图片渐变动画  
        ap_bg.startAnimation(aa); 
        bt1.startAnimation(aa); 
        bt2.startAnimation(aa); 
	}
	
	private void cloesAnimationAp_bg(){
		//图片渐变模糊度始终  
        AlphaAnimation aa = new AlphaAnimation(1.0f, 0.1f);  
        //渐变时间  
        aa.setDuration(150);  
        //展示图片渐变动画  
        ap_bg.startAnimation(aa); 
        bt1.startAnimation(aa); 
        bt2.startAnimation(aa); 
	}
	

	
	/**
	 * 伸缩动画
	 * 第一个参数fromX ,第二个参数toX:分别是动画起始、结束时X坐标上的伸缩尺寸。
	 * 第三个参数fromY ,第四个参数toY:分别是动画起始、结束时Y坐标上的伸缩尺寸。
	 * 另外还可以设置伸缩模式pivotXType、pivotYType， 伸缩动画相对于x,y 坐标的开始位置pivotXValue、pivotYValue等。
	 * float fromX 动画起始时 X坐标上的伸缩尺寸   
	 * float toX 动画结束时 X坐标上的伸缩尺寸   
	 * float fromY 动画起始时Y坐标上的伸缩尺寸   
	 * float toY 动画结束时Y坐标上的伸缩尺寸   
	 * int pivotXType 动画在X轴相对于物件位置类型   
	 * float pivotXValue 动画相对于物件的X坐标的开始位置   
	 * int pivotYType 动画在Y轴相对于物件位置类型   
	 * float pivotYValue 动画相对于物件的Y坐标的开始位置
	 */
	private void openAnimationBt(){
		//初始化  
		Animation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 1.0f, 1.0f,   
				Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f);  
		//设置动画时间  
		scaleAnimation.setDuration(200);  
		ap_bg.startAnimation(scaleAnimation); 
		head_img.startAnimation(scaleAnimation); 
        bt1.startAnimation(scaleAnimation);  
        bt2.startAnimation(scaleAnimation); 
        
        
        //下面是想做旋转+收缩 动画集
        //Animation rotateAnimation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,   
		//		0.5f,Animation.RELATIVE_TO_SELF,0.5f);  
       // rotateAnimation.setDuration(500);  
        
        //AnimationSet animationSet = new AnimationSet(true);
        //animationSet.setDuration(200);//动画持续时间
        //animationSet.addAnimation(scaleAnimation);
        //animationSet.addAnimation(rotateAnimation);
        //head_img.startAnimation(animationSet); 
	}
	
	
	private void cloesAnimationBt(){
		//初始化  
		Animation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 1.0f,   
				Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.1f);  
		//设置动画时间  
		scaleAnimation.setDuration(150); 
		ap_bg.startAnimation(scaleAnimation);  
		//head_img.startAnimation(scaleAnimation); 
        bt1.startAnimation(scaleAnimation);  
        bt2.startAnimation(scaleAnimation); 
	}
	
	/*
	 * 旋转动画
	 * 其中RotateAnimation类第一个参数fromDegrees表示动画起始时的角度， 第二个参数toDegrees表示动画结束时的角度。 
	 * 另外还可以设置伸缩模式pivotXType、pivotYType， 伸缩动画相对于x,y 坐标的开始位置pivotXValue、pivotYValue等。
	 * 参数说明：   
	 * float fromDegrees：旋转的开始角度。   
	 * float toDegrees：旋转的结束角度。   
	 * int pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。   
	 * float pivotXValue：X坐标的伸缩值。   
	 * int pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。   
	 * float pivotYValue：Y坐标的伸缩值。
	 */
	private void open_head_img_RotateAnimation(){
		Animation rotateAnimation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,   
				0.5f,Animation.RELATIVE_TO_SELF,0.5f);  
        rotateAnimation.setDuration(200);  
        head_img.startAnimation(rotateAnimation);  
	}
	
	
}
