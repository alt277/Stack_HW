import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print(
                    "Enter string  ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры

            CheckBracket theChecker = new CheckBracket(input);
            theChecker.check(); // Проверка парных скобок
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}
