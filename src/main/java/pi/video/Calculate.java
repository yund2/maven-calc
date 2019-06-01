package pi.video;
//Объявляем класс Calculate
public class Calculate {
	//Объявляем переменную result типа double
	public static double result;
	//Объявляем метод toCalculate() типа double
	public static double toCalculate(double[] arrayOfValues) {
	    //Задаем начальное значение переменной result
	    result = 1;
	    
		//Объявляем переменные videoVol audioVol типа double
	    double videoVol;
	    double audioVol;
	    
	    //Рассчитываем аудио и видео объем данных и переводим полученное значение в мегабайты
	    audioVol = arrayOfValues[4] * arrayOfValues[5] * arrayOfValues[6] / (8.0 * 1024.0 * 1024.0);
		videoVol = arrayOfValues[0] * arrayOfValues[1] * arrayOfValues[2] / (8.0 * 1024.0 * 1024.0);
		//Умножаем аудио и видео объем на кол-во кадров/сек
		result = audioVol * videoVol * arrayOfValues[3];
		//Возвращаем результат вычислений
		return result;
	}
	//Объявляем метод toFormateResult типа String
	public static String toFormateResult() {
		//Создаем экземпляр window класса createWindow
	    createWindow window = new createWindow();
	    //Объявляем массив arrayOfValues типа double c 7 ячейками
	    double[] arrayOfValues = new double[7];
	    arrayOfValues = window.getArrayOfValues();
		//Объявляем переменную value типа double и заносим в нее данные полученные из метода toCalculate
		double value = toCalculate(arrayOfValues);
		//Объявляем переменную formatedValue типа double
		String formatedValue;
		//Выполняем проверку данных для форматирования
		if (value > 500.0) {
			formatedValue = Double.toString(value / 1024.0) ;
			//Используем метод removeSymbols для удаления лишних знаков после запятой
			formatedValue = removeSymbols(formatedValue) + " гб";
		}
		else {
			formatedValue = Double.toString(value);
			//Используем метод removeSymbols для удаления лишних знаков после запятой
			formatedValue = removeSymbols(formatedValue) + " мб";
		}
		//Возвращаем отформатированный результат
		return formatedValue;
		
	}
	//Объявляем метод removeSymbols типа String, принимающий на вход переменную типа String
	public static String removeSymbols(String s) {
		//Объявляем переменную end типа int и записываем в нее позицию точки в числе
		int end = s.indexOf(".");
		//Выбираем из исходной строки подстроку начиная с 0 позиции и заканчивая end+2
		s = s.substring(0, end+2);
		//Возвращаем полученную строку
		return s;
	}
	
}
