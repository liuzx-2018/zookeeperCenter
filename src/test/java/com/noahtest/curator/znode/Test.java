package com.noahtest.curator.znode;/* ━━━━━━如来保佑━━━━━━
* 　　　┏┓　　　┏┓
* 　　┏┛┻━━━┛┻┓
* 　　┃　　　━　　　┃
* 　　┃　┳┛　┗┳　┃
* 　　┃　　　┻　　　┃
* 　　┗━┓　　　┏━┛
* 　　　　┃　　　┗━━━┓
* 　　　　┃　　　　　　　┣┓
* 　　　　┃　　　　　　　┏┛
* 　　　　┗┓┓┏━┳┓┏┛
* 　　　　　┗┻┛　┗┻┛
* ━━━━━━永无BUG━━━━━━
* 图灵学院-悟空老师
* 以往视频加小乔老师QQ：895900009
* 悟空老师QQ：245553999
*/

public class Test {
	public static void main(String[] args) {
		CuratorCrud zkClientCrud = new CuratorCrud();
		zkClientCrud.createPersistent("/wukong/abc", "abc");
		System.out.println(zkClientCrud.getData("/wukong/abc/ccc/d/d/daew/ew/ewew/"));
		;

	}
}
