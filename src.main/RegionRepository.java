import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class RegionRepository {

    public void getById(Long id) throws IOException {
        Files.lines(Paths.get("regions.txt"))
                .filter(line -> line.startsWith(id.toString()))
                .map(line -> List.of(line.split(". ")).get(1))
                .forEach(System.out::println);
    }

    public void getAll() throws IOException {
        Files.lines(Paths.get("regions.txt")).forEach(System.out::println);
    }

    public void save(Long id, String name) throws IOException {
        List list = Files.lines(Paths.get("regions.txt")).collect(Collectors.toList());
        list.add(id + ". " + name);
        Files.write(Paths.get("regions.txt"), list);
        getAll();

    }

    public void delete(Long id) throws IOException {
                List list = Files.lines(Paths.get("regions.txt")).collect(Collectors.toList());  // читаю строки в файле как List
        String foundObj = list.stream().filter(line -> line.toString().startsWith(id.toString())) // нахожу в List нужную мне строку
                .collect(Collectors.toList()).toString(); //   сохраняю как String
        System.out.println(list); // вывожу до "удаления"
        list.remove(foundObj);
        System.out.println(list); // вывожу после "удаления"
    }
}

