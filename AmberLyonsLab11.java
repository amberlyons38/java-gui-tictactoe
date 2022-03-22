import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToe extends JFrame{
    private JPanel windowContent, buttonsPanel, gameDisplayBarPanel, buttonsPanelStyle;
    
    private JTextField gameDisplayBar;
    
    private JButton buttons[];
    
    private int turns;
    
    public TicTacToe(){
        createUserInterface();
    }
    
    //Create and position the GUI components and register event handlers
    private void createUserInterface(){
        //Creates a panel to contain the content in the window
        windowContent = new JPanel();
        //Sets the windowContent panel to a border layout
        BorderLayout tictactoeGameLayout = new BorderLayout();
        windowContent.setLayout(tictactoeGameLayout);
        
        //Creates a panel that creates a stylistic border for the buttonsPanel
        buttonsPanelStyle = new JPanel();
        BorderLayout buttonsBorderLayout = new BorderLayout();
        buttonsPanelStyle.setLayout(buttonsBorderLayout);
        //Sets the border for the buttonsPanelStyle panel
        buttonsPanelStyle.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //Adds panel to center of windowContent panel
        windowContent.add("Center", buttonsPanelStyle);
        
        //Creates a panel that contains all of the tictactoe buttons
        buttonsPanel = new JPanel();
        //Sets the buttonsPanel to a grid layout
        GridLayout tictactoeButtonsLayout = new GridLayout(3, 3, 5, 5);
        buttonsPanel.setLayout(tictactoeButtonsLayout);
        //Sets the background color of the buttons panel to black
        buttonsPanel.setBackground(Color.BLACK);
        //Creates custom line border for the button panel style panel
        Border buttonsPanelBorder = BorderFactory.createLineBorder(Color.RED, 20);
        buttonsPanel.setBorder(buttonsPanelBorder);
        
        //Declares an array of 9 JButtons
        buttons = new JButton[9];
        
        //Sets the number of turns taken to 0
        turns = 0;
        
        //Creates 9 JButtons and stylizes them and adds action listeners to them
        for(int i = 0; i < 9; i++) {
            //Creates a new JButton for i
            buttons[i] = new JButton();
            //Sets background color of the buttons to white
            buttons[i].setBackground(Color.WHITE);
            //Sets border of the buttons to lowered bevel
            buttons[i].setBorder(new BevelBorder(BevelBorder.LOWERED));
            //Sets the font of the buttons to bold arial
            buttons[i].setFont(new Font("Arial", Font.BOLD, 100));
            //Presets the button text to be blank
            buttons[i].setText("");
            //Adds an action listener to the button at i
            buttons[i].addActionListener(
                    //Creates new action listener object
                new ActionListener(){
                    @Override
                    //Creates method that declares what the action listener will impact
                    public void actionPerformed(ActionEvent event){
                        //Creates a new JButton that changes the text of a specific button when it's clicked
                        JButton buttonClicked = (JButton)event.getSource();
                        //If the turns are even that means it's the X player's turn
                        if(turns % 2 == 0){
                            //Presets the bar to display for when the O player will click
                            gameDisplayBar.setText("Player O's Turn: ");
                            //Sets the clicked button's text to X
                            buttonClicked.setText("X");
                            //Disables the clicked button so the text cannot be further changed
                            buttonClicked.setEnabled(false);
                            //If the checkWins method doesn't return a blank that means someone has won
                            if(!checkWins().equals("")){
                                //Make the bar display the winner
                                gameDisplayBar.setText(checkWins());
                                //Disables any of the buttons that haven't been clicked yet so they cannot be clicked after the game is won
                                if(buttons[0].getText().equals("")){
                                    buttons[0].setEnabled(false);
                                }
                                if(buttons[1].getText().equals("")){
                                    buttons[1].setEnabled(false);
                                }
                                if(buttons[2].getText().equals("")){
                                    buttons[2].setEnabled(false);
                                }
                                if(buttons[3].getText().equals("")){
                                    buttons[3].setEnabled(false);
                                }
                                if(buttons[4].getText().equals("")){
                                    buttons[4].setEnabled(false);
                                }
                                if(buttons[5].getText().equals("")){
                                    buttons[5].setEnabled(false);
                                }
                                if(buttons[6].getText().equals("")){
                                    buttons[6].setEnabled(false);
                                }
                                if(buttons[7].getText().equals("")){
                                    buttons[7].setEnabled(false);
                                }
                                if(buttons[8].getText().equals("")){
                                    buttons[8].setEnabled(false);
                                }
                            }
                        }
                        //If the turns are odd that means it's the O player's turn
                        else{
                            //Presets the bar to display for when the X player will click
                            gameDisplayBar.setText("Player X's Turn: ");
                            //Sets the clicked button's text to O
                            buttonClicked.setText("O");
                            //Disables the clicked button so the text cannot be further changed
                            buttonClicked.setEnabled(false);
                            //If the checkWins method doesn't return a blank that means someone has won
                            if(!checkWins().equals("")){
                                //Make the bar display the winner
                                gameDisplayBar.setText(checkWins());
                                //Disables any of the buttons that haven't been clicked yet so they cannot be clicked after the game is won
                                if(buttons[0].getText().equals("")){
                                    buttons[0].setEnabled(false);
                                }
                                if(buttons[1].getText().equals("")){
                                    buttons[1].setEnabled(false);
                                }
                                if(buttons[2].getText().equals("")){
                                    buttons[2].setEnabled(false);
                                }
                                if(buttons[3].getText().equals("")){
                                    buttons[3].setEnabled(false);
                                }
                                if(buttons[4].getText().equals("")){
                                    buttons[4].setEnabled(false);
                                }
                                if(buttons[5].getText().equals("")){
                                    buttons[5].setEnabled(false);
                                }
                                if(buttons[6].getText().equals("")){
                                    buttons[6].setEnabled(false);
                                }
                                if(buttons[7].getText().equals("")){
                                    buttons[7].setEnabled(false);
                                }
                                if(buttons[8].getText().equals("")){
                                    buttons[8].setEnabled(false);
                                }  
                            }
                        }
                        //Turns increments by 1
                        turns++;
                    }
                }
            );
            //Adds each button to the buttonsPanel
            buttonsPanel.add(buttons[i]);
        }
        //Adds the buttons panel to it's style panel
        buttonsPanelStyle.add("Center", buttonsPanel);
        
        //Creates a panel that will contain the text field display bar
        gameDisplayBarPanel = new JPanel();
        //Sets the gamedisplayBarPanel to a border layout
        BorderLayout gameDisplayBarLayout = new BorderLayout();
        gameDisplayBarPanel.setLayout(gameDisplayBarLayout);
        //Creates custom line border for the gamedisplayBarPanel
        Border displayPanelBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 20);
        gameDisplayBarPanel.setBorder(displayPanelBorder);
        //Adds the gameDisplayBarPanel to the south of windowContent panel
        windowContent.add("South", gameDisplayBarPanel);
        
        //Creates a new JTextField
        gameDisplayBar = new JTextField();
        //Sets the border of the text field to lower beveled
        gameDisplayBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //Sets the alignment of the text in the text field to the left
        gameDisplayBar.setHorizontalAlignment(JTextField.LEFT);
        //Makes it so the text field can not be edited by the user
        gameDisplayBar.setEditable(false);
        //Presets the text in the text field for the first turn
        gameDisplayBar.setText("Player X's Turn: ");
        //Sets the size of the text field
        gameDisplayBar.setSize(50, 100);
        //Sets the font and font size of the text in the text field
        gameDisplayBar.setFont(new Font("Lucida Console", Font.PLAIN, 17));
        //Sets the font color of the text to black
        gameDisplayBar.setForeground(Color.BLACK);
        //Adds the gameDisplayBar to the center of the gameDisplayBarPanel
        gameDisplayBarPanel.add("Center", gameDisplayBar);
        
        //Creates a new JFrame and sets the window title to TicTacToe
        JFrame frame = new JFrame("TicTacToe");
        //Sets the contentPane of the JFrame to the windowContent panel
        frame.setContentPane(windowContent);
        //Sets the size of the window to 500x500
        frame.setSize(500, 500);
        //Makes the window visible
        frame.setVisible(true);
        //Sets the application to stop running when the exit button is clicked on the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    //Checks for the winning conditions of the game
    private String checkWins(){
        //Checks horizontally
        if((buttons[0].getText().equals(buttons[1].getText()) && !buttons[0].getText().equals("")) && (buttons[1].getText().equals(buttons[2].getText())
        && !buttons[1].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[0].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        else if((buttons[3].getText().equals(buttons[4].getText()) && !buttons[3].getText().equals("")) && (buttons[4].getText().equals(buttons[5].getText())
        && !buttons[4].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[3].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        else if((buttons[6].getText().equals(buttons[7].getText()) && !buttons[6].getText().equals("")) && (buttons[7].getText().equals(buttons[8].getText())
        && !buttons[7].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[6].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        //Checks vertically
        else if((buttons[0].getText().equals(buttons[3].getText()) && !buttons[0].getText().equals("")) && (buttons[3].getText().equals(buttons[6].getText())
        && !buttons[3].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[0].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        else if((buttons[1].getText().equals(buttons[4].getText()) && !buttons[1].getText().equals("")) && (buttons[4].getText().equals(buttons[7].getText())
        && !buttons[4].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[1].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        else if((buttons[2].getText().equals(buttons[5].getText()) && !buttons[2].getText().equals("")) && (buttons[5].getText().equals(buttons[8].getText())
        && !buttons[5].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[2].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        //checks diagonally
        else if((buttons[0].getText().equals(buttons[4].getText()) && !buttons[0].getText().equals("")) && (buttons[4].getText().equals(buttons[8].getText())
        && !buttons[4].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[0].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        else if((buttons[2].getText().equals(buttons[4].getText()) && !buttons[2].getText().equals("")) && (buttons[4].getText().equals(buttons[6].getText())
        && !buttons[4].getText().equals(""))){
            //If the buttons are X's then declare X the winner
            if(buttons[4].getText().equals("X")){
                return "Player X wins!";
            }
            //If the buttons are O's then declare O the winner
            else{
                return "Player O wins!";
            }
        }
        //Checks for ties
        else if(!buttons[0].getText().equals("") && !buttons[1].getText().equals("") && !buttons[2].getText().equals("") && !buttons[3].getText().equals("") && !buttons[4].getText().equals("")
        && !buttons[5].getText().equals("") && !buttons[6].getText().equals("") && !buttons[7].getText().equals("") && !buttons[8].getText().equals("")){
            //If all of the buttons have been clicked and none of them are aligned then it must be a tie
            return "It's a tie!";
        }
        //If it is none then the display bar text does not change
        else{
            return "";
        }
    }
}
//Main class
public class AmberLyonsLab11 {
    public static void main(String[] args){
        //Creates a new TicTacToe object application
        TicTacToe application = new TicTacToe();
    }
}
