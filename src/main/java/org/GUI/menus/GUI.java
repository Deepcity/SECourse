package org.GUI.menus;

import org.algorithm.dialog.*;
import org.data.objects.Event;
import org.data.objects.Row;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI {
    private JFrame frame;
    private JPanel mainPanel;
    private CustomPanel chartPanel;
    private JScrollPane tablePane;
    private JScrollPane chartPane;
    private JTable table;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton computeBtn;
    private JLabel wtLabel;
    private JLabel wtResultLabel;
    private JLabel tatLabel;
    private JLabel tatResultLabel;
    private JLabel tatpLabel;
    private JLabel tatpResultLabel;
    private JComboBox option;
    private DefaultTableModel model;

    public GUI(){
        model = new DefaultTableModel(new String[]{"进程号", "到达时间", "运行时间", "优先级", "完成时间", "周转时间", "等待时间"}, 0);

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        tablePane = new JScrollPane(table);
        tablePane.setBounds(25, 25, 450, 250);

        addBtn = new JButton("添加进程");
        addBtn.setBounds(260, 280, 105, 25);
        addBtn.setFont(new Font("", Font.PLAIN, 11));
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new String[]{"", "", "", "", "", "",""});
            }
        });

        removeBtn = new JButton("移除进程");
        removeBtn.setBounds(370, 280, 105, 25);
        removeBtn.setFont(new Font("", Font.PLAIN, 11));
        removeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row > -1) {
                    model.removeRow(row);
                }
            }
        });

        chartPanel = new CustomPanel();
        chartPanel.setPreferredSize(new Dimension(700, 10));
        chartPanel.setBackground(Color.WHITE);
        chartPane = new JScrollPane(chartPanel);
        chartPane.setBounds(25, 310, 450, 100);

        wtLabel = new JLabel("平均等待时间:");
        wtLabel.setBounds(25, 425, 180, 25);
        tatLabel = new JLabel("平均周转时间:");
        tatLabel.setBounds(25, 450, 180, 25);
        tatpLabel = new JLabel("平均带权周转时间");
        tatpLabel.setBounds(25, 475, 180, 25);
        wtResultLabel = new JLabel();
        wtResultLabel.setBounds(215, 425, 180, 25);
        tatResultLabel = new JLabel();
        tatResultLabel.setBounds(215, 450, 180, 25);
        tatpResultLabel= new JLabel();
        tatpResultLabel.setBounds(215, 475, 180, 25);


        option = new JComboBox(new String[]{"FCFS", "SJF", "SRTF", "PSNP", "PSP", "RR"});
        option.setBounds(390, 420, 85, 20);

        computeBtn = new JButton("Calculate");
        computeBtn.setBounds(390, 450, 85, 25);
        computeBtn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        computeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) option.getSelectedItem();
                CPUScheduler scheduler;

                switch (selected) {
                    case "FCFS":
                        scheduler = new FirstComeFirstServe();
                        break;
                    case "SJF":
                        scheduler = new ShortestJobFirst();
                        break;
                    case "SRTF":
                        scheduler = new ShortestRemainingTime();
                        break;
                    case "PSNP":
                        scheduler = new PriorityNonPreemptive();
                        break;
                    case "PSP":
                        scheduler = new PriorityPreemptive();
                        break;
                    case "RR":
                        String tq = JOptionPane.showInputDialog("Time Quantum");
                        if (tq == null) {
                            return;
                        }
                        scheduler = new RoundRobin();
                        scheduler.setTimeQuantum(Integer.parseInt(tq));
                        break;
                    default:
                        return;
                }

                for (int i = 0; i < model.getRowCount(); i++){
                    String process = (String) model.getValueAt(i, 0);
                    int at = Integer.parseInt((String) model.getValueAt(i, 1));
                    int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                    int pl;

                    if (selected.equals("PSNP") || selected.equals("PSP")){
                        if (!model.getValueAt(i, 3).equals("")){
                            pl = Integer.parseInt((String) model.getValueAt(i, 3));
                        }
                        else{
                            pl = 1;
                        }
                    }
                    else
                    {
                        pl = 1;
                    }

                    scheduler.add(new Row(process, at, bt, pl));
                }

                scheduler.process();

                for (int i = 0; i < model.getRowCount(); i++)
                {
                    String process = (String) model.getValueAt(i, 0);
                    Row row = scheduler.getRow(process);
                    model.setValueAt(row.getCompletionTime(), i, 4);
                    model.setValueAt(row.getTurnaroundTime(), i, 5);
                    model.setValueAt(row.getWaitingTime(), i, 6);
                }

                wtResultLabel.setText(Double.toString(scheduler.getAverageWaitingTime()));
                tatResultLabel.setText(Double.toString(scheduler.getAverageTurnAroundTime()));
                tatpResultLabel.setText(Double.toString(scheduler.getAverageTurnAroundTimeWithPower()));

                chartPanel.setTimeline(scheduler.getTimeline());
            }
        });

        mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(500, 525));
        mainPanel.add(tablePane);
        mainPanel.add(addBtn);
        mainPanel.add(removeBtn);
        mainPanel.add(chartPane);
        mainPanel.add(wtLabel);
        mainPanel.add(tatLabel);
        mainPanel.add(wtResultLabel);
        mainPanel.add(tatResultLabel);
        mainPanel.add(tatpLabel);
        mainPanel.add(tatpResultLabel);
        mainPanel.add(option);
        mainPanel.add(computeBtn);

        frame = new JFrame("调度算法模拟");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainPanel);
        frame.pack();

        frame.setLocationRelativeTo(null);
    }

    private Container getContentPane() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args)
    {
        new GUI();
    }

    class CustomPanel extends JPanel
    {
        private List<Event> timeline;

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if (timeline != null)
            {
                int width = 35;

                for (int i = 0; i < timeline.size(); i++)
                {
                    Event event = timeline.get(i);
                    int x = 30 * (i + 1);
                    int y = 20;

                    g.drawRect(x, y, 30, 30);
                    g.setFont(new Font("Segoe UI", Font.BOLD, 13));
                    g.drawString(event.getProcessName(), x + 10, y + 20);
                    g.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                    g.drawString(Integer.toString(event.getStartTime()), x - 5, y + 45);

                    if (i == timeline.size() - 1)
                    {
                        g.drawString(Integer.toString(event.getFinishTime()), x + 27, y + 45);
                    }

                    width += 35;
                }

                this.setPreferredSize(new Dimension(width, 75));
            }
        }

        public void setTimeline(List<Event> timeline)
        {
            this.timeline = timeline;
            repaint();
        }
    }
}