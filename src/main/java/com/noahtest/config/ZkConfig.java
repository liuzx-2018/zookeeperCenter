package com.noahtest.config;

import com.alibaba.fastjson.JSON;
import com.noahtest.api.Constant;
import com.noahtest.api.ZnodeConfig;
import com.noahtest.zkClient.watcher.ZkClientWatcher;

/**
 * 配置中心
 */
public class ZkConfig extends ZkClientWatcher<Object> {

	private ZnodeConfig znodeConfig;

	public ZkConfig(ZnodeConfig znodeConfig) {
		this.znodeConfig = znodeConfig;
	}

	public void listen(String path) {
		System.out.println("服务中心监听");
		this.lister(path);
	};

	public void setData(Object data) {
		if (!this.exist(Constant.NODE_PATH + znodeConfig.getZnodePath())) {
			System.out.println("成功连接服务中心，当前节点为： " + Constant.NODE_PATH + znodeConfig.getZnodePath()
			        + "数据为:  " + JSON.toJSONString(data));
			this.createEphemeral(Constant.NODE_PATH + znodeConfig.getZnodePath(), JSON.toJSONString(data));
		} else {
			System.out.println("向客户端发送数据： " + JSON.toJSONString(data) + "节点为：" + Constant.NODE_PATH
			        + znodeConfig.getZnodePath());
			this.writeData(Constant.NODE_PATH + znodeConfig.getZnodePath(), JSON.toJSONString(data));
		}
	}

	public void deleteRecursive(String path) {
		this.deleteRecursive(path);
	}

	public void delete(String path) {
		this.delete(path, -1);
	}
}