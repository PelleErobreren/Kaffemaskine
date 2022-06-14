import java.util.Scanner;

public class CoffeeMachine
{
    public static void print(int water, int milk, int beans, int cups, int money)
    {
        System.out.println("Kaffemaskinen har:");
        System.out.println(water + " ml vand");
        System.out.println(milk + " ml maelk");
        System.out.println(beans + " g kaffeboenner");
        System.out.println(cups + " engangskopper");
        System.out.println(money + " kroner");
    }

    public static boolean isEnough(String type, int water, int milk, int beans, int cups)
    {
        boolean enough = false;

        int waterLimit;
        int milkLimit;
        int beansLimit;

        switch (type)
        {
            case "1": // espresso
                waterLimit = 250;
                milkLimit = 0;
                beansLimit = 16;
                break;
            case "2": // latte
                waterLimit = 350;
                milkLimit = 75;
                beansLimit = 20;
                break;
            case "3": // cappuccino
                waterLimit = 200;
                milkLimit = 100;
                beansLimit = 12;
                break;
            default:
                return false;
        }
        if (water < waterLimit)
        {
            System.out.println("Beklager, ikke nok vand!");
        }
        else if (milk < milkLimit)
        {
            System.out.println("Beklager, ikke nok maelk!");
        }
        else if (beans < beansLimit)
        {
            System.out.println("Beklager, ikke nok kaffeboenner!");
        }
        else if (cups < 1)
        {
            System.out.println("Beklager, ikke nok engangskopper!");
        }
        else
        {
            enough = true;
            System.out.println("Jeg har ressourcer nok til at lave en kop kaffe til dig!");
        }
        return enough;
    }

    public static void start()
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