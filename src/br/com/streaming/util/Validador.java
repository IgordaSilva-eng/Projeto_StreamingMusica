package br.com.streaming.util;

public class Validador {
    public static boolean isEmailValido(String email) {
        return email != null && email.contains("@");
    }
}