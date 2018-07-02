package com.mie.sa.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
* @ClassName: ClientUtils  
* @Description: TODO(客户端操作)  
* @author wzy
* @date 2018年6月9日 下午4:29:48
*
 */
public class ClientUtils {

	private static Logger logger = LoggerFactory.getLogger(ClientUtils.class);

	/**
	 * 获取客户端请求IP地址
	 * @param request
	 * @return
	 */
	public static String getRequestIP(HttpServletRequest request) {
		try {
			if (null == request) {
				logger.error("请求对象为空，无法获取客户端IP请求地址");
				return null;
			}
			String ipAddress = null;
			// ipAddress = request.getRemoteAddr();
			ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();
				if (ipAddress.equals("127.0.0.1")) {
					// 根据网卡取本机配置的IP
					InetAddress inet = null;
					try {
						inet = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						logger.error("根据网卡取本机配置的IP出错", e);
					}
					ipAddress = inet.getHostAddress();
				}

			}

			// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
			// "***.***.***.***".length() = 15
			if (ipAddress != null && ipAddress.length() > 15) {
				if (ipAddress.indexOf(",") > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
			return ipAddress;
		} catch (Throwable t) {
			logger.error("获取客户端请求IP出错", t);
			return null;
		}
	}
	
}
