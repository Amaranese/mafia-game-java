import java.util.*;
import java.util.Map.*;
abstract class Players<T>{
    protected int hp;
    protected ArrayList<T> people;
    protected abstract String print_name();
    public int getHp() {
        return hp;
    }
}
class Mafia extends Player{
    Mafia(){
        setHp(2500);people=new ArrayList<Mafia>(); }

    @Override
    public String print_name() {
        return "Mafia";
    }
    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(! (o instanceof Mafia)){
            return false;
        }
        return Double.compare(hp,this.hp)==0;
    }

}
class Detective extends Player{
    Detective(){
        setHp(800);people=new ArrayList<Detective>();
    }

    @Override
    public String print_name() {
       return "Detective";
    }
    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(! (o instanceof Detective)){
            return false;
        }
        return Double.compare(hp,this.hp)==0;
    }
}
class Healer extends Player{
    Healer(){
        setHp(800);people=new ArrayList<Healer>();
    }
    @Override
    public String print_name() {
        return "Healer";
    }
    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(! (o instanceof Healer)){
            return false;
        }
        return Double.compare(hp,this.hp)==0;
    }
}
class  Player extends Players{
    Player(){
        super();
    }
    public void setHp(int x){
        if(x>=0){
            this.hp=x;} }
    @Override
    protected String print_name() {
        return "";
    }
}
class Commoner extends Player{
    Commoner(){
        setHp(1000);people=new ArrayList<Commoner>();
    }
    @Override
    public String print_name() {
        return "Commoner";
    }
    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(! (o instanceof Commoner)){
            return false;
        }
        return Double.compare(hp,this.hp)==0;
    }
}
public class Party_game {
    public static void main(String[] args){
        System.out.println("Welcome to Mafia");
        System.out.print("Enter number of players: ");
        System.out.println();
        Scanner s=new Scanner(System.in);
        boolean x=false;
        int n=0;
        int y=0;
        while(!x) {
            try {
                if (y > 0) {
                    System.err.println("Input Mismatch Exception : Number of players has to be an integer greater than 6.");
                    System.out.println("Enter a valid number:");
                }
                y++;
                n = s.nextInt();
                if (n >= 6) {
                    x = true;
                }
            } catch (InputMismatchException e) {
                s.next();
            }
        }
        int number_mafias=n/5;
        int count_mafias=0;
        int number_detectives=n/5;
        int count_detectives=0;
        int number_healers=Math.max(1,n/10);
        int count_round=1;
        int count_healers=0;
        int number_commoners=n-number_mafias-number_detectives-number_healers;
        int count_commoners=0;
        ArrayList<String> list1=new ArrayList<>();
        for (int i=0;i<n;i++){
            String c="Player";
            list1.add(c+(i+1)); }
        ArrayList<String> assigned=new ArrayList<>();
        ArrayList<String> all_mafias=new ArrayList<>();
        ArrayList<String> all_detectives=new ArrayList<>();
        ArrayList<String> all_healers=new ArrayList<>();
        ArrayList<String> all_commoners=new ArrayList<>();
        HashMap<String,Player> gamers=new HashMap<>();
        char_screen();
        int target=0;
        int test=0;
        int heal=0;
        String r="";
        Player user = new Player();
        Random random=new Random();
        switch (s.nextInt()){
            case 1:
                 r=r+list1.get(random.nextInt(n));
                 user=new Mafia();
                 gamers.put(r,user);
                 count_mafias++;
                 all_mafias.add(r);
                 break;
            case 2:
                r=r+list1.get(random.nextInt(n));
                user=new Detective();
                gamers.put(r,user);
                count_detectives++;
                all_detectives.add(r);
                break;
            case 3:
                r=r+list1.get(random.nextInt(n));
                user=new Healer();
                gamers.put(r,user);
                count_healers++;
                all_healers.add(r);
                break;
            case 4:
                r=r+list1.get(random.nextInt(n));
                user=new Commoner();
                gamers.put(r,user);
                count_commoners++;
                all_commoners.add(r);
                break;
            case 5:
                r=r+list1.get(random.nextInt(n));
                int g= random.nextInt(4);
                switch (g){
                    case 0:
                        user=new Mafia();
                        gamers.put(r,user);
                        count_mafias++;
                        all_mafias.add(r);
                        break;
                    case 1:
                        user=new Detective();
                        gamers.put(r,user);
                        count_detectives++;
                        all_detectives.add(r);
                        break;
                    case 2:
                        user=new Healer();
                        gamers.put(r,user);
                        count_healers++;
                        all_healers.add(r);
                        break;
                    case 3:
                        user=new Commoner();
                        gamers.put(r,user);
                        count_commoners++;
                        all_commoners.add(r);
                        break;
                }
        }
        assigned.add(r);
        System.out.println("You are "+r+".");
        System.out.print("You are a "+gamers.get(r).print_name()+".  ");
        while(count_mafias!=number_mafias){
            int g=random.nextInt(n);
            if (!assigned.contains(list1.get(g))){
                gamers.put(list1.get(g),new Mafia());
                count_mafias++;
                assigned.add(list1.get(g));
                all_mafias.add(list1.get(g));
            }
        }
        while(count_detectives!=number_detectives){
            int g=random.nextInt(n);
            if (!assigned.contains(list1.get(g))){
                gamers.put(list1.get(g),new Detective());
                count_detectives++;
                assigned.add(list1.get(g));
                all_detectives.add(list1.get(g));
            }
        }
        while(count_healers!=number_healers){
            int g=random.nextInt(n);
            if (!assigned.contains(list1.get(g))){
                gamers.put(list1.get(g),new Healer());
                count_healers++;
                assigned.add(list1.get(g));
                all_healers.add(list1.get(g));
            }
        }
        while(count_commoners!=number_commoners){
            int g=random.nextInt(n);
            if (!assigned.contains(list1.get(g))){
                gamers.put(list1.get(g),new Commoner());
                count_commoners++;
                assigned.add(list1.get(g));
                all_commoners.add(list1.get(g));
            }
        }
        switch (user.print_name()) {
            case "Mafia":
                System.out.print("Other mafias are: ");
                print(all_mafias, 1);
                break;
            case "Detective":
                System.out.print("Other detectives are: ");
                print(all_detectives, 1);
                break;
            case "Healer":
                System.out.print("Other healers are: ");
                print(all_healers, 1);
                break;
        }
        if(gamers.get(r) instanceof Mafia || gamers.get(r).equals(new Mafia())){
            boolean t=false;
            while(!t){
                test=0;
                heal=0;
                target=0;
                int alive_mafias=0;
                int alive_detectives=0;
                int alive_healers=0;
                round(list1,count_round);
                count_round++;
                for(String alldetective : all_detectives){
                    if(list1.contains(alldetective)){
                        alive_detectives++;
                    }
                }
                for(String allhealer : all_healers){
                    if(list1.contains(allhealer)){
                        alive_healers++;
                    }
                }
                for (String allMafia : all_mafias) {
                    if (gamers.get(allMafia).getHp() > 0 && list1.contains(allMafia)) {
                        alive_mafias++;
                    }
                }
                if(list1.contains(r)){
                    System.out.println("Choose a target :");
                    int j=0;
                    boolean p=false;
                    while(!p){
                        try {
                            if (j > 0) {
                                System.err.println("Target has to be an integer greater than 0 and not a mafia. Target has to be from the list given above.");
                                System.out.println("Enter a valid number:");
                            }
                            j++;
                            target = s.nextInt();
                            if (target > 0 && !all_mafias.contains("Player"+target) && list1.contains("Player"+target)) {
                                p = true;
                            }
                        } catch (InputMismatchException e) {
                            s.next();
                        }
                    }
                }
                else{
                    boolean b=false;
                    while(!b){
                        target=random.nextInt(n);
                        if(!all_mafias.contains("Player"+target) && list1.contains("Player"+target)){
                            b=true;}
                    }
                }
                System.out.println("Detectives have chosen a player to test.");
                boolean x2=false;
                if(alive_detectives>0){
                    while(!x2){
                        test=random.nextInt(n)+1;
                        if(!all_detectives.contains("Player"+(test)) && list1.contains("Player"+(test))){
                            x2=true;
                        }
                    }
                }
                System.out.println("Healers have chosen someone to heal.");
                System.out.println("--End of actions--");
                heal=random.nextInt(n) ;
                if(alive_healers>0){
                    while(!list1.contains("Player"+heal)){
                        heal=random.nextInt(n); } }
                int total_hp=0;
                for (String all_mafia : all_mafias) {
                    if (list1.contains(all_mafia)){
                        total_hp =total_hp+ gamers.get(all_mafia).getHp();} }
                int minus;
                if(total_hp>gamers.get("Player"+target).getHp()){
                    minus=gamers.get("Player"+target).getHp()/alive_mafias;
                    int c=0;
                    boolean why=false;
                    int due=0;
                    ArrayList<String> less=new ArrayList<>();
                    for (String all_mafia : all_mafias) {
                        if (gamers.get(all_mafia).getHp() < minus && list1.contains(all_mafia)) {
                            int k = gamers.get(all_mafia).getHp();
                            due = minus - k + due;
                            why=true;
                            less.add(all_mafia);
                            gamers.get(all_mafia).setHp(0);
                        } else if (list1.contains(all_mafia)) {
                            c++; } }
                    if (why && c>0){
                        int minus_final=minus+due/c;
                        for (String all_mafia : all_mafias) {
                            if (!less.contains(all_mafia) &&list1.contains(all_mafia) ) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus_final); } } }
                    else{
                        for (String all_mafia : all_mafias) {
                            if (list1.contains(all_mafia)) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus);
                            }
                        }
                    }
                    if(alive_healers>0 && target==heal){
                        gamers.get("Player"+target).setHp(500);
                        System.out.println("No one has died.");
                    }
                    else if(alive_healers>0&&target!=heal){
                        gamers.get("Player"+target).setHp(0);
                        System.out.println("Player"+target+" has died.");
                        list1.remove("Player"+target); } }
                else{
                    System.out.println("No one has died.");
                    gamers.get("Player"+target).setHp(gamers.get("Player"+target).getHp()-total_hp);
                }
                if(target!=heal){
                    gamers.get("Player"+heal).setHp(gamers.get("Player"+heal).getHp()+500);
                }
                boolean det=false;
                for (String all_detective : all_detectives) {
                    if (list1.contains(all_detective)) {
                        det = true;
                        break; } }
                boolean check=false;
                for (String all_mafia : all_mafias) {
                    if (alive_detectives>0 && det && all_mafia.equals("Player" + (test)) && list1.contains(all_mafia)) {
                        list1.remove(all_mafia);
                        check = true;
                        break; } }
                int left_mafias=0;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        left_mafias++; } }
                int w=list1.size()-left_mafias;
                if(w==left_mafias){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have won.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; }
                int voting=0;
                if(!check ){
                    boolean p=false;
                    while (!p) {
                        int n1=0;
                        HashMap<String,Integer> votes=new HashMap<>();
                        for (String value : list1) {
                            votes.put(value, 0); }
                        boolean q=false;
                        if(voting>0){
                            System.out.println("Last voting round was a tie."); }
                        voting++;
                        if(list1.contains(r)){
                            System.out.print("Select a person to vote out: ");
                            boolean x1=false;
                            q=true;
                            int y1=0;
                            while(!x1) {
                                try {
                                    if (y1 > 0) {
                                        System.err.println("Player has to be from the above list shown.");
                                        System.out.println("Enter a valid number:");
                                    }
                                    y1++;
                                    n1 = s.nextInt();
                                    if (list1.contains("Player"+n1)) {
                                        x1 = true;
                                    }
                                } catch (InputMismatchException g) {
                                    s.next(); } }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1); }
                        int count_people=0;
                        count_people=0;
                        if(q){
                            count_people++; }
                        while(count_people!=list1.size()){
                            n1=random.nextInt(n)+1+1;
                            while(!list1.contains("Player"+n1)){
                                n1=random.nextInt(n)+1; }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1);
                            count_people++; }
                        int max=n1;
                        HashMap<String,Integer> final_v=sortByValue(votes);
                        if(max>0){
                            p=true; }
                        System.out.println("Player"+n1+" has been voted out.");
                        list1.remove("Player"+n1); } }
                boolean ans=false;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        ans = true;
                        break; } }
                if(!ans){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have lost.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true;
                }
            }
        }
        else if(gamers.get(r) instanceof Detective ||gamers.get(r).equals(new Detective())){
            boolean t=false;
            while(!t){
                test=0;
                heal=0;
                int alive_detectives=0;
                int alive_healers=0;
                for(String alldetective : all_detectives){
                    if(list1.contains(alldetective)){
                        alive_detectives++;
                    }
                }
                for(String allhealer : all_healers){
                    if(list1.contains(allhealer)){
                        alive_healers++;
                    }
                }
                round(list1,count_round);
                count_round++;
                int alive_mafias=0;
                for (String allMafia : all_mafias) {
                    if (gamers.get(allMafia).getHp() > 0 && list1.contains(allMafia)) {
                        alive_mafias++;
                    }
                }
                System.out.println("Mafias have chosen their target.");
                target=random.nextInt(n);
                boolean l=false;
                while(!l){
                    target=random.nextInt(n);
                    if(list1.contains("Player"+target)&&!all_mafias.contains("Player"+target)){
                        l=true; } }
                if (list1.contains(r)) {
                    System.out.println("Choose a player to test: ");
                    int j=0;
                    boolean p=false;
                    while(!p){
                        try {
                            if (j > 0) {
                                System.err.println("You cannot test a detective. Player, who is to be tested, has to be an integer greater than 0 and not a detective. Player has to be from the list given above.");
                                System.out.println("Enter a valid number:"); }
                            j++;
                            test = s.nextInt();
                            if (test > 0 && !all_detectives.contains("Player"+test) && list1.contains("Player"+test)) {
                                p = true; }
                        } catch (InputMismatchException e) {
                            s.next(); } } }
                else if(alive_detectives>0 && !list1.contains(r)){
                    boolean h=false;
                    while(!h){
                        test=random.nextInt(n);
                        if(list1.contains("Player"+test)&&!all_detectives.contains("Player"+test)){
                            h=true; } } }
                if(gamers.get("Player"+test) instanceof Mafia){
                    System.out.println("Player"+test+" is a mafia."); }
                else{
                    System.out.println("Player"+test+" is not a mafia."); }
                System.out.println("Healers have chosen someone to heal.");
                heal=random.nextInt(n);
                if(alive_healers>0){
                    boolean j=false;
                    while(!j){
                        heal=random.nextInt(n);
                        if(list1.contains("Player"+heal)&& heal!=0){
                            j=true; } } }
                System.out.println("--End of actions--");
                int total_hp=0;
                for (String all_mafia : all_mafias) {
                    if (list1.contains(all_mafia)){
                        total_hp =total_hp+ gamers.get(all_mafia).getHp();}
                }
                int minus;
                if(total_hp>gamers.get("Player"+target).getHp()){
                    minus=gamers.get("Player"+target).getHp()/alive_mafias;
                    int c=0;
                    boolean why=false;
                    int due=0;
                    ArrayList<String> less=new ArrayList<>();
                    for (String all_mafia : all_mafias) {
                        if (gamers.get(all_mafia).getHp() < minus && list1.contains(all_mafia)) {
                            int k = gamers.get(all_mafia).getHp();
                            due = minus - k + due;
                            why=true;
                            less.add(all_mafia);
                            gamers.get(all_mafia).setHp(0);
                        } else if (list1.contains(all_mafia)) {
                            c++; } }
                    if (why && c>0){
                        int minus_final=minus+due/c;
                        for (String all_mafia : all_mafias) {
                            if (!less.contains(all_mafia) &&list1.contains(all_mafia) ) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus_final); } } }
                    else{
                        for (String all_mafia : all_mafias) {
                            if (list1.contains(all_mafia)) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus); } } }
                    if(alive_healers>0&&target==heal){
                        gamers.get("Player"+target).setHp(500);
                        System.out.println("No one has died."); }
                    else if(alive_healers>0&&target!=heal){
                        gamers.get("Player"+target).setHp(0);
                        System.out.println("Player"+target+" has died.");
                        list1.remove("Player"+target); } }
                else{
                    System.out.println("No one has died.");
                    gamers.get("Player"+target).setHp(gamers.get("Player"+target).getHp()-total_hp); }
                if(alive_healers>0 && target!=heal){
                    gamers.get("Player"+heal).setHp(gamers.get("Player"+heal).getHp()+500); }
                boolean det=false;
                for (String all_detective : all_detectives) {
                    if (list1.contains(all_detective)) {
                        det = true;
                        break; } }
                boolean check=false;
                for (String all_mafia : all_mafias) {
                    if (det && all_mafia.equals("Player" + test) && list1.contains(all_mafia)) {
                        list1.remove(all_mafia);
                        check = true;
                        break; } }
                int left_mafias=0;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        left_mafias++; } }
                int w=list1.size()-left_mafias;
                if(w==left_mafias){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have won.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; }
                if(!check){
                    int voting=0;
                    boolean p=false;
                    while (!p) {
                        int n1=0;
                        HashMap<String,Integer> votes=new HashMap<>();
                        for (String value : list1) {
                            votes.put(value, 0); }
                        boolean q=false;
                        if(voting>0){
                            System.out.println("Last voting round was a tie."); }
                        voting++;
                        if(list1.contains(r)){
                            System.out.print("Select a person to vote out: ");
                            boolean x1=false;
                            q=true;
                            int y1=0;
                            while(!x1) {
                                try {
                                    if (y1 > 0) {
                                        System.err.println("Player has to be from the above list shown.");
                                        System.out.println("Enter a valid number:"); }
                                    y1++;
                                    n1 = s.nextInt();
                                    if (list1.contains("Player"+n1)) {
                                        x1 = true; }
                                } catch (InputMismatchException g) {
                                    s.next(); } }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1); }
                        int count_people=0;
                        count_people=0;
                        if(q){
                            count_people++; }
                        while(count_people!=list1.size()){
                            n1=random.nextInt(n)+1+1;
                            while(!list1.contains("Player"+n1)){
                                n1=random.nextInt(n)+1; }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1);
                            count_people++; }
                        int max=n1;
                        HashMap<String,Integer> final_v=sortByValue(votes);
                        if(max>0){
                            p=true; }
                        System.out.println("Player"+n1+" has been voted out.");
                        list1.remove("Player"+n1); } }
                boolean ans=false;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        ans = true;
                        break; } }
                if(!ans){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have lost.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true;
                }
            }
        }
        else if(gamers.get(r) instanceof Healer|| gamers.get(r).equals(new Healer())){
            boolean t=false;
            while(!t){
                test=0;
                heal=0;
                target=0;
                int alive_mafias=0;
                int alive_detectives=0;
                int alive_healers=0;
                round(list1,count_round);
                count_round++;
                for(String alldetective : all_detectives){
                    if(list1.contains(alldetective)){
                        alive_detectives++; } }
                for(String allhealer : all_healers){
                    if(list1.contains(allhealer)){
                        alive_healers++; } }
                for (String allMafia : all_mafias) {
                    if (gamers.get(allMafia).getHp() > 0 && list1.contains(allMafia)) {
                        alive_mafias++; } }
                if(list1.contains(r)){
                    boolean p=false;
                    while(!p){
                        target=random.nextInt(n);
                        if(!all_mafias.contains("Player"+target)&&list1.contains("Player"+target)){
                            p=true; } } }
                System.out.println("Mafias have chosen someone to kill.");
                System.out.println("Detectives have chosen a player to test.");
                boolean x2=false;
                if(alive_detectives>0){
                    while(!x2){
                        test=random.nextInt(n)+1;
                        if(!all_detectives.contains("Player"+(test)) && list1.contains("Player"+(test))){
                            x2=true; } } }
                heal=random.nextInt(n) ;
              if(list1.contains(r)){
                    System.out.println("Choose a player to heal :");
                    int j=0;
                    boolean p=false;
                    while(!p){
                        try {
                            if (j > 0) {
                                System.err.println("Person to be healed has to be from the list given above.");
                                System.out.println("Enter a valid number:"); }
                            j++;
                            heal = s.nextInt();
                            if (heal > 0 && list1.contains("Player"+heal)) {
                                p = true; }
                        } catch (InputMismatchException e) {
                            s.next(); } } }
                else{
                    boolean b=false;
                    while(!b){
                        heal=random.nextInt(n);
                        if(!all_mafias.contains("Player"+heal) && list1.contains("Player"+heal)){
                            b=true;} } }
                System.out.println("--End of actions--");
                int total_hp=0;
                for (String all_mafia : all_mafias) {
                    if (list1.contains(all_mafia)){
                        total_hp =total_hp+ gamers.get(all_mafia).getHp();} }
                int minus;
                if(alive_mafias>0 && target>0 &&total_hp>gamers.get("Player"+target).getHp()){
                    minus=gamers.get("Player"+target).getHp()/alive_mafias;
                    int c=0;
                    boolean why=false;
                    int due=0;
                    ArrayList<String> less=new ArrayList<>();
                    for (String all_mafia : all_mafias) {
                        if (gamers.get(all_mafia).getHp() < minus && list1.contains(all_mafia)) {
                            int k = gamers.get(all_mafia).getHp();
                            due = minus - k + due;
                            why=true;
                            less.add(all_mafia);
                            gamers.get(all_mafia).setHp(0);
                        } else if (list1.contains(all_mafia)) {
                            c++; } }
                    if (why && c>0){
                        int minus_final=minus+due/c;
                        for (String all_mafia : all_mafias) {
                            if (!less.contains(all_mafia) &&list1.contains(all_mafia) ) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus_final); } } }
                    else{
                        for (String all_mafia : all_mafias) {
                            if (list1.contains(all_mafia)) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus); } } }
                    if(alive_healers>0 && target==heal){
                        gamers.get("Player"+target).setHp(500);
                        System.out.println("No one has died."); }
                    else if(alive_healers>0&&target!=heal){
                        gamers.get("Player"+target).setHp(0);
                        System.out.println("Player"+target+" has died.");
                        list1.remove("Player"+target); } }
                else{
                    System.out.println("No one has died.");
                    gamers.get("Player"+target).setHp(gamers.get("Player"+target).getHp()-total_hp); }
                if(target!=heal){
                    gamers.get("Player"+heal).setHp(gamers.get("Player"+heal).getHp()+500); }
                boolean det=false;
                for (String all_detective : all_detectives) {
                    if (list1.contains(all_detective)) {
                        det = true;
                        break; } }
                boolean check=false;
                for (String all_mafia : all_mafias) {
                    if (alive_detectives>0 && det && all_mafia.equals("Player" + (test)) && list1.contains(all_mafia)) {
                        list1.remove(all_mafia);
                        check = true;
                        break; } }
                int left_mafias=0;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        left_mafias++; } }
                int w=list1.size()-left_mafias;
                if(w==left_mafias){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have won.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; }
                int voting=0;
                if(!check ){
                    boolean p=false;
                    while (!p) {
                        int n1=0;
                        HashMap<String,Integer> votes=new HashMap<>();
                        for (String value : list1) {
                            votes.put(value, 0); }
                        boolean q=false;
                        if(voting>0){
                            System.out.println("Last voting round was a tie."); }
                        voting++;
                        if(list1.contains(r)){
                            System.out.print("Select a person to vote out: ");
                            boolean x1=false;
                            q=true;
                            int y1=0;
                            while(!x1) {
                                try {
                                    if (y1 > 0) {
                                        System.err.println("Player has to be from the above list shown.");
                                        System.out.println("Enter a valid number:"); }
                                    y1++;
                                    n1 = s.nextInt();
                                    if (list1.contains("Player"+n1)) {
                                        x1 = true; }
                                } catch (InputMismatchException g) {
                                    s.next(); } }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1); }
                        int count_people=0;
                        count_people=0;
                        if(q){
                            count_people++; }
                        while(count_people!=list1.size()){
                            n1=random.nextInt(n)+1+1;
                            while(!list1.contains("Player"+n1)){
                                n1=random.nextInt(n)+1; }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1);
                            count_people++; }
                        int max=n1;
                        HashMap<String,Integer> final_v=sortByValue(votes);
                        if(max>0){
                            p=true; }
                        System.out.println("Player"+n1+" has been voted out.");
                        list1.remove("Player"+n1); } }
                boolean ans=false;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        ans = true;
                        break; } }
                if(!ans){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have lost.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; } } }
        else{
            boolean t=false;
            while(!t){
                test=0;
                heal=0;
                target=0;
                int alive_mafias=0;
                int alive_detectives=0;
                int alive_healers=0;
                round(list1,count_round);
                count_round++;
                for(String alldetective : all_detectives){
                    if(list1.contains(alldetective)){
                        alive_detectives++; } }
                for(String allhealer : all_healers){
                    if(list1.contains(allhealer)){
                        alive_healers++; } }
                for (String allMafia : all_mafias) {
                    if (gamers.get(allMafia).getHp() > 0 && list1.contains(allMafia)) {
                        alive_mafias++; } }
                if(list1.contains(r)){
                    boolean p=false;
                    while(!p){
                        target=random.nextInt(n);
                        if(!all_mafias.contains("Player"+target)&&list1.contains("Player"+target)){
                            p=true; } } }
                System.out.println("Mafias have chosen someone to kill.");
                System.out.println("Detectives have chosen a player to test.");
                System.out.println("Healers have chosen a player to heal.");
                boolean x2=false;
                if(alive_detectives>0){
                    while(!x2){
                        test=random.nextInt(n)+1;
                        if(!all_detectives.contains("Player"+(test)) && list1.contains("Player"+(test))){
                            x2=true; } } }
                heal=random.nextInt(n) ;
                boolean x3=false;
                if(alive_healers>0){
                    while(!x3){
                        heal=random.nextInt(n)+1;
                        if(!all_detectives.contains("Player"+(heal)) && list1.contains("Player"+(heal))){
                            x3=true; } } }
                System.out.println("--End of actions--");
               int total_hp=0;
                for (String all_mafia : all_mafias) {
                    if (list1.contains(all_mafia)){
                        total_hp =total_hp+ gamers.get(all_mafia).getHp();} }
                int minus;
                if(alive_mafias>0 && target>0 &&total_hp>gamers.get("Player"+target).getHp()){
                    minus=gamers.get("Player"+target).getHp()/alive_mafias;
                    int c=0;
                    boolean why=false;
                    int due=0;
                    ArrayList<String> less=new ArrayList<>();
                    for (String all_mafia : all_mafias) {
                        if (gamers.get(all_mafia).getHp() < minus && list1.contains(all_mafia)) {
                            int k = gamers.get(all_mafia).getHp();
                            due = minus - k + due;
                            why=true;
                            less.add(all_mafia);
                            gamers.get(all_mafia).setHp(0);
                        } else if (list1.contains(all_mafia)) {
                            c++; } }
                    if (why && c>0){
                        int minus_final=minus+due/c;
                        for (String all_mafia : all_mafias) {
                            if (!less.contains(all_mafia) &&list1.contains(all_mafia) ) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus_final); } } }
                    else{
                        for (String all_mafia : all_mafias) {
                            if (list1.contains(all_mafia)) {
                                gamers.get(all_mafia).setHp(gamers.get(all_mafia).getHp() - minus); } } }
                    if(alive_healers>0 && target==heal){
                        gamers.get("Player"+target).setHp(500);
                        System.out.println("No one has died."); }
                    else if(alive_healers>0&&target!=heal){
                        gamers.get("Player"+target).setHp(0);
                        System.out.println("Player"+target+" has died.");
                        list1.remove("Player"+target); } }
                else{
                    System.out.println("No one has died.");
                    gamers.get("Player"+target).setHp(gamers.get("Player"+target).getHp()-total_hp); }
                if(target!=heal && target!=0){
                    gamers.get("Player"+heal).setHp(gamers.get("Player"+heal).getHp()+500); }
                boolean det=false;
                for (String all_detective : all_detectives) {
                    if (list1.contains(all_detective)) {
                        det = true;
                        break; } }
                boolean check=false;
                for (String all_mafia : all_mafias) {
                    if (alive_detectives>0 && det && all_mafia.equals("Player" + (test)) && list1.contains(all_mafia)) {
                        list1.remove(all_mafia);
                        check = true;
                        break; } }
                int left_mafias=0;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        left_mafias++; } }
                int w=list1.size()-left_mafias;
                if(w==left_mafias){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have won.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; }
                int voting=0;
                if(!check ){
                    boolean p=false;
                    while (!p) {
                        int n1=0;
                        HashMap<String,Integer> votes=new HashMap<>();
                        for (String value : list1) {
                            votes.put(value, 0); }
                        boolean q=false;
                        if(voting>0){
                            System.out.println("Last voting round was a tie."); }
                        voting++;
                        if(list1.contains(r)){
                            System.out.print("Select a person to vote out: ");
                            boolean x1=false;
                            q=true;
                            int y1=0;
                            while(!x1) {
                                try {
                                    if (y1 > 0) {
                                        System.err.println("Player has to be from the above list shown.");
                                        System.out.println("Enter a valid number:"); }
                                    y1++;
                                    n1 = s.nextInt();
                                    if (list1.contains("Player"+n1)) {
                                        x1 = true; }
                                } catch (InputMismatchException g) {
                                    s.next(); } }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1); }
                        int count_people=0;
                        count_people=0;
                        if(q){
                            count_people++; }
                        while(count_people!=list1.size()){
                            n1=random.nextInt(n)+1+1;
                            while(!list1.contains("Player"+n1)){
                                n1=random.nextInt(n)+1; }
                            votes.replace("Player"+n1,votes.get("Player"+n1)+1);
                            count_people++; }
                        int max=n1;
                        HashMap<String,Integer> final_v=sortByValue(votes);
                        if(max>0){
                            p=true; }
                        System.out.println("Player"+n1+" has been voted out.");
                        list1.remove("Player"+n1); } }
                boolean ans=false;
                for (String value : list1) {
                    if (all_mafias.contains(value)) {
                        ans = true;
                        break; } }
                if(!ans){
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("Game Over.");
                    System.out.println("The Mafias have lost.");
                    print(all_mafias,0 );
                    System.out.println("was/were mafias.");
                    print(all_detectives,0);
                    System.out.println("was/were detectives.");
                    print(all_healers,0);
                    System.out.println("was/were Healer.");
                    print(all_commoners,0);
                    System.out.println("were commoners.");
                    System.out.println("--End of Sample Case--");
                    System.out.println("------------------------------------------------------------------------------------");
                    t=true; } } } }
    public static void char_screen(){
        System.out.println("Choose a Character");
        System.out.println("1) Mafia");
        System.out.println("2) Detective");
        System.out.println("3) Healer");
        System.out.println("4) Commoner");
        System.out.println("5) Assign Randomly");
    }
    public static <T> void print(ArrayList<T> x,int start){
        for (int i=start;i<x.size();i++) {
            System.out.print("["+x.get(i)+"] ");
        }
    }
    public static <T> void round(ArrayList<T> x,int r){
        System.out.println();
        System.out.println("----------------------Round "+r+"----------------------");
        System.out.print(x.size()+" players are remaining: ");
        print(x,0);
        System.out.println("are alive.");
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> voting)
    { List<Map.Entry<String, Integer> > array = new LinkedList<Map.Entry<String, Integer> >(voting.entrySet());
        Collections.sort(array, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue()); }});
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : array) {
            temp.put(aa.getKey(), aa.getValue()); }
        return temp; }

}
