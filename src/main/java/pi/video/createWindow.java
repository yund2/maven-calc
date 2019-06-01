package pi.video;
/*
 * Swing - Библиотека графического интерфейса (конкретный пакет), В отличие от java.awt, javax.swing имеет более гибкую
 * систему управления и более широкий набор функций
 */
 
/*Подключение необходимых библиотек
 * javax.swing.JFrame            - JFrame, представляющий собой окно с рамкой и строкой заголовка (с кнопками «Свернуть», «Во весь экран» и «Закрыть»).
 *                                 Оно может изменять размеры и перемещаться по экрану.
 * javax.swing.JTextField        - JTextField, представляющий собой однострочное поле для ввода текста.
 * javax.swing.JLabel            - JLabel, представляющий собой поле для отображения текста или иконки.
 * javax.swing.JOptionPane       - JOptionPane позволяющий вызывать однин из многочисленных статических методов, создающих и выводящих на экран модальное диалоговое окно стандартного вида.
 * javax.swing.JButton           - JButton Кнопка
 * java.awt.event.ActionEvent;
 * java.awt.event.ActionListener - Событие Event - это объект, описывающий изменение состояния источника, с которым оно связано.
 *                                 Примером события, в котором участвует пользователь, являются нажатие кнопки, выбор элемента из списка, ввод символа с клавиатуры и т.д.
 *                                 Слушатель Listener - это уведомляемый о некотором событии объект.
 * java.io.FileWriter            - используется для записи потоков символов.
 * java.awt.Color                - классе Color определяется несколько констант (вроде Color.black) для описания наиболее употребительных используемых цветов.
 * javax.swing.JPanel            - панель контейнер, которая может содержать другие элементы (кнопки, текстовые поля и т.д.)
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
 
//Объявление класса createWindow
public class createWindow {
 
    //Объявление переменных типа JFrame и JTextField
    private JFrame frame;
    private JTextField widthText;
    private JTextField heightText;
    private JTextField colorText;
    private JTextField fpsText;
    private JTextField timeText;
    private JTextField soundText;
    private JTextField gzText;
    private JTextField resultText;
    private JTextField passwordText;
    /* Объявление глобальных переменных класса
     * calcValues     - переменная содержащая валидные значения из всех текстовых полей окна калькулятора
     * error          - логическая переменная содержащая результат проверки введенных значений на валидность
     * ADMIN_PASSWORD - константа содержащая пароль администратора
     */
    public static double[] calcValues = new double[7];
    public static boolean error;
    public static final String ADMIN_PASSWORD = "admin";
 
    //Метод main который запускает работу программы
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            //Метод run включающий отображение главного фрейма
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
       
        /*
         * Создаем фрейм и устанавливаем значение заголовка
         * setTitle()                   - устанавливает текстовое значение заголовка окна
         * setBounds()                  - устанавливает положение окна и его размеры
         * setDefaultCloseOperation()   - позволяет указать действие, которое необходимо выполнить, когда пользователь закрывает окно нажатием на крестик.
         * getContentPane()             - обращение к области контента. setLayout() - установка лейаута
         */
        frame = new JFrame();
        frame.setTitle("ПИ 217");
        frame.setBounds(100, 100, 462, 541);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
       
       
        /*
         * Создаем textField-ы и устанавливаем значения по умолчанию
         * setText()                - запись значения в элемент
         * setBounds()              - устанавливает положение элемента и его размеры
         * getContentPane().add()   - добавление элемента в окно программы
         * setColumns()             - изменение длинны строки
         */
        widthText = new JTextField();
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
 
       
       
