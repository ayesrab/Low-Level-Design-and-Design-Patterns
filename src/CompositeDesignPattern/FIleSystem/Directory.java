package CompositeDesignPattern.FIleSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> fileSystems;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directoy Name : " + directoryName);
        for(FileSystem fileSystem : fileSystems){
            fileSystem.ls();
        }
    }
}
