import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


class OnlineExam extends JFrame implements ActionListener {
    JLabel jLabel1, jLabel2;
    JRadioButton[] jb = new JRadioButton[6];
    JButton jButton1, jButton2;
    ButtonGroup buttonGroup;
    QuestionAnswer questionAnswer = new QuestionAnswer();
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer;

    OnlineExam(String s) {
        super(s);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        add(jLabel1);
        add(jLabel2);
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            buttonGroup.add(jb[i]);
        }
        jButton1 = new JButton("Save and Next");
        jButton2 = new JButton("Save for later");
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        add(jButton1);
        add(jButton2);
        set();
        jLabel1.setBounds(30, 40, 450, 20);
        jLabel2.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        jButton1.setBounds(95, 240, 140, 30);
        jButton2.setBounds(270, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

        final int[] timeLeft = {120}; // 2 minutes in seconds

        TimerTask task = new TimerTask() {
            public void run() {
                timeLeft[0]--;
                if (timeLeft[0] >= 0) {
                    jLabel2.setText("Time left: " + timeLeft[0] + " sec.");
                } else {
                    timer.cancel();
                    jLabel2.setText("Time Out");
                }
            }
        };

        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton1) {
            if (check()) {
                count++;
            }
            current++;
            set();
            if (current == 9) {
                jButton1.setEnabled(false);
                jButton2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Save for later")) {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                jButton2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {

            if (e.getActionCommand().equals("Review" + y)) {
                if (check()) {
                    count++;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }

            if(e.getActionCommand().equals("Result"))
            {
                if(check())
                    count += 1;
                current++;
                JOptionPane.showMessageDialog(this,"Score = "+count);
                System.exit(0);
            }
        }

    }



    // Refactor the set() method to use the arrays
    void set() {
        jb[4].setSelected(true);
        jLabel1.setText(questionAnswer.questions[current]);
        for (int i = 0; i < 4; i++) {
            jb[i].setText(questionAnswer.choices[current][i]);
        }
        jLabel1.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            jb[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    // Refactor the check() method to use the arrays
    boolean check() {
        return jb[questionAnswer.answers[current]].isSelected();
    }

}