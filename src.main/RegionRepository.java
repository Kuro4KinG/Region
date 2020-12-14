import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

public class RegionRepository {
    File regionsFile = new File("regions.txt");

    public List readFile() throws IOException {
        String b;
        List<Region> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(regionsFile)))) {
            while ((b = br.readLine()) != null) {
                String[] regionArray = b.split(". ");
                list.add(new Region(valueOf(regionArray[0]), regionArray[1]));
            }
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти файл");
            return null;
        }
    }

    public void writeList(List list) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(regionsFile))) {
            for (Object i : list) {
                Region r = (Region) i;
                bw.write(r.toString() + "\n");
            }

        }
    }

    public void getById(Long id) throws IOException {
        List list = readFile();
        for (Object i : list) {
            if (id == ((Region) i).getId()) {
                System.out.println(((Region) i).getName());
                return;
            }
        }
        System.out.println("По указанному id ничего не найдено");
    }

    public void getAll() throws IOException {
        List list = readFile();
        for (Object i : list) {
            System.out.println(i);
        }
    }

    public void save(Region r) throws IOException {
        List list = readFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(regionsFile, true))) {
            for (Object i : list) {
                if (r.getId() == ((Region) i).getId()) {
                    System.out.println("Объект с указанным id уже существует!");
                    return;
                }
            }
            String newR = "\n" + r.getId() + ". " + r.getName();
            bw.write(newR);
        } catch (IOException e) {
            throw new IOException("Ошибка ввода/вывода при сохранении");


        }
        getAll();
    }

    public void update(Long id, String name) throws IOException {
        List list = readFile();

        boolean changed = false;
        for (Object i : list) {
            if (id.equals(((Region) i).getId())) {
                ((Region) i).setName(name);
                changed = true;
            }
        }
        if (changed = false) {
            System.out.println("Указанный id не найден");
            return;
        }
        writeList(list);
        getAll();
    }

    public void deleteById(Long id) throws IOException {
        List list = readFile();
        int d = 0;
        boolean changed = false;

        for (Object i : list) {
            if (id == ((Region) i).getId()) {
                d = list.indexOf(i);
                changed = true;
            }
        }

        if (changed = false) {
            System.out.println("Указанный id не найден");
            return;
        }

        list.remove(d);
        writeList(list);
        getAll();
    }
}

