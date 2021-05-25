
package game;

import java.util.*;
import fixtures.*;
import globals.Direction;

public class Game {

    private ArrayList <Room>map;    
    private Player player;  

    List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look",
            "n", "s", "w", "e"));
    List<String> objects = new ArrayList<>(Arrays.asList("sword", "ring", "snake"));

    public Game() {
        this.map = new ArrayList<Room>();
        //      Room( name,   shortDescription, longDescription    N,   S,   W,  E )
        map.add(new Room("Foyer", "A homely looking foyer with few furnishing",
        		"Not much here to see, only a humble entryway to an enormous mansion",
        		3, -1, 1, -1));
        
		map.add(new Room("Living Room", "This large, rectangular living room has mismatched wooden, metal, and plastic furniture.",
				"The seating is cushionless.  The floor is carpeted and the walls are painted with a paneled dado.  Light is provided by floor lamps and a ceiling light.  The room is done in warm bright colors and overall has a retro look to it.  Among the first things one notices walking in are a tacky sculpture and a large TV set.",
				4, -1, -1, 0));
		
		map.add(new Room("Tomb", "This room resembles a royal mortuary",
				"Stone sarcophagi stand in five rows of three, each carved with the visage of a warrior lying in state. In their center, one sarcophagus stands taller than the rest. Held up by six squat pillars, its stone bears the carving of a beautiful woman who seems more asleep than dead. The carving of the warriors is skillful but seems perfunctory compared to the love a sculptor must have lavished upon the lifelike carving of the woman.",
				-1, -1, 0, 7));
		
		map.add(new Room("Kitchen", "This spacious, rectangular kitchen has stone counters and a sink with metal fixtures.",
				"The floor is linoleum and the walls are papered.  Light is provided by wall lamps.  The room is done in colors that remind you of an old book and overall looks like an old castle.  Among the first things one notices walking in are a crack in the wall and a full cookie jar.",
				8, 0, 4, 5));
		
		map.add(new Room("Bedroom", "This small, L-shaped bedroom has coordinating wooden furniture",
				"The floor is poured and the walls are painted with a paneled dado.  Light is provided by ceiling lights.  The room is done in a forest theme in bold colors and overall looks a bit old-fashioned.",
				-1, 1, -1, 3));
		
		map.add(new Room("Dining Room", "This cramped, rectangular dining room has matching ash wood furniture.",
				"The dining seating is cushionless and the living seating is cushionless.  The floor is wood and the walls are painted.  Light is provided by ceiling lights.  The room is done in a nature theme in bold colors and overall has a quaint atmosphere.  Among the first things one notices walking in is a barn star on the wall.",
				-1, -1, 3, 6));
		
		map.add(new Room("Bathroom", "This average-sized, rectangular bathroom has a shower and sink with porcelain fixtures.",
				"The sink is set into a stone counter.  The floor is stone and the walls are papered.  Light is provided by wall lamps.  The room is done in a floral theme in soft colors and overall has a cluttered look.  Among the first things one notices walking in are a magazine and a character toothbrush.",
				-1, 7, 5, -1));
		
		map.add(new Room("Treasure Room", "This room holds nothing but a chest",
				"This small bare chamber holds nothing but a large ironbound chest, which is big enough for a man to fit in and bears a heavy iron lock. The floor has a layer of undisturbed dust upon it.",
				6, -1, 2, -1));
		
		map.add(new Room("Study", "This small, rectangular office has matching dark wooden furniture.",
				"The floor is carpeted and the walls are papered.  Light is provided by wall lamps.  The room is done in light colors and overall has a cluttered look.  Among the first things one notices walking in is art supplies on the desk.",
				-1, 3, -1, -1));
        
        player = new Player("player", map.get(0));
    }

    // access methods
    // map
    ArrayList getMap() {
        return map;
    }

    void setMap(ArrayList aMap) {
        map = aMap;
    }

    // player
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player aPlayer) {
        player = aPlayer;
    }

    void moveActorTo(Player p, Room aRoom) {
        p.setRoom(aRoom);
    }

    int moveTo(Player aPlayer, Direction dir) {

        Room r = aPlayer.getRoom();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            default:
                exit = -1;
                break;
        }
        if (exit != -1) {
            moveActorTo(aPlayer, map.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir) {       
        return moveTo(player, dir);
    }

    private void goN() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    private void goS() {
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    private void goW() {
        updateOutput(movePlayerTo(Direction.WEST));
    }

    private void goE() {
        updateOutput(movePlayerTo(Direction.EAST));
    }

    void updateOutput(int roomNumber) {
        // if roomNumber = NOEXIT, display a special message, otherwise
        // display text (e.g. name and description of room)        
        String s;
        if (roomNumber == -1) {
            s = "You can't leave the current room from this direction";
        } else {
            Room r = getPlayer().getRoom();
            s = "You are in "
                    + r.getName() + ". " + r.getShortDescription() + ". " + r.getLongDescription();
        }
        System.out.println(s);
    }

    public String ProcessVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    public String ProcessVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        if (!objects.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        msg += " (not yet implemented)";
        return msg;
    }

    public String ParseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = ProcessVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = ProcessVerbNoun(wordlist);
        } else {
            msg = "Only 2 word commands allowed!";
        }
        return msg;
    }

    public List<String> WordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public void showIntro(){
        String s;
        s = "You have opened the door to the Ecelbarger mansion.\n"+
                "You find yourself in a homely foyer.\n" +
                "Where do you want to go? [Enter n, s, w or e]?\n" +
                "(or enter q to quit)";
        System.out.println(s);
    }
    
    public String RunCommand(String inputstr) {
        List<String> wordlist;
        String s = "Thank you for visiting the Ecelbarger Mansion!";
        String lowstr = inputstr.trim().toLowerCase();        
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a valid command";
            } else {
                wordlist = WordList(lowstr);                
                s = ParseCommand(wordlist);
            }
        }
        return s;
    }

}
