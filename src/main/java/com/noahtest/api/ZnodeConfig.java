package com.noahtest.api;

/**
 * 节点封装
 */
public class ZnodeConfig {

	private String group;
	private String version;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getZnodePath() {
		return "-" + group + "-" + version;
	}

}
