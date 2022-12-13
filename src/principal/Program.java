package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {
 
                String[] acesso = line.split(" ");
                String nome = acesso[0];
                Date moment = Date.from(Instant.parse(acesso[1]));
                set.add(new LogEntry(nome, moment));

                line = br.readLine();

            }

            System.out.println("Total de usuários: " + set.size());


        }  catch (IOException e) {
            e.getMessage();
        }


    }

    
}
