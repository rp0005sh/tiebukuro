class Main {
    public static void main(String args[]){
        ATM atm = new ATM();
        atm.init();

        User u1 = new User();
        u1.name = "あきら";
        u1.cash = 0;

        int gaku = 5000;
        if (atm.withdraw(u1, gaku)) {
            u1.cash = u1.cash + gaku;
        }
        System.out.println(u1.name+"は"+u1.cash+"円もっている");
    }
}

class ATM {
    DataBase db;

    boolean withdraw(User u, int kingaku) {
        Kouza k = db.getKouza(u.name);
        if (k == null) return false;
        if(k.zandaka > kingaku) {
            k.reduce(kingaku);
            return true;
        }
        return false;
    }

    void init() {
        db = new DataBase();
        db.kTable = new Kouza[2];
        
        Kouza k1 = new Kouza();
        k1.name = "あきら";
        k1.zandaka = 10000;
        
        Kouza k2 = new Kouza();
        k2.name = "さとし";
        k2.zandaka = 1000;
        
        db.kTable[0] = k1;
        db.kTable[1] = k2;
    }
}

class Kouza {
    String name;
    int zandaka;
    void reduce(int kingaku) {
        zandaka -= kingaku;
    }
}

class DataBase {
    Kouza[] kTable;
    Kouza getKouza(String name) {
        return java.util.stream.Stream.ofNullable(kTable)
        .flatMap(java.util.stream.Stream::of)
        .filter(k -> k != null)
        .filter(k -> k.name == null ? name == null : k.name.equals(name))
        .findFirst().orElse(null);
    }
}

class User {
    String name;
    int cash;
}
