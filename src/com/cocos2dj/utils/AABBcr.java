package com.stormframework.util;

/**
 * aabb�����ġ����뾶��ʽ����
 */

public class AABBcr {
	//===========================================================//
	//                         Fields                            //
	//===========================================================//
	public V2 			centerP;  
	public float 		halfWidth;
	public float 		halfHeight;
	//===========================================================//
	//                      Constructors                         //
	//===========================================================//
	/*************************************************************
	 * Ĭ�ϴ���һ���˻�Ϊ��ľ���
	 */
	public AABBcr(){
	/*************************************************************/
		this.centerP=new V2();
	}
	
	/*************************************************************
	 * ������һ�����ε�����
	 * @param another
	 */
	public AABBcr(AABBcr another){
	/*************************************************************/
		this.centerP=another.centerP;
		this.halfHeight=another.halfHeight;
		this.halfWidth=another.halfWidth;
	}
	
	/*************************************************************
	 * @param centerP
	 * @param halfWidth
	 * @param halfHeight
	 */
	public AABBcr(V2 centerP,float halfWidth,float halfHeight){
	/*************************************************************/
		this.centerP=centerP;
		this.halfHeight=halfHeight;
		this.halfWidth=halfWidth;
	}
	
	/*************************************************************
	 * @param centerX
	 * @param centerY
	 * @param halfWidth
	 * @param halfHeight
	 */
	public AABBcr(float centerX,float centerY,float halfWidth,float halfHeight){
	/*************************************************************/
		this.centerP=new V2(centerX,centerY);
		this.halfHeight=halfHeight;
		this.halfWidth=halfWidth;
	}
	//===========================================================//
	//                     Getter & Setter                       //
	//===========================================================//
	public float getLeft(){
		return centerP.x-halfWidth;
	}
	
	public float getTop(){
		return centerP.y-halfHeight;
	}
	
	public float getRight(){
		return centerP.x+halfWidth;
	}
	
	public float getBottom(){
		return centerP.y+halfHeight;
	}
	//===========================================================//
	//          Methods for/from SuperClass/Interfaces           //
	//===========================================================//
	public final AABBcr clone(){
		return new AABBcr(this);
	}
	
	public String toString(){
		return("center: x="+centerP.x+" y="+centerP.y+"  hwidth:"
				+halfWidth+" hheight:"+halfHeight);
	}
	//===========================================================//
	//                         Methods                           //
	//===========================================================//
	/*************************************************************
	 * ����С���ֵ����AABB
	 * (x1,y2)-(x2,y2)
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public final void setAABB(float x1,float y1,float x2,float y2){
	/*************************************************************/
		centerP.x=(x1+x2)/2;
		centerP.y=(y1+y2)/2;
		halfWidth=Math.abs(x2-x1)/2;
		halfHeight=Math.abs(y2-y1)/2;
	}
	
	/*************************************************************
	 * ����λ��(centerX,centerY)
	 * @param centerX
	 * @param centerY
	 */
	public final void updateAABB(float centerX, float centerY){
	/*************************************************************/
		this.centerP.set(centerX, centerY);
	}
	
	/*************************************************************
	 * ����λ��V2
	 * @param center
	 */
	public final void updateAABB(V2 center){
	/*************************************************************/
		this.centerP.x=center.x;
		this.centerP.y=center.y;
	}
	
	/*************************************************************
	 * ��offset�ƶ�AABB
	 * @param offset
	 */
	public final void moveAABB(V2 offset){
	/*************************************************************/
		this.centerP.x+=offset.x;
		this.centerP.y+=offset.y;
	}
	
	/*************************************************************
	 * ����λ���뷶Χ(centerX,centerY,hW,hH)
	 * @param centerX
	 * @param centerY
	 * @param halfWidth
	 * @param halfHeight
	 */
	public final void updateAABB(float canterX, float centerY, float hW, float hH){
	/*************************************************************/
		this.centerP.set(canterX, centerY);
		this.halfHeight=hH;
		this.halfWidth=hW;
	}
	
	/*************************************************************
	 * ���跶Χ(halfWidth,halfHeight)
	 * @param halfWidth
	 * @param halfHeight
	 */
	public final void reSetAABB(float halfWidth, float halfHeight){
	/*************************************************************/
		this.halfHeight=halfHeight;
		this.halfWidth=halfWidth;
	}
	
	/*************************************************************
	 * ���AABB����ȷ��
	 * @return  true ��AABB��Ч
	 */
	public final boolean isInvalid(){
	/*************************************************************/
		return this.halfHeight<0||this.halfWidth<0;
	}
	
	/*************************************************************
	 * ���Ը�AABB�Ƿ�����һ��AABB a��
	 * @param  a
	 * @return true  a������AABB
	 * 		   flase aû�а�����AABB	
	 */
	public final boolean testInAABB(AABBcr a){
	/*************************************************************/
		return (centerP.x-halfWidth>=a.centerP.x-a.halfWidth
				&&centerP.x+halfWidth<=a.centerP.x+a.halfWidth
				&&centerP.y-halfHeight>=a.centerP.x-a.halfHeight
				&&centerP.y+halfHeight<=a.centerP.y+a.halfHeight);
	}
	
	/*************************************************************
	 * �����another���ཻ
	 * @param another
	 * @return  true=�ཻ
	 */
	public final boolean testAABB(AABBcr another){
	/*************************************************************/
		if(Math.abs(this.centerP.x-another.centerP.x)>(this.halfWidth+another.halfWidth))
			return false;
		if(Math.abs(this.centerP.y-another.centerP.y)>(this.halfHeight+another.halfHeight))
			return false;
		return true;
	}
	
	/*************************************************************
	 * ���AABB a��AABB b���ཻ
	 * @param a
	 * @param b
	 * @return true=�ཻ
	 */
	public static final boolean testAABBAABB(final AABBcr a,final AABBcr b){
	/*************************************************************/
		if(Math.abs(a.centerP.x-b.centerP.x)>(a.halfWidth+b.halfWidth))
			return false;
		if(Math.abs(a.centerP.y-b.centerP.y)>(a.halfHeight+b.halfHeight))
			return false;
		return true;
	}
	
	/*************************************************************
	 * ���AABB����ȷ��
	 * @return  true ��AABB��Ч
	 */
	public static final boolean isInvalid(AABBcr a){
	/*************************************************************/
		return a.halfHeight<0||a.halfWidth<0;
	}
    //===========================================================//
	//                Inner and Anonymous Classes                //
	//===========================================================//
}

