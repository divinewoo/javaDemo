package com.gohigh.video.server.info;

/**
 *-------------------------------
 * @author wushaolong  Mar 22, 2011
 * @company gohigh.com.cn
 * @用途：启动UC客户端所需信息
 *-------------------------------
 */
public class LoginInfo {
	private String version = Constant.VIDEO_VERSION;
	private String serverIp;
	private int serverUdpPort = Constant.UDP_PORT;
	private int serverTcpPort = Constant.TCP_PORT;
	private String username;
	private String password;
	/**
	 * 登录视频服务器使用的协议，默认使用UDP
	 */
	private int loginProtocol = Constant.UDP_PROTOCOL;
	/**
	 * 1：最小化启动
	 * 0：非最小化启动
	 */
	private int startAsMinisize = Constant.START_NO_MINISIZE;//

	public LoginInfo(String serverIp, String username, String password) {
		super();
		this.serverIp = serverIp;
		this.username = username;
		this.password = password;
	}

	public LoginInfo() {
		super();
	}

	/**
	 * 将loginProtocol修改为Tcp连接
	 */
	public void changeProtocolToTcp() {
		this.loginProtocol = Constant.TCP_PROTOCOL;
	}
	/**
	 * 将loginProtocol修改为Udp连接
	 */
	public void changeProtocolToUdp() {
		this.loginProtocol = Constant.UDP_PROTOCOL;
	}
	
	/**
	 * 最小化启动UC客户端
	 */
	public void changeStartAsMiniSize(){
		this.startAsMinisize = Constant.START_MINISIZE;
	}
	/**
	 * 非最小化启动UC客户端
	 */
	public void changeStartAsMinNoSize() {
		this.startAsMinisize = Constant.START_NO_MINISIZE;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param serverIp
	 *            the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	/**
	 * @return the serverUdpPort
	 */
	public int getServerUdpPort() {
		return serverUdpPort;
	}

	/**
	 * @param serverUdpPort
	 *            the serverUdpPort to set
	 */
	public void setServerUdpPort(int serverUdpPort) {
		this.serverUdpPort = serverUdpPort;
	}

	/**
	 * @return the serverTcpPort
	 */
	public int getServerTcpPort() {
		return serverTcpPort;
	}

	/**
	 * @param serverTcpPort
	 *            the serverTcpPort to set
	 */
	public void setServerTcpPort(int serverTcpPort) {
		this.serverTcpPort = serverTcpPort;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * @return the loginProtocol
	 */
	public int getLoginProtocol() {
		return loginProtocol;
	}

	/**
	 * @param loginProtocol
	 *            the loginProtocol to set
	 */
	public void setLoginProtocol(int loginProtocol) {
		this.loginProtocol = loginProtocol;
	}

	/**
	 * @return the startAsMinisize
	 */
	public int getStartAsMinisize() {
		return startAsMinisize;
	}

	/**
	 * @param startAsMinisize
	 *            the startAsMinisize to set
	 */
	public void setStartAsMinisize(int startAsMinisize) {
		this.startAsMinisize = startAsMinisize;
	}
	
	/**
	 * 判断登录的核心字段(serverIp, userName, password)是否为空
	 * @return false: 有核心字段为空; true: 核心字段都不为空
	 */
	private boolean checkValid() {
		if(this.getServerIp() == null || this.getServerIp().equals("")) {
			return false;
		}
		if(this.getUsername() == null || this.getUsername().equals("")) {
			return false;
		}
		if(this.getPassword() == null || this.getPassword().equals("")) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		if(!checkValid()) {
			return null;
		}
		return this.getVersion() + "&SrvIP=" + this.getServerIp() + "&SrvUDPPort=" + 
		this.getServerUdpPort() + "&SrvTCPPort=" + this.getServerTcpPort() + "&UserName=" + 
		this.getUsername() + "&Password=" + this.getPassword() + "&loginProtocol=" + this.getLoginProtocol() +
		"&startasminisize=" + this.getStartAsMinisize();
	}
	
	public static void main(String[] args) {
		LoginInfo lInfo = new LoginInfo("www.baidu.com", "wusl", "1234");
		System.out.println(lInfo.toString());
	}
}
