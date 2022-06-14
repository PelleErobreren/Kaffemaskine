import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true)
        {
            System.out.print("Skriv handling (koeb, udfyld, tag, resterende, forlad): ");
            String command = scanner.next();
            System.out.println();

            switch (command)
            {
                case "koeb":
                    System.out.print("Hvad vil du koebe? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "tilbage - til hovedmenuen:");
                    String type = scanner.next();
                    boolean enough = CoffeeMachine.isEnough(type, water, milk, beans, cups);

                    switch (type)
                    {
                        case "1": // espresso
                            if (enough)
                            {
                                water -= 250;
                                beans -= 16;
                                cups -= 1;
                                money += 4;
                            }
                            break;
                        case "2": // latte
                            if (enough)
                            {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups -= 1;
                                money += 7;
                            }
                            break;
                        case "3": // cappuccino
                            if (enough)
                            {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups -= 1;
                                money += 6;
                            }
                            break;
                        case "tilbage":
                            break;
                        default:
                            System.out.println("Ukendt kaffetype");
                            break;
                    }
                    break;
                case "udfyld":
                    System.out.print("Skriv hvor mange ml vand du vil tilsaette: ");
                    water += scanner.nextInt();
                    System.out.print("Skriv hvor mange ml maelk du vil tilsaette: ");
                    milk += scanner.nextInt();
                    System.out.print("Skriv hvor mange gram kaffeboenner du vil tilfoeje: ");
                    beans += scanner.nextInt();
                    System.out.print("Skriv hvor mange engangskopper kaffe du vil tilfoeje: ");
                    cups += scanner.nextInt();
                    break;
                case "tag":
                    System.out.printf("Jeg gav dig kr %s\n", money);
                    money = 0;
                    break;
                case "resterende":
                    CoffeeMachine.print(water, milk, beans, cups, money);
                    break;
                case "forlad":
                    System.out.println("Tak for denne gang, paa gensyn!");
                    return;
                default:
                    System.out.println("Ukendt kommando");
                    break;
            }
            System.out.println();
        }
    }
}