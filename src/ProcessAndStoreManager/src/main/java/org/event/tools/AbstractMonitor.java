package org.event.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMonitor implements ActionListener {
    public abstract void actionPerformed(ActionEvent e);
}
