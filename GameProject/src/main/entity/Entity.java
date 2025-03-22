
public class Entity {
    private String name;
    private int level;
    private int health;
    private int mana;

    public Entity(String name, int level, int health, int mana) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {return name;}

    public int getLevel() {return level;}

    public int getHealth() {return health;}

    public int getMana() {return mana;}

    public void setName(String name) {this.name = name;}

    public void setLevel(int level) {this.level = level;}

    public void setHealth(int health) {this.health = health;}

    public void setMana(int mana) {this.mana = mana;}
}