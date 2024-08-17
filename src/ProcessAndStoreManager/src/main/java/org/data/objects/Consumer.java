package org.data.objects;

import io.reactivex.internal.operators.flowable.FlowableCache;
import javafx.util.Pair;
import org.GUI.menus.ProducterAndConsumer;

import javax.swing.table.DefaultTableModel;
import java.beans.ParameterDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;
import static org.data.objects.ResourceManager.*;

public class Consumer extends PCB{
    String name;
    List<Pair<String,Integer>> ConsumeItems;

    public Consumer(String name, List<Pair<String,Integer>> ConsumeItems) {
        super();
        this.name = name;
        ConsumeItems = ConsumeItems;
    }

    public Consumer() {
        ConsumeItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pair<String,Integer>> getConsumeItems() {
        return ConsumeItems;
    }

    public void setConsumeItems(List<Pair<String,Integer>> ConsumeItems) {
        ConsumeItems = ConsumeItems;
    }

    List<String> checkResourse(){
        List<String> res = new ArrayList<>();
        for (Pair<String, Integer> a: ConsumeItems
        ) {
            if(ResourceManager.getInstance().getResourceNumberByName(a.getKey()) < a.getValue()){
                res.add(a.getKey());
            }
        }
        return res;
    }

    @Override
    public void run() {
        ProducterAndConsumer.getInstance().getTerminal().append("消费者"+name+"开始消费了.....\n");
        ProducterAndConsumer.getInstance().getOtableModel().addRow(new String[]{String.valueOf(ID), name});
        DefaultTableModel run = ProducterAndConsumer.getInstance().getRunningTableModel();
        DefaultTableModel wait = ProducterAndConsumer.getInstance().getWaitTableModel();
        run.addRow(new String[]{String.valueOf(ID), name});
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                List<String> lockRes = null;
                int f = 1;
                do{
                    try {
                        P();
                        System.out.println("消费者"+ name +"锁同步");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lockRes = checkResourse();
                    if(f == 1 && !lockRes.isEmpty()) {
                        for (int i = 0; i < run.getRowCount(); i++) {
                            if (run.getValueAt(i, 1) == name) run.removeRow(i);
                        }
                        ProducterAndConsumer.getInstance().getTerminal().append("消费者" + name + "因资源"+lockRes.toString()+",不足挂起\n");
                        wait.addRow(new String[]{String.valueOf(ID), lockRes.toString()});
                        f=0;
                    }
                    if(!lockRes.isEmpty()) {
                        V();
                        System.out.println("消费者" + name + "挂起解同步\n");

                        try {
                            sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }while(!lockRes.isEmpty());

                if(f == 0) {
                    ProducterAndConsumer.getInstance().getTerminal().append("消费者" + name + "已得到所需资源\n");
                    for (int i = 0; i < wait.getRowCount(); i++) {
                        if (wait.getValueAt(i, 0).equals(String.valueOf(ID))) wait.removeRow(i);
                    }
                    run.addRow(new String[]{String.valueOf(ID), name});
                    f=1;
                }

                for (Pair<String, Integer> a: ConsumeItems
                )
                    ResourceManager.getInstance().updateResourceItem(a.getKey(),-a.getValue());
                V();
                System.out.println("消费者" + name + "解同步");
//                System.out.println(multex);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 1000, 1000);
    }

    public void resumeProcess() {
        synchronized (this) {
            notify(); // 唤醒消费者线程
        }
    }
}
