package Socket;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class pid {
	public String getProcessId() {
	    RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
	    String name = runtime.getName();
	    return name.split("@")[0]; // PID is before the '@' symbol
	}

}
