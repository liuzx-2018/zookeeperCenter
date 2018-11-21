package com.noahtest.zkClient.watcher;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZkClientWatcher<T> {

	ZkClient zkClient;
	private String connectString = "127.0.0.1:2181";

	public ZkClientWatcher() {
		this.zkClient = new ZkClient(connectString, 5000, 5000, new SerializableSerializer());
	}

	public T readData(String path) {
		return zkClient.readData(path);

	}

	public List<String> getChildren(String path) {
		return zkClient.getChildren(path);

	}

	public void writeData(String path, Object object) {
		zkClient.writeData(path, object);

	}

	public void deleteRecursive(String path) {
		zkClient.deleteRecursive(path);

	}

	public void delete(String path, int version) {
		zkClient.delete(path, version);
	}

	/***
	 *
	 * @param path
	 * @param data
	 */
	public void createPersistent(String path, Object data) {
		zkClient.createPersistent(path, data);
	}

	public void createEphemeral(String path, Object data) {
		zkClient.createEphemeral(path, data);
	}

	public void close() {
		zkClient.close();
	}

	public boolean exist(String path) {
		return zkClient.exists(path);
	}

	public void lister(String path) {
		// 父节点添加监听变化
		zkClient.subscribeDataChanges(path, new IZkDataListener() {
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.printf("节点变成：%s,%s", dataPath, data);

			}

			public void handleDataDeleted(String dataPath) throws Exception {
				System.out.printf("删除的节点为：%s", dataPath);
			}

		});
		// 对父节点添加监听子节点变化。
		zkClient.subscribeChildChanges(path, new IZkChildListener() {
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println("parentPath: " + parentPath + ",currentChilds:" + currentChilds);
			}
		});
		// 对父节点添加监听子节点变化
		zkClient.subscribeStateChanges(new IZkStateListener() {
			public void handleStateChanged(KeeperState state) throws Exception {
				if (state == Watcher.Event.KeeperState.SyncConnected) {
					// 当我重新启动后start，监听触发
					System.out.println("连接成功");
				} else if (state == Watcher.Event.KeeperState.Disconnected) {
					System.out.println("连接断开");// 当我在服务端将zk服务stop时，监听触发
				} else
					System.out.println("其他状态" + state);
			}

			public void handleSessionEstablishmentError(Throwable error) throws Exception {
				System.out.println("重建session");

			}

			public void handleNewSession() throws Exception {
			}
		});
	}

}