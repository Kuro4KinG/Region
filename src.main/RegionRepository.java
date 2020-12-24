import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class RegionRepository {
    final String regions = "regions.txt";

    public List<Region> getAll() throws IOException {
        return getLines(regions).
                stream().map(line -> List.of(line.split(". ")))
                .map(line -> regionFromLine(line))
                .collect(Collectors.toList());

    }

    public Region getById(Long id) throws IOException {
        return getAll().stream().filter(line -> line.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    public Region save(Region newRegion) throws IOException {
        List<Region> list = getAll();
        newRegion = new Region(generateID(list), newRegion.getName());
        list.add(newRegion);
        writeLines(regions, list);
        return newRegion;
    }

    public Region update(Region region) throws IOException {
        List<Region> list = getAll();

        Region updatedRegion = list.stream()
                .filter(el -> el.getId().equals(region.getId()))
                .findFirst().get();
        updatedRegion.setName(region.getName());

        writeLines(regions, list);
        return updatedRegion;
    }

    public void deleteById(Long id) throws IOException {
        List<Region> list = getAll();
        list.remove(list.stream().
                filter(el -> el.getId().equals(id))
                .collect(Collectors.toList()).get(0));
        writeLines(regions, list);
    }

    private List<String> getLines(String path) throws IOException {
        return Files.lines(Paths.get(path)).collect(Collectors.toList());
    }

    private void writeLines(String path, List<Region> list) throws IOException {
        List newList = list.stream()
                .map(line -> line.toString())
                .collect(Collectors.toList());
        Files.write(Paths.get(regions), newList);
    }

    private Region regionFromLine(List<String> line) {
        return new Region(Long.parseLong(line.get(0)), line.get(1));
    }

    private Long generateID(List<Region> list) {
        Long max = list.stream().map(line -> line.getId()).max(Long::compare).get() + 1;
        return max;
    }
}

