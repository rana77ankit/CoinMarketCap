package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

public class AppiumServer {

	public static AppiumDriverLocalService service;
	private static String appiumServerIp;

	public static boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AppiumServiceBuilder start() {
		appiumServerIp = BaseClass.prop.getProperty("server_ip");
		AppiumServiceBuilder builder = new AppiumServiceBuilder();

		if (!checkIfServerIsRunning(getPort())) {

			//Build the Appium service
			builder.withIPAddress(appiumServerIp);
			builder.usingPort(getPort());

			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

			//Start the server with the builder
			service = AppiumDriverLocalService.buildService(builder);
			service.start();
		}

		return builder;

	}

	private static int getPort() {
		return Integer.valueOf(BaseClass.prop.getProperty("server_port"));
	}

	public static URL getAppiumUrl() {
		return service.getUrl();
	}

	public static void stop() {
		if (service != null) {
			try {
				service.stop();
			} catch (Exception e) {
				if (service.isRunning()) {
					service.stop();
				}
			}
		}
	}

}
