package com.gohigh.video.server.info;

/**
 *-------------------------------
 * @author wushaolong  Mar 22, 2011
 * @company gohigh.com.cn
 * @��;������UC�ͻ���������Ϣ
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
	 * ��¼��Ƶ������ʹ�õ�Э�飬Ĭ��ʹ��UDP
	 */
	private int loginProtocol = Constant.UDP_PROTOCOL;
	/**
	 * 1����С������
	 * 0������С������
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
	 * ��loginProtocol�޸�ΪTcp����
	 */
	public void changeProtocolToTcp() {
		this.loginProtocol = Constant.TCP_PROTOCOL;
	}
	/**
	 * ��loginProtocol�޸�ΪUdp����
	 */
	public void changeProtocolToUdp() {
		this.loginProtocol = Constant.UDP_PROTOCOL;
	}
	
	/**
	 * ��С������UC�ͻ���
	 */
	public void changeStartAsMiniSize(){
		this.startAsMinisize = Constant.START_MINISIZE;
	}
	/**
	 * ����С������UC�ͻ���
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
	 * �жϵ�¼�ĺ����ֶ�(serverIp, userName, password)�Ƿ�Ϊ��
	 * @return false: �к����ֶ�Ϊ��; true: �����ֶζ���Ϊ��
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
