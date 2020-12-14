import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Long.valueOf;

public class Main {
    public static void main(String[] args) throws Exception {
//
//        new RegionRepository().getById(1L);
//        new RegionRepository().getAll();
        new RegionRepository().save(new Region(5L, "SomeRegion"));
   //     new RegionRepository().update(7L, "US");
 //      new RegionRepository().deleteById(7L);
    }
}