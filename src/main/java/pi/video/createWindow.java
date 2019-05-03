package pi.video;
//Подключение необходимых библиотек
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Объявление класса createWindow
public class createWindow {

	//Объявление переменных типа JFrame JTextField
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	//Объявление переменных класса
	public static double[] calcValues = new double[7];
	public static boolean error;

	//Метод main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//Паблик метод run включающий отображение главного фрейма
			public void run() {
				//Создание экземпляра класса createWindow
				createWindow window = new createWindow();
				//Отключение невидимости фрейма
				window.frame.setVisible(true);
			}
		});
	}
	

	//Паблик метод createWindow запускающий метод initialize
	public createWindow() {
		initialize();
	}
	//Приватный метод initialize реализующий создание главного окна программы
	private void initialize() {
		
		//Создаем фрейм и устанавливаем значение заголовка
		frame = new JFrame();
		frame.setTitle("\u041F\u0418 217");
		frame.setBounds(100, 100, 460, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//*********************************************************\\
		//Создаем textField-ы и устанавливаем значения по умолчанию\\
		//*********************************************************\\
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setText("1280");
		textField.setBounds(268, 77, 131, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText("1024");
		textField_1.setBounds(268, 108, 131, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("24");
		textField_2.setColumns(10);
		textField_2.setBounds(268, 139, 131, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText("25");
		textField_3.setBounds(268, 170, 131, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setText("52");
		textField_4.setBounds(268, 201, 131, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setText("16");
		textField_5.setBounds(268, 232, 131, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setText("44100");
		textField_6.setBounds(268, 263, 131, 20);
		frame.getContentPane().add(textField_6);
		//*********************************************************\\
		
		
		//**************\\
		//Создаем лейблы\\
		//**************\\
		JLabel lblNewLabel = new JLabel("\u0428\u0438\u0440\u0438\u043D\u0430 \u0438\u0437\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u044F (px)");
		lblNewLabel.setBounds(54, 80, 150, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblpx = new JLabel("\u0412\u044B\u0441\u043E\u0442\u0430 \u0438\u0437\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u044F (px)");
		lblpx.setBounds(54, 111, 150, 14);
		frame.getContentPane().add(lblpx);
		
		JLabel label_1 = new JLabel("\u0413\u043B\u0443\u0431\u0438\u043D\u0430 \u0446\u0432\u0435\u0442\u0430 (\u0431\u0438\u0442)");
		label_1.setBounds(54, 142, 150, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043A\u0430\u0434\u0440\u043E\u0432 (\u0448\u0442)");
		label_2.setBounds(54, 173, 150, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u0414\u043B\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u044C \u0432\u0438\u0434\u0435\u043E (\u0441\u0435\u043A)");
		label_3.setBounds(54, 204, 150, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u0420\u0430\u0437\u0440\u044F\u0434\u043D\u043E\u0441\u0442\u044C \u0437\u0432\u0443\u043A\u0430 (\u0431\u0438\u0442)");
		label_4.setBounds(54, 235, 150, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u0427\u0430\u0441\u0442\u043E\u0442\u0430 \u0434\u0438\u0441\u043A\u0440\u0435\u0442\u0438\u0437\u0430\u0446\u0438\u0438 (\u0413\u0446)");
		label_5.setBounds(54, 266, 150, 14);
		frame.getContentPane().add(label_5);
		//*********************************************************\\
		
		//Создаем кнопку
		JButton btnNewButton = new JButton("\u0420\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u0442\u044C");
		//Создаем слушатель для кнопки
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Проверка textField-ов на пустоту
				if(isTextFieldEmpty())
					//Если хотябы одно из полей пустое - выводим окно JOptionPane.showMessageDialog с сообщением об ошибке
					JOptionPane.showMessageDialog(null, "Все поля обязательны для заполнения!", "Ошибка", JOptionPane.WARNING_MESSAGE);
				
				//Проверка введены ли числовые значения
				if(isNumericValues() == true)
					//Заполняем массив значениями из textField-ов	
					setArrayValues();
				else
					//Если введены не числовые значения, выводим окно с сообщением об ошибке
					JOptionPane.showMessageDialog(null, "Введите числовые значения!", "Ошибка", JOptionPane.WARNING_MESSAGE);
				
				//Устанавливаем значение по умолчанию для переменной error информирующей об ошибке в заполнении полей
				error = false;
				//Проходимся циклом по всем значениям массива calcValues
				for(int i = 0; i < 7; i++) {
					//Проверяем значения массива методом toValidate
					if(toValidate(calcValues[i]) == true) {
						error = true;
						break;
					} 
						
				}
				//Если значение переменной error - истина, выводим окно с сообщением об ошибке
				if (error == true) {
					JOptionPane.showMessageDialog(null, "Введите положительные значения", "Ошибка", JOptionPane.WARNING_MESSAGE);
				} else {
				//Иначе выполняем вычисления в классе Calculate
					//Создаем экземпляр класса calculate
					Calculate calculate = new Calculate();
					//Выводим значение полученное в классе Calculate в текстовое поле
					textField_7.setText((calculate.toFormateResult()));	
				}
			}
		});
		btnNewButton.setBounds(268, 310, 131, 23);
		frame.getContentPane().add(btnNewButton);
		
	    //Создание текстового поля
		textField_7 = new JTextField();
		textField_7.setBounds(268, 360, 131, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		//Создание лейбла
		JLabel lblNewLabel_1 = new JLabel("\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442:");
		lblNewLabel_1.setBounds(141, 363, 63, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	//Метод setArrayValues реализующий добавление значений из textField-ов в массив
	public void setArrayValues() {
		calcValues[0] = Integer.parseInt(textField.getText());
		calcValues[1] = Integer.parseInt(textField_1.getText());
		calcValues[2] = Integer.parseInt(textField_2.getText());
		calcValues[3] = Integer.parseInt(textField_3.getText());
		calcValues[4] = Integer.parseInt(textField_4.getText());
		calcValues[5] = Integer.parseInt(textField_5.getText());
		calcValues[6] = Integer.parseInt(textField_6.getText());
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public boolean isNumericValues() {
		if (	!isNumeric(textField.getText())   ||
				!isNumeric(textField_1.getText()) ||
				!isNumeric(textField_2.getText()) ||
				!isNumeric(textField_3.getText()) ||
				!isNumeric(textField_4.getText()) ||
				!isNumeric(textField_5.getText()) ||
				!isNumeric(textField_6.getText()) )
			return false;
		else
			return true;
	}

	//Метод getArrayOfValues реализующий передачу данных из массива calcValues в класс Calculate
	public double[] getArrayOfValues() {
        return calcValues;
    }
	
	//Метод isTextFieldEmpty реализующий проверку textField-ов на пустоту
	public boolean isTextFieldEmpty() {
		//getText() - берет текст из текстового поля, trim() - удаляет пробелы, isEmpty() - проверяет пустое значение или нет
		if(		textField.getText().trim().isEmpty()   ||
				textField_1.getText().trim().isEmpty() ||
				textField_2.getText().trim().isEmpty() ||
				textField_3.getText().trim().isEmpty() ||
				textField_4.getText().trim().isEmpty() ||
				textField_5.getText().trim().isEmpty() ||
				textField_6.getText().trim().isEmpty() ||
				textField.getText().trim().isEmpty()) 
		{
			return true;
		} else
			return false;
	}
	
	//Метод toValidate реализующий проверку значений на положительность
	public boolean toValidate(double textFieldValue) {
		boolean er;
		if (textFieldValue <= 0 ) 
			er= true;
		 else
			er = false ;
		return er;
	}
}
