package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class Utils {

    public static String calcularHash(String senha) {
        String hashSHA1 = "";
        try {
            // Crie uma instância do MessageDigest 
            //com o algoritmo SHA1
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");

            // Atualize o digest com os bytes do texto
            sha1.update(senha.getBytes());

            // Calcule o hash SHA1
            byte[] digest = sha1.digest();

            // Converta o hash de bytes para uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            hashSHA1 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritmo SHA1 não encontrado");
        }

        return hashSHA1;
    }

    public static Date converterStringToDate(String dataStr) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(dataStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String converterDateToString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
        }
    }

    