import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class homeWork3
{
    private static Random random = new Random();

    public static void main (String[] args) {
        System.out.println("Task 1.");
        guessTheNumber();
        System.out.println("\nTask 2.\n");
        guessTheWord();
    }
    public static void guessTheNumber()
/*Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное
, или меньше.
После победы или проигрыша выводится запрос –
«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/
    {
        int unknownNumber, incomingNumber = 0;

        int maxCount = 3;

        int count = 0;

        Scanner input = new Scanner(System.in);

        unknownNumber = (int) (Math.random() * 9);

        System.out.println("Угадайте  число от 0 до 9. У вас 3 попытки ");

        while (true)

        {
            System.out.println("Введите число");
            incomingNumber = input.nextInt();

            count++;

            if (incomingNumber == unknownNumber)
            {
                System.out.println("Вы угадали!");
                break;
            }

            else if (maxCount <= count)
            {
                System.out.println("Вы проиграли");
                break;
            }

            else if (incomingNumber > unknownNumber)

            {
            System.out.println("Загаданное число меньше");
            }

             else
                System.out.println("Загаданное число больше");

        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
        incomingNumber = input.nextInt();
        if (incomingNumber == 1) guessTheNumber();
        else {
            System.out.println("Всего доброго!");
        }
    }


/* Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
"broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
"nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
apple – загаданное
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */
    public static void guessTheWord ()
    {
        String [] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println(Arrays.toString(words));
        System.out.println("\nЗагадано слово, попробуйте отгадать\n");

        int incomingWord = random.nextInt(words.length -1);

        Scanner scanner = new Scanner(System.in);

        String word = words[incomingWord];

        int lengthWord = word.length();

        System.out.println(word);

        do {
            System.out.println("\nВведите ответ");
            String answer = scanner.nextLine();

            if (word.equals(answer))
            {
                System.out.println("Вы угадали!");
                break;
            }

            char[] charAnswer = answer.toCharArray();

            for (int i = 0; i < charAnswer.length; i++)
            {
                if (i >= word.length())
                    charAnswer[i] = '#';
                else if (word.charAt(i) != charAnswer[i]) charAnswer[i] = '#';
            }

            StringBuilder comment = new StringBuilder(String.valueOf(charAnswer));

            if (charAnswer.length < 15)
            {
                for (int i = 0; i < (15 - charAnswer.length); i++) comment.append("#");
            }
            else if (charAnswer.length > 15)
            {
                comment.delete(15, charAnswer.length);
            }

            System.out.println(comment);
        }
        while (true);
    }
}