package com.stormframework.util;

/**
 * ������Χ��
 * @˵��	������"Сֵ-ֱ��"��ʽ����
 */

public class AABBmd {
	//===========================================================//
	//                         Fields                            //
	//===========================================================//
	public float minX;
	public float minY;
	public float dW;
	public float dH;
	//===========================================================//
	//                      Constructors                         //
	//===========================================================//
	/*************************************************************
	 * @param minX	��СֵX
	 * @param minY  ��СֵY
	 * @param dW    X����ֱ��
	 * @param dH    Y����ֱ��
	 */
	public AABBmd(float minX, float minY, float dW, float dH){
	/*************************************************************/
		this.minX=minX;
		this.minY=minY;
		this.dH=dH;
		this.dW=dW;
	}
	//===========================================================//
	//                         Methods                           //
	//===========================================================//
	/*************************************************************
	 * ����λ��(minX,minY)
	 * @param minX
	 * @param minY
	 */
	public final void updateAABB(float minX, float minY){
	/*************************************************************/
		this.minX=minX;
		this.minY=minY;
	}
	
	/*************************************************************
	 * ����λ���뷶Χ(minX,minY,dW,dH)
	 * @param minX
	 * @param minY
	 * @param dW
	 * @param dH
	 */
	public final void updateAABB(float minX, float minY, float dW, float dH){
	/*************************************************************/
		this.minX=minX;
		this.minY=minY;
		this.dH=dH;
		this.dW=dW;
	}
	
	/*************************************************************
	 * ���跶Χ(dW,dH)
	 * @param dW
	 * @param dH
	 */
	public final void reSetAABB(float dW, float dH){
	/*************************************************************/
		this.dH=dH;
		this.dW=dW;
	}
	
	/*************************************************************
	 * �������һAABB���ཻ
	 * @param 	another  �����AABB
	 * @return	true �ཻ
	 */
	public final boolean testAABB(AABBmd another){
	/*************************************************************/
		float t;
		if((t=minX-another.minX)>another.dW||-t>dW)
			return false;
		if((t=minY-another.minY)>another.dH||-t>dH)
		    return false;
		return true;
	}
	
	/*************************************************************
	 * ���AABB����ȷ��
	 * @return  true ��AABB��Ч
	 */
	public final boolean isInvalid(){
	/*************************************************************/
		return dW<0||dH<0;
	}
	
	/*************************************************************
	 * ���Ը�AABB�Ƿ�����һ��AABB��
	 * @param  another
	 * @return true  another������AABB
	 * 		   flase anotherû�а�����AABB	
	 */
	public final boolean testInAABB(AABBmd another){
	/*************************************************************/
		return (minX>=another.minX&&minX+dW<=another.minX+another.dW
				&&minY>=another.minY&&minY+dH<=another.minY+another.dH);
	}
	
	/*************************************************************
	 * ���AABB a �Ƿ���  AABB b��
	 * @param a  ������AABB
	 * @param b  ����AABB
	 * @return   true  b����a
	 * 		     flase bû�а���a
	 */
	public static final boolean testAABBInAABB(AABBmd a, AABBmd b){
	/*************************************************************/
		return (a.minX>=b.minX&&a.minX+a.dW<=b.minX+b.dW
				&&a.minY>=b.minY&&a.minY+a.dH<=b.minY+b.dH);
	}
	
	/*************************************************************
	 * �������AABB���ཻ
	 * @param a  ����AABB a
	 * @param b  ����AABB b
	 * @return   ture �ཻ
	 */
	public static final boolean testAABBAABB(AABBmd a,AABBmd b){
	/*************************************************************/
		float t;
		if((t=a.minX-b.minX)>b.dW||-t>a.dW)
			return false;
		if((t=a.minY-b.minY)>b.dH||-t>a.dH)
		    return false;
		return true;
	}
	
	/*************************************************************
	 * ���AABB����ȷ��
	 * @return  true ��AABB��Ч
	 */
	public static final boolean isInvalid(AABBmd a){
	/*************************************************************/
		return a.dW<0||a.dH<0;
	}
    //===========================================================//
	//                Inner and Anonymous Classes                //
	//===========================================================//
}

