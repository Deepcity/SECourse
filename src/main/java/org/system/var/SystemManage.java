package org.system.var;

import org.data.objects.ProcessManager;
import org.data.objects.ResourceManager;

public class SystemManage {
    private static int pidCounter;
    private static ProcessManager processesManageer;
    private static ResourceManager resourcesManager;

    static {
        resourcesManager = new ResourceManager();
        processesManageer = new ProcessManager();
    }
    public static synchronized int getPidCounter(){
        return pidCounter++;
    }

    public static synchronized boolean registerProcess(String name){
        return true;
    }

    public static double getCurTime() {
        return java.lang.System.currentTimeMillis();
    }
}
