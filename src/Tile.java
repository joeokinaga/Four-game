/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okinagajoe
 */
public class Tile {
    private int value;
    private String color;

    public Tile() {
        this.value = 0;
        this.color = "WHITE";
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public void incrementValue(String playerColor) {
        if (value < 4) {
            value++;
            if (value == 4) {
                color = playerColor;
            }
        }
    }

    public boolean isMaxValue() {
        return value == 4;
    }
}
