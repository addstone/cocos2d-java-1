package com.stormframework.util;

/**Բ�� ��Բ�ġ����뾶�Ľṹ����<p>
 * 
 * @author xu jun
 * Copyright (c) 2012-2014. All rights reserved. */
public class Circle implements Shape {
	/**Բ�ĵ�����*/
	public float x,y;
	/**Բ�İ뾶*/
	public float radius;
	
	public Circle() {}
	public Circle(final float x,final float y,final float radius) {
		this.set(x, y, radius);
	}
	public Circle(Circle other) {
		this.set(other);
	}
	
	
	/**����Բ������
	 * @param x
	 * @param y
	 * @param radius */
	public final void set(final float x,final float y,final float radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	/**������һԲ������
	 * @param other */
	public final void set(final Circle other) {
		this.x=other.x;
		this.y=other.y;
		this.radius=other.radius;
	}
	
	
	/**@param x ���Ե��x����
	 * @param y ���Ե��y����
	 * @return <code>true ���Ե������Բ�� false ���Ե���Բ��*/
	public final boolean contains(final float x,final float y) {
		final float dx=x-this.x;
		final float dy=y-this.y;
		return(dx*dx+dy*dy <= radius*radius);
	}
	
}
