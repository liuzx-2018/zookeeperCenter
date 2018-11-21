package com.noahtest.zkClient.znode;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class ZkClientOperate<T> {

	ZkClient zkClient;
	private String connect = "127.0.0.1:2181";

	public ZkClientOperate() {
		this.zkClient = new ZkClient(connect, 5000, 5000, new SerializableSerializer());
	}

	public boolean exist(String path) {
		return zkClient.exists(path);
	}

	public void setData(String path, Object object) {
		zkClient.writeData(path, object);
	}

	public void Persistent(String path, Object data) {
		zkClient.createPersistent(path, data);
	}

	T readData(String path) {
		return zkClient.readData(path);
	}

	public List<String> getChildren(String path) {
		return zkClient.getChildren(path);

	}

	public void writeData(String path, Object object) {
		zkClient.writeData(path, object);

	}

	// 递归删除
	public void deleteRecursive(String path) {
		zkClient.deleteRecursive(path);
	}

	public void delete(String path) {
		zkClient.delete(path);
	}

	public void close() {
		zkClient.close();
	}

	/***
	 * 支持创建递归方式
	 * 
	 * @param path
	 * @param createParents
	 */
	public void createPersistent(String path, boolean createParents) {
		zkClient.createPersistent(path, createParents);
	}

}