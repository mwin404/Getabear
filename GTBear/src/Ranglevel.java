public class Ranglevel {
    Rang rang;

    public Ranglevel(Rang rang) {
        this.rang = rang;
    }

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }

    public static String ranglevel(int Score) {
        if (Score <= 50) {
            return "Rang: Dog";
        }
        else if (Score <= 100) {
            return "Rang: Laufbursche";
        }
        else if (Score <= 200) {
            return "Rang: Gauner";
        }
        else if (Score <= 400) {
            return "Rang: Soldat";
        }
        else if (Score <= 700) {
            return "Rang: Profi";
        }
        else if (Score <= 1000) {
            return "Rang: Capo";
        }
        else {
            return "Rang: Boss";
        }
    }
}
