package org.data.objects;

import javafx.util.Pair;
import org.GUI.menus.ProducterAndConsumer;

import javax.swing.table.DefaultTableModel;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;
import static org.data.objects.ResourceManager.*;

public class Producter extends PCB implements Runnable{
    String name;
    List<Pair<String,Integer>> ProduceItems;
    public Producter() {
        ProduceItems = new ArrayList<>();
    }

    public Producter(String name, List<Pair<String,Integer>> produceItems) {
        super();
        this.name = name;
        ProduceItems = produceItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pair<String,Integer>> getProduceItems() {
        return ProduceItems;
    }

    public void setProduceItems(List<Pair<String,Integer>> produceItems) {
        ProduceItems = produceItems;
    }

    List<String> checkResourse(){
        List<String> res = new ArrayList<>();
        for (Pair<String, Integer> a: ProduceItems
        ) {
            if(ResourceManager.getInstance().getResourceNumberByName(a.getKey()) + a.getValue() > ResourceManager.getULIMIT()){
                res.add(a.getKey());
            }
        }
        return res;
    }

    @Override
    public void run() {
        ProducterAndConsumer.getInstance().getTerminal().append("生产者"+name+"开始生产了.....\n");
        ProducterAndConsumer.getInstance().getRunningTableModel().addRow(new String[]{String.valueOf(ID), name});
        ProducterAndConsumer.getInstance().getOtableModel().addRow(new String[]{String.valueOf(ID), name});
        DefaultTableModel run = ProducterAndConsumer.getInstance().getRunningTableModel();
        DefaultTableModel wait = ProducterAndConsumer.getInstance().getWaitTableModel();
//        run.addRow(new String[]{String.valueOf(ID), name});
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                List<String> lockRes = null;
                int f = 1;
                do{
                    try {
                        P();
                        System.out.println("生产者"+ name +"锁同步");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lockRes = checkResourse();
                    if(f == 1 && !lockRes.isEmpty()) {
                        for (int i = 0; i < run.getRowCount(); i++) {
                            if (run.getValueAt(i, 1) == name) run.removeRow(i);
                        }
                        ProducterAndConsumer.getInstance().getTerminal().append("生产者者" + name + "因资源"+lockRes.toString()+",过多挂起\n");
                        wait.addRow(new String[]{String.valueOf(ID), lockRes.toString()});
                        f=0;
                    }
                    if(!lockRes.isEmpty()) {
                        V();
                        System.out.println("生产者者" + name + "挂起解同步\n");

                        try {
                            sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }while(!lockRes.isEmpty());

                if(f == 0) {
                    ProducterAndConsumer.getInstance().getTerminal().append("生产者" + name + "已经允许恢复生产\n");
                    for (int i = 0; i < wait.getRowCount(); i++) {
                        if (wait.getValueAt(i, 0).equals(String.valueOf(ID))) wait.removeRow(i);
                    }
                    run.addRow(new String[]{String.valueOf(ID), name});
                    f=1;
                }

                for (Pair<String, Integer> a: ProduceItems
                )
                    ResourceManager.getInstance().updateResourceItem(a.getKey(),a.getValue());
                V();
                System.out.println("生产者" + name + "解同步");
//                System.out.println(multex);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 1000, 1000);
    }
}
