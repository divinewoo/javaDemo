package com.gohigh.video.server.info;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.gohigh.video.server.exception.InValidPropertyException;

/**
 *-------------------------------
 * @author wushaolong  Mar 23, 2011
 * @company gohigh.com.cn
 * @用途： 获取properties文件中配置信息的工具类
 *-------------------------------
 */
public class UserUtility {
	private static Properties getInfoProperties() {
		String userInfoPath = System.getProperty("user.dir") + "\\" + Constant.PROPERTY_FILE_NAME;
		InputStream input;
		try {
			input = new BufferedInputStream(new FileInputStream(userInfoPath));
		} catch (Exception e) {
			input = UserUtility.class.getResourceAsStream("/" + Constant.PROPERTY_FILE_NAME);
		}
		Properties properties = new Properties();
		try {
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return properties;
	}

	public static NetUser getNetUser() {
		NetUser user = null;
		Properties properties = UserUtility.getInfoProperties();
		if (properties != null) {
			user = new NetUser();
			user.setName(properties.getProperty(Constant.NET_USER_KEY));
			user.setPassword(properties.getProperty(Constant.NET_PASS_KEY));
		}
		return user;
	}
	
	public static String getValueByName(String name) {
		Properties properties = UserUtility.getInfoProperties();
		if (properties != null) {
			return properties.getProperty(Constant.VIDEO_USER_KEY);
		}
		return null;
	}

	public static LoginInfo getLoginInfo() {
		LoginInfo user = null;
		Properties properties = UserUtility.getInfoProperties();
		if (properties != null) {
			user = new LoginInfo();
			if (propertyIsValid(Constant.SERVER_IP_KEY, properties)) {
				user.setServerIp(properties.getProperty(Constant.SERVER_IP_KEY));
			} else {
				throw new InValidPropertyException(Constant.SERVER_IP_ERROR);
			}
			if (propertyIsValid(Constant.VIDEO_USER_KEY, properties)) {
				user.setUsername(properties.getProperty(Constant.VIDEO_USER_KEY));
			} else {
				throw new InValidPropertyException(Constant.VIDEO_USER_ERROR);
			}
			if (propertyIsValid(Constant.VIDEO_PASS_KEY, properties)) {
				user.setPassword(properties.getProperty(Constant.VIDEO_PASS_KEY));
			} else {
				throw new InValidPropertyException(Constant.VIDEO_PASS_ERROR);
			}
			if (propertyIsValid(Constant.VIDEO_VERSION_KEY, properties)) {
				user.setVersion(properties.getProperty(Constant.VIDEO_VERSION_KEY));
			}
			if (propertyIsValid(Constant.VIDEO_UDP_PORT_KEY, properties)) {
				user.setServerUdpPort(Integer.parseInt(properties.getProperty(Constant.VIDEO_UDP_PORT_KEY)));
			}
			if (propertyIsValid(Constant.VIDEO_TCP_PORT_KEY, properties)) {
				user.setServerTcpPort(Integer.parseInt(properties.getProperty(Constant.VIDEO_TCP_PORT_KEY)));
			}
			if (propertyIsValid(Constant.VIDEO_PROTOCOL_KEY, properties)) {
				user.setLoginProtocol(Integer.parseInt(properties.getProperty(Constant.VIDEO_PROTOCOL_KEY)));
			}
			if (propertyIsValid(Constant.VIDEO_START_MINI_KEY, properties)) {
				user.setStartAsMinisize(Integer.parseInt(properties.getProperty(Constant.VIDEO_START_MINI_KEY)));
			}
		}
		return user;
	}

	private static boolean propertyIsValid(String name, Properties p) {
		if (p == null) {
			return false;
		}
		String value = p.getProperty(name);
		if (value == null || value.equals("")) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		NetUser user = UserUtility.getNetUser();
		System.out.println(user.getName() + "++++" + user.getPassword());
		LoginInfo info = UserUtility.getLoginInfo();
		System.out.println(info);
	}
}
