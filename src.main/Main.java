import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new RegionRepository()
                .getAll());

        System.out.println(new RegionRepository()
                .getById(1L));

        Region r = new Region(null, "ARCTIC");
        System.out.println(new RegionRepository()
                .save(r));

        Region region = new Region(6L, "ANTARCTIC");
        System.out.println(new RegionRepository()
                .update(region));

        new RegionRepository()
                .deleteById(2L);


    }


}