package com.gohigh.video.server.info;

/**
 * -------------------------------
 * 
 * @author wushaolong Mar 22, 2011
 * @company gohigh.com.cn
 * @��;�� ע���������������User 
 * -------------------------------
 */
public class NetUser {
	private String name;
	private String password;

	public NetUser(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public NetUser() {
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
