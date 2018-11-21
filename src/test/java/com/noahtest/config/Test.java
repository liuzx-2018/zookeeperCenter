package com.noahtest.config;

import com.noahtest.api.Constant;
import com.noahtest.api.ZnodeConfig;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// 初始化服务中心
		ZnodeConfig node = new ZnodeConfig();
		node.setGroup("vip");
		node.setVersion("1");
		ZkConfigClient client = new ZkConfigClient(18, "lewis");
		ZkConfig config = new ZkConfig(node);
		config.delete(Constant.NODE_PATH + node.getZnodePath());
		// 服务中心监听
		config.listen(Constant.NODE_PATH + node.getZnodePath());
		// 客户端监听
		client.listen(Constant.NODE_PATH + node.getZnodePath());
		config.setData(client);
		config.setData("123456");

		Thread.sleep(2000);
		client.getData(Constant.NODE_PATH + node.getZnodePath());
		client.cache(Constant.NODE_PATH + node.getZnodePath());

	}

}