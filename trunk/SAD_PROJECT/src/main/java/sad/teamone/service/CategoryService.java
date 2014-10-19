package sad.teamone.service;

import sad.teamone.entity.Category;

/**
 * Created by QuangTV on 10/19/2014.
 */
public interface CategoryService {

    Category insert(Category category);
    Category update(Category category);
    Category delete(Category category);
    Category remove(int i);
    Category find(int id);
}
