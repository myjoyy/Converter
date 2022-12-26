public class Converter implements TextGraphicsConverter {
    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
    BufferedImage img = ImageIO . read (new URL (url));

    // Если конвертер попросили проверять на максимально допустимое
    // соотношение сторон изображения, то вам здесь надо сделать эту проверку,
    // и, если картинка не подходит, выбросить исключение BadImageSizeException.

    // Если конвертеру выставили максимально допустимые ширину и/или высоту,
    // вам надо по ним и по текущим высоте и ширине вычислить новые высоту
    // и ширину.
    // Соблюдение пропорций означает, что вы должны уменьшать ширину и высоту должны
    // в одинаковое количество раз.
    // Пример 1: макс. допустимые 100x100, а картинка 500x200. Новый размер
    // будет 100x40 (в 5 раз меньше).
    // Пример 2: макс. допустимые 100x30, а картинка 150x15. Новый размер
    // будет 100x10 (в 1.5 раза меньше).
    // Подумайте, какими действиями можно вычислить новые размеры.

    int newWidth = ???;
    int newHeight = ???;
    Image scaledImage = img . getScaledInstance (newWidth, newHeight, BufferedImage.SCALE_SMOOTH);

    // Теперь сделаем её чёрно-белой. Для этого поступим так:

    BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
    Graphics2D graphics = bwImg . createGraphics ();
    graphics.drawImage(scaledImage, 0, 0, null);


    // Теперь давайте пройдёмся по пикселям нашего изображения.
    // Если для рисования мы просили у картинки .createGraphics(),
    // то:
    WritableRaster bwRaster = bwImg . getRaster ();


    int color = bwRaster . getPixel (w, h, new int[3])[0];


    // Вам осталось пробежаться двойным циклом по всем столбцам (ширина)
    // и строкам (высота) изображения, на каждой внутренней итерации
    // получить степень белого пикселя (int color выше) и по ней
    // получить соответствующий символ c. 
    for ??? {
    for ??? {
    int color = bwRaster . getPixel (w, h, new int[3])[0];
    char c = schema . convert (color);
    return ??? //запоминаем символ c, например, в двумерном массиве или как-то ещё на ваше усмотрение
}
}



    return ???; // Возвращаем собранный текст.
}
}