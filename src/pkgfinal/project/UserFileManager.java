package pkgfinal.project;

import java.io.*;
import java.security.MessageDigest;

public class UserFileManager {

    private static final String FILE_PATH = "users.txt";

    // 🔐 Password hashing using SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return password; // fallback (not ideal, but avoids crash)
        }
    }

    // 📝 Save user info to users.txt
    public static void saveUser(String name, String email, String password) {
        String hashedPassword = hashPassword(password);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(name + "|" + email + "|" + hashedPassword);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Check if login credentials are valid
    public static boolean isValidLogin(String name, String email, String password) {
        String hashedInput = hashPassword(password);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3 && parts[0].equals(name) && parts[1].equals(email) && parts[2].equals(hashedInput)) {
                    return true; // credentials match
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // no match found
    }
}