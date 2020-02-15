
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Methods {
    
    public static void isEnable(List<JTextField> list) {
        list.stream().filter((next) -> (next.isEnabled())).forEach((next) -> {
            next.setText("");
        });
    }
    
    public static void taskName(MouseEvent evt, JLabel labelName) {
        if (evt.getClickCount() == 2) {
            try {
                JTextField tf = new JTextField();
                String task = JOptionPane.showInputDialog(tf, "enter task name", JOptionPane.OK_OPTION);
                if (task.length() > 0) {
                    labelName.setText(task);
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static void task(JTextComponent timedBox, JButton action, JLabel lab[], int taskId) {
        try {
            if (!(timedBox.getText().equals("") || timedBox.getText().length() > 5 || Integer.parseInt(timedBox.getText()) <= 0)) {
                lab[0].setText(timedBox.getText());
                timedBox.setEnabled(false);
                action.setEnabled(false);
                lab[2].setText("Running");
                Methods.getTime(timedBox, action, lab, taskId);
            }
        } catch (Exception e) {
        }
    }
    
    public static void getTime(JTextComponent timedBox, JButton start, JLabel lab[], int taskId) {
//        OffsetTime ot = OffsetTime.now();
        TimeUnit secUnit = TimeUnit.SECONDS;
        TimeUnit minUnit = TimeUnit.MINUTES;
        if (taskId == 1) {
            Runnable run1 = new Runnable() {
                boolean flag = true;
                long extratcMinute = Long.parseLong(timedBox.getText());
                long second = secUnit.convert(extratcMinute, TimeUnit.MINUTES);    // convert recived extratcMinute to seconds 
                long minute = minUnit.convert(extratcMinute, TimeUnit.MINUTES);
                
                @Override
                public void run() {
                    try {
                        while (flag) {
                            second--;           // each  sec dec second by -1
                            lab[1].setText((second) + "");
                            Thread.sleep(1000);           // sleep for second
                            if (second == 0) {               // flag to stop when second is 0
                                flag = false;           // change flag to false to stop thread
                                timedBox.setEnabled(true); // enable stoped component
                                start.setEnabled(true);// enable stoped component
                                lab[2].setText("Finish");  // change state that task is finished
                            }
                            if (second % 60 == 0) {         // here to dec extratcMinute each 60 sec
                                extratcMinute--;                   // dec extratcMinute
                                lab[0].setText((extratcMinute) + "");     // show current extratcMinute on defined label 
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            };
            new Thread(run1).start();
        } else if (taskId == 2) {
            Runnable run2 = new Runnable() {
                boolean flag = true;
                long extratcMinute = Long.parseLong(timedBox.getText());
                long second = secUnit.convert(extratcMinute, TimeUnit.MINUTES);    // convert recived extratcMinute to seconds 
                long minute = minUnit.convert(extratcMinute, TimeUnit.MINUTES);
                
                @Override
                public void run() {
                    try {
                        while (flag) {
                            second--;           // each  sec dec second by -1
                            lab[1].setText((second) + "");
                            Thread.sleep(1000);           // sleep for second
                            if (second == 0) {               // flag to stop when second is 0
                                flag = false;           // change flag to false to stop thread
                                timedBox.setEnabled(true); // enable stoped component
                                start.setEnabled(true);// enable stoped component
                                lab[2].setText("Finish");  // change state that task is finished
                            }
                            if (second % 60 == 0) {         // here to dec extratcMinute each 60 sec
                                extratcMinute--;                   // dec extratcMinute
                                lab[0].setText((extratcMinute) + "");     // show current extratcMinute on defined label 
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            };
            new Thread(run2).start();
        } else if (taskId == 3) {
            Runnable run3 = new Runnable() {
                boolean flag = true;
                long extratcMinute = Long.parseLong(timedBox.getText());
                long second = secUnit.convert(extratcMinute, TimeUnit.MINUTES);    // convert recived extratcMinute to seconds 
                long minute = minUnit.convert(extratcMinute, TimeUnit.MINUTES);
                
                @Override
                public void run() {
                    try {
                        while (flag) {
                            second--;           // each  sec dec second by -1
                            lab[1].setText((second) + "");
                            Thread.sleep(1000);           // sleep for second
                            if (second == 0) {               // flag to stop when second is 0
                                flag = false;           // change flag to false to stop thread
                                timedBox.setEnabled(true); // enable stoped component
                                start.setEnabled(true);// enable stoped component
                                lab[2].setText("Finish");  // change state that task is finished
                            }
                            if (second % 60 == 0) {         // here to dec extratcMinute each 60 sec
                                extratcMinute--;                   // dec extratcMinute
                                lab[0].setText((extratcMinute) + "");     // show current extratcMinute on defined label 
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            };
            new Thread(run3).start();
        } else if (taskId == 4) {
            Runnable run4 = new Runnable() {
                boolean flag = true;
                long extratcMinute = Long.parseLong(timedBox.getText());
                long second = secUnit.convert(extratcMinute, TimeUnit.MINUTES);    // convert recived extratcMinute to seconds 
                long minute = minUnit.convert(extratcMinute, TimeUnit.MINUTES);
                
                @Override
                public void run() {
                    try {
                        while (flag) {
                            second--;           // each  sec dec second by -1
                            lab[1].setText((second) + "");
                            Thread.sleep(1000);           // sleep for second
                            if (second == 0) {               // flag to stop when second is 0
                                flag = false;           // change flag to false to stop thread
                                timedBox.setEnabled(true); // enable stoped component
                                start.setEnabled(true);// enable stoped component
                                lab[2].setText("Finish");  // change state that task is finished
                            }
                            if (second % 60 == 0) {         // here to dec extratcMinute each 60 sec
                                extratcMinute--;                   // dec extratcMinute
                                lab[0].setText((extratcMinute) + "");     // show current extratcMinute on defined label 
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            };
            new Thread(run4).start();
        } else if (taskId == 5) {
            Runnable run5 = new Runnable() {
                boolean flag = true;
                long extratcMinute = Long.parseLong(timedBox.getText());
                long second = secUnit.convert(extratcMinute, TimeUnit.MINUTES);    // convert recived extratcMinute to seconds 
                long minute = minUnit.convert(extratcMinute, TimeUnit.MINUTES);
                
                @Override
                public void run() {
                    try {
                        while (flag) {
                            second--;           // each  sec dec second by -1
                            lab[1].setText((second) + "");
                            Thread.sleep(1000);           // sleep for second
                            if (second == 0) {               // flag to stop when second is 0
                                flag = false;           // change flag to false to stop thread
                                timedBox.setEnabled(true); // enable stoped component
                                start.setEnabled(true);// enable stoped component
                                lab[2].setText("Finish");  // change state that task is finished
                            }
                            if (second % 60 == 0) {         // here to dec extratcMinute each 60 sec
                                extratcMinute--;                   // dec extratcMinute
                                lab[0].setText((extratcMinute) + "");     // show current extratcMinute on defined label 
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            };
            new Thread(run5).start();
        }
    }
}
