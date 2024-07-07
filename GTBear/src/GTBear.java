import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GTBear {
    int boardwith = 600;
    int boardHeight = 650;


    JFrame frame = new JFrame("GeTaBear");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JLabel textLabel2 = new JLabel();
    JPanel textPanel2 = new JPanel();

    JButton[] board = new JButton[9];
    ImageIcon Bear1;
    ImageIcon Bear2;
    ImageIcon crash;
    ImageIcon jail;
    ImageIcon traurig;
    ImageIcon Schatz;
    ImageIcon Pferd;
    ImageIcon Vacation;
    ImageIcon Drunk;

    JButton currBear1tile;
    JButton currBear2tile;
    JButton currBear3tile;
    JButton currBear4tile;
    JButton currBear5tile;
    JButton currBear6tile;
    JButton currBear7tile;
    JButton currBear8tile;
    JButton currBear9tile;


    Random random = new Random();
    Timer setBear1Timer;
    Timer setBear2Timer;
    Timer setBear3Timer;
    Timer setBear4Timer;
    Timer setBear5Timer;
    Timer setBear6Timer;
    Timer setBear7Timer;
    Timer setBear8Timer;
    Timer setBear9Timer;

    int score = 0;

    String filepath = "GTBear.wav";
    String filepath2 = "Richtig.wav";
    String filepath3 = "Extra.wav";
    String filepath4 = "Backup Gameover.wav";
    String filepath5 = "Tribut.wav";

    static boolean gameOver = false;

    GTBear() {

        frame.setSize(boardwith, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel2.setFont(new Font("Italic", Font.PLAIN, 25));
        textLabel2.setHorizontalAlignment(JLabel.CENTER);
        textLabel2.setText(Ranglevel.ranglevel(score)); // Setze Anfangsrang mit Methode auf Startrang
        textLabel2.setOpaque(true);
        textPanel2.setLayout(new BorderLayout());
        textPanel2.add(textLabel2);
        frame.add(textPanel2, BorderLayout.SOUTH);

        textLabel.setFont(new Font("Italic", Font.PLAIN, 25));
        textLabel.setHorizontalAlignment(JLabel.RIGHT);
        textLabel.setText("Score: 0");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.WHITE );
        frame.add(boardPanel);

        // Bear2 = new ImageIcon(getClass().getResource("./Designer.jpg"));
        Image Bear2Img = new ImageIcon(getClass().getResource("./Designer.jpg")).getImage();
        Bear2 = new ImageIcon(Bear2Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear1Img = new ImageIcon(getClass().getResource("./thuglifebear.jpg")).getImage();
        Bear1 = new ImageIcon(Bear1Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear3Img = new ImageIcon(getClass().getResource("./crash.jpg")).getImage();
        crash = new ImageIcon(Bear3Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear4Img = new ImageIcon(getClass().getResource("./traurig.jpg")).getImage();
        traurig = new ImageIcon(Bear4Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear5Img = new ImageIcon(getClass().getResource("./jail.jpg")).getImage();
        jail = new ImageIcon(Bear5Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear6Img = new ImageIcon(getClass().getResource("./Schatz.jpg")).getImage();
        Schatz = new ImageIcon(Bear6Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear7Img = new ImageIcon(getClass().getResource("./Pferd.jpg")).getImage();
        Pferd = new ImageIcon(Bear7Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear8Img = new ImageIcon(getClass().getResource("./Vacation.jpg")).getImage();
        Vacation = new ImageIcon(Bear8Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        Image Bear9Img = new ImageIcon(getClass().getResource("./Drunk.jpg")).getImage();
        Drunk = new ImageIcon(Bear9Img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        score = 0;
        Bearsound.PlayMusic(filepath);

        for (int i=0; i < 9; i++) {
            JButton tile = new JButton();
            board[i] = tile;
            boardPanel.add(tile);
            tile.setFocusable(false);
            // tile.setIcon(Bear1);
            tile.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   JButton tile = (JButton)e.getSource();
                   if (tile == currBear1tile) {
                       score +=10;
                       Bearbuzzer.PlayExtra(filepath2);
                       textLabel.setText("+10    Score: " + Integer.toString(score));
                       textLabel2.setText(Ranglevel.ranglevel(score));
                   }

                   else if (tile == currBear6tile) {
                       score += 60;
                       Bearbuzzer.PlayExtra(filepath3);
                       setBear6Timer.stop();
                       currBear6tile.setIcon(null);
                       currBear6tile = null;
                       setBear6Timer.restart();
                       textLabel.setText("T-T-T-reasure!  +50     Score: " + Integer.toString(score));
                       textLabel2.setText(Ranglevel.ranglevel(score));
                   }
                   else if (tile == currBear8tile) {
                       score -= 10;
                       Bearbuzzer.PlayExtra(filepath5);
                       setBear8Timer.stop();
                       currBear8tile.setIcon(null);
                       currBear8tile = null;
                       setBear8Timer.restart();
                       textLabel.setText("O'zapft is!  -10    Score: " + Integer.toString(score));
                       textLabel2.setText(Ranglevel.ranglevel(score));
                   }
                   else if (tile == currBear9tile) {
                       score -= 50;
                       Bearbuzzer.PlayExtra(filepath5);
                       setBear9Timer.stop();
                       currBear9tile.setIcon(null);
                       currBear9tile = null;
                       setBear9Timer.restart();
                       textLabel.setText("Bossanteil!  -50    Score: " + Integer.toString(score));
                       textLabel2.setText(Ranglevel.ranglevel(score));
                   }
                   else if (tile == currBear7tile) {
                       score += 100;
                       Bearbuzzer.PlayExtra(filepath3);
                       setBear7Timer.stop();
                       currBear7tile.setIcon(null);
                       currBear7tile = null;
                       setBear7Timer.restart();
                       textLabel.setText("GTA == Ponyhof  +100    Score: " + Integer.toString(score));
                       textLabel2.setText(Ranglevel.ranglevel(score));
                   }

                   else if (tile == currBear2tile) {
                       textLabel.setText("GaMeOvEr");
                       gameOver=true;

                       Bearbuzzer.PlayExtra(filepath4);
                       setBear1Timer.stop();
                       setBear2Timer.stop();
                       setBear3Timer.stop();
                       setBear4Timer.stop();
                       setBear5Timer.stop();
                       setBear6Timer.stop();
                       setBear7Timer.stop();
                       setBear8Timer.stop();
                       setBear9Timer.stop();
                       for (int i=0; i < 9; i++) {
                           board[i].setEnabled(false);
                       }
                   }
                   else if (tile == currBear3tile) {
                       textLabel.setText("GaMeOvEr");

                       Bearbuzzer.PlayExtra(filepath4);
                       setBear1Timer.stop();
                       setBear2Timer.stop();
                       setBear3Timer.stop();
                       setBear4Timer.stop();
                       setBear5Timer.stop();
                       setBear6Timer.stop();
                       setBear7Timer.stop();
                       setBear8Timer.stop();
                       setBear9Timer.stop();
                       for (int i=0; i < 9; i++) {
                           board[i].setEnabled(false);
                       }
                   }
                   else if (tile == currBear4tile) {
                       textLabel.setText("GaMeOvEr");

                       Bearbuzzer.PlayExtra(filepath4);
                       setBear1Timer.stop();
                       setBear2Timer.stop();
                       setBear3Timer.stop();
                       setBear4Timer.stop();
                       setBear5Timer.stop();
                       setBear6Timer.stop();
                       setBear7Timer.stop();
                       setBear8Timer.stop();
                       setBear9Timer.stop();
                       for (int i=0; i < 9; i++) {
                           board[i].setEnabled(false);
                       }
                   }
                   else if (tile == currBear5tile) {
                       textLabel.setText("GaMeOvEr");

                       Bearbuzzer.PlayExtra(filepath4);

                       setBear1Timer.stop();
                       setBear2Timer.stop();
                       setBear3Timer.stop();
                       setBear4Timer.stop();
                       setBear5Timer.stop();
                       setBear6Timer.stop();
                       setBear7Timer.stop();
                       setBear8Timer.stop();
                       setBear9Timer.stop();
                       for (int i=0; i < 9; i++) {
                           board[i].setEnabled(false);
                       }
                   }
               }
            });
        }
        setBear1Timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear1tile !=null) {
                    currBear1tile.setIcon(null);
                    currBear1tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear1tile = tile;
                currBear1tile.setIcon(Bear1);
            }
        });

        setBear2Timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear2tile !=null) {
                    currBear2tile.setIcon(null);
                    currBear2tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear2tile = tile;
                currBear2tile.setIcon(Bear2);
            }
        });

        setBear3Timer = new Timer(4500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear3tile !=null) {
                    currBear3tile.setIcon(null);
                    currBear3tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear3tile = tile;
                currBear3tile.setIcon(crash);
            }
        });
        setBear4Timer = new Timer(12500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear4tile !=null) {
                    currBear4tile.setIcon(null);
                    currBear4tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear4tile = tile;
                currBear4tile.setIcon(traurig);
            }
        });
        setBear5Timer = new Timer(7500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear5tile !=null) {
                    currBear5tile.setIcon(null);
                    currBear5tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear5tile = tile;
                currBear5tile.setIcon(jail);
            }
        });
        setBear6Timer = new Timer(14500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear6tile !=null) {
                    currBear6tile.setIcon(null);
                    currBear6tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear6tile = tile;
                currBear6tile.setIcon(Schatz);
            }
        });
        setBear7Timer = new Timer(38000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear7tile !=null) {
                    currBear7tile.setIcon(null);
                    currBear7tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];

                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear8tile == tile) return;
                if (currBear9tile == tile) return;

                currBear7tile = tile;
                currBear7tile.setIcon(Pferd);
            }
        });
        setBear8Timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear8tile !=null) {
                    currBear8tile.setIcon(null);
                    currBear8tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];
                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear9tile == tile) return;

                currBear8tile = tile;
                currBear8tile.setIcon(Vacation);
            }
        });
        setBear9Timer = new Timer(12000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBear9tile !=null) {
                    currBear9tile.setIcon(null);
                    currBear9tile = null;
                }

                int num = random.nextInt(9); //0-8
                JButton tile = board[num];
                if (currBear1tile == tile) return;
                if (currBear2tile == tile) return;
                if (currBear3tile == tile) return;
                if (currBear4tile == tile) return;
                if (currBear5tile == tile) return;
                if (currBear6tile == tile) return;
                if (currBear7tile == tile) return;
                if (currBear8tile == tile) return;

                currBear9tile = tile;
                currBear9tile.setIcon(Drunk);
            }
        });
        setBear1Timer.start();
        setBear2Timer.start();
        setBear3Timer.start();
        setBear4Timer.start();
        setBear5Timer.start();
        setBear6Timer.start();
        setBear7Timer.start();
        setBear8Timer.start();
        setBear9Timer.start();
        frame.setVisible(true);
    }

}
