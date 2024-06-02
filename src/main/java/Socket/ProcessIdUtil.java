package Socket;

import java.lang.management.ManagementFactory;

public class ProcessIdUtil {
    public static String getProcessId() {
        // Get the name of the running Java virtual machine
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        // Extract the process ID from the JVM name
        return jvmName.split("@")[0];
    }
}