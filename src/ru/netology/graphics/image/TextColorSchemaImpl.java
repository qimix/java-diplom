package ru.netology.graphics.image;

public class TextColorSchemaImpl {
    public char convert(int color) {
        char[] array = {'#', '$', '@', '%', '*', '+', '-', '\''};

        if (color <= 31) {
            return '#';
        } else if (color < 62 && color > 31) {
            return '$';
        } else if (color < 93 && color > 62) {
            return '@';
        } else if (color < 124 && color > 93) {
            return '%';
        } else if (color < 155 && color > 124) {
            return '*';
        } else if (color < 186 && color > 155) {
            return '+';
        } else if (color < 217 && color > 186) {
            return '-';
        } else if (color < 248 && color > 217) {
            return '\'';
        }
        return '%';
    }
}
