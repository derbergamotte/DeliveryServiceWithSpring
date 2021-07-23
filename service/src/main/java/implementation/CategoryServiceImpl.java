package implementation;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.CategoryDto;
import entities.Category;
import interfaces.CategoryDao;
import interfaces.CategoryService;
import mappers.CategoryMapper;
import org.apache.commons.lang3.StringUtils;


public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = CategoryDaoImpl.getCategoryDao();

    private static CategoryServiceImpl categoryService;

    private CategoryServiceImpl() {
    }

    public static CategoryServiceImpl getCategoryService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl();
        }
        return categoryService;
    }

    public CategoryDto add(CategoryDto categoryDto) {
        return CategoryMapper.INSTANCE.toDto(categoryDao.add(CategoryMapper.INSTANCE.toEntity(categoryDto)));
    }

    public CategoryDto getById(Long id) {
        return CategoryMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Collection<CategoryDto> getAll() {
        return categoryDao.getAll().stream().map(CategoryMapper.INSTANCE::toDto).collect(Collectors.toSet());
    }

    public void remove(Long categoryId) {
        categoryDao.remove(categoryId);
    }

    public void update(CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            return;
        }
        Category category = getEntityById(categoryDto.getId());
        if (StringUtils.isNotEmpty(categoryDto.getName())) {
            category.setName(categoryDto.getName());
        }
        categoryDao.update(category);
    }


    private Category getEntityById(Long id) {
        return categoryDao.get(id);
    }
}
