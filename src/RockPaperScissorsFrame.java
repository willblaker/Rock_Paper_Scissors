import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel buttonPnl;
    JPanel quitPnl;
    JPanel scorePnl;
    JPanel resultPnl;

    JLabel titleTxt;
    ImageIcon RockImg, PaperImg, ScissorsImg;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorBtn;
    JButton quitButton;

    JTextField playerWins, computerWins, ties;
    JLabel pWinsL, compWinsL, tiesL;
    private int playerWinInt;
    private int computerWinInt;
    private int tiesInt;

    JTextArea resultsTxt;
    public RockPaperScissorsFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(5, 1));

        createTitlePnl();
        mainPnl.add(titlePnl);

        createButtonPnl();
        mainPnl.add(buttonPnl);

        createQuitPnl();
        mainPnl.add(quitPnl);

        createScorePnl();
        mainPnl.add(scorePnl);

        createResultsPnl();
        mainPnl.add(resultPnl);

        add(mainPnl);
        setSize(500,600);
        setVisible(true);
    }

    public void createTitlePnl(){
        titlePnl = new JPanel();
        titleTxt = new JLabel();

        titleTxt.setText("Rock Paper Scissors Game");
        titleTxt.setFont(new Font("Serif", Font.PLAIN, 36));
        titleTxt.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleTxt);
    }

    public void createButtonPnl(){
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));
        Border lineThickerBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        buttonPnl.setBorder(lineThickerBorder);

        RockImg = new ImageIcon(this.getClass().getResource("rock.jpg"));
        RockImg = new ImageIcon(RockImg.getImage().getScaledInstance(250,150,Image.SCALE_SMOOTH));
        rockBtn = new JButton(RockImg);
        rockBtn.setBorder(BorderFactory.createEmptyBorder());
        rockBtn.setContentAreaFilled(false);
        rockBtn.addActionListener((ActionEvent ae) ->
                {
                    resultsTxt.selectAll();
                    resultsTxt.replaceSelection("");
                    int player = 0;
                    results(player);
                }
        );
        buttonPnl.add(rockBtn);

        PaperImg = new ImageIcon(this.getClass().getResource("paper.jpg"));
        PaperImg = new ImageIcon(PaperImg.getImage().getScaledInstance(250,150,Image.SCALE_SMOOTH));
        paperBtn = new JButton(PaperImg);
        paperBtn.setBorder(BorderFactory.createEmptyBorder());
        paperBtn.setContentAreaFilled(false);
        paperBtn.addActionListener((ActionEvent ae) ->
                {
                    resultsTxt.selectAll();
                    resultsTxt.replaceSelection("");
                    int player = 1;
                    results(player);
                }
        );
        buttonPnl.add(paperBtn);

        ScissorsImg = new ImageIcon(this.getClass().getResource("scissor.jpg"));
        ScissorsImg = new ImageIcon(ScissorsImg.getImage().getScaledInstance(250,150,Image.SCALE_SMOOTH));
        scissorBtn = new JButton(ScissorsImg);
        scissorBtn.setBorder(BorderFactory.createEmptyBorder());
        scissorBtn.setContentAreaFilled(false);
        scissorBtn.addActionListener((ActionEvent ae) ->
                {
                    resultsTxt.selectAll();
                    resultsTxt.replaceSelection("");
                    int player = 2;
                    results(player);
                }
        );
        buttonPnl.add(scissorBtn);
    }

    public void createQuitPnl(){
        quitPnl = new JPanel();
        quitButton = new JButton();
        quitButton.setText("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        quitPnl.add(quitButton);
    }

    public void createScorePnl(){
        scorePnl = new JPanel();
         pWinsL = new JLabel();
         pWinsL.setText("Player Wins: ");
         playerWins = new JTextField("", 3);
         scorePnl.add(pWinsL);
         scorePnl.add(playerWins);

        compWinsL = new JLabel();
        compWinsL.setText("Computer Wins: ");
        computerWins = new JTextField("", 3);
        scorePnl.add(compWinsL);
        scorePnl.add(computerWins);

        tiesL = new JLabel();
        tiesL.setText("Ties: ");
        ties = new JTextField("",3);
        scorePnl.add(tiesL);
        scorePnl.add(ties);
    }

    public void createResultsPnl(){
        resultPnl = new JPanel();
        resultsTxt = new JTextArea("",3,21);

        resultPnl.add(resultsTxt);
    }

    public void results(int p){
        Random rnd = new Random();
        int c = rnd.nextInt(3);

        if(p == 0 && c == 0){
            resultsTxt.append("Rock vs Rock? It's a tie!");
            tiesInt++;
            ties.setText(tiesInt + "");
        }
        if(p == 1 && c == 1){
            resultsTxt.append("Paper vs Paper? It's a tie!");
            tiesInt++;
            ties.setText(tiesInt + "");
        }
        if(p == 2 && c == 2){
            resultsTxt.append("Scissors vs Scissors? It's a tie!");
            tiesInt++;
            ties.setText(tiesInt + "");
        }

        if(p == 0 && c == 1){
            resultsTxt.append("Paper covers Rock, Computer Wins!");
            computerWinInt++;
            computerWins.setText(computerWinInt + "");
        }
        if(p == 1 && c == 2){
            resultsTxt.append("Scissors cuts Paper, Computer Wins!");
            computerWinInt++;
            computerWins.setText(computerWinInt + "");
        }
        if(p == 2 && c == 0){
            resultsTxt.append("Rock breaks Scissors, Computer Wins!");
            computerWinInt++;
            computerWins.setText(computerWinInt + "");
        }

        if(p == 0 && c == 2){
            resultsTxt.append("Rock breaks Scissors, Player Wins!");
            playerWinInt++;
            playerWins.setText(playerWinInt + "");
        }
        if(p == 2 && c == 1){
            resultsTxt.append("Scissors cuts Paper, Player Wins!");
            playerWinInt++;
            playerWins.setText(playerWinInt + "");
        }
        if(p == 1 && c == 0){
            resultsTxt.append("Player Wins!");
            playerWinInt++;
            playerWins.setText(playerWinInt + "");
        }
    }
}
