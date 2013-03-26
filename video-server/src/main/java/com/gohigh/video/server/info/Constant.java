package com.gohigh.video.server.info;

public class Constant {
	//配置文件名
	public final static String PROPERTY_FILE_NAME = "user.properties";
	
	//error message
	public final static String SERVER_IP_ERROR = "ServerIp of Video-client is null or invalid.";
	public final static String VIDEO_USER_ERROR = "videoUser of Video-client is invalid.";
	public final static String VIDEO_PASS_ERROR = "videoPass of Video-client is invalid.";
	
	//UC客户端参数默认值
	public final static int TCP_PROTOCOL = 0;
	public final static int UDP_PROTOCOL = 1;
	
	public static int TCP_PORT = 11010;
	public static int UDP_PORT = 8000;
	
	public final static int START_MINISIZE = 1;
	public final static int START_NO_MINISIZE = 0;
	
	public static String VIDEO_VERSION = "IA2#";
	
	//properties中key
	public final static String NET_USER_KEY = "netUser";
	public final static String NET_PASS_KEY = "netPass";
	public final static String SERVER_IP_KEY = "serverIp";
	public final static String VIDEO_USER_KEY = "videoUser";
	public final static String VIDEO_PASS_KEY = "videoPass";
	public final static String VIDEO_UDP_PORT_KEY = "videoUdpPort";
	public final static String VIDEO_TCP_PORT_KEY = "videoTcpPort";
	public final static String VIDEO_PROTOCOL_KEY = "videoProtocol";
	public final static String VIDEO_START_MINI_KEY = "videoStartMini";
	public final static String VIDEO_VERSION_KEY= "videoVersion";
	
}
