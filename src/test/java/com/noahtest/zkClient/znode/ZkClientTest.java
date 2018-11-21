package com.noahtest.zkClient.znode;

public class ZkClientTest {

	public static void main(String[] args) {
		ZkClientOperate zkClientOperate = new ZkClientOperate();
		User user = new User();
		user.setAge(18);
		user.setName("666");
		zkClientOperate.Persistent("/aaa", user);
		System.out.println(zkClientOperate.readData("/aaa"));
	}

}
