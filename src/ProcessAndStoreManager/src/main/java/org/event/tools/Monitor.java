package org.event.tools;

import org.GUI.menus.BankersAlgorithmSimulation;
import org.GUI.menus.GUI;
import org.GUI.menus.ProducterAndConsumer;
import org.data.objects.ResourceManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

//代理类
public class Monitor extends AbstractMonitor{
    @Override
    public void actionPerformed(ActionEvent e) {
        //actionPerformed()
        System.out.println("A Button has been pressed!\n" +
                "the relative info is:" + e.getActionCommand());
        String eventMessage = e.getActionCommand();
        if (eventMessage.equals("生产者消费者")) {
            ProducterAndConsumer.getInstance();
            ResourceManager.getInstance().getObservable().subscribe(ProducterAndConsumer.getInstance().getObserver());
        } else if (eventMessage.equals("银行家算法")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new BankersAlgorithmSimulation().setVisible(true);
                }
            });
        } else if (eventMessage.equals("调度算法综述")) {
            new GUI();
        }
    }
}
