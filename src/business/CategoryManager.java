package business;

import core.logging.Logger;
import dataAccess.category.CategoryDao;
import entities.Category;
import java.util.List;

public class CategoryManager {
    private CategoryDao categoryDao;
    private List<Logger> loggers;
    private List<Category> categories;


    public CategoryManager(CategoryDao categoryDao,List<Logger> loggers,List<Category> categories) {
        this.categoryDao = categoryDao;
        this.loggers=loggers;
        this.categories=categories;


    }

    public void add(Category category) throws Exception {
        for (Category c : categories) {
            if (category.getName().equals(c.getName())) {
                throw new Exception("Aynı isimde kategori olamaz");
            }
        }
        categories.add(category);
        categoryDao.add(category);

        for (Logger logger: loggers) {
            logger.add(category.getName());

        }
    }
}
