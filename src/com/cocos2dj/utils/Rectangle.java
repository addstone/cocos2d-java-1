package com.stormframework.util;

import java.io.Serializable;

/**���� <p>
 * ���ա���Сֵ����ֱ�����Ľṹ��¼���ݣ����½������Լ������<p>
 * 
 * @author xu jun
 * Copyright (c) 2012-2014. All rights reserved. */
public class Rectangle implements Serializable, Shape {
	
	private static final long serialVersionUID = 5733252015138115702L;
	
	public final V2 position = new V2();
	public float width, height;

	public Rectangle () {}

	/**@param x ���½�x����
	 * @param y ���½�y����
	 * @param width ��
	 * @param height �� */
	public Rectangle (float x, float y, float width, float height) {
		position.set(x, y);
		this.width = width;
		this.height = height;
	}

	/**����һ�������������ͬ�ľ���
	 * @param ��Ҫ���Ƶľ��� */
	public Rectangle (final Rectangle rect) {
		position.set(rect.position);
		width = rect.width;
		height = rect.height;
	}
	
	/**@return ��ȡ�þ��ε�����X���� */
	public final float getCenterX(){
		return position.x+width/2;
	}
	
	/**@return ��ȡ�þ��ε�����Y���� */
	public final float getCenterY(){
		return position.y+height/2;
	}
	
	/**����rectangle�����½�����*/
	public final void setXY(final float x,final float y){
		position.set(x, y);
	}
	
	/**����rectangle������λ�ã����µ������½����꣩*/
	public final void setCenterXY(final float x,final float y){
		position.set(x-width/2,y-height/2);
	}
	
	/**����ractangle�Ŀ����*/
	public final void setWidthHeight(final float width,final float height){
		this.width=width;
		this.height=height;
	}
	
	public final Rectangle set (final float x, final float y, final float width, final float height) {
		position.set(x, y);
		this.width = width;
		this.height = height;
		return this;
	}
	
	/**������һ�����εĲ���
	 * @param ��Ϊ����Դ�ľ��� */
	public final void set (final Rectangle rect) {
		position.set(rect.position);
		this.width = rect.width;
		this.height = rect.height;
	}

	/**@param rectangel ��Ҫ���Եľ��� {@link Rectangle}.
	 * @return <code>true ��һ��rectangle�����ڴ�rectangle�� <br>
	 * false ��һ������û�б���rectangle���� */
	public final boolean contains (final Rectangle rectangle) {
		final float xmin = rectangle.position.x;
		final float xmax = xmin + rectangle.width;

		final float ymin = rectangle.position.y;
		final float ymax = ymin + rectangle.height;

		return ((xmin > position.x && xmin < position.x + width) 
				&& (xmax > position.x && xmax < position.x + width))
				&& ((ymin > position.y && ymin < position.y + height) 
				&& (ymax > position.y && ymax < position.y + height));
	}

	/**@param rectangle {@link Rectangle}
	 * @return <code>true ���������ཻ <br>
	 * false �������β��ཻ */
	public final boolean overlaps (final Rectangle another) {
		float t;
		if((t = position.x - another.position.x) > another.width || -t > width)
			return false;
		if((t = position.y - another.position.y) > another.height || -t > height)
		    return false;
		return true;
	}
	
	public final boolean overlaps (final float x, final float y, 
			final float width, final float height) {
		float t;
		if((t = position.x - x) > width || -t > this.width)
			return false;
		if((t = position.y - y) > height || -t > this.height)
		    return false;
		return true;
	}

	/**@param x ������x����
	 * @param y ������y����
	 * @return <code>true ���������ڴ�rectangle�� <br>
	 * false �����û�б���rectangle���� */
	public final boolean contains (final float x, final float y) {
		return position.x < x && position.x + width > x 
				&& position.y < y && position.y + height > y;
	}

	/**�ں�����rect��ʹ�µ�rect���԰���֮ǰ������rect��
	 * @param rect ��һ��rect */
	public final void merge (final Rectangle rect) {
		final float minX = Math.min(position.x, rect.position.x);
		final float maxX = Math.max(position.x + width, rect.position.x + rect.width);
		position.x = minX;
		width = maxX - minX;

		final float minY = Math.min(position.y, rect.position.y);
		final float maxY = Math.max(position.y + height, rect.position.y + rect.height);
		position.y = minY;
		height = maxY - minY;
	}

	public String toString () {
		return position+"," + width + "," + height;
	}
}

