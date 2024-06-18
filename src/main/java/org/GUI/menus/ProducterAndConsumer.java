package org.GUI.menus;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import javafx.util.Pair;
import org.GUI.Form.AddConsumerFrom;
import org.GUI.Form.AddProducterFrom;
import org.data.objects.ResourceManager;
import org.event.tools.Monitor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProducterAndConsumer {
    private static ProducterAndConsumer instance = new ProducterAndConsumer();
    public JFrame frame;
    private JPanel panel1;
    private JTextArea terminal;
    private JTable objectTable;
    private JButton addProducterButton;
    private JButton addConsumerButton;
    private JButton ViewInfoButton;
    private JButton exitButton;
    private JTable resourceTable;
    private JTable runTable;
    private JTable waitTable;
    DefaultTableModel rtableModel;
    DefaultTableModel otableModel;
    DefaultTableModel runTableModel;
    DefaultTableModel waitTableModel;
    private JScrollPane runQueue;
    private JTabbedPane Queues;
    private JScrollPane waitQueue;
    private JScrollPane otable;
    private Monitor monitor;
    private Observer<Map<String, Integer>> resourceObserver;
    private static Map<String, ArrayList<Pair<String, Integer>>> objects = new HashMap<>();

    public static Map<String, ArrayList<Pair<String, Integer>>> getObjects() {
        return objects;
    }

    public static ProducterAndConsumer getInstance() {
        return instance;
    }

    public JPanel getHomePanel() {
        return this.panel1;
    }

    public JTextArea getTerminal() {
        return terminal;
    }

    public Observer<Map<String, Integer>> getObserver() {
        return this.resourceObserver;
    }

    public DefaultTableModel getOtableModel() {
        return otableModel;
    }

    public ProducterAndConsumer() {
        frame = new JFrame("生产者消费者模型");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        rtableModel = (DefaultTableModel) resourceTable.getModel();
        otableModel = (DefaultTableModel) objectTable.getModel();
        runTableModel = (DefaultTableModel) runTable.getModel();
        waitTableModel = (DefaultTableModel) waitTable.getModel();
        rtableModel.addColumn("资源昵称");
        rtableModel.addColumn("资源数量");
        otableModel.addColumn("线程编号");
        otableModel.addColumn("线程昵称");
        runTableModel.addColumn("运行编号");
        runTableModel.addColumn("PID");
        waitTableModel.addColumn("PID");
        waitTableModel.addColumn("等待资源");

        terminal.setText("terminal stating...\n");
        monitor = new Monitor();
        addProducterButton.addActionListener(monitor);
        addConsumerButton.addActionListener(monitor);
        ViewInfoButton.addActionListener(monitor);
        exitButton.addActionListener(monitor);
        addConsumerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSubCForm();
            }
        });

        addProducterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSubPForm();
            }
        });
        resourceObserver = new Observer<Map<String, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("资源管理器订阅");
            }

            @Override
            public void onNext(Map<String, Integer> resourceItems) {
                clearTable(rtableModel);
                for (Map.Entry<String, Integer> entry : resourceItems.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    rtableModel.addRow(new String[]{key, value.toString()});
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("!!!!!!!!!!!!!");
                frame.dispose();
            }
        });
        ViewInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, (objects.size() == 0 ? "null" : objects.toString())
                        , "Information", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private void openSubCForm() {
        AddConsumerFrom addConsumerFrom = new AddConsumerFrom(this);
        addConsumerFrom.frame.setVisible(true);
    }

    private void openSubPForm() {
        AddProducterFrom addProducterFrom = new AddProducterFrom(this);
        addProducterFrom.frame.setVisible(true);
    }

    public static void main(String[] args) {
        ResourceManager.getInstance();

        ResourceManager.getInstance().getObservable().subscribe(getInstance().getObserver());
    }

    void clearTable(DefaultTableModel table) {
        int rowNums = table.getRowCount();
        for (int i = rowNums - 1; i >= 0; i--)
            table.removeRow(i);
    }

    public DefaultTableModel getRunningTableModel() {
        return this.runTableModel;
    }

    public DefaultTableModel getWaitTableModel() {
        return this.waitTableModel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:20px:noGrow,left:4dlu:noGrow,fill:500px:noGrow,left:4dlu:noGrow,fill:300px:noGrow,left:5dlu:noGrow,fill:300px:noGrow,left:5dlu:noGrow,fill:20px:noGrow", "center:20px:noGrow,top:4dlu:noGrow,center:300px:noGrow,top:5dlu:noGrow,center:200px:noGrow,top:4dlu:noGrow,center:20px:noGrow"));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:d:grow", "center:20px:noGrow,top:4dlu:noGrow,center:d:grow"));
        CellConstraints cc = new CellConstraints();
        panel1.add(panel2, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
        final JLabel label1 = new JLabel();
        label1.setText("Terminal");
        panel2.add(label1, cc.xy(1, 1));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, cc.xy(1, 3, CellConstraints.FILL, CellConstraints.FILL));
        terminal = new JTextArea();
        terminal.setBackground(new Color(-16777216));
        terminal.setForeground(new Color(-65793));
        scrollPane1.setViewportView(terminal);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FormLayout("fill:31px:noGrow,left:4dlu:noGrow,fill:max(d;50px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:5dlu:noGrow,fill:116px:noGrow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        panel1.add(panel3, cc.xy(3, 5, CellConstraints.DEFAULT, CellConstraints.FILL));
        addProducterButton = new JButton();
        addProducterButton.setPreferredSize(new Dimension(78, 50));
        addProducterButton.setText("添加生产者");
        panel3.add(addProducterButton, cc.xy(3, 3));
        addConsumerButton = new JButton();
        addConsumerButton.setPreferredSize(new Dimension(78, 50));
        addConsumerButton.setText("添加消费者");
        panel3.add(addConsumerButton, cc.xy(5, 3));
        ViewInfoButton = new JButton();
        ViewInfoButton.setPreferredSize(new Dimension(78, 50));
        ViewInfoButton.setText("展示进程信息");
        panel3.add(ViewInfoButton, cc.xy(7, 3));
        exitButton = new JButton();
        exitButton.setPreferredSize(new Dimension(78, 50));
        exitButton.setText("退出");
        panel3.add(exitButton, cc.xy(9, 3));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel4, cc.xywh(7, 3, 1, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
        Queues = new JTabbedPane();
        panel4.add(Queues, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        runQueue = new JScrollPane();
        Queues.addTab("运行队列", runQueue);
        runTable = new JTable();
        runQueue.setViewportView(runTable);
        waitQueue = new JScrollPane();
        Queues.addTab("等待队列", waitQueue);
        waitTable = new JTable();
        waitQueue.setViewportView(waitTable);
        final JScrollPane scrollPane2 = new JScrollPane();
        panel1.add(scrollPane2, cc.xy(5, 3, CellConstraints.FILL, CellConstraints.FILL));
        resourceTable = new JTable();
        scrollPane2.setViewportView(resourceTable);
        otable = new JScrollPane();
        panel1.add(otable, cc.xy(5, 5, CellConstraints.FILL, CellConstraints.FILL));
        objectTable = new JTable();
        otable.setViewportView(objectTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
