


public class Entity {
    private String Name;
    private boolean Is_it_pnj, Is_it_player,Is_it_monster,Is_it_object;
    private int Health;
    private int Attack;
    private int Defense;
    private int Speed;
    private int Level;
    private int Experience;
    private int Experience_to_next_level;
    private int Gold;
    private int x;
    private int Y;
    private int Id;
    private int Mana;
    private static final int DEFAULT_HEALTH = 100;
    private static final int DEFAULT_ATTACK = 10;
    private static final int DEFAULT_DEFENSE = 10;
    private static final int DEFAULT_SPEED = 10;    
    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_EXPERIENCE = 0;
    private static final int DEFAULT_EXPERIENCE_TO_NEXT_LEVEL = 100;
    private static final int DEFAULT_GOLD = 0;
    private static final int DEFAULT_X = 0;
    private static final int DEFAULT_Y = 0;
    private static final int DEFAULT_MAX_HEALTH = 100;
    private static final int MAX_SPEED = 100;
    private static final int MAX_ATTACK = 100;
    private static final int MAX_DEFENSE = 100;
    
    
    public Entity(String Name, boolean Is_it_pnj, boolean Is_it_player, boolean Is_it_monster, boolean Is_it_object, int Health, int Attack, int Defense, int Speed, int Level, int Experience, int Experience_to_next_level, int Gold, int x, int Y, int Id, int Mana) {
        this.Name = Name;
        this.Is_it_pnj = Is_it_pnj;
        this.Is_it_player = Is_it_player;
        this.Is_it_monster = Is_it_monster;
        this.Is_it_object = Is_it_object;
        this.Health = Health;
        this.Attack = Attack;
        this.Defense = Defense;
        this.Speed = Speed;
        this.Level = Level;
        this.Experience = Experience;
        this.Experience_to_next_level = Experience_to_next_level;
        this.Gold = Gold;
        this.x = x;
        this.Y = Y;
        this.Id = Id;
        this.Mana = Mana;
    }
    public void ToString() {
        System.out.println("Name: " + Name);
        System.out.println("Is it pnj: " + Is_it_pnj);
        System.out.println("Is it player: " + Is_it_player);
        System.out.println("Is it monster: " + Is_it_monster);
        System.out.println("Is it object: " + Is_it_object);
        System.out.println("Health: " + Health);
        System.out.println("Attack: " + Attack);
        System.out.println("Defense: " + Defense);
        System.out.println("Speed: " + Speed);
        System.out.println("Level: " + Level);
        System.out.println("Experience: " + Experience);
        System.out.println("Experience to next level: " + Experience_to_next_level);
        System.out.println("Gold: " + Gold);
        System.out.println("x: " + x);
        System.out.println("Y: " + Y);
        System.out.println("Id: " + Id);
        System.out.println("Mana: " + Mana);
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
    public void setIs_it_pnj(boolean Is_it_pnj) {
        this.Is_it_pnj = Is_it_pnj;
    }
    public boolean getIs_it_pnj() {
        return Is_it_pnj;
    }
    public void setIs_it_player(boolean Is_it_player) {
        this.Is_it_player = Is_it_player;
    }
    public boolean getIs_it_player() {
        return Is_it_player;
    }

    public void setIs_it_monster(boolean Is_it_monster) {
        this.Is_it_monster = Is_it_monster;
    }
    public boolean getIs_it_monster() {
        return Is_it_monster;
    }
    public void setIs_it_object(boolean Is_it_object) {
        this.Is_it_object = Is_it_object;
    }
    public boolean getIs_it_object() {
        return Is_it_object;
    }
    public void setHealth(int Health) {
        this.Health = Health;
    }
    public int getHealth() {
        return Health;
    }
    public void setAttack(int Attack) {
        this.Attack = Attack;
    }
    public int getAttack() {
        return Attack;
    }
    public void setDefense(int Defense) {
        this.Defense = Defense;
    }
    public int getDefense() {
        return Defense;
    }
    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
    public int getSpeed() {
        return Speed;
    }
    public void setLevel(int Level) {
        this.Level = Level;
    }
    public int getLevel() {
        return Level;
    }
    public void setExperience(int Experience) {
        this.Experience = Experience;
    }
    public int getExperience() {
        return Experience;
    }
    public void setExperience_to_next_level(int Experience_to_next_level) {
        this.Experience_to_next_level = Experience_to_next_level;
    }
    public int getExperience_to_next_level() {
        return Experience_to_next_level;
    }
    public void setGold(int Gold) {
        this.Gold = Gold;
    }
    public int getGold() {
        return Gold;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int Y) {
        this.Y = Y;
    }
    public int getY() {
        return Y;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getId() {
        return Id;
    }
    public void setMana(int Mana) {
        this.Mana = Mana;
    }
    public int getMana() {
        return Mana;
    }
    public boolean isAlive() {
        if (Health > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void attack(Entity entity,Entity entity2) {
        if(entity.isAlive() && entity2.isAlive() && !entity.Is_it_pnj){
            entity.setHealth(entity.getHealth() - entity2.getAttack());
            System.out.println("You attacked " + entity.getName() + " and dealt " + entity2.getAttack() + " damage  by the entity :"+entity2.getName());

        }
        else{
            System.out.println("You can't attack a dead entity");
        }
        
    }

    public void heal(int heal) {
        if(this.Health>0){
            if(this.Health<DEFAULT_MAX_HEALTH){
                if(this.Health+heal>DEFAULT_MAX_HEALTH){
                    this.Health=DEFAULT_MAX_HEALTH;
                }
                else{
                    this.Health+=heal;
                }

            }

        }
        
    }
    public void gainExperience(int experience) {
        if(this.Experience+experience>=this.Experience_to_next_level){
            this.Level++;
            this.Experience=this.Experience+experience-this.Experience_to_next_level;
            this.Experience_to_next_level+=100;
        }
        else{
            this.Experience+=experience;
        }
    }

    public void gainGold(int gold) {
        Gold += gold;
    }
    public void loseGold(int gold) {
        Gold -= gold;
    }
    public void move(int x, int y) {
        this.x = x;
        this.Y = y;
    }
    public void useMana(int mana) {
        Mana -= mana;
    }
    public void gainMana(int mana) {
        Mana += mana;
    }
    public void loseMana(int mana) {
        Mana -= mana;
    }
    public void gainSpeed(int speed) {
        if(this.Speed+speed<MAX_SPEED){
            this.Speed+=speed;
        }
        else{
            this.Speed=MAX_SPEED;
        }

    }
    public void loseSpeed(int speed) {
        if(this.Speed-speed>0){
            this.Speed-=speed;
        }
        else{
            this.Speed=0;
        }
    }
    public void gainAttack(int attack) {
        if(this.Attack+attack>+MAX_ATTACK){
            this.Attack=MAX_ATTACK;
        }
        else{
            this.Attack+=attack;
        }
    }
    public void loseAttack(int attack) {
        if(this.Attack-attack>0){
            this.Attack-=attack;
        }
        else{
            this.Attack=0;
        }
    }
    public void gainDefense(int Defense) {
        if(this.Defense+Defense>+MAX_DEFENSE){
            this.Defense=MAX_DEFENSE;
        }
        else{
            this.Defense+=Defense;
        }
    }
    public void loseDefense(int Defense) {
        if(this.Defense-Defense>0){
            this.Defense-=Defense;
        }
        else{
            this.Defense=0;
        }
    }





}