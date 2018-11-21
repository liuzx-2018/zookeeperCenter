package com.noahtest.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.noahtest.zkClient.watcher.ZkClientWatcher;

public class ZkConfigClient extends ZkClientWatcher<Object> {

	private Integer age;

	private String name;

	public void listen(String path) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("客户端监听");
		this.lister(path);
	};

	public void getData(String path) {
		System.out.println("得到服务中心发送的消息" + this.readData(path));
		this.readData(path);
	};

	// 本地备份数据
	public void cache(String path) {
		// 1. 创建缓存管理器
		CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

		// 2. 获取缓存对象
		Cache cache = cacheManager.getCache("HelloCache");

		// 3. 创建元素
		Element element = new Element("key", this.readData(path));

		// 4. 将元素添加到缓存
		cache.put(element);

		// 5. 获取缓存
		Element value = cache.get("key");
		System.out.println("备份数据,放入缓存" + value);
		// System.out.println(value.getObjectValue());

		// 7. 刷新缓存
		cache.flush();

		// 8. 关闭缓存管理器
		cacheManager.shutdown();
	}

	public Integer getId() {
		return age;
	}

	public void setId(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZkConfigClient(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

}
