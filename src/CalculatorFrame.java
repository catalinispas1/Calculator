import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton[] buttons = new JButton[18];
    JTextField calculate;
    JTextField result;
    CalculatorFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(420, 500);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(24,24,24));
        this.setVisible(true);

        panel2.setLayout(new GridLayout(4,4, 5, 5));
        panel2.setBounds(10, 150, 385, 250);

        panel1.setLayout(new GridLayout(1 , 2, 20, 20));
        panel1.setBounds(20, 410, 365, 40);

        String[] operants = {"+", "-", "*"};
        int counter = 0;
        for(int i = 1; i <= 12; i++){
            if(i % 4 == 0){
                buttons[i - 1] = new JButton(operants[counter]);
                panel2.add(buttons[i - 1]);
                counter++;
            }
            else{
                buttons[i - 1] = new JButton(Integer.toString(i - counter));
                panel2.add(buttons[i - 1]);
            }
        }
        buttons[12] = new JButton(".");
        panel2.add(buttons[12]);
        buttons[13] = new JButton("0");
        panel2.add(buttons[13]);
        buttons[14] = new JButton("#");
        panel2.add(buttons[14]);
        buttons[15] = new JButton("/");
        panel2.add(buttons[15]);

        panel1.setBackground(new Color(26, 17, 16));
        panel2.setBackground(new Color(26, 17, 16));
        this.add(panel2);

        buttons[16] = new JButton("Delete");
        panel1.add(buttons[16]);
        buttons[17] = new JButton("Clear");
        panel1.add(buttons[17]);

        for(JButton button: buttons){
            button.addActionListener(this);
            button.setBackground(new Color(24,24,24));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.PLAIN, 25));
            button.setFocusable(false);
        }

        this.add(panel1);

        Font myFont = new Font("Roboto", Font.BOLD, 30);

        calculate = new JTextField();
        calculate.setBounds(10, 10, 385, 60);
        calculate.setEditable(false);
        calculate.setFont(myFont);
        calculate.setBackground(new Color(24,24,24));
        calculate.setForeground(Color.WHITE);

        result = new JTextField();
        result.setBounds(10, 80, 385, 60);
        result.setEditable(false);
        result.setFont(myFont);
        result.setBackground(new Color(24,24,24));
        result.setForeground(Color.WHITE);

        this.add(calculate);
        this.add(result);

        buttons[3].setEnabled(false);
        buttons[7].setEnabled(false);
        buttons[11].setEnabled(false);
        buttons[14].setEnabled(false);
        buttons[15].setEnabled(false);

        result.setText("" + 0);
    }
    Input input = new Input();

    @Override
    public void actionPerformed(ActionEvent e) {

        int counter = 0;
        for (int i = 1; i <= 12; i++) {
            if (i % 4 == 0) {
                counter++;
            } else {
                if (e.getSource() == buttons[i - 1]) {
                    if(calculate.getText().length() > 0){
                        String[] checkZero = calculate.getText().split(" ");
                        if(checkZero[checkZero.length - 1].equals("0")){
                            String removeZero = "";
                            for(int j = checkZero.length - 2; j >= 0; j-- ){
                                removeZero = checkZero[j] + " " + removeZero;
                            }
                            calculate.setText(removeZero.concat(String.valueOf(i - counter)));
                        } else calculate.setText(calculate.getText().concat(String.valueOf(i - counter)));
                    } else calculate.setText(calculate.getText().concat(String.valueOf(i - counter)));

                    buttons[3].setEnabled(true);
                    buttons[7].setEnabled(true);
                    buttons[11].setEnabled(true);
                    buttons[14].setEnabled(true);
                    buttons[15].setEnabled(true);

                    result.setText("" + input.calculateNow(calculate.getText().split(" ")));
                }
            }
        }

        if (e.getSource() == buttons[3]) {
            calculate.setText(calculate.getText().concat(" + "));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[12].setEnabled(true);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);

            buttons[12].setEnabled(true);
        } else if (e.getSource() == buttons[7]) {
            calculate.setText(calculate.getText().concat(" - "));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[12].setEnabled(true);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);

            buttons[12].setEnabled(true);
        } else if (e.getSource() == buttons[11]) {
            calculate.setText(calculate.getText().concat(" * "));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[12].setEnabled(true);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);

            buttons[12].setEnabled(true);
        } else if (e.getSource() == buttons[12]) {
            if(calculate.getText().split(" ").length % 2 == 0 || calculate.getText().length() == 0)
                calculate.setText(calculate.getText().concat("0."));
            else calculate.setText(calculate.getText().concat("."));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);
            buttons[12].setEnabled(false);

        } else if (e.getSource() == buttons[13]) {
            if(calculate.getText().length() > 0){
                String[] checkZero = calculate.getText().split(" ");
                if(checkZero[checkZero.length - 1].equals("0")){
                    String removeZero = "";
                    for(int j = checkZero.length - 2; j >= 0; j-- ){
                        removeZero = checkZero[j] + " " + removeZero;
                    }
                    calculate.setText(removeZero.concat(String.valueOf(0)));
                } else calculate.setText(calculate.getText().concat(String.valueOf(0)));
            } else calculate.setText(calculate.getText().concat(String.valueOf(0)));

            buttons[3].setEnabled(true);
            buttons[7].setEnabled(true);
            buttons[11].setEnabled(true);
            buttons[14].setEnabled(true);
            buttons[15].setEnabled(true);

            result.setText("" + input.calculateNow(calculate.getText().split(" ")));
        } else if (e.getSource() == buttons[14]) {
            calculate.setText(calculate.getText().concat(" # "));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[12].setEnabled(true);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);
        } else if (e.getSource() == buttons[15]) {
            calculate.setText(calculate.getText().concat(" / "));

            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[12].setEnabled(true);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);
        } else if (e.getSource() == buttons[16]) {
            if (calculate.getText().length() > 0){
                if(calculate.getText().charAt(calculate.getText().length() - 1) != ' '){
                    if(calculate.getText().charAt(calculate.getText().length() -1) == '.'){
                        buttons[12].setEnabled(true);
                    }
                    calculate.setText(calculate.getText().substring(0, calculate.getText().length() - 1));
                }
                else{
                    calculate.setText(calculate.getText().substring(0, calculate.getText().length()- 3));
                }

                if(calculate.getText().split(" ").length % 2 == 0){
                    buttons[3].setEnabled(false);
                    buttons[7].setEnabled(false);
                    buttons[11].setEnabled(false);
                    buttons[14].setEnabled(false);
                    buttons[15].setEnabled(false);
                }else{
                    buttons[3].setEnabled(true);
                    buttons[7].setEnabled(true);
                    buttons[11].setEnabled(true);
                    buttons[14].setEnabled(true);
                    buttons[15].setEnabled(true);

                    if(calculate.getText().length() > 1){
                        String[] lastNumCheck = calculate.getText().split(" ");
                        String lastNum = lastNumCheck[lastNumCheck.length - 1];

                        for(int i = 0; i < lastNum.length(); i++){
                            if(lastNum.charAt(i) == '.'){
                                buttons[12].setEnabled(false);
                                break;
                            }
                        }
                    }
                }
                if(calculate.getText().equals("")) {
                    result.setText("" + 0);
                    buttons[3].setEnabled(false);
                    buttons[7].setEnabled(false);
                    buttons[11].setEnabled(false);
                    buttons[14].setEnabled(false);
                    buttons[15].setEnabled(false);
                }
                else result.setText("" + input.calculateNow(calculate.getText().split(" ")));
            }
        } else if (e.getSource() == buttons[17]) {
            buttons[3].setEnabled(false);
            buttons[7].setEnabled(false);
            buttons[11].setEnabled(false);
            buttons[14].setEnabled(false);
            buttons[15].setEnabled(false);

            calculate.setText("");
            buttons[12].setEnabled(true);
            result.setText("" + 0);
        }
    }
}
