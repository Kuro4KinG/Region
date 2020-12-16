public class Main {
    public static void main(String[] args) throws Exception {

        new RegionRepository().getAll();
        new RegionRepository().getById(1L);
        new RegionRepository().save(5L, "SomeRegion");

    }
}