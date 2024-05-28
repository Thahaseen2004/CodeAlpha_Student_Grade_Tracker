import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentGradeTracker extends JFrame {
    private ArrayList<Integer> grades;
    private JTextField gradeInputField;
    private JTextArea displayArea;
    
    public StudentGradeTracker() {
        grades = new ArrayList<>();
        
        // Set up the frame
        setTitle("Student Grade Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create GUI components
        gradeInputField = new JTextField(10);
        JButton addButton = new JButton("Add Grade");
        JButton calculateButton = new JButton("Calculate");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        
        // Layout components
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Grade:"));
        inputPanel.add(gradeInputField);
        inputPanel.add(addButton);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Add button action listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGrade();
            }
        });
        
        // Calculate button action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });
    }
    
    private void addGrade() {
        try {
            int grade = Integer.parseInt(gradeInputField.getText());
            grades.add(grade);
            gradeInputField.setText("");
            displayArea.append("Added Grade: " + grade + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer grade.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calculateGrades() {
        if (grades.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No grades to calculate.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int sum = 0;
        int highest = grades.get(0);
        int lowest = grades.get(0);
        char grade1='A';
        char grade2='B';
        char grade3='C';
        char grade4='F';
    
        for (int grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
            if(grade>=800)
             displayArea.append ("\nGrade of  student with" + grade + " marks is :" +grade1);
            else if(grade>=600 && grade<800) 
             displayArea.append ("\nGrade of 1st student with" + grade + "marks is :" +grade2);
            else if(grade>=400 && grade<600) 
             displayArea.append ("\nGrade of 1st student with" + grade + "marks is :" +grade3);
            else 
             displayArea.append ("\nGrade of 1st student with" + grade + "marks is :" +grade4);
        }

        
        double average = (double) sum / grades.size();
        
        displayArea.append("\nAverage Grade: " + average);
        displayArea.append("\nHighest Grade: " + highest);
        displayArea.append("\nLowest Grade: " + lowest + "\n");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentGradeTracker().setVisible(true);
            }
        });
    }
}
