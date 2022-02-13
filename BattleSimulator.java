import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BattleSimulator extends JFrame {

    public static JButton StartB;

    // Window
    public JFrame frame;
    public static JPanel panel;
    public JPanel movesPanel;
    public static JPanel TextPanel;
    public static JPanel AttackPanel;

    // Bottom Right labels
    public static JLabel WhoseTurnItIs;
    public static JLabel DidAttackHit;

    // Labels
    public static JLabel UserHealthLabel;
    public static JLabel CompHealthLabel;
    public static JLabel UserSelectedPokemonLabel;
    public static JLabel CompSelectedPokemonLabel;
    public static JLabel DidYourAttackHit;

    // Pokemons
    public static JButton ratButton;
    public static JButton snakeButton;
    public static JButton turtleButton;

    // Generic Attack Values
    public static int Attackdmg;

    // Random Buttons
    public static JButton TestButton;

    // Pokemon Selction True
    public static boolean PokemonSelctionvalue = true;
    public static String SelectedPokemon;
    public static String SelectedAttack;
    public static boolean TurnChecker = true;
    public static String CompSelectedPokemon;

    // Attack Buttons
    public static JButton Strongattack;
    public static JButton Mediumattack;
    public static JButton Weakattack;
    public static JButton Effectattack;

    // Attack Variables
    public static int UserStrongDmg;
    public static int UserMediumDmg;
    public static int UserWeakDmg;
    public static int UserEffectDmg;
    public static int UserHealth = 1;

    // User Accuracy Variables
    public static int UserStrongAcc;
    public static int UserMediumAcc;
    public static int UserWeakAcc;
    public static int UserEffectAcc;

    // Attack Variables
    public static int CompStrongDmg;
    public static int CompMediumDmg;
    public static int CompWeakDmg;
    public static int CompEffectDmg;
    public static int CompHealth = 1;

    // Comp Acc Values
    public static int CompStrongAcc;
    public static int CompMediumAcc;
    public static int CompWeakAcc;
    public static int CompEffectAcc;

    public static JTextArea attackstats;
    public static JTextArea attackAccuracy;

    // Rat move Values
    public static int RatStrongAttack = 60;
    public static int RatMediumAttack = 40;
    public static int RatWeakAttack = 20;
    public static int RatEffectAttack = 10;
    public static int RatHealth = 150;

    // Rat Move Accuracy
    public static int RatStrongAcc = 65;
    public static int RatMediumAcc = 70;
    public static int RatWeakAcc = 100;
    public static int RatEffectAcc = 90;

    // Snake Move Values
    public static int SnakeStrongAttack = 90;
    public static int SnakeMediumAttack = 80;
    public static int SnakeWeakAttack = 30;
    public static int SnakeEffectAttack = 30;
    public static int SnakeHealth = 100;

    // Snake Moves Acc
    public static int SnakeStrongAcc = 60;
    public static int SnakeMediumAcc = 75;
    public static int SnakeWeakAcc = 95;
    public static int SnakeEffectAcc = 90;

    // Turtle Move Values
    public static int TurtleStrongAttack = 50;
    public static int TurtleMediumAttack = 40;
    public static int TurtleWeakAttack = 20;
    public static int TurtleEffectAttack = 0;
    public static int TurtleHealth = 200;

    // Turtle Moves Acc
    public static int TurtleStrongAcc = 70;
    public static int TurtleMediumAcc = 80;
    public static int TurtleWeakAcc = 95;
    public static int TurtleEffectAcc = 0;

    public static String WhoIsWho;

    public BattleSimulator() {

        // Panel and frame object
        panel = new JPanel();
        frame = new JFrame();

        attackstats = new JTextArea();
        attackAccuracy = new JTextArea();

        attackstats.setFont(new Font("Calibri", Font.PLAIN, 20));
        attackAccuracy.setFont(new Font("Calibri", Font.PLAIN, 20));

        // Label Objects
        UserSelectedPokemonLabel = new JLabel();
        CompSelectedPokemonLabel = new JLabel();
        UserHealthLabel = new JLabel();
        CompHealthLabel = new JLabel();
        WhoseTurnItIs = new JLabel();
        DidAttackHit = new JLabel();
        DidYourAttackHit = new JLabel();

        // Panel Objects
        movesPanel = new JPanel();
        TextPanel = new JPanel();
        AttackPanel = new JPanel();

        // Create Window
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Sets panels layout
        frame.setLayout(new GridLayout(2, 2));
        movesPanel.setLayout(new GridLayout(2, 2));
        TextPanel.setLayout(new GridLayout(2, 2));
        AttackPanel.setLayout(new GridLayout(3, 1));

        // Add Panels to frame
        frame.add(panel);
        frame.add(movesPanel);
        frame.add(TextPanel);
        frame.add(AttackPanel);

        // Label to Panel | Bottom Left Panel
        TextPanel.add(UserSelectedPokemonLabel);
        TextPanel.add(CompSelectedPokemonLabel);
        TextPanel.add(UserHealthLabel);
        TextPanel.add(CompHealthLabel);

        // Labels to move info panel | Bottom Right panel
        AttackPanel.add(WhoseTurnItIs);
        AttackPanel.add(DidAttackHit);
        AttackPanel.add(DidYourAttackHit);
        // Icon icon = new ImageIcon("D:/Java coding/Grpahics/rat.png"

        // Character Selections Buttons
        ratButton = new JButton("Rat");
        snakeButton = new JButton("Snake");
        turtleButton = new JButton("Turtle");
        TestButton = new JButton("Confirm");

        // Attack buttons
        Strongattack = new JButton("Strong attack");
        Mediumattack = new JButton("Medium attack");
        Weakattack = new JButton("Weak Attack");
        Effectattack = new JButton("Effect Attack");

        // Buttons to panel
        panel.add(ratButton);
        panel.add(snakeButton);
        panel.add(turtleButton);
        panel.add(TestButton);

        panel.add(attackstats);// Adds the stats list to the pokemon selection panel
        panel.add(attackAccuracy);

        // Attack Buttons to panel
        movesPanel.add(Strongattack);
        movesPanel.add(Mediumattack);
        movesPanel.add(Weakattack);
        movesPanel.add(Effectattack);

        // Testing
        attackstats.setEditable(false);
        attackAccuracy.setEditable(false);

    }// ShartBrownFrameWork

    private static void PokemonSelection() throws InterruptedException {

        ratButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (PokemonSelctionvalue == true) {// Only Lets you select if you have not confirmed

                    // Sets Default Values to stats for selected pokemon
                    SelectedPokemon = "Rat";

                    MovesAsignment(RatStrongAttack, RatMediumAttack, RatWeakAttack, RatEffectAttack, RatHealth,
                            RatStrongAcc, RatMediumAcc, RatWeakAcc, RatEffectAcc);

                    // Displays attack stats before picking
                    AttackDisplay(UserStrongDmg, UserMediumDmg, UserWeakDmg, UserEffectDmg, UserHealth, UserStrongAcc,
                            UserMediumAcc, UserWeakAcc, UserEffectAcc);
                }
                if (PokemonSelctionvalue == false) {
                    System.out.println("You already chose " + SelectedPokemon);
                }
            }
        });
        snakeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (PokemonSelctionvalue == true) { // Only Lets you select if you have not confirmed

                    // Sets Default Values to stats for selected pokemon
                    SelectedPokemon = "Snake";
                    MovesAsignment(SnakeStrongAttack, SnakeMediumAttack, SnakeWeakAttack, SnakeEffectAttack,
                            SnakeHealth, SnakeStrongAcc, SnakeMediumAcc, SnakeWeakAcc, SnakeEffectAcc);

                    // Displays attack stats before picking
                    AttackDisplay(UserStrongDmg, UserMediumDmg, UserWeakDmg, UserEffectDmg, UserHealth, UserStrongAcc,
                            UserMediumAcc, UserWeakAcc, UserEffectAcc);
                }
                if (PokemonSelctionvalue == false) {
                    System.out.println("You already chose " + SelectedPokemon);
                }
            }
        });
        turtleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (PokemonSelctionvalue == true) { // Only Lets you select if you have not confirmed

                    // Sets Default Values to stats for selected pokemon
                    SelectedPokemon = "Turtle";
                    MovesAsignment(TurtleStrongAttack, TurtleMediumAttack, TurtleWeakAttack, TurtleEffectAttack,
                            TurtleHealth, TurtleStrongAcc, TurtleMediumAcc, TurtleWeakAcc, TurtleEffectAcc);

                    // Displays attack stats before picking
                    AttackDisplay(UserStrongDmg, UserMediumDmg, UserWeakDmg, UserEffectDmg, UserHealth, UserStrongAcc,
                            UserMediumAcc, UserWeakAcc, UserEffectAcc);

                } else {
                    System.out.println("You already chose " + SelectedPokemon);
                }
            }
        });

    }// PokemonSelection

    private static void ButtonTesting() throws InterruptedException {

        TestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (PokemonSelctionvalue == true) {

                    panel.remove(turtleButton);
                    panel.remove(snakeButton);
                    panel.remove(ratButton);
                    panel.remove(TestButton);

                    UserSelectedPokemonLabel.setText("You: " + SelectedPokemon);
                    PokemonSelctionvalue = false;
                    if (PokemonSelctionvalue == false) {
                        ComputerPokemonSelection();
                    }
                } else {
                    System.out.println("You have already picked a poke mon");
                }

            }
        });
    }

    public static void PlayAttacking() throws InterruptedException {

        // Strong attack button
        Strongattack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (PokemonSelctionvalue == false) {
                    try {
                        UpdateHealth();
                    } catch (InterruptedException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    // Calls the attack method with try and catch because of the sleep
                    try {
                        CompHealth = Attackingmethod(UserStrongDmg, CompHealth, UserStrongAcc, 0);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    System.out.println(CompHealth);

                    try {
                        CompMoveSelection();
                        Thread.sleep(500);
                        UpdateHealth();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

            }
        });// Strong Attack

        // Medium Attack Button
        Mediumattack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PokemonSelctionvalue == false) {
                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    // Calls the attack method with try and catch because of the sleep
                    try {
                        CompHealth = Attackingmethod(UserMediumDmg, CompHealth, UserMediumAcc, 0);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }

                    try {
                        CompMoveSelection();
                        Thread.sleep(500);
                        UpdateHealth();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

            }
        });// Medium Attack

        // Weak Attack Button
        Weakattack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (PokemonSelctionvalue == false) {
                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    // Calls the attack method with try and catch because of the sleep
                    try {
                        CompHealth = Attackingmethod(UserWeakDmg, CompHealth, UserWeakAcc, 0);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }

                    TurnChecker = false;

                    try {
                        CompMoveSelection();
                        Thread.sleep(500);
                        UpdateHealth();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

            }
        });// Weak Attack

        // Effect Attack Button
        Effectattack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Checks for if the user has already slected a poke mon and the computer has
                // not made their turn yet

                if (PokemonSelctionvalue == false) {
                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }
                    try {
                        CompHealth = Attackingmethod(UserEffectDmg, CompHealth, UserEffectAcc, 0);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    try {
                        UpdateHealth();
                    } catch (InterruptedException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }

                    try {
                        CompMoveSelection();
                        Thread.sleep(500);
                        UpdateHealth();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }

            }
        });// Effect Attack

    }// Play Attaciking Method

    // Method for displaying the stats of the selected moves in the text area
    public static void AttackDisplay(int move1, int move2, int move3, int move4, int health, int acc1, int acc2,
            int acc3, int acc4) {
        attackstats.setText("Stats for " + SelectedPokemon +
                "\nStrong Attack:" + move1 +
                "\nMedium Attack: " + move2 +
                "\nWeak Attack: " + move3 +
                "\nEffect Attack: " + move4 +
                "\nHealth: " + health);

        attackAccuracy.setText(
                "Accuracy Stats \n Strong Accuracy: " + acc1 +
                        "\n Medium Accuracy: " + acc2 +
                        "\n Weak Accuracy: " + acc3 +
                        "\n Effect Accuracy: " + acc4 + "\n");

    }// Attack Display

    // Takes in either comp or user moves and assings them
    public static void MovesAsignment(int move1, int move2, int move3, int move4, int health, int acc1, int acc2,
            int acc3, int acc4) {
        UserStrongDmg = move1;
        UserMediumDmg = move2;
        UserWeakDmg = move3;
        UserEffectDmg = move4;
        UserHealth = health;

        UserStrongAcc = acc1;
        UserMediumAcc = acc2;
        UserWeakAcc = acc3;
        UserEffectAcc = acc4;

    }// Rat Moves Asignment

    public static void CompMovesAsignment(int move1, int move2, int move3, int move4, int health, int acc1, int acc2,
            int acc3, int acc4) {
        CompStrongDmg = move1;
        CompMediumDmg = move2;
        CompWeakDmg = move3;
        CompEffectDmg = move4;
        CompHealth = health;

        CompStrongAcc = acc1;
        CompMediumAcc = acc2;
        CompWeakAcc = acc3;
        CompEffectAcc = acc4;

    }// Rat Moves Asignment

    // Takes in users input of damage and the other person health | Needs to be
    // called equaling the oposing foes health
    private static int Attackingmethod(int moveDMG, int EnemyHealth, int moveACC, int User)
            throws InterruptedException {
        Thread.sleep(500);

        if (User == 1) {
            WhoIsWho = "Computers";
        }
        if (User == 0) {
            WhoIsWho = "Users";

        }
        int random = (int) Math.floor(Math.random() * 100 + 1);
        if (random <= moveACC) {
            DidAttackHit.setText("The" + WhoIsWho + " Attack Hit for " + moveDMG);
            System.out.println(EnemyHealth + "The update helath attack hit" + moveDMG);
            System.out.println();
            EnemyHealth = EnemyHealth - moveDMG;
            if (User == 0) {
                DidYourAttackHit.setText("Your attack hit for " + moveDMG);
            }
            return EnemyHealth;

        } else {
            DidAttackHit.setText("The " + WhoIsWho + "Attack Missed :(");
            if (User == 0) {
                DidYourAttackHit.setText("Your attack missed");
            }
            return EnemyHealth;

        }
    }// Attacking method

    private static void CompMoveSelection() throws InterruptedException {// Computer Picks a random number and then uses
                                                                         // the move
        int jhit;
        WhoseTurnItIs.setText("The computer is now selecting a move");
        Thread.sleep(500);
        int random = (int) Math.floor(Math.random() * 4 + 1);
        if (random == 1) {
            WhoseTurnItIs.setText("The Computer Chose Strong Attack");
            jhit = Attackingmethod(CompStrongDmg, UserHealth, CompStrongAcc, 1);
            System.out.println("Strong " + jhit);
            UserHealth = jhit;
            UpdateHealth();
        }

        if (random == 2) {
            DidAttackHit.setText("The Computer Chose Medium Attack");
            jhit = Attackingmethod(CompMediumDmg, UserHealth, CompMediumAcc, 1);
            System.out.println("medium " + jhit);
            UserHealth = jhit;
            UpdateHealth();
        }

        if (random == 3) {
            DidAttackHit.setText("The Computer Chose Weak Attack");
            jhit = Attackingmethod(CompWeakDmg, UserHealth, CompWeakAcc, 1);
            System.out.println("weak " + jhit);
            UserHealth = jhit;
            UpdateHealth();
        }

        if (random == 4) {
            DidAttackHit.setText("The Computer Chose Effect Attack");
            jhit = Attackingmethod(CompEffectDmg, UserHealth, CompEffectAcc, 1);
            System.out.println("Effect " + jhit);
            UserHealth = jhit;
            UpdateHealth();
        }
        WhoseTurnItIs.setText("Select your move");
    }

    private static void UpdateHealth() throws InterruptedException {
        String Userhealth = String.valueOf(UserHealth);
        String ComputerHealth = String.valueOf(CompHealth);
        UserHealthLabel.setText("You have " + Userhealth + " hp");
        CompHealthLabel.setText("The computer has " + ComputerHealth + " hp");
        GameCanRun();

    }

    private static void ComputerPokemonSelection() {
        int random = (int) Math.floor(Math.random() * 3 + 1);
        System.out.println(random);
        if (random == 1) {// Selects for Rat

            CompMovesAsignment(RatStrongAttack, RatMediumAttack, RatWeakAttack,
                    RatEffectAttack, RatHealth, RatStrongAcc, RatMediumAcc, RatWeakAcc,
                    RatEffectAcc);
            // CompMovesAsignment(100, 100, 100, 100, 100, 100, 100, 100, 100);
            CompSelectedPokemon = "Rat";
            // Shows they selected what pokemon on
            // the bottom right
            CompSelectedPokemonLabel.setText("Comp: " + CompSelectedPokemon);// Sets bottom left to always show what
                                                                             // pokemon they
            // have

        }
        if (random == 2) {// Selects for Snake

            CompMovesAsignment(SnakeStrongAttack, SnakeMediumAttack, SnakeWeakAttack,
                    SnakeEffectAttack, SnakeHealth, SnakeStrongAcc, SnakeMediumAcc, SnakeWeakAcc, SnakeEffectAcc);
            // CompMovesAsignment(100, 100, 100, 100, 100, 100, 100, 100, 100);
            CompSelectedPokemon = "Snake";
            // Shows they selected what pokemon on
            // the bottom right
            CompSelectedPokemonLabel.setText("Comp: " + CompSelectedPokemon);// Sets bottom left to always show what
                                                                             // pokemon they
            // have

        }
        if (random == 3) {// Selects for Turtle

            CompMovesAsignment(TurtleStrongAttack, TurtleMediumAttack, TurtleWeakAttack,
                    TurtleEffectAttack,
                    TurtleHealth, TurtleStrongAcc, TurtleMediumAcc, TurtleWeakAcc,
                    TurtleEffectAcc);// Assigns moves to
                                     // comps move
            // CompMovesAsignment(100, 100, 100, 100, 100, 100, 100, 100, 100);
            CompSelectedPokemon = "Turtle"; // Stores What they selected in string
            // Shows they selected what pokemon on
            // the bottom right
            CompSelectedPokemonLabel.setText("Comp: " + CompSelectedPokemon);// Sets bottom left to always show what
                                                                             // pokemon they
            // have

        }

    }

    // Checks if
    private static void GameCanRun() throws InterruptedException {

        if (UserHealth <= 0) {

            UserHealthLabel.setText("YOU LOST");
            CompHealthLabel.setText("YOU LOST");
            WhoseTurnItIs.setText("YOU LOST");
            DidAttackHit.setText("YOU LOST");
            DidYourAttackHit.setText("YOU LOST");
            ratButton.setText("YOU LOST");
            turtleButton.setText("YOU LOST");
            snakeButton.setText("YOU LOST");
            TestButton.setText("YOU LOST");
            Strongattack.setText("YOU LOST");
            Mediumattack.setText("YOU LOST");
            Weakattack.setText("YOU LOST");
            Effectattack.setText("YOU LOST");
            UserSelectedPokemonLabel.setText("YOU LOST");
            CompSelectedPokemonLabel.setText("YOU LOST");
            attackstats.setText("YOU LOST");
            attackAccuracy.setText("YOU LOST");

            Thread.sleep(5000);
            System.exit(0);

        }
        if (CompHealth <= 0) {
            UserHealthLabel.setText("YOU WON");
            CompHealthLabel.setText("YOU WON");
            WhoseTurnItIs.setText("YOU WON");
            DidAttackHit.setText("YOU WON");
            DidYourAttackHit.setText("YOU WON");
            ratButton.setText("YOU WON");
            turtleButton.setText("YOU WON");
            snakeButton.setText("YOU WON");
            TestButton.setText("YOU WON");
            Strongattack.setText("YOU WON");
            Mediumattack.setText("YOU WON");
            Weakattack.setText("YOU WON");
            Effectattack.setText("YOU WON");
            UserSelectedPokemonLabel.setText("YOU WON");
            CompSelectedPokemonLabel.setText("YOU WON");
            attackstats.setText("YOU WON");
            attackAccuracy.setText("YOU WON");

            Thread.sleep(5000);
            System.exit(0);
        }

    }

    public static void main(String args[]) throws InterruptedException {
        new BattleSimulator();

        PokemonSelection();
        ButtonTesting();

        PlayAttacking();

        // CompMoveSelection();

    }// Main Method

}// File end
