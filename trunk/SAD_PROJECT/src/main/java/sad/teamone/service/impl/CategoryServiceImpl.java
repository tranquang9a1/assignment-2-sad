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
    public Boolean insert(Category category) {
        return categoryDAO.insert(category);
    }


    @Override
    public Boolean update(Category category) {
        return categoryDAO.update(category);
    }


    @Override
    public Boolean delete(Category category) {
        return categoryDAO.delete(category);
    }


    @Override
    public Boolean remove(int id) {
        return categoryDAO.delete(id);
    }

    @Override
    public Category find(int id) {
        return (Category) categoryDAO.find(id);
    }
}
