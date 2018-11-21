package com.noahtest.zkClient.watcher;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ZkClientWatcher watcher = new ZkClientWatcher();
		String path = "/xun666";
		watcher.lister(path);
		watcher.deleteRecursive(path);
		watcher.createPersistent(path, "666");
		Thread.sleep(2000);
		watcher.writeData(path, "777777");
		watcher.deleteRecursive(path);
		Thread.sleep(Integer.MAX_VALUE);

	}

}