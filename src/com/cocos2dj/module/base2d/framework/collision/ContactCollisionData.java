package com.cocos2dj.module.base2d.framework.collision;

/**��ײ����<p>
 * 
 * @author xujun
 * Copyright (c) 2015-2016. All rights reserved. */
public class ContactCollisionData {
	
//	/**��ײ�� */
//	public V2 point;
//	
//	/**�ཻ��� */
//	public float depth;

	public boolean isXZ = false;
	
	/**Ӧ���ṩ��ײ������shape */
	public Shape shape1;
	
	public Shape shape2;

	public void clear() {
		shape1 = null;
		shape2 = null;
	}
}
