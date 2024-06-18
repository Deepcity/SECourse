package org.data.objects;

import org.system.var.SystemManage;

public class PCB implements Runnable{
    int ID = 0;                           // 进程ID
    double arr_time = 0;                  // 进程到达时间
    double ser_time = 0;                  // 进程服务时间
    double fin_time = 0;                  // 进程完成时间
    int priority = 80;                    // 进程优先级
    double cyc_time = 0;                  // 周转时间
    double autcyc_time = 0;               // 带权周转时间
    double last_sertime = 0;              // 剩余服务时间
    int statu = 0;                        // 表示进程状态 0：就绪状态， 1： 运行状态 2： 等待状态

    public PCB() {
        ID = SystemManage.getPidCounter();
        arr_time = SystemManage.getCurTime();
    }

    public void printPCBInfo() {
        System.out.println("------------------------------");
        System.out.println("进程PID:" + ID);
        System.out.println("进程到达时间:" + arr_time);
        System.out.println("进程服务时间:" + ser_time);
        System.out.println("进程完成时间:" + fin_time);
        System.out.println("进程优先级:" + priority);
        System.out.println("周转时间" + cyc_time);
        System.out.println("带权周转时间" + autcyc_time);
        System.out.println("剩余服务时间" + last_sertime);
        System.out.println("运行状态" + statu);
        System.out.println("\n");
    }

    public int getID() {
        return ID;
    }

    // 减少剩余服务时间
    public void reduceRemainingTime(double time) {
        last_sertime -= time;
    }

    // 获取剩余服务时间
    public double getRemainingTime() {
        return last_sertime;
    }

    @Override
    public void run(){
        System.out.println("Running");
    }
}
