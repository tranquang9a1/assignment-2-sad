package sad.teamone.service.impl;

import sad.teamone.common.annotation.Autowired;
import sad.teamone.dao.CategoryDAO;
import sad.teamone.entity.Category;
import sad.teamone.service.CategoryService;

/**
 * Created by QuangTV on 10/19/2014.
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category insert(Category category) {
        return (Category) categoryDAO.insert(category);
    }


    @Override
    public Category update(Category category) {
        return (Category) categoryDAO.update(category);
    }


    @Override
    public Category delete(Category category) {
        return (Category) categoryDAO.delete(category);
    }


    @Override
    public Category remove(int id) {
        return (Category) categoryDAO.delete(id);
    }

    @Override
    public Category find(int id) {
        return (Category) categoryDAO.find(id);
    }
}
