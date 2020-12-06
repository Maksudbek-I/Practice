package Practice.Practice_3.second;

public class Head {
    private String hair_Color, eyes_Color;

    public String getHair_Color() {
        return hair_Color;
    }

    public void setHair_Color(String hair_Color) {
        this.hair_Color = hair_Color;
    }

    public String getEyes_Color() {
        return eyes_Color;
    }

    public void setEyes_Color(String eyes_Color) {
        this.eyes_Color = eyes_Color;
    }

    @Override
    public String toString() {
        return "Head{" +
                "hair_Color='" + hair_Color + '\'' +
                ", eyes_Color='" + eyes_Color + '\'' +
                '}';
    }
}
