package implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.BaseEntity;
import interfaces.GenericDao;
import util.DirectoryControl;
import util.GenerateId;

public abstract class GenericDaoImpl<T extends BaseEntity> implements GenericDao<T> {

    private final Class<T> clazz;

    public GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getGenericClass() {
        return this.clazz;
    }

    @Transactional
    public T add(T entity) {
        Long id = GenerateId.getId(getDirectoryPath());
        entity.setId(id);
        writeOrRewriteInRepository(entity);
        return entity;
    }

    @Transactional
    public T get(Long id) {
        T entity = null;
        try {
            File file = getFile(id);
            ObjectMapper mapper = new ObjectMapper();
            entity = mapper.readValue(file, clazz);
        } catch (NullPointerException | IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return entity;
    }

    @Transactional
    public List<T> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<T> listEntities = new ArrayList<>();
        try {
            listEntities = Files.walk(Paths.get(getDirectoryPath()))
                    .filter(p -> !p.getFileName().equals(Paths.get("autoincrement")))
                    .filter(Files::isRegularFile)
                    .map(p -> {
                        T entity = null;
                        try {
                            entity = mapper.readValue(p.toFile(), clazz);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return entity;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listEntities;
    }

    @Transactional
    public void remove(Long id) {
        File file = getFile(id);
        file.delete();
    }

    @Transactional
    public void update(T entity) {
        writeOrRewriteInRepository(entity);
    }

    private String getDirectoryPath() {
        return DirectoryControl.getPath(clazz.getSimpleName());
    }

    private File getFile(Long id) {
        return new File(getDirectoryPath() + id.toString() + ".json");
    }

    private void writeOrRewriteInRepository(T entity) {
        File file = getFile(entity.getId());
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
