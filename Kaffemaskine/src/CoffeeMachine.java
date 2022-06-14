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
}