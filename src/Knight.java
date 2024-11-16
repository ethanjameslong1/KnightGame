import java.util.Random;

public class Knight {
    protected String name, armour, weapon;
    protected int health;

    public Knight() {
        Random rand = new Random();

        int x = rand.nextInt(4)+1;
        switch (x) {
            case 1:  this.weapon = "Long Sword";
            this.name = "Ethan the Deadly";
                this.health = rand.nextInt(20)+20;
                this.armour = "Chainmail";

                break;
            case 2: this.weapon = "Enchanted Sword";
            this.name = "Eden the Wood Elf";
                this.health = rand.nextInt(15)+15;
                this.armour = "Wind Cloak";

                break;
            case 3: this.weapon = "Staff";
            this.name = "Leon the Wicked";
                this.health = rand.nextInt(15)+20;
                this.armour = "Robes";

                break;
            case 4: this.weapon = "Warhammer";
            this.name = "Bruce the Mighty";
                this.health = rand.nextInt(10)+30;
                this.armour = "Steel Plates";

                break;
        }

    }
    public Knight(String Character)
    {
        Random rand = new Random();
        this.name = Character;
        switch (Character) {
            case "Ethan the Deadly":
                this.weapon = "Long Sword";
                this.health = rand.nextInt(20)+20;
                this.armour = "Chainmail";
                break;
            case "Eden the Wood Elf":
                this.health = rand.nextInt(15)+15;
                this.armour = "Wind Cloak";
                this.weapon = "Enchanted Sword";
                break;
            case "Leon the Wicked Mage":
                this.health = rand.nextInt(15)+20;
                this.armour = "Robes";
                this.weapon = "Staff";
                break;
            case "Bruce the Mighty":
                this.health = rand.nextInt(10)+30;
                this.armour = "Steel Plates";
                this.weapon = "Warhammer";
                break;
            default:
                this.health = rand.nextInt(20)+10;
                this.armour = "Leather";
                break;
        }

    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public String getWeapon() { return weapon; }
    public String getArmour() { return armour; }

    @Override
    public String toString()
    {
        String output;
        output = "Name: "+name+" Health: "+health+" Armour: "+armour+" Weapon: "+weapon;
        return output;
    }
    private int DamageTakenFrom(Knight vil) {
        Random rand = new Random(); //used in case the wind
        int dice = rand.nextInt(6)+1; //cloak allows an elf to dodge
        switch (vil.weapon) {
            case "Long Sword": switch (this.armour) {
                case "Chainmail": return 5;
                case "Steel Plates": return 3;
                case "Robe Armour": return 7;
                case "Wind Cloak": if(dice == 6) return 0; else return 9;
                case "Leather": return 9;
            }//perhaps
            case "Enchanted Sword": switch (this.armour) {
                case "Chainmail": return 6;
                case "Steel Plates": return 7;
                case "Robe Armour": return 3;
                case "Wind Cloak": if(dice == 6) return 0; else return 6;
                case "Leather": return 9;
            }
            case "Staff": switch (this.armour) {
                case "Chainmail": return 8;
                case "Steel Plates": return 7;
                case "Robe Armour": return 3;
                case "Wind Cloak": if(dice == 6) return 0; else return 8;
                case "Leather": return 9;
            }
            case "Warhammer": switch (this.armour) {
                case "Chainmail": return 4;
                case "Steel Plates": return 3;
                case "Robe Armour": return 8;
                case "Wind Cloak": if(dice == 6|| dice == 5) return 0; else return 11;
                case "Leather": return 9;
            }

        }
        return 4;
    }
    public void KnightFight(Knight vil) {
        Random rand = new Random();
        boolean coin = rand.nextBoolean();

        if (coin) { vil.health -= DamageTakenFrom(this); }

        while (vil.health > 0 && this.health > 0) {
            this.health -= DamageTakenFrom(vil);
            vil.health -= DamageTakenFrom(this);
        }
        if (this.health > 0) {
            System.out.printf("%s%d%s%n","Congrats! You're still alive and on ",this.health," health.");
        }
        if (vil.health > 0) {
            System.out.printf("%s%d%s%n","Oh No! You're dead, villain has ",vil.health," health remaining.");
        }
        if (vil.health < 0 && this.health < 0) {
            System.out.printf("%s%n","In the last attack both you and your villain perished, truly a tragedy!");
        }
    }
    int damageTakenFromEnemy(Enemy vil) {
    Random rand = new Random();
    int dice = rand.nextInt(6)+1;
        switch (vil.weapon)
        {
            case 'c': switch (this.armour) {
                case "Chainmail": return 5;
                case "Steel Plates": return 4;
                case "Robe Armour": return 7;
                case "Wind Cloak": if(dice == 1 || dice == 2) return 0; else return 12;
            }
            case 's': switch (this.armour) {
                case "Chainmail": return 3;
                case "Steel Plates": return 4;
                case "Robe Armour": return 7;
                case "Wind Cloak": if(dice == 1) return 0; else return 9;
            }
            case 'w': switch (this.armour) {
                case "Chainmail": return 8;
                case "Steel Plates": return 8;
                case "Robe Armour": return 3;
                case "Wind Cloak": if(dice == 1) return 0; else return 6;
            }
        }
        return 4;
    }

    public void EnemyFight(Enemy vil) throws InvalidDamageException {
        Random rand = new Random();
        boolean coin = rand.nextBoolean();
        System.out.printf("You begin your fight with: %n%s%n",vil.toString());

        if (coin) { vil.takeDamage(vil.DamageFromKnight(this)); }
        while (vil.health > 0 && this.health > 0) {
            this.health -= this.damageTakenFromEnemy(vil);
            vil.takeDamage(vil.DamageFromKnight(this)); //I had to implement the exception for the assignment
        }
        if (this.health > 0) {
            System.out.printf("%s%d%s%n","Congrats! You're still alive and on ",this.health," health.");
        }
        if (vil.health > 0) {
            System.out.printf("%s%s%s%d%s%n","Oh No! You're dead, ",vil.name," has ",vil.health," health remaining.");
        }
        if (vil.health < 0 && this.health < 0) {
            System.out.printf("%s%s%s%n","In the last attack both you and your foe, the ",vil.name,", perished. Truly a tragedy!");
        }
    }
    public void Heal(){
        health += 15;
    }
}