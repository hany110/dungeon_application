package dungeon;

public class MedievalLevelBuilder {

  private final Level level;
  private int nlvl;
  private int nroom;
  private int nom;
  private int noT;
  private int ncR;


  public MedievalLevelBuilder(int nlvl,int rmno_actual, int nom, int noT)
  {
    if(rmno_actual<0 || nom <0 || noT <0)
    {
      throw new IllegalArgumentException("incorrect args");
    }
    this.nlvl = nlvl;
    this.nroom = rmno_actual;
    this.nom = nom;
    this.noT = noT;

    level = new Level(nlvl);
    this.ncR = 0;
  }

  public MedievalLevelBuilder addRoom(String roomDescription)
  {
    if(nroom ==0)
    {
      throw new IllegalStateException("No rooms");
    }
    level.addRoom(roomDescription);
    nroom -= 1;
    ncR += 1;
    return this;

  }

  public MedievalLevelBuilder addGoblins(int room, int numberOfGoblins)
  {
    if(this.nom ==0)
    {
      throw new IllegalStateException("Max level reached");
    } else if (ncR ==0) {
      throw new IllegalArgumentException("No Room");
    } else {
      Monster goblin = new Monster("goblin","mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
          7);
      for(int i=0; i<numberOfGoblins; i++)
      {
        level.addMonster(room,goblin);
        nom -= 1;
      }
      return this;
    }
  }

  public MedievalLevelBuilder addOrc(int room)
  {
    if(this.nom ==0)
    {
      throw new IllegalStateException("Max level reached");
    }
    else if (ncR ==0) {
      throw new IllegalArgumentException("No Room");

    }
    else {
      Monster orc = new Monster("orc","brutish, aggressive, malevolent being serving evil",20);

      level.addMonster(room,orc);
      nom -= 1;

      return this;

    }
  }

  public MedievalLevelBuilder addOgre(int room)
  {
    if(this.nom ==0)
    {
      throw new IllegalStateException("Max level reached");
    }
    else if (ncR ==0) {
      throw new IllegalArgumentException("No Room");

    }
    else {
      Monster ogre = new Monster("ogre","large, hideous man-like being that likes to eat humans for lunch", 50);

      level.addMonster(room,ogre);
      nom -= 1;

      return this;

    }

  }

  public MedievalLevelBuilder addHuman(int room,String name, String description, int hitPoints)
  {
    if(this.nom ==0)
    {
      throw new IllegalStateException("Max level reached");
    }
    else if (ncR ==0) {
      throw new IllegalArgumentException("No Room");

    }
    else {
      Monster human = new Monster(name,description,hitPoints);
      level.addMonster(room,human);
      nom -= 1;
      return this;
    }
  }

  public MedievalLevelBuilder addPotion(int room)
  {
    Treasure potion = new Treasure("a healing potion", 1);
    level.addTreasure(room, potion);
    noT -= 1;
    return this;
  }



  public MedievalLevelBuilder addGold(int room, int goldValue)
  {
    Treasure gold = new Treasure("pieces of gold", goldValue);
    level.addTreasure(room, gold);
    noT -= 1;

    return this;
  }




  public MedievalLevelBuilder addWeapon(int room, String weaponName)
  {
    Treasure weapon = new Treasure(weaponName, 10);
    level.addTreasure(room, weapon);
    noT -= 1;
    return this;
  }




  public MedievalLevelBuilder addSpecial(int room, String desc, int value)
  {
    Treasure special = new Treasure(desc, value);
    level.addTreasure(room, special);
    noT -= 1;
    return this;
  }


  public Level build() {
    if (nroom > 0 || nom > 0 || noT > 0) {
      throw new IllegalStateException("Level Creation incomplete");
    }
    return level;
  }
}

