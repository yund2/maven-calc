package pi.video;
//Подключение необходимых библиотек
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

//Объявление класса createWindow
public class createWindow {

	//Объявление переменных типа JFrame JTextField
	private JFrame frame;
	private JTextField widthText;
	private JTextField heightText;
	private JTextField colorText;
	private JTextField fpsText;
	private JTextField timeText;
	private JTextField soundText;
	private JTextField gzText;
	private JTextField resultText;
	//Объявление переменных класса
	public static double[] calcValues = new double[7];
	public static boolean error;
	private JTextField passwordText;
	public static final String ADMIN_PASSWORD = "admin";

	//Метод main
	public static void main(String[] args) throws Exception {
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
	public void initialize() {
		
		//Создаем фрейм и устанавливаем значение заголовка
		frame = new JFrame();
		frame.setTitle("ПИ 217");
		frame.setBounds(100, 100, 462, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//*********************************************************\\
		//Создаем textField-ы и устанавливаем значения по умолчанию\\
		//*********************************************************\\
		widthText = new JTextField();
		widthText.setToolTipText("");
		widthText.setText("1280");
		widthText.setBounds(269, 123, 131, 20);
		frame.getContentPane().add(widthText);
		widthText.setColumns(10);
		
		heightText = new JTextField();
		heightText.setColumns(10);
		heightText.setText("1024");
		heightText.setBounds(269, 154, 131, 20);
		frame.getContentPane().add(heightText);
		
		colorText = new JTextField();
		colorText.setText("24");
		colorText.setColumns(10);
		colorText.setBounds(269, 185, 131, 20);
		frame.getContentPane().add(colorText);
		
		fpsText = new JTextField();
		fpsText.setColumns(10);
		fpsText.setText("25");
		fpsText.setBounds(269, 216, 131, 20);
		frame.getContentPane().add(fpsText);
		
		timeText = new JTextField();
		timeText.setColumns(10);
		timeText.setText("52");
		timeText.setBounds(269, 247, 131, 20);
		frame.getContentPane().add(timeText);
		
		soundText = new JTextField();
		soundText.setColumns(10);
		soundText.setText("16");
		soundText.setBounds(269, 278, 131, 20);
		frame.getContentPane().add(soundText);
		
		gzText = new JTextField();
		gzText.setColumns(10);
		gzText.setText("44100");
		gzText.setBounds(269, 309, 131, 20);
		frame.getContentPane().add(gzText);
		//*********************************************************\\
		
		
		//**************\\
		//Создаем лейблы\\
		//**************\\
		JLabel widthLabel = new JLabel("Ширина изображения (px)");
		widthLabel.setBounds(55, 126, 204, 14);
		frame.getContentPane().add(widthLabel);
		
		JLabel heightLabel = new JLabel("Высота изображения (px)");
		heightLabel.setBounds(55, 157, 204, 14);
		frame.getContentPane().add(heightLabel);
		
		JLabel colorLabel = new JLabel("Глубина цвета (бит)");
		colorLabel.setBounds(55, 188, 204, 14);
		frame.getContentPane().add(colorLabel);
		
		JLabel fpsLabel = new JLabel("Количество кадров (шт)");
		fpsLabel.setBounds(55, 219, 204, 14);
		frame.getContentPane().add(fpsLabel);
		
		JLabel timeLabel = new JLabel("Длительность видео (сек)");
		timeLabel.setBounds(55, 250, 204, 14);
		frame.getContentPane().add(timeLabel);
		
		JLabel soundLabel = new JLabel("Разрядность звука (бит)");
		soundLabel.setBounds(55, 281, 204, 14);
		frame.getContentPane().add(soundLabel);
		
		JLabel gzLabel = new JLabel("Частота дискретизации (Гц)");
		gzLabel.setBounds(55, 312, 204, 14);
		frame.getContentPane().add(gzLabel);
		//*********************************************************\\
		
		//Создаем кнопку
		JButton resultButton = new JButton("Рассчитать");
		//Создаем слушатель для кнопки
		resultButton.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(null, "Введите положительные значения\nКалькулятор не поддерживает значения больше 1000000", "Ошибка", JOptionPane.WARNING_MESSAGE);
				} else {
				//Иначе выполняем вычисления в классе Calculate
					//Создаем экземпляр класса calculate
					Calculate calculate = new Calculate();
					//Выводим значение полученное в классе Calculate в текстовое поле
					resultText.setText((calculate.toFormateResult()));	
				}
			}
		});
		resultButton.setBounds(269, 356, 131, 23);
		frame.getContentPane().add(resultButton);
		
	    //Создание текстового поля
		resultText = new JTextField();
		resultText.setBounds(269, 406, 131, 20);
		frame.getContentPane().add(resultText);
		resultText.setColumns(10);
		
		//Создание лейбла
		JLabel resultLabel = new JLabel("Результат:");
		resultLabel.setBounds(142, 409, 117, 14);
		frame.getContentPane().add(resultLabel);
		
		final JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(21, 11, 398, 88);
		frame.getContentPane().add(passwordPanel);
		passwordPanel.setLayout(null);
		
		JLabel passwordLabel = new JLabel("Пароль администратора:");
		passwordLabel.setBounds(34, 28, 128, 14);
		passwordPanel.add(passwordLabel);
		
		passwordText = new JTextField();
		passwordText.setText("admin");
		passwordText.setBounds(247, 25, 128, 20);
		passwordPanel.add(passwordText);
		passwordText.setColumns(10);
		
		final JButton reportButton = new JButton("Сформировать отчет");
		reportButton.setVisible(false);
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showReport();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		reportButton.setBounds(202, 438, 198, 23);
		frame.getContentPane().add(reportButton);
		
		JButton passwordButton = new JButton("Войти");
		passwordButton.setBounds(247, 54, 128, 23);
		passwordPanel.add(passwordButton);
		passwordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordText.getText().equals(ADMIN_PASSWORD)) {
					passwordPanel.setVisible(false);
					reportButton.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Не верный пароль администратора", "Ошибка", JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		passwordButton.setBackground(Color.PINK);
		passwordButton.setForeground(Color.DARK_GRAY);
	}
	
	//Метод setArrayValues реализующий добавление значений из textField-ов в массив
	public void setArrayValues() {
		calcValues[0] = Integer.parseInt(widthText.getText());
		calcValues[1] = Integer.parseInt(heightText.getText());
		calcValues[2] = Integer.parseInt(colorText.getText());
		calcValues[3] = Integer.parseInt(fpsText.getText());
		calcValues[4] = Integer.parseInt(timeText.getText());
		calcValues[5] = Integer.parseInt(soundText.getText());
		calcValues[6] = Integer.parseInt(gzText.getText());
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
		if (	!isNumeric(widthText.getText())   ||
				!isNumeric(heightText.getText()) ||
				!isNumeric(colorText.getText()) ||
				!isNumeric(fpsText.getText()) ||
				!isNumeric(timeText.getText()) ||
				!isNumeric(soundText.getText()) ||
				!isNumeric(gzText.getText()) )
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
		if(		widthText.getText().trim().isEmpty()   ||
				heightText.getText().trim().isEmpty() ||
				colorText.getText().trim().isEmpty() ||
				fpsText.getText().trim().isEmpty() ||
				timeText.getText().trim().isEmpty() ||
				soundText.getText().trim().isEmpty() ||
				gzText.getText().trim().isEmpty() ||
				widthText.getText().trim().isEmpty()) 
		{
			return true;
		} else
			return false;
	}
	
	//Метод toValidate реализующий проверку значений на положительность
	public boolean toValidate(double textFieldValue) {
		boolean er;
		if (textFieldValue <= 0 || textFieldValue >= 1000000) 
			er= true;
		 else
			er = false;
		return er;
	}
	
	public void showReport() throws Exception {
		FileWriter nFile = new FileWriter("Отчет.txt");
        nFile.write("Ширина изображения: " + widthText.getText() + "\n" +
        			"Высота изображения: " + heightText.getText() + "\n" +
        			"Глубина цвета: " + colorText.getText() + "\n" +
        			"Количество кадров: " + fpsText.getText() + "\n" +
        			"Длительность видео: " + timeText.getText() + "\n" +
        			"Разрядность звука: " + soundText.getText() + "\n" +
        			"Частота дискретизации: " + gzText.getText() + "\n" +
        			"----------------------------------------------\n" +
        			"Результат " + resultText.getText() + "\n");
        nFile.close();
	}
}
