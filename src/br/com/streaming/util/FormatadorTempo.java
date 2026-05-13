package br.com.streaming.util;

public class FormatadorTempo {

    public static String formatarSegundos(int totalSegundos) {
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
}