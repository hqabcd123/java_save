import java.io.*;
import java.util.Random;

public class nero_god {
    public static void main(String[] args) throws IOException {
        String input = "";
        boolean state = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (state) {
            System.out.println("please input");
            input = br.readLine();
            byte[] sbyte = input.getBytes();

            for(int i=0; i<sbyte.length; i++)
            {
                System.out.println(sbyte[i]);
            }
            try {
                switch (input) {
                    case ("paper"): {
                        game(input, RockPaperScissorsGenaretor());
                        break;
                    }
                    case ("scissors"): {
                        game(input, RockPaperScissorsGenaretor());
                        break;
                    }
                    case ("rock"): {
                        game(input, RockPaperScissorsGenaretor());
                        break;
                    }
                    case ("stop"):
                    {
                        state = false;
                        break;
                    }
                    default:
                    {
                        System.out.println("error");
                        break;
                    }
                }
            }catch (NumberFormatException ne)
            {
                System.out.println("Error code is " + ne);
            }
        }
    }

    private static String RockPaperScissorsGenaretor()
    {
        final String[] string =
                {
                        "scissors",
                        "rock",
                        "paper",
                };
        String hand = "";
        int index = string.length;
        Random random = new Random();
        return string[random.nextInt(index)];
    }
    private static void game(String GamerHand,String ComputerHand)
    {
        final String[] string =
                {
                        "scissors",
                        "paper",
                        "rock",
                };
        int temp1 = 0, temp2 = 0;

        System.out.println("Player2 is " + ComputerHand);
        if (GamerHand.equalsIgnoreCase(ComputerHand))
        {
            System.out.println("Draw");
        }
        else
        {
            for (int i = 0; i < string.length; i++)
            {
                if (GamerHand.equalsIgnoreCase(string[i]))
                {
                    temp1 = i;
                }
                if (ComputerHand.equalsIgnoreCase(string[i]))
                {
                    temp2 = i;
                }
            }

            if (temp1 == 1)
            {
                if (temp1 > temp2)
                {
                    System.out.println("you lose");
                }
                else
                {
                    System.out.println("Player lose");
                }
            }

            else if (temp2 == 1)
            {
                if (temp1 < temp2)
                {
                    System.out.println("Player lose");
                }
                else
                {
                    System.out.println("you lose");
                }
            }

            else
            {
                if (temp1 < temp2)
                {
                    System.out.println("you lose");
                }
                else
                {
                    System.out.println("Player lose");
                }
            }
        }
    }
}
