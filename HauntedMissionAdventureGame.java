import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HauntedMissionAdventureGame extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel imageLabel;
    private boolean gameEnded = false;

    public HauntedMissionAdventureGame() {
        setTitle("Haunted Mission Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputField = new JTextField(30);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        inputPanel.add(inputField);
        inputPanel.add(submitButton);
        add(inputPanel, BorderLayout.SOUTH);

        // Load and display a haunted house image
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("haunted-house.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel, BorderLayout.WEST);

        textArea.append("Welcome to the Haunted Mission Adventure...\n");
        textArea.append("You've been tasked with exploring a haunted mansion. Can you survive?\n");
        textArea.append("Enter 'start' to begin...\n");
    }

    public void actionPerformed(ActionEvent e) {
        if (gameEnded) {
            inputField.setText("");
            return; // The game has already ended
        }

        String userInput = inputField.getText().toLowerCase().trim();

        // Handle user input and update the game's storyline based on choices
        switch (userInput) {
            case "start":
                textArea.setText(""); // Clear the initial message
                textArea.append("You cautiously enter the haunted mansion...\n");
                textArea.append("You find yourself in a dimly lit hallway. What do you do?\n");
                textArea.append("1. Go left\n");
                textArea.append("2. Go right\n");
                break;
            case "1":
                textArea.append("You chose to go left and discovered a spooky room...\n");
                textArea.append("You see a locked door and a chest. What will you do?\n");
                textArea.append("A. Try to open the door\n");
                textArea.append("B. Open the chest\n");
                break;
            case "2":
                textArea.append("You chose to go right and encountered a ghostly figure...\n");
                textArea.append("It beckons you to follow. What's your decision?\n");
                textArea.append("C. Follow the ghost\n");
                textArea.append("D. Ignore the ghost and continue\n");
                break;
            case "a":
                textArea.append("You tried to open the door but it's locked. The room grows colder...\n");
                textArea.append("You feel a presence behind you. What do you do?\n");
                textArea.append("E. Turn around and face it\n");
                break;
            case "b":
                textArea.append("You opened the chest and found a key. You can now unlock the door...\n");
                textArea.append("You proceed into the next room...\n");
                textArea.append("Congratulations! You've successfully completed the mission!\n");
                gameEnded = true;
                break;
            case "c":
                textArea.append("You decide to follow the ghostly figure...\n");
                textArea.append("It leads you to a hidden room filled with treasure...\n");
                textArea.append("Congratulations! You've completed the mission!\n");
                gameEnded = true;
                break;
            case "d":
                textArea.append("You chose to ignore the ghost and continue...\n");
                textArea.append("You encounter more challenges and mysteries...\n");
                textArea.append("Your adventure continues...\n");
                break;
            case "e":
                textArea.append("You turn around to face the presence, but it vanishes...\n");
                textArea.append("The room returns to its eerie stillness...\n");
                textArea.append("Your adventure continues...\n");
                break;
            default:
                textArea.append("Invalid choice. Try again.\n");
                break;
        }

        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HauntedMissionAdventureGame game = new HauntedMissionAdventureGame();
            game.pack();
            game.setVisible(true);
        });
    }
}