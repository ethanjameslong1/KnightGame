import java.util.Random;


public abstract class Enemy {
    protected int health;
    protected char armour, weapon;
    public String name;

    public int getHealth() {
        return health;
    }
    public char getArmour() {
        return armour;
    }
    public char getWeapon() {
        return weapon;
    }
    public String getName() {
        return name;
    }

    public void takeDamage(int damage) throws InvalidDamageException {
        if (damage < 0) {
            throw new InvalidDamageException("Damage cannot be negative!");
        }
        health -= damage;
    }

    public static Enemy getRandomEnemy(int level) {
        Random ran = new Random();
        int index = ran.nextInt(3);
        switch (index) {
            case 0:
                return new EnemyOgre(level);
            case 1:
                return new EnemySorcerer(level);
            case 2:
                return new EnemyUndeadKnight(level);
        }
        return null;
    }

    public int DamageFromKnight(Knight knight) {
        switch (knight.weapon) {
            case "Long Sword":
                switch (this.armour) {
                    case 'l':
                        return 10;
                    case 'c':
                        return 5;
                    case 'r':
                        return 8;
                    default:
                        return 0;
                }
            case "Staff":
                switch (this.armour) {
                    case 'l':
                        return 9;
                    case 'c':
                        return 8;
                    case 'r':
                        return 3;
                    default:
                        return 0;
                }

            case "Enchanted Sword":
                switch (this.armour) {
                    case 'l':
                        return 9;
                    case 'c':
                        return 7;
                    case 'r':
                        return 4;
                    default:
                        return 0;
                }

            case "Warhammer":
                switch (this.armour) {
                    case 'l':
                        return 12;
                    case 'c':
                        return 10;
                    case 'r':
                        return 8;
                    default:
                        return 0;
                }

        }
        return 4;
    }

    @Override
    public String toString()
    {
        String output;
        output = "Name of Enemy: "+name+" it has "+health+" total health";
        return output;
    }

}
