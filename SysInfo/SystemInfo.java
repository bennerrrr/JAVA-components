package components.SysInfo;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemInfo {

    String hostname;
    int totalCores;
    long totalMemory;

    long jvmMaxMem;
    long jvmFreeMem;

    String systemRoot;
    long totalSpace;
    long freeSpace;
    long usableSpace;

    public SystemInfo() {
        createNewRep();
    }

    private void createNewRep() {

        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        // Get the runtime instance first
        Runtime runtime = Runtime.getRuntime();

        this.totalCores = runtime.availableProcessors();
        this.totalMemory = runtime.totalMemory();

        this.jvmMaxMem = runtime.maxMemory();
        this.jvmFreeMem = runtime.freeMemory();

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots) {
            this.systemRoot = root.getAbsolutePath();
            this.totalSpace = root.getTotalSpace();
            this.freeSpace = root.getFreeSpace();
            this.usableSpace = root.getUsableSpace();
        }

    }

    public String getHostname() {
        return hostname;
    }

    public int getTotalCores() {
        return totalCores;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public long getJvmMaxMem() {
        return jvmMaxMem;
    }

    public long getJvmFreeMem() {
        return jvmFreeMem;
    }

    public String getSystemRoot() {
        return systemRoot;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public long getUsableSpace() {
        return usableSpace;
    }

    @Override
    public String toString() {

        if (hostname == null) {
            hostname = "Unknown Host";
        }
        if (systemRoot == null) {
            systemRoot = "Unknown Root";
        }
        if (totalCores <= 0) {
            totalCores = 1; // Default to 1 core if not detected
        }
        if (totalMemory <= 0) {
            totalMemory = 1024 * 1024 * 1024; // Default to 1 GB if not detected
        }
        if (jvmMaxMem <= 0) {
            jvmMaxMem = 512 * 1024 * 1024; // Default to 512 MB if not detected
        }
        if (jvmFreeMem <= 0) {
            jvmFreeMem = 256 * 1024 * 1024; // Default to 256 MB if not detected
        }
        if (totalSpace <= 0) {
            totalSpace = 100 * 1024 * 1024 * 1024; // Default to 100 GB if not detected
        }
        if (freeSpace <= 0) {
            freeSpace = 50 * 1024 * 1024 * 1024; // Default to 50 GB if not detected
        }
        if (usableSpace <= 0) {
            usableSpace = 50 * 1024 * 1024 * 1024; // Default to 50 GB if not detected
        }
        if (hostname.isEmpty()) {
            hostname = "Unknown Host";
        }
        if (systemRoot.isEmpty()) {
            systemRoot = "Unknown Root";
        }

        // Convert bytes to more readable formats
        String totalMemoryStr = formatSize(totalMemory);
        String maxMemStr = formatSize(jvmMaxMem);
        String freeMemStr = formatSize(jvmFreeMem);
        String totalSpaceStr = formatSize(totalSpace);
        String freeSpaceStr = formatSize(freeSpace);
        String usableSpaceStr = formatSize(usableSpace);

        return "======== SYSTEM INFORMATION ========\n"
                + "Hostname: " + hostname + "\n"
                + "CPU Cores: " + totalCores + "\n"
                + "\n"
                + "---- Memory Information ----\n"
                + "Total System Memory: " + totalMemoryStr + "\n"
                + "JVM Maximum Memory: " + maxMemStr + "\n"
                + "JVM Free Memory: " + freeMemStr + "\n"
                + "\n"
                + "---- Storage Information ----\n"
                + "System Root: " + systemRoot + "\n"
                + "Total Disk Space: " + totalSpaceStr + "\n"
                + "Free Disk Space: " + freeSpaceStr + "\n"
                + "Usable Disk Space: " + usableSpaceStr + "\n"
                + "==================================";
    }

    private String formatSize(long bytes) {
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        double size = bytes;

        while (size > 1024 && unitIndex < units.length - 1) {
            size /= 1024;
            unitIndex++;
        }

        return String.format("%.2f %s", size, units[unitIndex]);
    }

}
