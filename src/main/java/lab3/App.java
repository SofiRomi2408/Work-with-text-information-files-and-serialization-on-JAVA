package lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.yaml.snakeyaml.Yaml;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App 
{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        while (true) {
            
            System.out.println("Menu:");
            System.out.println("1 - Work with I/O Streams");
            System.out.println("2 - Native Java Serialization");
            System.out.println("3 - JSON Serialization (GSON)");
            System.out.println("4 - YAML Serialization (SnakeYAML)");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
        
            switch (choice) {
                case 1:
                    performIOOperations();
                    break;
                case 2:
                   
                    performSerialization();
                    break;
                case 3:
                    performJsonSerialization();
                    break;
                case 4:
                    performYamlSerialization();
                    break;
                case 5:
                 
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
        private static void performIOOperations() {
  
            List<Message> messages = new ArrayList<>();
            messages.add(new Message("Hello", "I`m Sofia Romaniv", new Date()));
            messages.add(new Message("Question", "How are you?", new Date()));
    
  
            UserProfile user = new UserProfile(1, "Sofia", "Romaniv", "sofi@gmail.com", messages);
    
            try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("user_profile.dat")))) {
                oos.writeObject(user);
                System.out.println("User profile has been serialized and written to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("user_profile.dat")))) {
                UserProfile deserializedUser = (UserProfile) ois.readObject();
                System.out.println("Deserialized User: ");
                System.out.println("ID: " + deserializedUser.getId());
                System.out.println("First Name: " + deserializedUser.getFirstName());
                System.out.println("Last Name: " + deserializedUser.getLastName());
                System.out.println("Email: " + deserializedUser.getEmail());
                System.out.println("Messages: ");
                for (Message message : deserializedUser.getMessages()) {
                    System.out.println("  Subject: " + message.getSubject());
                    System.out.println("  Text: " + message.getText());
                    System.out.println("  Date: " + message.getDate());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


           
            private static void performSerialization() {
    
                List<Message> messages = new ArrayList<>();
        
    
                UserProfile1 user = new UserProfile1(1, "Sofia", "Romaniv", "sofi@gmail.com", messages);
        
                try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("user_profile_no_messages.dat")))) {
                    oos.writeObject(user);
                    System.out.println("User profile without messages has been serialized and written to file.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("user_profile_no_messages.dat")))) {
                    UserProfile1 deserializedUser = (UserProfile1) ois.readObject(); 
                    System.out.println("Deserialized User (without messages): ");
                    System.out.println("ID: " + deserializedUser.getId());
                    System.out.println("First Name: " + deserializedUser.getFirstName());
                    System.out.println("Last Name: " + deserializedUser.getLastName());
                    System.out.println("Email: " + deserializedUser.getEmail());
                    System.out.println("Messages: " + deserializedUser.getMessages()); 
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            private static void performJsonSerialization() {
                List<Message3> messages = new ArrayList<>();
                messages.add(new Message3("Hello", "I`m Sofia Romaniv", new Date()));
                messages.add(new Message3("Question", "How are you?", new Date()));
                UserProfile3 user = new UserProfile3(1, "Sofia", "Romaniv", "sofi@gmail.com", messages);
            

                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                String jsonString = gson.toJson(user);
                System.out.println("Serialized User Profile to JSON:\n" + jsonString);

                try (Writer writer = new BufferedWriter(new FileWriter("user_profile.json"))) {
                    writer.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (Reader reader = new BufferedReader(new FileReader("user_profile.json"))) {
                    UserProfile3 deserializedUser = gson.fromJson(reader, UserProfile3.class);

                    if (deserializedUser.getMessages() == null) {
                        deserializedUser.getMessages().add(new Message3("Default", "No messages found.", null));
                    }
                    
                    System.out.println("Deserialized User Profile:");
                    System.out.println("ID: " + deserializedUser.getId());
                    System.out.println("First Name: " + deserializedUser.getFirstName());
                    System.out.println("Last Name: " + deserializedUser.getLastName());
                    System.out.println("Messages:");
                    for (Message3 message : deserializedUser.getMessages()) {
                        System.out.println("  Subject: " + message.getSubject());
                        System.out.println("  Text: " + message.getText());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            private static void performYamlSerialization() {

                List<Message4> messages = new ArrayList<>();
                messages.add(new Message4("Hello", "I`m Sofia Romaniv", new Date()));
                messages.add(new Message4("Question", "How are you?", new Date()));
                
                UserProfile4 user = new UserProfile4(1, "Sofia", "Romaniv", "sofi@gmail.com", messages);

                Yaml yaml = new Yaml();
                String yamlString = yaml.dump(user);
                System.out.println("Serialized User Profile to YAML:\n" + yamlString);
            

                try (Writer writer = new BufferedWriter(new FileWriter("user_profile.yaml"))) {
                    writer.write(yamlString);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (Reader reader = new BufferedReader(new FileReader("user_profile.yaml"))) {
                    UserProfile4 deserializedUser = yaml.loadAs(reader, UserProfile4.class);
            
                    System.out.println("Deserialized User Profile:");
                    System.out.println("ID: " + deserializedUser.getId());
                    System.out.println("First Name: " + deserializedUser.getFirstName());
                    System.out.println("Last Name: " + deserializedUser.getLastName());
                    System.out.println("Email: " + deserializedUser.getEmail());
                    System.out.println("Messages:");
                    for (Message4 message : deserializedUser.getMessages()) {
                        System.out.println("  Subject: " + message.getSubject());
                        System.out.println("  Text: " + message.getText());
                        System.out.println("  Date: null");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
    
           }
