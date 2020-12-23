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